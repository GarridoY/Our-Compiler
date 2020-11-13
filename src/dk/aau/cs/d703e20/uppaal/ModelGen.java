package dk.aau.cs.d703e20.uppaal;

import com.uppaal.model.core2.Location;
import com.uppaal.model.core2.Node;
import com.uppaal.model.core2.PrototypeDocument;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.statements.PinDeclarationNode;
import dk.aau.cs.d703e20.ast.statements.StatementNode;
import dk.aau.cs.d703e20.ast.statements.VariableDeclarationNode;
import dk.aau.cs.d703e20.ast.structure.*;
import dk.aau.cs.d703e20.uppaal.structures.UPPSystem;
import dk.aau.cs.d703e20.uppaal.structures.UPPTemplate;

import java.io.IOException;
import java.util.HashMap;


public class ModelGen {
    // New system with default properties
    UPPSystem system = new UPPSystem(new PrototypeDocument());
    // Map of channels to start templates from loop
    HashMap<UPPTemplate, String> chanMap = new HashMap<>();

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

    // Adds declaration from pair to global scope
    private void printChanMap(UPPTemplate key, String value) {
        system.getGlobalDeclSB().append("chan ").append(value).append(";\n");
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
        template.flushSB();
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
                visitPinDecl((PinDeclarationNode) statementNode, system);
            }
        }
        chanMap.forEach(this::printChanMap);
        system.setProperty("declaration", system.getGlobalDeclSB().toString());
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
            visitPinDecl((PinDeclarationNode) statementNode, template);
        else if (statementNode instanceof VariableDeclarationNode)
            visitVarDecl((VariableDeclarationNode) statementNode, template);
        /*
        TODO:
          visitAssignment (only for clock)
          visitFunctionCall, begin_Function!
          visitIfElseStatement, create new template
          visitIterativeStatement, create new template
          visitAtStatement, create new template
          visitBoundStatement, create new template
         */
    }

    /**
     * Add PinDeclaration as chan to template/global.
     * StringBuilder is used as all properties have to be set at once.
     *
     * @param node        UPPTemplate or UPPSystem
     * @param pinDeclNode Source StatementNode
     */
    private void visitPinDecl(PinDeclarationNode pinDeclNode, Node node) {
        String pinDecl = "chan ".concat(Enums.stringFromPinType(pinDeclNode.getPinType())).concat(pinDeclNode.getPinNumber()).concat(";\n");
        if (node instanceof UPPSystem) {
            ((UPPSystem) node).getGlobalDeclSB().append(pinDecl);
        } else if (node instanceof UPPTemplate) {
            ((UPPTemplate) node).getDeclSB().append(pinDecl);
        } else
            throw new IllegalArgumentException("Wrong Node instance");
    }

    /**
     * Add clocks to template/system
     *
     * @param varDeclNode Source StatementNode
     * @param node        UPPTemplate or UPPSystem
     */
    private void visitVarDecl(VariableDeclarationNode varDeclNode, Node node) {
        String varDecl = "clock ".concat(varDeclNode.getVariableName()).concat(";\n");
        if (varDeclNode.getDataType() == Enums.DataType.CLOCK) {
            if (node instanceof UPPSystem) {
                ((UPPSystem) node).getGlobalDeclSB().append(varDecl);
            } else if (node instanceof UPPTemplate) {
                ((UPPTemplate) node).getDeclSB().append(varDecl);
            } else
                throw new IllegalArgumentException("Wrong Node instance");
        }
    }

    private void visitFuncDecl(FunctionDeclarationNode functionDeclarationNode) {
        // Create new template
        UPPTemplate template = system.createTemplate(functionDeclarationNode.getFunctionName());
        chanMap.put(template, "begin_" + functionDeclarationNode.getFunctionName());
        visitBlock(functionDeclarationNode.getBlockNode(), template);
        // Flush StringBuilder into property
        template.flushSB();
    }
}
