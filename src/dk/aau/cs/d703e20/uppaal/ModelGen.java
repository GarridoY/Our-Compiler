package dk.aau.cs.d703e20.uppaal;

import com.uppaal.model.core2.*;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.statements.*;
import dk.aau.cs.d703e20.ast.structure.*;
import dk.aau.cs.d703e20.uppaal.structures.UPPSystem;
import dk.aau.cs.d703e20.uppaal.structures.UPPTemplate;

import java.io.IOException;
import java.util.HashMap;

import static dk.aau.cs.d703e20.uppaal.structures.UPPTemplate.setNail;


public class ModelGen {
    // New system with default properties
    UPPSystem system = new UPPSystem(new PrototypeDocument());
    // Map of channels to start templates from loop
    HashMap<UPPTemplate, String> templateChanMap = new HashMap<>();
    // Map of io pins (name, number)
    HashMap<String, Integer> pinChanMap = new HashMap<>();

    int atCount = 0;
    int boundCount = 0;
    // count the amount of channels needed
    int opinCount = 0;
    int ipinCount = 0;
    String opinChanName = "out";
    String ipinChanName = "in";

    // sample setup and debugging
    void createExample() {
        // Model requires at least 1 template
        UPPTemplate t = system.createTemplate("exampleTemplate");
        // Add location for new template t
        Location l0 = t.addLocation("L0", 0, 0);
        // Location is initial
        l0.setProperty("init", true);
        // add system declaration
        system.setDeclaration();

        // Save model for debugging
        try {
            String path = System.getProperty("user.dir");
            system.save(path + "\\Resources\\output\\hej.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
     * @return Document for UPPAAL to compile
     */
    public UPPSystem visitProgram(ProgramNode programNode) {
        programNode.getFunctionDeclarationNodes().forEach(this::visitFuncDecl);
        visitLoop(programNode.getLoopNode());
        visitSetup(programNode.getSetupNode());
        createExample(); //TODO: remove
        return system;
    }

    private void visitLoop(LoopNode loopNode) {
        UPPTemplate template = system.createTemplate("controller");
        visitBlock(loopNode.getBlockNode(), template);
        template.setDeclaration();
    }

    /**
     * Goes through all declarations made in setup() and finally sets global UPPAAL scope
     *
     * @param setupNode Source setup() from programNode
     */
    private void visitSetup(SetupNode setupNode) {
        // visitBlock(setupNode.getBlockNode(), doc); TODO: figure out if setup needs more than variables

        // Find all declarations
        for (StatementNode statementNode : setupNode.getBlockNode().getStatementNodes()) {
            if (statementNode instanceof VariableDeclarationNode) {
                visitVarDecl((VariableDeclarationNode) statementNode, system);
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
        system.setGlobalDecl();
    }

    /**
     * Visit new block.
     * Pass StringBuilder of new template.
     *
     * @param blockNode Block of current node
     * @param template  Current UPPTemplate for statement, function declaration or loop
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
     * @param template      Current template from BlockNode
     */
    private void visitStatement(StatementNode statementNode, UPPTemplate template) {
        if (statementNode instanceof PinDeclarationNode)
            visitPinDecl((PinDeclarationNode) statementNode);
        else if (statementNode instanceof VariableDeclarationNode)
            visitVarDecl((VariableDeclarationNode) statementNode, template);
        else if (statementNode instanceof AtStatementNode)
            visitAtStatement((AtStatementNode) statementNode);
        else if (statementNode instanceof BoundStatementNode)
            visitBoundStatement((BoundStatementNode) statementNode);

        /*
        TODO:
          visitAssignment (only for clock)
          visitFunctionCall, begin_Function!
          visitIfElseStatement, create new template
          visitIterativeStatement, create new template
         */
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
     * Add clocks to template/system
     *
     * @param varDeclNode Source StatementNode
     * @param node        UPPTemplate or UPPSystem
     */
    private void visitVarDecl(VariableDeclarationNode varDeclNode, Node node) {
        if (node instanceof UPPSystem) {
            ((UPPSystem) node).addDecl(varDeclNode);
        } else if (node instanceof UPPTemplate) {
            ((UPPTemplate) node).addDecl(varDeclNode);
        } else
            throw new IllegalArgumentException("Wrong Node instance");
    }

    private void visitAtStatement(AtStatementNode atStatementNode) {
        // Create new template
        UPPTemplate template = system.createTemplate("At" + atCount);
        templateChanMap.put(template, "begin_" + "AT" + atCount);
        visitBlock(atStatementNode.getBlockNode(), template);

        // Flush StringBuilder into property
        template.setDeclaration();
    }

    private void visitBoundStatement(BoundStatementNode boundStatementNode) {
        // Create new template
        UPPTemplate template = system.createTemplate("Bound" + boundCount);
        templateChanMap.put(template, "begin_" + "Bound" + boundCount);
        visitBlock(boundStatementNode.getBody(), template);

        // Check for additional blocks
        if (boundStatementNode.getCatchBlock() != null) {
            visitBlock(boundStatementNode.getCatchBlock(), template);
        }
        if (boundStatementNode.getFinalBlock() != null) {
            visitBlock(boundStatementNode.getFinalBlock(), template);
        }

        // Flush StringBuilder into property
        template.setDeclaration();
    }

    private void visitFuncDecl(FunctionDeclarationNode functionDeclarationNode) {
        // Create new template
        UPPTemplate template = system.createTemplate(functionDeclarationNode.getFunctionName());
        templateChanMap.put(template, "begin_" + functionDeclarationNode.getFunctionName());
        visitBlock(functionDeclarationNode.getBlockNode(), template);

        // Flush StringBuilder into property
        template.setDeclaration();
    }
}
