package dk.aau.cs.d703e20;

import dk.aau.cs.d703e20.errorhandling.OurErrorListener;
import dk.aau.cs.d703e20.parser.OurLexer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.List;

// Testing and ensuring that lexer turns string of code into expected tokens
public class lexerTest {
    OurErrorListener errorListener = new OurErrorListener();

    // Parser testing. Probably.
    // void test() {
    // String content = "int hej = 0";
    // OurLexer lexer = new OurLexer(CharStreams.fromString(content));

    // CommonTokenStream tokens = new CommonTokenStream(lexer);
    // OurParser parser = new OurParser(tokens);
    // ParseTree tree = parser.program();

    // ParseTreeWalker walker = new ParseTreeWalker();
    // OurParser listener = new OurParserListener();
    // walker.walk(listener, tree);
    // }


    // Turn string into list of lexer tokens
    private List<Token> getTokensFromText(String txt) {
        // Instantiate lexer from input text
        OurLexer lexer = new OurLexer(CharStreams.fromString(txt));
        // Add ANTLR errorListener to throw syntaxError exceptions, reports offending symbol and line
        lexer.addErrorListener(errorListener);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        tokenStream.fill();
        return tokenStream.getTokens();
    }

    // Method for comparing lexer rules to tokens
    // lexerRule is int as Lexer stores token types as integers
    private void equalToken(int lexerRule, int tokenIndex, List<Token> tokens) {
        assertEquals(lexerRule, tokens.get(tokenIndex).getType());
    }

    // Basic test if lexer can create tokens
    @Test
    void testLexer() {
        List<Token> tokens = getTokensFromText("{");
        // Type of token "{" should be LEFT_BRACKET
        // Use of lambda to define predicate function for type matching
        assertTrue(tokens.stream().anyMatch(p -> p.getType() == OurLexer.LEFT_BRACKET));
    }

    // Test lexer tokens for conditional statement if
    @Test
    void testIF() {
        List<Token> tokens = getTokensFromText("if (hej == true)");
        equalToken(OurLexer.IF, 0, tokens);
        equalToken(OurLexer.LEFT_PAREN, 1, tokens);
        equalToken(OurLexer.ID, 2, tokens);
        equalToken(OurLexer.EQUAL, 3, tokens);
        equalToken(OurLexer.BOOL_LITERAL, 4, tokens);
        equalToken(OurLexer.RIGHT_PAREN, 5, tokens);
    }

}
