package dk.aau.cs.d703e20.ast.errorhandling;

import dk.aau.cs.d703e20.ast.CodePosition;

public class VariableAlreadyDeclaredException extends CompilerException {

    public VariableAlreadyDeclaredException(CodePosition codePosition) {
        super("ERROR: Variable already declared.", codePosition);
    }

    public VariableAlreadyDeclaredException(String variableName) {
        super("ERROR: " + variableName + " is already declared.");
    }

    public VariableAlreadyDeclaredException(String variableName, CodePosition codePosition) {
        super("ERROR: " + variableName + " is already declared.", codePosition);
    }
}
