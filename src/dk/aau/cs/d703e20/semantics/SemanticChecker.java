package dk.aau.cs.d703e20.semantics;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.expressions.*;
import dk.aau.cs.d703e20.ast.statements.*;
import dk.aau.cs.d703e20.ast.structure.*;
import dk.aau.cs.d703e20.errorhandling.*;

import java.util.*;

public class SemanticChecker {

    private final Stack<HashMap<String, ASTNode>> hashMapStack = new Stack<>();
    private final HashMap<String, PinDeclarationNode> pinSymbolTable = new HashMap<>();
    // Stack to keep track of bound scopes
    private final Stack<Boolean> boundScope = new Stack<>();
    // Map of variableNames and whether they are constant
    private final HashMap<String, Boolean> varConstMap = new HashMap<>();
    // Map of ID's and datatype
    private  final HashMap<String, Enums.DataType> idTypeMap = new HashMap<>();

    public SemanticChecker() {
        HashMap<String, ASTNode> newSymbolTable = new HashMap<>();
        this.hashMapStack.push(newSymbolTable);

        // Outer scope is not bounded
        boundScope.push(false);

        // Add standard functions to symbol table
        enterFunction(
                new FunctionDeclarationNode(
                        Enums.DataType.VOID,
                        "delay",
                        new BlockNode(new ArrayList<>()),
                        new ArrayList<>(Collections.singletonList(
                                new FunctionParameterNode(Enums.DataType.INT, "ms")
                        ))
                ));
        enterFunction(
                new FunctionDeclarationNode(
                        Enums.DataType.INT,
                        "millis",
                        new BlockNode(new ArrayList<>()),
                        new ArrayList<>()
                ));
        enterFunction(
                new FunctionDeclarationNode(
                        Enums.DataType.INT,
                        "Seconds",
                        new BlockNode(new ArrayList<>()),
                        new ArrayList<>(Collections.singletonList(
                                new FunctionParameterNode(Enums.DataType.DOUBLE, "seconds")
                        ))
                ));
        enterFunction(
                new FunctionDeclarationNode(
                        Enums.DataType.INT,
                        "Minutes",
                        new BlockNode(new ArrayList<>()),
                        new ArrayList<>(Collections.singletonList(
                                new FunctionParameterNode(Enums.DataType.DOUBLE, "minutes")
                        ))
                ));
        enterFunction(
                new FunctionDeclarationNode(
                        Enums.DataType.INT,
                        "Hours",
                        new BlockNode(new ArrayList<>()),
                        new ArrayList<>(Collections.singletonList(
                                new FunctionParameterNode(Enums.DataType.DOUBLE, "hours")
                        ))
                ));
        enterFunction(
                new FunctionDeclarationNode(
                        Enums.DataType.INT,
                        "Days",
                        new BlockNode(new ArrayList<>()),
                        new ArrayList<>(Collections.singletonList(
                                new FunctionParameterNode(Enums.DataType.DOUBLE, "days")
                        ))
                ));

        // Add arduino constants to symbol table
        enterSymbol("LED_BUILTIN", new VariableDeclarationNode(Enums.DataType.INT, "LED_BUILTIN"));
    }

    private void openScope() {
        HashMap<String, ASTNode> newSymbolTable = new HashMap<>();
        this.hashMapStack.push(newSymbolTable);
    }

    private void closeScope() {
        this.hashMapStack.pop();
    }

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

    public HashMap<String, Boolean> getVarConstMap() {
        return varConstMap;
    }

    /*      VISITOR       */
    public void visitProgram(ProgramNode programNode) {
        openScope();
        visitFunctions(programNode.getFunctionDeclarationNodes());
        visitSetup(programNode.getSetupNode());
        visitLoop(programNode.getLoopNode());
        closeScope();
    }

    public void visitSetup(SetupNode setupNode) {
        visitSetupBlock(setupNode.getBlockNode());
    }

    public void visitLoop(LoopNode loopNode) {
        visitLoopBlock(loopNode.getBlockNode());
    }

    private void visitSetupBlock(BlockNode blockNode) {
        openScope();
        for (StatementNode statement : blockNode.getStatementNodes()) {
            if (statement instanceof VariableDeclarationNode) {
                // Variable declared in setup
                ((VariableDeclarationNode) statement).setInSetup(true);
                visitStatement(statement);
            } else if (statement instanceof PinDeclarationNode)
                visitStatement(statement);
            else
                throw new IllegalSetupStatementException(blockNode.getCodePosition());
        }
    }

