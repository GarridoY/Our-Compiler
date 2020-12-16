package dk.aau.cs.d703e20.ast.expressions;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubscriptNode implements ASTNode {
    private final String variableName;
    private final int index;

    private CodePosition codePosition;

    public SubscriptNode(String text) {
        Pattern pattern = Pattern.compile("(.+?)\\[(.+?)\\]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        matcher.matches();

        variableName = matcher.group(1);
        index = Integer.parseInt(matcher.group(2));
    }

    public String getVariableName() {
        return variableName;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String prettyPrint(int indentation) {
        return variableName + "[" + index + "]";
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
