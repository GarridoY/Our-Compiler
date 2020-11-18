package dk.aau.cs.d703e20.errorhandling;

import dk.aau.cs.d703e20.ast.CodePosition;

public class IllegalSetupStatementException extends CompilerException {

    public IllegalSetupStatementException(CodePosition codePosition) {
        super("ERROR: Illegal statement (non-declaration statement found) in Setup", codePosition);
    }
}
