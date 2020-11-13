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

        //for (StatementNode statement : blockNode.getStatementNodes())
        //    statementNodes.addAll(visitStatement(statement));

        return new BlockNode(statementNodes);
    }

    private ArrayList<StatementNode> visitStatement(StatementNode statementNode) {
        ArrayList<StatementNode> statementNodes = new ArrayList<>();

        if (statementNode instanceof AssignmentNode)
            statementNodes.add(visitAssignment((AssignmentNode) statementNode));
        else if (statementNode instanceof VariableDeclarationNode)
            statementNodes.add(visitVariableDeclaration((VariableDeclarationNode) statementNode));
        else if (statementNode instanceof IfElseStatementNode)
            statementNodes.add(visitIfElseStatement((IfElseStatementNode) statementNode));
        else if (statementNode instanceof ReturnStatementNode)
            statementNodes.add(visitReturnStatement((ReturnStatementNode) statementNode));
        else if (statementNode instanceof FunctionCallNode)
            statementNodes.add(visitFunctionCall((FunctionCallNode) statementNode));
        else if (statementNode instanceof ForStatementNode)
            statementNodes.add(visitForStatement((ForStatementNode) statementNode));
        else if (statementNode instanceof WhileStatementNode)
            statementNodes.add(visitWhileStatement((WhileStatementNode) statementNode));
        else if (statementNode instanceof AtStatementNode)
            statementNodes.add(visitAtStatement((AtStatementNode) statementNode));
        else if (statementNode instanceof BoundStatementNode)
            statementNodes.add(visitBoundStatement((BoundStatementNode) statementNode));
        else if (statementNode instanceof AssignArrayNode)
            statementNodes.add(visitAssignArray((AssignArrayNode) statementNode));
        else if (statementNode instanceof PinDeclarationNode)
            statementNodes.add(visitPinDeclaration((PinDeclarationNode) statementNode));
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

    private IfElseStatementNode visitIfElseStatement(IfElseStatementNode ifElseStatementNode) {
        IfStatementNode ifStatementNode = visitIfStatement(ifElseStatementNode.getIfStatementNode());
        ElseStatementNode elseStatementNode = visitElseStatement(ifElseStatementNode.getElseStatement());
        ArrayList<ElseIfStatementNode> elseIfStatementNodes = new ArrayList<>();

        if (ifElseStatementNode.getElseIfStatementNodes() != null) {
            for (ElseIfStatementNode elseIfStatementNode : ifElseStatementNode.getElseIfStatementNodes()) {
                elseIfStatementNodes.add(visitElseIfStatement(elseIfStatementNode));
            }
        }

        return new IfElseStatementNode(ifStatementNode, elseIfStatementNodes, elseStatementNode);
    }

    private IfStatementNode visitIfStatement(IfStatementNode ifStatementNode) {
        ConditionalExpressionNode conditionalExpressionNode = ifStatementNode.getConditionalExpressionNode();
        BlockNode blockNode = ifStatementNode.getBlockNode();
        return new IfStatementNode(visitConditionalExpression(conditionalExpressionNode), visitBlock(blockNode));
    }

    private ElseIfStatementNode visitElseIfStatement(ElseIfStatementNode elseIfStatementNode) {
        ConditionalExpressionNode conditionalExpressionNode = elseIfStatementNode.getConditionalExpressionNode();
        BlockNode blockNode = elseIfStatementNode.getBlockNode();
        return new ElseIfStatementNode(visitConditionalExpression(conditionalExpressionNode), visitBlock(blockNode));
    }

    private ElseStatementNode visitElseStatement(ElseStatementNode elseStatementNode) {
        return new ElseStatementNode(visitBlock(elseStatementNode.getBlockNode()));
    }

    private FunctionDeclarationNode visitFunctionDeclaration(FunctionDeclarationNode functionDeclarationNode) {
        Enums.DataType dataType = functionDeclarationNode.getDataType();
        String functionName = functionDeclarationNode.getFunctionName();
        BlockNode blockNode = visitBlock(functionDeclarationNode.getBlockNode());
        ArrayList<FunctionParameterNode> functionParameterNodes = new ArrayList<>();

        for (FunctionParameterNode functionParameterNode : functionDeclarationNode.getFunctionParameterNodes()) {
            functionParameterNodes.add(visitFunctionParameter(functionParameterNode));
        }
        return new FunctionDeclarationNode(dataType, functionName, visitBlock(blockNode), functionParameterNodes);
    }

    private FunctionParameterNode visitFunctionParameter(FunctionParameterNode functionParameterNode) {
        Enums.DataType dataType = functionParameterNode.getDataType();
        String variableName = functionParameterNode.getVariableName();
        return new FunctionParameterNode(dataType, variableName);
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
        } else if (functionArgNode.getBoolExpressionNode() != null) {
            boolExpressionNode = visitBoolExpression(functionArgNode.getBoolExpressionNode());
            return new FunctionArgNode((boolExpressionNode));
        } else throw new CompilerException("Invalid function argument", functionArgNode.getCodePosition());
    }

    private WhileStatementNode visitWhileStatement(WhileStatementNode whileStatementNode) {
        BoolExpressionNode boolExpressionNode = whileStatementNode.getBoolExpressionNode();
        BlockNode blockNode = whileStatementNode.getBlockNode();
        return new WhileStatementNode(boolExpressionNode, blockNode);
    }

    private AtStatementNode visitAtStatement(AtStatementNode atStatementNode) {
        AtParamsNode atParamsNode = atStatementNode.getAtParamsNode();
        BlockNode blockNode = atStatementNode.getBlockNode();
        return new AtStatementNode(atParamsNode, blockNode);
    }

    private ReturnStatementNode visitReturnStatement(ReturnStatementNode returnStatementNode) {
        return new ReturnStatementNode(returnStatementNode.getVariableName());
    }

    private AtParamsNode visitAtParams(AtParamsNode atParamsNode) {
        return new AtParamsNode(visitBoolExpression(atParamsNode.getBoolExpressionNode()));
    }

    private BoundStatementNode visitBoundStatement(BoundStatementNode boundStatementNode) {
        AtParamsNode atParamsNode = visitAtParams(boundStatementNode.getAtParamsNode());
        BlockNode body = visitBlock(boundStatementNode.getBody());
        String boolLiteral = boundStatementNode.getBoolLiteral();
        BlockNode catchBlock;
        BlockNode finalBlock;

        if (boolLiteral != null) {
            if (boundStatementNode.getFinalBlock() != null) {
                finalBlock = visitBlock(boundStatementNode.getFinalBlock());
                if (boundStatementNode.getCatchBlock() != null) {
                    catchBlock = visitBlock(boundStatementNode.getCatchBlock());
                    return new BoundStatementNode(atParamsNode, boolLiteral, body, catchBlock, finalBlock);
                } else
                    return new BoundStatementNode(atParamsNode, boolLiteral, body, finalBlock, false);
            } else if (boundStatementNode.getCatchBlock() != null) {
                catchBlock = visitBlock(boundStatementNode.getCatchBlock());
                return new BoundStatementNode(atParamsNode, boolLiteral, body, catchBlock, true);
            } else
                return new BoundStatementNode(atParamsNode, boolLiteral, body);
        }
        if (boundStatementNode.getFinalBlock() != null) {
            finalBlock = visitBlock(boundStatementNode.getFinalBlock());
            if (boundStatementNode.getCatchBlock() != null) {
                catchBlock = visitBlock(boundStatementNode.getCatchBlock());
                return new BoundStatementNode(atParamsNode, body, catchBlock, finalBlock);
            }
        } else
            return new BoundStatementNode(atParamsNode, body);

        throw new CompilerException("invalid bound statement", boundStatementNode.getCodePosition());
    }

    private AssignArrayNode visitAssignArray(AssignArrayNode assignArrayNode){
        String variableName = assignArrayNode.getVariableName();
        ArrayList<ArrayParamNode> arrayParamNodes = new ArrayList<>();

        for (ArrayParamNode arrayParamNode : assignArrayNode.getParamNodes()) {
            arrayParamNodes.add(visitArrayParam(arrayParamNode));
        }
        return new AssignArrayNode(variableName, arrayParamNodes);
    }

    private ArrayParamNode visitArrayParam(ArrayParamNode arrayParamNode){
        String literal = arrayParamNode.getLiteral();
        ArithExpressionNode arithExpressionNode = arrayParamNode.getArithExpressionNode();

        if (literal != null) {
            return new ArrayParamNode(literal);
        }
        else return new ArrayParamNode(visitArithExpression(arithExpressionNode));
    }

    private ForStatementNode visitForStatement(ForStatementNode forStatementNode) {
        ArithExpressionNode arithExpressionNode1 = forStatementNode.getArithExpressionNode1();
        ArithExpressionNode arithExpressionNode2 = forStatementNode.getArithExpressionNode2();
        BlockNode blockNode = forStatementNode.getBlockNode();

        return new ForStatementNode(visitArithExpression(arithExpressionNode1), visitArithExpression(arithExpressionNode2), visitBlock(blockNode));
    }

    private PinDeclarationNode visitPinDeclaration(PinDeclarationNode pinDeclarationNode) {
        Enums.PinType pinType = pinDeclarationNode.getPinType();
        String variableName = pinDeclarationNode.getVariableName();
        String pinNumber = pinDeclarationNode.getPinNumber();

        return new PinDeclarationNode(pinType, variableName, pinNumber);
    }


    //TODO -> VisitArithExpression og VisitBoolExpression og visitConditionalExpression
    private ArithExpressionNode visitArithExpression(ArithExpressionNode arithExpressionNode) {
        boolean optionalNot = arithExpressionNode.getOptionalNot();
        ArithExpressionNode arithExpressionNode1;
        ArithExpressionNode arithExpressionNode2;
        Enums.ArithOperator arithOperator;

        if (optionalNot) {

        }
        return arithExpressionNode;
    }

    private BoolExpressionNode visitBoolExpression(BoolExpressionNode boolExpressionNode) {
        if (boolExpressionNode.getBoolExprOperandNodes() != null)
            visitBoolOperation(boolExpressionNode.getBoolExpressionOperators());
        return boolExpressionNode;
    }

    private ConditionalExpressionNode visitConditionalExpression(ConditionalExpressionNode conditionalExpressionNode) {
        BoolExpressionNode boolExpressionNode;
        if (conditionalExpressionNode.getBoolExpressionNode() != null) {
            boolExpressionNode = visitBoolExpression(conditionalExpressionNode.getBoolExpressionNode());
            return new ConditionalExpressionNode(boolExpressionNode);
        } else
            throw new CompilerException("Invalid conditional-expression", conditionalExpressionNode.getCodePosition());
    }


}
