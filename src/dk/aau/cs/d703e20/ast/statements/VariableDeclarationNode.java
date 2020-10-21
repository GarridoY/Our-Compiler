package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;

public class VariableDeclarationNode extends StatementNode {

    private final Enums.DataType dataType;

    private AssignmentNode assignmentNode;
    private String variableName;
    private AssignArrayNode assignArrayNode;

    private CodePosition codePosition;

    public VariableDeclarationNode(Enums.DataType dataType, AssignmentNode assignmentNode) {
        this.dataType = dataType;
        this.assignmentNode = assignmentNode;
    }

    public VariableDeclarationNode(Enums.DataType dataType, AssignArrayNode assignArrayNode) {
        this.dataType = dataType;
        this.assignArrayNode = assignArrayNode;
    }

    public VariableDeclarationNode(Enums.DataType dataType, String variableName) {
        this.dataType = dataType;
        this.variableName = variableName;
    }

    public Enums.DataType getDataType() {
        return dataType;
    }

    public AssignmentNode getAssignmentNode() {
        return assignmentNode;
    }

    public String getVariableName() {
        return variableName;
    }

    public AssignArrayNode getAssignArrayNode() {
        return assignArrayNode;
    }

    @Override
    public String prettyPrint(int indentation) {
        return null;
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
