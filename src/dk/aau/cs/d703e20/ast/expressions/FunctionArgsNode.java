package dk.aau.cs.d703e20.ast.expressions;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;

import java.util.List;

public class FunctionArgsNode implements ASTNode {
    private final List<ArithExpressionNode> arithExpressionNodes;
    private final List<BoolExpressionNode> boolExpressionNodes;

    private CodePosition codePosition;

    public FunctionArgsNode(List<ArithExpressionNode> arithExpressionNodes, List<BoolExpressionNode> boolExpressionNodes) {
        this.arithExpressionNodes = arithExpressionNodes;
        this.boolExpressionNodes = boolExpressionNodes;
    }

    public List<ArithExpressionNode> getArithExpressionNodes() {
        return arithExpressionNodes;
    }

    public List<BoolExpressionNode> getBoolExpressionNodes() {
        return boolExpressionNodes;
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
