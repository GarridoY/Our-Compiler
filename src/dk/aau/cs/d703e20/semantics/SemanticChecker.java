package dk.aau.cs.d703e20.semantics;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.structure.ProgramNode;

import java.util.HashMap;
import java.util.Stack;

public class SemanticChecker {
    private final Stack<HashMap<String, ASTNode>> hashMapStack;

    public SemanticChecker() {
        this.hashMapStack = new Stack<>();
    }

    private void openScope() {
        HashMap<String, ASTNode> newSymbolTable = new HashMap<>();
        this.hashMapStack.push(newSymbolTable);
    }

    private void closeScope() {
        hashMapStack.pop();
    }

    private void enterSymbol(String name, ASTNode object) {
        this.hashMapStack.peek().put(name, object);
    }

    private ASTNode retrieveSymbol(String name) {
        int stackLevel = this.hashMapStack.size() - 1;

        while (stackLevel >= 0) {
            if (this.hashMapStack.elementAt(stackLevel).get(name) != null)
                return this.hashMapStack.elementAt(stackLevel).get(name);
            else
                stackLevel -= 1;
        }

        return null;
    }

    /*      VISITOR         */
    public void visitProgram(ProgramNode programNode) {
        openScope();

        // TODO Visit function declarations.
        // TODO Visit Main
        // visitMain(programNode.getMainNode());
    }
}
