package dk.aau.cs.d703e20.ast.statements;

import  dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;

public class VariableDeclarationNode extends StatementNode{

    private final Enums.DataType dataType;

    private final AssignmentNode assignmentNode;

    private CodePosition codePosition;

    public VariableDeclarationNode(Enums.DataType dataType, AssignmentNode assignmentNode) {
        this.dataType = dataType;
        this.assignmentNode = assignmentNode;
    }

    public Enums.DataType getDataType() { return dataType; }

    public AssignmentNode getAssignmentNode() { return assignmentNode; }

    @Override
    public String prettyPrint(int indentation) { return null; }

    @Override
    public void setCodePosition(CodePosition codePosition) { this.codePosition = codePosition; }

    @Override
    public CodePosition getCodePosition() { return codePosition; }
}
