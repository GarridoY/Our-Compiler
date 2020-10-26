package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.expressions.FunctionArgsNode;

public class FunctionCallNode extends StatementNode {
    private final String functionName;
    private final FunctionArgsNode functionargsNode;

    private CodePosition codePosition;

    public FunctionCallNode(String functionName) {
        this.functionName = functionName;
        this.functionargsNode = null;
    }

    public FunctionCallNode(String functionName, FunctionArgsNode functionargsNode) {
        this.functionName = functionName;
        this.functionargsNode = functionargsNode;
    }

    public String getFunctionName() {
        return functionName;
    }

    public FunctionArgsNode getFunctionArgsNode() {
        return functionargsNode;
    }

    @Override
    public String prettyPrint(int indentation) {
        StringBuilder sb = new StringBuilder();

        sb.append(functionName);
        sb.append("(");
        if (functionargsNode != null)
            sb.append(functionargsNode.prettyPrint(indentation));
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