    private void visitLoopBlock(BlockNode blockNode) {
        openScope();
        for (StatementNode statement : blockNode.getStatementNodes()) {
            if (statement instanceof PinDeclarationNode)
                throw new IllegalLoopStatementException(blockNode.getCodePosition());
            else
                visitStatement(statement);
        }
        closeScope();
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
        else if (statementNode instanceof ReturnStatementNode)
            visitReturnStatement((ReturnStatementNode) statementNode, getDataTypeFromName(((ReturnStatementNode) statementNode).getVariableName()));
        else
            throw new CompilerException("Unknown statement");
    }

    /*         STATEMENTS         */
    public void visitVariableDeclaration(VariableDeclarationNode varDeclNode) {
        Enums.DataType dataType = varDeclNode.getDataType();
        String variableName = varDeclNode.getVariableName();
        idTypeMap.put(variableName, dataType);

        // Check if variable is already in symbol table
        if (retrieveSymbol(variableName) == null) {
            // Variable assignment rule
            if (varDeclNode.getAssignmentNode() != null) {
                Enums.DataType assignmentDataType = visitAssignment(varDeclNode.getAssignmentNode());

                boolean typesMatch;

                typesMatch = assignmentDataType == dataType;

                if (dataType == Enums.DataType.CLOCK)
                    typesMatch = typesMatch || (assignmentDataType == Enums.DataType.INT);

                if (dataType == Enums.DataType.INT)
                    typesMatch = typesMatch || (assignmentDataType == Enums.DataType.CLOCK);

                if (typesMatch)
                    enterSymbol(varDeclNode.getAssignmentNode().getVariableName(), varDeclNode);
                else
                    throw new InconsistentTypeException(
                            varDeclNode.getVariableName(),
                            varDeclNode.getCodePosition(),
                            dataType, assignmentDataType);
            }
            // Array assignment rule
            else if (varDeclNode.getAssignArrayNode() != null) {
                Enums.DataType arrayDataType = visitAssignArray(varDeclNode.getAssignArrayNode());
                String arrayVarName = varDeclNode.getAssignArrayNode().getVariableName();
                idTypeMap.put(arrayVarName, arrayDataType);

                if (arrayDataType != Enums.singleDataTypeFromArrayDatatype(dataType))
                    throw new InconsistentTypeException(
                            varDeclNode.getVariableName(),
                            varDeclNode.getCodePosition());
                else
                    enterSymbol(varDeclNode.getAssignArrayNode().getVariableName(), varDeclNode);

                List<ArrayParamNode> arrayParamNodes = varDeclNode.getAssignArrayNode().getParamNodes();
                if (varDeclNode.getAllocatedSize() < arrayParamNodes.size())
                    throw new InvalidArrayException(variableName,
                            varDeclNode.getAllocatedSize(),
                            arrayParamNodes.size(),
                            varDeclNode.getCodePosition());

            }
            // Variable name rule
            else
                enterSymbol(varDeclNode.getVariableName(), varDeclNode);

            // Variable is constant at this point
            varConstMap.put(variableName, true);
        } else
            throw new VariableAlreadyDeclaredException(variableName, varDeclNode.getCodePosition());
    }

    private Enums.DataType visitAssignment(AssignmentNode assignmentNode) {
        Enums.DataType dataType;

        // Arith expression
        if (assignmentNode.getArithExpressionNode() != null) {
            dataType = visitArithmeticExpression(assignmentNode.getArithExpressionNode());

            // Check if variableName is re-assigned
            if (assignmentNode.getVariableName() != null)
                // Variable is no longer constant
                varConstMap.put(assignmentNode.getVariableName(), false);

            // Literal
        } else
            dataType = getDataTypeFromLiteral(assignmentNode.getLiteralValue());

        return dataType;
    }

