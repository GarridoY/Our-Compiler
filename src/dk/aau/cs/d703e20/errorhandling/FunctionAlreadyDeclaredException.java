package dk.aau.cs.d703e20.errorhandling;

import dk.aau.cs.d703e20.ast.CodePosition;

public class FunctionAlreadyDeclaredException extends CompilerException {

    public FunctionAlreadyDeclaredException(CodePosition codePosition) {
        super("ERROR: Function already declared.", codePosition);
    }

    public FunctionAlreadyDeclaredException(String functionName) {
        super("ERROR: " + functionName + " is already declared.");
    }

    public FunctionAlreadyDeclaredException(String functionName, CodePosition codePosition) {
        super("ERROR: " + functionName + " is already declared.", codePosition);
    }
}
