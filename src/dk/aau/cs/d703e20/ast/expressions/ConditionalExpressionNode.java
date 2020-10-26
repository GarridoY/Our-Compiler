package dk.aau.cs.d703e20.ast.expressions;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.statements.FunctionCallNode;

public class ConditionalExpressionNode implements ASTNode {
    private BoolExpressionNode boolExpressionNode;
    private String variableName;
    private FunctionCallNode functionCallNode;
    private SubscriptNode subscriptNode;

    private CodePosition codePosition;

    public ConditionalExpressionNode(BoolExpressionNode boolExpressionNode) {
        this.boolExpressionNode = boolExpressionNode;
    }

    public ConditionalExpressionNode(String variableName) {
        this.variableName = variableName;
    }

    public ConditionalExpressionNode(FunctionCallNode functionCallNode) {
        this.functionCallNode = functionCallNode;
    }

    public ConditionalExpressionNode(SubscriptNode subscriptNode) {
        this.subscriptNode = subscriptNode;
    }

    public BoolExpressionNode getBoolExpressionNode() {
        return boolExpressionNode;
    }

    public String getVariableName() {
        return variableName;
    }

    public FunctionCallNode getFunctionCallNode() {
        return functionCallNode;
    }

    public SubscriptNode getSubscriptNode() {
        return subscriptNode;
    }

    @Override
    public String prettyPrint(int indentation) {
        StringBuilder sb = new StringBuilder();

        if (boolExpressionNode != null) {
            sb.append(boolExpressionNode.prettyPrint(indentation));
        }
        else if (variableName != null) {
            //TODO: we need to know if we should print "!"
            sb.append(variableName);
        }
        else if (functionCallNode != null) {
            sb.append(functionCallNode.prettyPrint(indentation));
        }
        else if (subscriptNode != null) {
            sb.append(subscriptNode.prettyPrint(indentation));
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
