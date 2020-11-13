package dk.aau.cs.d703e20.codegen.arduino.statements;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.structure.BlockNode;
import dk.aau.cs.d703e20.codegen.arduino.expressions.ConditionalExpressionNode;

public class ElseIfStatementNode implements ASTNode {
    private final ConditionalExpressionNode conditionalExpressionNode;
    private final BlockNode blockNode;

    private CodePosition codePosition;

    public ElseIfStatementNode(ConditionalExpressionNode conditionalExpressionNode, BlockNode blockNode) {
        this.conditionalExpressionNode = conditionalExpressionNode;
        this.blockNode = blockNode;
    }

    public ConditionalExpressionNode getConditionalExpressionNode() {
        return conditionalExpressionNode;
    }

    public BlockNode getBlockNode() {
        return blockNode;
    }

    @Override
    public String prettyPrint(int indentation) {
        StringBuilder sb = new StringBuilder();

        sb.append("else if (");
        sb.append(conditionalExpressionNode.prettyPrint(indentation));
        sb.append(") ");
        sb.append(blockNode.prettyPrint(indentation));

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
