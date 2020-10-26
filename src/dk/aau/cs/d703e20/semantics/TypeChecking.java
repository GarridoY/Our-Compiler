package dk.aau.cs.d703e20.semantics;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.errorhandling.CompilerException;
import dk.aau.cs.d703e20.ast.expressions.ArithExpressionNode;
import dk.aau.cs.d703e20.ast.expressions.BoolExpressionNode;
import dk.aau.cs.d703e20.ast.statements.*;
import dk.aau.cs.d703e20.ast.structure.*;

import java.util.*;

public class TypeChecking {

    private Stack<HashMap<String, ASTNode>> hashMapStack;
    private Integer functionCounter = 1;
    private FunctionDeclarationNode currentFuncNode;

    private ArrayList<String> listOfPredefined;
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

    // TODO retrieveAllVariableDeclarations?

    private ArrayList<FunctionDeclarationNode> retrieveAllFunctions(String name) {
        ArrayList<FunctionDeclarationNode> functionDeclarations = new ArrayList<>();

        int stackLevel = this.hashMapStack.size() - 1;

        while (stackLevel >= 0) {
            if (this.hashMapStack.elementAt(stackLevel).get(name) != null) {
                if (this.hashMapStack.elementAt(stackLevel).get(name) instanceof FunctionDeclarationNode) {
                    functionDeclarations.add((FunctionDeclarationNode) this.hashMapStack.elementAt(stackLevel).get(name));
                    if (functionCounter != 1) {
                        for (int i = 1; i < functionCounter; i++) {
                            functionDeclarations.add((FunctionDeclarationNode) this.hashMapStack.elementAt(stackLevel).get(i + name));
                        }
                    }
                }
            }
            stackLevel -= 1;
        }
        return functionDeclarations;
    }

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
        for (StatementNode statement : blockNode.getStatementNodes()) {
            visitStatement(statement);
        }
        closeScope();
    }

    public void visitStatement(StatementNode statementNode) {
        if (statementNode instanceof VariableDeclarationNode) {
            visitVariableDeclaration((VariableDeclarationNode) statementNode);
        } else if (statementNode instanceof AssignmentNode) {
            visitAssignment((AssignmentNode) statementNode);
        } else if (statementNode instanceof PinDeclarationNode) {
            visitPinDeclaration((PinDeclarationNode) statementNode);
        } else if (statementNode instanceof FunctionCallNode) {
            visitFunctionCall((FunctionCallNode) statementNode);
        } else if (statementNode instanceof IfElseStatementNode) {
            visitIfElseStatement((IfElseStatementNode) statementNode);
        } else if (statementNode instanceof ForStatementNode) {
            visitForStatement((ForStatementNode) statementNode);
        } else if (statementNode instanceof WhileStatementNode) {
            visitWhileStatement((WhileStatementNode) statementNode);
        } else if (statementNode instanceof AtStatementNode) {
            visitAtStatement((AtStatementNode) statementNode);
        } else if (statementNode instanceof BoundStatementNode) {
            visitBoundStatement((BoundStatementNode) statementNode);
        } else if (statementNode instanceof ReturnStatementNode) {
            visitReturnStatement((ReturnStatementNode) statementNode);
        }
    }
    /*         STATEMENTS         */
    private void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
        VariableDeclarationNode retrievedNode = null;

        String variableName;
        String dataType;

        if (variableDeclarationNode.getVariableName() != null) {
            variableName = variableDeclarationNode.getVariableName();
            if (retrieveSymbol(variableName) instanceof VariableDeclarationNode)
                retrievedNode = (VariableDeclarationNode) retrieveSymbol(variableName);

            if (retrievedNode != null)
                dataType = retrievedNode.getDataType().toString();
            else dataType = null;

            if (retrieveSymbol(variableName) == null)
                throw new CompilerException("ERROR: Variable (" + variableName + ") is not declared.", retrievedNode.getCodePosition());

            if (dataType != null) {
                // TODO what do we check here?
            }
        }

        if (retrieveSymbol(variableDeclarationNode.getAssignmentNode().getVariableName()) != null && retrieveSymbol(variableDeclarationNode.getAssignmentNode().getVariableName()) instanceof  VariableDeclarationNode)
            retrievedNode = (VariableDeclarationNode) retrieveSymbol(variableDeclarationNode.getAssignmentNode().getVariableName());

        if (retrieveSymbol(variableDeclarationNode.getAssignArrayNode().getVariableName()) != null && retrieveSymbol(variableDeclarationNode.getAssignArrayNode().getVariableName()) instanceof  VariableDeclarationNode)
            retrievedNode = (VariableDeclarationNode) retrieveSymbol(variableDeclarationNode.getAssignArrayNode().getVariableName());

        if (retrievedNode == null) enterSymbol(variableDeclarationNode.getAssignmentNode().getVariableName(), variableDeclarationNode);
        else throw new CompilerException("ERROR: A variable (" + variableDeclarationNode.getAssignmentNode().getVariableName() + ") with the same name already exists.", retrievedNode.getCodePosition());

        if (retrievedNode == null) enterSymbol(variableDeclarationNode.getAssignArrayNode().getVariableName(), variableDeclarationNode);
        else throw new CompilerException("ERROR: A array variable (" + variableDeclarationNode.getAssignArrayNode().getVariableName() + ") with the same name already exists.", retrievedNode.getCodePosition());

        if (retrievedNode == null) enterSymbol(variableDeclarationNode.getVariableName(), variableDeclarationNode);
        else throw new CompilerException("ERROR: A variable (" + variableDeclarationNode.getVariableName() + ") with the same name already exists.", retrievedNode.getCodePosition());

        if (variableDeclarationNode.getAssignmentNode() != null) visitAssignment(variableDeclarationNode.getAssignmentNode());

        if (variableDeclarationNode.getAssignArrayNode() != null) visitAssignArray(variableDeclarationNode.getAssignArrayNode());
    }

    private void visitAssignment(AssignmentNode assignmentNode) {
        String variableName;
        String dataType;

        if (assignmentNode.getVariableName() != null) {
            VariableDeclarationNode variableDeclarationNode = null;
            variableName = assignmentNode.getVariableName();
            if (retrieveSymbol(variableName) instanceof VariableDeclarationNode)
                variableDeclarationNode = (VariableDeclarationNode) retrieveSymbol(variableName);

            if (variableDeclarationNode != null)
                dataType = variableDeclarationNode.getDataType().toString();
            else dataType = null;

            if (retrieveSymbol(variableName) == null)
                throw new CompilerException("ERROR: Variable (" + variableName + ") on left side of assignment is not declared.", assignmentNode.getCodePosition());

            if (assignmentNode.getArithExpressionNode() != null) {
                String assignedDataType = null;
                /*
                if (assignmentNode.getLiteralValue() != null) {
                    if (assignmentNode.getLiteralValue())
                    assignedDataType = Enums.DataType.BOOL.toString();
                } else ()
                if (dataType != null && assignedDataType != null && !assignedDataType.equals(dataType))
                    this
                 * */
            }

        }
    }

    private void visitAssignArray(AssignArrayNode assignArrayNode) {

    }

    private void visitPinDeclaration(PinDeclarationNode pinDeclarationNode) {

    }

    private void visitFunctionCall(FunctionCallNode functionCallNode) {

    }

    private void visitIfElseStatement(IfElseStatementNode ifElseStatementNode) {

    }

    private void visitForStatement(ForStatementNode forStatementNode) {

    }

    private void visitWhileStatement(WhileStatementNode whileStatementNode) {

    }

    private void visitAtStatement(AtStatementNode atStatementNode) {

    }

    private void visitBoundStatement(BoundStatementNode boundStatementNode) {

    }

    private void visitReturnStatement(ReturnStatementNode returnStatementNode) {

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



}
