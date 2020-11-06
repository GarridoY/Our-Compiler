package dk.aau.cs.d703e20.ast.errorhandling;

import dk.aau.cs.d703e20.ast.CodePosition;

public class IllegalAtExpressionException extends CompilerException {

    public IllegalAtExpressionException(CodePosition codePosition) {
        super("ERROR: Illegal operand in at statement.", codePosition);
    }
}
