package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.expressions.ArithExpressionNode;

public class AssignmentNode extends StatementNode {

    private final String variableName;
    private String literalValue;
    private ArithExpressionNode expressionNode;

    private  CodePosition codePosition;

    public AssignmentNode(String variableName, ArithExpressionNode expressionNode) {
        this.variableName = variableName;
        this.expressionNode = expressionNode;
    }

    public AssignmentNode(String variableName, String literalValue) {
        this.variableName = variableName;
        this.literalValue = literalValue;
    }

    public String getVariableName() { return variableName; }

    public ArithExpressionNode getExpressionNode() { return expressionNode; }

    public String getLiteralValue() {
        return literalValue;
    }

    @Override
    public String prettyPrint(int indentation) { return null; }

    @Override
    public void setCodePosition(CodePosition codePosition) { this.codePosition = codePosition; }

    @Override
    public CodePosition getCodePosition() { return codePosition; }
}
