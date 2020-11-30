package dk.aau.cs.d703e20.uppaal;

import com.uppaal.model.core2.Location;
import com.uppaal.model.core2.PrototypeDocument;
import dk.aau.cs.d703e20.uppaal.structures.UPPSystem;
import dk.aau.cs.d703e20.uppaal.structures.UPPTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UPPTemplateTest {
    UPPSystem system;
    UPPTemplate template;

    @BeforeEach
    void setUp() {
        // Set up main system
        system = new UPPSystem(new PrototypeDocument());
        // Create a template
        template = system.createTemplate("template01");
    }

    @Test
    void testAddEdge() {
        // Add location to the template
        Location l1 = template.addLocation("l1", 0, 0);
        // Add edge from init to l1 with no properties
        template.addEdge(template.getLocationList().get(0), l1, "x > 10", "out!", "i + 1");
    }
}
