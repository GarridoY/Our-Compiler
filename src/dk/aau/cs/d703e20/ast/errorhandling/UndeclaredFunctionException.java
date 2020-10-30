package dk.aau.cs.d703e20.ast.errorhandling;

import dk.aau.cs.d703e20.ast.CodePosition;

public class UndeclaredFunctionException extends CompilerException {

    public UndeclaredFunctionException(CodePosition codePosition) {
        super("ERROR: Function has not been declared.", codePosition);
    }

    public UndeclaredFunctionException(String functionName) {
        super("ERROR: " + functionName + " has not been declared.");
    }

    public UndeclaredFunctionException(String functionName, CodePosition codePosition) {
        super("ERROR: " + functionName + " has not been declared.", codePosition);
    }
}
