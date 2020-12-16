package dk.aau.cs.d703e20;

import dk.aau.cs.d703e20.ast.expressions.BoolExpressionNode;
import dk.aau.cs.d703e20.ast.statements.FunctionCallNode;
import dk.aau.cs.d703e20.ast.statements.VariableDeclarationNode;
import dk.aau.cs.d703e20.ast.structure.*;
import dk.aau.cs.d703e20.errorhandling.*;
import dk.aau.cs.d703e20.parser.OurParser;
import dk.aau.cs.d703e20.semantics.SemanticChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static dk.aau.cs.d703e20.resources.Utilities.getNodeFromText;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class semanticTest {
    private SemanticChecker semanticChecker;

    @BeforeEach
    void initSemanticChecker() {
        semanticChecker = new SemanticChecker();
    }

    @Test
    void testIllegalStatement01(){
        SetupNode setup = getNodeFromText(
          "Setup {int a = 10; if (a > 10) {}}",
          SetupNode.class,
          OurParser.SetupContext.class,
         "setup"
        );

        assertThrows(IllegalSetupStatementException.class,
                ()-> semanticChecker.visitSetup(setup)
        );
    }

    @Test
    void testIllegalStatement02(){
        LoopNode loop = getNodeFromText(
                "Loop {ipin a 1; if (a > 10) {}}",
                LoopNode.class,
                OurParser.LoopContext.class,
                "loop"
        );

        assertThrows(IllegalLoopStatementException.class,
                ()-> semanticChecker.visitLoop(loop)
        );
    }

    @Test
    void testIllegalStatement03(){
        SetupNode setup = getNodeFromText(
                "Setup {int a = 10; ipin b 1; opin c 3;}",
                SetupNode.class,
                OurParser.SetupContext.class,
                "setup"
        );

        assertDoesNotThrow(
                ()-> semanticChecker.visitSetup(setup)
        );
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

    @Test
    void testIllegalAtStatement01() { //This also goes for boundStatement
        BlockNode blockNode = getNodeFromText(
                "{int a = 10; at(a == true) {}}",
                BlockNode.class,
                OurParser.BlockContext.class,
                "block"
        );
        assertThrows(IllegalAtExpressionException.class,
                ()-> semanticChecker.visitBlock(blockNode)
        );
    }

    @Test
    void testIllegalAtStatement02() {
        BlockNode blockNode = getNodeFromText(
                "{int a = 10; at(a && 2) {}}",
                BlockNode.class,
                OurParser.BlockContext.class,
                "block"
        );
        assertThrows(IllegalAtExpressionException.class,
                ()-> semanticChecker.visitBlock(blockNode)
        );
    }

    @Test
    void testIllegalBoundStatement01(){
        BlockNode blockNode = getNodeFromText(
                "{clock a = 10; bound(a > 2) {}}",
                BlockNode.class,
                OurParser.BlockContext.class,
                "block"
        );
        assertThrows(IllegalBoundStatementException.class,
                ()-> semanticChecker.visitBlock(blockNode)
        );
    }

    @Test
    void testIllegalBoundStatement02(){
        BlockNode blockNode = getNodeFromText(
                "{clock a; bound(a < 6) {}}",
                BlockNode.class,
                OurParser.BlockContext.class,
                "block"
        );
        assertDoesNotThrow(
                ()-> semanticChecker.visitBlock(blockNode)
        );
    }

    @Test
    void testForLoop() {
        BlockNode blockNode = getNodeFromText(
                "{clock x; int leet = 1337; bound (x < 20) { for (1 + 3 + 3 + 7 to 9 + 10 +2) {}}}",
                BlockNode.class,
                OurParser.BlockContext.class,
                "block"
        );
        assertDoesNotThrow(
                ()-> semanticChecker.visitBlock(blockNode)
        );
    }

    @Test
    void testWhileOutsideBound() {
        BlockNode blockNode = getNodeFromText(
                "{clock x; int leet = 1337; bound (x < 35) {} while (true) {}}",
                BlockNode.class,
                OurParser.BlockContext.class,
                "block"
        );
        assertThrows(IllegalIterativeStatementException.class, ()-> semanticChecker.visitBlock(blockNode));
    }

    @Test
    void testForOutsideBound() {
        BlockNode blockNode = getNodeFromText(
                "{int leet = 1337; for (1 + 3 + 3 + 7 to 9 + 10 +2) {}}",
                BlockNode.class,
                OurParser.BlockContext.class,
                "block"
        );
        assertThrows(IllegalIterativeStatementException.class, ()-> semanticChecker.visitBlock(blockNode));
    }

    @Test
    void testIfElseIf() {
        BlockNode blockNode = getNodeFromText(
                "{bool a = true; if(true) {} else if(a){}}",
                BlockNode.class,
                OurParser.BlockContext.class,
                "block"
        );
        assertDoesNotThrow(
                ()-> semanticChecker.visitBlock(blockNode)
        );
    }

    @Test
    void testWhileLoop01(){
        BlockNode blockNode = getNodeFromText(
                "{clock x; int leet = 1337; bound (x < leet) { while (leet == true) {}}}",
                BlockNode.class,
                OurParser.BlockContext.class,
                "block"
        );
        assertThrows(IllegalOperandException.class,
                ()-> semanticChecker.visitBlock(blockNode)
        );
    }

    @Test
    void testWhileLoop02(){
        BlockNode blockNode = getNodeFromText(
                "{clock x; int leet = 1337; bound (x < leet) { while (leet < x) {}}}",
                BlockNode.class,
                OurParser.BlockContext.class,
                "block"
        );
        assertDoesNotThrow(
                ()-> semanticChecker.visitBlock(blockNode)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"int a = 10", "double a = 10.0", "bool a = true"})
    void testIllegalAtTypes(String type) {
        BlockNode blockNode = getNodeFromText("{" + type + "; at(a > 20) {}}",
                BlockNode.class,
                OurParser.BlockContext.class,
                "block");
        assertThrows(IllegalAtExpressionException.class, ()-> semanticChecker.visitBlock(blockNode));
    }

    @Test
    void testIllegalAtTypesString() {
        BlockNode blockNode = getNodeFromText("{string a = \"\"; at(a > 20) {}}",
                BlockNode.class,
                OurParser.BlockContext.class,
                "block");
        assertThrows(InconsistentTypeException.class, ()-> semanticChecker.visitBlock(blockNode));
    }

    @Test
    void testIllegalAt() {
        BlockNode blockNode = getNodeFromText("{clock a = 0; at(a && 10) {}}",
                BlockNode.class,
                OurParser.BlockContext.class,
                "block");
        assertThrows(IllegalAtExpressionException.class, ()-> semanticChecker.visitBlock(blockNode));
    }

    @Test
    void testValidAt() {
        BlockNode blockNode = getNodeFromText("{clock a = 0; at(a > 20) {}}",
                BlockNode.class,
                OurParser.BlockContext.class,
                "block");
        assertDoesNotThrow(()-> semanticChecker.visitBlock(blockNode));
    }

    @Test
    void testValidAt02() {
        BlockNode blockNode = getNodeFromText("{clock a = 0; at((a > 20) && (a < 30)) {}}",
                BlockNode.class,
                OurParser.BlockContext.class,
                "block");
        assertDoesNotThrow(()-> semanticChecker.visitBlock(blockNode));
    }

    @Test
    void testValidAt03() {
        BlockNode blockNode = getNodeFromText("{clock a = 0; at((a == 20) && (a < 50)) {}}",
                BlockNode.class,
                OurParser.BlockContext.class,
                "block");
        assertDoesNotThrow(()-> semanticChecker.visitBlock(blockNode));
    }

    @Test
    void testScopeRule01(){
        ProgramNode programNode = getNodeFromText("Setup{clock x;} Loop{clock x;}",
                ProgramNode.class,
                OurParser.ProgramContext.class,
                "program");
        assertThrows(VariableAlreadyDeclaredException.class, ()-> semanticChecker.visitProgram(programNode));
    }
}
