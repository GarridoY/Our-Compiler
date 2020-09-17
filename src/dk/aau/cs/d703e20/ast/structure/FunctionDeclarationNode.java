package dk.aau.cs.d703e20.ast.structure;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.expressions.FunctionParameterNode;

import java.util.List;

public class FunctionDeclarationNode implements ASTNode {
    private final Enums.DataType dataType;
    private final String functionName;
    private final List<FunctionParameterNode> functionParameterNodes;
    private final BlockNode blockNode;

    private CodePosition codePosition;

    public FunctionDeclarationNode(Enums.DataType dataType, String functionName, List<FunctionParameterNode> functionParameterNodes, BlockNode blockNode) {
        this.dataType = dataType;
        this.functionName = functionName;
        this.functionParameterNodes = functionParameterNodes;
        this.blockNode = blockNode;
    }

    public Enums.DataType getDataType() {
        return dataType;
    }

    public String getFunctionName() {
        return functionName;
    }

    public List<FunctionParameterNode> getFunctionParameterNodes() {
        return functionParameterNodes;
    }

    public BlockNode getBlockNode() {
        return blockNode;
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
