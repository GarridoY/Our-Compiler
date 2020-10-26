package dk.aau.cs.d703e20.ast.expressions;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;

import java.util.List;

public class BoolExpressionNode implements ASTNode {
    // TODO Add boolSymbol
    private boolean optionalNot;
    private BoolExpressionNode boolExpressionNode;
    private String boolLiteral;

    private List<BoolExprOperandNode> boolExprOperandNodes;

    private List<Enums.BoolOperator> boolExpressionOperators;

    private CodePosition codePosition;

    // NOT? LEFT_PAREN boolExpr RIGHT_PAREN;
    public BoolExpressionNode(boolean optionalNot, BoolExpressionNode boolExpressionNode) {
        this.optionalNot = optionalNot;
        this.boolExpressionNode = boolExpressionNode;
    }

    public BoolExpressionNode(List<BoolExprOperandNode> boolExprOperandNodes, List<Enums.BoolOperator> boolExpressionOperators) {
        this.boolExprOperandNodes = boolExprOperandNodes;
        this.boolExpressionOperators = boolExpressionOperators;
    }

    // BOOL_LITERAL
    public BoolExpressionNode(String boolLiteral) {
        this.boolLiteral = boolLiteral;
    }

    public String getBoolLiteral() {
        return boolLiteral;
    }


    public BoolExpressionNode getBoolExpressionNode() {
        return boolExpressionNode;
    }

    public Boolean getOptionalNot() {
        return optionalNot;
    }

    public boolean isOptionalNot() {
        return optionalNot;
    }

    public List<BoolExprOperandNode> getBoolExprOperandNodes() {
        return boolExprOperandNodes;
    }

    public List<Enums.BoolOperator> getBoolExpressionOperators() {
        return boolExpressionOperators;
    }

    @Override
    public String prettyPrint(int indentation) {
        /* TODO: fix :)
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
        } else if (boolLiteral != null) {
            sb.append(boolLiteral);
        } else if (boolExpressionNode != null) {
            if (optionalNot)
                sb.append("!");
            sb.append("(");
            sb.append(boolExpressionNode.prettyPrint(indentation));
            sb.append(")");
        }

        return sb.toString();
        */
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
