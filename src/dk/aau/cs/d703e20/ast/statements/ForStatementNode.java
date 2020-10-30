package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.expressions.ArithExpressionNode;
import dk.aau.cs.d703e20.ast.structure.BlockNode;

public class ForStatementNode extends StatementNode {
    private final ArithExpressionNode arithExpressionNode1;
    private final ArithExpressionNode arithExpressionNode2;
    private final BlockNode blockNode;

    private CodePosition codePosition;

    public ForStatementNode(ArithExpressionNode arithExpressionNode1, ArithExpressionNode arithExpressionNode2, BlockNode blockNode) {
        this.arithExpressionNode1 = arithExpressionNode1;
        this.arithExpressionNode2 = arithExpressionNode2;
        this.blockNode = blockNode;
    }

    public ArithExpressionNode getArithExpressionNode1() {
        return arithExpressionNode1;
    }

    public ArithExpressionNode getArithExpressionNode2() {
        return arithExpressionNode2;
    }

    public BlockNode getBlockNode() {
        return blockNode;
    }

    @Override
    public String prettyPrint(int indentation) {
        // TODO: implement pretty print
        return "FOR STATEMENT";
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
