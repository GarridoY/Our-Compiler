package dk.aau.cs.d703e20.uppaal.structures;

import com.uppaal.model.core2.Document;
import com.uppaal.model.core2.Element;
import com.uppaal.model.core2.Location;
import dk.aau.cs.d703e20.ast.statements.VariableDeclarationNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static dk.aau.cs.d703e20.uppaal.structures.UPPTemplate.LKind;
import static dk.aau.cs.d703e20.uppaal.structures.UPPTemplate.setLabel;

public class UPPSystem extends Document {
    // Store all declarations before setting them
    private final StringBuilder globalDeclSB = new StringBuilder("// Global declarations\n");
    private final List<UPPTemplate> templateList = new ArrayList<>();

    public UPPSystem(Element prototype) {
        super(prototype);
    }

    /**
     * Overwritten to return subclass.
     * Template cannot be cast to UPPTemplate.
     * Automatically setup start location.
     *
     * @return new UPPTemplate
     */
    @Override
    public UPPTemplate createTemplate() {
        UPPTemplate t = new UPPTemplate((Element) this.getPropertyValue("#template"));
        Location l = t.addLocation("start", 0, 0);
        setLabel(l, LKind.init, true, 0, 0);
        return t;
    }

    /**
     * Creates a new template and adds it to the UPPAAL model
     *
     * @param name name of new template
     * @return new UPPTemplate
     */
    public UPPTemplate createTemplate(String name, int id) {
        UPPTemplate t = createTemplate();
        // Set template name (UPPAAL) then (JAVA)
        t.setProperty("name", name);
        t.setName(name);
        t.setId(id);
        t.setProperty("parameter", "const int id");
        // Insert template into UPPAAL model
        this.insert(t, null);
        templateList.add(t);
        return t;
    }

    public void setSysDeclaration() {
        StringBuilder procBuilder = new StringBuilder();
        StringBuilder sysBuilder = new StringBuilder("system");
        for (UPPTemplate template : templateList) {
            // P + ID = Name(ID)
            procBuilder.append("P").append(template.getId()).append(" = ").append(template.toString()).append("; ");
            sysBuilder.append(" ").append("P").append(template.getId()).append(",");
        }
        // End with ; rather than ,
        sysBuilder.setCharAt(sysBuilder.length() - 1, ';');

        this.setProperty("system", (procBuilder.toString() + "\n" + sysBuilder.toString()));
    }

    public List<UPPTemplate> getTemplateList() {
        return templateList;
    }

    public void addClockDecl(VariableDeclarationNode varDecl) {
        globalDeclSB.append("clock ").append(varDecl.getVariableName()).append(";\n");
    }


    /**
     * Set all global variables
     */
    public void setGlobalDecl() {
        String lockDecl = "int lock = 0;\n";
        String prevLockDecl = "int prevLock = 0;\n";
        String scopeLock = "bool atNotRunning = true;\n";
        globalDeclSB.append(lockDecl);
        globalDeclSB.append(prevLockDecl);
        globalDeclSB.append(scopeLock);
        this.setProperty("declaration", globalDeclSB.toString());
    }

    /**
     * Add channel declaration to global system
     *
     * @param id Name of channel
     */
    public void addChan(String id) {
        globalDeclSB.append("chan ").append(id).append(";\n");
    }

    /**
     * Add channel array to global system
     *
     * @param id        Name of channel array
     * @param arraySize size of array
     */
    public void addDigitalPin(String id, int arraySize) {
        // chan *id*[size][2] - 2 as digital pins are either high or low
        globalDeclSB.append("chan ").append(id).append("[").append(arraySize).append("][2];\n");

    }

    // printing for debugging
    public void toXML() {
        // Save model for debugging
        try {
            String path = System.getProperty("user.dir");
            this.save(path + "/Resources/output/debug.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
