package dk.aau.cs.d703e20.ast.expressions;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.statements.FunctionCallNode;

public class ConditionalExpressionNode implements ASTNode {
    private BoolExpressionNode boolExpression;
    private String variableName;
    private FunctionCallNode functionCallNode;

    private CodePosition codePosition;

    public ConditionalExpressionNode(BoolExpressionNode boolExpression) {
        this.boolExpression = boolExpression;
    }

    public ConditionalExpressionNode(String variableName) {
        this.variableName = variableName;
    }

    public ConditionalExpressionNode(FunctionCallNode functionCallNode) {
        this.functionCallNode = functionCallNode;
    }

    public BoolExpressionNode getBoolExpression() {
        return boolExpression;
    }

    public String getVariableName() {
        return variableName;
    }

    public FunctionCallNode getFunctionCallNode() {
        return functionCallNode;
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
