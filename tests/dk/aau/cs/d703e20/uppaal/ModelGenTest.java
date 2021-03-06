package dk.aau.cs.d703e20.uppaal;

import com.uppaal.model.core2.Edge;
import com.uppaal.model.core2.Node;
import dk.aau.cs.d703e20.ast.structure.ProgramNode;
import dk.aau.cs.d703e20.parser.OurParser;
import dk.aau.cs.d703e20.semantics.SemanticChecker;
import dk.aau.cs.d703e20.uppaal.structures.UPPSystem;
import dk.aau.cs.d703e20.uppaal.structures.UPPTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static dk.aau.cs.d703e20.resources.Utilities.getNodeFromText;
import static org.junit.jupiter.api.Assertions.*;


public class ModelGenTest {
    private final SemanticChecker semanticChecker = new SemanticChecker();
    ModelGen modelGen;


    private UPPSystem generateModelFromText(String programText) {
        ProgramNode program = programNodeFromText(programText);
        semanticChecker.visitProgram(program);
        modelGen = new ModelGen(semanticChecker.getVarConstMap());
        return modelGen.visitProgram(program, null);
    }

    private ProgramNode programNodeFromText(String programText) {
        return getNodeFromText(
                programText,
                ProgramNode.class,
                OurParser.ProgramContext.class,
                "program");
    }

    private UPPSystem generateModelFromProgramNode(ProgramNode program) {
        semanticChecker.visitProgram(program);
        modelGen = new ModelGen(semanticChecker.getVarConstMap());
        return modelGen.visitProgram(program, null);
    }

    private UPPSystem parseProgramLoop(String loopBody) {
        String programText = "Setup {} Loop {" + loopBody + "}";
        return generateModelFromText(programText);
    }

    private UPPSystem parseProgramSetup(String setupBody) {
        String programText = "Setup {" + setupBody + "} Loop {}";
        return generateModelFromText(programText);
    }

    private UPPSystem parseProgramFunction(String func, String call) {
        String programText = "Setup {} Loop {" + call + "} " + func;
        return generateModelFromText(programText);
    }

    /**
     * Get a list of all edges in template
     *
     * @param inputNode UPPTemplate with edges to return
     * @return edgeList list of all edges
     */
    private List<Edge> getEdges(Node inputNode) {
        List<Edge> edgeList = new ArrayList<>();
        // Get first node of inputNode in XML
        Node node = inputNode.getFirst();

        // Go through XML elements/nodes top down and add edges to list
        while (node != null) {
            if (node instanceof Edge)
                edgeList.add((Edge) node);
            node = node.getNext();
        }
        // Reverse list as it is built from last to first
        Collections.reverse(edgeList);
        return edgeList;
    }

    private boolean checkAllBoundBreaks(List<Edge> edgeList, String sync, String guard) {
        return edgeList.stream().allMatch(edge -> edge.getProperty("synchronisation").getValue().equals(sync) && edge.getProperty("guard").getValue().toString().contains(guard));
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
        UPPSystem system = parseProgramLoop("clock x; at (x < 35) {} at(x == 1) {}");

        UPPTemplate controller = system.getTemplateList().get(0);
        UPPTemplate at0 = system.getTemplateList().get(1);

        // Controller template contains a location for having scheduled the at
        assertAll(
                () -> assertTrue(controller.getLocationList().stream().anyMatch(location -> location.getName().equals("called_At0"))),
                () -> assertEquals("At0", at0.getName()),
                () -> assertEquals("Sync_done", at0.getLocationList().get(1).getName())
        );
    }

    @Test
    void testSetup() {
        String setupString = "ipin input 3;\n" +
                             "    opin output 5;\n" +
                             "    int a = 1;\n" +
                             "    int b = 2;";
        UPPSystem system = parseProgramSetup(setupString);

        assertEquals("// Global declarations\n" +
                     "chan outPin[1][2];\n" +
                     "chan inPin[1][2];\n" +
                     "int lock = 0;\n" +
                     "int prevLock = 0;\n" +
                     "bool atNotRunning = true;\n",
                system.getProperty("declaration").getValue().toString());
    }

    @Test
    void testVisitFunctionDecl() {
        String function = "void func() {  }";
        String call = "func();";
        UPPSystem system = parseProgramFunction(function, call);

        UPPTemplate funcTemplate = system.getTemplateList().get(0);

        List<Edge> edges = getEdges(funcTemplate);

        assertAll(
                () -> assertEquals("func", funcTemplate.getName()),
                () -> assertEquals("begin_func?", edges.get(edges.size() - 1).getProperty("synchronisation").getValue()),
                () -> assertEquals("sync_done", funcTemplate.getLocationList().get(1).getName()),
                () -> assertEquals("End_func", funcTemplate.getLocationList().get(2).getName()),
                () -> assertEquals("bound_kill", funcTemplate.getLocationList().get(3).getName()),
                () -> assertEquals(3, edges.size())
        );
    }

