package dk.aau.cs.d703e20.ast.expressions;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;

public class FunctionArgNode implements ASTNode {
    private ArithExpressionNode arithExpressionNode;
    private BoolExpressionNode boolExpressionNode;

    private CodePosition codePosition;

    public FunctionArgNode(ArithExpressionNode arithExpressionNode) {
        this.arithExpressionNode = arithExpressionNode;
    }

    public FunctionArgNode(BoolExpressionNode boolExpressionNode) {
        this.boolExpressionNode = boolExpressionNode;
    }

    public ArithExpressionNode getArithExpressionNode() {
        return arithExpressionNode;
    }

    public BoolExpressionNode getBoolExpressionNode() {
        return boolExpressionNode;
    }

    @Override
    public String prettyPrint(int indentation) {
        StringBuilder sb = new StringBuilder();

        if (arithExpressionNode != null) {
            sb.append(arithExpressionNode.prettyPrint(indentation));
        }
        else if (boolExpressionNode != null) {
            sb.append(boolExpressionNode.prettyPrint(indentation));
        }

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
