package dk.aau.cs.d703e20.errorhandling;

import dk.aau.cs.d703e20.ast.CodePosition;

public class IllegalIterativeStatementException extends CompilerException{
    public IllegalIterativeStatementException(CodePosition codePosition) {
        super("Iterative statement not inside bound scope", codePosition);
    }
}
