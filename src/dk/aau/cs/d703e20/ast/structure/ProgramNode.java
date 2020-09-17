package dk.aau.cs.d703e20.ast.structure;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;

import java.util.List;

public class ProgramNode implements ASTNode {
    private final MainNode mainNode;
    private final List<FunctionDeclarationNode> functionDeclarationNode;

    private CodePosition codePosition;

    public ProgramNode(MainNode mainNode, List<FunctionDeclarationNode> functionDeclarationNode) {
        this.mainNode = mainNode;
        this.functionDeclarationNode = functionDeclarationNode;
    }

    public MainNode getMainNode() {
        return mainNode;
    }

    public List<FunctionDeclarationNode> getFunctionDeclarationNode() {
        return functionDeclarationNode;
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
