package dk.aau.cs.d703e20.uppaal;

import com.uppaal.model.core2.Edge;
import com.uppaal.model.core2.Location;
import com.uppaal.model.core2.PrototypeDocument;
import dk.aau.cs.d703e20.Pair;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.expressions.ArithExpressionNode;
import dk.aau.cs.d703e20.ast.expressions.ArrayParamNode;
import dk.aau.cs.d703e20.ast.expressions.SubscriptNode;
import dk.aau.cs.d703e20.ast.statements.*;
import dk.aau.cs.d703e20.ast.structure.*;
import dk.aau.cs.d703e20.uppaal.structures.UPPSystem;
import dk.aau.cs.d703e20.uppaal.structures.UPPTemplate;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import static dk.aau.cs.d703e20.uppaal.structures.UPPTemplate.setNail;


public class ModelGen {
    // New system with default properties
    UPPSystem system = new UPPSystem(new PrototypeDocument());
    // Map of channels to start templates from loop
    HashMap<UPPTemplate, String> templateChanMap = new HashMap<>();
    List<String> utilChan = new ArrayList<>();
    // Map of io pins (name, number)
    HashMap<String, Integer> pinChanMap = new HashMap<>();
    // List of used clocks
    List<String> clockList = new ArrayList<>();
    // Map of varName and values, also stores return value of function
    HashMap<String, String> varValues = new HashMap<>();
    HashMap<String, List<ArrayParamNode>> arrayValues = new HashMap<>();

    // Stack of (guard, sync) used to check time after each statement and return to bound
    Stack<Pair<String, String>> boundGuardKillSync = new Stack<>();

    // Keep count of templates
    int atCount = 0;
    int boundCount = 0;
    int ifCount = 0;
    int elseIfCount = 0;
    int forCount = 0;
    int whileCount = 0;
    // count the amount of channels needed
    int opinCount = 0;
    int ipinCount = 0;
    String opinChanName = "outPin";
    String ipinChanName = "inPin";


    // Create template to handle world input/output
    private void createNaiveWorldModel() {
        UPPTemplate template = system.createTemplate("Naive_World");

        // New edge from/to init for input chan
        if (ipinCount > 0) {
            Edge inputHandler = template.addEdge(template.getLocationList().get(0), template.getLocationList().get(0), null, "inPin[i][1]!", null);
            UPPTemplate.setLabel(inputHandler, UPPTemplate.EKind.select, "i : int[0," + (ipinCount-1) + "]", 0, 0);
            setNail(inputHandler, -10, -5);
            setNail(inputHandler, -10, 5);
        }

        // New edge from/to init for output
        if (opinCount > 0) {
            Edge outputHandler = template.addEdge(template.getLocationList().get(0), template.getLocationList().get(0), null, "outPin[i][j]?", null);
            UPPTemplate.setLabel(outputHandler, UPPTemplate.EKind.select, "i : int[0," + (opinCount-1) + "], j : int[0,1]", 0, 0);
            setNail(outputHandler, 10, -5);
            setNail(outputHandler, 10, 5);
        }
    }

    /**
     * Create a new template and sync it with the previous template.
     *
     * @param templateName name of the new template (should be name and count)
     * @param prevTemplate template where this statement is called
     * @return the new template
     */
    private UPPTemplate newSyncedTemplate(String templateName, UPPTemplate prevTemplate) {
        // Create new template
        UPPTemplate template = system.createTemplate(templateName);

        // Create channel for synchronisation
        String chan = "begin_" + templateName;
        templateChanMap.put(template, chan);

        // Add edge to sync into new template
        template.edgeFromLastLoc("Sync_done", null, chan + "?", null);

        // Add edge to sync previous template into new one
        prevTemplate.edgeFromLastLoc("called_" + template.getName(), null, chan + "!", null);

        return template;
    }

    // Adds declaration from pair to global scope
    private void appendChanMapGlobal(UPPTemplate key, String value) {
        system.addChan(value);
    }

