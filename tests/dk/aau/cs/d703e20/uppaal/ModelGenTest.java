package dk.aau.cs.d703e20.uppaal;

import dk.aau.cs.d703e20.ast.structure.ProgramNode;
import dk.aau.cs.d703e20.parser.OurParser;
import dk.aau.cs.d703e20.uppaal.structures.UPPSystem;
import dk.aau.cs.d703e20.uppaal.structures.UPPTemplate;
import org.junit.jupiter.api.Test;

import static dk.aau.cs.d703e20.resources.Utilities.getNodeFromText;
import static org.junit.jupiter.api.Assertions.*;


public class ModelGenTest {
    ModelGen modelGen = new ModelGen();


    private UPPSystem generateModelFromText(String programText) {
        ProgramNode program = getNodeFromText(
                programText,
                ProgramNode.class,
                OurParser.ProgramContext.class,
                "program");
        return modelGen.visitProgram(program);
    }

    private UPPSystem parseProgramLoop(String loopBody) {
        String programText = "Setup {} Loop {" + loopBody + "}";
        return generateModelFromText(programText);
    }

    private UPPSystem parseProgramSetup(String setupBody) {
        String programText = "Setup {" + setupBody + "} Loop {}";
        return generateModelFromText(programText);
    }

    private UPPSystem parseProgramFunction(String func) {
        String programText = "Setup {} Loop {} " + func;
        return generateModelFromText(programText);
    }

    @Test
    void testClockScope() {
        UPPSystem system = parseProgramLoop("clock x; at (x == 10) {}");

        assertAll(
                () -> assertFalse(system.getTemplateList().get(0).getProperty("declaration").getValue().toString().contains("clock x")),
                () -> assertFalse(system.getTemplateList().get(1).getProperty("declaration").getValue().toString().contains("clock x"))
        );
    }

    @Test
    void testAtTemplate() {
        UPPSystem system = parseProgramLoop("clock x; at (x < 35) {}");

        UPPTemplate controller = system.getTemplateList().get(0);
        UPPTemplate at0 = system.getTemplateList().get(1);

        // Controller template contains a location for having scheduled the at
        assertAll(
                () -> assertTrue(controller.getLocationList().stream().anyMatch(location -> location.getName().equals("schedAt0"))),
                () -> assertEquals("At0", at0.getName()),
                () -> assertEquals("CheckTime", at0.getLocationList().get(1).getName())
        );
    }

    @Test
    void testSetup() {
        String setupString = "ipin input 3;\n" +
                "    opin output 5;\n" +
                "    int a = 1;\n" +
                "    int b = 2;";
        UPPSystem system = parseProgramSetup(setupString);

        assertEquals("// Global declarations\n" + "chan out[1];\n" + "chan in[1];\n",
                system.getProperty("declaration").getValue().toString());
    }

    @Test
    void testVisitFunctionDecl() {
        String function = "void func() {}";
        UPPSystem system = parseProgramFunction(function);

        assertEquals("func", system.getTemplateList().get(0).getName());
    }

    @Test
    void testVisitFunctionCall() {
        String program = "Setup {} Loop { func(); } void func() {}";
        UPPSystem system = generateModelFromText(program);

        UPPTemplate controller = system.getTemplateList().get(1);

        assertTrue(controller.getLocationList().stream().anyMatch(location -> location.getName().equals("called_func")));
    }
}
