package dk.aau.cs.d703e20.codegen;

import dk.aau.cs.d703e20.ast.errorhandling.CompilerException;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.expressions.*;
import dk.aau.cs.d703e20.ast.statements.*;
import dk.aau.cs.d703e20.ast.structure.ProgramNode;

import java.util.HashMap;
import java.util.LinkedHashSet;


public class ArduinoGenerator {

    private StringBuilder sb;

    private static HashMap<String, VariableDeclarationNode> variables;
    private LinkedHashSet<String> usedVariables;

    public static HashMap<String, VariableDeclarationNode> getVariables() {
        return variables;
    }

    public String GenerateArduino(ProgramNode ast) {
        sb = new StringBuilder();

        variables = new HashMap<>();
        usedVariables = new LinkedHashSet<>();

        //TODO: ProgramNode program = visitProgram(ast);

        //TODO: generateSetup();
        //TODO: generateLoop();
        //TODO generateFunctions();

        return sb.toString();
    }


}
