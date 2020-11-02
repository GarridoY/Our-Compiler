package dk.aau.cs.d703e20.semantics;

import dk.aau.cs.d703e20.ast.structure.ProgramNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimeVerifier {
    public TimeVerifier() {

    }

    public void verifyProgram(ProgramNode programNode) {
        try {
            System.out.println("\nRUNNING UPPAAL:\n");

            // TODO: generate model to use instead of example
            String filePath = getClass().getResource("/UPPAAL_models/CreatePopcorn.xml").getPath().substring(1);

            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "verifyta " + filePath);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) { break; }
                System.out.println(line);
            }

            // TODO: throw exception if UPPAAL fails

            System.out.println("\n");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
