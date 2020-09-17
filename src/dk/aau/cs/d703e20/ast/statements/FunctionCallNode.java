package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.expressions.ExpressionNode;

import java.util.List;

public class FunctionCallNode extends StatementNode {
    private final String functionName;
    private final List<ExpressionNode> expressionNodes;

    private CodePosition codePosition;

    public FunctionCallNode(String functionName, List<ExpressionNode> expressionNodes) {
        this.functionName = functionName;
        this.expressionNodes = expressionNodes;
    }

    public String getFunctionName() {
        return functionName;
    }

    public List<ExpressionNode> getExpressionNodes() {
        return expressionNodes;
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
