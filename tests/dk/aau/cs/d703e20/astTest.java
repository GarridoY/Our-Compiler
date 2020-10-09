package dk.aau.cs.d703e20;

import dk.aau.cs.d703e20.ast.ASTBuilder;
import dk.aau.cs.d703e20.ast.expressions.*;
import dk.aau.cs.d703e20.ast.statements.*;
import dk.aau.cs.d703e20.ast.structure.*;
import dk.aau.cs.d703e20.parser.OurLexer;
import dk.aau.cs.d703e20.parser.OurParser;
import dk.aau.cs.d703e20.resources.FailTestErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ListTokenSource;
import org.antlr.v4.runtime.Token;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class astTest {

    // Turn string into list of lexer tokens
    private List<Token> getTokensFromText(String txt) {
        // Instantiate lexer from input text
        OurLexer lexer = new OurLexer(CharStreams.fromString(txt));
        // Add ANTLR errorListener to throw syntaxError exceptions, reports offending symbol and line
        lexer.addErrorListener(new FailTestErrorListener());
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        tokenStream.fill();
        return tokenStream.getTokens();
    }

    private OurParser createParser(List<Token> tokens) {
        ListTokenSource tokenSource = new ListTokenSource(tokens);
        CommonTokenStream cts = new CommonTokenStream(tokenSource);
        OurParser parser = new OurParser(cts);
        parser.addErrorListener(new FailTestErrorListener()); // Not expecting any syntax error, fails test if any
        return parser;
    }

    private  OurParser createParser(String txt) {
        List<Token> tokens = getTokensFromText(txt);
        return createParser(tokens);
    }

    // Test AST for conditional statement if
    @Test
    void testIF() {
        OurParser parser = createParser("if (hej == true) {}");
        OurParser.IfStatementContext ifStatement = parser.ifStatement();
        ASTBuilder astBuilder = new ASTBuilder();
        IfStatementNode ifStatementNode = (IfStatementNode) astBuilder.visitIfStatement(ifStatement);

        ConditionalExpressionNode conditionalExpressionNode = ifStatementNode.getConditionalExpressionNode();
        BoolExpressionNode boolExpressionNode = conditionalExpressionNode.getBoolExpressionNode();
        BlockNode blockNode = ifStatementNode.getBlockNode();

        assertAll(
                () -> assertNotNull(blockNode),
                () -> assertNotNull(boolExpressionNode),
                () -> assertNotNull(conditionalExpressionNode)
        );

    }

    // Test AST for conditional statement if else if
    @Test
    void testIFELSEIF() {
        OurParser parser = createParser("if (hej == true) {} else if (test) {} else {}");
        OurParser.IfElseStatementContext ifElseStatement = parser.ifElseStatement();
        ASTBuilder astBuilder = new ASTBuilder();
        IfElseStatementNode ifElseStatementNode = (IfElseStatementNode) astBuilder.visitIfElseStatement(ifElseStatement);

        IfStatementNode ifStatementNode = ifElseStatementNode.getIfStatementNode();
        List<ElseIfStatementNode> elseIfStatementNodes = ifElseStatementNode.getElseIfStatementNodes();
        ElseStatementNode elseStatementNode = ifElseStatementNode.getElseStatement();

        assertAll(
                () -> assertNotNull(ifStatementNode),
                () -> assertNotNull(elseIfStatementNodes),
                () -> assertNotNull(elseStatementNode)
        );

    }

    // Test AST for bool expression
    @Test
    void testBOOLEXPR() {
        OurParser parser = createParser("test1 == test2;");
        OurParser.BoolExprContext boolExpr = parser.boolExpr();
        ASTBuilder astBuilder = new ASTBuilder();
        BoolExpressionNode boolExpressionNode = (BoolExpressionNode) astBuilder.visitBoolExpr(boolExpr);

        ArithExpressionNode expressionNode1 = boolExpressionNode.getArithExpressionNode1();

        assertAll(
                () -> assertEquals(expressionNode1.getVariableName(), "test1")
        );

    }



}
