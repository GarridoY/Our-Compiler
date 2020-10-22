package dk.aau.cs.d703e20.semantics;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.statements.AssignmentNode;
import dk.aau.cs.d703e20.ast.statements.StatementNode;
import dk.aau.cs.d703e20.ast.statements.VariableDeclarationNode;
import dk.aau.cs.d703e20.ast.structure.*;

import java.util.*;

public class TypeChecking {

    private Stack<HashMap<String, ASTNode>> hashMapStack;
    private Integer functionCounter = 1;
    private FunctionDeclarationNode currentFuncNode;

    private ArrayList<String> lis;
    private HashMap<String, Enums.DataType> predefinedFunctions;
    private ArrayList<VariableDeclarationNode> listOfPredefinedVariables;
    private ArrayList<Enums.BoolOperator> boolOperatorList;
    private ArrayList<Enums.ArithOperator> arithOperatorList;

    public TypeChecking() {
        HashMap<String, ASTNode> newSymbolTable = new HashMap<>();
        this.hashMapStack.push(newSymbolTable);
    }

    private void openScope(){
        HashMap<String, ASTNode> newSymbolTable = new HashMap<>();
        this.hashMapStack.push(newSymbolTable);
    }

    private void closeScope() { this.hashMapStack.pop(); }

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

    // TODO retrieveAllFunctions?
    // TODO retrieveAllVariables?

    public void printSymbolTable() {
        System.out.println("Symbol table:\n----------------------------------");
        System.out.println("Size of stack: " + hashMapStack.size());
        for (HashMap<String, ASTNode> hashMap : hashMapStack) {
            for (Map.Entry<String, ASTNode> entry : hashMap.entrySet()) {
                System.out.println(entry);
            }
        }
        System.out.println("----------------------------------");
    }

    /*      VISITOR         */
    public void visitProgram(ProgramNode programNode){
        openScope();
        visitSetup(programNode.getSetupNode());
        visitLoop(programNode.getLoopNode());
        visitFunctions(programNode.getFunctionDeclarationNodes());
    }

    public void visitSetup(SetupNode setupNode) {
        visitBlock(setupNode.getBlockNode());
    }

    public void visitLoop(LoopNode loopNode) {
        visitBlock(loopNode.getBlockNode());
    }

    public void visitBlock(BlockNode blockNode) {
        openScope();

        closeScope();
    }

    public void visitStatement(StatementNode statementNode) {

    }

    public void visitFunctions(List<FunctionDeclarationNode> functionDeclarationNodes) {
        for (FunctionDeclarationNode functionDeclaration : functionDeclarationNodes) {
            visitFunctionDeclaration(functionDeclaration);
        }

        for (FunctionDeclarationNode functionDeclaration : functionDeclarationNodes) {
            // functionDeclaration.getDataType() or functionDeclaration.getReturnType()?
            visitFunctionBlock(functionDeclaration.getBlockNode(), functionDeclaration.getDataType(), functionDeclaration);
        }
    }

    private void visitFunctionDeclaration(FunctionDeclarationNode function) {

    }

    private void visitFunctionBlock(BlockNode blockNode, Enums.DataType returnType, FunctionDeclarationNode functionDeclarationNode) {

    }


    private void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {

    }

    private void visitAssignment(AssignmentNode assignmentNode) {

    }
}
