package dk.aau.cs.d703e20.codegen;

import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.expressions.*;
import dk.aau.cs.d703e20.ast.statements.*;
import dk.aau.cs.d703e20.ast.structure.*;
import dk.aau.cs.d703e20.codegen.arduino.structure.*;
import dk.aau.cs.d703e20.errorhandling.CompilerException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ArduinoGenerator {

    private ArrayList<VariableDeclarationNode> globalVariables;
    private HashMap<String, PinDeclarationNode> pins;
    private ArrayList<AtStatementNode> atStatements;
    private ArrayList<String> clockNames;
    private ArrayList<FunctionDeclarationNode> functions;

    public String GenerateArduino(ProgramNode ast) {
        globalVariables = new ArrayList<>();
        pins = new HashMap<>();
        atStatements = new ArrayList<>();
        clockNames = new ArrayList<>();
        functions = new ArrayList<>();

        ArduinoProgramNode program = visitProgram(ast);

        // handle all at statements
        for (AtStatementNode at : atStatements) {
            // create if node from at node
            IfStatementNode ifNode =
                    new IfStatementNode(
                        new ConditionalExpressionNode(at.getAtParamsNode().getBoolExpressionNode()),
                        at.getBlockNode()
                    );
            IfElseStatementNode ifElseNode = new IfElseStatementNode(ifNode, new ArrayList<>(), null);

            // insert at the end
            program.getLoopNode().getBlockNode().getStatementNodes().add(ifElseNode);
        }

        // increment all clocks
        for (String clockName : clockNames) {
            // create [clockName = clockName + 1;]
            ArithExpressionNode variableName = new ArithExpressionNode(clockName, false);
            ArithExpressionNode one = new ArithExpressionNode("1", true);
            ArithExpressionNode clockPlusOne = new ArithExpressionNode(variableName, one, Enums.ArithOperator.ADD);
            AssignmentNode clockIncrement = new AssignmentNode(clockName, clockPlusOne);

            // insert at the end
            program.getLoopNode().getBlockNode().getStatementNodes().add(clockIncrement);
        }

        return program.prettyPrint(0);
    }


    private ArduinoProgramNode visitProgram(ProgramNode programNode) {
        ArduinoSetupNode setupNode = visitSetup(programNode.getSetupNode());
        ArduinoLoopNode loopNode = visitLoop(programNode.getLoopNode());

        // TODO: visit function declarations
        ArrayList<FunctionDeclarationNode> functionDeclarationNodes = new ArrayList<>();

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
                visitVariableDeclaration(varDeclNode);
                globalVariables.add(varDeclNode);
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
            if (statementNode instanceof VariableDeclarationNode) {
                VariableDeclarationNode varDeclNode = (VariableDeclarationNode) statementNode;
                visitVariableDeclaration(varDeclNode);
                statementNodes.add(varDeclNode);
            }
            else if (statementNode instanceof AssignmentNode) {
                AssignmentNode assignmentNode = (AssignmentNode) statementNode;
                statementNodes.add(visitAssignment(assignmentNode));
            }
            else if (statementNode instanceof IfElseStatementNode) {
                statementNodes.add(visitIfElseStatement((IfElseStatementNode) statementNode));
            }
            else if (statementNode instanceof AtStatementNode) {
                visitAtStatement((AtStatementNode) statementNode);
            }
            else if (statementNode instanceof BoundStatementNode) {
                visitBoundStatement((BoundStatementNode) statementNode);
            }
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
        String io = pinType == Enums.PinType.IPIN ? "INPUT" : "OUTPUT";
        functionArgNodes.add(new FunctionArgNode(new ArithExpressionNode(io, false)));
        return new FunctionCallNode("pinMode", functionArgNodes);
    }

    private void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
        if (variableDeclarationNode.getDataType() == Enums.DataType.CLOCK)
            clockNames.add(variableDeclarationNode.getVariableName());
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
                argValue = new FunctionArgNode(assignmentNode.getArithExpressionNode());
            else {
                String value;

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

                argValue = new FunctionArgNode(new ArithExpressionNode(value, true));
            }
            functionArgNodes.add(argValue);

            return new FunctionCallNode(pinDecl.isAnalog() ? "analogWrite" : "digitalWrite", functionArgNodes);
        }
        else
            return assignmentNode;
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

    private void visitAtStatement (AtStatementNode atStatementNode) {
        atStatements.add(atStatementNode);
    }

    private void visitBoundStatement (BoundStatementNode boundStatementNode) {

    }

}
