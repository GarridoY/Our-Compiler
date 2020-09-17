package dk.aau.cs.d703e20.ast.expressions;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;

public class BoolExpressionNode implements ASTNode {
    // TODO Add boolSymbol
    private ExpressionNode expressionNode;
    private BoolExpressionNode boolExpressionNode;

    private CodePosition codePosition;

    public BoolExpressionNode(ExpressionNode expressionNode) {
        this.expressionNode = expressionNode;
    }

    public BoolExpressionNode(BoolExpressionNode boolExpressionNode) {
        this.boolExpressionNode = boolExpressionNode;
    }

    public ExpressionNode getExpressionNode() {
        return expressionNode;
    }

    public BoolExpressionNode getBoolExpressionNode() {
        return boolExpressionNode;
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
