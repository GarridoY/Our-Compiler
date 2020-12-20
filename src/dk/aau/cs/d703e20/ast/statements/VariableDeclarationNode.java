package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;

public class VariableDeclarationNode extends StatementNode {

    protected final Enums.DataType dataType;
    protected int allocatedSize;

    protected String variableName;
    protected AssignmentNode assignmentNode;
    protected AssignArrayNode assignArrayNode;

    private boolean inSetup;

    protected CodePosition codePosition;

    public VariableDeclarationNode(Enums.DataType dataType, AssignmentNode assignmentNode) {
        this.dataType = dataType;
        this.assignmentNode = assignmentNode;
        this.variableName = assignmentNode.getVariableName();
    }

    public VariableDeclarationNode(Enums.DataType dataType, AssignArrayNode assignArrayNode) {
        this.dataType = dataType;
        this.assignArrayNode = assignArrayNode;
        this.variableName = assignArrayNode.getVariableName();
    }

    public VariableDeclarationNode(Enums.DataType dataType, String variableName) {
        this.dataType = dataType;
        this.variableName = variableName;
    }

    public VariableDeclarationNode(Enums.DataType dataType, int allocatedSize, AssignArrayNode assignArrayNode) {
        this.dataType = dataType;
        this.allocatedSize = allocatedSize;
        this.assignArrayNode = assignArrayNode;
    }

    public VariableDeclarationNode(Enums.DataType dataType, int allocatedSize, String variableName) {
        this.dataType = dataType;
        this.allocatedSize = allocatedSize;
        this.variableName = variableName;
    }

    public Enums.DataType getDataType() {
        return dataType;
    }

    public int getAllocatedSize() {
        return allocatedSize;
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

    public boolean isInSetup() {
        return inSetup;
    }

    public void setInSetup(boolean inSetup) {
        this.inSetup = inSetup;
    }

    @Override
    public String prettyPrint(int indentation) {
        StringBuilder sb = new StringBuilder();

        sb.append(Enums.stringFromDataType(dataType, allocatedSize));
        sb.append(" ");
        if (assignmentNode != null)
            sb.append(assignmentNode.prettyPrint(indentation));
        else if (assignArrayNode != null)
            sb.append(assignArrayNode.prettyPrint(indentation));
        else {
            sb.append(variableName);
            sb.append(";");
        }
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
