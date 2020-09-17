package dk.aau.cs.d703e20.ast;

public interface ASTNode {
    String prettyPrint(int indentation);

    void setCodePosition(CodePosition codePosition);
    CodePosition getCodePosition();
}