    private Enums.DataType visitArithmeticExpression(ArithExpressionNode arithExpressionNode) {
        // Variable name rule
        if (arithExpressionNode.getVariableName() != null) {
            ASTNode declaration = retrieveSymbol(arithExpressionNode.getVariableName());
            if (declaration != null) {
                if (declaration instanceof PinDeclarationNode) {
                    if (((PinDeclarationNode) declaration).isAnalog())
                        return Enums.DataType.INT;
                    else
                        return Enums.DataType.BOOL;
                } else
                    return ((VariableDeclarationNode) declaration).getDataType();
            } else
                throw new UndeclaredVariableException(
                        arithExpressionNode.getVariableName(),
                        arithExpressionNode.getCodePosition());
        }

        // Num literal rule
        else if (arithExpressionNode.getNumber() != null)
            return getDataTypeFromLiteral(arithExpressionNode.getNumber());

            // Function call rule
        else if (arithExpressionNode.getFunctionCallNode() != null)
            return visitFunctionCall(arithExpressionNode.getFunctionCallNode());

            // Expression Operand Expression rule
        else if (arithExpressionNode.getArithExpressionNode2() != null) {
            Enums.DataType dataType1 = visitArithmeticExpression(arithExpressionNode.getArithExpressionNode1());
            Enums.DataType dataType2 = visitArithmeticExpression(arithExpressionNode.getArithExpressionNode2());

            if ((dataType1 != null && dataType2 != null) && dataType1 != dataType2)
                throw new InconsistentTypeException(arithExpressionNode.getVariableName(),
                        arithExpressionNode.getCodePosition(),
                        dataType1, dataType2);
            else
                return dataType1;
        }

        else if (arithExpressionNode.getSubscriptNode() != null) {
            if (idTypeMap.get(arithExpressionNode.getSubscriptNode().getVariableName()) != null)
                return idTypeMap.get(arithExpressionNode.getSubscriptNode().getVariableName());
            else
                throw new UndeclaredVariableException("ID of subscript", arithExpressionNode.getCodePosition());
        }

        // NOT? (arithExpr)
        else
            return visitArithmeticExpression(arithExpressionNode.getArithExpressionNode1());
    }

    private Enums.DataType visitAssignArray(AssignArrayNode assignArrayNode) {
        String variableName = assignArrayNode.getVariableName();
        Enums.DataType assignedDataType = null;

        if (variableName != null) {
            for (ArrayParamNode arrayParam : assignArrayNode.getParamNodes()) {
                if (assignedDataType == null)
                    assignedDataType = visitArrayParameters(arrayParam);
                else if (visitArrayParameters(arrayParam) != assignedDataType)
                    throw new InconsistentTypeException(
                            assignArrayNode.getVariableName(),
                            assignArrayNode.getCodePosition());
            }
        }
        return assignedDataType;
    }

    private Enums.DataType visitArrayParameters(ArrayParamNode arrayParamNode) {
        if (arrayParamNode.getArithExpressionNode() != null)
            return visitArithmeticExpression(arrayParamNode.getArithExpressionNode());
        else
            return getDataTypeFromLiteral(arrayParamNode.getLiteral());
    }

    private void visitPinDeclaration(PinDeclarationNode pinDeclarationNode) {
        String variableName = pinDeclarationNode.getVariableName();
        String pinNumber = pinDeclarationNode.getPinNumber();

        if (retrieveSymbol(variableName) != null)
            throw new VariableAlreadyDeclaredException(variableName, pinDeclarationNode.getCodePosition());
        else if (pinSymbolTable.containsKey(pinNumber))
            throw new VariableAlreadyDeclaredException(pinNumber, pinDeclarationNode.getCodePosition());
        else {
            pinSymbolTable.put(pinNumber, pinDeclarationNode);
            enterSymbol(pinDeclarationNode.getVariableName(), pinDeclarationNode);
        }
    }

    public Enums.DataType visitFunctionCall(FunctionCallNode functionCallNode) {
        // Annotate if in bound scope
        annotateBounded(functionCallNode);

        ASTNode declaration = retrieveSymbol(functionCallNode.getFunctionName());
        if (declaration != null) {
            FunctionDeclarationNode functionDeclarationNode = (FunctionDeclarationNode) declaration;
            List<FunctionParameterNode> functionParameterNodes = functionDeclarationNode.getFunctionParameterNodes();

            //check if arguments/parameters match
            for (int i = 0; i < functionCallNode.getFunctionArgNodes().size(); i++) {
                FunctionArgNode functionArgNode = functionCallNode.getFunctionArgNodes().get(i);
                Enums.DataType functionArgNodeDataType = null;

                if (functionArgNode.getArithExpressionNode() != null)
                    functionArgNodeDataType = visitArithmeticExpression(functionArgNode.getArithExpressionNode());
                else if (functionArgNode.getBoolExpressionNode() != null)
                    functionArgNodeDataType = Enums.DataType.BOOL;

                if (functionParameterNodes.get(i).getDataType() != functionArgNodeDataType)
                    throw new IllegalFunctionCallException(functionCallNode.getFunctionName(), functionCallNode.getCodePosition());
            }
            return functionDeclarationNode.getDataType();
        } else
            throw new UndeclaredFunctionException(functionCallNode.getFunctionName(), functionCallNode.getCodePosition());
    }

