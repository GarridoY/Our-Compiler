package dk.aau.cs.d703e20.ast.structure;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.statements.FunctionCallNode;
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
        indentation++;
        StringBuilder sb = new StringBuilder();

        sb.append("{\n");
        for (StatementNode statementNode : statementNodes) {
            for (int i = 0; i < indentation; i++)
                sb.append("\t");

            sb.append(statementNode.prettyPrint(indentation));

            if (statementNode instanceof FunctionCallNode)
                sb.append(";");

            sb.append("\n");
        }

        indentation--;
        for (int i = 0; i < indentation; i++)
            sb.append("\t");
        sb.append("}");

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
