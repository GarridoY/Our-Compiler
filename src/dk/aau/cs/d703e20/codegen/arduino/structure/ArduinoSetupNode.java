package dk.aau.cs.d703e20.codegen.arduino.structure;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.structure.BlockNode;

public class ArduinoSetupNode implements ASTNode {
    private final BlockNode blockNode;

    private CodePosition codePosition;

    public ArduinoSetupNode(BlockNode blockNode) {
        this.blockNode = blockNode;
    }

    public BlockNode getBlockNode() {
        return blockNode;
    }

    @Override
    public String prettyPrint(int indentation) {
        StringBuilder sb = new StringBuilder();

        sb.append("void setup() ");
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