    /**
     * Function to kill current statement outside boundTemplate and return to bound.
     *
     * @param statementNode current statement node
     * @param template      current template corresponding to the node
     */
    // TODO: non sync edge for statements inside boundTemplate, if bounded addEdge() for every location from itself to time_eceeded, get locations of boundtemplate
    private void setBoundBreakEdges(StatementNode statementNode, UPPTemplate template) {
        if (statementNode.isBounded()) {
            Location boundKill = template.addLocation("bound_kill", 50, 100);
            // Make sure template can be reset
            template.setLooping();
            // Add an extra edge for every location, to break out of template
            template.getLocationList().subList(0, template.getLocationList().size() -2).forEach(location -> template.addEdge(location, boundKill, boundGuardKillSync.peek().getFirst(), boundGuardKillSync.peek().getSecond() + "!", null));
        }
    }

    private void setBoundBreakEdges(StatementNode statementNode, UPPTemplate template, Location boundKill) {
        if (statementNode.isBounded()) {
            // Make sure template can be reset
            template.setLooping();
            // Add an extra edge for every location, to break out of template
            template.getLocationList().subList(0, template.getLocationList().size() -2).forEach(location -> template.addEdge(location, boundKill, boundGuardKillSync.peek().getFirst(), boundGuardKillSync.peek().getSecond() + "!", null));
        }
    }

    /**
     * Begins the process of generating UPPAAL code corresponding to the program
     *
     * @param programNode Top node of program AST
     * @return UPPSystem for UPPAAL to compile
     */
    public UPPSystem visitProgram(ProgramNode programNode, String userModelFileName) {
        // Functions -> Controller -> Global
        programNode.getFunctionDeclarationNodes().forEach(this::visitFuncDecl);
        visitSetup(programNode.getSetupNode());
        visitLoop(programNode.getLoopNode());
        setSetupDecl();

        // If a model is given, it will use that one as the IO model of the world.
        // Else use the naive one.
        if (userModelFileName != null) {
            UserModelTranslator userModelTranslator = new UserModelTranslator(system);
            try {
                userModelTranslator.createTemplateFromUserModel(userModelFileName);
            } catch (ParserConfigurationException | IOException | SAXException e) {
                e.printStackTrace();
            }
        } else {
            createNaiveWorldModel();
        }

        // Set system declaration (processes)
        system.setDeclaration();
        system.toXML(); //TODO: remove
        return system;
    }

    private void visitLoop(LoopNode loopNode) {
        UPPTemplate template = system.createTemplate("controller");
        visitBlock(loopNode.getBlockNode(), template);
        template.edgeFromLastLoc("End_controller", null, null, null);
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
        // Add all utility channels (kill channels)
        utilChan.forEach(s -> system.addChan(s));
        // Set all declarations as system properties
        system.setGlobalDecl();
    }

