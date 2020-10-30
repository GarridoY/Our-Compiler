package dk.aau.cs.d703e20.ast.errorhandling;

import dk.aau.cs.d703e20.ast.CodePosition;

public class ArraySizeExceedsException extends CompilerException {
    public ArraySizeExceedsException(String variableName, CodePosition codePosition) {
        super("ERROR: Size exceeded in Array declaration " + variableName + ".", codePosition);
    }
}