package dk.aau.cs.d703e20.codegen.arduino.expressions;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;

public class FunctionParameterNode implements ASTNode {
    private final String variableName;
    private final Enums.DataType dataType;

    private CodePosition codePosition;

    public FunctionParameterNode(Enums.DataType dataType,  String variableName) {
        this.dataType = dataType;
        this.variableName = variableName;
    }

    public Enums.DataType getDataType() {
        return dataType;
    }

    public String getVariableName() {
        return variableName;
    }

    @Override
    public String prettyPrint(int indentation) {
        StringBuilder sb = new StringBuilder();

        sb.append(Enums.stringFromDataType(dataType));
        sb.append(" ");
        sb.append(variableName);

        return sb.toString();
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