    @Test
    void testBoundedFunctionTemplate() {
        String function = "void func() {  }";
        String call = "clock x; bound (x < 40) { func(); }";
        String programText = "Setup {} Loop {" + call + "} " + function;
        ProgramNode programNode = programNodeFromText(programText);

        // Requires semantic check to annotate AST
        UPPSystem system = generateModelFromProgramNode(programNode);

        UPPTemplate funcTemplate = system.getTemplateList().get(0);
        List<Edge> edges = getEdges(funcTemplate);

        assertAll(
                () -> assertEquals("begin_func?", edges.get(2).getProperty("synchronisation").getValue()),
                // Locations
                () -> assertEquals("sync_done", funcTemplate.getLocationList().get(1).getName()),
                () -> assertEquals("End_func", funcTemplate.getLocationList().get(2).getName()),
                () -> assertEquals("bound_kill", funcTemplate.getLocationList().get(3).getName()),
                // Edge for checking bound time
                () -> assertEquals("bound_kill→start", edges.get(3).getName()),
                () -> assertEquals("start→bound_kill", edges.get(4).getName()),
                () -> assertEquals("kill1!", edges.get(4).getProperty("synchronisation").getValue()),
                () -> assertTrue(edges.get(4).getProperty("guard").getValue().toString().contains("x > 40")),
                // Edge for checking bound time
                () -> assertEquals("sync_done→bound_kill", edges.get(5).getName()),
                () -> assertEquals("kill1!", edges.get(5).getProperty("synchronisation").getValue()),
                () -> assertTrue(edges.get(5).getProperty("guard").getValue().toString().contains("x > 40"))
        );
    }

    @Test
    void testVisitFunctionCall() {
        String program = "Setup {} Loop { func(); } void func() {}";
        UPPSystem system = generateModelFromText(program);

        UPPTemplate controller = system.getTemplateList().get(1);

        assertTrue(controller.getLocationList().stream().anyMatch(location -> location.getName().equals("called_func")));
    }

    @Test
    void testDelayNumber() {
        String program = "delay(4);";
        UPPSystem system = parseProgramLoop(program);

        UPPTemplate controller = system.getTemplateList().get(0);

        Edge delayEdge = getEdges(controller).get(1);


        assertAll(
                () -> assertTrue(delayEdge.getProperty("guard").getValue().toString().contains("delayClock > (4)")),
                () -> assertEquals("reset_local_clock", controller.getLocationList().get(1).getName()),
                () -> assertEquals("finished_delay", controller.getLocationList().get(2).getName())
        );
    }

    @Test
    void testDelayFunctionCall() {
        String program = "Setup {} Loop { delay(func()); } int func () { int value = 8; return value;}";
        UPPSystem system = generateModelFromText(program);

        UPPTemplate controller = system.getTemplateList().get(1);

        List<Edge> edgeList = getEdges(controller);
        Edge delayEdge = edgeList.get(1);

        assertTrue(delayEdge.getProperty("guard").getValue().toString().contains("delayClock > (8)"));
    }

    @Test
    void testDelaySubscript() {
        String program = "int[3] myList = {1, 2, 3}; delay(myList[1]);";
        UPPSystem system = parseProgramLoop(program);
        UPPTemplate controller = system.getTemplateList().get(0);
        // Delay has 2 edges, second has the guard
        Edge delayEdge = getEdges(controller).get(1);

        assertTrue(delayEdge.getProperty("guard").getValue().toString().contains("delayClock > (2)"));
    }

    @Test
    void testPinAssignment() {
        String program = "Setup {opin x 2;} Loop {x = true;}";
        UPPSystem system = generateModelFromText(program);
        UPPTemplate controller = system.getTemplateList().get(0);
        Edge syncEdge = getEdges(controller).get(0);

        assertEquals("outPin[0][1]!", syncEdge.getProperty("synchronisation").getValue());
    }

    @Test
    void testForLoop() {
        UPPSystem system = parseProgramLoop("clock x; bound (x < 20) {for (0 to 10) {}}");
        // Get forLoop template
        UPPTemplate forTemplate = system.getTemplateList().get(2);
        List<Edge> edgeList = getEdges(forTemplate);

        assertAll(
                () -> assertEquals("loop", forTemplate.getLocationList().get(2).getName()),
                () -> assertTrue(edgeList.get(1).getProperty("assignment").getValue().toString().contains("loopIndex = 0")),
                () -> assertTrue(edgeList.get(2).getProperty("guard").getValue().toString().contains("loopIndex != 10")),
                () -> assertTrue(edgeList.get(3).getProperty("assignment").getValue().toString().contains("loopIndex ++")),
                () -> assertTrue(edgeList.get(4).getProperty("guard").getValue().toString().contains("loopIndex == 10")),
                () -> assertTrue(forTemplate.getProperty("declaration").getValue().toString().contains("int loopIndex = 0;"
                ))
        );
    }