    /**
     * Visit new block.
     *
     * @param blockNode Block of current node
     * @param template  template of node containing the block
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
            visitBoundStatement((BoundStatementNode) statementNode, template);
        else if (statementNode instanceof AssignmentNode)
            visitAssignment((AssignmentNode) statementNode, template);
        else if (statementNode instanceof FunctionCallNode)
            visitFunctionCall((FunctionCallNode) statementNode, template);
        else if (statementNode instanceof IfElseStatementNode)
            visitIfElseStatement((IfElseStatementNode) statementNode, template);
        else if (statementNode instanceof ForStatementNode)
            visitForStatement((ForStatementNode) statementNode, template);
        else if (statementNode instanceof WhileStatementNode)
            visitWhileStatement((WhileStatementNode) statementNode, template);
    }

    private void visitForStatement(ForStatementNode forLoopNode, UPPTemplate prevTemplate) {
        UPPTemplate forTemplate = newSyncedTemplate("For" + forCount, prevTemplate);
        forCount++;

        // Loop location, requires var
        String loopVar = "loopIndex";
        forTemplate.addVar("int " + loopVar + " = 0");
        // initialize loop template by setting loopVar
        forTemplate.edgeFromLastLoc("loop", null, null, loopVar + " = " + getValueArithExpr(forLoopNode.getArithExpressionNode1()));
        // Get the location of main loop node
        Location loopLoc = getLast(forTemplate.getLocationList());
        // TODO: consider making loop location urgent

        // First location of loop iteration
        forTemplate.edgeFromLastLoc("iterate", loopVar + " != " + getValueArithExpr(forLoopNode.getArithExpressionNode2()), null, null);

        // Add body of loop to template
        visitBlock(forLoopNode.getBlockNode(), forTemplate);
        // Get the last location in the loop
        Location lastLocInLoop = getLast(forTemplate.getLocationList());

        // Last edge for incrementing loopVar
        forTemplate.addEdge(lastLocInLoop, loopLoc, null, null, loopVar + " ++");

        // Add exit case for loop location
        Location endFor = forTemplate.addLocation("end_for");
        forTemplate.addEdge(loopLoc, endFor, loopVar + " == " + getValueArithExpr(forLoopNode.getArithExpressionNode2()), null, null);
        forTemplate.setLooping();
        forTemplate.setDeclaration();

        setBoundBreakEdges(forLoopNode, forTemplate);
    }

    private void visitWhileStatement(WhileStatementNode whileStatementNode, UPPTemplate prevTemplate) {
        UPPTemplate whileTemplate = newSyncedTemplate("While" + whileCount, prevTemplate);
        whileCount++;

        // Setup start loop location for looping
        Location startLoop = whileTemplate.addLocation("Start_loop");
        // Edge from sync_done to starting loop
        whileTemplate.addEdge(whileTemplate.getLocationList().get(1), startLoop, null, null, null);

        // Add block
        visitBlock(whileStatementNode.getBlockNode(), whileTemplate);

        // Add end location
        whileTemplate.edgeFromLastLoc("End_loop", null, null, null);
        // Add uncontrollable edge from "End_loop" to "Start_loop" locations, used to simulate the while loop
        whileTemplate.addEdge(getLast(whileTemplate.getLocationList()), startLoop, null, null, null).setProperty("controllable", false);

        whileTemplate.edgeFromLastLoc("While_end", null, null, null);
        whileTemplate.setLooping();

        setBoundBreakEdges(whileStatementNode, whileTemplate);
    }

    private void visitIfElseStatement(IfElseStatementNode ifElseStatementNode, UPPTemplate prevTemplate) {
        final int locationCoord = 75;
        // Create new template and sync with previous
        UPPTemplate ifTemplate = newSyncedTemplate("If" + ifCount, prevTemplate);
        ifCount++;

        // Save location to start each if/elseIf/else
        Location startLoc = getLast(ifTemplate.getLocationList());
        // Location for If start
        Location ifLoc = ifTemplate.addLocation("Start_If");

        // Set uncontrollable edge and let UPPAAL do whitebox testing
        ifTemplate.addEdge(startLoc, ifLoc, null, null, null).setProperty("controllable", false);
        // Add block statements to if branch
        visitBlock(ifElseStatementNode.getIfStatementNode().getBlockNode(), ifTemplate);

        // Create location to end all if statements
        Location endLoc = ifTemplate.addLocation("If_end");
        // Set looping manual as endLoc is not last in list
        ifTemplate.addEdge(endLoc, startLoc, null, null, null);
        // Create edge from last location of if to endLoc
        ifTemplate.addEdge(ifTemplate.getLocationList().get(ifTemplate.getLocationList().size() - 2), endLoc, null, null, null);

        // Handle Else If statements
        if (!ifElseStatementNode.getElseIfStatementNodes().isEmpty())
            // New location branch for each else if
            ifElseStatementNode.getElseIfStatementNodes().forEach(elseIfStatementNode -> visitElseIf(elseIfStatementNode, ifTemplate, startLoc, endLoc, locationCoord));

        // Handle else statement
        if (ifElseStatementNode.getElseStatement() != null) {
            // Create location beneath else if's
            Location elseLoc = ifTemplate.addLocation("Start_Else", startLoc.getX() + locationCoord, locationCoord + locationCoord * elseIfCount);

            // Set uncontrollable edge and let UPPAAL do whitebox testing
            ifTemplate.addEdge(startLoc, elseLoc, null, null, null).setProperty("controllable", false);
            // Add block statements to else branch
            visitBlock(ifElseStatementNode.getElseStatement().getBlockNode(), ifTemplate);
            // Create edge from last location of else to endLoc
            ifTemplate.addEdge(getLast(ifTemplate.getLocationList()), endLoc, null, null, null);
        }

        // Reset count for next if statements
        elseIfCount = 0;

        setBoundBreakEdges(ifElseStatementNode, ifTemplate);
    }

    private void visitElseIf(ElseIfStatementNode elseIfNode, UPPTemplate ifTemplate, Location startLoc, Location endLoc, int locationCoord) {
        // Create locations, locationCoord makes sure they do not stack
        Location elseIfLoc = ifTemplate.addLocation("Start_ElseIf" + elseIfCount, startLoc.getX() + locationCoord, locationCoord + locationCoord * elseIfCount);

        // Set uncontrollable edge and let UPPAAL do whitebox testing
        ifTemplate.addEdge(startLoc, elseIfLoc, null, null, null).setProperty("controllable", false);
        // Add block statements to else if branch
        visitBlock(elseIfNode.getBlockNode(), ifTemplate);
        // Create edge from last location of else if to endLoc
        ifTemplate.addEdge(getLast(ifTemplate.getLocationList()), endLoc, null, null, null);

        elseIfCount++;
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
            Location prevLoc = getLast(template.getLocationList());
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

            // Set the function template to be able to break bound
            assert functionTemplate != null;
            setBoundBreakEdges(functionCallNode, functionTemplate, getLast(functionTemplate.getLocationList()));
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

    private void visitAtStatement(AtStatementNode atStatementNode, UPPTemplate prevTemplate) {
        // Create new template and sync with previous
        UPPTemplate atTemplate = newSyncedTemplate("At" + atCount, prevTemplate);
        atCount++;

        //TODO: add invariant

        // Edge and location for starting at (when atParam is ready)
        Location startAt = atTemplate.addLocation("startAt");
        String guard = atStatementNode.getAtParamsNode().getBoolExpressionNode().prettyPrint(0);
        atTemplate.addEdge(atTemplate.getLocationList().get(1), startAt, guard, null, null);

        visitBlock(atStatementNode.getBlockNode(), atTemplate);

        // Edge and location for ending 'at' for model verification.
        atTemplate.edgeFromLastLoc("endAt", null, null, null);

        atTemplate.setLooping();

        setBoundBreakEdges(atStatementNode, atTemplate);
    }

    // Run body, check if time is exceeded, then run catch and final or just final
    private void visitBoundStatement(BoundStatementNode boundStatementNode, UPPTemplate prevTemplate) {
        // Create new template and sync with previous
        UPPTemplate boundTemplate = newSyncedTemplate("Bound" + boundCount, prevTemplate);
        boundCount++;

        // Add guard and sync to stack used to kill statements within bound scope
        String exceedGuard = boundStatementNode.getAtParamsNode().getBoolExpressionNode().prettyPrint(0).replaceAll("(<=|<)", ">");
        String killSync = "kill" + boundCount;
        utilChan.add(killSync);
        boundGuardKillSync.push(new Pair<>(exceedGuard, killSync));

        // Visit block
        visitBlock(boundStatementNode.getBody(), boundTemplate);

        // Save list of all body locations, used to add time exceptions
        final List<Location> bodyStatements = new ArrayList<>(boundTemplate.getLocationList().subList(2, boundTemplate.getLocationList().size()));
        // Pop stack as we exit bound body
        boundGuardKillSync.pop();

        // Done location
        boundTemplate.edgeFromLastLoc("body_done", null, null, null);
        // save the location for body end, as we branch out
        Location bodyEndLoc = getLast(boundTemplate.getLocationList());

        // Check if blocking
        if (boundStatementNode.getBoolLiteral() != null && boundStatementNode.getBoolLiteral().equals("true")) {
            // Bound param, where '<' is changed to '=='
            String guard = boundStatementNode.getAtParamsNode().getBoolExpressionNode().prettyPrint(0).replaceAll("(<=|<)", "==");
            boundTemplate.edgeFromLastLoc("Time_OK", guard, null, null);
        } else
            boundTemplate.edgeFromLastLoc("Time_OK", boundStatementNode.getAtParamsNode().getBoolExpressionNode().prettyPrint(0), null, null);

        // TODO: create variable before, and set it to return of edgefromlastloc
        Location timeOKLoc = getLast(boundTemplate.getLocationList());
        Location timeExceedLoc = boundTemplate.addLocation("Time_exceeded", getLast(boundTemplate.getLocationList()).getX(), 75);
        // Add edge with guard for exceeding time
        boundTemplate.addEdge(bodyEndLoc, timeExceedLoc, exceedGuard, null, null);

        // Create end location and set template to loop
        Location boundDone = boundTemplate.addLocation("Bound_done", 150, -150);
        boundTemplate.setLooping();

        // Add blocks if any
        handleBoundBlocks(boundStatementNode, boundTemplate, timeExceedLoc, timeOKLoc, boundDone);

        // Create break edges
        bodyStatements.forEach(location -> breakBoundStmt(location, boundTemplate, timeExceedLoc, exceedGuard, killSync));
    }

    // Add edge for every statement in bound template to break if body if time is exceeded
    private void breakBoundStmt(Location location, UPPTemplate template, Location timeExceedLoc, String exceedGuard, String killSync) {
        if (location.getName().startsWith("called_")) {
            // Bound entered new scope, need to handle a break from sync. Guard is checked inside scope
            template.addEdge(location, timeExceedLoc, null, killSync + "?", null);
        } else {
            template.addEdge(location, timeExceedLoc, exceedGuard, null, null);
        }
    }

    private void handleBoundBlocks(BoundStatementNode boundStatementNode, UPPTemplate boundTemplate, Location timeExceedLoc, Location timeOKLoc, Location endLocation) {
        Location startCatch = null;
        Location endCatch = null;
        Location startFinal = null;
        // visit Catch
        if (boundStatementNode.getCatchBlock() != null) {
            startCatch = visitBoundBlock(boundStatementNode.getCatchBlock(), boundTemplate, "Catch", timeExceedLoc, endLocation);
            endCatch = getLast(boundTemplate.getLocationList());
        }
        // visit Final
        if (boundStatementNode.getFinalBlock() != null) {
            startFinal = visitBoundBlock(boundStatementNode.getFinalBlock(), boundTemplate, "Final", timeOKLoc, endLocation);
            // Last location in final goes to end of bound
            boundTemplate.addEdge(getLast(boundTemplate.getLocationList()), endLocation, null, null, null);
        }

        // Make sure all end locations to to next block or end of bound
        if (startFinal != null && startCatch != null)
            // Catch goes into final block if both exists
            boundTemplate.addEdge(endCatch, startFinal, null, null, null);
        else if (startCatch != null) {
            // If no final block, go straight to end of bound
            boundTemplate.addEdge(endCatch, endLocation, null, null, null);
            boundTemplate.addEdge(timeOKLoc, endLocation, null, null, null);
        } else if (startFinal != null) {
            // If no catch block
            boundTemplate.addEdge(timeExceedLoc, endLocation, null, null, null);
        } else {
            boundTemplate.addEdge(timeOKLoc, endLocation, null, null, null);
            boundTemplate.addEdge(timeExceedLoc, endLocation, null, null, null);
        }
    }

    // Returns location for starting block
    private Location visitBoundBlock(BlockNode block, UPPTemplate template, String name, Location prevLocation, Location endLocation) {

        // Create location for starting block
        Location startBlock = template.addLocation("Start_" + name, prevLocation.getX() + 75, prevLocation.getY());
        template.addEdge(prevLocation, startBlock, null, null, null);

        // Add edge from previous location to new start
        template.addEdge(prevLocation, getLast(template.getLocationList()), null, null, null);

        // visit block
        visitBlock(block, template);
        // End location for block
        template.edgeFromLastLoc(name + "_done", null, null, null);

        return startBlock;
    }

    private void visitFuncDecl(FunctionDeclarationNode functionDeclarationNode) {
        // Create new template
        UPPTemplate template = system.createTemplate(functionDeclarationNode.getFunctionName());
        // Create channel to start new template
        templateChanMap.put(template, "begin_" + functionDeclarationNode.getFunctionName());
        visitBlock(functionDeclarationNode.getBlockNode(), template);
        template.edgeFromLastLoc("End_" + functionDeclarationNode.getFunctionName(), null, null, null);
        template.setLooping();

        //Setup location for breaking bounds as last location in list, might not be used
        Location boundKill = template.addLocation("bound_kill",75, -100);

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

    /**
     * Returns last element of a list
     *
     * @param list list containing the element
     * @return last element in list
     */
    private <T> T getLast(List<T> list) {
        return list.get(list.size() - 1);
    }
}
