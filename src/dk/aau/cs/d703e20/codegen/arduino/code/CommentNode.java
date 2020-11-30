package dk.aau.cs.d703e20.codegen.arduino.code;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.statements.StatementNode;

public class CommentNode extends StatementNode {
    private String comment;

    private CodePosition codePosition;

    public CommentNode (String comment) {
        this.comment = comment;
    }

    @Override
    public String prettyPrint(int indentation) {
        StringBuilder sb = new StringBuilder();

        sb.append("//");
        sb.append(comment);

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
