package dk.aau.cs.d703e20;

import dk.aau.cs.d703e20.parser.OurLexer;
import dk.aau.cs.d703e20.parser.OurParser;
import dk.aau.cs.d703e20.resources.FailTestErrorListener;
import dk.aau.cs.d703e20.resources.TestToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ListTokenSource;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


// Match list of tokens to correct parser rule
public class parserTest {
    final TestToken l_paren = new TestToken("Left_Paren", OurLexer.LEFT_PAREN);
    final TestToken r_paren = new TestToken("Right_Paren", OurLexer.RIGHT_PAREN);
    final TestToken l_bracket = new TestToken("Left_Bracket", OurLexer.LEFT_BRACKET);
    final TestToken r_bracket = new TestToken("Right_Bracket", OurLexer.RIGHT_BRACKET);


    private OurParser createParser(List<TestToken> tokens) {
        ListTokenSource tokenSource = new ListTokenSource(tokens);
        CommonTokenStream cts = new CommonTokenStream(tokenSource);
        OurParser parser = new OurParser(cts);
        parser.addErrorListener(new FailTestErrorListener()); // Not expecting any syntax error, fails test if any
        return parser;
    }

    @Test
    void testProgram() {
        // Create list of program tokens
        List<TestToken> tokens = List.of(
                new TestToken("Setup", OurLexer.SETUP),
                l_bracket,
                r_bracket,
                new TestToken("Loop", OurLexer.LOOP),
                l_bracket,
                r_bracket
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
    void testFunctionDecl() {
        String fname = "myFunction";
        // Create list of functionDecl tokens
        List<TestToken> tokens = List.of(
                new TestToken("type", OurLexer.VOID),
                new TestToken(fname, OurLexer.ID),
                l_paren,
                r_paren,
                l_bracket,
                r_bracket
        );
        OurParser parser = createParser(tokens);
        OurParser.FunctionDeclContext func = parser.functionDecl();
        assertEquals(fname, func.functionName().getText());
    }

    @Test
    void testFunctionDeclParam() {
        List<TestToken> tokens = List.of(
                new TestToken("type", OurLexer.VOID),
                new TestToken("myFunction", OurLexer.ID),
                l_paren,
                new TestToken("Param_type", OurLexer.INT),
                new TestToken("Param2", OurLexer.ID),
                r_paren,
                l_bracket,
                r_bracket
        );
        OurParser parser = createParser(tokens);
        OurParser.FunctionDeclContext func = parser.functionDecl();
        assertNotNull(func.functionParam().dataType(0).INT());
    }

    @Test
    void testFunctionCall() {
        String fname = "Function";
        List<TestToken> tokens = List.of(
                new TestToken(fname, OurLexer.ID),
                l_paren,
                new TestToken("IntArg", OurLexer.DIGIT),
                new TestToken("Comma", OurLexer.COMMA),
                new TestToken("DoubleArg", OurLexer.DOUBLE_DIGIT),
                r_paren
        );
        OurParser parser = createParser(tokens);
        OurParser.FunctionCallContext fcall = parser.functionCall();
        assertEquals(fname, fcall.functionName().getText());
        assertEquals(2, fcall.functionArgs().arithExpr().size());
    }

    @Test
    void testFunctionCallEmptyArg() {
        String fname = "Function";
        List<TestToken> tokens = List.of(
                new TestToken(fname, OurLexer.ID),
                l_paren,
                r_paren
        );
        OurParser parser = createParser(tokens);
        OurParser.FunctionCallContext fcall = parser.functionCall();
        assertNull(fcall.functionArgs());
    }

    @Test
    void testVariableDecl() {
        String varname = "Var1";
        List<TestToken> tokens = List.of(
                new TestToken("Var_Type", OurLexer.STRING),
                new TestToken(varname, OurLexer.ID),
                new TestToken("Assign", OurLexer.ASSIGN),
                new TestToken("Literal", OurLexer.STRING_LITERAL),
                new TestToken("Semicolon", OurLexer.SEMICOLON)
        );
        OurParser parser = createParser(tokens);
        OurParser.VariableDeclContext varDeclctx = parser.variableDecl();
        assertNotNull(varDeclctx.assignment().literal().STRING_LITERAL());
    }

    @Test
    void testAtStatement() {
        String var_name = "Var_name";
        List<TestToken> tokens = List.of(
                new TestToken("At", OurLexer.AT),
                l_paren,
                new TestToken(var_name, OurLexer.ID),
                new TestToken("Operator", OurLexer.LESS_THAN),
                new TestToken("Expr", OurLexer.DIGIT),
                r_paren,
                l_bracket,
                r_bracket
        );
        OurParser parser = createParser(tokens);
        OurParser.AtStatementContext atCtx = parser.atStatement();
        assertNotNull(atCtx.arithExpr().numLiteral().DIGIT());
        assertEquals(OurLexer.LESS_THAN, atCtx.boolOp().LESS_THAN().getSymbol().getType());
    }
}
