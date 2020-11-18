package dk.aau.cs.d703e20.codegen.arduino.expressions;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;

public class ArrayParamNode implements ASTNode {
    private ArithExpressionNode arithExpressionNode;
    private String literal;

    private CodePosition codePosition;

    public ArrayParamNode(String literal) {
        this.literal = literal;
    }

    public ArrayParamNode(ArithExpressionNode arithExpressionNode) {
        this.arithExpressionNode = arithExpressionNode;
    }

    public String getLiteral() {
        return literal;
    }

    public ArithExpressionNode getArithExpressionNode() {
        return arithExpressionNode;
    }

    @Override
    public String prettyPrint(int indentation) {
        if (arithExpressionNode != null)
            return arithExpressionNode.prettyPrint(indentation);
        else
            return literal;
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