package dk.aau.cs.d703e20.codegen.arduino.expressions;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;

public class BoolExprOperandNode implements ASTNode {
    private String boolLiteral;
    private ArithExpressionNode arithExpressionNode;

    private CodePosition codePosition;

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
        if (arithExpressionNode != null)
            return arithExpressionNode.prettyPrint(indentation);
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
