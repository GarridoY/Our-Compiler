package dk.aau.cs.d703e20.codegen;

import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.expressions.ArithExpressionNode;
import dk.aau.cs.d703e20.ast.expressions.FunctionArgNode;
import dk.aau.cs.d703e20.ast.statements.*;
import dk.aau.cs.d703e20.ast.structure.BlockNode;
import dk.aau.cs.d703e20.ast.structure.LoopNode;
import dk.aau.cs.d703e20.ast.structure.ProgramNode;
import dk.aau.cs.d703e20.ast.structure.SetupNode;
import dk.aau.cs.d703e20.codegen.arduino.statements.*;
import dk.aau.cs.d703e20.codegen.arduino.structure.*;
import dk.aau.cs.d703e20.errorhandling.*;

import java.util.ArrayList;
import java.util.List;


public class ArduinoGenerator {

    private ArrayList<VariableDeclarationNode> globalVariables;
    private ArrayList<FunctionDeclarationNode> functions;

    public String GenerateArduino(ProgramNode ast) {
        globalVariables = new ArrayList<>();
        functions = new ArrayList<>();

        ArduinoProgramNode program = visitProgram(ast);

        return program.prettyPrint(0);
    }


    private ArduinoProgramNode visitProgram(ProgramNode programNode) {
        ArduinoSetupNode setupNode = visitSetup(programNode.getSetupNode());
        ArduinoLoopNode loopNode = visitLoop(programNode.getLoopNode());

        // TODO: visit function declarations
        ArrayList<FunctionDeclarationNode> functionDeclarationNodes = new ArrayList<>();

        return new ArduinoProgramNode(globalVariables, setupNode, loopNode, functionDeclarationNodes);
    }

    private ArduinoSetupNode visitSetup(SetupNode setupNode) {
        ArduinoSetupNode arduinoSetupNode = new ArduinoSetupNode(visitBlockNode(setupNode.getBlockNode()));
        return arduinoSetupNode;
    }

    private ArduinoLoopNode visitLoop(LoopNode loopNode) {
        ArduinoLoopNode arduinoLoopNode = new ArduinoLoopNode(visitBlockNode(loopNode.getBlockNode()));
        return arduinoLoopNode;
    }

