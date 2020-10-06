package dk.aau.cs.d703e20;

import dk.aau.cs.d703e20.errorhandling.OurErrorListener;
import dk.aau.cs.d703e20.parser.OurLexer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ListTokenSource;
import org.antlr.v4.runtime.Token;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        assertAll(
                () -> equalToken(OurLexer.IF, 0, tokens),
                () -> equalToken(OurLexer.LEFT_PAREN, 1, tokens),
                () -> equalToken(OurLexer.ID, 2, tokens),
                () -> equalToken(OurLexer.EQUAL, 3, tokens),
                () -> equalToken(OurLexer.BOOL_LITERAL, 4, tokens),
                () -> equalToken(OurLexer.RIGHT_PAREN, 5, tokens)
        );
    }

    // Test lexer token STRING_LITERAL as part of declaration
    @Test
    void testStringDecl() {
        List<Token> tokens = getTokensFromText("string text = \"hej123\";");
        assertAll("Should return token types (ints) for string declaration",
                () -> equalToken(OurLexer.STRING, 0, tokens),
                () -> equalToken(OurLexer.ID, 1, tokens),
                () -> equalToken(OurLexer.ASSIGN, 2, tokens),
                () -> equalToken(OurLexer.STRING_LITERAL, 3, tokens),
                () -> equalToken(OurLexer.SEMICOLON, 4, tokens)
        );
    }

    // Test lexer DIGIT's and FOR
    @Test
    void testForLoop() {
        List<Token> tokens = getTokensFromText("for ( 1 to 9) {5.68 + (-2.5) }");    // Purposely bad formatting
        assertAll("Should return token types (ints) for for loop and digits",
                () -> equalToken(OurLexer.FOR, 0, tokens),
                () -> equalToken(OurLexer.LEFT_PAREN, 1, tokens),
                () -> equalToken(OurLexer.DIGIT, 2, tokens),
                () -> equalToken(OurLexer.TO, 3, tokens),
                () -> equalToken(OurLexer.DIGIT, 4, tokens),
                () -> equalToken(OurLexer.RIGHT_PAREN, 5, tokens),
                () -> equalToken(OurLexer.LEFT_BRACKET, 6, tokens),
                () -> equalToken(OurLexer.DOUBLE_DIGIT, 7, tokens),
                () -> equalToken(OurLexer.ADD, 8, tokens),
                () -> equalToken(OurLexer.DOUBLE_DIGIT_NEGATIVE, 9, tokens),
                () -> equalToken(OurLexer.RIGHT_BRACKET, 10, tokens)
        );
    }

    // Test comments are properly discarded
    @Test
    void testComment() {
        List<Token> tokens = getTokensFromText("// This is a comment");
        // Comment token is discarded and will throw FailedError as token is 'EOF' and has no type
        assertThrows(AssertionFailedError.class, () -> equalToken(OurLexer.COMMENT_STRING, 0, tokens));
    }
}
