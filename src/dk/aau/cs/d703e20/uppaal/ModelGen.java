package dk.aau.cs.d703e20.uppaal;

import com.uppaal.model.core2.*;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.statements.PinDeclarationNode;
import dk.aau.cs.d703e20.ast.statements.StatementNode;
import dk.aau.cs.d703e20.ast.statements.VariableDeclarationNode;
import dk.aau.cs.d703e20.ast.structure.BlockNode;
import dk.aau.cs.d703e20.ast.structure.FunctionDeclarationNode;
import dk.aau.cs.d703e20.ast.structure.ProgramNode;
import dk.aau.cs.d703e20.ast.structure.SetupNode;

import java.io.IOException;


public class ModelGen {
    // New model with default properties
    Document doc = new Document(new PrototypeDocument());



    /* TODO:
        Each template is:
        1. Declarations
        2. Transitions
        3. Locations
        Last is:
        4. Queries
    */

    /**
     * Valid kinds of labels on locations.
     */
    public enum LKind {
        name, init, urgent, committed, invariant, exponentialrate, comments
    }

    /**
     * Valid kinds of labels on edges.
     */
    public enum EKind {
        select, guard, synchronisation, assignment, comments
    }

    /**
     * Sets a label on a location.
     *
     * @param l     the location on which the label is going to be attached
     * @param kind  a kind of the label
     * @param value the label value (either boolean or String)
     * @param x     the x coordinate of the label
     * @param y     the y coordinate of the label
     */
    public static void setLabel(Location l, ModelGen.LKind kind, Object value, int x, int y) {
        l.setProperty(kind.name(), value);
        Property p = l.getProperty(kind.name());
        p.setProperty("x", x);
        p.setProperty("y", y);
    }

    /**
     * Adds a location to a template.
     *
     * @param t    the template
     * @param name a name for the new location
     * @param x    the x coordinate of the location
     * @param y    the y coordinate of the location
     * @return the new location instance
     */
    public static Location addLocation(Template t, String name, String exprate,
                                       int x, int y) {
        Location l = t.createLocation();
        t.insert(l, null);
        l.setProperty("x", x);
        l.setProperty("y", y);
        if (name != null)
            setLabel(l, ModelGen.LKind.name, name, x, y - 28);
        if (exprate != null)
            setLabel(l, ModelGen.LKind.exponentialrate, exprate, x, y - 28 - 12);
        return l;
    }

    /**
     * Sets a label on an edge.
     *
     * @param e     the edge
     * @param kind  the kind of the label
     * @param value the content of the label
     * @param x     the x coordinate of the label
     * @param y     the y coordinate of the label
     */
    public static void setLabel(Edge e, ModelGen.EKind kind, String value, int x, int y) {
        e.setProperty(kind.name(), value);
        Property p = e.getProperty(kind.name());
        p.setProperty("x", x);
        p.setProperty("y", y);
    }

    /**
     * Adds an edge to the template
     *
     * @param t      the template where the edge belongs
     * @param source the source location
     * @param target the target location
     * @param guard  guard expression
     * @param sync   synchronization expression
     * @param update update expression
     * @return e     the edge
     */
    public static Edge addEdge(Template t, Location source, Location target,
                               String guard, String sync, String update) {
        Edge e = t.createEdge();
        t.insert(e, null);
        e.setSource(source);
        e.setTarget(target);
        int x = (source.getX() + target.getX()) / 2;
        int y = (source.getY() + target.getY()) / 2;
        if (guard != null) {
            setLabel(e, ModelGen.EKind.guard, guard, x - 15, y - 28);
        }
        if (sync != null) {
            setLabel(e, ModelGen.EKind.synchronisation, sync, x - 15, y - 14);
        }
        if (update != null) {
            setLabel(e, ModelGen.EKind.assignment, update, x - 15, y);
        }
        return e;
    }

    // Visitors
    // sample setup and debugging
    void createExample() {
        Template t = doc.createTemplate();
        doc.insert(t, null);
        t.setProperty("name", "Expik");
        Location l0 = addLocation(t, "L0", "1", 0, 0);
        l0.setProperty("init", true);
        // add system declaration:
        doc.setProperty("system",
                "Exp1=Expik();\n" +
                        "system Exp1;");

        try {
            doc.save("C:\\Users\\the_p\\Documents\\GitHub\\P7\\Resources\\output\\hej.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Document visitProgram(ProgramNode programNode) {
        visitSetup(programNode.getSetupNode());
        //TODO: visitLoop();
        createExample(); //TODO: remove
        return doc;
    }

    void visitSetup(SetupNode setupNode) {
        // visitBlock(setupNode.getBlockNode(), doc); TODO: figure out if setup needs more than variables
        StringBuilder globalDecl = new StringBuilder();

        // Find all declarations
        for (StatementNode statementNode : setupNode.getBlockNode().getStatementNodes()) {
            if (statementNode instanceof VariableDeclarationNode) {

            } else if (statementNode instanceof PinDeclarationNode) {
                visitPinDecl((PinDeclarationNode) statementNode, globalDecl);
            }
        }
        doc.setProperty("declaration", globalDecl.toString());

        //System.out.println(globalDecl.toString());
    }

    void visitBlock(BlockNode blockNode, StringBuilder stringBuilder) {
        // TODO:
        for (StatementNode snode : blockNode.getStatementNodes()) {
            visitStatement(snode, stringBuilder);
        }
    }

    void visitStatement(StatementNode statementNode, StringBuilder stringBuilder) {
        if (statementNode instanceof PinDeclarationNode)
            visitPinDecl((PinDeclarationNode) statementNode, stringBuilder);
        /*
        TODO: visitAssignment (only for clock)
        TODO: visitVarDecl (only for clock)
        TODO: visitFunctionCall
        TODO: visitIfElseStatement, create new template
        TODO: visitIterativeStatement
        TODO: visitAtStatement, create new template
        TODO: visitBoundStatement, create new template
        TODO: visitReturnStatement
         */
    }

    // pin -> chan, node as they can be attached template-wise and globally
    void visitPinDecl(PinDeclarationNode pinDeclNode, StringBuilder stringBuilder) {
        stringBuilder.append("chan ").append(Enums.stringFromPinType(pinDeclNode.getPinType())).append(pinDeclNode.getPinNumber()).append(";\n");
    }

    void visitFuncDecl(FunctionDeclarationNode functionDeclarationNode) {
        // TODO: create new template
    }
}
