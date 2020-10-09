package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.expressions.ArithExpressionNode;
import dk.aau.cs.d703e20.ast.structure.BlockNode;

public class AtStatementNode extends StatementNode{

    private String variableName;
    private ArithExpressionNode expressionNode;
    private Enums.BoolOperator boolOperator;
    private BlockNode blockNode;

    private CodePosition codePosition;

    public AtStatementNode(String variableName, ArithExpressionNode expressionNode, Enums.BoolOperator boolOperator, BlockNode blockNode) {
        this.variableName = variableName;
        this.expressionNode = expressionNode;
        this.boolOperator = boolOperator;
        this.blockNode = blockNode;
    }

    public String getVariableName() {
        return variableName;
    }

    public ArithExpressionNode getExpressionNode() {
        return expressionNode;
    }

    public Enums.BoolOperator getBoolOperator() {
        return boolOperator;
    }

    public BlockNode getBlockNode() {
        return blockNode;
    }

    @Override
    public String prettyPrint(int indentation) {
        return null;
    }

    @Override
    public void setCodePosition(CodePosition codePosition) { this.codePosition = codePosition; }

    @Override
    public CodePosition getCodePosition() {
        return codePosition;
    }
}
