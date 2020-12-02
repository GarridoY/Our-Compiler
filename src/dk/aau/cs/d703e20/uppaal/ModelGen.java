package dk.aau.cs.d703e20.uppaal;

import com.uppaal.model.core2.Edge;
import com.uppaal.model.core2.Location;
import com.uppaal.model.core2.PrototypeDocument;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.expressions.ArithExpressionNode;
import dk.aau.cs.d703e20.ast.expressions.ArrayParamNode;
import dk.aau.cs.d703e20.ast.expressions.SubscriptNode;
import dk.aau.cs.d703e20.ast.statements.*;
import dk.aau.cs.d703e20.ast.structure.*;
import dk.aau.cs.d703e20.uppaal.structures.UPPSystem;
import dk.aau.cs.d703e20.uppaal.structures.UPPTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static dk.aau.cs.d703e20.uppaal.structures.UPPTemplate.setNail;


public class ModelGen {
    // New system with default properties
    UPPSystem system = new UPPSystem(new PrototypeDocument());
    // Map of channels to start templates from loop
    HashMap<UPPTemplate, String> templateChanMap = new HashMap<>();
    // Map of io pins (name, number)
    HashMap<String, Integer> pinChanMap = new HashMap<>();
    // List of used clocks
    List<String> clockList = new ArrayList<>();
    // Map of varName and values, also stores return value of function
    HashMap<String, String> varValues = new HashMap<>();
    HashMap<String, List<ArrayParamNode>> arrayValues = new HashMap<>();

    int atCount = 0;
    int boundCount = 0;
    // count the amount of channels needed
    int opinCount = 0;
    int ipinCount = 0;
    String opinChanName = "outPin";
    String ipinChanName = "inPin";


    // Create template to handle world input/output
    //TODO: use with main arg
    UPPTemplate createNaiveWorldModel() {
        UPPTemplate template = system.createTemplate("Naive_World");

        // New edge from/to init for input chan
        Edge outputHandler = template.addEdge(template.getLocationList().get(0), template.getLocationList().get(0), null, "in[i]!", null);
        UPPTemplate.setLabel(outputHandler, UPPTemplate.EKind.select, "i : int[0," + opinCount + "]", 0, 0);
        setNail(outputHandler, -10, -5);
        setNail(outputHandler, -10, 5);

        // New edge from/to init for output
        Edge inputHandler = template.addEdge(template.getLocationList().get(0), template.getLocationList().get(0), null, "out[i]?", null);
        UPPTemplate.setLabel(inputHandler, UPPTemplate.EKind.select, "i : int[0," + ipinCount + "]", 0, 0);
        setNail(inputHandler, 10, -5);
        setNail(inputHandler, 10, 5);
        return template;
    }

    // Adds declaration from pair to global scope
    private void appendChanMapGlobal(UPPTemplate key, String value) {
        system.addChan(value);
    }

    /**
     * Begins the process of generating UPPAAL code corresponding to the program
     *
     * @param programNode Top node of program AST
     * @return UPPSystem for UPPAAL to compile
     */
    public UPPSystem visitProgram(ProgramNode programNode) {
        // Functions -> Controller -> Global
        programNode.getFunctionDeclarationNodes().forEach(this::visitFuncDecl);
        visitSetup(programNode.getSetupNode());
        visitLoop(programNode.getLoopNode());
        setSetupDecl();
        // Set system declaration (processes)
        system.setDeclaration();
        system.toXML(); //TODO: remove
        return system;
    }

    private void visitLoop(LoopNode loopNode) {
        UPPTemplate template = system.createTemplate("controller");
        visitBlock(loopNode.getBlockNode(), template);
        template.setLooping();
    }

    /**
     * Goes through all declarations made in setup() and finally sets global UPPAAL scope
     *
     * @param setupNode Source setup() from programNode
     */
    private void visitSetup(SetupNode setupNode) {
        // Find all declarations
        for (StatementNode statementNode : setupNode.getBlockNode().getStatementNodes()) {
            if (statementNode instanceof VariableDeclarationNode) {
                // Declare clocks
                visitVarDecl((VariableDeclarationNode) statementNode);
            } else if (statementNode instanceof PinDeclarationNode) {
                // Declare pins
                visitPinDecl((PinDeclarationNode) statementNode);
            }
        }
    }

    private void setSetupDecl() {
        // Add channel with size of ipin & opin counts
        if (opinCount > 0)
            system.addDigitalPin(opinChanName, opinCount);
        if (ipinCount > 0)
            system.addDigitalPin(ipinChanName, ipinCount);
        // Add channel for each template
        templateChanMap.forEach(this::appendChanMapGlobal);
        // Set all declarations as system properties
        system.setGlobalDecl();
    }

