package dk.aau.cs.d703e20;

import dk.aau.cs.d703e20.ast.expressions.BoolExpressionNode;
import dk.aau.cs.d703e20.ast.statements.FunctionCallNode;
import dk.aau.cs.d703e20.ast.statements.VariableDeclarationNode;
import dk.aau.cs.d703e20.ast.structure.BlockNode;
import dk.aau.cs.d703e20.ast.structure.FunctionDeclarationNode;
import dk.aau.cs.d703e20.ast.structure.ProgramNode;
import dk.aau.cs.d703e20.errorhandling.*;
import dk.aau.cs.d703e20.parser.OurLexer;
import dk.aau.cs.d703e20.parser.OurParser;
import dk.aau.cs.d703e20.semantics.SemanticChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static dk.aau.cs.d703e20.resources.Utilities.getNodeFromText;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class semanticTest {
    private SemanticChecker semanticChecker;

    @BeforeEach
    void initSemanticChecker() {
        semanticChecker = new SemanticChecker();
    }

    @Test
    void testInvalidDeclarationType01() {
        VariableDeclarationNode variableDeclarationNode = getNodeFromText(
                "string four = 4;",
                VariableDeclarationNode.class,
                OurParser.VariableDeclContext.class,
                "variableDecl"
        );

        assertThrows(InconsistentTypeException.class,
                ()-> semanticChecker.visitVariableDeclaration(variableDeclarationNode)
        );
    }

    @Test
    void testInvalidDeclarationType02() {
        VariableDeclarationNode variableDeclarationNode = getNodeFromText(
                "int boolit = false;",
                VariableDeclarationNode.class,
                OurParser.VariableDeclContext.class,
                "variableDecl"
        );

        assertThrows(InconsistentTypeException.class,
                ()-> semanticChecker.visitVariableDeclaration(variableDeclarationNode)
        );
    }

    @Test
    void testArraySizeExceeded() {
        VariableDeclarationNode variableDeclarationNode = getNodeFromText(
                "int[3] a = {1, 2, 3, 4};",
                VariableDeclarationNode.class,
                OurParser.VariableDeclContext.class,
                "variableDecl"
        );

        assertThrows(InvalidArrayException.class,
                ()->  semanticChecker.visitVariableDeclaration(variableDeclarationNode));
    }

    @Test
    void testInconsistentArray() {
        VariableDeclarationNode variableDeclarationNode = getNodeFromText(
                "int[5] a = {1.1, 1.2, 1.3};",
                VariableDeclarationNode.class,
                OurParser.VariableDeclContext.class,
                "variableDecl"
        );

        assertThrows(InconsistentTypeException.class,
                ()-> semanticChecker.visitVariableDeclaration(variableDeclarationNode));
    }

    @Test
    void testBooleanArray() {
        VariableDeclarationNode variableDeclarationNode = getNodeFromText(
                "bool[3] a = {1, 2, 3};",
                VariableDeclarationNode.class,
                OurParser.VariableDeclContext.class,
                "variableDecl"
        );

        assertThrows(InconsistentTypeException.class,
                ()-> semanticChecker.visitVariableDeclaration(variableDeclarationNode));
    }

    @Test
    void testAlreadyDeclaredVariable() {
        BlockNode blockNode = getNodeFromText(
                "{int a = 0; int a = 1;}",
                BlockNode.class,
                OurParser.BlockContext.class,
                "block"
        );

        assertThrows(VariableAlreadyDeclaredException.class,
                ()-> semanticChecker.visitBlock(blockNode)
        );
    }

    @Test
    void testAlreadyDeclaredPinVariable() {
        BlockNode blockNode = getNodeFromText(
                "{ipin a A10; opin a A11;}",
                BlockNode.class,
                OurParser.BlockContext.class,
                "block"
        );

        assertThrows(VariableAlreadyDeclaredException.class,
                ()-> semanticChecker.visitBlock(blockNode)
        );
    }

    @Test
    void testUndeclaredVariable() {
        BlockNode blockNode = getNodeFromText(
                "{int a = b;}",
                BlockNode.class,
                OurParser.BlockContext.class,
                "block"
        );

        assertThrows(UndeclaredVariableException.class,
                ()-> semanticChecker.visitBlock(blockNode)
        );
    }

    @Test
    void testAlreadyDeclaredFunction() {
        ProgramNode programNode = getNodeFromText(
                "Setup{} Loop{} void UniqueFunctionName(){} double UniqueFunctionName(){}",
                ProgramNode.class,
                OurParser.ProgramContext.class,
                "program"
        );

        assertThrows(FunctionAlreadyDeclaredException.class,
                ()-> semanticChecker.visitProgram(programNode)
        );
    }

    @Test
    void testUndeclaredFunction() {
        FunctionCallNode functionCallNode = getNodeFromText(
                "undeclaredFunc()",
                FunctionCallNode.class,
                OurParser.FunctionCallContext.class,
                "functionCall"
        );

        assertThrows(UndeclaredFunctionException.class,
                ()-> semanticChecker.visitFunctionCall(functionCallNode)
        );
    }

    @Test
    void testIncorrectReturnType() {
        FunctionDeclarationNode functionDeclarationNode = getNodeFromText(
                "string textFunc(){int number = 1; return number;}",
                FunctionDeclarationNode.class,
                OurParser.FunctionDeclContext.class,
                "functionDecl"
        );

        assertThrows(IncorrectReturnTypeException.class,
                ()-> semanticChecker.visitFunctionDeclaration(functionDeclarationNode)
        );
    }


    @Test
    void testIllegalOperandInBoolExpr() {
        BoolExpressionNode boolExpressionNode = getNodeFromText(
                "true && 1337",
                BoolExpressionNode.class,
                OurParser.BoolExprContext.class,
                "boolExpr"
        );

        assertThrows(IllegalOperandException.class,
                ()-> semanticChecker.visitBooleanExpression(boolExpressionNode)
        );
    }
}
