package dk.aau.cs.d703e20.uppaal;

import com.uppaal.model.core2.Location;
import com.uppaal.model.core2.Node;
import com.uppaal.model.core2.PrototypeDocument;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.statements.PinDeclarationNode;
import dk.aau.cs.d703e20.ast.statements.StatementNode;
import dk.aau.cs.d703e20.ast.statements.VariableDeclarationNode;
import dk.aau.cs.d703e20.ast.structure.BlockNode;
import dk.aau.cs.d703e20.ast.structure.FunctionDeclarationNode;
import dk.aau.cs.d703e20.ast.structure.ProgramNode;
import dk.aau.cs.d703e20.ast.structure.SetupNode;
import dk.aau.cs.d703e20.uppaal.structures.UPPSystem;
import dk.aau.cs.d703e20.uppaal.structures.UPPTemplate;

import java.io.IOException;


public class ModelGen {
    // New system with default properties
    UPPSystem system = new UPPSystem(new PrototypeDocument());

    // sample setup and debugging
    void createExample() {
        // Model requires at least 1 template
        UPPTemplate t = system.createTemplate("exampleTemplate");
        // Add location for new template t
        Location l0 = t.addLocation("L0", 0, 0);
        // Location is initial
        l0.setProperty("init", true);
        // add system declaration:
        system.setProperty("system", "Exp1=exampleTemplate();\n" + "system Exp1;");

        // Save model for debugging
        try {
            String path = System.getProperty("user.dir");
            system.save(path + "\\Resources\\output\\hej.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Begins the process of generating UPPAAL code corresponding to the program
     *
     * @param programNode Top node of program AST
     * @return Document for UPPAAL to compile
     */
    public UPPSystem visitProgram(ProgramNode programNode) {
        visitSetup(programNode.getSetupNode());
        //TODO: visitLoop();
        createExample(); //TODO: remove
        return system;
    }

    /**
     * Goes through all declarations made in setup() and adds them to global UPPAAL scope
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
        system.setProperty("declaration", system.getGlobalDeclSB().toString());
    }

    /**
     * Visit new block.
     * Pass StringBuilder of new template.
     *
     * @param blockNode     Block of current node
     * @param stringBuilder StringBuilder from current visitor
     */
    private void visitBlock(BlockNode blockNode, StringBuilder stringBuilder, UPPTemplate template) {
        for (StatementNode statementNode : blockNode.getStatementNodes()) {
            visitStatement(statementNode, stringBuilder, template);
        }
    }

    /**
     * Select visitor based on type of statement.
     * Some of these visitors open new templates.
     *
     * @param statementNode From a BlockNode
     * @param stringBuilder From a BlockNode
     */
    private void visitStatement(StatementNode statementNode, StringBuilder stringBuilder, UPPTemplate template) {
        if (statementNode instanceof PinDeclarationNode)
            visitPinDecl((PinDeclarationNode) statementNode, template);
        else if (statementNode instanceof VariableDeclarationNode)
            visitVarDecl((VariableDeclarationNode) statementNode, template);
        /*
        TODO:
          visitAssignment (only for clock)
          visitFunctionCall
          visitIfElseStatement, create new template
          visitIterativeStatement
          visitAtStatement, create new template
          visitBoundStatement, create new template
          visitReturnStatement
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
        // TODO: create new template
    }
}
