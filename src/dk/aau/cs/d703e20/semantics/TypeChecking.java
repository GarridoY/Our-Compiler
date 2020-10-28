package dk.aau.cs.d703e20.semantics;

import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.errorhandling.CompilerException;
import dk.aau.cs.d703e20.ast.expressions.*;
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
        }
    }

    /*         STATEMENTS         */
    private void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
        VariableDeclarationNode retrievedNode = null;

        String variableName;
        Enums.DataType dataType = null;

        if (variableDeclarationNode.getVariableName() != null) {
            variableName = variableDeclarationNode.getVariableName();
            if (retrieveSymbol(variableName) instanceof VariableDeclarationNode)
                retrievedNode = (VariableDeclarationNode) retrieveSymbol(variableName);

            if (retrievedNode != null)
                dataType = retrievedNode.getDataType();
            else dataType = null;

            if (retrieveSymbol(variableName) == null)
                throw new CompilerException("ERROR: Variable (" + variableName + ") is not declared.", retrievedNode.getCodePosition());

            if (dataType.equals(Enums.DataType.CLOCK))
                if (retrievedNode.getVariableName() == null)
                    throw new CompilerException("ERROR: Invalid declaration of a clock variable (" + variableName + ").", retrievedNode.getCodePosition());
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
        if (variableDeclarationNode.getAssignArrayNode() != null) {
            Enums.DataType arrayDataType = visitAssignArray(variableDeclarationNode.getAssignArrayNode(), variableDeclarationNode.getAllocatedSize());
            if (arrayDataType != dataType) throw new CompilerException("ERROR: A array variable (" + variableDeclarationNode.getVariableName() + ") contains invalid types.", retrievedNode.getCodePosition());
        }
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

    private Enums.DataType visitAssignArray(AssignArrayNode assignArrayNode, int allocatedSize) {
        String variableName;
        Enums.DataType assignedDataType = null;

        if (assignArrayNode.getVariableName() != null) {
            VariableDeclarationNode variableDeclarationNode = null;
            variableName = assignArrayNode.getVariableName();
            if (retrieveSymbol(variableName) instanceof VariableDeclarationNode)
                variableDeclarationNode = (VariableDeclarationNode) retrieveSymbol(variableName);

            if (variableDeclarationNode != null) assignedDataType = variableDeclarationNode.getDataType();
            else throw new CompilerException("ERROR: Array variable (" + variableName + ") is not declared.", assignArrayNode.getCodePosition());

            if (allocatedSize < assignArrayNode.getParamNodes().size())
                throw new CompilerException("ERROR: Size exceeded in Array variable(" + variableName + ")." ,assignArrayNode.getCodePosition());

            for (ArrayParamNode arrayParam : assignArrayNode.getParamNodes()){
                if (assignedDataType == null) {
                    assignedDataType = visitArrayParameters(arrayParam);
                } else if (visitArrayParameters(arrayParam) != assignedDataType)
                    throw new CompilerException("ERROR: Incompatible types (" +  assignedDataType + ")", assignArrayNode.getCodePosition());
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

        String variableName;
        Enums.PinType pinType = null;

        if (pinDeclarationNode.getVariableName() != null) {
            variableName = pinDeclarationNode.getVariableName();
            if (retrieveSymbol(variableName) instanceof VariableDeclarationNode)
                retrievedNode = (PinDeclarationNode) retrieveSymbol(variableName);

            if (retrievedNode != null)
                pinType = retrievedNode.getPinType();
            else pinType = null;

            if (retrieveSymbol(variableName) == null)
                throw new CompilerException("ERROR: Pin Variable (" + variableName + ") is not declared.", retrievedNode.getCodePosition());
        }

        if (retrieveSymbol(pinDeclarationNode.getVariableName()) != null && retrieveSymbol(pinDeclarationNode.getVariableName()) instanceof PinDeclarationNode)
            retrievedNode = (PinDeclarationNode) retrieveSymbol(pinDeclarationNode.getVariableName());

        if (retrievedNode == null) {
            if (pinDeclarationNode.getVariableName() != null)
                enterSymbol(pinDeclarationNode.getVariableName(), pinDeclarationNode);
            else throw new CompilerException("ERROR: A pin variable (" + pinDeclarationNode.getVariableName() + ") with the same name already exists.", retrievedNode.getCodePosition());
        }
    }

    private FunctionDeclarationNode visitFunctionCall(FunctionCallNode functionCallNode) {
        boolean notFound = true;
        FunctionDeclarationNode functionDeclarationNodeReturn = null;
        String functionName = functionCallNode.getFunctionName();
        List<FunctionArgNode> functionArgNodes = functionCallNode.getFunctionArgNodes();

        FunctionDeclarationNode functionDeclarationNode = (FunctionDeclarationNode) retrieveSymbol(functionName);

        for (int i = 0; i < functionDeclarationNode.getFunctionParameterNodes().size(); i++) {
            if (functionDeclarationNode.getFunctionParameterNodes().get(i).getDataType() != null) {
                Enums.DataType dataType1 = functionDeclarationNode.getFunctionParameterNodes().get(i).getDataType();
                //Enums.DataType dataType2 = functionCallNode.getFunctionArgNodes().get(i).;
                //if (!dataType1.equals(dataType1))
                    //throw new CompilerException("ERROR: Argument type mismatch in function call (" + functionName + "). Found " + dataType1 + " and " + dataType2 + ".", functionCallNode.getCodePosition());
            }
        }



        return functionDeclarationNodeReturn;

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
    


    public void visitFunctions(List<FunctionDeclarationNode> functionDeclarationNodes) {
        for (FunctionDeclarationNode functionDeclaration : functionDeclarationNodes) {
            visitFunctionDeclaration(functionDeclaration);
        }

        for (FunctionDeclarationNode functionDeclaration : functionDeclarationNodes) {
            visitFunctionBlock(functionDeclaration.getBlockNode(), functionDeclaration.getDataType(), functionDeclaration);
        }
    }

    private void visitFunctionDeclaration(FunctionDeclarationNode function) {
        String functionName = function.getFunctionName();
        List<FunctionParameterNode> functionParameters = function.getFunctionParameterNodes();
        Enums.DataType returnType = function.getDataType();

        ArrayList<FunctionDeclarationNode> retrievedFunctions = null;
        if (retrievedFunctions.isEmpty())
            enterSymbol(functionName, function);

        if (retrievedFunctions.size() > 0) {
            boolean sameReturnType = true;
            boolean sameFunctionArgs = false;
            boolean sameAmountOfArgs = false;

            outerloop:
            for (FunctionDeclarationNode retrivedNode : retrievedFunctions) {
                sameReturnType = retrivedNode.getDataType() == returnType;
                sameAmountOfArgs = retrivedNode.getFunctionParameterNodes() == null && functionParameters == null;

                if (retrivedNode.getFunctionParameterNodes() != null && functionParameters != null){
                    if (retrivedNode.getFunctionParameterNodes().size() == functionParameters.size()) {
                        for (int i = 0; i < functionParameters.size(); i++) {
                            if (functionParameters.get(i).getDataType() != null) {
                                if (retrivedNode.getFunctionParameterNodes().get(i).getDataType() != null) {
                                    if (functionParameters.get(i).getDataType().equals(retrivedNode.getFunctionParameterNodes().get(i).getDataType())) {
                                        sameFunctionArgs = true;
                                        break outerloop;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (sameFunctionArgs)
                throw new CompilerException("ERROR: A function with the same name (" + functionName + ") and arguments already exists.", retrieveSymbol(functionName).getCodePosition());
            if (sameAmountOfArgs)
                if (returnType != null)
                    throw new CompilerException("ERROR: A function with the same name (" + functionName + ") and type (" + returnType + "already exists.", retrieveSymbol(functionName).getCodePosition());
            enterSymbol(functionName, function);
        }
    }

    // TODO: FINISH IT
    private void visitFunctionBlock(BlockNode blockNode, Enums.DataType returnType, FunctionDeclarationNode functionDeclarationNode) {
        openScope();

        boolean pureFunction = returnType != null;

        if (functionDeclarationNode.getFunctionParameterNodes() != null) {
            for (FunctionParameterNode functionParameter : functionDeclarationNode.getFunctionParameterNodes()) {
                if (functionParameter.getDataType() != null) {
                    // TODO: FINISH IT
                    //AssignmentNode assignmentNode = new AssignmentNode(functionParameter.getVariableName(), null);

                }
            }
        }
    }

    private void visitReturnStatement(ReturnStatementNode returnStatementNode, FunctionDeclarationNode functionDeclarationNode) {
        String returnName = returnStatementNode.getVariableName();
        Enums.DataType returnType =  functionDeclarationNode.getDataType();

        VariableDeclarationNode variableDeclaration = (VariableDeclarationNode) retrieveSymbol(returnName);

        if (variableDeclaration.getDataType() != returnType)
            throw new CompilerException("ERROR: Invalid return data type on variable (" + returnName + ").", returnStatementNode.getCodePosition());
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
