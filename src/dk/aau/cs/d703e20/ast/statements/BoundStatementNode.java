package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.expressions.ArithExpressionNode;
import dk.aau.cs.d703e20.ast.structure.BlockNode;

public class BoundStatementNode extends StatementNode{
    String variableName;
    Enums.BoolOperator boolOperator;
    ArithExpressionNode arithExpressionNode;
    String boolLiteral;
    BlockNode blockNode;
    BlockNode finalBlock;

    // variableName boolOp arithExpr block
    public BoundStatementNode(String variableName, Enums.BoolOperator boolOperator, ArithExpressionNode arithExpressionNode) {
        this.variableName = variableName;
        this.boolOperator = boolOperator;
        this.arithExpressionNode = arithExpressionNode;
    }
    // variableName boolOp arithExpr COMMA BOOL_LITERAL block
    public BoundStatementNode(String variableName, Enums.BoolOperator boolOperator, ArithExpressionNode arithExpressionNode, String boolLiteral, BlockNode blockNode) {
        this.variableName = variableName;
        this.boolOperator = boolOperator;
        this.arithExpressionNode = arithExpressionNode;
        this.boolLiteral = boolLiteral;
        this.blockNode = blockNode;
    }
    // variableName boolOp arithExpr block FINAL block
    public BoundStatementNode(String variableName, Enums.BoolOperator boolOperator, ArithExpressionNode arithExpressionNode, BlockNode blockNode, BlockNode finalBlock) {
        this.variableName = variableName;
        this.boolOperator = boolOperator;
        this.arithExpressionNode = arithExpressionNode;
        this.blockNode = blockNode;
        this.finalBlock = finalBlock;
    }
    // variableName boolOp arithExpr COMMA BOOL_LITERAL block FINAL block
    public BoundStatementNode(String variableName, Enums.BoolOperator boolOperator, ArithExpressionNode arithExpressionNode, String boolLiteral, BlockNode blockNode, BlockNode finalBlock) {
        this.variableName = variableName;
        this.boolOperator = boolOperator;
        this.arithExpressionNode = arithExpressionNode;
        this.boolLiteral = boolLiteral;
        this.blockNode = blockNode;
        this.finalBlock = finalBlock;
    }

    public String getVariableName() {
        return variableName;
    }

    public Enums.BoolOperator getBoolOperator() {
        return boolOperator;
    }

    public ArithExpressionNode getArithExpressionNode() {
        return arithExpressionNode;
    }

    public String getBoolLiteral() {
        return boolLiteral;
    }

    public BlockNode getBlockNode() {
        return blockNode;
    }

    public BlockNode getFinalBlock() {
        return finalBlock;
    }

    @Override
    public String prettyPrint(int indentation) {
        return "BOUND STATEMENT";
    }

    @Override
    public void setCodePosition(CodePosition codePosition) {

    }

    @Override
    public CodePosition getCodePosition() {
        return null;
    }
}
