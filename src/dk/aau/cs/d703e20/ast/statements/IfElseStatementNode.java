package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;

import java.util.List;

public class IfElseStatementNode extends StatementNode {
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
        StringBuilder sb = new StringBuilder();

        sb.append(ifStatementNode.prettyPrint(indentation));
        for (ElseIfStatementNode elseif : elseIfStatementNodes)
            sb.append(elseif.prettyPrint(indentation));
        if (elseStatementNode != null)
            sb.append(elseStatementNode.prettyPrint(indentation));

        return sb.toString();
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
