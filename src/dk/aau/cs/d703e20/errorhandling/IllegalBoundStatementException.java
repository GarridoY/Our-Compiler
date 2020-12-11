package dk.aau.cs.d703e20.errorhandling;

import dk.aau.cs.d703e20.ast.CodePosition;

public class IllegalBoundStatementException extends CompilerException{
    public IllegalBoundStatementException(CodePosition codePosition) {
        super("ERROR: Illegal condition in bound statement.", codePosition);
    }
}
