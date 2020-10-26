package dk.aau.cs.d703e20.ast.expressions;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;

import java.util.List;

public class FunctionParameterNode implements ASTNode {
    private final List<String> variableNames;
    private final List<Enums.DataType> dataTypes;

    private CodePosition codePosition;

    public FunctionParameterNode(List<Enums.DataType> dataTypes,  List<String> variableNames) {
        this.dataTypes = dataTypes;
        this.variableNames = variableNames;
    }

    public List<Enums.DataType> getDataTypes() {
        return dataTypes;
    }

    public List<String> getVariableNames() {
        return variableNames;
    }

    @Override
    public String prettyPrint(int indentation) {
        return "FUNCTION PARAMETER";
    }

    @Override
    public void setCodePosition(CodePosition codePosition) {
        this.codePosition = codePosition;
    }

    @Override
    public CodePosition getCodePosition() {
        return codePosition;
    }
}
