package dk.aau.cs.d703e20.ast.structure;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.expressions.FunctionParameterNode;

public class FunctionDeclarationNode implements ASTNode {
    private Enums.DataType dataType;
    private final String functionName;
    private final BlockNode blockNode;
    private FunctionParameterNode functionParameterNode;
    private CodePosition codePosition;

    public FunctionDeclarationNode(Enums.DataType dataType, String functionName, BlockNode blockNode) {
        this.dataType = dataType;
        this.functionName = functionName;
        this.blockNode = blockNode;
    }

    public FunctionDeclarationNode(String functionName, BlockNode blockNode) {
        this.dataType = Enums.DataType.VOID;
        this.functionName = functionName;
        this.blockNode = blockNode;
    }

    public FunctionDeclarationNode(Enums.DataType dataType, String functionName, BlockNode blockNode, FunctionParameterNode functionParameterNode) {
        this.dataType = dataType;
        this.functionName = functionName;
        this.blockNode = blockNode;
        this.functionParameterNode = functionParameterNode;
    }

    public FunctionDeclarationNode(String functionName, BlockNode blockNode, FunctionParameterNode functionParameterNode) {
        this.dataType = Enums.DataType.VOID;
        this.functionName = functionName;
        this.blockNode = blockNode;
        this.functionParameterNode = functionParameterNode;
    }

    public Enums.DataType getDataType() {
        return dataType;
    }

    public String getFunctionName() {
        return functionName;
    }

    public BlockNode getBlockNode() {
        return blockNode;
    }

    public FunctionParameterNode getFunctionParameterNode() {
        return functionParameterNode;
    }

    @Override
    public String prettyPrint(int indentation) {
        StringBuilder sb = new StringBuilder();

        sb.append(dataType.toString());
        sb.append(" ");
        sb.append(functionName);
        sb.append(" (");
        if (functionParameterNode != null)
            sb.append(functionParameterNode.prettyPrint(indentation));
        sb.append(") ");
        sb.append(blockNode.prettyPrint(indentation));

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
