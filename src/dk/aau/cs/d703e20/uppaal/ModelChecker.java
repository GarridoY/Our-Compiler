package dk.aau.cs.d703e20.uppaal;

import com.uppaal.engine.*;
import com.uppaal.model.core2.Document;
import com.uppaal.model.core2.Location;
import com.uppaal.model.core2.Query;
import com.uppaal.model.system.SystemEdge;
import com.uppaal.model.system.SystemLocation;
import com.uppaal.model.system.UppaalSystem;
import com.uppaal.model.system.symbolic.SymbolicState;
import com.uppaal.model.system.symbolic.SymbolicTransition;
import dk.aau.cs.d703e20.Main;
import dk.aau.cs.d703e20.ast.structure.ProgramNode;
import dk.aau.cs.d703e20.errorhandling.ConsoleColors;
import dk.aau.cs.d703e20.uppaal.structures.UPPSystem;
import dk.aau.cs.d703e20.uppaal.structures.UPPTemplate;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModelChecker {
    private final ModelGen modelGen;
    private boolean queryFailed = false;

    public ModelChecker() {
        modelGen = new ModelGen();
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

    public void checkProgram(ProgramNode programNode, String fileName, String userQueryFileName, String userModelFileName) {

        Feedback feedback = new Feedback();

        try {
            System.out.println("\nGenerating UPPAAL model...\n");
            UPPSystem doc = modelGen.visitProgram(programNode, userModelFileName);

            // Get output directory
            String outputDir = System.getProperty("user.dir") + "\\Resources\\output";
            // Save the model into a file:
            doc.save(outputDir + "/" + fileName +  ".xml");

            System.out.println("\nVerifying UPPAAL model:\n");

            // Connect to the engine server:
            Engine engine = connectToEngine();

            // Create a link to a local Uppaal process:
            UppaalSystem sys = compile(engine, doc);

            // perform a random symbolic simulation and get a trace:
            // TODO Is there a need to make a trace? We probably just want the queries.
            //ArrayList<SymbolicTransition> trace = symbolicSimulation(engine, sys);

            // save the trace to an XTR file:
            // TODO Is this necessary? I read somewhere that it was basically unreadable.
            //saveXTRFile(trace, outputDir + "/output_trace.xtr");

            // Model-checking:
            System.out.println("===== Query verifier =====");
            List<Query> queryList = new ArrayList<>();

            Query deadlockQuery = new Query("E<> not deadlock", "");
            queryList.add(deadlockQuery);
            Query livenessQuery = new Query("controller.start --> controller.End_controller", "");
            queryList.add(livenessQuery);

            // Create queries and put them in a list to be run.
            for (UPPTemplate template : doc.getTemplateList()) {
                String templateName = template.getName();

                // Every timed construct should have Reachability and Liveness tests.
                if (templateName.contains("Bound")) {
                    queryList.addAll(getQueryFromTemplate(template, "Sync_done", "Bound_done"));
                } else if (templateName.contains("At")) {
                    queryList.addAll(getQueryFromTemplate(template, "startAt", "endAt"));
                }
            }

            // Add user queries
            if (userQueryFileName != null) {
                List<Query> userQueryList = getUserQueries(userQueryFileName);
                if (!userQueryList.isEmpty()) {
                    queryList.addAll(userQueryList);
                    System.out.println("[INFO] Added user queries.");
                }
            }

            // Run all queries
            for (Query query : queryList) {
                // Verify query
                QueryResult queryResult = engine.query(sys, options, query, feedback);
                // Check if query succeeded
                if ("OK".equals(queryResult.getStatusString())) {
                    System.out.println(ConsoleColors.GREEN + "[SUCCESS] " + query + " === OK" + ConsoleColors.RESET);
                } else {
                    queryFailed = true;
                    System.out.println(ConsoleColors.RED + "[WARNING] " + query + " === FAILED" + ConsoleColors.RESET);
                }
            }

            System.out.println("[INFO] Queries verified.\n");

            if (queryFailed)
                System.out.println(
                        ConsoleColors.RED +
                        "[WARNING] One or more queries could not be satisfied. Thus time safety cannot be guaranteed.\n\n" +
                        ConsoleColors.RESET);

            engine.disconnect();
        } catch (EngineException | IOException ex) {
            ex.printStackTrace(System.err);
            System.exit(1);
        }
    }

    private List<Query> getQueryFromTemplate(UPPTemplate template, String startStateName, String endStateName) {
        List<Query> queryList = new ArrayList<>();
        String templateName = template.getName();

        List<Location> locationList = template.getLocationList();

        // Find the last location
        Location endLocation = null;
        Location startLocation = null;
        for (Location location : locationList) {
            if (startStateName.equals(location.getName()))
                startLocation = location;
            if (endStateName.equals(location.getName()))
                endLocation = location;

            // If we have found both states - just stop searching.
            if (startLocation != null && endLocation != null)
                break;
        }

        // Liveness
        // Is it given that if we enter the start state, we also end up in the end state?
        if (endLocation != null && startLocation != null) {
            Query query = new Query("A<> " +
                    templateName + "." + startLocation.getName() +
                    " --> " +
                    templateName + "." + endLocation.getName(),
                    "");
            queryList.add(query);
        }

        // Reachability
        // Can we reach the end state in the template?
        if (endLocation != null) {
            Query query = new Query("A<> " + templateName + "." + endLocation.getName(), "");
            queryList.add(query);
        }

        return queryList;
    }

    public List<Query> getUserQueries(String filepath) {
        File file = new File(filepath);
        List<Query> queryList = new ArrayList<>();
        // Check if file extension is a .q as they are special UPPAAL query files containing special characters.
        boolean qFile = "q".equals(file.getName().split("\\.")[1]);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = reader.readLine();
            while (line != null) {
                if (qFile) {
                    if (line.isEmpty() || line.startsWith("//") || line.startsWith("/*") || line.startsWith("*/")) {
                        line = reader.readLine();
                        continue;
                    }
                }

                queryList.add(new Query(line, ""));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return queryList;
    }

    private Engine connectToEngine() throws EngineException, IOException {
        String os = System.getProperty("os.name");
        String here = Main.uppaalDirectory;

        String path;
        if ("Linux".equals(os))
            path = here + "/bin-Linux/server";
        else if (os.contains("Windows"))
            path = here + "\\bin-Windows\\server.exe";
        else
            throw new RuntimeException("OS not supported");

        Engine engine = new Engine();
        engine.setServerPath(path);
        engine.setServerHost("localhost");
        engine.setConnectionMode(EngineStub.BOTH);
        engine.connect();
        return engine;
    }

    private UppaalSystem compile(Engine engine, Document doc) throws EngineException {
        // compile the model into system:
        ArrayList<Problem> problems = new ArrayList<>();
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

    private ArrayList<SymbolicTransition> symbolicSimulation(Engine engine, UppaalSystem sys)
            throws EngineException, CannotEvaluateException {
        ArrayList<SymbolicTransition> trace = new ArrayList<>();
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
            }
            else {
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

    private void saveXTRFile(ArrayList<SymbolicTransition> trace, String file)
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

    private void print(UppaalSystem sys, SymbolicState s) {
        System.out.print("(");
        for (SystemLocation l : s.getLocations()) {
            System.out.print(l.getName() + ", ");
        }
        int[] val = s.getVariableValues();
        for (int i = 0; i < sys.getNoOfVariables(); i++) {
            System.out.print(sys.getVariableName(i) + "=" + val[i] + ", ");
        }
        List<String> constraints = new ArrayList<>();
        s.getPolyhedron().getAllConstraints(constraints);
        for (String cs : constraints) {
            System.out.print(cs + ", ");
        }
        System.out.println(")");
    }
}
