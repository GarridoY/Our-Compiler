package dk.aau.cs.d703e20;

import dk.aau.cs.d703e20.ast.ASTBuilder;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.expressions.*;
import dk.aau.cs.d703e20.ast.statements.*;
import dk.aau.cs.d703e20.ast.structure.*;
import dk.aau.cs.d703e20.parser.OurLexer;
import dk.aau.cs.d703e20.parser.OurParser;
import dk.aau.cs.d703e20.resources.FailTestErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class astTest {

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

    // Test AST for AssignmentNode
    @Test
    void testASSIGN() {
        OurParser parser = createParserFromText("four = 4;");
        OurParser.AssignmentContext assignment = parser.assignment();
        ASTBuilder astBuilder = new ASTBuilder();

        AssignmentNode assignmentNode = (AssignmentNode) astBuilder.visitAssignment(assignment);

        assertAll(
                () -> assertEquals("four", assignmentNode.getVariableName()),
                () -> assertEquals(4, assignmentNode.getArithExpressionNode().getNumber())
        );
    }

    @Test
    void testVarDeclString() {
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("string varName = \"Super123\";");
        // Get parsed context
        OurParser.VariableDeclContext variableDecl = parser.variableDecl();
        // Context -> ASTNode
        ASTBuilder astBuilder = new ASTBuilder();
        VariableDeclarationNode varDeclNode = (VariableDeclarationNode) astBuilder.visitVariableDecl(variableDecl);

        assertAll(
                () -> assertEquals(Enums.DataType.STRING, varDeclNode.getDataType()),
                () -> assertEquals("varName", varDeclNode.getAssignmentNode().getVariableName()),
                () -> assertEquals("Super123", varDeclNode.getAssignmentNode().getLiteralValue())
        );
    }

    @Test
    void testVarDeclEmpty() {
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("double[] arr");
        // Get parsed context
        OurParser.VariableDeclContext variableDeclContext = parser.variableDecl();
        // Context -> ASTNode
        ASTBuilder astBuilder = new ASTBuilder();
        VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode) astBuilder.visitVariableDecl(variableDeclContext);

        assertAll(
                () -> assertEquals(Enums.DataType.DOUBLE_ARRAY, variableDeclarationNode.getDataType()),
                () -> assertEquals("arr", variableDeclarationNode.getVariableName())
        );

    }

    @Test
    void testVarDeclBool() {
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("bool varName = true;");
        // Get parsed context
        OurParser.VariableDeclContext variableDecl = parser.variableDecl();
        // Context -> ASTNode
        ASTBuilder astBuilder = new ASTBuilder();
        VariableDeclarationNode varDeclNode = (VariableDeclarationNode) astBuilder.visitVariableDecl(variableDecl);

        assertAll(
                () -> assertEquals(Enums.DataType.BOOL, varDeclNode.getDataType()),
                () -> assertEquals("varName", varDeclNode.getAssignmentNode().getVariableName()),
                () -> assertEquals("true", varDeclNode.getAssignmentNode().getLiteralValue())
        );
    }

    @Test
    void testPinDeclDigital() {
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("ipin digiPin 12;");
        // Get parsed context
        OurParser.PinDeclContext pinDecl = parser.pinDecl();
        // Context -> ASTNode
        ASTBuilder astBuilder = new ASTBuilder();
        PinDeclarationNode pinDeclNode = (PinDeclarationNode) astBuilder.visitPinDecl(pinDecl);

        assertAll(
                () -> assertEquals(Enums.PinType.IPIN, pinDeclNode.getPinType()),
                () -> assertEquals("digiPin", pinDeclNode.getVariableName()),
                () -> assertEquals("12", pinDeclNode.getPinNumber())
        );
    }

    @Test
    void testPinDeclAnalog() {
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("opin anaPin A5;");
        // Get parsed context
        OurParser.PinDeclContext pinDecl = parser.pinDecl();
        // Context -> ASTNode
        ASTBuilder astBuilder = new ASTBuilder();
        PinDeclarationNode pinDeclNode = (PinDeclarationNode) astBuilder.visitPinDecl(pinDecl);

        assertAll(
                () -> assertEquals(Enums.PinType.OPIN, pinDeclNode.getPinType()),
                () -> assertEquals("anaPin", pinDeclNode.getVariableName()),
                () -> assertEquals("A5", pinDeclNode.getPinNumber())
        );
    }

    @Test
    void testVarDeclFunctionCall() {
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("int varName = getInt();");
        // Get parsed context
        OurParser.VariableDeclContext variableDecl = parser.variableDecl();
        // Context -> ASTNode
        ASTBuilder astBuilder = new ASTBuilder();
        VariableDeclarationNode varDeclNode = (VariableDeclarationNode) astBuilder.visitVariableDecl(variableDecl);

        assertAll(
                () -> assertEquals(Enums.DataType.INT, varDeclNode.getDataType()),
                () -> assertEquals("varName", varDeclNode.getAssignmentNode().getVariableName()),
                () -> assertEquals("getInt", varDeclNode.getAssignmentNode().getArithExpressionNode().getFunctionCallNode().getFunctionName())
        );
    }

    //Test AST for AtStatement
    @Test
    void testATStatement() {
        OurParser parser = createParserFromText("at (x == 1) {}");
        OurParser.AtStatementContext at = parser.atStatement();
        ASTBuilder astBuilder = new ASTBuilder();

        AtStatementNode atStatementNode = (AtStatementNode) astBuilder.visitAtStatement(at);

        assertEquals("x", atStatementNode.getAtParamsNode().getBoolExpressionNode().getBoolExprOperandNodes().get(0).getArithExpressionNode().getVariableName());
    }

    //Test AST for AtStatement with &&
    @Test
    void testATStatementWithAND() {
        OurParser parser = createParserFromText("at (x == 1 && y == true) {}");
        OurParser.AtStatementContext at = parser.atStatement();
        ASTBuilder astBuilder = new ASTBuilder();

        AtStatementNode atStatementNode = (AtStatementNode) astBuilder.visitAtStatement(at);

        assertEquals("y", atStatementNode.getAtParamsNode().getBoolExpressionNode().getBoolExprOperandNodes().get(2).getArithExpressionNode().getVariableName());
        assertEquals(Enums.BoolOperator.AND, atStatementNode.getAtParamsNode().getBoolExpressionNode().getBoolExpressionOperators().get(1));
    }

    @Test
    void testBoundStatement() {
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("bound (y < 12, true) {} final {}");
        // Get parsed context
        OurParser.BoundStatementContext boundCtx = parser.boundStatement();
        // Context -> ASTNode
        ASTBuilder astBuilder = new ASTBuilder();
        BoundStatementNode boundNode = (BoundStatementNode) astBuilder.visitBoundStatement(boundCtx);

        assertAll(
                () -> assertEquals("y", boundNode.getAtParamsNode().getBoolExpressionNode().getBoolExprOperandNodes().get(0).getArithExpressionNode().getVariableName()),
                () -> assertEquals(Enums.BoolOperator.LESS_THAN, boundNode.getAtParamsNode().getBoolExpressionNode().getBoolExpressionOperators().get(0)),
                () -> assertEquals(12, boundNode.getAtParamsNode().getBoolExpressionNode().getBoolExprOperandNodes().get(1).getArithExpressionNode().getNumber()),
                () -> assertEquals("true", boundNode.getBoolLiteral()),
                () -> assertNotNull(boundNode.getBody()),
                () -> assertNotNull(boundNode.getFinalBlock())
        );
    }

    @Test
    void testBoundStatementArgBlock() {
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("bound (y == 22) {}");
        // Get parsed context
        OurParser.BoundStatementContext boundCtx = parser.boundStatement();
        // Context -> ASTNode
        ASTBuilder astBuilder = new ASTBuilder();
        BoundStatementNode boundNode = (BoundStatementNode) astBuilder.visitBoundStatement(boundCtx);

        assertAll(
                () -> assertEquals("y", boundNode.getAtParamsNode().getBoolExpressionNode().getBoolExprOperandNodes().get(0).getArithExpressionNode().getVariableName()),
                () -> assertEquals(Enums.BoolOperator.EQUAL, boundNode.getAtParamsNode().getBoolExpressionNode().getBoolExpressionOperators().get(0)),
                () -> assertEquals(22, boundNode.getAtParamsNode().getBoolExpressionNode().getBoolExprOperandNodes().get(1).getArithExpressionNode().getNumber()),
                () -> assertNotNull(boundNode.getBody())
        );
    }

    @Test
    void testBoundStatementAllArgs() {
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("bound (y <= 0, false) {} catch {} final {}");
        // Get parsed context
        OurParser.BoundStatementContext boundCtx = parser.boundStatement();
        // Context -> ASTNode
        ASTBuilder astBuilder = new ASTBuilder();
        BoundStatementNode boundNode = (BoundStatementNode) astBuilder.visitBoundStatement(boundCtx);

        assertAll(
                () -> assertEquals("y", boundNode.getAtParamsNode().getBoolExpressionNode().getBoolExprOperandNodes().get(0).getArithExpressionNode().getVariableName()),
                () -> assertEquals(Enums.BoolOperator.LESS_OR_EQUAL, boundNode.getAtParamsNode().getBoolExpressionNode().getBoolExpressionOperators().get(0)),
                () -> assertEquals(0, boundNode.getAtParamsNode().getBoolExpressionNode().getBoolExprOperandNodes().get(1).getArithExpressionNode().getNumber()),
                () -> assertEquals("false", boundNode.getBoolLiteral()),
                () -> assertNotNull(boundNode.getBody()),
                () -> assertNotNull(boundNode.getCatchBlock()),
                () -> assertNotNull(boundNode.getFinalBlock())
        );
    }

    // Test AST for conditional statement if
    @Test
    void testIF() {
        OurParser parser = createParserFromText("if (hej == true) {}");
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
        OurParser parser = createParserFromText("if (hej == true) {} else if (test) {} else {}");
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

    // Test AST for bool expression | arith op arith
    @Test
    void testBOOLEXPR() {
        OurParser parser = createParserFromText("test1 == test2");
        OurParser.BoolExprContext boolExpr = parser.boolExpr();
        ASTBuilder astBuilder = new ASTBuilder();
        BoolExpressionNode boolExpressionNode = (BoolExpressionNode) astBuilder.visitBoolExpr(boolExpr);

        ArithExpressionNode expressionNode1 = boolExpressionNode.getBoolExprOperandNodes().get(0).getArithExpressionNode();
        ArithExpressionNode expressionNode2 = boolExpressionNode.getBoolExprOperandNodes().get(1).getArithExpressionNode();
        Enums.BoolOperator operator = boolExpressionNode.getBoolExpressionOperators().get(0);


        assertAll(
                () -> assertEquals("test1", expressionNode1.getVariableName()),
                () -> assertEquals("test2", expressionNode2.getVariableName()),
                () -> assertEquals(Enums.BoolOperator.EQUAL, operator)
        );
    }

    @Test
    void TestBOOLEXPR1() {
        OurParser parser = createParserFromText("test != false");
        OurParser.BoolExprContext boolExpr = parser.boolExpr();
        ASTBuilder astBuilder = new ASTBuilder();
        BoolExpressionNode boolExpressionNode = (BoolExpressionNode) astBuilder.visitBoolExpr(boolExpr);

        ArithExpressionNode expressionNode = boolExpressionNode.getBoolExprOperandNodes().get(0).getArithExpressionNode();
        Enums.BoolOperator operator = boolExpressionNode.getBoolExpressionOperators().get(0);
        assertAll(
                () -> assertEquals("test", expressionNode.getVariableName()),
                () -> assertEquals("false", boolExpressionNode.getBoolExprOperandNodes().get(1).getBoolLiteral()),
                () -> assertEquals(Enums.BoolOperator.NOT_EQUAL, operator)
        );
    }

    @Test
    void TestBOOLEXPR2() {
        OurParser parser = createParserFromText("test >= 5");
        OurParser.BoolExprContext boolExpr = parser.boolExpr();
        ASTBuilder astBuilder = new ASTBuilder();
        BoolExpressionNode boolExpressionNode = (BoolExpressionNode) astBuilder.visitBoolExpr(boolExpr);

        ArithExpressionNode expressionNode1 = boolExpressionNode.getBoolExprOperandNodes().get(0).getArithExpressionNode();
        ArithExpressionNode expressionNode2 = boolExpressionNode.getBoolExprOperandNodes().get(1).getArithExpressionNode();
        Enums.BoolOperator operator = boolExpressionNode.getBoolExpressionOperators().get(0);
        assertAll(
                () -> assertEquals("test", expressionNode1.getVariableName()),
                () -> assertEquals(5, expressionNode2.getNumber()),
                () -> assertEquals(Enums.BoolOperator.GREATER_OR_EQUAL, operator)
        );
    }

    @Test
    void TestSUBSCRIPT() {
        OurParser parser = createParserFromText("array[23]");
        OurParser.ConditionalExpressionContext conditionalExpression = parser.conditionalExpression();
        ASTBuilder astBuilder = new ASTBuilder();
        ConditionalExpressionNode conditionalExpressionNode = (ConditionalExpressionNode) astBuilder.visitConditionalExpression(conditionalExpression);

        assertAll(
                () -> assertEquals("array", conditionalExpressionNode.getSubscriptNode().getVariableName()),
                () -> assertEquals(23, conditionalExpressionNode.getSubscriptNode().getIndex())
        );
    }

    @Test
    void testBoolExprLiteral() {
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("true");
        // Get parsed context
        OurParser.BoolExprContext boolExpr = parser.boolExpr();
        // Context -> ASTNode
        ASTBuilder astBuilder = new ASTBuilder();
        BoolExpressionNode boolExpressionNode = (BoolExpressionNode) astBuilder.visitBoolExpr(boolExpr);

        assertEquals("true", boolExpressionNode.getBoolLiteral());
    }

    @Test
    void testBoolExprNotLiteral() {
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("!(true)");
        // Get parsed context
        OurParser.BoolExprContext boolExpr = parser.boolExpr();
        // Context -> ASTNode
        ASTBuilder astBuilder = new ASTBuilder();
        BoolExpressionNode boolExpressionNode = (BoolExpressionNode) astBuilder.visitBoolExpr(boolExpr);

        assertAll(
                () -> assertEquals("true", boolExpressionNode.getBoolExpressionNode().getBoolLiteral()),
                () -> assertEquals(true, boolExpressionNode.getOptionalNot())
        );
    }

    // Test arithExpr arithOp arithExpr
    @Test
    void testArithExpr1() {
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("var + 2");
        // Get parsed context
        OurParser.ArithExprContext arithExpr = parser.arithExpr();
        // Context -> ASTNode
        ASTBuilder astBuilder = new ASTBuilder();
        ArithExpressionNode arithExpressionNode = (ArithExpressionNode) astBuilder.visitArithExpr(arithExpr);

        String varName = arithExpressionNode.getArithExpressionNode1().getVariableName();
        Enums.ArithOperator operator = arithExpressionNode.getArithExpressionOperator();
        double literal = arithExpressionNode.getArithExpressionNode2().getNumber();

        assertAll(
                () -> assertEquals("var", varName),
                () -> assertEquals(Enums.ArithOperator.ADD, operator),
                () -> assertEquals(2, literal)
        );
    }

    // Test NOT?(arithExpr), arithExpr is functionCall
    @Test
    void testArithExprNotFunc() {
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("!(FuncName())");
        // Get parsed context
        OurParser.ArithExprContext arithExpr = parser.arithExpr();
        // Context -> ASTNode
        ASTBuilder astBuilder = new ASTBuilder();
        ArithExpressionNode arithExpressionNode = (ArithExpressionNode) astBuilder.visitArithExpr(arithExpr);


        assertAll(
                () -> assertEquals("FuncName", arithExpressionNode.getArithExpressionNode1().getFunctionCallNode().getFunctionName()),
                () -> assertEquals(Enums.BoolOperator.NOT, arithExpressionNode.getOptionalNot())
        );
    }

    // Test SUBSCRIPT arithExpr
    @Test
    void testArithExprSUBSCRIPT() {
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("arr[2]");
        // Get parsed context
        OurParser.ArithExprContext arithExpr = parser.arithExpr();
        // Context -> ASTNode
        ASTBuilder astBuilder = new ASTBuilder();
        ArithExpressionNode arithExpressionNode = (ArithExpressionNode) astBuilder.visitArithExpr(arithExpr);


        assertAll(
                () -> assertEquals("arr", arithExpressionNode.getSubscriptNode().getVariableName()),
                () -> assertEquals(2, arithExpressionNode.getSubscriptNode().getIndex())
        );
    }

    // Test visitprogram
    @Test
    void testVisitProgram() {
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("Setup{} Loop{}");
        // Get parsed Context
        OurParser.ProgramContext programContext = parser.program();
        // Context -> AST visit
        ASTBuilder astBuilder = new ASTBuilder();
        ProgramNode programNode = (ProgramNode) astBuilder.visitProgram(programContext);

        assertAll(
                () -> assertNotNull(programNode.getSetupNode()),
                () -> assertNotNull(programNode.getLoopNode())
        );
    }

    @Test
    void testForLoop() {
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("for (var to 5) {}");
        // Get parsed context
        OurParser.ForStatementContext forStatement = parser.forStatement();
        // Context -> ASTNode
        ASTBuilder astbuilder = new ASTBuilder();
        ForStatementNode forStatementNode = (ForStatementNode) astbuilder.visitForStatement(forStatement);

        assertAll(
                () -> assertEquals("var", forStatementNode.getArithExpressionNode1().getVariableName()),
                () -> assertEquals(5, forStatementNode.getArithExpressionNode2().getNumber())
        );
    }

    @Test
    void testFunctionCallArgs() {
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("function(2, varName)");
        // Get parsed context, through arithExpr
        OurParser.ArithExprContext arithExprContext = parser.arithExpr();
        // Context -> ASTNode
        ASTBuilder astbuilder = new ASTBuilder();
        ArithExpressionNode arithExpressionNode = (ArithExpressionNode) astbuilder.visitArithExpr(arithExprContext);
        FunctionCallNode functionCallNode = arithExpressionNode.getFunctionCallNode();

        assertAll(
                () -> assertEquals("function", functionCallNode.getFunctionName()),
                () -> assertEquals(2, functionCallNode.getFunctionArgsNode().getArithExpressionNodes().get(0).getNumber()),
                () -> assertEquals("varName", functionCallNode.getFunctionArgsNode().getArithExpressionNodes().get(1).getVariableName())
        );
    }

    // Test void functionDecl
    @Test
    void testFunctionDecl() {
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("void test(int ID2, string varName){}");
        // Get parsed context
        OurParser.FunctionDeclContext functionDeclContext = parser.functionDecl();
        // Context -> ASTNode
        ASTBuilder astbuilder = new ASTBuilder();
        FunctionDeclarationNode functionDeclarationNode = (FunctionDeclarationNode) astbuilder.visitFunctionDecl(functionDeclContext);

        assertAll(
                () -> assertNotNull(functionDeclarationNode.getBlockNode()),
                () -> assertEquals(Enums.DataType.VOID, functionDeclarationNode.getDataType()),
                () -> assertNotNull(functionDeclarationNode.getFunctionName())
        );
    }

    //Test FunctionDecl with get.Datatype
    @Test
    void testFunctionDeclDatatype() {
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("bool test(int ID2, string varName){}");
        // Get parsed context
        OurParser.FunctionDeclContext functionDeclContext = parser.functionDecl();
        // Context -> ASTNode
        ASTBuilder astbuilder = new ASTBuilder();
        FunctionDeclarationNode functionDeclarationNode = (FunctionDeclarationNode) astbuilder.visitFunctionDecl(functionDeclContext);

        assertEquals(Enums.DataType.BOOL, functionDeclarationNode.getDataType());
    }

    @Test
    void testVisitReturnStatement() {
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("return varName;");
        // Get parsed context
        OurParser.StatementContext statementContext = parser.statement();
        // Context -> ASTNode
        ASTBuilder astbuilder = new ASTBuilder();
        // VisitStatement returns a ReturnStatementNode
        ReturnStatementNode returnStatementNode = (ReturnStatementNode) astbuilder.visitStatement(statementContext);

        assertEquals("varName", returnStatementNode.getVariableName());
    }

    @Test
    void testVisitFunctionParam() {
        OurParser parser = createParserFromText("bool test(int ID2, string varName){}");
        // Get parsed context
        OurParser.FunctionDeclContext functionDeclContext = parser.functionDecl();
        // Context -> ASTNode
        ASTBuilder astbuilder = new ASTBuilder();

        FunctionDeclarationNode functionDeclarationNode = (FunctionDeclarationNode) astbuilder.visitFunctionDecl(functionDeclContext);
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
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("while (true) {}");
        // Get parsed context
        OurParser.WhileStatementContext whileStatementContext = parser.whileStatement();
        // Context -> ASTNode
        ASTBuilder astBuilder = new ASTBuilder();

        WhileStatementNode whileStatementNode = (WhileStatementNode) astBuilder.visitWhileStatement(whileStatementContext);

        assertEquals("true", whileStatementNode.getBoolExpressionNode().getBoolLiteral());
    }

    @Test
    void testAssignArray() {
        // String -> Tokens -> Parsing
        OurParser parser = createParserFromText("arr = {1.2, 3.3}");
        // Get parsed context
        OurParser.AssignArrayContext assignArrayContext = parser.assignArray();
        // Context -> ASTNode
        ASTBuilder astBuilder = new ASTBuilder();
        AssignArrayNode assignArrayNode = (AssignArrayNode) astBuilder.visitAssignArray(assignArrayContext);

        assertAll(
                () -> assertEquals("arr", assignArrayNode.getVariableName()),
                () -> assertEquals(1.2, assignArrayNode.getParamNodes().get(0).getArithExpressionNode().getNumber()),
                () -> assertEquals(3.3, assignArrayNode.getParamNodes().get(1).getArithExpressionNode().getNumber())
        );
    }
}
