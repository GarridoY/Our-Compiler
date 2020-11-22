package dk.aau.cs.d703e20.uppaal;

import static dk.aau.cs.d703e20.resources.Utilities.getNodeFromText;


import dk.aau.cs.d703e20.ast.structure.ProgramNode;
import dk.aau.cs.d703e20.parser.OurParser;
import dk.aau.cs.d703e20.uppaal.structures.UPPSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ModelGenTest {
    ModelGen modelGen = new ModelGen();


    UPPSystem parseProgramLoop(String loopBody) {
        String programText = "Setup {} Loop {" + loopBody + "}";
        ProgramNode program = getNodeFromText(
                programText,
                ProgramNode.class,
                OurParser.ProgramContext.class,
                "program");
        return modelGen.visitProgram(program);
    }

    @Test
    void testClockScope() {
        UPPSystem system = parseProgramLoop("clock x; at (x == 10) { FuncTwo(); }");
        System.out.println(system.getTemplateList().get(1).getName());
        assertTrue(system.getTemplateList().get(1).getProperty("declaration").getValue().toString().contains("clock x"));
    }
}