    private BlockNode visitBlockNode(BlockNode blockNode) {
        List<StatementNode> statementNodes = new ArrayList<>();
        for (StatementNode statementNode : blockNode.getStatementNodes()) {
            if (statementNode instanceof PinDeclarationNode) {
                PinDeclarationNode pinDeclNode = (PinDeclarationNode)statementNode;
                statementNodes.add(visitPinDeclaration(pinDeclNode));
            }
            //TODO: do specific visits
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

    /*
    private FunctionDeclarationNode visitFunctionDeclaration(FunctionDeclarationNode functionDeclarationNode) {
        Enums.DataType dataType = functionDeclarationNode.getDataType();
        String functionName = functionDeclarationNode.getFunctionName();
        BlockNode blockNode = visitBlock(functionDeclarationNode.getBlockNode());
        ArrayList<FunctionParameterNode> functionParameterNodes = new ArrayList<>();

        for (FunctionParameterNode functionParameterNode : functionDeclarationNode.getFunctionParameterNodes()) {
            functionParameterNodes.add(visitFunctionParameter(functionParameterNode));
        }
        return new FunctionDeclarationNode(dataType, functionName, visitBlock(blockNode), functionParameterNodes);
    }

    private FunctionParameterNode visitFunctionParameter(FunctionParameterNode functionParameterNode) {
        Enums.DataType dataType = functionParameterNode.getDataType();
        String variableName = functionParameterNode.getVariableName();
        return new FunctionParameterNode(dataType, variableName);
    }

    private FunctionCallNode visitFunctionCall(FunctionCallNode functionCallNode) {
        ArrayList<FunctionArgNode> functionArgNodes = new ArrayList<>();
        String functionName = functionCallNode.getFunctionName();

        if (functionCallNode.getFunctionArgNodes() != null) {
            for (FunctionArgNode argNode : functionCallNode.getFunctionArgNodes()) {
                functionArgNodes.add(visitFunctionArgument(argNode));
            }
        }
        return new FunctionCallNode(functionName, functionArgNodes);
    }

    private FunctionArgNode visitFunctionArgument(FunctionArgNode functionArgNode) {
        ArithExpressionNode arithExpressionNode;
        BoolExpressionNode boolExpressionNode;
        if (functionArgNode.getArithExpressionNode() != null) {
            arithExpressionNode = visitArithExpression(functionArgNode.getArithExpressionNode());
            return new FunctionArgNode(arithExpressionNode);
        } else if (functionArgNode.getBoolExpressionNode() != null) {
            boolExpressionNode = visitBoolExpression(functionArgNode.getBoolExpressionNode());
            return new FunctionArgNode((boolExpressionNode));
        } else throw new CompilerException("Invalid function argument", functionArgNode.getCodePosition());
    }

    private WhileStatementNode visitWhileStatement(WhileStatementNode whileStatementNode) {
        BoolExpressionNode boolExpressionNode = whileStatementNode.getBoolExpressionNode();
        BlockNode blockNode = whileStatementNode.getBlockNode();
        return new WhileStatementNode(boolExpressionNode, blockNode);
    }

    private AtStatementNode visitAtStatement(AtStatementNode atStatementNode) {
        AtParamsNode atParamsNode = atStatementNode.getAtParamsNode();
        BlockNode blockNode = atStatementNode.getBlockNode();
        return new AtStatementNode(atParamsNode, blockNode);
    }

    private ReturnStatementNode visitReturnStatement(ReturnStatementNode returnStatementNode) {
        return new ReturnStatementNode(returnStatementNode.getVariableName());
    }

    private AtParamsNode visitAtParams(AtParamsNode atParamsNode) {
        return new AtParamsNode(visitBoolExpression(atParamsNode.getBoolExpressionNode()));
    }

    private BoundStatementNode visitBoundStatement(BoundStatementNode boundStatementNode) {
        AtParamsNode atParamsNode = visitAtParams(boundStatementNode.getAtParamsNode());
        BlockNode body = visitBlock(boundStatementNode.getBody());
        String boolLiteral = boundStatementNode.getBoolLiteral();
        BlockNode catchBlock;
        BlockNode finalBlock;

        if (boolLiteral != null) {
            if (boundStatementNode.getFinalBlock() != null) {
                finalBlock = visitBlock(boundStatementNode.getFinalBlock());
                if (boundStatementNode.getCatchBlock() != null) {
                    catchBlock = visitBlock(boundStatementNode.getCatchBlock());
                    return new BoundStatementNode(atParamsNode, boolLiteral, body, catchBlock, finalBlock);
                } else
                    return new BoundStatementNode(atParamsNode, boolLiteral, body, finalBlock, false);
            } else if (boundStatementNode.getCatchBlock() != null) {
                catchBlock = visitBlock(boundStatementNode.getCatchBlock());
                return new BoundStatementNode(atParamsNode, boolLiteral, body, catchBlock, true);
            } else
                return new BoundStatementNode(atParamsNode, boolLiteral, body);
        }
        if (boundStatementNode.getFinalBlock() != null) {
            finalBlock = visitBlock(boundStatementNode.getFinalBlock());
            if (boundStatementNode.getCatchBlock() != null) {
                catchBlock = visitBlock(boundStatementNode.getCatchBlock());
                return new BoundStatementNode(atParamsNode, body, catchBlock, finalBlock);
            }
        } else
            return new BoundStatementNode(atParamsNode, body);

        throw new CompilerException("invalid bound statement", boundStatementNode.getCodePosition());
    }

    private AssignArrayNode visitAssignArray(AssignArrayNode assignArrayNode) {
        String variableName = assignArrayNode.getVariableName();
        ArrayList<ArrayParamNode> arrayParamNodes = new ArrayList<>();

        for (ArrayParamNode arrayParamNode : assignArrayNode.getParamNodes()) {
            arrayParamNodes.add(visitArrayParam(arrayParamNode));
        }
        return new AssignArrayNode(variableName, arrayParamNodes);
    }

    private ArrayParamNode visitArrayParam(ArrayParamNode arrayParamNode) {
        String literal = arrayParamNode.getLiteral();
        ArithExpressionNode arithExpressionNode = arrayParamNode.getArithExpressionNode();

        if (literal != null) {
            return new ArrayParamNode(literal);
        } else return new ArrayParamNode(visitArithExpression(arithExpressionNode));
    }

    private ForStatementNode visitForStatement(ForStatementNode forStatementNode) {
        ArithExpressionNode arithExpressionNode1 = forStatementNode.getArithExpressionNode1();
        ArithExpressionNode arithExpressionNode2 = forStatementNode.getArithExpressionNode2();
        BlockNode blockNode = forStatementNode.getBlockNode();

        return new ForStatementNode(visitArithExpression(arithExpressionNode1), visitArithExpression(arithExpressionNode2), visitBlock(blockNode));
    }
    */

}