    private void visitIfElseStatement(IfElseStatementNode ifElseStatementNode) {
        // Annotate if in bound scope
        annotateBounded(ifElseStatementNode);

        IfStatementNode ifStatement = ifElseStatementNode.getIfStatementNode();
        List<ElseIfStatementNode> elseIfStatements = ifElseStatementNode.getElseIfStatementNodes();
        ElseStatementNode elseStatement = ifElseStatementNode.getElseStatement();

        // if
        visitConditionalExpression(ifStatement.getConditionalExpressionNode());
        visitBlock(ifStatement.getBlockNode());

        // else if
        if (elseIfStatements != null) {
            for (ElseIfStatementNode elseIfStatementNode : elseIfStatements) {
                visitConditionalExpression(elseIfStatementNode.getConditionalExpressionNode());
                visitBlock(elseIfStatementNode.getBlockNode());
            }
        }

        // else
        if (elseStatement != null)
            visitBlock(elseStatement.getBlockNode());
    }

    private void visitConditionalExpression(ConditionalExpressionNode conditionalExpressionNode) {
        if (conditionalExpressionNode.getBoolExpressionNode() != null)
            visitBooleanExpression(conditionalExpressionNode.getBoolExpressionNode());

        else if (conditionalExpressionNode.getVariableName() != null)
            if (!getDataTypeFromName(conditionalExpressionNode.getVariableName()).equals(Enums.DataType.BOOL))
                throw new IllegalConditionalExpressionException(conditionalExpressionNode.getCodePosition());

            else if (conditionalExpressionNode.getFunctionCallNode() != null)
                if (!getDataTypeFromName(conditionalExpressionNode.getFunctionCallNode().getFunctionName()).equals(Enums.DataType.BOOL))
                    throw new IllegalConditionalExpressionException(conditionalExpressionNode.getCodePosition());

                else if (conditionalExpressionNode.getSubscriptNode() != null)
                    if (!getDataTypeFromName(conditionalExpressionNode.getSubscriptNode().getVariableName()).equals(Enums.DataType.BOOL))
                        throw new IllegalConditionalExpressionException(conditionalExpressionNode.getCodePosition());
    }

    private void visitForStatement(ForStatementNode forStatementNode) {
        // Annotate if in bound scope
        annotateBounded(forStatementNode);

        // Not inside bound scope? throw exception
        if (!boundScope.peek())
            throw new IllegalIterativeStatementException(forStatementNode.getCodePosition());

        ArithExpressionNode forLoopExpression1 = forStatementNode.getArithExpressionNode1();
        ArithExpressionNode forLoopExpression2 = forStatementNode.getArithExpressionNode2();

        openScope();

        visitArithmeticExpression(forLoopExpression1);
        visitArithmeticExpression(forLoopExpression2);

        if (forStatementNode.getBlockNode() != null)
            visitBlock(forStatementNode.getBlockNode());

        closeScope();
    }

    private void visitWhileStatement(WhileStatementNode whileStatementNode) {
        // Annotate if in bound scope
        annotateBounded(whileStatementNode);

        // Not inside bound scope? throw exception
        if (!boundScope.peek())
            throw new IllegalIterativeStatementException(whileStatementNode.getCodePosition());

        BoolExpressionNode whileLoopExpression = whileStatementNode.getBoolExpressionNode();

        openScope();

        visitBooleanExpression(whileLoopExpression);

        if (whileStatementNode.getBlockNode() != null)
            visitBlock(whileStatementNode.getBlockNode());

        closeScope();
    }

    public void visitAtStatement(AtStatementNode atStatementNode) {
        // Annotate if in bound scope
        annotateBounded(atStatementNode);

        visitAtParams(atStatementNode.getAtParamsNode().getBoolExpressionNode(), false);
        visitBlock(atStatementNode.getBlockNode());
    }