    @Test
    void testSync() {
        String function = "void Func() {}";
        String loopBody = "clock x; Func(); at (x > 10) {} if (true) {}";
        UPPSystem system = generateModelFromText("Setup {} Loop {" + loopBody + "} " + function);
        //UPPSystem system = parseProgramLoop("clock x; at (x > 10) {} if (true) {}");
        UPPTemplate funcTemplate = system.getTemplateList().get(0);
        UPPTemplate controller = system.getTemplateList().get(1);
        UPPTemplate atTemplate = system.getTemplateList().get(2);
        UPPTemplate ifTemplate = system.getTemplateList().get(3);

        List<Edge> ctrlEdges = getEdges(controller);
        Edge syncFunc = getEdges(funcTemplate).get(getEdges(funcTemplate).size() - 1);
        Edge syncAt = getEdges(atTemplate).get(0);
        Edge syncIf = getEdges(ifTemplate).get(0);

        assertAll(
                () -> assertEquals("begin_At0?", syncAt.getProperty("synchronisation").getValue()),
                () -> assertEquals("begin_Func?", syncFunc.getProperty("synchronisation").getValue()),
                () -> assertEquals("begin_If0?", syncIf.getProperty("synchronisation").getValue()),
                () -> assertEquals("begin_Func!", ctrlEdges.get(1).getProperty("synchronisation").getValue()),
                () -> assertEquals("begin_At0!", ctrlEdges.get(3).getProperty("synchronisation").getValue()),
                () -> assertEquals("begin_If0!", ctrlEdges.get(5).getProperty("synchronisation").getValue())
        );
    }

    @Test
    void testIfElseComplete() {
        String loopBody = "bool a; bool b;" +
                          "if (a == b) {}\n" +
                          "    else if (a != b) {}\n" +
                          "    else {}";
        UPPSystem system = parseProgramLoop(loopBody);

        UPPTemplate ifTemplate = system.getTemplateList().get(1);
        List<Edge> edges = getEdges(ifTemplate);

        assertAll(
                () -> assertEquals("start→Sync_done", edges.get(0).getName()),
                () -> assertEquals("begin_If0?", edges.get(0).getProperty("synchronisation").getValue()),
                () -> assertEquals("Sync_done→Start_If", edges.get(1).getName()),
                () -> assertEquals(false, edges.get(1).getProperty("controllable").getValue()),
                () -> assertEquals("If_end→start", edges.get(2).getName()),
                () -> assertEquals("Start_If→If_end", edges.get(3).getName()),
                () -> assertEquals("Sync_done→Start_ElseIf0", edges.get(4).getName()),
                () -> assertEquals(false, edges.get(4).getProperty("controllable").getValue()),
                () -> assertEquals("Start_ElseIf0→If_end", edges.get(5).getName()),
                () -> assertEquals("Sync_done→Start_Else", edges.get(6).getName()),
                () -> assertEquals(false, edges.get(6).getProperty("controllable").getValue()),
                () -> assertEquals("Start_Else→If_end", edges.get(7).getName()),
                () -> assertEquals("Start_Else→If_end", edges.get(7).getName())
        );
    }

    @Test
    void testWhile() {
        String loopBody = "clock x; bound (x < 40) { while (true) {} }";
        String programText = "Setup {} Loop {" + loopBody + "}";
        ProgramNode programNode = programNodeFromText(programText);

        // Requires semantic check to annotate AST
        semanticChecker.visitProgram(programNode);
        UPPSystem system = generateModelFromProgramNode(programNode);

        UPPTemplate whileTemplate = system.getTemplateList().get(2);
        List<Edge> edges = getEdges(whileTemplate);
        system.toXML(); //TODO: also remove

        assertAll(
                () -> assertEquals("While0", whileTemplate.getName()),
                () -> assertEquals("begin_While0?", edges.get(0).getProperty("synchronisation").getValue()),
                () -> assertEquals("Sync_done→Start_loop", edges.get(1).getName()),
                () -> assertEquals("Start_loop→End_loop", edges.get(2).getName()),
                () -> assertEquals("End_loop→Start_loop", edges.get(3).getName()),
                () -> assertEquals(false, edges.get(3).getProperty("controllable").getValue()),
                () -> assertTrue(checkAllBoundBreaks(edges.subList(7, edges.size()), "kill1!", "x > 40"))
        );
    }
}
