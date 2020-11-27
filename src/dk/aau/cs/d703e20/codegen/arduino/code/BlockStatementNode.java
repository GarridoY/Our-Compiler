package dk.aau.cs.d703e20.codegen.arduino.code;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.statements.StatementNode;
import dk.aau.cs.d703e20.ast.structure.BlockNode;

public class BlockStatementNode extends StatementNode {
    private BlockNode block;

    private CodePosition codePosition;

    public BlockStatementNode (BlockNode block) {
        this.block = block;
    }

    @Override
    public String prettyPrint(int indentation) {
        return block.prettyPrint(indentation);
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
