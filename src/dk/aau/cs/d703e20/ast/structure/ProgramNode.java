package dk.aau.cs.d703e20.ast.structure;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;

import java.util.List;

public class ProgramNode implements ASTNode {
    private final SetupNode setupNode;
    private final LoopNode loopNode;
    private final List<FunctionDeclarationNode> functionDeclarationNodes;

    private CodePosition codePosition;

    public ProgramNode(SetupNode setupNode, LoopNode loopNode, List<FunctionDeclarationNode> functionDeclarationNodes) {
        this.setupNode = setupNode;
        this.loopNode = loopNode;
        this.functionDeclarationNodes = functionDeclarationNodes;
    }

    public SetupNode getSetupNode() {
        return setupNode;
    }

    public LoopNode getLoopNode() {
        return loopNode;
    }

    public List<FunctionDeclarationNode> getFunctionDeclarationNodes() {
        return functionDeclarationNodes;
    }

    @Override
    public String prettyPrint(int indentation) {
        StringBuilder sb = new StringBuilder();

        sb.append(setupNode.prettyPrint(indentation));
        sb.append("\n");
        sb.append(loopNode.prettyPrint(indentation));
        sb.append("\n");
        for (FunctionDeclarationNode funcDecl : functionDeclarationNodes) {
            sb.append(funcDecl.prettyPrint(indentation));
            sb.append("\n");
        }

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
