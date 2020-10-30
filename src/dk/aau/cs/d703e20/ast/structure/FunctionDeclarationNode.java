package dk.aau.cs.d703e20.ast.structure;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.expressions.FunctionParameterNode;

import java.util.List;

public class FunctionDeclarationNode implements ASTNode {
    private Enums.DataType dataType;
    private final String functionName;
    private final BlockNode blockNode;
    private List<FunctionParameterNode> functionParameterNodes;
    private CodePosition codePosition;

    public FunctionDeclarationNode(Enums.DataType dataType, String functionName, BlockNode blockNode, List<FunctionParameterNode> functionParameterNodes) {
        this.dataType = dataType;
        this.functionName = functionName;
        this.blockNode = blockNode;
        this.functionParameterNodes = functionParameterNodes;
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

    public List<FunctionParameterNode> getFunctionParameterNodes() {
        return functionParameterNodes;
    }

    @Override
    public String prettyPrint(int indentation) {
        StringBuilder sb = new StringBuilder();

        sb.append(Enums.stringFromDataType(dataType));
        sb.append(" ");
        sb.append(functionName);
        sb.append(" (");
        String prefix = "";
        for (FunctionParameterNode functionParameterNode : functionParameterNodes) {
            sb.append(prefix);
            sb.append(functionParameterNode.prettyPrint(indentation));
            prefix = ", ";
        }
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