    /**
     * Visit new block.
     * Pass StringBuilder of new template.
     *
     * @param blockNode Block of current node
     */
    private void visitBlock(BlockNode blockNode, UPPTemplate template) {
        // Visit each statement in block
        blockNode.getStatementNodes().forEach(statementNode -> visitStatement(statementNode, template));
    }

    /**
     * Select visitor based on type of statement. Adds statements as transitions to template.
     * Some of these visitors open new templates.
     *
     * @param statementNode Current statement in BlockNode
     * @param template      template of current block
     */
    private void visitStatement(StatementNode statementNode, UPPTemplate template) {
        if (statementNode instanceof PinDeclarationNode)
            visitPinDecl((PinDeclarationNode) statementNode);
        else if (statementNode instanceof VariableDeclarationNode)
            visitVarDecl((VariableDeclarationNode) statementNode);
        else if (statementNode instanceof AtStatementNode)
            visitAtStatement((AtStatementNode) statementNode, template);
        else if (statementNode instanceof BoundStatementNode)
            visitBoundStatement((BoundStatementNode) statementNode);
        else if (statementNode instanceof AssignmentNode)
            visitAssignment((AssignmentNode) statementNode, template);
        else if (statementNode instanceof FunctionCallNode)
            visitFunctionCall((FunctionCallNode) statementNode, template);

        /*
        TODO:
          visitIfElseStatement, create new template
          visitIterativeStatement, create new template
         */
    }

    private void visitAssignment(AssignmentNode assignmentNode, UPPTemplate template) {
        // Store value of variable name
        if (assignmentNode.getArithExpressionNode() != null)
            varValues.put(assignmentNode.getVariableName(), assignmentNode.getArithExpressionNode().prettyPrint(0));

        // Is variable pin?
        if (pinChanMap.containsKey(assignmentNode.getVariableName())) {
            if (assignmentNode.getLiteralValue().equals("true")) {
                // chan! update pin to value 1
                template.edgeFromLastLoc("pinHigh", null, opinChanName + "[" + pinChanMap.get(assignmentNode.getVariableName()) + "][1]!", null);
            } else if (assignmentNode.getLiteralValue().equals("false")) {
                // chan! update pin to value 0
                template.edgeFromLastLoc("pinLow", null, opinChanName + "[" + pinChanMap.get(assignmentNode.getVariableName()) + "][0]!", null);
            }
        }
        // Is variable clock?
        else if (clockList.contains(assignmentNode.getVariableName())) {
            // Update string
            String updateStmt = assignmentNode.getArithExpressionNode().prettyPrint(0);

            // New location for update edge
            Location prevLoc = template.getLocationList().get(template.getLocationList().size() - 1);
            Location newLoc = template.addLocation("");
            template.addEdge(prevLoc, newLoc, null, null, updateStmt);
        }
    }

    private void visitFunctionCall(FunctionCallNode functionCallNode, UPPTemplate currentTemplate) {
        String name = functionCallNode.getFunctionName();
        String functionChan;
        UPPTemplate functionTemplate = null;

        // Special delay function
        if (name.equals("delay")) {
            delayFunction(functionCallNode, currentTemplate);
        } else {
            // Find template matching the function name
            for (UPPTemplate uppTemplate : system.getTemplateList()) {
                if (uppTemplate.getName().equals(name))
                    functionTemplate = uppTemplate;
            }
            // Get chan name for starting function template
            functionChan = templateChanMap.get(functionTemplate);
            // Add sync edge to current template, sync starts the function template
            currentTemplate.edgeFromLastLoc("called_" + functionCallNode.getFunctionName(), null, functionChan + "!", null);
        }
    }

    private void delayFunction(FunctionCallNode functionCallNode, UPPTemplate currentTemplate) {
        String localClockName = "delayClock";
        ArithExpressionNode argument = functionCallNode.getFunctionArgNodes().get(0).getArithExpressionNode();
        String delay = getValueArithExpr(argument);

        // Declare local clock
        currentTemplate.addVar("clock " + localClockName);
        // Edge to reset local clock
        currentTemplate.edgeFromLastLoc("reset_local_clock", null, null, localClockName + " = 0");
        // Guard template to wait the given amount
        currentTemplate.edgeFromLastLoc("called_" + functionCallNode.getFunctionName(), localClockName + " > (" + delay + ")", null, null);
        currentTemplate.setDeclaration();
    }

    /**
     * Add PinDeclaration as chan to template/global.
     * StringBuilder is used as all properties have to be set at once.
     * Counts are used to set all declaration at once later.
     *
     * @param pinDeclNode Source StatementNode
     */
    private void visitPinDecl(PinDeclarationNode pinDeclNode) {
        // Save pin (name, value) in map
        if (pinDeclNode.getPinType() == Enums.PinType.IPIN) {
            pinChanMap.put(pinDeclNode.getVariableName(), ipinCount);
            ipinCount++;
        } else {
            pinChanMap.put(pinDeclNode.getVariableName(), opinCount);
            opinCount++;
        }
    }

