package dk.aau.cs.d703e20.ast.expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubscriptNode {

    String variableName;
    int index;

    public SubscriptNode (String text) {
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
}
