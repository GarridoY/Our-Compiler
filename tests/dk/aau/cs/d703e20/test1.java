package dk.aau.cs.d703e20;

import dk.aau.cs.d703e20.errorhandling.OurErrorListener;
import dk.aau.cs.d703e20.parser.OurLexer;
import dk.aau.cs.d703e20.parser.OurParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.List;

public class test1 {
    OurErrorListener errorlistener = new OurErrorListener();

    void test() {


        // String content = "int hej = 0";
        // OurLexer lexer = new OurLexer(CharStreams.fromString(content));

        // CommonTokenStream tokens = new CommonTokenStream(lexer);
        // OurParser parser = new OurParser(tokens);
        // ParseTree tree = parser.program();

        // ParseTreeWalker walker = new ParseTreeWalker();
        // OurParser listener = new OurParserListener();
        // walker.walk(listener, tree);
    }


    private List<Token> getTokensFromText(String txt) {
        // Instantiate lexer from text
        OurLexer lexer = new OurLexer(CharStreams.fromString(txt));
        lexer.addErrorListener(errorlistener);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        tokenStream.fill();
        return tokenStream.getTokens();
    }

    // Basic test if lexer works lexer
    @Test
    void testLexer() {
        List<Token> tokens = getTokensFromText("{");
        // Type of token "{" should be LEFT_BRACKET
        assertTrue(tokens.stream().anyMatch(p -> p.getType() == OurLexer.LEFT_BRACKET));

    }

}
