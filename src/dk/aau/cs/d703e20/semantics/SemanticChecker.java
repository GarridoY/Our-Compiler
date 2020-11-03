package dk.aau.cs.d703e20.semantics;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.errorhandling.*;
import dk.aau.cs.d703e20.ast.expressions.*;
import dk.aau.cs.d703e20.ast.statements.*;
import dk.aau.cs.d703e20.ast.structure.*;

import java.util.*;

public class SemanticChecker {

    private Stack<HashMap<String, ASTNode>> hashMapStack = new Stack<>();

    public SemanticChecker() {
        HashMap<String, ASTNode> newSymbolTable = new HashMap<>();
        this.hashMapStack.push(newSymbolTable);

        // Add standard functions to symbol table
        enterFunction(
            new FunctionDeclarationNode(
                Enums.DataType.VOID,
                "delay",
                new BlockNode(new ArrayList<StatementNode>()),
                new ArrayList<>(Arrays.asList(
                    new FunctionParameterNode(Enums.DataType.INT, "ms")
                ))
        ));
    }

    private void openScope(){
        HashMap<String, ASTNode> newSymbolTable = new HashMap<>();
        this.hashMapStack.push(newSymbolTable);
    }

    private void closeScope() { this.hashMapStack.pop(); }

    private void enterSymbol(String name, ASTNode object) {
        this.hashMapStack.peek().put(name, object);
    }

    private void enterFunction(FunctionDeclarationNode functionDeclarationNode) {
        enterSymbol(functionDeclarationNode.getFunctionName(), functionDeclarationNode);
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
        visitFunctions(programNode.getFunctionDeclarationNodes());
        visitSetup(programNode.getSetupNode());
        visitLoop(programNode.getLoopNode());
        closeScope();
    }

    private void visitSetup(SetupNode setupNode) {
        visitBlock(setupNode.getBlockNode());
    }

    private void visitLoop(LoopNode loopNode) {
        visitBlock(loopNode.getBlockNode());
    }

    public void visitBlock(BlockNode blockNode) {
        openScope();
        for (StatementNode statement : blockNode.getStatementNodes()) {
            visitStatement(statement);
        }
        closeScope();
    }

    private void visitStatement(StatementNode statementNode) {
        if (statementNode instanceof VariableDeclarationNode)
            visitVariableDeclaration((VariableDeclarationNode) statementNode);
        else if (statementNode instanceof AssignmentNode)
            visitAssignment((AssignmentNode) statementNode);
        else if (statementNode instanceof PinDeclarationNode)
            visitPinDeclaration((PinDeclarationNode) statementNode);
        else if (statementNode instanceof FunctionCallNode)
            visitFunctionCall((FunctionCallNode) statementNode);
        else if (statementNode instanceof IfElseStatementNode)
            visitIfElseStatement((IfElseStatementNode) statementNode);
        else if (statementNode instanceof ForStatementNode)
            visitForStatement((ForStatementNode) statementNode);
        else if (statementNode instanceof WhileStatementNode)
            visitWhileStatement((WhileStatementNode) statementNode);
        else if (statementNode instanceof AtStatementNode)
            visitAtStatement((AtStatementNode) statementNode);
        else if (statementNode instanceof BoundStatementNode)
            visitBoundStatement((BoundStatementNode) statementNode);
        else
            throw new CompilerException("Unknown statement");
    }

    /*         STATEMENTS         */
    public void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
        Enums.DataType dataType = variableDeclarationNode.getDataType();
        String variableName = variableDeclarationNode.getVariableName();

