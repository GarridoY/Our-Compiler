package dk.aau.cs.d703e20.codegen.arduino.structure;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.statements.VariableDeclarationNode;
import dk.aau.cs.d703e20.ast.structure.FunctionDeclarationNode;

import java.util.List;

public class ArduinoProgramNode implements ASTNode {
    private final List<VariableDeclarationNode> variableDeclarationNodes;
    private final ArduinoSetupNode setupNode;
    private final ArduinoLoopNode loopNode;
    private final List<FunctionDeclarationNode> functionDeclarationNodes;

    private CodePosition codePosition;

    public ArduinoProgramNode(List<VariableDeclarationNode> variableDeclarationNodes, ArduinoSetupNode setupNode, ArduinoLoopNode loopNode, List<FunctionDeclarationNode> functionDeclarationNodes) {
        this.variableDeclarationNodes = variableDeclarationNodes;
        this.setupNode = setupNode;
        this.loopNode = loopNode;
        this.functionDeclarationNodes = functionDeclarationNodes;
    }

    public List<VariableDeclarationNode> getVariableDeclarationNodes() {
        return variableDeclarationNodes;
    }

    public ArduinoSetupNode getSetupNode() {
        return setupNode;
    }

    public ArduinoLoopNode getLoopNode() {
        return loopNode;
    }

    public List<FunctionDeclarationNode> getFunctionDeclarationNodes() {
        return functionDeclarationNodes;
    }

    @Override
    public String prettyPrint(int indentation) {
        StringBuilder sb = new StringBuilder();

        for (VariableDeclarationNode varDecl : variableDeclarationNodes) {
            sb.append(varDecl.prettyPrint(indentation));
            sb.append("\n");
        }
        sb.append("\n");
        sb.append(setupNode.prettyPrint(indentation));
        sb.append("\n\n");
        sb.append(loopNode.prettyPrint(indentation));
        sb.append("\n\n");
        for (FunctionDeclarationNode funcDecl : functionDeclarationNodes) {
            sb.append(funcDecl.prettyPrint(indentation));
            sb.append("\n\n");
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
