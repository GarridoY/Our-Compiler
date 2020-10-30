package dk.aau.cs.d703e20.ast.errorhandling;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;

public class IncorrectReturnTypeException extends CompilerException {

    public IncorrectReturnTypeException(CodePosition codePosition) {
        super("ERROR: Incorrect return type.", codePosition);
    }

    public IncorrectReturnTypeException(Enums.DataType expectedType, Enums.DataType actualType) {
        super("ERROR: Incorrect return type. Expected " + expectedType + ", got " + actualType);
    }

    public IncorrectReturnTypeException(Enums.DataType expectedType, Enums.DataType actualType, CodePosition codePosition) {
        super("ERROR: Incorrect return type. Expected " + expectedType + ", got " + actualType, codePosition);
    }
}