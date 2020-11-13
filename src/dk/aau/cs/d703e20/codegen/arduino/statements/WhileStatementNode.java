package dk.aau.cs.d703e20.codegen.arduino.statements;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.statements.StatementNode;
import dk.aau.cs.d703e20.ast.structure.BlockNode;
import dk.aau.cs.d703e20.codegen.arduino.expressions.BoolExpressionNode;

public class WhileStatementNode extends StatementNode {
    private final BoolExpressionNode boolExpressionNode;
    private final BlockNode blockNode;

    private CodePosition codePosition;

    public WhileStatementNode(BoolExpressionNode boolExpressionNode, BlockNode blockNode) {
        this.boolExpressionNode = boolExpressionNode;
        this.blockNode = blockNode;
    }

    public BoolExpressionNode getBoolExpressionNode() {
        return boolExpressionNode;
    }

    public BlockNode getBlockNode() {
        return blockNode;
    }

    @Override
    public String prettyPrint(int indentation) {

        return "while (" +
                boolExpressionNode.prettyPrint(indentation) +
                ") " +
                blockNode.prettyPrint(indentation);
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
