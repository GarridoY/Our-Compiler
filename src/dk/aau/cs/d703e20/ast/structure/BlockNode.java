package dk.aau.cs.d703e20.ast.structure;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.statements.StatementNode;

import java.util.List;

public class BlockNode implements ASTNode {
    private final List<StatementNode> statementNodes;

    private CodePosition codePosition;

    public BlockNode(List<StatementNode> statementNodes) {
        this.statementNodes = statementNodes;
    }

    public List<StatementNode> getStatementNodes() {
        return statementNodes;
    }

    @Override
    public String prettyPrint(int indentation) {
        return null;
    }

    @Override
    public void setCodePosition(CodePosition codePosition) {
        this.codePosition = codePosition;
    }

    @Override
    public CodePosition getCodePosition() {
        return codePosition;
    }
}
