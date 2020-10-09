package dk.aau.cs.d703e20;

import dk.aau.cs.d703e20.ast.ASTBuilder;
import dk.aau.cs.d703e20.ast.expressions.BoolExpressionNode;
import dk.aau.cs.d703e20.ast.expressions.ConditionalExpressionNode;
import dk.aau.cs.d703e20.ast.expressions.ExpressionNode;
import dk.aau.cs.d703e20.ast.statements.IfStatementNode;
import dk.aau.cs.d703e20.ast.structure.BlockNode;
import dk.aau.cs.d703e20.parser.OurLexer;
import dk.aau.cs.d703e20.parser.OurParser;
import dk.aau.cs.d703e20.resources.FailTestErrorListener;
import dk.aau.cs.d703e20.resources.TestToken;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ListTokenSource;
import org.antlr.v4.runtime.Token;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class astTest {

    // Turn string into list of lexer tokens
    private List<Token> getTokensFromText(String txt) {
        // Instantiate lexer from input text
        OurLexer lexer = new OurLexer(CharStreams.fromString(txt));
        // Add ANTLR errorListener to throw syntaxError exceptions, reports offending symbol and line
        lexer.addErrorListener(new FailTestErrorListener());
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        tokenStream.fill();
        return tokenStream.getTokens();
    }

    private OurParser createParser(List<Token> tokens) {
        ListTokenSource tokenSource = new ListTokenSource(tokens);
        CommonTokenStream cts = new CommonTokenStream(tokenSource);
        OurParser parser = new OurParser(cts);
        parser.addErrorListener(new FailTestErrorListener()); // Not expecting any syntax error, fails test if any
        return parser;
    }

    private  OurParser createParser(String txt) {
        List<Token> tokens = getTokensFromText(txt);
        return createParser(tokens);
    }

    // Test AST for conditional statement if
    @Test
    void testIF() {
        OurParser parser = createParser("if (hej == true) {}");
        OurParser.IfStatementContext ifStatement = parser.ifStatement();
        ASTBuilder astBuilder = new ASTBuilder();
        IfStatementNode ifStatementNode = (IfStatementNode) astBuilder.visitIfStatement(ifStatement);

        ConditionalExpressionNode conditionalExpressionNode = ifStatementNode.getConditionalExpressionNode();
        BoolExpressionNode boolExpressionNode = conditionalExpressionNode.getBoolExpression();
        BlockNode blockNode = ifStatementNode.getBlockNode();

        assertAll(
                () -> assertNotNull(blockNode),
                () -> assertNotNull(boolExpressionNode),
                () -> assertNotNull(conditionalExpressionNode)
        );

    }



}
