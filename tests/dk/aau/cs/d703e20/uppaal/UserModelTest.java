package dk.aau.cs.d703e20.uppaal;

import com.uppaal.model.core2.PrototypeDocument;
import dk.aau.cs.d703e20.uppaal.structures.UPPSystem;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class UserModelTest {

    // Check if the function may parse the XML file
    // and if it was able to add all locations, transitions and labels to the system.
    @Test
    void testCreateTemplateFromUserModel() {
        // New system with default properties
        UPPSystem system = new UPPSystem(new PrototypeDocument());
        UserModelTranslator userModelTranslator = new UserModelTranslator(system);
        try {
            userModelTranslator.createTemplateFromUserModel(System.getProperty("user.dir") + "\\Resources\\test_model_files\\sample.xml");
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
