package dk.aau.cs.d703e20.ast.errorhandling;

import dk.aau.cs.d703e20.ast.CodePosition;

public class IllegalOperandException extends CompilerException {

    public IllegalOperandException(CodePosition codePosition) {
        super("ERROR: Illegal operand in boolean expression.", codePosition);
    }

    public IllegalOperandException(String operand, CodePosition codePosition) {
        super("ERROR: Illegal operand in boolean expression. (" + operand + ")", codePosition);
    }
}
