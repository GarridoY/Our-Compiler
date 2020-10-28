package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.structure.BlockNode;

public class BoundStatementNode extends StatementNode {
    AtParamsNode atParamsNode;
    String boolLiteral;
    BlockNode body;
    BlockNode catchBlock;
    BlockNode finalBlock;

    // atParam, block
    public BoundStatementNode(AtParamsNode atParamsNode, BlockNode body) {
        this.atParamsNode = atParamsNode;
        this.body = body;
    }

    // atParam COMMA BOOL_LITERAL block
    public BoundStatementNode(AtParamsNode atParamsNode, String boolLiteral, BlockNode body) {
        this.atParamsNode = atParamsNode;
        this.boolLiteral = boolLiteral;
        this.body = body;
    }

    // atParam block keyword block
    public BoundStatementNode(AtParamsNode atParamsNode, BlockNode body, BlockNode finalOrCatchBlock, boolean catchBlock) {
        this.atParamsNode = atParamsNode;
        this.body = body;
        // Evade same type erasure of constructors
        if (catchBlock)
            this.catchBlock = finalOrCatchBlock;
        else
            this.finalBlock = finalOrCatchBlock;
    }


    // atParam COMMA BOOL_LITERAL block keyword block
    public BoundStatementNode(AtParamsNode atParamsNode, String boolLiteral, BlockNode body, BlockNode finalOrCatchBlock, boolean catchBlock) {
        this.atParamsNode = atParamsNode;
        this.boolLiteral = boolLiteral;
        this.body = body;
        // Evade same type erasure of constructors
        if (catchBlock)
            this.catchBlock = finalOrCatchBlock;
        else
            this.finalBlock = finalOrCatchBlock;
    }

    public BoundStatementNode(AtParamsNode atParamsNode, BlockNode body, BlockNode catchBlock, BlockNode finalBlock) {
        this.atParamsNode = atParamsNode;
        this.body = body;
        this.catchBlock = catchBlock;
        this.finalBlock = finalBlock;
    }

    public BoundStatementNode(AtParamsNode atParamsNode, String boolLiteral, BlockNode body, BlockNode catchBlock, BlockNode finalBlock) {
        this.atParamsNode = atParamsNode;
        this.boolLiteral = boolLiteral;
        this.body = body;
        this.catchBlock = catchBlock;
        this.finalBlock = finalBlock;
    }

    public AtParamsNode getAtParamsNode() {
        return atParamsNode;
    }

    public BlockNode getCatchBlock() {
        return catchBlock;
    }

    public String getBoolLiteral() {
        return boolLiteral;
    }

    public BlockNode getBody() {
        return body;
    }

    public BlockNode getFinalBlock() {
        return finalBlock;
    }

    @Override
    public String prettyPrint(int indentation) {
        return "BOUND STATEMENT";
    }

    @Override
    public void setCodePosition(CodePosition codePosition) {

    }

    @Override
    public CodePosition getCodePosition() {
        return null;
    }
}
