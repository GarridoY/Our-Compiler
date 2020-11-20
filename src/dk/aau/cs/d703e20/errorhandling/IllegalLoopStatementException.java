package dk.aau.cs.d703e20.errorhandling;

import dk.aau.cs.d703e20.ast.CodePosition;

public class IllegalLoopStatementException extends CompilerException{
    public IllegalLoopStatementException(CodePosition codePosition) {
        super("ERROR: Illegal statement (non-declaration statement found) in Loop", codePosition);
    }
}
