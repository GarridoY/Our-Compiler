package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.expressions.ExpressionNode;
import dk.aau.cs.d703e20.ast.structure.BlockNode;

public class IfStatementNode implements ASTNode {
    private final ExpressionNode expressionNode;
    private final BlockNode blockNode;

    private CodePosition codePosition;

    public IfStatementNode(ExpressionNode expressionNode, BlockNode blockNode) {
        this.expressionNode = expressionNode;
        this.blockNode = blockNode;
    }

    public ExpressionNode getExpressionNode() {
        return expressionNode;
    }

    public BlockNode getBlockNode() {
        return blockNode;
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
