package dk.aau.cs.d703e20;

import dk.aau.cs.d703e20.ast.ASTBuilder;
import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.expressions.*;
import dk.aau.cs.d703e20.ast.statements.*;
import dk.aau.cs.d703e20.ast.structure.*;
import dk.aau.cs.d703e20.parser.OurLexer;
import dk.aau.cs.d703e20.parser.OurParser;
import dk.aau.cs.d703e20.resources.FailTestErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class astTest {

    private OurParser createParserFromText(String txt) {
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

    // Test AST for AssignmentNode
    @Test
    void testASSIGN() {
        OurParser parser = createParserFromText("four = 4;");
        OurParser.AssignmentContext assignment = parser.assignment();
        ASTBuilder astBuilder = new ASTBuilder();

        AssignmentNode assignmentNode = (AssignmentNode) astBuilder.visitAssignment(assignment);

        assertAll(
                () -> assertEquals("four", assignmentNode.getVariableName() )
        );


    }

    // Test AST for conditional statement if
    @Test
    void testIF() {
        OurParser parser = createParserFromText("if (hej == true) {}");
        OurParser.IfStatementContext ifStatement = parser.ifStatement();
        ASTBuilder astBuilder = new ASTBuilder();
        IfStatementNode ifStatementNode = (IfStatementNode) astBuilder.visitIfStatement(ifStatement);

        ConditionalExpressionNode conditionalExpressionNode = ifStatementNode.getConditionalExpressionNode();
        BoolExpressionNode boolExpressionNode = conditionalExpressionNode.getBoolExpressionNode();
        BlockNode blockNode = ifStatementNode.getBlockNode();

        assertAll(
                () -> assertNotNull(blockNode),
                () -> assertNotNull(boolExpressionNode),
                () -> assertNotNull(conditionalExpressionNode)
        );

    }

    // Test AST for conditional statement if else if
    @Test
    void testIFELSEIF() {
        OurParser parser = createParserFromText("if (hej == true) {} else if (test) {} else {}");
        OurParser.IfElseStatementContext ifElseStatement = parser.ifElseStatement();
        ASTBuilder astBuilder = new ASTBuilder();
        IfElseStatementNode ifElseStatementNode = (IfElseStatementNode) astBuilder.visitIfElseStatement(ifElseStatement);

        IfStatementNode ifStatementNode = ifElseStatementNode.getIfStatementNode();
        List<ElseIfStatementNode> elseIfStatementNodes = ifElseStatementNode.getElseIfStatementNodes();
        ElseStatementNode elseStatementNode = ifElseStatementNode.getElseStatement();

        assertAll(
                () -> assertNotNull(ifStatementNode),
                () -> assertNotNull(elseIfStatementNodes),
                () -> assertNotNull(elseStatementNode)
        );

    }

    // Test AST for bool expression
    @Test
    void testBOOLEXPR() {
        OurParser parser = createParserFromText("test1 == test2");
        OurParser.BoolExprContext boolExpr = parser.boolExpr();
        ASTBuilder astBuilder = new ASTBuilder();
        BoolExpressionNode boolExpressionNode = (BoolExpressionNode) astBuilder.visitBoolExpr(boolExpr);

        ArithExpressionNode expressionNode1 = boolExpressionNode.getArithExpressionNode1();
        ArithExpressionNode expressionNode2 = boolExpressionNode.getArithExpressionNode2();
        Enums.BoolOperator operator = boolExpressionNode.getBoolExpressionOperator();


        assertAll(
                () -> assertEquals("test1", expressionNode1.getVariableName()),
                () -> assertEquals("test2", expressionNode2.getVariableName()),
                () -> assertEquals(Enums.BoolOperator.EQUAL, operator)
        );
    }






}
