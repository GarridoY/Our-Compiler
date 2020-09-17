package dk.aau.cs.d703e20.ast;

import dk.aau.cs.d703e20.ast.statements.StatementNode;
import dk.aau.cs.d703e20.ast.structure.BlockNode;
import dk.aau.cs.d703e20.ast.structure.FunctionDeclarationNode;
import dk.aau.cs.d703e20.ast.structure.MainNode;
import dk.aau.cs.d703e20.ast.structure.ProgramNode;
import dk.aau.cs.d703e20.parser.OurParser;
import dk.aau.cs.d703e20.parser.OurParserBaseVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;

public class ASTBuilder extends OurParserBaseVisitor<ASTNode> {
    @Override
    public ProgramNode visitProgram(OurParser.ProgramContext ctx) {
        MainNode mainNode = visitMain(ctx.main());

        List<FunctionDeclarationNode> functionDeclarationNodes = new ArrayList<>();
        for (OurParser.FunctionDeclContext functionDecl : ctx.functionDecl()) {
            functionDeclarationNodes.add(visitFunctionDecl(functionDecl));
        }

        ProgramNode programNode = new ProgramNode(mainNode, functionDeclarationNodes);
        programNode.setCodePosition(getCodePosition(ctx));
        return programNode;
    }

    @Override
    public MainNode visitMain(OurParser.MainContext ctx) {
        BlockNode blockNode = visitBlock(ctx.block());

        MainNode mainNode = new MainNode(blockNode);
        mainNode.setCodePosition(getCodePosition(ctx));
        return mainNode;
    }

    @Override
    public BlockNode visitBlock(OurParser.BlockContext ctx) {
        List<StatementNode> statementNodes = new ArrayList<>();

        for (OurParser.StatementContext statement : ctx.statement()) {
            statementNodes.add(visitStatement(statement));
        }
        BlockNode blockNode = new BlockNode(statementNodes);
        blockNode.setCodePosition(getCodePosition(ctx));
        return blockNode;
    }

    @Override
    public ASTNode visitFunctionDecl(OurParser.FunctionDeclContext ctx) {
        return super.visitFunctionDecl(ctx);
    }

    @Override
    public ASTNode visitFunctionParam(OurParser.FunctionParamContext ctx) {
        return super.visitFunctionParam(ctx);
    }

    @Override
    public ASTNode visitStatement(OurParser.StatementContext ctx) {
        return super.visitStatement(ctx);
    }

    @Override
    public ASTNode visitFunctionCall(OurParser.FunctionCallContext ctx) {
        return super.visitFunctionCall(ctx);
    }

    @Override
    public ASTNode visitIfElseStatement(OurParser.IfElseStatementContext ctx) {
        return super.visitIfElseStatement(ctx);
    }

    @Override
    public ASTNode visitIfStatement(OurParser.IfStatementContext ctx) {
        return super.visitIfStatement(ctx);
    }

    @Override
    public ASTNode visitElseIfStatement(OurParser.ElseIfStatementContext ctx) {
        return super.visitElseIfStatement(ctx);
    }

    @Override
    public ASTNode visitElseStatement(OurParser.ElseStatementContext ctx) {
        return super.visitElseStatement(ctx);
    }

    @Override
    public ASTNode visitConditionalExpression(OurParser.ConditionalExpressionContext ctx) {
        return super.visitConditionalExpression(ctx);
    }

    @Override
    public ASTNode visitIterativeStatement(OurParser.IterativeStatementContext ctx) {
        return super.visitIterativeStatement(ctx);
    }

    @Override
    public ASTNode visitForStatement(OurParser.ForStatementContext ctx) {
        return super.visitForStatement(ctx);
    }

    @Override
    public ASTNode visitExpr(OurParser.ExprContext ctx) {
        return super.visitExpr(ctx);
    }

    @Override
    public ASTNode visitBoolExpr(OurParser.BoolExprContext ctx) {
        return super.visitBoolExpr(ctx);
    }

    @Override
    public ASTNode visitBoolSymbol(OurParser.BoolSymbolContext ctx) {
        return super.visitBoolSymbol(ctx);
    }

    @Override
    public ASTNode visitVariableDecl(OurParser.VariableDeclContext ctx) {
        return super.visitVariableDecl(ctx);
    }

    @Override
    public ASTNode visitAssignment(OurParser.AssignmentContext ctx) {
        return super.visitAssignment(ctx);
    }

    @Override
    public ASTNode visitVariableName(OurParser.VariableNameContext ctx) {
        return super.visitVariableName(ctx);
    }

    @Override
    public ASTNode visitFunctionName(OurParser.FunctionNameContext ctx) {
        return super.visitFunctionName(ctx);
    }

    @Override
    public ASTNode visitDatatype(OurParser.DatatypeContext ctx) {
        return super.visitDatatype(ctx);
    }

    @Override
    public ASTNode visitLiteral(OurParser.LiteralContext ctx) {
        return super.visitLiteral(ctx);
    }

    @Override
    public ASTNode visitNumLiteral(OurParser.NumLiteralContext ctx) {
        return super.visitNumLiteral(ctx);
    }

    private CodePosition getCodePosition(ParserRuleContext ctx) {
        return new CodePosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }
}
