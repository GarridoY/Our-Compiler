package dk.aau.cs.d703e20.ast.expressions;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;

public class BoolExpressionNode extends ExpressionNode {
    // TODO Add boolSymbol
    private Boolean not;
    private BoolExpressionNode boolExpressionNode;

    private ExpressionNode expressionNode1;
    private ExpressionNode expressionNode2;

    private String boolLiteral;
    private String boolLiteral1;

    private Enums.BoolOperator boolExpressionOperator;

    private CodePosition codePosition;

    public BoolExpressionNode(Boolean not, BoolExpressionNode boolExpressionNode) {
        this.not = not;
        this.boolExpressionNode = boolExpressionNode;
    }

    public BoolExpressionNode(ExpressionNode expressionNode1, ExpressionNode expressionNode2, Enums.BoolOperator boolExpressionOperator) {
        this.expressionNode1 = expressionNode1;
        this.expressionNode2 = expressionNode2;
        this.boolExpressionOperator = boolExpressionOperator;
    }

    public BoolExpressionNode(ExpressionNode expressionNode1 , String boolLiteral, Enums.BoolOperator boolExpressionOperator) {
        this.expressionNode1 = expressionNode1;
        this.boolExpressionOperator = boolExpressionOperator;
        this.boolLiteral = boolLiteral;
    }

    public BoolExpressionNode(String boolLiteral, ExpressionNode expressionNode1, Enums.BoolOperator boolExpressionOperator) {
        this.boolLiteral = boolLiteral;
        this.expressionNode1 = expressionNode1;
        this.boolExpressionOperator = boolExpressionOperator;
    }

    public BoolExpressionNode(Enums.BoolOperator boolExpressionOperator, String boolLiteral, String boolLiteral1) {
        this.boolExpressionOperator = boolExpressionOperator;
        this.boolLiteral = boolLiteral;
        this.boolLiteral1 = boolLiteral1;
    }

    public BoolExpressionNode(String boolLiteral) {
        this.boolLiteral = boolLiteral;
    }

    public ExpressionNode getExpressionNode1() { return expressionNode1; }

    public ExpressionNode getExpressionNode2() { return expressionNode2; }

    public Enums.BoolOperator getBoolExpressionOperator() { return boolExpressionOperator; }

    public String getBoolLiteral() { return boolLiteral; }

    public String getBoolLiteral1() {
        return boolLiteral1;
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
