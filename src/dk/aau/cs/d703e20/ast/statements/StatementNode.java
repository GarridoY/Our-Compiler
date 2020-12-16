package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.ASTNode;

public abstract class StatementNode implements ASTNode {
    private boolean isBounded;

    public boolean isBounded() {
        return isBounded;
    }

    public void setBounded(boolean bounded) {
        isBounded = bounded;
    }

    @Override
    public String prettyPrint(int indentation) {
        return "STATEMENT";
    }
}
