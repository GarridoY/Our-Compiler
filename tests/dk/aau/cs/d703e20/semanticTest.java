package dk.aau.cs.d703e20;

import dk.aau.cs.d703e20.ast.ASTBuilder;
import dk.aau.cs.d703e20.ast.errorhandling.*;
import dk.aau.cs.d703e20.ast.expressions.BoolExpressionNode;
import dk.aau.cs.d703e20.ast.statements.FunctionCallNode;
import dk.aau.cs.d703e20.ast.statements.PinDeclarationNode;
import dk.aau.cs.d703e20.ast.statements.StatementNode;
import dk.aau.cs.d703e20.ast.statements.VariableDeclarationNode;
import dk.aau.cs.d703e20.ast.structure.BlockNode;
import dk.aau.cs.d703e20.ast.structure.FunctionDeclarationNode;
import dk.aau.cs.d703e20.ast.structure.ProgramNode;
import dk.aau.cs.d703e20.parser.OurLexer;
import dk.aau.cs.d703e20.parser.OurParser;
import dk.aau.cs.d703e20.resources.FailTestErrorListener;
import dk.aau.cs.d703e20.semantics.SemanticChecker;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class semanticTest {
    private SemanticChecker semanticChecker;

    private OurParser createParserFromText(String txt) {
        // Instantiate lexer from input text
        OurLexer lexer = new OurLexer(CharStreams.fromString(txt));
        // Add ANTLR errorListener to throw syntaxError exceptions, reports offending symbol and line
        lexer.addErrorListener(new FailTestErrorListener());
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        // Instantiate parser from lexer tokens
        OurParser parser = new OurParser(tokenStream);
        parser.addErrorListener(new FailTestErrorListener()); // Not expecting any syntax error, fails test if any
        return parser;
    }

    private <T, S> T getNodeFromText(String text, String parseRuleName, Class<T> nodeClass, Class<S> contextClass) {
        // Parse text
        OurParser parser = createParserFromText(text);

        T node = null;
        try {
            // parser.parseRuleName()
            Method contextMethod = OurParser.class.getMethod(parseRuleName);

            // ASTBuilder.visitParseRuleName(contextClass)
            Method visitorMethod = ASTBuilder.class.getMethod(
                    "visit" + parseRuleName.toUpperCase().substring(0,1) + parseRuleName.substring(1),
                    contextClass);

            // Get OurParser.parseRuleNameContext from parser
            S context = (S) contextMethod.invoke(parser);

            // Get Node from visitorMethod in ASTBuilder using context
            node = nodeClass.cast(visitorMethod.invoke(new ASTBuilder(), context));
        }
        catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return node;
    }

    @BeforeEach
    void initSemanticChecker() {
        semanticChecker = new SemanticChecker();
    }

    @Test
    void testInvalidDeclarationType01() {
        VariableDeclarationNode variableDeclarationNode = getNodeFromText(
                "string four = 4;",
                "variableDecl",
                VariableDeclarationNode.class,
                OurParser.VariableDeclContext.class);

        assertThrows(InconsistentTypeException.class,
                ()-> semanticChecker.visitVariableDeclaration(variableDeclarationNode)
        );
    }

    @Test
    void testInvalidDeclarationType02() {
        VariableDeclarationNode variableDeclarationNode = getNodeFromText(
                "int boolit = false;",
                "variableDecl",
                VariableDeclarationNode.class,
                OurParser.VariableDeclContext.class);

        assertThrows(InconsistentTypeException.class,
                ()-> semanticChecker.visitVariableDeclaration(variableDeclarationNode)
        );
    }

    @Test
    void testArraySizeExceeded() {
        VariableDeclarationNode variableDeclarationNode = getNodeFromText(
                "int[3] a = {1, 2, 3, 4};",
                "variableDecl",
                VariableDeclarationNode.class,
                OurParser.VariableDeclContext.class);

        assertThrows(InvalidArrayException.class,
                ()->  semanticChecker.visitVariableDeclaration(variableDeclarationNode));
    }

    @Test
    void testInconsistentArray() {
        VariableDeclarationNode variableDeclarationNode = getNodeFromText(
                "int[5] a = {1.1, 1.2, 1.3};",
                "variableDecl",
                VariableDeclarationNode.class,
                OurParser.VariableDeclContext.class);

        assertThrows(InconsistentTypeException.class,
                ()-> semanticChecker.visitVariableDeclaration(variableDeclarationNode));
    }

    @Test
    void testBooleanArray() {
        VariableDeclarationNode variableDeclarationNode = getNodeFromText(
                "bool[3] a = {1, 2, 3};",
                "variableDecl",
                VariableDeclarationNode.class,
                OurParser.VariableDeclContext.class);

        assertThrows(InconsistentTypeException.class,
                ()-> semanticChecker.visitVariableDeclaration(variableDeclarationNode));
    }

    @Test
    void testAlreadyDeclaredVariable() {
        BlockNode blockNode = getNodeFromText(
                "{int a = 0; int a = 1;}",
                "block",
                BlockNode.class,
                OurParser.BlockContext.class);

        assertThrows(VariableAlreadyDeclaredException.class,
                ()-> semanticChecker.visitBlock(blockNode)
        );
    }

    @Test
    void testAlreadyDeclaredPinVariable() {
        BlockNode blockNode = getNodeFromText(
                "{ipin a A10; opin a A11;}",
                "block",
                BlockNode.class,
                OurParser.BlockContext.class);

        assertThrows(VariableAlreadyDeclaredException.class,
                ()-> semanticChecker.visitBlock(blockNode)
        );
    }

    @Test
    void testUndeclaredVariable() {
        BlockNode blockNode = getNodeFromText(
                "{int a = b;}",
                "block",
                BlockNode.class,
                OurParser.BlockContext.class);

        assertThrows(UndeclaredVariableException.class,
                ()-> semanticChecker.visitBlock(blockNode)
        );
    }

    @Test
    void testAlreadyDeclaredFunction() {
        ProgramNode programNode = getNodeFromText(
                "Setup{} Loop{} void UniqueFunctionName(){} double UniqueFunctionName(){}",
                "program",
                ProgramNode.class,
                OurParser.ProgramContext.class);

        assertThrows(FunctionAlreadyDeclaredException.class,
                ()-> semanticChecker.visitProgram(programNode)
        );
    }

    @Test
    void testUndeclaredFunction() {
        FunctionCallNode functionCallNode = getNodeFromText(
                "undeclaredFunc()",
                "functionCall",
                FunctionCallNode.class,
                OurParser.FunctionCallContext.class);

        assertThrows(UndeclaredFunctionException.class,
                ()-> semanticChecker.visitFunctionCall(functionCallNode)
        );
    }

    @Test
    void testIncorrectReturnType() {
        FunctionDeclarationNode functionDeclarationNode = getNodeFromText(
                "string textFunc(){int number = 1; return number;}",
                "functionDecl",
                FunctionDeclarationNode.class,
                OurParser.FunctionDeclContext.class);

        assertThrows(IncorrectReturnTypeException.class,
                ()-> semanticChecker.visitFunctionDeclaration(functionDeclarationNode)
        );
    }


    @Test
    void testIllegalOperandInBoolExpr() {
        BoolExpressionNode boolExpressionNode = getNodeFromText(
                "true && 1337",
                "boolExpr",
                BoolExpressionNode.class,
                OurParser.BoolExprContext.class);

        assertThrows(IllegalOperandException.class,
                ()-> semanticChecker.visitBooleanExpression(boolExpressionNode)
        );
    }
}
