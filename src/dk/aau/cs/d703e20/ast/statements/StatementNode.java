package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.ASTNode;

public abstract class StatementNode implements ASTNode {
    @Override
    public String prettyPrint(int indentation) {
        return "STATEMENT";
    }
}
