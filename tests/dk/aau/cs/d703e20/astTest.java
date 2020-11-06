package dk.aau.cs.d703e20;

import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.expressions.*;
import dk.aau.cs.d703e20.ast.statements.*;
import dk.aau.cs.d703e20.ast.structure.*;
import dk.aau.cs.d703e20.parser.OurParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static dk.aau.cs.d703e20.resources.Utilities.getNodeFromText;
import static org.junit.jupiter.api.Assertions.*;

public class astTest {

    // Test AST for AssignmentNode
    @Test
    void testASSIGN() {
        AssignmentNode assignmentNode = getNodeFromText(
                "four = 4;",
                AssignmentNode.class,
                OurParser.AssignmentContext.class,
                "assignment"
        );

        assertAll(
                () -> assertEquals("four", assignmentNode.getVariableName()),
                () -> assertEquals("4", assignmentNode.getArithExpressionNode().getNumber())
        );
    }

    @Test
    void testVarDeclString() {
        VariableDeclarationNode variableDeclarationNode = getNodeFromText(
                "string varName = \"Super123\";",
                VariableDeclarationNode.class,
                OurParser.VariableDeclContext.class,
                "variableDecl"
        );

        assertAll(
                () -> assertEquals(Enums.DataType.STRING, variableDeclarationNode.getDataType()),
                () -> assertEquals("varName", variableDeclarationNode.getAssignmentNode().getVariableName()),
                () -> assertEquals("Super123", variableDeclarationNode.getAssignmentNode().getLiteralValue())
        );
    }

    @Test
    void testVarDeclEmpty() {
        VariableDeclarationNode variableDeclarationNode = getNodeFromText(
                "double[] arr",
                VariableDeclarationNode.class,
                OurParser.VariableDeclContext.class,
                "variableDecl"
        );

        assertAll(
                () -> assertEquals(Enums.DataType.DOUBLE_ARRAY, variableDeclarationNode.getDataType()),
                () -> assertEquals("arr", variableDeclarationNode.getVariableName())
        );

    }

    @Test
    void testVarDeclBool() {
        VariableDeclarationNode variableDeclarationNode = getNodeFromText(
                "bool varName = true;",
                VariableDeclarationNode.class,
                OurParser.VariableDeclContext.class,
                "variableDecl"
        );

        assertAll(
                () -> assertEquals(Enums.DataType.BOOL, variableDeclarationNode.getDataType()),
                () -> assertEquals("varName", variableDeclarationNode.getAssignmentNode().getVariableName()),
                () -> assertEquals("true", variableDeclarationNode.getAssignmentNode().getLiteralValue())
        );
    }

    @Test
    void testPinDeclDigital() {
        PinDeclarationNode pinDeclarationNode = getNodeFromText(
                "ipin digiPin 12;",
                PinDeclarationNode.class,
                OurParser.PinDeclContext.class,
                "pinDecl"
        );

        assertAll(
                () -> assertEquals(Enums.PinType.IPIN, pinDeclarationNode.getPinType()),
                () -> assertEquals("digiPin", pinDeclarationNode.getVariableName()),
                () -> assertEquals("12", pinDeclarationNode.getPinNumber())
        );
    }

    @Test
    void testPinDeclAnalog() {
        PinDeclarationNode pinDeclarationNode = getNodeFromText(
                "opin anaPin A5;",
                PinDeclarationNode.class,
                OurParser.PinDeclContext.class,
                "pinDecl"
        );

        assertAll(
                () -> assertEquals(Enums.PinType.OPIN, pinDeclarationNode.getPinType()),
                () -> assertEquals("anaPin", pinDeclarationNode.getVariableName()),
                () -> assertEquals("A5", pinDeclarationNode.getPinNumber())
        );
    }

    @Test
    void testVarDeclFunctionCall() {
        VariableDeclarationNode variableDeclarationNode = getNodeFromText(
                "int varName = getInt();",
                VariableDeclarationNode.class,
                OurParser.VariableDeclContext.class,
                "variableDecl"
        );

        assertAll(
                () -> assertEquals(Enums.DataType.INT, variableDeclarationNode.getDataType()),
                () -> assertEquals("varName", variableDeclarationNode.getAssignmentNode().getVariableName()),
                () -> assertEquals(
                        "getInt",
                        variableDeclarationNode
                                .getAssignmentNode()
                                .getArithExpressionNode()
                                .getFunctionCallNode()
                                .getFunctionName())
        );
    }

