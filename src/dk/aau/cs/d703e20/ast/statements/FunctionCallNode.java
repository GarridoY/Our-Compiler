package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.expressions.FunctionArgNode;

import java.util.List;

public class FunctionCallNode extends StatementNode {
    private final String functionName;
    private final List<FunctionArgNode> functionargNodes;

    private CodePosition codePosition;

    public FunctionCallNode(String functionName, List<FunctionArgNode> functionargNodes) {
        this.functionName = functionName;
        this.functionargNodes = functionargNodes;
    }

    public String getFunctionName() {
        return functionName;
    }

    public List<FunctionArgNode> getFunctionArgNodes() {
        return functionargNodes;
    }

    @Override
    public String prettyPrint(int indentation) {
        StringBuilder sb = new StringBuilder();

        sb.append(functionName);
        sb.append("(");
        String prefix = "";
        for (FunctionArgNode functionArgNode : functionargNodes) {
            sb.append(prefix);
            sb.append(functionArgNode.prettyPrint(indentation));
            prefix = ", ";
        }
        sb.append(");");

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
