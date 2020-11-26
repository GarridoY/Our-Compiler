package dk.aau.cs.d703e20.uppaal;

import com.uppaal.model.core2.PrototypeDocument;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.statements.VariableDeclarationNode;
import dk.aau.cs.d703e20.uppaal.structures.UPPSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;


public class UPPSystemTest {
    UPPSystem system;

    @BeforeEach
    void setUp() {
        system = new UPPSystem(new PrototypeDocument());
    }

    @Test
    void testCreateTemplate() {
        // Create template with name and initial location
        system.createTemplate("test01");

        // Assert that there is a template, with an initial location
        assertNotNull(system.getTemplateList().get(0).getLocationList().get(0).getProperty("init"));
    }

    @Test
    void testSetDeclaration() {
        // Create templates
        system.createTemplate("test01");
        system.createTemplate("test02");
        // Set system declaration
        system.setDeclaration();
        // Assert that property was set
        assertEquals("system test01, test02;", system.getProperty("system").getValue().toString());
    }

    @ParameterizedTest
    @EnumSource(value = Enums.PinType.class)
    void testAddChan(Enums.PinType pinType) {
        // Add channels
        system.addChan("startTemp");
        system.addChan("in", 3, pinType);
        // Set global declarations (Channels)
        system.setGlobalDecl();

        assertEquals("// Global declarations\n" +
                        "chan startTemp;\n" +
                        "chan in[3];\n",
                system.getProperty("declaration").getValue().toString());
    }

    @Test
    void testAddDecl() {
        // Add clock to system
        VariableDeclarationNode variableDeclarationNode = new VariableDeclarationNode(Enums.DataType.CLOCK, "x");
        system.addClockDecl(variableDeclarationNode);

        // Set global declarations (Clocks)
        system.setGlobalDecl();

        assertEquals("// Global declarations\n" +
                        "clock x;\n",
                system.getProperty("declaration").getValue().toString());
    }
}