    //Test AST for AtStatement
    @Test
    void testATStatement() {
        AtStatementNode atStatementNode = getNodeFromText(
                "at (x == 1) {}",
                AtStatementNode.class,
                OurParser.AtStatementContext.class,
                "atStatement"
        );

        assertEquals(
                "x",
                atStatementNode
                        .getAtParamsNode()
                        .getBoolExpressionNode()
                        .getBoolExprOperandNodes().get(0)
                        .getArithExpressionNode()
                        .getVariableName());
    }

    //Test AST for AtStatement with &&
    @Test
    void testATStatementWithAND() {
        AtStatementNode atStatementNode = getNodeFromText(
                "at (x == 1 && y == true) {}",
                AtStatementNode.class,
                OurParser.AtStatementContext.class,
                "atStatement"
        );

        assertEquals(
                "y",
                atStatementNode
                        .getAtParamsNode()
                        .getBoolExpressionNode()
                        .getBoolExprOperandNodes().get(2)
                        .getArithExpressionNode()
                        .getVariableName());
        assertEquals(
                Enums.BoolOperator.AND,
                atStatementNode
                        .getAtParamsNode()
                        .getBoolExpressionNode()
                        .getBoolExpressionOperators().get(1));
    }

    @Test
    void testBoundStatement() {
        BoundStatementNode boundNode = getNodeFromText(
                "bound (y < 12, true) {} final {}",
                BoundStatementNode.class,
                OurParser.BoundStatementContext.class,
                "boundStatement"
        );

        assertAll(
                () -> assertEquals(
                        "y",
                        boundNode
                                .getAtParamsNode()
                                .getBoolExpressionNode()
                                .getBoolExprOperandNodes().get(0)
                                .getArithExpressionNode()
                                .getVariableName()),

                () -> assertEquals(
                        Enums.BoolOperator.LESS_THAN,
                        boundNode
                                .getAtParamsNode()
                                .getBoolExpressionNode()
                                .getBoolExpressionOperators().get(0)),

                () -> assertEquals(
                        "12",
                        boundNode
                                .getAtParamsNode()
                                .getBoolExpressionNode()
                                .getBoolExprOperandNodes().get(1)
                                .getArithExpressionNode()
                                .getNumber()),

                () -> assertEquals("true", boundNode.getBoolLiteral()),
                () -> assertNotNull(boundNode.getBody()),
                () -> assertNotNull(boundNode.getFinalBlock())
        );
    }

    @Test
    void testBoundStatementArgBlock() {
        BoundStatementNode boundNode = getNodeFromText(
                "bound (y == 22) {}",
                BoundStatementNode.class,
                OurParser.BoundStatementContext.class,
                "boundStatement"
        );

        assertAll(
                () -> assertEquals(
                        "y",
                        boundNode
                                .getAtParamsNode()
                                .getBoolExpressionNode()
                                .getBoolExprOperandNodes().get(0)
                                .getArithExpressionNode()
                                .getVariableName()),

                () -> assertEquals(
                        Enums.BoolOperator.EQUAL,
                        boundNode
                                .getAtParamsNode()
                                .getBoolExpressionNode()
                                .getBoolExpressionOperators().get(0)),

                () -> assertEquals(
                        "22",
                        boundNode
                                .getAtParamsNode()
                                .getBoolExpressionNode()
                                .getBoolExprOperandNodes().get(1)
                                .getArithExpressionNode()
                                .getNumber()),

                () -> assertNotNull(boundNode.getBody())
        );
    }

    @Test
    void testBoundStatementAllArgs() {
        BoundStatementNode boundNode = getNodeFromText(
                "bound (y <= 0, false) {} catch {} final {}",
                BoundStatementNode.class,
                OurParser.BoundStatementContext.class,
                "boundStatement"
        );

        assertAll(
                () -> assertEquals(
                        "y",
                        boundNode
                                .getAtParamsNode()
                                .getBoolExpressionNode()
                                .getBoolExprOperandNodes().get(0)
                                .getArithExpressionNode()
                                .getVariableName()),

                () -> assertEquals(
                        Enums.BoolOperator.LESS_OR_EQUAL,
                        boundNode
                                .getAtParamsNode()
                                .getBoolExpressionNode()
                                .getBoolExpressionOperators().get(0)),

                () -> assertEquals(
                        "0",
                        boundNode
                                .getAtParamsNode()
                                .getBoolExpressionNode()
                                .getBoolExprOperandNodes().get(1)
                                .getArithExpressionNode()
                                .getNumber()),

                () -> assertEquals("false", boundNode.getBoolLiteral()),
                () -> assertNotNull(boundNode.getBody()),
                () -> assertNotNull(boundNode.getCatchBlock()),
                () -> assertNotNull(boundNode.getFinalBlock())
        );
    }

