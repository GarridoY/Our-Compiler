package dk.aau.cs.d703e20;

import dk.aau.cs.d703e20.ast.ASTBuilder;
import dk.aau.cs.d703e20.codegen.ArduinoGenerator;
import dk.aau.cs.d703e20.errorhandling.ReasonableErrorStrategy;
import dk.aau.cs.d703e20.ast.structure.ProgramNode;
import dk.aau.cs.d703e20.parser.OurLexer;
import dk.aau.cs.d703e20.parser.OurParser;
import dk.aau.cs.d703e20.semantics.SemanticChecker;
import dk.aau.cs.d703e20.uppaal.ModelChecker;
import dk.aau.cs.d703e20.uppaal.ModelGen;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.io.IOException;

public class Main {
    public static String uppaalDirectory;

    public static void main(String[] args) {
        String inputFileName = null;
        boolean prettyPrint = false;

        String outputDirPath = System.getProperty("user.dir") + "\\Resources\\output";
        File file = new File(outputDirPath);

        if (!file.isDirectory()) {
            boolean makeDirSucceeded = file.mkdir();
            if (!makeDirSucceeded)
                throw new RuntimeException("Failed to create output folder");
        }

        //TODO: we need a better solution for checking arguments
        if (args.length > 0) {
            // Set file name which is to be compiled.
            inputFileName = args[0];

            if (args.length > 1) {
                if (args[1].equals("-pp"))
                    prettyPrint = true;
                else
                    uppaalDirectory = args[1]; //TODO: this is very hacky
            }
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
            ProgramNode programNode = (ProgramNode) astBuilder.visitProgram(parseTree);
            System.out.println("AST ok");

            //PRETTY PRINT
            if (prettyPrint) {
                System.out.println("Pretty print:\n");
                System.out.println(programNode.prettyPrint(0));
            }

            // SEMANTICS
            SemanticChecker semanticChecker = new SemanticChecker();
            semanticChecker.visitProgram(programNode);
            System.out.println("Semantics ok");

            // VERIFY TIME IN UPPAAL
            ModelChecker modelChecker = new ModelChecker();
            modelChecker.checkProgram(programNode);
            System.out.println("Time check finished\n");

            // Generate and print Arduino code
            ArduinoGenerator arduinoGenerator = new ArduinoGenerator();
            System.out.println(arduinoGenerator.GenerateArduino(programNode));

            System.exit(0);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
