package dk.aau.cs.d703e20.ast.expressions;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;

public class BoolExpressionNode implements ASTNode {
    // TODO Add boolSymbol
    // private Boolean not;
    private boolean optionalNot;
    private BoolExpressionNode boolExpressionNode;

    private ArithExpressionNode arithExpressionNode1;
    private ArithExpressionNode arithExpressionNode2;

    private String boolLiteral;
    private String boolLiteral2;

    private Enums.BoolOperator boolExpressionOperator;

    private CodePosition codePosition;

    // NOT? LEFT_PAREN boolExpr RIGHT_PAREN;
    public BoolExpressionNode(boolean optionalNot, BoolExpressionNode boolExpressionNode) {
        this.optionalNot = optionalNot;
        this.boolExpressionNode = boolExpressionNode;
    }

    // arithExpr boolOp arithExpr
    public BoolExpressionNode(ArithExpressionNode arithExpressionNode1, ArithExpressionNode arithExpressionNode2, Enums.BoolOperator boolExpressionOperator) {
        this.arithExpressionNode1 = arithExpressionNode1;
        this.boolExpressionOperator = boolExpressionOperator;
        this.arithExpressionNode2 = arithExpressionNode2;
    }

    // arithExpr boolOp BOOL_LITERAL
    public BoolExpressionNode(ArithExpressionNode arithExpressionNode1 , String boolLiteral2, Enums.BoolOperator boolExpressionOperator) {
        this.arithExpressionNode1 = arithExpressionNode1;
        this.boolExpressionOperator = boolExpressionOperator;
        this.boolLiteral2 = boolLiteral2;
    }

    // BOOL_LITERAL boolOp arithExpr
    public BoolExpressionNode(String boolLiteral1, ArithExpressionNode arithExpressionNode2, Enums.BoolOperator boolExpressionOperator) {
        this.boolLiteral = boolLiteral1;
        this.boolExpressionOperator = boolExpressionOperator;
        this.arithExpressionNode1 = arithExpressionNode2;
    }

    // BOOL_LITERAL boolOp BOOL_LITERAL
    public BoolExpressionNode(String boolLiteral1, String boolLiteral2, Enums.BoolOperator boolExpressionOperator) {
        this.boolLiteral = boolLiteral1;
        this.boolExpressionOperator = boolExpressionOperator;
        this.boolLiteral2 = boolLiteral2;
    }

    // BOOL_LITERAL
    public BoolExpressionNode(String boolLiteral) {
        this.boolLiteral = boolLiteral;
    }

    public ArithExpressionNode getArithExpressionNode1() { return arithExpressionNode1; }

    public ArithExpressionNode getArithExpressionNode2() { return arithExpressionNode2; }

    public Enums.BoolOperator getBoolExpressionOperator() { return boolExpressionOperator; }

    public String getBoolLiteral() { return boolLiteral; }

    public String getBoolLiteral2() {
        return boolLiteral2;
    }

    public BoolExpressionNode getBoolExpressionNode() {
        return boolExpressionNode;
    }

    public Boolean getOptionalNot() {
        return optionalNot;
    }

    @Override
    public String prettyPrint(int indentation) {
        StringBuilder sb = new StringBuilder();

        if (boolExpressionOperator != null) {
            if (arithExpressionNode1 != null)
                sb.append(arithExpressionNode1.prettyPrint(indentation));
            else
                sb.append(boolLiteral);

            sb.append(" ");
            sb.append(Enums.stringFromBoolOperator(boolExpressionOperator));
            sb.append(" ");

            if (arithExpressionNode2 != null)
                sb.append(arithExpressionNode2.prettyPrint(indentation));
            else
                sb.append(boolLiteral2);
        }
        else if (boolLiteral != null) {
            sb.append(boolLiteral);
        }
        else if (boolExpressionNode != null) {
            if (optionalNot)
                sb.append("!");
            sb.append("(");
            sb.append(boolExpressionNode.prettyPrint(indentation));
            sb.append(")");
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