    // Test AST for conditional statement if
    @Test
    void testIF() {
        IfStatementNode ifStatementNode = getNodeFromText(
                "if (hej == true) {}",
                IfStatementNode.class,
                OurParser.IfStatementContext.class,
                "ifStatement"
        );

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
        IfElseStatementNode ifElseStatementNode = getNodeFromText(
                "if (hej == true) {} else if (test) {} else {}",
                IfElseStatementNode.class,
                OurParser.IfElseStatementContext.class,
                "ifElseStatement"
        );

        IfStatementNode ifStatementNode = ifElseStatementNode.getIfStatementNode();
        List<ElseIfStatementNode> elseIfStatementNodes = ifElseStatementNode.getElseIfStatementNodes();
        ElseStatementNode elseStatementNode = ifElseStatementNode.getElseStatement();

        assertAll(
                () -> assertNotNull(ifStatementNode),
                () -> assertNotNull(elseIfStatementNodes),
                () -> assertNotNull(elseStatementNode)
        );

    }

    // Test AST for bool expression | arith op arith
    @Test
    void testBOOLEXPR() {
        BoolExpressionNode boolExpressionNode = getNodeFromText(
                "test1 == test2",
                BoolExpressionNode.class,
                OurParser.BoolExprContext.class,
                "boolExpr"
        );

        ArithExpressionNode expressionNode1 =
                boolExpressionNode.getBoolExprOperandNodes().get(0).getArithExpressionNode();

        ArithExpressionNode expressionNode2 =
                boolExpressionNode.getBoolExprOperandNodes().get(1).getArithExpressionNode();

        Enums.BoolOperator operator = boolExpressionNode.getBoolExpressionOperators().get(0);

        assertAll(
                () -> assertEquals("test1", expressionNode1.getVariableName()),
                () -> assertEquals("test2", expressionNode2.getVariableName()),
                () -> assertEquals(Enums.BoolOperator.EQUAL, operator)
        );
    }

    @Test
    void TestBOOLEXPR1() {
        BoolExpressionNode boolExpressionNode = getNodeFromText(
                "test != false",
                BoolExpressionNode.class,
                OurParser.BoolExprContext.class,
                "boolExpr"
        );

        ArithExpressionNode expressionNode =
                boolExpressionNode.getBoolExprOperandNodes().get(0).getArithExpressionNode();

        Enums.BoolOperator operator = boolExpressionNode.getBoolExpressionOperators().get(0);

        assertAll(
                () -> assertEquals("test", expressionNode.getVariableName()),

                () -> assertEquals(
                        "false",
                        boolExpressionNode
                                .getBoolExprOperandNodes().get(1)
                                .getBoolLiteral()),

                () -> assertEquals(Enums.BoolOperator.NOT_EQUAL, operator)
        );
    }

    @Test
    void TestBOOLEXPR2() {
        BoolExpressionNode boolExpressionNode = getNodeFromText(
                "test >= 5",
                BoolExpressionNode.class,
                OurParser.BoolExprContext.class,
                "boolExpr"
        );

        ArithExpressionNode expressionNode1 =
                boolExpressionNode.getBoolExprOperandNodes().get(0).getArithExpressionNode();

        ArithExpressionNode expressionNode2 =
                boolExpressionNode.getBoolExprOperandNodes().get(1).getArithExpressionNode();

        Enums.BoolOperator operator = boolExpressionNode.getBoolExpressionOperators().get(0);
        assertAll(
                () -> assertEquals("test", expressionNode1.getVariableName()),
                () -> assertEquals("5", expressionNode2.getNumber()),
                () -> assertEquals(Enums.BoolOperator.GREATER_OR_EQUAL, operator)
        );
    }

    @Test
    void TestSUBSCRIPT() {
        ConditionalExpressionNode conditionalExpressionNode = getNodeFromText(
                "array[23]",
                ConditionalExpressionNode.class,
                OurParser.ConditionalExpressionContext.class,
                "conditionalExpression"
        );

        assertAll(
                () -> assertEquals("array", conditionalExpressionNode.getSubscriptNode().getVariableName()),
                () -> assertEquals(23, conditionalExpressionNode.getSubscriptNode().getIndex())
        );
    }

