package dk.aau.cs.d703e20.resources;

import dk.aau.cs.d703e20.ast.ASTBuilder;
import dk.aau.cs.d703e20.parser.OurLexer;
import dk.aau.cs.d703e20.parser.OurParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Utilities {

    public static OurParser createParserFromText(String txt) {
        // Instantiate lexer from input text
        OurLexer lexer = new OurLexer(CharStreams.fromString(txt));
        // Add ANTLR errorListener to throw syntaxError exceptions, reports offending symbol and line
        lexer.addErrorListener(new FailTestErrorListener());
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        // Instantiate parser from lexer tokens
        OurParser parser = new OurParser(tokenStream);
        parser.addErrorListener(new FailTestErrorListener()); // Not expecting any syntax error, fails test if any
        return parser;
    }

    public static <T, S> T getNodeFromText(String text, Class<T> nodeClass, Class<S> contextClass, String parseRuleName) {
        // Parse text
        OurParser parser = createParserFromText(text);

        T node = null;
        try {
            // parser.parseRuleName()
            Method contextMethod = OurParser.class.getMethod(parseRuleName);

            // ASTBuilder.visitParseRuleName(contextClass)
            Method visitorMethod = ASTBuilder.class.getMethod(
                    "visit" + parseRuleName.toUpperCase().substring(0,1) + parseRuleName.substring(1),
                    contextClass);

            // Get OurParser.parseRuleNameContext from parser
            S context = (S) contextMethod.invoke(parser);

            // Get Node from visitorMethod in ASTBuilder using context
            node = nodeClass.cast(visitorMethod.invoke(new ASTBuilder(), context));
        }
        catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return node;
    }
}
