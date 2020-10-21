package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.expressions.ArithExpressionNode;

import java.util.Arrays;
import java.util.List;

public class AssignArrayNode extends StatementNode {
    private final String variableName;
    private List<ArithExpressionNode> arithExpressionNodes;
    private List<String> literals;

    // TODO: look into generify
    public AssignArrayNode(String variableName, List<Object> nodes, Boolean isLiteral) {
        this.variableName = variableName;
        if (isLiteral)
            this.literals = (List<String>)(List<?>) nodes; // Weird cast but ok
        else
            this.arithExpressionNodes = (List<ArithExpressionNode>)(List<?>) nodes;
    }

    public String getVariableName() {
        return variableName;
    }

    public List<ArithExpressionNode> getArithExpressionNodes() {
        return arithExpressionNodes;
    }

    public List<String> getLiterals() {
        return literals;
    }

    @Override
    public String prettyPrint(int indentation) {
        return null;
    }

    @Override
    public void setCodePosition(CodePosition codePosition) {

    }

    @Override
    public CodePosition getCodePosition() {
        return null;
    }
}
