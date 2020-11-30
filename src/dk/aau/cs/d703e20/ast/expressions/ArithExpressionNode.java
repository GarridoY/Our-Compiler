package dk.aau.cs.d703e20.ast.expressions;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.statements.FunctionCallNode;

public class ArithExpressionNode implements ASTNode {
    // arithExpr arithOp arithExpr
    private ArithExpressionNode arithExpressionNode1;
    private ArithExpressionNode arithExpressionNode2;
    private Enums.ArithOperator arithExpressionOperator;

    // functionCall
    private FunctionCallNode functionCallNode;
    // NOT? (arithExpr)
    private boolean optionalNot;

    // numLiteral
    private String number;

    private String variableName;

    private SubscriptNode subscriptNode;

    private CodePosition codePosition;

    // arithExpr arithOp arithExpr
    public ArithExpressionNode(ArithExpressionNode arithExpressionNode1, ArithExpressionNode arithExpressionNode2, Enums.ArithOperator arithExpressionOperator) {
        this.arithExpressionNode1 = arithExpressionNode1;
        this.arithExpressionNode2 = arithExpressionNode2;
        this.arithExpressionOperator = arithExpressionOperator;
    }

    // numLiteral
    public ArithExpressionNode(String variableNameOrNumber, boolean isNumber) {
        if (isNumber)
            this.number = variableNameOrNumber;
        else
            this.variableName = variableNameOrNumber;
    }

    // functionCall
    public ArithExpressionNode(FunctionCallNode functionCallNode) {
        this.functionCallNode = functionCallNode;
    }

    // NOT? (arithExpr)
    public ArithExpressionNode(ArithExpressionNode arithExpressionNode1, boolean optionalNot) {
        this.arithExpressionNode1 = arithExpressionNode1;
        this.optionalNot = optionalNot;
    }

    public ArithExpressionNode(SubscriptNode subscriptNode) {
        this.subscriptNode = subscriptNode;
    }

    public ArithExpressionNode getArithExpressionNode1() {
        return arithExpressionNode1;
    }

    public ArithExpressionNode getArithExpressionNode2() {
        return arithExpressionNode2;
    }

    public Enums.ArithOperator getArithExpressionOperator() {
        return arithExpressionOperator;
    }

    public String getNumber() {
        return number;
    }

    public String getVariableName() {
        return variableName;
    }

    public FunctionCallNode getFunctionCallNode() {
        return functionCallNode;
    }

    public boolean getOptionalNot() {
        return optionalNot;
    }

    public SubscriptNode getSubscriptNode() {
        return subscriptNode;
    }

    @Override
    public String prettyPrint(int indentation) {
        StringBuilder sb = new StringBuilder();

        if (arithExpressionOperator != null) {
            sb.append(arithExpressionNode1.prettyPrint(indentation));
            sb.append(" ");
            sb.append(Enums.stringFromArithOperator(arithExpressionOperator));
            sb.append(" ");
            sb.append(arithExpressionNode2.prettyPrint(indentation));
        }
        else if (arithExpressionNode1 != null) {
            sb.append("!");
            sb.append(arithExpressionNode1.prettyPrint(indentation));
        }
        else if (number != null) {
            sb.append(number);
        }
        else if (variableName != null) {
            sb.append(variableName);
        }
        else if (functionCallNode != null) {
            sb.append(functionCallNode.prettyPrint(indentation));
        }
        else if (subscriptNode != null) {
            sb.append(subscriptNode.prettyPrint(indentation));
        } else
            sb.append(0);

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
