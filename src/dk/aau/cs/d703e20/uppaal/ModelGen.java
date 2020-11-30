package dk.aau.cs.d703e20.uppaal;

import com.uppaal.model.core2.Edge;
import com.uppaal.model.core2.Location;
import com.uppaal.model.core2.PrototypeDocument;
import dk.aau.cs.d703e20.ast.Enums;
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

    int atCount = 0;
    int boundCount = 0;
    // count the amount of channels needed
    int opinCount = 0;
    int ipinCount = 0;
    String opinChanName = "out";
    String ipinChanName = "in";


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
        visitLoop(programNode.getLoopNode());
        visitSetup(programNode.getSetupNode());
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
                visitVarDecl((VariableDeclarationNode) statementNode);
            } else if (statementNode instanceof PinDeclarationNode) {
                visitPinDecl((PinDeclarationNode) statementNode);
            }
        }
        // Add channel with size of ipin & opin counts
        if (opinCount > 0)
            system.addChan(opinChanName, opinCount, Enums.PinType.OPIN);
        if (ipinCount > 0)
            system.addChan(ipinChanName, ipinCount, Enums.PinType.IPIN);
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
     * Select visitor based on type of statement.
     * Some of these visitors open new templates.
     *
     * @param statementNode Current statement in BlockNode
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
        // Is variable pin?
        if (pinChanMap.containsKey(assignmentNode.getVariableName())) {
            if (assignmentNode.getLiteralValue().equals("true")) {
                // chan! update pin to value 1
            } else if (assignmentNode.getLiteralValue().equals("false")) {
                // chan! update pin to value 0
            }
            template.edgeFromLastLoc("Assigned", null, null, opinChanName.concat("[") + pinChanMap.get(assignmentNode.getVariableName()) + "]!");
        } else if (clockList.contains(assignmentNode.getVariableName())) {
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
        // Only clock types are used in UPPAAL
        // All clocks are global due to scoping with templates
        if (varDeclNode.getDataType() == Enums.DataType.CLOCK) {
            system.addClockDecl(varDeclNode);
            clockList.add(varDeclNode.getVariableName());
        }
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
    }
}
