package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.expressions.ArithExpressionNode;
import dk.aau.cs.d703e20.ast.structure.BlockNode;

public class ForStatementNode extends StatementNode {
    private ArithExpressionNode expressionNode1;
    private ArithExpressionNode expressionNode2;
    private BlockNode blockNode;

    private CodePosition codePosition;

    public ForStatementNode(ArithExpressionNode expressionNode1, ArithExpressionNode expressionNode2, BlockNode blockNode) {
        this.expressionNode1 = expressionNode1;
        this.expressionNode2 = expressionNode2;
        this.blockNode = blockNode;
    }

    public ArithExpressionNode getExpressionNode1() {
        return expressionNode1;
    }

    public ArithExpressionNode getExpressionNode2() {
        return expressionNode2;
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
