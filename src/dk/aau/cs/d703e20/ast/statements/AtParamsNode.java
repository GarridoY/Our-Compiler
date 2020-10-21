package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.expressions.ArithExpressionNode;

import java.util.List;

public class AtParamsNode extends StatementNode {
    List<String> variableNames;
    List<Enums.BoolOperator> boolOperators;
    List<ArithExpressionNode> arithExpressionNodes;
    String boolLiteral;

    public AtParamsNode(List<String> variableNames, List<Enums.BoolOperator> boolOperators, List<ArithExpressionNode> arithExpressionNodes) {
        this.variableNames = variableNames;
        this.boolOperators = boolOperators;
        this.arithExpressionNodes = arithExpressionNodes;
    }

    public AtParamsNode(List<String> variableNames, List<Enums.BoolOperator> boolOperators, List<ArithExpressionNode> arithExpressionNodes, String boolLiteral) {
        this.variableNames = variableNames;
        this.boolOperators = boolOperators;
        this.arithExpressionNodes = arithExpressionNodes;
        this.boolLiteral = boolLiteral;
    }

    public List<String> getVariableNames() {
        return variableNames;
    }

    public List<Enums.BoolOperator> getBoolOperators() {
        return boolOperators;
    }

    public String getBoolLiteral() {
        return boolLiteral;
    }

    public List<ArithExpressionNode> getArithExpressionNodes() {
        return arithExpressionNodes;
    }

    @Override
    public String prettyPrint(int indentation) {
        return null;
    }

    @Override
    public void setCodePosition(CodePosition codePosition) {

    }

    @Override
    public CodePosition getCodePosition() {
        return null;
    }
}