    public void visitBoundStatement(BoundStatementNode boundStatementNode) {
        // Enter bound scope
        boundScope.push(true);

        visitAtParams(boundStatementNode.getAtParamsNode().getBoolExpressionNode(), true);
        visitBlock(boundStatementNode.getBody());

        // Leave bound scope
        boundScope.pop();

        if (boundStatementNode.getCatchBlock() != null)
            visitBlock(boundStatementNode.getCatchBlock());

        if (boundStatementNode.getFinalBlock() != null)
            visitBlock(boundStatementNode.getFinalBlock());
    }

    private void visitAtParams(BoolExpressionNode boolExpressionNode, boolean isBoundParentNode) {
        if (boolExpressionNode.getBoolExpressionOperators() != null) {
            for (int i = 0; i < boolExpressionNode.getBoolExpressionOperators().size(); i++) {
                Enums.BoolOperator operator = boolExpressionNode.getBoolExpressionOperators().get(i);

                BoolExpressionNode leftBoolExp =
                        boolExpressionNode.getBoolExprOperandNodes().get(i).getBoolExpressionNode();
                BoolExpressionNode rightBoolExp =
                        boolExpressionNode.getBoolExprOperandNodes().get(i + 1).getBoolExpressionNode();

                ArithExpressionNode leftArith =
                        boolExpressionNode.getBoolExprOperandNodes().get(i).getArithExpressionNode();
                ArithExpressionNode rightArith =
                        boolExpressionNode.getBoolExprOperandNodes().get(i + 1).getArithExpressionNode();

                if ((operator == null
                     || leftArith == null && leftBoolExp == null)
                    || (rightArith == null && rightBoolExp == null)) {
                    throw new IllegalAtExpressionException(boolExpressionNode.getCodePosition());
                } else {
                    Enums.DataType leftType;
                    Enums.DataType rightType;

                    if (leftArith != null)
                        leftType = visitArithmeticExpression(leftArith);
                    else
                        leftType = Enums.DataType.BOOL;

                    if (rightArith != null)
                        rightType = visitArithmeticExpression(rightArith);
                    else
                        rightType = Enums.DataType.BOOL;

                    if (operator == Enums.BoolOperator.OR || operator == Enums.BoolOperator.AND) {
                        if (leftType != Enums.DataType.BOOL || rightType != Enums.DataType.BOOL)
                            throw new IllegalAtExpressionException(boolExpressionNode.getCodePosition());
                    } else {
                        if (leftType != Enums.DataType.CLOCK && leftType != Enums.DataType.INT)
                            throw new IllegalAtExpressionException(boolExpressionNode.getCodePosition());

                        if (rightType != Enums.DataType.CLOCK && rightType != Enums.DataType.INT)
                            throw new IllegalAtExpressionException(boolExpressionNode.getCodePosition());

                        if (leftType != Enums.DataType.CLOCK && rightType != Enums.DataType.CLOCK)
                            throw new IllegalAtExpressionException(boolExpressionNode.getCodePosition());
                    }

                    if (isBoundParentNode) {
                        switch (operator) {
                            case LESS_OR_EQUAL:
                            case LESS_THAN:
                                if (rightType == Enums.DataType.CLOCK)
                                    throw new IllegalBoundStatementException(boolExpressionNode.getCodePosition());
                                break;
                            case GREATER_THAN:
                            case GREATER_OR_EQUAL:
                                if (leftType == Enums.DataType.CLOCK)
                                    throw new IllegalBoundStatementException(boolExpressionNode.getCodePosition());
                                break;
                        }
                    }
                }
            }
        } else
            throw new IllegalAtExpressionException(boolExpressionNode.getCodePosition());
    }

