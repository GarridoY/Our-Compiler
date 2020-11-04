package dk.aau.cs.d703e20.codegen;

import dk.aau.cs.d703e20.ast.statements.*;
import dk.aau.cs.d703e20.ast.structure.*;
import dk.aau.cs.d703e20.errorhandling.CompilerException;

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

    //TODO
    private ArrayList<StatementNode> visitStatement(StatementNode statementNode) {
        ArrayList<StatementNode> statementNodes = new ArrayList<>();

        if (statementNode instanceof AssignmentNode)
            statementNodes.add(visitAssignment((AssignmentNode)statementNode, true));
        else if (statementNode instanceof VariableDeclarationNode)
            statementNodes.add(visitVariableDeclaration((VariableDeclarationNode)statementNode));
        else if (statementNode instanceof IfStatementNode)
            statementNodes.add(visitIfStatement((IfStatementNode)statementNode));
        else if (statementNode)
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
