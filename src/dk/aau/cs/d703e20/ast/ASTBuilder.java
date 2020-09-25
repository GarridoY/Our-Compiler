package dk.aau.cs.d703e20.ast;

import dk.aau.cs.d703e20.ast.errorhandling.CompilerException;
import dk.aau.cs.d703e20.ast.expressions.*;
import dk.aau.cs.d703e20.ast.statements.*;
import dk.aau.cs.d703e20.ast.structure.BlockNode;
import dk.aau.cs.d703e20.ast.structure.FunctionDeclarationNode;
import dk.aau.cs.d703e20.ast.structure.MainNode;
import dk.aau.cs.d703e20.ast.structure.ProgramNode;
import dk.aau.cs.d703e20.parser.OurParser;
import dk.aau.cs.d703e20.parser.OurParserBaseVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ASTBuilder extends OurParserBaseVisitor<ASTNode> {
    @Override
    public ASTNode visitProgram(OurParser.ProgramContext ctx) {
        MainNode mainNode = (MainNode) visitMain(ctx.main());

        List<FunctionDeclarationNode> functionDeclarationNodes = visitList(FunctionDeclarationNode.class, ctx.functionDecl(), this::visitFunctionDecl);

        ProgramNode programNode = new ProgramNode(mainNode, functionDeclarationNodes);
        setCodePos(programNode, ctx);
        return programNode;
    }

    @Override
    public ASTNode visitMain(OurParser.MainContext ctx) {
        BlockNode blockNode = (BlockNode) visitBlock(ctx.block());

        MainNode mainNode = new MainNode(blockNode);
        setCodePos(mainNode, ctx);
        return mainNode;
    }

    @Override
    public ASTNode visitBlock(OurParser.BlockContext ctx) {
        List<StatementNode> statementNodes = visitList(StatementNode.class, ctx.statement(), this::visitStatement);

        BlockNode blockNode = new BlockNode(statementNodes);
        setCodePos(blockNode, ctx);
        return blockNode;
    }

    @Override
    public ASTNode visitFunctionDecl(OurParser.FunctionDeclContext ctx) {
        BlockNode blockNode = (BlockNode) visitBlock(ctx.block());
        FunctionDeclarationNode functionDeclarationNode = new FunctionDeclarationNode(getDataType(ctx.datatype()), ctx.functionName().getText(), blockNode);
        setCodePos(functionDeclarationNode, ctx);
        return functionDeclarationNode;
    }

    @Override
    public ASTNode visitFunctionParam(OurParser.FunctionParamContext ctx) {
        List<FunctionParameterNode> functionParameterNodes = visitList(FunctionParameterNode.class, ctx.functionParam(), this::visitFunctionParam);

        FunctionParameterNode functionParameterNode = new FunctionParameterNode(getDataType(ctx.datatype()), functionParameterNodes, ctx.variableName().getText());
        setCodePos(functionParameterNode, ctx);
        return functionParameterNode;
    }

    @Override
    public ASTNode visitStatement(OurParser.StatementContext ctx) {
        if (ctx.variableDecl() != null)
            return visitVariableDecl(ctx.variableDecl());
        else if (ctx.assignment() != null)
            return visitAssignment(ctx.assignment());
        else if (ctx.functionCall() != null)
            return visitFunctionCall(ctx.functionCall());
        else if (ctx.iterativeStatement() != null)
            return visitForStatement(ctx.iterativeStatement().forStatement());
        else
            throw new CompilerException("Invalid statement", getCodePosition(ctx));
    }

    @Override
    public ASTNode visitFunctionCall(OurParser.FunctionCallContext ctx) {
        FunctionCallNode functionCallNode = new FunctionCallNode(ctx.functionName().getText(), (FunctionArgsNode) visitFunctionArgs(ctx.functionArgs()));
        setCodePos(functionCallNode, ctx);
        return functionCallNode;
    }

    @Override
    public ASTNode visitFunctionArgs(OurParser.FunctionArgsContext ctx) {
        List<ExpressionNode> expressionNodes = visitList(ExpressionNode.class, ctx.expr(), this::visitExpr);

        List<BoolExpressionNode> boolExpressionNodes = visitList(BoolExpressionNode.class, ctx.boolExpr(), this::visitBoolExpr);

        FunctionArgsNode functionArgsNode = new FunctionArgsNode(expressionNodes, boolExpressionNodes);
        setCodePos(functionArgsNode, ctx);
        return functionArgsNode;
    }

    @Override
    public ASTNode visitIfElseStatement(OurParser.IfElseStatementContext ctx) {
        IfStatementNode ifStatementNode = (IfStatementNode) visitIfStatement(ctx.ifStatement());
        List<ElseIfStatementNode> elseIfStatementNode = null;
        ElseStatementNode elseStatementNode = null;

        // ElseIf nodes
        if (ctx.elseIfStatement() != null) {
            elseIfStatementNode = visitList(ElseIfStatementNode.class, ctx.elseIfStatement(), this::visitElseIfStatement);
        }
        // Else nodes
        if (ctx.elseStatement() != null) {
            elseStatementNode = (ElseStatementNode) visitElseStatement(ctx.elseStatement());
        }

        IfElseStatementNode ifElseStatementNode = new IfElseStatementNode(ifStatementNode, elseIfStatementNode, elseStatementNode);
        setCodePos(ifStatementNode, ctx);
        return ifElseStatementNode;
    }

    @Override
    public ASTNode visitIfStatement(OurParser.IfStatementContext ctx) {
        ExpressionNode expressionNode = (ExpressionNode) visitConditionalExpression(ctx.conditionalExpression());
        BlockNode blockNode = (BlockNode) visitBlock(ctx.block());

        IfStatementNode ifStatementNode = new IfStatementNode(expressionNode, blockNode);
        setCodePos(ifStatementNode, ctx);
        return ifStatementNode;
    }

    @Override
    public ASTNode visitElseIfStatement(OurParser.ElseIfStatementContext ctx) {
        ExpressionNode expressionNode = (ExpressionNode) visitConditionalExpression(ctx.conditionalExpression());
        BlockNode blockNode = (BlockNode) visitBlock(ctx.block());

        ElseIfStatementNode elseIfStatementNode = new ElseIfStatementNode(expressionNode, blockNode);
        setCodePos(elseIfStatementNode, ctx);
        return elseIfStatementNode;
    }

    @Override
    public ASTNode visitElseStatement(OurParser.ElseStatementContext ctx) {
        BlockNode blockNode = (BlockNode) visitBlock(ctx.block());

        ElseStatementNode elseStatementNode = new ElseStatementNode(blockNode);
        setCodePos(elseStatementNode, ctx);
        return elseStatementNode;
    }

    @Override
    public ASTNode visitConditionalExpression(OurParser.ConditionalExpressionContext ctx) {
        ConditionalExpressionNode conditionalExpressionNode;

        if (ctx.boolExpr() != null) {
            BoolExpressionNode boolExpressionNode = (BoolExpressionNode) visitBoolExpr(ctx.boolExpr());
            conditionalExpressionNode = new ConditionalExpressionNode(boolExpressionNode);
        } else if (ctx.variableName() != null) {
            conditionalExpressionNode = new ConditionalExpressionNode(ctx.variableName().getText());
        } else if (ctx.functionCall() != null) {
            FunctionCallNode functionCallNode = (FunctionCallNode) visitFunctionCall(ctx.functionCall());
            conditionalExpressionNode = new ConditionalExpressionNode(functionCallNode);
        } else {
            throw new CompilerException("Invalid conditional expression", getCodePosition(ctx));
        }

        setCodePos(conditionalExpressionNode, ctx);
        return conditionalExpressionNode;
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

    private Enums.DataType getDataType(OurParser.DatatypeContext ctx) {
        Enums.DataType dataType;

        if (ctx.INT() != null)
            dataType = Enums.DataType.INT;
        else if (ctx.BOOLEAN() != null)
            dataType = Enums.DataType.BOOL;
        else if (ctx.CLOCK() != null)
            dataType = Enums.DataType.CLOCK;
        else
            throw new CompilerException("DataType is unknown", getCodePosition(ctx));

        return dataType;
    }

    // Creates a list of T (ASTNodes), then visits all contexts in S using func
    // All the results from visiting are added to the list which gets returned.
    // Usage example:
    // List<StatementNode> statementNodes = visitList(StatementNode.class, ctx.statement(), this::visitStatement);
    private <T,S> List<T> visitList(Class<T> tClass, List<S> ctxs, Function<S, ASTNode> func) {
        List<T> nodes = new ArrayList<>();
        for (S ctx : ctxs) {
            nodes.add(tClass.cast(func.apply(ctx)));
        }
        return nodes;
    }

    // Set codePosition of a Node using ctx
    private void setCodePos(ASTNode node, ParserRuleContext ctx) {
        node.setCodePosition(getCodePosition(ctx));
    }

    private CodePosition getCodePosition(ParserRuleContext ctx) {
        return new CodePosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }
}
