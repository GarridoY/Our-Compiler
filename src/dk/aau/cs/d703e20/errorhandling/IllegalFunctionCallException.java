package dk.aau.cs.d703e20.errorhandling;

import dk.aau.cs.d703e20.ast.CodePosition;

public class IllegalFunctionCallException extends CompilerException {
    public IllegalFunctionCallException(String functionName, CodePosition codePosition) {
        super("ERROR: wrong argument type found when calling " + functionName + ".", codePosition);
    }
}
