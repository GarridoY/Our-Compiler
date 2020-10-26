package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.CodePosition;

public class ReturnStatementNode extends StatementNode{
    private final String variableName;

    private CodePosition codePosition;

    public ReturnStatementNode(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableName() {
        return variableName;
    }

    @Override
    public String prettyPrint(int indentation) {
        StringBuilder sb = new StringBuilder();

        sb.append("return ");
        sb.append(variableName);
        sb.append(";");

        return sb.toString();
    }

    @Override
    public void setCodePosition(CodePosition codePosition) { this.codePosition = codePosition; }

    @Override
    public CodePosition getCodePosition() {
        return codePosition;
    }
}
