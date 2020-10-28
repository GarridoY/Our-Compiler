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

    /*      VISITOR       */
    public void visitProgram(ProgramNode programNode){
        openScope();
        visitSetup(programNode.getSetupNode());
        visitLoop(programNode.getLoopNode());
        visitFunctions(programNode.getFunctionDeclarationNodes());
    }

    private void visitSetup(SetupNode setupNode) {
        visitBlock(setupNode.getBlockNode());
    }

    private void visitLoop(LoopNode loopNode) {
        visitBlock(loopNode.getBlockNode());
    }

    private void visitBlock(BlockNode blockNode) {
        openScope();
        for (StatementNode statement : blockNode.getStatementNodes()) {
            visitStatement(statement);
        }
        closeScope();
    }

    private void visitStatement(StatementNode statementNode) {
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
        }

        if (retrieveSymbol(variableDeclarationNode.getAssignmentNode().getVariableName()) != null && retrieveSymbol(variableDeclarationNode.getAssignmentNode().getVariableName()) instanceof  VariableDeclarationNode)
            retrievedNode = (VariableDeclarationNode) retrieveSymbol(variableDeclarationNode.getAssignmentNode().getVariableName());

        if (retrieveSymbol(variableDeclarationNode.getAssignArrayNode().getVariableName()) != null && retrieveSymbol(variableDeclarationNode.getAssignArrayNode().getVariableName()) instanceof  VariableDeclarationNode)
            retrievedNode = (VariableDeclarationNode) retrieveSymbol(variableDeclarationNode.getAssignArrayNode().getVariableName());

        if (retrievedNode == null) {
            if (variableDeclarationNode.getAssignmentNode().getVariableName() != null)
                enterSymbol(variableDeclarationNode.getAssignmentNode().getVariableName(), variableDeclarationNode);
            else throw new CompilerException("ERROR: A variable (" + variableDeclarationNode.getAssignmentNode().getVariableName() + ") with the same name already exists.", retrievedNode.getCodePosition());

            if (variableDeclarationNode.getAssignArrayNode().getVariableName() != null)
                enterSymbol(variableDeclarationNode.getAssignArrayNode().getVariableName(), variableDeclarationNode);
            else throw new CompilerException("ERROR: A array variable (" + variableDeclarationNode.getAssignArrayNode().getVariableName() + ") with the same name already exists.", retrievedNode.getCodePosition());

            if (variableDeclarationNode.getVariableName() != null)
                enterSymbol(variableDeclarationNode.getVariableName(), variableDeclarationNode);
            else throw new CompilerException("ERROR: A variable (" + variableDeclarationNode.getVariableName() + ") with the same name already exists.", retrievedNode.getCodePosition());
        }
        if (variableDeclarationNode.getAssignmentNode() != null) visitAssignment(variableDeclarationNode.getAssignmentNode());
        if (variableDeclarationNode.getAssignArrayNode() != null) visitAssignArray(variableDeclarationNode.getAssignArrayNode());
    }

    private void visitAssignment(AssignmentNode assignmentNode) {
        String variableName;
        Enums.DataType dataType;

        if (assignmentNode.getVariableName() != null) {
            VariableDeclarationNode variableDeclarationNode = null;
            variableName = assignmentNode.getVariableName();
            if (retrieveSymbol(variableName) instanceof VariableDeclarationNode)
                variableDeclarationNode = (VariableDeclarationNode) retrieveSymbol(variableName);

            if (variableDeclarationNode != null) dataType = variableDeclarationNode.getDataType();
            else throw new CompilerException("ERROR: Variable (" + variableName + ") on left side of assignment is not declared.", assignmentNode.getCodePosition());

            Enums.DataType assignedDataType = null;
            if (assignmentNode.getLiteralValue() != null) { //is it a bool or string?
                assignedDataType = getDataTypeFromLiteral(assignmentNode.getLiteralValue());
            } else if (assignmentNode.getArithExpressionNode() != null) //is it a int or double?
                assignedDataType = visitArithmeticExpression(assignmentNode.getArithExpressionNode());

            if (dataType != null && assignedDataType != null && !assignedDataType.equals(dataType))
                throw new CompilerException("ERROR: Incompatible types. (" + dataType + " and " + assignedDataType + ")", assignmentNode.getCodePosition());
        }
    }

    private Enums.DataType visitArithmeticExpression(ArithExpressionNode arithExpressionNode) {
        if (arithExpressionNode.getVariableName() != null)
            return ((VariableDeclarationNode) retrieveSymbol(arithExpressionNode.getVariableName())).getDataType();
        else if (arithExpressionNode.getNumber() != null)
            return Enums.DataType.INT;
        else if (arithExpressionNode.getFunctionCallNode() != null)
            return ((FunctionDeclarationNode) retrieveSymbol(arithExpressionNode.getFunctionCallNode().getFunctionName())).getDataType();
        else if (arithExpressionNode.getArithExpressionNode2() != null) {
            Enums.DataType dataType1 = visitArithmeticExpression(arithExpressionNode.getArithExpressionNode1());
            Enums.DataType dataType2 = visitArithmeticExpression(arithExpressionNode.getArithExpressionNode2());
            if ((dataType1 != null && dataType2 != null) && dataType1 != dataType2)
                throw new CompilerException("ERROR: Incompatible types. (" + dataType1 + " and " + dataType2 + ")", arithExpressionNode.getCodePosition());
            else return dataType1;
        }
        return null;
    }

    private void visitAssignArray(AssignArrayNode assignArrayNode) {
        //int[] a = {1};
        //int[3] b;
        //int[6] c = {1, 3, 5, "asd"};

        String variableName;
        Enums.DataType dataType;

        if (assignArrayNode.getVariableName() != null) {
            VariableDeclarationNode variableDeclarationNode = null;
            variableName = assignArrayNode.getVariableName();
            if (retrieveSymbol(variableName) instanceof VariableDeclarationNode)
                variableDeclarationNode = (VariableDeclarationNode) retrieveSymbol(variableName);

            if (variableDeclarationNode != null) dataType = variableDeclarationNode.getDataType();
            else throw new CompilerException("ERROR: Array (" + variableName + ") is not declared.", assignArrayNode.getCodePosition());

            Enums.DataType assignedDataType = null;
            assignedDataType = getDataTypeFromLiteral(a)
        }
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

    private void visitBooleanExpression(BoolExpressionNode boolExpressionNode) {

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

    private Enums.DataType getDataTypeFromLiteral(String literal) {
        //TODO: do fancy regex to check type
        if (literal.equals("true") || literal.equals("false"))
            return Enums.DataType.BOOL;
        else if (literal.contains("\""))
            return Enums.DataType.STRING;
        else if (literal.contains("."))
            return Enums.DataType.DOUBLE;
        else return Enums.DataType.INT ;
        //return Enums.DataType.VOID;
    }
}
