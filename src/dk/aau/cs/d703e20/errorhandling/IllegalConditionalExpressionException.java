package dk.aau.cs.d703e20.errorhandling;

import dk.aau.cs.d703e20.ast.CodePosition;

public class IllegalConditionalExpressionException extends CompilerException {

    public IllegalConditionalExpressionException(CodePosition codePosition) {
        super("ERROR: Illegal conditional expression with inconsistent type.", codePosition);
    }
}
