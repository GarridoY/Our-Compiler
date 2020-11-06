package dk.aau.cs.d703e20.errorhandling;

import dk.aau.cs.d703e20.ast.CodePosition;

public class CompilerException extends RuntimeException {

    public CompilerException(String message) {
        super(message);
    }

    public CompilerException(String message, CodePosition codePosition) {
        super("Line " + codePosition.toString() + " - " + message);
    }
}
