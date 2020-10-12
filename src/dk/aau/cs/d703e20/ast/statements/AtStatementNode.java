package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.expressions.ArithExpressionNode;
import dk.aau.cs.d703e20.ast.structure.BlockNode;

public class AtStatementNode extends StatementNode{

    private String variableName;
    private ArithExpressionNode arithExpressionNode;
    private Enums.BoolOperator boolOperator;
    private BlockNode blockNode;

    private CodePosition codePosition;

    public AtStatementNode(String variableName, ArithExpressionNode arithExpressionNode, Enums.BoolOperator boolOperator, BlockNode blockNode) {
        this.variableName = variableName;
        this.arithExpressionNode = arithExpressionNode;
        this.boolOperator = boolOperator;
        this.blockNode = blockNode;
    }

    public String getVariableName() {
        return variableName;
    }

    public ArithExpressionNode getArithExpressionNode() {
        return arithExpressionNode;
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
