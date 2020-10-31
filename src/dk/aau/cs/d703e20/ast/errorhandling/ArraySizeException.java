package dk.aau.cs.d703e20.ast.errorhandling;

import dk.aau.cs.d703e20.ast.CodePosition;

public class ArraySizeException extends CompilerException {
    public ArraySizeException(String variableName, CodePosition codePosition) {
        super("ERROR: Size exceeded in Array declaration " + variableName + ".", codePosition);
    }

    public ArraySizeException(String variableName, int ArraySize, CodePosition codePosition) {
        super("ERROR: Invalid ArraySize " + variableName + "[" + ArraySize + "].", codePosition);
    }
}