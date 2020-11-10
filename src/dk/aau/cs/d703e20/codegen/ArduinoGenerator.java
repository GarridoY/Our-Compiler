package dk.aau.cs.d703e20.codegen;

import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.expressions.*;
import dk.aau.cs.d703e20.ast.statements.*;
import dk.aau.cs.d703e20.ast.structure.*;
import dk.aau.cs.d703e20.errorhandling.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;


public class ArduinoGenerator {

    private StringBuilder sb;

    private static HashMap<String, VariableDeclarationNode> variables;
    private LinkedHashSet<String> usedVariables;
    private ArrayList<FunctionDeclarationNode> Functions;

    public static HashMap<String, VariableDeclarationNode> getVariables() {
        return variables;
    }

    public String GenerateArduino(ProgramNode ast) {
        sb = new StringBuilder();

        variables = new HashMap<>();
        usedVariables = new LinkedHashSet<>();

        Functions = new ArrayList<>();

        ProgramNode program = visitProgram(ast);

        //TODO: generateSetup();
        //TODO: generateLoop();
        //TODO generateFunctions();

        return sb.toString();
    }


    private ProgramNode visitProgram(ProgramNode programNode) {
        SetupNode setupNode = visitSetup(programNode.getSetupNode());
        LoopNode loopNode = visitLoop(programNode.getLoopNode());
        ArrayList<FunctionDeclarationNode> functionDeclarationNodes = new ArrayList<>();

        for (FunctionDeclarationNode functionDeclarationNode : programNode.getFunctionDeclarationNodes()) {
            functionDeclarationNodes.add(visitFunctionDeclaration(functionDeclarationNode));
        }

        return new ProgramNode(setupNode, loopNode, functionDeclarationNodes);
    }

    private SetupNode visitSetup(SetupNode setupNode) {
        return new SetupNode(visitBlock(setupNode.getBlockNode()));
    }

    private LoopNode visitLoop(LoopNode loopNode) {
        return new LoopNode(visitBlock(loopNode.getBlockNode()));
    }

    private BlockNode visitBlock(BlockNode blockNode) {
        ArrayList<StatementNode> statementNodes = new ArrayList<>();

        for (StatementNode statement : blockNode.getStatementNodes())
            statementNodes.addAll(visitStatement(statement));

        return new BlockNode(statementNodes);
    }

    private ArrayList<StatementNode> visitStatement(StatementNode statementNode) {
        ArrayList<StatementNode> statementNodes = new ArrayList<>();

        if (statementNode instanceof AssignmentNode)
            statementNodes.add(visitAssignment((AssignmentNode)statementNode));
        else if (statementNode instanceof VariableDeclarationNode)
            statementNodes.add(visitVariableDeclaration((VariableDeclarationNode)statementNode));
        else if (statementNode instanceof IfElseStatementNode)
            statementNodes.add(visitIfElseStatement((IfElseStatementNode)statementNode));
        else if (statementNode instanceof ReturnStatementNode)
            statementNodes.add(visitReturnStatement((ReturnStatementNode)statementNode));
        else if (statementNode instanceof FunctionCallNode)
            statementNodes.add(visitFunctionCall((FunctionCallNode)statementNode));
        else if (statementNode instanceof ForStatementNode)
            statementNodes.add(visitForStatement((ForStatementNode)statementNode));
        else if (statementNode instanceof WhileStatementNode)
            statementNodes.add(visitWhileStatement((WhileStatementNode)statementNode));
        else if (statementNode instanceof AtStatementNode)
            statementNodes.add(visitAtStatement((AtStatementNode)statementNode));
        else if (statementNode instanceof BoundStatementNode)
            statementNodes.add(visitBoundStatement((BoundStatementNode)statementNode));
        else if (statementNode instanceof AssignArrayNode)
            statementNodes.add(visitAssignArray((AssignArrayNode)statementNode));
        else if (statementNode instanceof PinDeclarationNode)
            statementNodes.add(visitPinDeclaration((PinDeclarationNode)statementNode));
        else {
            throw new RuntimeException("Statement is of unknown type: " + statementNode.prettyPrint(0));
        }
        return statementNodes;
    }

