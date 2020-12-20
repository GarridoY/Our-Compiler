package dk.aau.cs.d703e20.uppaal;

import com.uppaal.model.core2.Edge;
import com.uppaal.model.core2.Location;
import com.uppaal.model.core2.Node;
import com.uppaal.model.core2.PrototypeDocument;
import dk.aau.cs.d703e20.Pair;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.expressions.*;
import dk.aau.cs.d703e20.ast.statements.*;
import dk.aau.cs.d703e20.ast.structure.*;
import dk.aau.cs.d703e20.uppaal.structures.UPPSystem;
import dk.aau.cs.d703e20.uppaal.structures.UPPTemplate;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

import static dk.aau.cs.d703e20.uppaal.structures.UPPTemplate.setLabel;
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
    // Map of varName and values, also stores return value of function. TODO: Use another map for return values
    HashMap<String, String> varValues = new HashMap<>();
    HashMap<String, List<ArrayParamNode>> arrayValues = new HashMap<>();

    Set<String> functionSyncSet = new HashSet<>();

    // Stack of (guard, sync) used to check time after each statement and return to bound
    Stack<Pair<String, String>> boundGuardKillSync = new Stack<>();

    private final HashMap<String, Boolean> varConstMap;

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

    public ModelGen(HashMap<String, Boolean> varConstMap) {
        this.varConstMap = varConstMap;
    }

    /**
     * Find the ID for new templates
     *
     * @return all counts + 1
     */
    private int getID() {
        // Controller = 0, IO = 1
        return templateChanMap.size() + 2;
    }

    // Create template to handle world input/output
    private void createNaiveWorldModel() {
        UPPTemplate template = system.createTemplate("Naive_World", 1);

        // New edge from/to init for input chan
        if (ipinCount > 0) {
            Edge inputHandler = template.addFreeEdge(template.getLocationList().get(0), template.getLocationList().get(0), null, "inPin[i][1]!", null);
            UPPTemplate.setLabel(inputHandler, UPPTemplate.EKind.select, "i : int[0," + (ipinCount - 1) + "]", 0, 0);
            setNail(inputHandler, -10, -5);
            setNail(inputHandler, -10, 5);
        }

        // New edge from/to init for output
        if (opinCount > 0) {
            Edge outputHandler = template.addFreeEdge(template.getLocationList().get(0), template.getLocationList().get(0), null, "outPin[i][j]?", null);
            UPPTemplate.setLabel(outputHandler, UPPTemplate.EKind.select, "i : int[0," + (opinCount - 1) + "], j : int[0,1]", 0, 0);
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
    private UPPTemplate syncIntoNewTemplate(String templateName, UPPTemplate prevTemplate) {
        // Create new template
        UPPTemplate newTemplate = system.createTemplate(templateName, getID());

        // Create channel for synchronisation
        String chan = "begin_" + templateName;
        templateChanMap.put(newTemplate, chan);

        // Add edge to new template for sync
        Location tempLastLoc = getLast(newTemplate.getLocationList());
        Location syncDone = newTemplate.addLocation("Sync_done");
        newTemplate.addFreeEdge(tempLastLoc, syncDone, null, chan + "?", "returnLock = prevLock");

        // Add edge to previous template to sync into new one
        Location prevTempLastLoc = getLast(prevTemplate.getLocationList());
        Location called = prevTemplate.addLocation("called_" + newTemplate.getName());
        if (!newTemplate.getName().startsWith("At"))
            prevTemplate.addFreeEdge(prevTempLastLoc, called, "atNotRunning", chan + "!", "lock = " + newTemplate.getId() + ", prevLock = " + prevTemplate.getId());
        else
            prevTemplate.addFreeEdge(prevTempLastLoc, called, null, chan + "!", "prevLock = " + prevTemplate.getId());

        // Add edge to wait for template to finish
        prevTemplate.chainLoc(newTemplate.getName() + "_done", null, null, null);


        return newTemplate;
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
            template.getLocationList().subList(0, template.getLocationList().size() - 2).forEach(location -> template.addEdge(location, boundKill, boundGuardKillSync.peek().getFirst(), boundGuardKillSync.peek().getSecond() + "!", null));
        }
    }

    // Used in functions to avoid multiple identical locations
    private void setBoundBreakEdges(StatementNode statementNode, UPPTemplate template, Location boundKill) {
        if (statementNode.isBounded()) {
            // Make sure template can be reset
            template.setLooping();
            // Add an extra edge for every location, to break out of template
            template.getLocationList().subList(0, template.getLocationList().size() - 2).forEach(location -> template.addEdge(location, boundKill, boundGuardKillSync.peek().getFirst(), boundGuardKillSync.peek().getSecond() + "!", null));
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
        system.setSysDeclaration();
        system.toXML(); //TODO: remove
        return system;
    }

    private void visitLoop(LoopNode loopNode) {
        UPPTemplate template = system.createTemplate("controller", 0);
        template.setLocalReturnLock("int returnLock = 0; ");
        visitBlock(loopNode.getBlockNode(), template);
        template.chainLoc("End_controller", null, null, null);
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
                visitVarDecl((VariableDeclarationNode) statementNode, null);
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
            visitVarDecl((VariableDeclarationNode) statementNode, template);
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
        UPPTemplate forTemplate = syncIntoNewTemplate("For" + forCount, prevTemplate);
        forCount++;

        // Loop location, requires var
        String loopVar = "loopIndex";
        forTemplate.addVar("int " + loopVar + " = 0");
        // initialize loop template by setting loopVar
        Location loopLoc = forTemplate.chainLoc("loop", null, null, loopVar + " = " + getValueArithExpr(forLoopNode.getArithExpressionNode1()));
        // TODO: consider making loop location urgent

        // First location of loop iteration
        forTemplate.chainLoc("iterate", loopVar + " != " + getValueArithExpr(forLoopNode.getArithExpressionNode2()), null, null);

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

        setBoundBreakEdges(forLoopNode, forTemplate);
    }

    private void visitWhileStatement(WhileStatementNode whileStatementNode, UPPTemplate prevTemplate) {
        UPPTemplate whileTemplate = syncIntoNewTemplate("While" + whileCount, prevTemplate);
        whileCount++;

        // Setup start loop location for looping
        Location startLoop = whileTemplate.addLocation("Start_loop");
        // Edge from sync_done to starting loop
        whileTemplate.addEdge(whileTemplate.getLocationList().get(1), startLoop, null, null, null);

        // Add block
        visitBlock(whileStatementNode.getBlockNode(), whileTemplate);

        // Add end location
        whileTemplate.chainLoc("End_loop", null, null, null);
        // Add uncontrollable edge from "End_loop" to "Start_loop" locations, used to simulate the while loop
        whileTemplate.addEdge(getLast(whileTemplate.getLocationList()), startLoop, null, null, null).setProperty("controllable", false);

        whileTemplate.chainLoc("While_end", null, null, null);
        whileTemplate.setLooping();

        setBoundBreakEdges(whileStatementNode, whileTemplate);
    }

    private void visitIfElseStatement(IfElseStatementNode ifElseStatementNode, UPPTemplate prevTemplate) {
        final int locationCoord = 75;
        // Create new template and sync with previous
        UPPTemplate ifTemplate = syncIntoNewTemplate("If" + ifCount, prevTemplate);
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
        ifTemplate.setLooping();
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
            int output = 0;
            if (assignmentNode.getLiteralValue() != null) {
                if (assignmentNode.getLiteralValue().equals("true")) {
                    // chan! update pin to value 1
                    template.chainLoc("", null, opinChanName + "[" + pinChanMap.get(assignmentNode.getVariableName()) + "][1]!", null);
                } else if (assignmentNode.getLiteralValue().equals("false")) {
                    // chan! update pin to value 0
                    template.chainLoc("", null, opinChanName + "[" + pinChanMap.get(assignmentNode.getVariableName()) + "][0]!", null);
                }
            } else if (assignmentNode.getVariableName() != null) {

                if (varConstMap.get(assignmentNode.getArithExpressionNode().getVariableName())) {
                    // Var is constant
                    // lookup if var is true, then 1, else output = 0
                    if (varValues.get(assignmentNode.getArithExpressionNode().getVariableName()).equals("true"))
                        output = 1;
                    template.chainLoc("", null, opinChanName + "[" + pinChanMap.get(assignmentNode.getVariableName()) + "][" + output + "]!", null);
                } else {
                    // Case: var in not constant = use select
                    template.chainLoc("", null, opinChanName + "[" + pinChanMap.get(assignmentNode.getVariableName()) + "][e]!", null);
                    Edge edgeSelectPin = getLast(getEdges(template));
                    setLabel(edgeSelectPin, UPPTemplate.EKind.select, "e : int[0,1]", 0, 0);
                }

            }
        }
        // Is variable clock?
        else if (clockList.contains(assignmentNode.getVariableName())) {
            // Update string
            String updateStmt = assignmentNode.getVariableName() + " = " + getValueArithExpr(assignmentNode.getArithExpressionNode());
                    assignmentNode.getArithExpressionNode().prettyPrint(0);

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

            assert functionTemplate != null;

            // Get chan name for starting function template
            functionChan = templateChanMap.get(functionTemplate);
            // Add sync edge to current template, sync starts the function template
            currentTemplate.addFreeEdge(getLast(currentTemplate.getLocationList()), currentTemplate.addLocation("called_" + functionCallNode.getFunctionName()), null, functionChan + "!", "lock = " + functionTemplate.getId() + ", prevLock = " + currentTemplate.getId());
            // Add edge to wait for template to finish
            currentTemplate.chainLoc(functionTemplate.getName() + "_done", null, null, null);

            // Add sync edge to function template to receive sync from the call
            if (functionSyncSet.add(functionChan))
                functionTemplate.addFreeEdge(functionTemplate.getLocationList().get(0), functionTemplate.getLocationList().get(1), null, functionChan + "?", "returnLock = prevLock");

            // Set the function template to be able to break bound
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
        currentTemplate.chainLoc("reset_local_clock", null, null, localClockName + " = 0");
        // Guard template to wait the given amount
        currentTemplate.chainLoc("finished_" + functionCallNode.getFunctionName(), localClockName + " > (" + delay + ")", null, null);
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
    private void visitVarDecl(VariableDeclarationNode varDeclNode, UPPTemplate template) {
        // Save variable name and its value in map for later use
        if (varDeclNode.getAssignmentNode() != null) {
            if (varDeclNode.getAssignmentNode().getArithExpressionNode() != null)
                varValues.put(varDeclNode.getAssignmentNode().getVariableName(), getValueArithExpr(varDeclNode.getAssignmentNode().getArithExpressionNode()));
            else if (varDeclNode.getAssignmentNode().getLiteralValue() != null)
                varValues.put(varDeclNode.getAssignmentNode().getVariableName(), varDeclNode.getAssignmentNode().getLiteralValue());
        } else if (varDeclNode.getAssignArrayNode() != null)
            arrayValues.put(varDeclNode.getAssignArrayNode().getVariableName(), varDeclNode.getAssignArrayNode().getParamNodes());

        // Only clock types are used in UPPAAL
        // All clocks are global due to scoping with templates
        if (varDeclNode.getDataType() == Enums.DataType.CLOCK) {
            system.addClockDecl(varDeclNode);
            clockList.add(varDeclNode.getVariableName());
            if (!varDeclNode.isInSetup())
                template.chainLoc("", null, null, varDeclNode.getVariableName() + " = 0");
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

    private String calcTimeFunc(ArithExpressionNode arithExpressionNode, int timeUnit) {
        // Cast argument to double, calculate the value, cast it back to string for printing to UPPAAL
        return Integer.toString((int) (Double.parseDouble(getValueArithExpr(arithExpressionNode.getFunctionCallNode().getFunctionArgNodes().get(0).getArithExpressionNode())) * timeUnit));
    }

    private String getValueArithExpr(ArithExpressionNode arithExpressionNode) {
        String value;
        // If arg is a variable name, get its value from map
        if (arithExpressionNode.getVariableName() != null) {
            if (clockList.contains(arithExpressionNode.getVariableName())) {
                value = arithExpressionNode.getVariableName();
            } else
                value = varValues.get(arithExpressionNode.getVariableName());
        }
        // If arg is a function call get the value of its return
        else if (arithExpressionNode.getFunctionCallNode() != null) {
            // Check for time specific functions
            value = switch (arithExpressionNode.getFunctionCallNode().getFunctionName()) {
                case "Seconds" -> calcTimeFunc(arithExpressionNode, 1000);
                case "Minutes" -> calcTimeFunc(arithExpressionNode, 1000 * 60);
                case "Hours" -> calcTimeFunc(arithExpressionNode, 1000 * 60 * 60);
                case "Days" -> calcTimeFunc(arithExpressionNode, 1000 * 60 * 60 * 24);
                default -> varValues.get(arithExpressionNode.getFunctionCallNode().getFunctionName());
            };
        } else if (arithExpressionNode.getSubscriptNode() != null) {
            value = getValueSubscript(arithExpressionNode.getSubscriptNode());
        } else if (arithExpressionNode.getArithExpressionNode1() != null) {
            // arithExpr arithOp arithExpr
            value = '(' + getValueArithExpr(arithExpressionNode.getArithExpressionNode1()) + arithExpressionNode.getArithExpressionOperator() + getValueArithExpr(arithExpressionNode.getArithExpressionNode2()) + ')';
        } else
            // Handles number case
            value = arithExpressionNode.prettyPrint(0);
        return value;
    }

    private List<String> getOperandValues(List<BoolExprOperandNode> operands) {
        List<String> guardOperands = new ArrayList<>();
        // Handle operand by finding value and casting to string
        for (BoolExprOperandNode operand : operands) {
            if (operand.getBoolExpressionNode() != null)
                guardOperands.add('(' + findGuard(operand.getBoolExpressionNode()) + ')');
            else
                guardOperands.add(getValueArithExpr(operand.getArithExpressionNode()));
        }
        return guardOperands;
    }

    private String findGuard(BoolExpressionNode boolExpressionNode) {
        StringBuilder guardBuilder = new StringBuilder();
        int index = 0;

        if (!boolExpressionNode.getBoolExprOperandNodes().isEmpty()) {
            // Cast all operand values to string
            List<String> guardOperands = getOperandValues(boolExpressionNode.getBoolExprOperandNodes());
            for (String guardOperand : guardOperands) {
                guardBuilder.append(guardOperand);
                // Add operator, but avoid NullPointer from last operand, since there is 1 more operand than operator
                if (index <= boolExpressionNode.getBoolExpressionOperators().size() - 1)
                    guardBuilder.append(" ").append(Enums.stringFromBoolOperator(boolExpressionNode.getBoolExpressionOperators().get(index))).append(" ");
                index++;
            }
            return guardBuilder.toString();
        }
        if (boolExpressionNode.getOptionalNot()) {
            return "!(" + findGuard(boolExpressionNode.getBoolExpressionNode()) + ")";
        }
        throw new RuntimeException("Guard was not found");
    }

    private String findInvariant(BoolExpressionNode boolExpressionNode) {
        StringBuilder invariantBuilder = new StringBuilder();
        int operandIndex = 0;

        // Handle lower bounds of guard
        if (!boolExpressionNode.getBoolExprOperandNodes().isEmpty()) {
            // Cast all operand values to string
            List<String> invarOperands = getOperandValues(boolExpressionNode.getBoolExprOperandNodes());

            for (Enums.BoolOperator operator : boolExpressionNode.getBoolExpressionOperators()) {
                if ((operator == Enums.BoolOperator.LESS_THAN || operator == Enums.BoolOperator.LESS_OR_EQUAL) && clockList.contains(invarOperands.get(operandIndex))) {
                    invariantBuilder.append(invarOperands.get(operandIndex)).append(" <= ").append(invarOperands.get(operandIndex + 1));
                } else if ((operator == Enums.BoolOperator.GREATER_THAN || operator == Enums.BoolOperator.GREATER_OR_EQUAL) && clockList.contains(invarOperands.get(operandIndex + 1))) {
                    invariantBuilder.append(invarOperands.get(operandIndex + 1)).append(" <= ").append(invarOperands.get(operandIndex));
                } else if (operator == Enums.BoolOperator.EQUAL) {
                    if (clockList.contains(invarOperands.get(operandIndex)))
                        invariantBuilder.append(invarOperands.get(operandIndex)).append(" <= ").append(invarOperands.get(operandIndex + 1));
                    else if (clockList.contains(invarOperands.get(operandIndex + 1)))
                        invariantBuilder.append(invarOperands.get(operandIndex + 1)).append(" <= ").append(invarOperands.get(operandIndex));
                } else if (operator == Enums.BoolOperator.OR || operator == Enums.BoolOperator.AND) {
                    invariantBuilder.append("(").append(invarOperands.get(operandIndex)).append(")").append(" ").append(operator).append(" ").append("(").append(invarOperands.get(operandIndex + 1)).append(")");
                }

                operandIndex++;
            }
            return invariantBuilder.toString();
        }

        if (boolExpressionNode.getOptionalNot()) {
            return "!(" + findInvariant(boolExpressionNode.getBoolExpressionNode()) + ")";
        }

        throw new RuntimeException("Could not find proper invariant");
    }

    private void visitAtStatement(AtStatementNode atStatementNode, UPPTemplate prevTemplate) {
        // Create new template and sync with previous
        UPPTemplate atTemplate = syncIntoNewTemplate("At" + atCount, prevTemplate);
        atCount++;
        Location syncDone = getLast(atTemplate.getLocationList());
        // Add invariant
        setLabel(syncDone, UPPTemplate.LKind.invariant, findInvariant(atStatementNode.getAtParamsNode().getBoolExpressionNode()), syncDone.getX(), syncDone.getY());

        // Edge and location for starting at (when atParam is ready)
        Location startAt = atTemplate.addLocation("startAt");
        String guard = findGuard(atStatementNode.getAtParamsNode().getBoolExpressionNode());
        atTemplate.addFreeEdge(syncDone, startAt, guard, null, "lock = " + atTemplate.getId() + ", returnLock = prevLock, atNotRunning = false");

        visitBlock(atStatementNode.getBlockNode(), atTemplate);

        // Edge and location for ending 'at' for model verification.
        atTemplate.chainLoc("endAt", null, null, null);

        atTemplate.setLooping();

        setBoundBreakEdges(atStatementNode, atTemplate);
    }

    // Run body, check if time is exceeded, then run catch and final or just final
    private void visitBoundStatement(BoundStatementNode boundStatementNode, UPPTemplate prevTemplate) {
        // Create new template and sync with previous
        UPPTemplate boundTemplate = syncIntoNewTemplate("Bound" + boundCount, prevTemplate);
        boundCount++;

        // Add guard and sync to stack used to kill statements within bound scope
        String exceedGuard = findGuard(boundStatementNode.getAtParamsNode().getBoolExpressionNode()).replaceAll("(<=|<)", ">");
        String killSync = "kill" + boundCount;
        utilChan.add(killSync);
        boundGuardKillSync.push(new Pair<>(exceedGuard, killSync));

        // Visit block
        visitBlock(boundStatementNode.getBody(), boundTemplate);

        // Save list of all body locations, used to add time exceptions
        final List<Location> bodyStatements = new ArrayList<>(boundTemplate.getLocationList().subList(2, boundTemplate.getLocationList().size()));
        // Pop stack as we exit bound body
        boundGuardKillSync.pop();

        // Done location, save the location for body end, as we branch out
        Location bodyEndLoc = boundTemplate.chainLoc("body_done", null, null, null);

        Location timeOKLoc;
        // Check if blocking
        if (boundStatementNode.getBoolLiteral()) {
            // Bound param, where '<' is changed to '=='
            String guard = findGuard(boundStatementNode.getAtParamsNode().getBoolExpressionNode()).replaceAll("(<=|<)", "==");
            timeOKLoc = boundTemplate.chainLoc("Time_OK", guard, null, null);
        } else
            timeOKLoc = boundTemplate.chainLoc("Time_OK", findGuard(boundStatementNode.getAtParamsNode().getBoolExpressionNode()), null, null);

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
            startCatch = visitBoundBlock(boundStatementNode.getCatchBlock(), boundTemplate, "Catch", timeExceedLoc);
            endCatch = getLast(boundTemplate.getLocationList());
        }
        // visit Final
        if (boundStatementNode.getFinalBlock() != null) {
            startFinal = visitBoundBlock(boundStatementNode.getFinalBlock(), boundTemplate, "Final", timeOKLoc);
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
    private Location visitBoundBlock(BlockNode block, UPPTemplate template, String name, Location prevLocation) {

        // Create location for starting block
        Location startBlock = template.addLocation("Start_" + name, prevLocation.getX() + 75, prevLocation.getY());
        template.addEdge(prevLocation, startBlock, null, null, null);

        // Add edge from previous location to new start
        template.addEdge(prevLocation, getLast(template.getLocationList()), null, null, null);

        // visit block
        visitBlock(block, template);
        // End location for block
        template.chainLoc(name + "_done", null, null, null);

        return startBlock;
    }

    private void visitFuncDecl(FunctionDeclarationNode functionDeclarationNode) {
        // Create new template
        UPPTemplate template = system.createTemplate(functionDeclarationNode.getFunctionName(), getID());
        // Create channel to start new template
        templateChanMap.put(template, "begin_" + functionDeclarationNode.getFunctionName());
        // New location for starting body, functionCall will join this location with the initial one
        template.addLocation("sync_done");

        visitBlock(functionDeclarationNode.getBlockNode(), template);
        template.chainLoc("End_" + functionDeclarationNode.getFunctionName(), null, null, null);
        template.setLooping();

        // Setup location for breaking bounds as last location in list, used in functionCall if bounded
        template.addLocation("bound_kill", 75, -100);

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

    /**
     * Get a list of all edges in template
     *
     * @param inputNode UPPTemplate with edges to return
     * @return edgeList list of all edges
     */
    private List<Edge> getEdges(Node inputNode) {
        List<Edge> edgeList = new ArrayList<>();
        // Get first node of inputNode in XML
        Node node = inputNode.getFirst();

        // Go through XML elements/nodes top down and add edges to list
        while (node != null) {
            if (node instanceof Edge)
                edgeList.add((Edge) node);
            node = node.getNext();
        }
        // Reverse list as it is built from last to first
        Collections.reverse(edgeList);
        return edgeList;
    }
}
