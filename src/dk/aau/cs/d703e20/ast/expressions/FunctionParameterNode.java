package dk.aau.cs.d703e20.ast.expressions;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;

import java.util.List;

public class FunctionParameterNode extends ExpressionNode {
    private final Enums.DataType dataType;
    private final String variableName;
    private final List<FunctionParameterNode> functionParameterNodes;

    private CodePosition codePosition;

    public FunctionParameterNode(Enums.DataType dataType,List<FunctionParameterNode> functionParameterNodes,  String variableName) {
        this.dataType = dataType;
        this.variableName = variableName;
        this.functionParameterNodes = functionParameterNodes;
    }

    public Enums.DataType getDataType() {
        return dataType;
    }

    public String getVariableName() {
        return variableName;
    }

    public List<FunctionParameterNode> getFunctionParameterNodes() {
        return functionParameterNodes;
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
