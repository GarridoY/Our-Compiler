package dk.aau.cs.d703e20.uppaal;

import com.uppaal.engine.*;
import com.uppaal.model.core2.Document;
import com.uppaal.model.core2.Query;
import com.uppaal.model.system.SystemEdge;
import com.uppaal.model.system.SystemLocation;
import com.uppaal.model.system.UppaalSystem;
import com.uppaal.model.system.symbolic.SymbolicState;
import com.uppaal.model.system.symbolic.SymbolicTransition;
import dk.aau.cs.d703e20.Main;
import dk.aau.cs.d703e20.ast.structure.ProgramNode;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModelChecker {
    ModelGen modelGen = new ModelGen();
    public ModelChecker() {

    }

    public void checkProgram(ProgramNode programNode) {

        Feedback feedback = new Feedback();

        try {
            Document doc = null;

            // TODO: generate model to use instead of example
            doc = modelGen.visitProgram(programNode);
                    //ModelDemo.createSampleModel();

            String outputDir = getClass().getResource("/output/do-not-delete.txt").getPath().substring(1);
            outputDir = outputDir.substring(0, outputDir.length() - "do-not-delete.txt".length());

            // save the model into a file:
            doc.save(outputDir + "/result.xml");

            //String modelPath = getClass().getResource("/UPPAAL_models/atTemplate.xml").getPath().substring(1);
            //doc = new PrototypeDocument().load(new URL("file", null, modelPath));

            System.out.println("\nRUNNING UPPAAL:\n");

            // connect to the engine server:
            Engine engine = connectToEngine();

            // create a link to a local Uppaal process:
            UppaalSystem sys = compile(engine, doc);

            // perform a random symbolic simulation and get a trace:
            ArrayList<SymbolicTransition> trace = symbolicSimulation(engine, sys);

            // save the trace to an XTR file:
            saveXTRFile(trace, outputDir + "/result.xtr");

            // simple model-checking:
            //Query query = new Query("E<> Exp1.Final", "can Exp1 finish?");
            //System.out.println("===== Simple check =====");
            //System.out.println("Result: "
            //        + engine.query(sys, options, query, feedback));
//
            //// SMC model-checking:
            //Query smcq = new Query("Pr[<=30](<> Exp1.Final)", "what is the probability of finishing?");
            //System.out.println("===== SMC check =====");
            //System.out.println("Result: "
            //        + engine.query(sys, options, smcq, feedback));

            // Model-checking with customized initial state:
            SymbolicState state = engine.getInitialState(sys);
            int vi = -1; // variable v index
            for (int i = 0; i < sys.getNoOfVariables(); i++) {
                if ("v".equals(sys.getVariableName(i))) {
                    vi = i;
                    break;
                }
            }

            // Verification with custom initial state:
            int[] vars = state.getVariableValues();
            if (vi < 0 || vi >= vars.length) {
                System.err.println("Variable v was not found");
                System.exit(1);
            }

            // set variable v to value 2:
            state.getVariableValues()[vi] = 2;
            // add constrain "x-0<=5":
            state.getPolyhedron().addNonStrictConstraint(1, 0, 5);
            // add constrain "0-x<=-5" (equivalent to "x>=5"):
            state.getPolyhedron().addNonStrictConstraint(0, 1, -5);
            // Notice that all other clocks will be constrained too,
            // because of other (initial) constrains like: x==y, y==z

            //System.out.println("===== Custom check ===== ");
            //System.out.println("Result: "
            //        + engine.query(sys, state, options, query, feedback));
//
            //System.out.println("===== Custom SMC ===== ");
            //System.out.println("Result: "
            //        + engine.query(sys, state, options, smcq, feedback));
//
            //Query smcsim = new Query("simulate 1 [<=30] { v, x, y }", "get simulation trajectories");
            //System.out.println("===== Custom Concrete Simulation ===== ");
            //System.out.println("Result: "
            //        + engine.query(sys, state, options, smcsim, feedback));
            //engine.disconnect();

            // TODO: throw exception if UPPAAL fails
            System.out.println("\n");

        } catch (CannotEvaluateException ex) {
            ex.printStackTrace(System.err);
            System.exit(1);
        } catch (EngineException ex) {
            ex.printStackTrace(System.err);
            System.exit(1);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
            System.exit(1);
        }
    }

    public static Engine connectToEngine() throws EngineException, IOException {
        String os = System.getProperty("os.name");
        //String here = System.getProperty("user.dir");
        String here = Main.uppaalDirectory;
        String path = null;
        if ("Linux".equals(os)) {
            path = here + "/bin-Linux/server";
        } else {
            path = here + "\\bin-Windows\\server.exe";
        }
        Engine engine = new Engine();
        engine.setServerPath(path);
        engine.setServerHost("localhost");
        engine.setConnectionMode(EngineStub.BOTH);
        engine.connect();
        return engine;
    }

    public static UppaalSystem compile(Engine engine, Document doc)
            throws EngineException, IOException {
        // compile the model into system:
        ArrayList<Problem> problems = new ArrayList<Problem>();
        UppaalSystem sys = engine.getSystem(doc, problems);
        if (!problems.isEmpty()) {
            boolean fatal = false;
            System.out.println("There are problems with the document:");
            for (Problem p : problems) {
                System.out.println(p.toString());
                if (!"warning".equals(p.getType())) { // ignore warnings
                    fatal = true;
                }
            }
            if (fatal) {
                System.exit(1);
            }
        }
        return sys;
    }

    public static ArrayList<SymbolicTransition> symbolicSimulation(Engine engine,
                                                                   UppaalSystem sys)
            throws EngineException, IOException, CannotEvaluateException {
        ArrayList<SymbolicTransition> trace = new ArrayList<SymbolicTransition>();
        // compute the initial state:
        SymbolicState state = engine.getInitialState(sys);
        // add the initial transition to the trace:
        trace.add(new SymbolicTransition(null, null, state));
        while (state != null) {
            print(sys, state);
            // compute the successors (including "deadlock"):
            ArrayList<SymbolicTransition> trans = engine.getTransitions(sys, state);
            // select a random transition:
            int n = (int) Math.floor(Math.random() * trans.size());
            SymbolicTransition tr = trans.get(n);
            // check the number of edges involved:
            if (tr.getSize() == 0) {
                // no edges, something special (like "deadlock"):
                System.out.println(tr.getEdgeDescription());
            } else {
                // one or more edges involved, print them:
                for (SystemEdge e : tr.getEdges()) {
                    System.out.print(e.getProcessName() + ": "
                            + e.getEdge().getSource().getPropertyValue("name")
                            + " \u2192 "
                            + e.getEdge().getTarget().getPropertyValue("name") + ", ");
                }
            }
            // jump to a successor state (null in case of deadlock):
            state = tr.getTarget();
            // if successfull, add the transition to the trace:
            if (state != null) trace.add(tr);
        }
        return trace;
    }

    public static void saveXTRFile(ArrayList<SymbolicTransition> trace, String file)
            throws IOException {
	/* BNF for the XTR format just in case
	   (it may change, thus don't rely on it)
	   <XTRFomat>  := <state> ( <state> <transition> ".\n" )* ".\n"
	   <state>     := <locations> ".\n" <polyhedron> ".\n" <variables> ".\n"
	   <locations> := ( <locationId> "\n" )*
	   <polyhedron> := ( <constraint> ".\n" )*
	   <constraint> := <clockId> "\n" clockId "\n" bound "\n"
	   <variables> := ( <varValue> "\n" )*
	   <transition> := ( <processId> <edgeId> )* ".\n"
	*/
        FileWriter out = new FileWriter(file);
        Iterator<SymbolicTransition> it = trace.iterator();
        it.next().getTarget().writeXTRFormat(out);
        while (it.hasNext()) {
            it.next().writeXTRFormat(out);
        }
        out.write(".\n");
        out.close();
    }

    //TODO: figure out which of these we should use
    public static final String options = "order 0\n"
            + "reduction 1\n"
            + "representation 0\n"
            + "trace 0\n"
            + "extrapolation 0\n"
            + "hashsize 27\n"
            + "reuse 1\n"
            + "smcparametric 1\n"
            + "modest 0\n"
            + "statistical 0.01 0.01 0.05 0.05 0.05 0.9 1.1 0.0 0.0 1280.0 0.01";

    public static void print(UppaalSystem sys, SymbolicState s) {
        System.out.print("(");
        for (SystemLocation l : s.getLocations()) {
            System.out.print(l.getName() + ", ");
        }
        int val[] = s.getVariableValues();
        for (int i = 0; i < sys.getNoOfVariables(); i++) {
            System.out.print(sys.getVariableName(i) + "=" + val[i] + ", ");
        }
        List<String> constraints = new ArrayList<String>();
        s.getPolyhedron().getAllConstraints(constraints);
        for (String cs : constraints) {
            System.out.print(cs + ", ");
        }
        System.out.println(")");
    }
}