        // Check if variable is already in symbol table
        if (retrieveSymbol(variableName) == null)
        {
            // Variable assignment rule
            if (variableDeclarationNode.getAssignmentNode() != null) {
                Enums.DataType assignmentDataType = visitAssignment(variableDeclarationNode.getAssignmentNode());

                if (assignmentDataType != dataType)
                    throw new InconsistentTypeException(variableDeclarationNode.getVariableName(), variableDeclarationNode.getCodePosition(), dataType, assignmentDataType);
                else
                    enterSymbol(variableDeclarationNode.getAssignmentNode().getVariableName(), variableDeclarationNode);
            }
            // Array assignment rule
            else if (variableDeclarationNode.getAssignArrayNode() != null) {
                Enums.DataType arrayDataType = visitAssignArray(variableDeclarationNode.getAssignArrayNode());

                if (arrayDataType != Enums.dataTypeFromDatatype(dataType)) {
                    throw new InconsistentTypeException(variableDeclarationNode.getVariableName(), variableDeclarationNode.getCodePosition());
                }
                else
                    enterSymbol(variableDeclarationNode.getAssignArrayNode().getVariableName(), variableDeclarationNode);

                List<ArrayParamNode> arrayParamNodes = variableDeclarationNode.getAssignArrayNode().getParamNodes();
                if (variableDeclarationNode.getAllocatedSize() < arrayParamNodes.size())
                    throw new InvalidArrayException(variableName, variableDeclarationNode.getAllocatedSize(), arrayParamNodes.size(), variableDeclarationNode.getCodePosition());

            }
            // Variable name rule
            else {
                enterSymbol(variableDeclarationNode.getVariableName(), variableDeclarationNode);
            }
        }
        else
            throw new VariableAlreadyDeclaredException(variableName, variableDeclarationNode.getCodePosition());
    }

    private Enums.DataType visitAssignment(AssignmentNode assignmentNode) {
        Enums.DataType dataType;

        // Arith expression
        if (assignmentNode.getArithExpressionNode() != null) {
            dataType = visitArithmeticExpression(assignmentNode.getArithExpressionNode());
            return dataType;
        }
        // Literal
        else {
            dataType = getDataTypeFromLiteral(assignmentNode.getLiteralValue());
            return dataType;
        }
    }

    private Enums.DataType visitArithmeticExpression(ArithExpressionNode arithExpressionNode) {
        // Variable name rule
        if (arithExpressionNode.getVariableName() != null) {
            ASTNode declaration = retrieveSymbol(arithExpressionNode.getVariableName());
            if (declaration != null)
                return ((VariableDeclarationNode) declaration).getDataType();
            else
                throw new UndeclaredVariableException(arithExpressionNode.getVariableName(), arithExpressionNode.getCodePosition());
        }
        // Num literal rule
        else if (arithExpressionNode.getNumber() != null) {
            return getDataTypeFromLiteral(arithExpressionNode.getNumber());
        }
        // Function call rule
        else if (arithExpressionNode.getFunctionCallNode() != null) {
            ASTNode declaration = retrieveSymbol(arithExpressionNode.getFunctionCallNode().getFunctionName());
            if (declaration != null)
                return ((FunctionDeclarationNode) declaration).getDataType();
            else
                throw new UndeclaredFunctionException(arithExpressionNode.getFunctionCallNode().getFunctionName(), arithExpressionNode.getCodePosition());
        }
        // Expression Operand Expression rule
        else if (arithExpressionNode.getArithExpressionNode2() != null) {
            Enums.DataType dataType1 = visitArithmeticExpression(arithExpressionNode.getArithExpressionNode1());
            Enums.DataType dataType2 = visitArithmeticExpression(arithExpressionNode.getArithExpressionNode2());
            if ((dataType1 != null && dataType2 != null) && dataType1 != dataType2)
                throw new InconsistentTypeException(arithExpressionNode.getVariableName(), arithExpressionNode.getCodePosition(), dataType1, dataType2);
            else return dataType1;
        }
        return null;
    }

    // TODO: Contains Errors
    private Enums.DataType visitAssignArray(AssignArrayNode assignArrayNode) {
        String variableName = assignArrayNode.getVariableName();
        Enums.DataType assignedDataType = null;

        if (variableName != null) {
            for (ArrayParamNode arrayParam : assignArrayNode.getParamNodes()){
                if (assignedDataType == null) {
                    assignedDataType = visitArrayParameters(arrayParam);
                } else if (visitArrayParameters(arrayParam) != assignedDataType){
                    throw new InconsistentTypeException(assignArrayNode.getVariableName(), assignArrayNode.getCodePosition());
                }
            }
        }
        return assignedDataType;
    }

    private Enums.DataType visitArrayParameters(ArrayParamNode arrayParamNode) {
        if (arrayParamNode.getArithExpressionNode() != null)
            return visitArithmeticExpression(arrayParamNode.getArithExpressionNode());
        else return getDataTypeFromLiteral(arrayParamNode.getLiteral());
    }

    private void visitPinDeclaration(PinDeclarationNode pinDeclarationNode) {
        PinDeclarationNode retrievedNode = null;

        Enums.PinType pinType = pinDeclarationNode.getPinType();
        String variableName = pinDeclarationNode.getVariableName();
        String pinNumber = pinDeclarationNode.getPinNumber();

        if (retrieveSymbol(variableName) != null)
            throw new VariableAlreadyDeclaredException(variableName, pinDeclarationNode.getCodePosition());
        else
            enterSymbol(pinDeclarationNode.getVariableName(), pinDeclarationNode);
    }

    public Enums.DataType visitFunctionCall(FunctionCallNode functionCallNode) {
        ASTNode declaration = retrieveSymbol(functionCallNode.getFunctionName());
        if (declaration != null) {
            FunctionDeclarationNode functionDeclarationNode = (FunctionDeclarationNode)declaration;

            //TODO: check if arguments/parameters match etc.

            return functionDeclarationNode.getDataType();
        }
        else {
            throw new UndeclaredFunctionException(functionCallNode.getFunctionName(), functionCallNode.getCodePosition());
        }
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

    public void visitBooleanExpression(BoolExpressionNode boolExpressionNode) {
        for (int i = 0; i < boolExpressionNode.getBoolExpressionOperators().size(); i++) {
            Enums.BoolOperator operator = boolExpressionNode.getBoolExpressionOperators().get(i);

            ArithExpressionNode leftArith = boolExpressionNode.getBoolExprOperandNodes().get(i).getArithExpressionNode();
            ArithExpressionNode rightArith = boolExpressionNode.getBoolExprOperandNodes().get(i+1).getArithExpressionNode();

            String leftBool = boolExpressionNode.getBoolExprOperandNodes().get(i).getBoolLiteral();
            String rightBool = boolExpressionNode.getBoolExprOperandNodes().get(i+1).getBoolLiteral();

            // Typechecking operators (Only bools can &&, ||. Bools cannot <, >)
            switch (operator) {
                case OR:
                case AND:
                    throwIfNotBool(leftArith, boolExpressionNode.getCodePosition());
                    throwIfNotBool(rightArith, boolExpressionNode.getCodePosition());
                    break;
                    
                case GREATER_THAN:
                case GREATER_OR_EQUAL:
                case LESS_THAN:
                case LESS_OR_EQUAL:
                    throwIfBool(leftArith, leftBool, boolExpressionNode.getCodePosition());
                    throwIfBool(rightArith, rightBool, boolExpressionNode.getCodePosition());
                    break;
            }
        }
    }

    private void throwIfNotBool(ArithExpressionNode arithExp, CodePosition codePosition) {
        if (arithExp != null) {
            if (visitArithmeticExpression(arithExp) != Enums.DataType.BOOL)
                throw new IllegalOperandException(arithExp.prettyPrint(0), codePosition);
        }
    }

    private void throwIfBool(ArithExpressionNode arithExp, String boolExp, CodePosition codePosition) {
        if (boolExp != null)
            throw new IllegalOperandException(boolExp, codePosition);
        else if (arithExp != null) {
            if (visitArithmeticExpression(arithExp) == Enums.DataType.BOOL)
                throw new IllegalOperandException(arithExp.prettyPrint(0), codePosition);
        }
    }

    public void visitFunctions(List<FunctionDeclarationNode> functionDeclarationNodes) {
        for (FunctionDeclarationNode functionDeclaration : functionDeclarationNodes) {
            visitFunctionDeclaration(functionDeclaration);
        }
    }

    public void visitFunctionDeclaration(FunctionDeclarationNode function) {
        String functionName = function.getFunctionName();
        List<FunctionParameterNode> functionParameters = function.getFunctionParameterNodes();
        Enums.DataType returnType = function.getDataType();

        // Check if function is already in symbol table
        if (retrieveSymbol(functionName) == null) {
            enterSymbol(functionName, function);
            visitFunctionBlock(function.getBlockNode(), returnType, functionParameters);
        }
        else {
            throw new FunctionAlreadyDeclaredException(functionName, function.getCodePosition());
        }
    }

    // TODO: FINISH IT
    private void visitFunctionBlock(BlockNode blockNode, Enums.DataType returnType, List<FunctionParameterNode> functionParameters) {
        openScope();

        boolean returned = false;

        if (functionParameters != null) {
            for (FunctionParameterNode functionParameter : functionParameters) {
                if (functionParameter.getDataType() != null) {
                    // TODO: FINISH IT
                    //AssignmentNode assignmentNode = new AssignmentNode(functionParameter.getVariableName(), null);

                }
            }
        }

        for (StatementNode statement : blockNode.getStatementNodes()) {
            if (statement instanceof ReturnStatementNode) {
                returned = true;
                visitReturnStatement((ReturnStatementNode)statement, returnType);
            }
            else
                visitStatement(statement);
        }

        if (returnType != Enums.DataType.VOID && !returned) {
            throw new IncorrectReturnTypeException(returnType, Enums.DataType.VOID, blockNode.getCodePosition());
        }
        closeScope();
    }

    private void visitReturnStatement(ReturnStatementNode returnStatementNode, Enums.DataType returnType) {
        String returnName = returnStatementNode.getVariableName();

        VariableDeclarationNode variableDeclaration = (VariableDeclarationNode) retrieveSymbol(returnName);

        if (variableDeclaration.getDataType() != returnType)
            throw new IncorrectReturnTypeException(returnType, variableDeclaration.getDataType(), returnStatementNode.getCodePosition());
    }

    private Enums.DataType getDataTypeFromLiteral(String literal) {
        if (literal.equals("true") || literal.equals("false"))
            return Enums.DataType.BOOL;
        else if (literal.contains("\""))
            return Enums.DataType.STRING;
        else if (literal.contains("."))
            return Enums.DataType.DOUBLE;
        else
            return Enums.DataType.INT ;
    }
}
