package dk.aau.cs.d703e20.codegen;

import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.Enums.PinType;
import dk.aau.cs.d703e20.ast.expressions.*;
import dk.aau.cs.d703e20.ast.statements.*;
import dk.aau.cs.d703e20.ast.structure.*;
import dk.aau.cs.d703e20.codegen.arduino.code.*;
import dk.aau.cs.d703e20.codegen.arduino.structure.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ArduinoGenerator {

    private ArrayList<VariableDeclarationNode> globalVariables;
    private HashMap<String, PinDeclarationNode> pins;
    private ArrayList<AtStatementNode> atStatements;
    private ArrayList<String> clockNames;
    private ArrayList<FunctionDeclarationNode> functions;

    private boolean digitalWriteUsed;

    public String GenerateArduino(ProgramNode ast) {
        StringBuilder stringBuilder = new StringBuilder();
        globalVariables = new ArrayList<>();
        pins = new HashMap<>();
        atStatements = new ArrayList<>();
        clockNames = new ArrayList<>();
        functions = new ArrayList<>();

        ArduinoProgramNode program = visitProgram(ast);

        // Declare scheduled_ats array
        program.getVariableDeclarationNodes().add(new ArduinoVarDecl(Enums.DataType.INT_ARRAY, atStatements.size(), "scheduled_ats"));

        program.getLoopNode().getBlockNode().getStatementNodes().add(0, new CommentNode(" LOOP CODE"));

        program.getLoopNode().getBlockNode().getStatementNodes().add(new CommentNode(" AT STATEMENTS"));
        // handle all at statements
        for (int at = 0; at < atStatements.size(); at++) {
            // create if node from at node
            BoolExpressionNode atBool = atStatements.get(at).getAtParamsNode().getBoolExpressionNode();
            BlockNode atBlock = atStatements.get(at).getBlockNode();

            // decrement schedule count inside block
            atBlock.getStatementNodes().add(0, new CommentNode(" code from at block:"));
            atBlock.getStatementNodes().add(0, new CodeNode("scheduled_ats[" + at +"]--;"));
            atBlock.getStatementNodes().add(0, new CommentNode(" decrement schedule counter"));

            // insert at the end
            program.getLoopNode().getBlockNode().getStatementNodes().add(
                    new BlockStatementNode(
                            new CodeNode("if (scheduled_ats[" + at + "] && " + atBool.prettyPrint(0) + ") "),
                            atBlock));
        }

        program.getLoopNode().getBlockNode().getStatementNodes().add(new CommentNode(" CLOCKS"));
        // increment all clocks
        for (String clockName : clockNames) {
            // insert increment statement at the end
            program.getLoopNode().getBlockNode().getStatementNodes().add(new CodeNode(clockName + "++;"));
        }

        stringBuilder.append(program.prettyPrint(0));

        // add custom write functions to end of program
        if (digitalWriteUsed)
            stringBuilder.append(Functions.dWrite);

        return stringBuilder.toString();
    }

    private ArduinoProgramNode visitProgram(ProgramNode programNode) {
        ArduinoSetupNode setupNode = visitSetup(programNode.getSetupNode());
        ArduinoLoopNode loopNode = visitLoop(programNode.getLoopNode());

        ArrayList<FunctionDeclarationNode> functionDeclarationNodes = new ArrayList<>();
        for (FunctionDeclarationNode fDecl : programNode.getFunctionDeclarationNodes()) {
            Enums.DataType fType = fDecl.getDataType();
            String fName = fDecl.getFunctionName();
            List<FunctionParameterNode> fParams = fDecl.getFunctionParameterNodes();
            BlockNode fBlock = visitBlockNode(fDecl.getBlockNode());

            FunctionDeclarationNode functionDeclaration = new FunctionDeclarationNode(fType, fName, fBlock, fParams);

            functionDeclarationNodes.add(functionDeclaration);
            functions.add(functionDeclaration);
        }

        return new ArduinoProgramNode(globalVariables, setupNode, loopNode, functionDeclarationNodes);
    }

    // Handles setup block
    private ArduinoSetupNode visitSetup(SetupNode setupNode) {
        BlockNode blockNode = setupNode.getBlockNode();

        List<StatementNode> statementNodes = new ArrayList<>();
        for (StatementNode statementNode : blockNode.getStatementNodes()) {
            if (statementNode instanceof PinDeclarationNode) {
                PinDeclarationNode pinDeclNode = (PinDeclarationNode)statementNode;
                pins.put(pinDeclNode.getVariableName(), pinDeclNode);
                statementNodes.add(visitPinDeclaration(pinDeclNode));
            }
            else if (statementNode instanceof VariableDeclarationNode) {
                VariableDeclarationNode varDeclNode = (VariableDeclarationNode)statementNode;
                globalVariables.add(visitVariableDeclaration(varDeclNode));
            }
            // else nothing. Only declarations allowed
        }

        return new ArduinoSetupNode(visitBlockNode(new BlockNode(statementNodes)));
    }

    private ArduinoLoopNode visitLoop(LoopNode loopNode) {
        return new ArduinoLoopNode(visitBlockNode(loopNode.getBlockNode()));
    }

    // Does not handle setup block
    private BlockNode visitBlockNode(BlockNode blockNode) {
        List<StatementNode> statementNodes = new ArrayList<>();
        for (StatementNode statementNode : blockNode.getStatementNodes()) {

            if (statementNode instanceof VariableDeclarationNode)
                statementNodes.add(visitVariableDeclaration((VariableDeclarationNode) statementNode));

            else if (statementNode instanceof AssignmentNode)
                statementNodes.add(visitAssignment((AssignmentNode) statementNode));

            else if (statementNode instanceof IfElseStatementNode)
                statementNodes.add(visitIfElseStatement((IfElseStatementNode) statementNode));

            else if (statementNode instanceof AtStatementNode)
                statementNodes.add(visitAtStatement((AtStatementNode) statementNode));

            else if (statementNode instanceof BoundStatementNode)
                visitBoundStatement((BoundStatementNode) statementNode);

            // TODO: handle other statement node types with visitors
            else
                statementNodes.add(statementNode);
        }
        return new BlockNode(statementNodes);
    }

    // Adds a variable declaration [ int pinName = number; ] globally
    // and returns a function call [ pinMode(pinName, INPUT/OUTPUT); ]
    private FunctionCallNode visitPinDeclaration(PinDeclarationNode pinDeclarationNode) {
        String varName = pinDeclarationNode.getVariableName();
        String pinNumber = pinDeclarationNode.getPinNumber();
        Enums.PinType pinType = pinDeclarationNode.getPinType();

        // int pinName = number;
        globalVariables.add(new VariableDeclarationNode(Enums.DataType.INT, new AssignmentNode(varName, pinNumber)));

        // pinMode(pinName, INPUT/OUTPUT);
        List<FunctionArgNode> functionArgNodes = new ArrayList<>();
        functionArgNodes.add(new FunctionArgNode(new ArithExpressionNode(varName, false)));
        String io = "";
        switch (pinType) {
            case IPIN: io = "INPUT";
                break;
            case OPIN: io = "OUTPUT";
                break;
            case IPPIN: io = "INPUT_PULLUP";
                break;
        }
        functionArgNodes.add(new FunctionArgNode(new ArithExpressionNode(io, false)));
        return new FunctionCallNode("pinMode", functionArgNodes);
    }

    private VariableDeclarationNode visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
        // If variable is a clock, turn it into an int instead
        if (variableDeclarationNode.getDataType() == Enums.DataType.CLOCK) {
            AssignmentNode assignmentNode = variableDeclarationNode.getAssignmentNode();
            String variableName = variableDeclarationNode.getVariableName();

            clockNames.add(variableName);
            if (assignmentNode != null)
                return new VariableDeclarationNode(Enums.DataType.INT, assignmentNode);
            else
                return new VariableDeclarationNode(Enums.DataType.INT, variableName);
        }
        else
            return variableDeclarationNode;
    }

    private StatementNode visitAssignment(AssignmentNode assignmentNode) {
        if (pins.containsKey(assignmentNode.getVariableName())) {
            PinDeclarationNode pinDecl = pins.get(assignmentNode.getVariableName());

            // digital/analog-Write arguments
            List<FunctionArgNode> functionArgNodes = new ArrayList<>();

            // arg 1: pin number
            FunctionArgNode argName = new FunctionArgNode(new ArithExpressionNode(assignmentNode.getVariableName(), false));
            functionArgNodes.add(argName);

            // arg 2: value
            FunctionArgNode argValue;
            if (assignmentNode.getArithExpressionNode() != null)
                argValue = new FunctionArgNode(visitArithExpression(assignmentNode.getArithExpressionNode()));
            else {
                String value = assignmentNode.getLiteralValue();

                /*
                if (pinDecl.isAnalog())
                    value = assignmentNode.getLiteralValue();
                else {
                    switch (assignmentNode.getLiteralValue()) {
                        case "true": value = "HIGH";
                            break;
                        case "false": value = "LOW";
                            break;
                        default:
                            throw new CompilerException("ERROR: assignment to pin failed, expected true or false. Got " + assignmentNode.getLiteralValue());
                    }
                }
                */

                argValue = new FunctionArgNode(new ArithExpressionNode(value, true));
            }
            functionArgNodes.add(argValue);

            if (!pinDecl.isAnalog())
                digitalWriteUsed = true;

            return new FunctionCallNode(pinDecl.isAnalog() ? "analogWrite" : "dWrite", functionArgNodes);
        }
        else {
            if (assignmentNode.getArithExpressionNode() != null) {
                return new AssignmentNode(
                        assignmentNode.getVariableName(),
                        visitArithExpression(assignmentNode.getArithExpressionNode()));
            }
            else
                return assignmentNode;
        }
    }

    private ArithExpressionNode visitArithExpression(ArithExpressionNode arithExpressionNode) {
        ArithExpressionNode leftArith = arithExpressionNode.getArithExpressionNode1();
        ArithExpressionNode rightArith = arithExpressionNode.getArithExpressionNode2();
        String number = arithExpressionNode.getNumber();
        String variableName = arithExpressionNode.getVariableName();
        FunctionCallNode functionCallNode = arithExpressionNode.getFunctionCallNode();

        ArithExpressionNode newArithExpression;

        if (leftArith != null) {
            if (rightArith != null)
                newArithExpression = new ArithExpressionNode(
                        visitArithExpression(leftArith),
                        visitArithExpression(rightArith),
                        arithExpressionNode.getArithExpressionOperator());
            else
                newArithExpression = new ArithExpressionNode(
                        visitArithExpression(leftArith),
                        arithExpressionNode.getOptionalNot());
        }
        else if (number != null)
            newArithExpression = new ArithExpressionNode(number, true);

        else if (variableName != null) {
            if (pins.containsKey(variableName)) {
                List<FunctionArgNode> fArgs = new ArrayList<>();
                fArgs.add(new FunctionArgNode(new ArithExpressionNode(variableName, false)));
                FunctionCallNode readCall = new FunctionCallNode("digitalRead", fArgs);

                newArithExpression = new ArithExpressionNode(readCall);
            }
            else
                newArithExpression = arithExpressionNode;
        }

        else if (functionCallNode != null) {
            List<FunctionArgNode> functionArgNodes = new ArrayList<>();
            for (FunctionArgNode arg : functionCallNode.getFunctionArgNodes()) {
                ArithExpressionNode argArith = arg.getArithExpressionNode();

                if (argArith != null)
                    functionArgNodes.add(new FunctionArgNode(visitArithExpression(argArith)));
                else
                    functionArgNodes.add(arg);
            }
            FunctionCallNode newFuncCall = new FunctionCallNode(functionCallNode.getFunctionName(), functionArgNodes);
            newArithExpression = new ArithExpressionNode(newFuncCall);
        }
        else
            newArithExpression = arithExpressionNode;

        return newArithExpression;
    }

    private IfElseStatementNode visitIfElseStatement(IfElseStatementNode ifElseStatementNode) {
        IfStatementNode ifStatementNode = visitIfStatement(ifElseStatementNode.getIfStatementNode());

        List<ElseIfStatementNode> elseIfStatementNodes = new ArrayList<>();
        for (ElseIfStatementNode elseIfStatementNode: ifElseStatementNode.getElseIfStatementNodes()) {
            elseIfStatementNodes.add(visitElseIfStatement(elseIfStatementNode));
        }

        ElseStatementNode elseStatementNode = null;
        if (ifElseStatementNode.getElseStatement() != null) {
            elseStatementNode = visitElseStatement(ifElseStatementNode.getElseStatement());
        }

        return new IfElseStatementNode(ifStatementNode, elseIfStatementNodes, elseStatementNode);
    }

    private IfStatementNode visitIfStatement(IfStatementNode ifStatementNode) {
        BlockNode blockNode = visitBlockNode(ifStatementNode.getBlockNode());
        return new IfStatementNode(ifStatementNode.getConditionalExpressionNode(), blockNode);
    }

    private ElseIfStatementNode visitElseIfStatement(ElseIfStatementNode elseIfStatementNode) {
        BlockNode blockNode = visitBlockNode(elseIfStatementNode.getBlockNode());
        return new ElseIfStatementNode(elseIfStatementNode.getConditionalExpressionNode(), blockNode);
    }

    private ElseStatementNode visitElseStatement(ElseStatementNode elseStatementNode) {
        BlockNode blockNode = visitBlockNode(elseStatementNode.getBlockNode());
        return new ElseStatementNode(blockNode);
    }

    private StatementNode visitAtStatement (AtStatementNode atStatementNode) {
        BlockNode visitedBlock = visitBlockNode(atStatementNode.getBlockNode());
        AtStatementNode visitedAt = new AtStatementNode(atStatementNode.getAtParamsNode(), visitedBlock);

        int atIndex = atStatements.size();
        atStatements.add(visitedAt);
        return new CodeNode("scheduled_ats[" + atIndex + "]++;");
    }

    private void visitBoundStatement (BoundStatementNode boundStatementNode) {

    }

}