    private AssignmentNode visitAssignment(AssignmentNode assignmentNode) {
        String variableName = assignmentNode.getVariableName();
        ArithExpressionNode arithExpressionNode = assignmentNode.getArithExpressionNode();
        return new AssignmentNode(variableName, arithExpressionNode);
    }

    private VariableDeclarationNode visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
        Enums.DataType dataType = variableDeclarationNode.getDataType();
        return new VariableDeclarationNode(dataType, variableDeclarationNode.getAssignmentNode());
    }

    private IfElseStatementNode visitIfElseStatement(IfElseStatementNode ifElseStatementNode){
        IfStatementNode ifStatementNode = visitIfStatement(ifElseStatementNode.getIfStatementNode());
        ElseStatementNode elseStatementNode = null;
        ArrayList<ElseIfStatementNode> elseIfStatementNodes = new ArrayList<>();

        if (ifElseStatementNode.getElseIfStatementNodes() != null) {
            for (ElseIfStatementNode elseIfStatementNode : ifElseStatementNode.getElseIfStatementNodes()) {
                elseIfStatementNodes.add(visitElseIfStatement(elseIfStatementNode));
            }
        }

        if (ifElseStatementNode.getElseStatement() != null) {
            elseStatementNode = visitElseStatement(ifElseStatementNode.getElseStatement());
        }

        return new IfElseStatementNode(ifStatementNode, elseIfStatementNodes, elseStatementNode);
    }

    private IfStatementNode visitIfStatement(IfStatementNode ifStatementNode) {
        ConditionalExpressionNode conditionalExpressionNode = null;
        BlockNode blockNode;

        if (ifStatementNode.getConditionalExpressionNode() != null) {
            conditionalExpressionNode = visitConditionalExpression(ifStatementNode.getConditionalExpressionNode());
        }

        if (ifStatementNode.getBlockNode() != null) {
            blockNode = visitBlock(ifStatementNode.getBlockNode());
            return new IfStatementNode(conditionalExpressionNode, blockNode);
        }
        else throw new CompilerException("Invalid if-statement", ifStatementNode.getCodePosition());
    }

    private ElseIfStatementNode visitElseIfStatement(ElseIfStatementNode elseIfStatementNode){
        ConditionalExpressionNode conditionalExpressionNode = null;
        BlockNode blockNode;

        if (elseIfStatementNode.getConditionalExpressionNode() != null) {
            conditionalExpressionNode = visitConditionalExpression(elseIfStatementNode.getConditionalExpressionNode());
        }

        if (elseIfStatementNode.getBlockNode() != null) {
            blockNode = visitBlock(elseIfStatementNode.getBlockNode());
            return new ElseIfStatementNode(conditionalExpressionNode, blockNode);
        }
        else
            throw new CompilerException("Invalid else-if-statement", elseIfStatementNode.getCodePosition());
    }

    private ElseStatementNode visitElseStatement(ElseStatementNode elseStatementNode) {
        BlockNode blockNode;
        if (elseStatementNode.getBlockNode() != null) {
            blockNode = visitBlock(elseStatementNode.getBlockNode());
            return new ElseStatementNode(blockNode);
        }
        else throw new CompilerException("Invalid else-statement", elseStatementNode.getCodePosition());
    }

    private FunctionDeclarationNode visitFunctionDeclaration(FunctionDeclarationNode functionDeclarationNode) {
        if (functionDeclarationNode.getDataType() != null) {
            Functions.add(functionDeclarationNode);
        }
        else
            throw new CompilerException("Function without data type.", functionDeclarationNode.getCodePosition());
        return functionDeclarationNode;
    }

    private FunctionCallNode visitFunctionCall(FunctionCallNode functionCallNode) {
        ArrayList<FunctionArgNode> functionArgNodes = new ArrayList<>();
        String functionName = functionCallNode.getFunctionName();

        if (functionCallNode.getFunctionArgNodes() != null) {
            for (FunctionArgNode argNode : functionCallNode.getFunctionArgNodes()) {
                functionArgNodes.add(visitFunctionArgument(argNode));
            }
        }
        return new FunctionCallNode(functionName, functionArgNodes);
    }

    private FunctionArgNode visitFunctionArgument(FunctionArgNode functionArgNode) {
        ArithExpressionNode arithExpressionNode;
        BoolExpressionNode boolExpressionNode;
        if (functionArgNode.getArithExpressionNode() != null) {
            arithExpressionNode = visitArithExpression(functionArgNode.getArithExpressionNode());
            return new FunctionArgNode(arithExpressionNode);
        }
        else if (functionArgNode.getBoolExpressionNode() != null) {
            boolExpressionNode = visitBoolExpression(functionArgNode.getBoolExpressionNode());
            return new FunctionArgNode((boolExpressionNode));
        }
        else throw new CompilerException("Invalid function argument", functionArgNode.getCodePosition());
    }

    private ConditionalExpressionNode visitConditionalExpression(ConditionalExpressionNode conditionalExpressionNode){
        BoolExpressionNode boolExpressionNode;
        if (conditionalExpressionNode.getBoolExpressionNode() != null) {
            boolExpressionNode = visitBoolExpression(conditionalExpressionNode.getBoolExpressionNode());
            return new ConditionalExpressionNode(boolExpressionNode);
        }
        else throw new CompilerException("Invalid conditional-expression", conditionalExpressionNode.getCodePosition());
    }

    private WhileStatementNode visitWhileStatement(WhileStatementNode whileStatementNode) {
        BoolExpressionNode boolExpressionNode;
        BlockNode blockNode;
        if (whileStatementNode.getBoolExpressionNode() != null || whileStatementNode.getBlockNode() != null) {
            boolExpressionNode = visitBoolExpression(whileStatementNode.getBoolExpressionNode());
            blockNode = visitBlock(whileStatementNode.getBlockNode());
            return new WhileStatementNode(boolExpressionNode, blockNode);
        }
        else throw new CompilerException("invalid while statement", whileStatementNode.getCodePosition());
    }

    private AtStatementNode visitAtStatement(AtStatementNode atStatementNode) {
        AtParamsNode atParamsNode;
        BlockNode blockNode;
        if (atStatementNode.getAtParamsNode() != null) {
            atParamsNode = visitAtParams(atStatementNode.getAtParamsNode());
            blockNode = visitBlock(atStatementNode.getBlockNode());
            return new AtStatementNode(atParamsNode, blockNode);
        }
        else throw new CompilerException("invalid at statement", atStatementNode.getCodePosition());
    }

    private ReturnStatementNode visitReturnStatement(ReturnStatementNode returnStatementNode){
        if (returnStatementNode.getVariableName() != null) {
            return returnStatementNode;
        }
        else throw new CompilerException("Invalid return-statement", returnStatementNode.getCodePosition());
    }

    //TODO -> VisitArithExpression og VisitBoolExpression
    private ArithExpressionNode visitArithExpression (ArithExpressionNode arithExpressionNode) {
        boolean optionalNot = arithExpressionNode.getOptionalNot();
        ArithExpressionNode arithExpressionNode1;
        ArithExpressionNode arithExpressionNode2;
        Enums.ArithOperator arithOperator;

        if (optionalNot) {

        }
        return arithExpressionNode;
    }

    private BoolExpressionNode visitBoolExpression(BoolExpressionNode boolExpressionNode){
        if (boolExpressionNode.getBoolExprOperandNodes() != null)
            visitBoolOperation(boolExpressionNode.getBoolExpressionOperators());
        return  boolExpressionNode;
    }

    //TODO -> visitForStatement
    private ForStatementNode visitForStatement(ForStatementNode forStatementNode) {
        ArrayList<StatementNode> statementNodes = new ArrayList<>();
        ArithExpressionNode arithExpressionNode1 = visitArithExpression(forStatementNode.getArithExpressionNode1());
        ArithExpressionNode arithExpressionNode2 = visitArithExpression(forStatementNode.getArithExpressionNode2());
        LoopNode loopNode;

        if (arithExpressionNode1.getVariableName() != null) {
            statementNodes.add(arithExpressionNode1.getVariableName());
            return new ForStatementNode(arithExpressionNode1);
        }
        else if (arithExpressionNode1.get)
    }









}
