package dk.aau.cs.d703e20.codegen.arduino.statements;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.statements.StatementNode;
import dk.aau.cs.d703e20.ast.structure.BlockNode;

public class AtStatementNode extends StatementNode {

    private final AtParamsNode atParamsNode;
    private final BlockNode blockNode;

    private CodePosition codePosition;

    public AtStatementNode(AtParamsNode atParamsNode, BlockNode blockNode) {
        this.atParamsNode = atParamsNode;
        this.blockNode = blockNode;
    }

    public AtParamsNode getAtParamsNode() {
        return atParamsNode;
    }

    public BlockNode getBlockNode() {
        return blockNode;
    }


    @Override
    public String prettyPrint(int indentation) {

        return "at (" +
                atParamsNode.prettyPrint(indentation) +
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
