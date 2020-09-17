package dk.aau.cs.d703e20;

import dk.aau.cs.d703e20.ast.ASTBuilder;
import dk.aau.cs.d703e20.ast.errorhandling.ReasonableErrorStrategy;
import dk.aau.cs.d703e20.parser.OurLexer;
import dk.aau.cs.d703e20.parser.OurParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inputFileName = null;

        System.out.println(args[0]);

        // Set file name which is to be compiled.
        if (args.length > 0) {
            inputFileName = args[0];
        }

        if (inputFileName == null) {
            throw new RuntimeException("No input file specified");
        }

        // LEXER / PARSER
        OurParser.ProgramContext parseTree = null;
        try {
            OurLexer lexer = new OurLexer(CharStreams.fromFileName(inputFileName));
            OurParser parser = new OurParser(new CommonTokenStream(lexer));
            parser.setErrorHandler(new ReasonableErrorStrategy());
            parseTree = parser.program();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // AST
        ASTBuilder astBuilder = new ASTBuilder();
        if (parseTree != null) {
            astBuilder.visitProgram(parseTree);
        } else {
            throw new RuntimeException("AST ERROR.");
        }
    }
}