    @Test
    void testBoolExprLiteral() {
        BoolExpressionNode boolExpressionNode = getNodeFromText(
                "true",
                BoolExpressionNode.class,
                OurParser.BoolExprContext.class,
                "boolExpr"
        );

        assertEquals("true", boolExpressionNode.getBoolLiteral());
    }

    @Test
    void testBoolExprNotLiteral() {
        BoolExpressionNode boolExpressionNode = getNodeFromText(
                "!(true)",
                BoolExpressionNode.class,
                OurParser.BoolExprContext.class,
                "boolExpr"
        );

        assertAll(
                () -> assertEquals("true", boolExpressionNode.getBoolExpressionNode().getBoolLiteral()),
                () -> assertEquals(true, boolExpressionNode.getOptionalNot())
        );
    }

    // Test arithExpr arithOp arithExpr
    @Test
    void testArithExpr1() {
        ArithExpressionNode arithExpressionNode = getNodeFromText(
                "var + 2",
                ArithExpressionNode.class,
                OurParser.ArithExprContext.class,
                "arithExpr"
        );

        String varName = arithExpressionNode.getArithExpressionNode1().getVariableName();
        Enums.ArithOperator operator = arithExpressionNode.getArithExpressionOperator();
        String literal = arithExpressionNode.getArithExpressionNode2().getNumber();

        assertAll(
                () -> assertEquals("var", varName),
                () -> assertEquals(Enums.ArithOperator.ADD, operator),
                () -> assertEquals("2", literal)
        );
    }

    // Test NOT?(arithExpr), arithExpr is functionCall
    @Test
    void testArithExprNotFunc() {
        ArithExpressionNode arithExpressionNode = getNodeFromText(
                "!(FuncName())",
                ArithExpressionNode.class,
                OurParser.ArithExprContext.class,
                "arithExpr"
        );

        assertAll(
                () -> assertEquals(
                        "FuncName",
                        arithExpressionNode
                                .getArithExpressionNode1()
                                .getFunctionCallNode()
                                .getFunctionName()),

                () -> assertEquals(true, arithExpressionNode.getOptionalNot())
        );
    }

    // Test SUBSCRIPT arithExpr
    @Test
    void testArithExprSUBSCRIPT() {
        ArithExpressionNode arithExpressionNode = getNodeFromText(
                "arr[2]",
                ArithExpressionNode.class,
                OurParser.ArithExprContext.class,
                "arithExpr"
        );

        assertAll(
                () -> assertEquals("arr", arithExpressionNode.getSubscriptNode().getVariableName()),
                () -> assertEquals(2, arithExpressionNode.getSubscriptNode().getIndex())
        );
    }

    // Test visitprogram
    @Test
    void testVisitProgram() {
        ProgramNode programNode = getNodeFromText(
                "Setup{} Loop{}",
                ProgramNode.class,
                OurParser.ProgramContext.class,
                "program"
        );

        assertAll(
                () -> assertNotNull(programNode.getSetupNode()),
                () -> assertNotNull(programNode.getLoopNode())
        );
    }

    @Test
    void testForLoop() {
        ForStatementNode forStatementNode = getNodeFromText(
                "for (var to 5) {}",
                ForStatementNode.class,
                OurParser.ForStatementContext.class,
                "forStatement"
        );

        assertAll(
                () -> assertEquals("var", forStatementNode.getArithExpressionNode1().getVariableName()),
                () -> assertEquals("5", forStatementNode.getArithExpressionNode2().getNumber())
        );
    }

    @Test
    void testFunctionCallArgs() {
        ArithExpressionNode arithExpressionNode = getNodeFromText(
                "function(2, varName)",
                ArithExpressionNode.class,
                OurParser.ArithExprContext.class,
                "arithExpr"
        );

        FunctionCallNode functionCallNode = arithExpressionNode.getFunctionCallNode();

        assertAll(
                () -> assertEquals(
                        "function",
                        functionCallNode
                                .getFunctionName()),

                () -> assertEquals(
                        "2",
                        functionCallNode
                                .getFunctionArgNodes().get(0)
                                .getArithExpressionNode()
                                .getNumber()),

                () -> assertEquals(
                        "varName",
                        functionCallNode
                                .getFunctionArgNodes().get(1)
                                .getArithExpressionNode()
                                .getVariableName())
        );
    }

