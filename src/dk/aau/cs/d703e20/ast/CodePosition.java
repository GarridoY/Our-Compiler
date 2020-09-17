package dk.aau.cs.d703e20.ast;

public class CodePosition {
    private final int lineNumber;
    private final int columnNumber;

    public CodePosition(int lineNumber, int columnNumber) {
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    @Override
    public String toString() {
        return getLineNumber() + ":" + getColumnNumber();
    }
}