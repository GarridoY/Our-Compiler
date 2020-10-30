package dk.aau.cs.d703e20;

import dk.aau.cs.d703e20.ast.ASTBuilder;
import dk.aau.cs.d703e20.ast.ASTNode;
import dk.aau.cs.d703e20.ast.errorhandling.AlreadyDeclaredException;
import dk.aau.cs.d703e20.ast.errorhandling.CompilerException;
import dk.aau.cs.d703e20.ast.errorhandling.InconsistentTypeException;
import dk.aau.cs.d703e20.ast.errorhandling.UndeclaredVariableException;
import dk.aau.cs.d703e20.ast.statements.AssignmentNode;
import dk.aau.cs.d703e20.ast.statements.VariableDeclarationNode;
import dk.aau.cs.d703e20.ast.structure.BlockNode;
import dk.aau.cs.d703e20.parser.OurLexer;
import dk.aau.cs.d703e20.parser.OurParser;
import dk.aau.cs.d703e20.resources.FailTestErrorListener;
import dk.aau.cs.d703e20.semantics.SemanticChecker;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class semanticTest {
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

    @Test
    void testInvalidDeclarationType01() {
        OurParser parser = createParserFromText("string four = 4;");
        OurParser.VariableDeclContext variableDecl = parser.variableDecl();

        ASTBuilder astBuilder = new ASTBuilder();
        VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode) astBuilder.visitVariableDecl(variableDecl);

        SemanticChecker semanticChecker = new SemanticChecker();
        assertThrows(InconsistentTypeException.class,
                ()-> semanticChecker.visitVariableDeclaration(variableDeclarationNode)
        );
    }

    @Test
    void testInvalidDeclarationType02() {
        OurParser parser = createParserFromText("int boolit = false;");
        OurParser.VariableDeclContext variableDecl = parser.variableDecl();

        ASTBuilder astBuilder = new ASTBuilder();
        VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode) astBuilder.visitVariableDecl(variableDecl);

        SemanticChecker semanticChecker = new SemanticChecker();
        assertThrows(InconsistentTypeException.class,
                ()-> semanticChecker.visitVariableDeclaration(variableDeclarationNode)
        );
    }

    @Test
    void testAlreadyDeclaredVariable() {
        OurParser parser = createParserFromText("{int a = 0; int a = 1;}");
        OurParser.BlockContext block = parser.block();

        ASTBuilder astBuilder = new ASTBuilder();
        BlockNode blockNode = (BlockNode) astBuilder.visitBlock(block);

        SemanticChecker semanticChecker = new SemanticChecker();
        assertThrows(AlreadyDeclaredException.class,
                ()-> semanticChecker.visitBlock(blockNode)
        );
    }

    @Test
    void testUndeclaredVariable() {
        OurParser parser = createParserFromText("{int a = b;}");
        OurParser.BlockContext block = parser.block();

        ASTBuilder astBuilder = new ASTBuilder();
        BlockNode blockNode = (BlockNode) astBuilder.visitBlock(block);

        SemanticChecker semanticChecker = new SemanticChecker();
        assertThrows(UndeclaredVariableException.class,
                ()-> semanticChecker.visitBlock(blockNode)
        );
    }
}
