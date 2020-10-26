package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;

import java.beans.Statement;
import java.util.List;

public class IfElseStatementNode extends StatementNode implements ASTNode {
    private final IfStatementNode ifStatementNode;
    private final List<ElseIfStatementNode> elseIfStatementNodes;
    private final ElseStatementNode elseStatementNode;

    private CodePosition codePosition;

    public IfElseStatementNode(IfStatementNode ifStatementNode, List<ElseIfStatementNode> elseIfStatementNodes, ElseStatementNode elseStatementNode) {
        this.ifStatementNode = ifStatementNode;
        this.elseIfStatementNodes = elseIfStatementNodes;
        this.elseStatementNode = elseStatementNode;
    }

    public IfStatementNode getIfStatementNode() {
        return ifStatementNode;
    }

    public List<ElseIfStatementNode> getElseIfStatementNodes() {
        return elseIfStatementNodes;
    }

    public ElseStatementNode getElseStatement() {
        return elseStatementNode;
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
