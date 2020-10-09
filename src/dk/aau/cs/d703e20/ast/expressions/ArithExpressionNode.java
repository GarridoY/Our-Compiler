package dk.aau.cs.d703e20.ast.expressions;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;

public class ArithExpressionNode implements ASTNode {
    private ArithExpressionNode arithExpressionNode1;
    private ArithExpressionNode arithExpressionNode2;
    private Enums.Operator arithExpressionOperator;

    private Double number;

    private String variableName;

    private CodePosition codePosition;

    public ArithExpressionNode(ArithExpressionNode arithExpressionNode1, ArithExpressionNode arithExpressionNode2, Enums.Operator arithExpressionOperator) {
        this.arithExpressionNode1 = arithExpressionNode1;
        this.arithExpressionNode2 = arithExpressionNode2;
        this.arithExpressionOperator = arithExpressionOperator;
    }

    public ArithExpressionNode(Double number) {
        this.number = number;
    }

    public ArithExpressionNode(ArithExpressionNode arithExpressionNode1) {
        this.arithExpressionNode1 = arithExpressionNode1;
    }

    public ArithExpressionNode(String variableName) {
        this.variableName = variableName;
    }

    public ArithExpressionNode getArithExpressionNode1() {
        return arithExpressionNode1;
    }

    public ArithExpressionNode getArithExpressionNode2() {
        return arithExpressionNode2;
    }

    public Enums.Operator getArithExpressionOperator() {
        return arithExpressionOperator;
    }

    public Double getNumber() {
        return number;
    }

    public String getVariableName() {
        return variableName;
    }

    @Override
    public String prettyPrint(int indentation) {
        return null;
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
