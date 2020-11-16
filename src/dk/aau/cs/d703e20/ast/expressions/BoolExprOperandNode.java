package dk.aau.cs.d703e20.ast.expressions;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;

public class BoolExprOperandNode implements ASTNode {
    private String boolLiteral;
    private ArithExpressionNode arithExpressionNode;
    private BoolExpressionNode boolExpressionNode;

    private CodePosition codePosition;

    public BoolExprOperandNode(String boolLiteral) {
        this.boolLiteral = boolLiteral;
    }

    public BoolExprOperandNode(ArithExpressionNode arithExpressionNode) {
        this.arithExpressionNode = arithExpressionNode;
    }

    public BoolExprOperandNode(BoolExpressionNode boolExpressionNode) {
        this.boolExpressionNode = boolExpressionNode;
    }

    public String getBoolLiteral() {
        return boolLiteral;
    }

    public ArithExpressionNode getArithExpressionNode() {
        return arithExpressionNode;
    }

    public BoolExpressionNode getBoolExpressionNode() {
        return boolExpressionNode;
    }

    @Override
    public String prettyPrint(int indentation) {
        if (arithExpressionNode != null)
            return arithExpressionNode.prettyPrint(indentation);
        else if (boolExpressionNode != null)
            return boolExpressionNode.prettyPrint(indentation);
        else
            return boolLiteral;
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