    /**
     * Add clocks to system as global variables
     *
     * @param varDeclNode Source StatementNode
     */
    private void visitVarDecl(VariableDeclarationNode varDeclNode) {
        // Save variable name and its value in map for later use
        if (varDeclNode.getAssignmentNode() != null)
            varValues.put(varDeclNode.getAssignmentNode().getVariableName(), varDeclNode.getAssignmentNode().getArithExpressionNode().prettyPrint(0));
        else if (varDeclNode.getAssignArrayNode() != null)
            arrayValues.put(varDeclNode.getAssignArrayNode().getVariableName(), varDeclNode.getAssignArrayNode().getParamNodes());

        // Only clock types are used in UPPAAL
        // All clocks are global due to scoping with templates
        if (varDeclNode.getDataType() == Enums.DataType.CLOCK) {
            system.addClockDecl(varDeclNode);
            clockList.add(varDeclNode.getVariableName());
        }
    }

    // Returns the value of the index in the list
    private String getValueSubscript(SubscriptNode subscriptNode) {
        List<ArrayParamNode> arrayNodes = arrayValues.get(subscriptNode.getVariableName());

        ArithExpressionNode arithNodeOfList = new ArithExpressionNode("0", true);
        if (arrayNodes.get(subscriptNode.getIndex()).getArithExpressionNode() != null)
            arithNodeOfList = arrayNodes.get(subscriptNode.getIndex()).getArithExpressionNode();

        return getValueArithExpr(arithNodeOfList);
    }

    private String getValueArithExpr(ArithExpressionNode arithExpressionNode) {
        String delay;
        // If arg is a variable name, get its value from map
        if (arithExpressionNode.getVariableName() != null) {
            delay = varValues.get(arithExpressionNode.getVariableName());
        }
        // If arg is a function call get the value of its return
        else if (arithExpressionNode.getFunctionCallNode() != null) {
            delay = varValues.get(arithExpressionNode.getFunctionCallNode().getFunctionName());
        } else if (arithExpressionNode.getSubscriptNode() != null)
            delay = getValueSubscript(arithExpressionNode.getSubscriptNode());
        else
            delay = arithExpressionNode.prettyPrint(0);
        return delay;
    }

    private void visitAtStatement(AtStatementNode atStatementNode, UPPTemplate fromTemplate) {
        // Create new template
        UPPTemplate atTemplate = system.createTemplate("At" + atCount);
        // Create channel for synchronisation
        templateChanMap.put(atTemplate, "begin_" + "AT" + atCount);

        // Add edge to sync previous template into new one
        fromTemplate.edgeFromLastLoc("sched" + atTemplate.getName(), null, templateChanMap.get(atTemplate) + "!", null);

        // Create new location to check time and edge to sync at schedule
        atTemplate.edgeFromLastLoc("CheckTime", null, templateChanMap.get(atTemplate) + "?", null);

        // Edge and location for starting at (when atParam is ready)
        Location startAt = atTemplate.addLocation("starAt");
        String guard = atStatementNode.getAtParamsNode().getBoolExpressionNode().prettyPrint(0);
        atTemplate.addEdge(atTemplate.getLocationList().get(1), startAt, guard, null, null);

        visitBlock(atStatementNode.getBlockNode(), atTemplate);
        atTemplate.setLooping();
    }

    private void visitBoundStatement(BoundStatementNode boundStatementNode) {
        // Create new template
        UPPTemplate template = system.createTemplate("Bound" + boundCount);
        templateChanMap.put(template, "begin_" + "Bound" + boundCount);
        visitBlock(boundStatementNode.getBody(), template);

        // Check for additional blocks, these are added to the current template
        if (boundStatementNode.getCatchBlock() != null) {
            visitBlock(boundStatementNode.getCatchBlock(), template);
        }
        if (boundStatementNode.getFinalBlock() != null) {
            visitBlock(boundStatementNode.getFinalBlock(), template);
        }
    }

    private void visitFuncDecl(FunctionDeclarationNode functionDeclarationNode) {
        // Create new template
        UPPTemplate template = system.createTemplate(functionDeclarationNode.getFunctionName());
        // Create channel to start new template
        templateChanMap.put(template, "begin_" + functionDeclarationNode.getFunctionName());
        visitBlock(functionDeclarationNode.getBlockNode(), template);

        // Add function name and return value to map of varValues
        findReturnValue(functionDeclarationNode);
    }

    // Finds value of return statement and adds it to map of values
    private void findReturnValue(FunctionDeclarationNode function) {
        for (StatementNode statement : function.getBlockNode().getStatementNodes()) {
            if (statement instanceof ReturnStatementNode) {
                ReturnStatementNode returnNode = (ReturnStatementNode) statement;
                String functionName = function.getFunctionName();
                String returnValue = varValues.get(returnNode.getVariableName());

                varValues.put(functionName, returnValue);
            }
        }
    }
}
