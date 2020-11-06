package dk.aau.cs.d703e20.codegen;

import dk.aau.cs.d703e20.ast.expressions.ArithExpressionNode;
import dk.aau.cs.d703e20.ast.expressions.ArrayParamNode;
import dk.aau.cs.d703e20.ast.expressions.BoolExpressionNode;
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
            statementNodes.add(visitReturnStatemnent((ReturnStatementNode)statementNode));
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
        return new AssignmentNode(visitArithExpression(assignmentNode.getArithExpressionNode()));
    }

    private FunctionDeclarationNode visitFunctionDeclaration(FunctionDeclarationNode functionDeclarationNode) {
        if (functionDeclarationNode.getDataType() != null) {
            Functions.add(functionDeclarationNode);
        }
        else
            throw new CompilerException("Function without data type.", functionDeclarationNode.getCodePosition());
        return functionDeclarationNode;
    }



}
