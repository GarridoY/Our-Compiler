package dk.aau.cs.d703e20.uppaal;

import java.io.IOException;

import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class ModelGen {
    /* TODO:
        Each template is:
        1. Declarations
        2. Transitions
        3. Locations
        Last is:
        4. Queries
    */
    void createXML() {
        try{
            //root element
            Element root = new Element("nta");
            DocType dtype = new DocType(root.getName(), "-//Uppaal Team//DTD Flat System 1.1//EN", "http://www.it.uu.se/research/group/darts/uppaal/flat-1_2.dtd");
            Document doc = new Document(root, dtype);

            //first element
            Element supercarElement = new Element("declaration");

            supercarElement.addContent("chan sched2;\n");
            supercarElement.addContent("chan sched1;\n");
            supercarElement.addContent("clock x;");

            //nested elements
            Element carElement1 = new Element("carname");
            carElement1.setAttribute(new Attribute("type","formula one"));
            carElement1.setAttribute(new Attribute("id", "id2"));
            carElement1.setText("Ferrari 101");

            Element carElement2 = new Element("carname");
            carElement2.setAttribute(new Attribute("type","sports"));
            carElement2.setText("Ferrari 202");

            supercarElement.addContent(carElement1);
            supercarElement.addContent(carElement2);

            doc.getRootElement().addContent(supercarElement);

            XMLOutputter xmlOutput = new XMLOutputter();

            // display ml
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, System.out);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ModelGen modelGen = new ModelGen();
        modelGen.createXML();

    }
}
