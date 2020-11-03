package dk.aau.cs.d703e20.codegen;

import dk.aau.cs.d703e20.ast.errorhandling.CompilerException;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.expressions.*;
import dk.aau.cs.d703e20.ast.statements.*;
import dk.aau.cs.d703e20.ast.structure.*;

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

    //TODO visitBlock
    private SetupNode visitSetup(SetupNode setupNode) {
        return new SetupNode(visitBlock(setupNode.getBlockNode()));
    }

    //TODO visitBlock
    private LoopNode visitLoop(LoopNode loopNode) {
        return new LoopNode(visitBlock(loopNode.getBlockNode()));
    }

    private FunctionDeclarationNode visitFunctionDeclaration(FunctionDeclarationNode functionDeclarationNode) {
        if (functionDeclarationNode.getDataType() != null) {
            Functions.add(functionDeclarationNode);
        }
        else {
            // Should have been inserted into main. Do nothing here TODO
        }
        return functionDeclarationNode;
    }




}
