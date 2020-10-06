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

        if (args.length > 0) {
            // Set file name which is to be compiled.
            inputFileName = args[0];
        }

        if (inputFileName == null) {
            throw new RuntimeException("No input file specified");
        }

        try {
            System.out.println("Compiling: " + inputFileName);

            // LEXER
            OurLexer lexer = new OurLexer(CharStreams.fromFileName(inputFileName));
            System.out.println("Lexer ok");

            // PARSER
            OurParser parser = new OurParser(new CommonTokenStream(lexer));
            parser.setErrorHandler(new ReasonableErrorStrategy());
            OurParser.ProgramContext parseTree = parser.program();
            System.out.println("Parser ok");

            // AST
            ASTBuilder astBuilder = new ASTBuilder();
            astBuilder.visitProgram(parseTree);
            System.out.println("AST ok");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
