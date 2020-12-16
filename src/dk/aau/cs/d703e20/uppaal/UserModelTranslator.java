package dk.aau.cs.d703e20.uppaal;

import com.uppaal.model.core2.Edge;
import com.uppaal.model.core2.Location;
import dk.aau.cs.d703e20.uppaal.structures.UPPSystem;
import dk.aau.cs.d703e20.uppaal.structures.UPPTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.List;

import static dk.aau.cs.d703e20.uppaal.structures.UPPTemplate.setLabel;
import static dk.aau.cs.d703e20.uppaal.structures.UPPTemplate.setNail;

public class UserModelTranslator {
    private final UPPSystem system;
    private List<Location> locationList;

    public UserModelTranslator(UPPSystem system) {
        this.system = system;
    }

    public void createTemplateFromUserModel(String userModelFileName) throws ParserConfigurationException, IOException, SAXException {
        File file = new File(userModelFileName);

        /* Remove doctype from XML file being parsed */
        File tempFile = new File("tempFile.xml");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;
        while((currentLine = reader.readLine()) != null) {
            // Don't include the doctype XML line as it can't be parsed with it.
            if(currentLine.startsWith("<!DOCTYPE nta"))
                continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(tempFile);

        //optional, but recommended
        //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
        document.getDocumentElement().normalize();

        /* Translate XML file to Locations, Transitions and add to the system we are making. */
        UPPTemplate template = system.createTemplate("IO_Model");

        // Get start location
        Element start = (Element) document.getElementsByTagName("init").item(0);

        NodeList locations = document.getElementsByTagName("location");
        // Add locations to UPPAAL model
        for (int i = 0; i < locations.getLength(); i++) {
            Node node = locations.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                // If the current location is the start location - don't create it as it is made automatically when creating a template.
                if (!start.getAttribute("ref").equals(element.getAttribute("id")))
                    template.addLocation(element.getAttribute("id"), Integer.parseInt(element.getAttribute("x")), Integer.parseInt(element.getAttribute("y")));
            }
        }

        // Add transitions to UPPAAL model
        NodeList transitions = document.getElementsByTagName("transition");
        for (int i = 0; i < transitions.getLength(); i++) {
            Node node = transitions.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element transition = (Element) node;
                locationList = template.getLocationList();

                // Find source location name
                Location sourceLocation = getLocationFromElement(transition, "source");
                // Find target location name
                Location targetLocation = getLocationFromElement(transition, "target");

                // Add edge to template
                Edge edge = template.addEdge(sourceLocation, targetLocation, null, null, null);

                // Add any nails that there might be
                // TODO Apparently, this does not work but it is not important since we won't be opening the file.
                if (transition.getElementsByTagName("nail").item(0) != null) {
                    Element nail = (Element) transition.getElementsByTagName("nail").item(0);
                    setNail(edge, Integer.parseInt(nail.getAttribute("x")), Integer.parseInt(nail.getAttribute("y")));
                }

                // Set controllable if it is set for an edge/transition.
                if (!transition.getAttribute("controllable").isEmpty()) {
                    setLabel(edge, UPPTemplate.EKind.controllable, Boolean.valueOf(transition.getAttribute("contrallable")));
                }

                // Add any labels that there might be
                if (transition.getElementsByTagName("label") != null) {

                    for (int j = 0; j < transition.getElementsByTagName("label").getLength(); j++) {
                        Element element = (Element) transition.getElementsByTagName("label").item(j);

                        switch (element.getAttribute("kind")) {
                            case "select" -> setLabel(edge, UPPTemplate.EKind.select, element.getTextContent(), Integer.parseInt(element.getAttribute("x")), Integer.parseInt(element.getAttribute("y")));
                            case "synchronisation" -> setLabel(edge, UPPTemplate.EKind.synchronisation, element.getTextContent(), Integer.parseInt(element.getAttribute("x")), Integer.parseInt(element.getAttribute("y")));
                            case "update" -> setLabel(edge, UPPTemplate.EKind.assignment, element.getTextContent(), Integer.parseInt(element.getAttribute("x")), Integer.parseInt(element.getAttribute("y")));
                            case "guard" -> setLabel(edge, UPPTemplate.EKind.guard, element.getTextContent(), Integer.parseInt(element.getAttribute("x")), Integer.parseInt(element.getAttribute("y")));
                            default -> throw new RuntimeException("Unknown Edge kind. Fix this.");
                        }
                    }
                }
            }
        }

        tempFile.delete();
    }

    private Location getLocationFromElement(Element transition, String tagName) {
        Element source = (Element) transition.getElementsByTagName(tagName).item(0);
        for (Location location : locationList) {
            if (source.getAttribute("ref").equals(location.getName())
                    || source.getAttribute("ref").equals("id0")) {
                return location;
            }
        }

        throw new RuntimeException("Unknown location is transition.");
    }
}
