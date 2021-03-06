package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.expressions.BoolExpressionNode;

public class AtParamsNode extends StatementNode {
    private final BoolExpressionNode boolExpressionNode;

    private CodePosition codePosition;

    public AtParamsNode(BoolExpressionNode boolExpressionNode) {
        this.boolExpressionNode = boolExpressionNode;
    }

    public BoolExpressionNode getBoolExpressionNode() {
        return boolExpressionNode;
    }

    @Override
    public String prettyPrint(int indentation) {
        return boolExpressionNode.prettyPrint(indentation);
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