    public void visitBooleanExpression(BoolExpressionNode boolExpressionNode) {
        if (boolExpressionNode.getBoolExpressionOperators() != null) {

            for (int i = 0; i < boolExpressionNode.getBoolExpressionOperators().size(); i++) {
                Enums.BoolOperator operator = boolExpressionNode.getBoolExpressionOperators().get(i);

                ArithExpressionNode leftArith =
                        boolExpressionNode.getBoolExprOperandNodes().get(i).getArithExpressionNode();

                ArithExpressionNode rightArith =
                        boolExpressionNode.getBoolExprOperandNodes().get(i + 1).getArithExpressionNode();

                // Both are null
                Enums.DataType leftType;
                Enums.DataType rightType;

                // Either check leftArith type or leftType is bool
                if (leftArith != null)
                    leftType = visitArithmeticExpression(leftArith);
                else
                    leftType = Enums.DataType.BOOL;

                // Either check rightArith type or rightType is bool
                if (rightArith != null)
                    rightType = visitArithmeticExpression(rightArith);
                else
                    rightType = Enums.DataType.BOOL;

                // Make sure left and right operand are same type
                if (leftType != rightType) {
                    if (leftType != Enums.DataType.CLOCK && leftType != Enums.DataType.INT)
                        throw new IllegalOperandException(boolExpressionNode.getCodePosition());

                    if (rightType != Enums.DataType.CLOCK && rightType != Enums.DataType.INT)
                        throw new IllegalOperandException(boolExpressionNode.getCodePosition());

                    if (leftType != Enums.DataType.CLOCK && rightType != Enums.DataType.CLOCK)
                        throw new IllegalOperandException(boolExpressionNode.getCodePosition());
                }

                // Typechecking operators (Only bools can &&, ||. Bools cannot <, >)
                switch (operator) {
                    case OR:
                    case AND:
                        if (leftType != Enums.DataType.BOOL)
                            throw new IllegalOperandException(boolExpressionNode.getCodePosition());
                        break;

                    case GREATER_THAN:
                    case GREATER_OR_EQUAL:
                    case LESS_THAN:
                    case LESS_OR_EQUAL:
                        if (leftType == Enums.DataType.BOOL)
                            throw new IllegalOperandException(boolExpressionNode.getCodePosition());
                        break;
                }
            }
        } else if (boolExpressionNode.getBoolExpressionNode() != null)
            visitBooleanExpression(boolExpressionNode.getBoolExpressionNode());
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
        } else
            throw new FunctionAlreadyDeclaredException(functionName, function.getCodePosition());
    }

    private void visitFunctionBlock(BlockNode blockNode, Enums.DataType returnType, List<FunctionParameterNode> functionParameters) {
        openScope();
        boolean returned = false;

        if (!functionParameters.isEmpty()) {
            for (FunctionParameterNode functionParameter : functionParameters) {
                enterSymbol(functionParameter.getVariableName(), functionParameter);
            }
        }

        for (StatementNode statement : blockNode.getStatementNodes()) {
            if (statement instanceof ReturnStatementNode) {
                returned = true;
                visitReturnStatement((ReturnStatementNode) statement, returnType);
            } else
                visitStatement(statement);
        }

        if (returnType != Enums.DataType.VOID && !returned)
            throw new IncorrectReturnTypeException(returnType, Enums.DataType.VOID, blockNode.getCodePosition());

        closeScope();
    }

    private void visitReturnStatement(ReturnStatementNode returnStatementNode, Enums.DataType returnType) {
        String returnName = returnStatementNode.getVariableName();

        VariableDeclarationNode variableDeclaration = (VariableDeclarationNode) retrieveSymbol(returnName);

        if (variableDeclaration == null)
            throw new UndeclaredVariableException(returnName, returnStatementNode.getCodePosition());
        else {
            if (variableDeclaration.getDataType() != returnType)
                throw new IncorrectReturnTypeException(returnType, variableDeclaration.getDataType(), returnStatementNode.getCodePosition());
        }
    }

    private Enums.DataType getDataTypeFromLiteral(String literal) {
        if (literal.equals("true") || literal.equals("false"))
            return Enums.DataType.BOOL;
        else if (literal.contains("\""))
            return Enums.DataType.STRING;
        else if (literal.contains("."))
            return Enums.DataType.DOUBLE;
        else
            return Enums.DataType.INT;
    }

    private Enums.DataType getDataTypeFromName(String name) {
        Enums.DataType dataType = null;
        ASTNode node = retrieveSymbol(name);
        if (node instanceof VariableDeclarationNode)
            dataType = ((VariableDeclarationNode) node).getDataType();
        else if (node instanceof FunctionDeclarationNode)
            dataType = ((FunctionDeclarationNode) node).getDataType();

        if (dataType != null)
            return dataType;
        else
            throw new UndeclaredVariableException(name);
    }

    /**
     * Chekc if statement is in bound, if then annotate node
     *
     * @param statementNode the currently visited node
     */
    private void annotateBounded(StatementNode statementNode) {
        if (boundScope.peek())
            statementNode.setBounded(true);
    }
}
