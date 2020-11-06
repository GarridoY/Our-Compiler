package dk.aau.cs.d703e20.errorhandling;

import dk.aau.cs.d703e20.ast.CodePosition;

public class InvalidArrayException extends CompilerException {
    public InvalidArrayException(String variableName, int ExpectedArraySize, int ActualArraySize, CodePosition codePosition) {
        super("ERROR: Size exceeded in Array declaration " + variableName + ". Expected " + ExpectedArraySize + ", got " + ActualArraySize + ".", codePosition);
    }

    public InvalidArrayException(String variableName, int ArraySize, CodePosition codePosition) {
        super("ERROR: Invalid ArraySize " + variableName + "[" + ArraySize + "].", codePosition);
    }

    public InvalidArrayException(String vairableName, CodePosition codePosition) {
        super("ERROR: Invalid Array content of array variable " + vairableName + ".", codePosition);
    }

    public InvalidArrayException(CodePosition codePosition) {
        super("ERROR: Invalid Array declaration.", codePosition);
    }
}