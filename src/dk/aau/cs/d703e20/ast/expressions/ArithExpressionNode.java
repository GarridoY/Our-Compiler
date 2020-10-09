package dk.aau.cs.d703e20.ast.expressions;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;

public class ArithExpressionNode implements ASTNode {
    private ArithExpressionNode expressionNode1;
    private ArithExpressionNode expressionNode2;
    private Enums.Operator arithExpressionOperator;

    private Double number;

    private String variableName;

    private CodePosition codePosition;

    public ArithExpressionNode(ArithExpressionNode expressionNode1, ArithExpressionNode expressionNode2, Enums.Operator arithExpressionOperator) {
        this.expressionNode1 = expressionNode1;
        this.expressionNode2 = expressionNode2;
        this.arithExpressionOperator = arithExpressionOperator;
    }

    public ArithExpressionNode(Double number) {
        this.number = number;
    }

    public ArithExpressionNode(ArithExpressionNode expressionNode1) {
        this.expressionNode1 = expressionNode1;
    }

    public ArithExpressionNode(String variableName) {
        this.variableName = variableName;
    }

    public ArithExpressionNode getExpressionNode1() {
        return expressionNode1;
    }

    public ArithExpressionNode getExpressionNode2() {
        return expressionNode2;
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
