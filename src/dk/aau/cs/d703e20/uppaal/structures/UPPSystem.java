package dk.aau.cs.d703e20.uppaal.structures;

import com.uppaal.model.core2.Document;
import com.uppaal.model.core2.Element;
import com.uppaal.model.core2.Template;

public class UPPSystem extends Document {
    // Store all declarations before setting them
    private final StringBuilder globalDeclSB = new StringBuilder("// Global declarations\n");

    public UPPSystem(Element prototype) {
        super(prototype);
    }

    /**
     * Overwritten to return subclass.
     * Template cannot be cast to UPPTemplate.
     *
     * @return new UPPTemplate
     */
    @Override
    public UPPTemplate createTemplate() {
        return new UPPTemplate((Element) this.getPropertyValue("#template"));
        //return super.createTemplate();
    }

    /**
     * Creates a new template and adds it to the UPPAAL model
     *
     * @param name name of new template
     * @return new UPPTemplate
     */
    public UPPTemplate createTemplate(String name) {
        UPPTemplate t = createTemplate();
        // Set template name
        t.setProperty("name", name);
        // Insert template into UPPAAL model
        this.insert(t, null);
        return t;
    }

    public StringBuilder getGlobalDeclSB() {
        return globalDeclSB;
    }
}
