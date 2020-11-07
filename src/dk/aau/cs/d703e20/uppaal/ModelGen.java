package dk.aau.cs.d703e20.uppaal;

import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.statements.VariableDeclarationNode;
import org.jdom2.Attribute;
import org.jdom2.DocType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.IOException;


public class ModelGen {
    // File handling
    FileHandler fileHandler = new FileHandler();

    // Root element
    Element root = new Element("nta");
    // Document type and header
    DocType dtype = new DocType(root.getName(), "-//Uppaal Team//DTD Flat System 1.1//EN", "http://www.it.uu.se/research/group/darts/uppaal/flat-1_2.dtd");
    Document doc = new Document(root, dtype);

    /* TODO:
        Each template is:
        1. Declarations
        2. Transitions
        3. Locations
        Last is:
        4. Queries
    */

    private String visitVariableDecl(VariableDeclarationNode varDeclNode) {
        // TODO: check UPPAAL array declaration, placement of brackets, frick, int a[]
        Enums.DataType type = varDeclNode.getDataType();
        // If declaration is array type
        if (type == Enums.DataType.BOOL_ARRAY || type == Enums.DataType.DOUBLE_ARRAY || type == Enums.DataType.INT_ARRAY) {
            if (varDeclNode.getAssignArrayNode() != null) {

            }
            // else allocatedSize != null
            else {
                return type.toString() + " " + varDeclNode.getVariableName();
            }
        }
        return null;
    }

    void createXML() {
        //first element
        Element supercarElement = new Element("declaration");

        supercarElement.addContent("chan sched2;\n");
        supercarElement.addContent("chan sched1;\n");
        supercarElement.addContent("clock x;");

        //nested elements
        Element carElement1 = new Element("carname");
        carElement1.setAttribute(new Attribute("type", "formula one"));
        carElement1.setAttribute(new Attribute("id", "id2"));
        carElement1.setText("Ferrari 101");

        Element carElement2 = new Element("carname");
        carElement2.setAttribute(new Attribute("type", "sports"));
        carElement2.setText("Ferrari 202");

        supercarElement.addContent(carElement1);
        supercarElement.addContent(carElement2);

        doc.getRootElement().addContent(supercarElement);

    }

    void outputXml() {
        try {
            XMLOutputter xmlOutput = new XMLOutputter();

            // display ml
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, fileHandler.getWriter()); // FileHandler --> system.out for test print
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VariableDeclarationNode variableDeclarationNode = new VariableDeclarationNode(Enums.DataType.INT_ARRAY, 5, "Hej123");
        System.out.println(variableDeclarationNode.prettyPrint(0));
        ModelGen modelGen = new ModelGen();
        modelGen.createXML();
        modelGen.outputXml();

    }
}