    // Test void functionDecl
    @Test
    void testFunctionDecl() {
        FunctionDeclarationNode functionDeclarationNode = getNodeFromText(
                "void test(int ID2, string varName){}",
                FunctionDeclarationNode.class,
                OurParser.FunctionDeclContext.class,
                "functionDecl"
        );

        assertAll(
                () -> assertNotNull(functionDeclarationNode.getBlockNode()),
                () -> assertEquals(Enums.DataType.VOID, functionDeclarationNode.getDataType()),
                () -> assertNotNull(functionDeclarationNode.getFunctionName())
        );
    }

    //Test FunctionDecl with get.Datatype
    @Test
    void testFunctionDeclDatatype() {
        FunctionDeclarationNode functionDeclarationNode = getNodeFromText(
                "bool test(int ID2, string varName){}",
                FunctionDeclarationNode.class,
                OurParser.FunctionDeclContext.class,
                "functionDecl"
        );

        assertEquals(Enums.DataType.BOOL, functionDeclarationNode.getDataType());
    }

    @Test
    void testVisitReturnStatement() {
        ReturnStatementNode returnStatementNode = getNodeFromText(
                "return varName;",
                ReturnStatementNode.class,
                OurParser.StatementContext.class,
                "statement"
        );

        assertEquals("varName", returnStatementNode.getVariableName());
    }

    @Test
    void testVisitFunctionParam() {
        FunctionDeclarationNode functionDeclarationNode = getNodeFromText(
                "bool test(int ID2, string varName){}",
                FunctionDeclarationNode.class,
                OurParser.FunctionDeclContext.class,
                "functionDecl"
        );

        List<FunctionParameterNode> functionParameterNodes = functionDeclarationNode.getFunctionParameterNodes();

        assertAll(
                () -> assertEquals(Enums.DataType.INT, functionParameterNodes.get(0).getDataType()),
                () -> assertEquals(Enums.DataType.STRING, functionParameterNodes.get(1).getDataType()),
                () -> assertEquals("ID2", functionParameterNodes.get(0).getVariableName()),
                () -> assertEquals("varName", functionParameterNodes.get(1).getVariableName())
        );
    }

    @Test
    void testWhileStatement() {
        WhileStatementNode whileStatementNode = getNodeFromText(
                "while (true) {}",
                WhileStatementNode.class,
                OurParser.WhileStatementContext.class,
                "whileStatement"
        );

        assertEquals("true", whileStatementNode.getBoolExpressionNode().getBoolLiteral());
    }

    @Test
    void testAssignArray() {
        AssignArrayNode assignArrayNode = getNodeFromText(
                "arr = {1.2, 3.3}",
                AssignArrayNode.class,
                OurParser.AssignArrayContext.class,
                "assignArray"
        );

        assertAll(
                () -> assertEquals("arr", assignArrayNode.getVariableName()),

                () -> assertEquals(
                        "1.2",
                        assignArrayNode
                                .getParamNodes().get(0)
                                .getArithExpressionNode()
                                .getNumber()),

                () -> assertEquals(
                        "3.3",
                        assignArrayNode
                                .getParamNodes().get(1)
                                .getArithExpressionNode()
                                .getNumber())
        );
    }

    @Test
    void testVariableDeclArrayDatatype() {
        VariableDeclarationNode variableDeclarationNode = getNodeFromText(
                "int[5] arr;",
                VariableDeclarationNode.class,
                OurParser.VariableDeclContext.class,
                "variableDecl"
        );

        assertEquals(Enums.DataType.INT_ARRAY, variableDeclarationNode.getDataType());
    }

    @Test
    void testBooleanVariableDeclArray() {
        VariableDeclarationNode variableDeclarationNode = getNodeFromText(
                "bool[] arr = {true, false};",
                VariableDeclarationNode.class,
                OurParser.VariableDeclContext.class,
                "variableDecl"
        );

        assertEquals(
                "false",
                variableDeclarationNode
                        .getAssignArrayNode()
                        .getParamNodes().get(1)
                        .getLiteral());
    }

    @Test
    void testVariableDeclArrayIndex() {
        VariableDeclarationNode variableDeclarationNode = getNodeFromText(
                "int[] arr = {1, 4, 35};",
                VariableDeclarationNode.class,
                OurParser.VariableDeclContext.class,
                "variableDecl"
        );

        assertEquals(
                "35",
                variableDeclarationNode
                        .getAssignArrayNode()
                        .getParamNodes().get(2)
                        .getArithExpressionNode()
                        .getNumber());
    }
}
