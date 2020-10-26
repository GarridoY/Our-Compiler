package dk.aau.cs.d703e20.ast.expressions;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;

public class BoolExpressionNode implements ASTNode {
    // TODO Add boolSymbol
    // private Boolean not;
    private Enums.BoolOperator optionalNot;
    private BoolExpressionNode boolExpressionNode;

    private ArithExpressionNode arithExpressionNode1;
    private ArithExpressionNode arithExpressionNode2;

    private String boolLiteral;
    private String boolLiteral1;

    private Enums.BoolOperator boolExpressionOperator;

    private CodePosition codePosition;

    public BoolExpressionNode(Enums.BoolOperator optionalNot, BoolExpressionNode boolExpressionNode) {
        this.optionalNot = optionalNot;
        this.boolExpressionNode = boolExpressionNode;
    }

    public BoolExpressionNode(ArithExpressionNode arithExpressionNode1, ArithExpressionNode arithExpressionNode2, Enums.BoolOperator boolExpressionOperator) {
        this.arithExpressionNode1 = arithExpressionNode1;
        this.arithExpressionNode2 = arithExpressionNode2;
        this.boolExpressionOperator = boolExpressionOperator;
    }

    public BoolExpressionNode(ArithExpressionNode arithExpressionNode1 , String boolLiteral, Enums.BoolOperator boolExpressionOperator) {
        this.arithExpressionNode1 = arithExpressionNode1;
        this.boolExpressionOperator = boolExpressionOperator;
        this.boolLiteral = boolLiteral;
    }

    public BoolExpressionNode(BoolExpressionNode boolExpressionNode , String boolLiteral, Enums.BoolOperator boolExpressionOperator) {
        this.boolExpressionNode = boolExpressionNode;
        this.boolExpressionOperator = boolExpressionOperator;
        this.boolLiteral = boolLiteral;
    }

    public BoolExpressionNode(String boolLiteral, ArithExpressionNode arithExpressionNode2, Enums.BoolOperator boolExpressionOperator) {
        this.boolLiteral = boolLiteral;
        this.arithExpressionNode1 = arithExpressionNode2;
        this.boolExpressionOperator = boolExpressionOperator;
    }

    public BoolExpressionNode(String boolLiteral1, String boolLiteral2, Enums.BoolOperator boolExpressionOperator) {
        this.boolExpressionOperator = boolExpressionOperator;
        this.boolLiteral = boolLiteral1;
        this.boolLiteral1 = boolLiteral2;
    }

    public BoolExpressionNode(String boolLiteral) {
        this.boolLiteral = boolLiteral;
    }

    public ArithExpressionNode getArithExpressionNode1() { return arithExpressionNode1; }

    public ArithExpressionNode getArithExpressionNode2() { return arithExpressionNode2; }

    public Enums.BoolOperator getBoolExpressionOperator() { return boolExpressionOperator; }

    public String getBoolLiteral() { return boolLiteral; }

    public String getBoolLiteral1() {
        return boolLiteral1;
    }

    public BoolExpressionNode getBoolExpressionNode() {
        return boolExpressionNode;
    }

    public Enums.BoolOperator getOptionalNot() {
        return optionalNot;
    }

    @Override
    public String prettyPrint(int indentation) {
        return "BOOL EXPRESSION";
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
