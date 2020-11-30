package dk.aau.cs.d703e20.codegen.arduino.code;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.statements.StatementNode;

public class CodeNode extends StatementNode {
    private String code;

    private CodePosition codePosition;

    public CodeNode (String code) {
        this.code = code;
    }

    @Override
    public String prettyPrint(int indentation) {
        StringBuilder sb = new StringBuilder();

        sb.append(code);

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
