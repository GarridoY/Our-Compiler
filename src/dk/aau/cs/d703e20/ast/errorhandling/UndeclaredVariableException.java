package dk.aau.cs.d703e20.ast.errorhandling;

import dk.aau.cs.d703e20.ast.CodePosition;

public class UndeclaredVariableException extends CompilerException {

    public UndeclaredVariableException(CodePosition codePosition) {
        super("ERROR: Variable has not been declared.", codePosition);
    }

    public UndeclaredVariableException(String variableName) {
        super("ERROR: " + variableName + " has not been declared.");
    }

    public UndeclaredVariableException(String variableName, CodePosition codePosition) {
        super("ERROR: " + variableName + " has not been declared.", codePosition);
    }
}
