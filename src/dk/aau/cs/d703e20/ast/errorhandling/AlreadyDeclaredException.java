package dk.aau.cs.d703e20.ast.errorhandling;

import dk.aau.cs.d703e20.ast.CodePosition;

public class AlreadyDeclaredException extends CompilerException {

    public AlreadyDeclaredException(CodePosition codePosition) {
        super("ERROR: variable already declared.", codePosition);
    }

    public AlreadyDeclaredException(String variableName) {
        super("ERROR: " + variableName + " is already declared.");
    }

    public AlreadyDeclaredException(String variableName, CodePosition codePosition) {
        super("ERROR: " + variableName + " is already declared.", codePosition);
    }
}
