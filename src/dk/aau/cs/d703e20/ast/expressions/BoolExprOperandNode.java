package dk.aau.cs.d703e20.ast.expressions;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;

public class BoolExprOperandNode implements ASTNode {
    String boolLiteral;
    ArithExpressionNode arithExpressionNode;

    public BoolExprOperandNode(String boolLiteral) {
        this.boolLiteral = boolLiteral;
    }

    public BoolExprOperandNode(ArithExpressionNode arithExpressionNode) {
        this.arithExpressionNode = arithExpressionNode;
    }

    public String getBoolLiteral() {
        return boolLiteral;
    }

    public ArithExpressionNode getArithExpressionNode() {
        return arithExpressionNode;
    }

    @Override
    public String prettyPrint(int indentation) {
        return null;
    }

    @Override
    public void setCodePosition(CodePosition codePosition) {

    }

    @Override
    public CodePosition getCodePosition() {
        return null;
    }
}
