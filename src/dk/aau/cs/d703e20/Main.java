package dk.aau.cs.d703e20;

import dk.aau.cs.d703e20.lexer.OurLexer;
import dk.aau.cs.d703e20.parser.OurParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inputFileName = null;

        // Set file name which is to be compiled.
        if (args.length > 0) {
            inputFileName = args[1];
        }

        if (inputFileName == null) {
            throw new RuntimeException("No input file specified");
        }

        try {
            OurLexer lexer = new OurLexer(CharStreams.fromFileName(inputFileName));
            OurParser parser = new OurParser(new CommonTokenStream(lexer));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
