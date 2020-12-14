package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.structure.BlockNode;

public class BoundStatementNode extends StatementNode {
    private AtParamsNode atParamsNode;
    private boolean boolLiteral;
    private BlockNode body;
    private BlockNode catchBlock;
    private BlockNode finalBlock;

    // atParam, block
    public BoundStatementNode(AtParamsNode atParamsNode, BlockNode body) {
        this.atParamsNode = atParamsNode;
        this.body = body;
    }

    // atParam COMMA BOOL_LITERAL block
    public BoundStatementNode(AtParamsNode atParamsNode, String boolLiteral, BlockNode body) {
        this.atParamsNode = atParamsNode;
        this.boolLiteral = boolLiteral.equals("true");
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
        this.boolLiteral = boolLiteral.equals("true");
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
        this.boolLiteral = boolLiteral.equals("true");
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

    public boolean getBoolLiteral() {
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
        StringBuilder sb = new StringBuilder();

        sb.append("bound (");
        sb.append(atParamsNode.prettyPrint(indentation));
        sb.append(", ");
        sb.append(boolLiteral);
        sb.append(") ");
        sb.append(body.prettyPrint(indentation));

        if (catchBlock != null) {
            sb.append("catch ");
            sb.append(catchBlock.prettyPrint(indentation));
        }

        if (finalBlock != null) {
            sb.append("final ");
            sb.append(finalBlock.prettyPrint(indentation));
        }

        return sb.toString();
    }

    @Override
    public void setCodePosition(CodePosition codePosition) {

    }

    @Override
    public CodePosition getCodePosition() {
        return null;
    }
}
