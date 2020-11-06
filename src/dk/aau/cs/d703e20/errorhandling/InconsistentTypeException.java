package dk.aau.cs.d703e20.errorhandling;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;

public class InconsistentTypeException extends CompilerException {

    public InconsistentTypeException(CodePosition codePosition) {
        super("ERROR: Inconsistent types.", codePosition);
    }

    public InconsistentTypeException(String variableName) {
        super("ERROR: " + variableName + " declaration contains inconsistent types.");
    }

    public InconsistentTypeException(String variableName, CodePosition codePosition) {
        super("ERROR: " + variableName + " declaration contains inconsistent types.", codePosition);
    }

    public InconsistentTypeException(CodePosition codePosition, Enums.DataType expectedType, Enums.DataType actualType) {
        super("ERROR: Inconsistent types. Expected " + expectedType + ", got " + actualType, codePosition);
    }

    public InconsistentTypeException(String variableName, Enums.DataType expectedType, Enums.DataType actualType) {
        super("ERROR: " + variableName + " declaration contains inconsistent types. Expected " + expectedType + ", got " + actualType);
    }

    public InconsistentTypeException(String variableName, CodePosition codePosition, Enums.DataType expectedType, Enums.DataType actualType) {
        super("ERROR: " + variableName + " declaration contains inconsistent types. Expected " + expectedType + ", got " + actualType, codePosition);
    }
}
