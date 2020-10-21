package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.structure.BlockNode;

public class AtStatementNode extends StatementNode {

    private AtParamsNode atParamsNode;
    private BlockNode blockNode;
    private BlockNode finalBlock;

    private CodePosition codePosition;

    public AtStatementNode(AtParamsNode atParamsNode, BlockNode blockNode) {
        this.atParamsNode = atParamsNode;
        this.blockNode = blockNode;
    }

    public AtStatementNode(AtParamsNode atParamsNode, BlockNode blockNode, BlockNode finalBlock) {
        this.atParamsNode = atParamsNode;
        this.blockNode = blockNode;
        this.finalBlock = finalBlock;
    }

    public AtParamsNode getAtParamsNode() {
        return atParamsNode;
    }

    public BlockNode getBlockNode() {
        return blockNode;
    }

    public BlockNode getFinalBlock() {
        return finalBlock;
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
