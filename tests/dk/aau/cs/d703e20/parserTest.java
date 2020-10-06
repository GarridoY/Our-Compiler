package dk.aau.cs.d703e20;

import dk.aau.cs.d703e20.errorhandling.OurErrorListener;
import dk.aau.cs.d703e20.parser.OurLexer;
import dk.aau.cs.d703e20.parser.OurParser;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ListTokenSource;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


// Match list of tokens to correct parser rule
public class parserTest {

    private OurParser createParser(List<TestToken> tokens) {
        ListTokenSource tokenSource = new ListTokenSource(tokens);
        CommonTokenStream cts = new CommonTokenStream(tokenSource);
        OurParser parser = new OurParser(cts);
        parser.addErrorListener(new OurErrorListener());
        return parser;
    }

    @Test
    void testProgram() {
        // Create list of program tokens
        List<TestToken> tokens = List.of(
                new TestToken("Setup", OurLexer.SETUP),
                new TestToken("L_Bracket0", OurLexer.LEFT_BRACKET),
                new TestToken("R_Bracket0", OurLexer.RIGHT_BRACKET),
                new TestToken("Loop", OurLexer.LOOP),
                new TestToken("L_Bracket1", OurLexer.LEFT_BRACKET),
                new TestToken("L_Bracket1", OurLexer.RIGHT_BRACKET)
        );
        // Create parser based on tokens
        OurParser parser = createParser(tokens);
        // Get rule for testing
        OurParser.ProgramContext prog = parser.program();
        // Assert that rule is not empty
        assertNotNull(prog.setup(), "Setup part of program rule was null");
        assertNotNull(prog.loop(), "Loop part of program rule was null");
    }

    @Test
    void testFunction() {
        // Create list of functionDecl tokens
        List<TestToken> tokens = List.of(
                new TestToken("type", OurLexer.VOID),
                new TestToken("myFunction", OurLexer.ID),
                new TestToken("L_Paren", OurLexer.LEFT_PAREN),
                new TestToken("R_Paren", OurLexer.RIGHT_PAREN),
                new TestToken("L_Bracket1", OurLexer.LEFT_BRACKET),
                new TestToken("L_Bracket1", OurLexer.RIGHT_BRACKET)

        );
        OurParser parser = createParser(tokens);
        OurParser.FunctionDeclContext func = parser.functionDecl();
        assertNotNull(func.functionName());
    }

}
