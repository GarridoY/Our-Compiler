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
        return visitForStatement(ctx.forStatement());
    }

    @Override
    public ASTNode visitForStatement(OurParser.ForStatementContext ctx) {
        ArithExpressionNode arithExpressionNode1 = (ArithExpressionNode) visitExpr(ctx.expr(0));
        ArithExpressionNode arithExpressionNode2 = (ArithExpressionNode) visitExpr(ctx.expr(1));
        BlockNode blockNode = (BlockNode) visitBlock(ctx.block());

        ForStatementNode forStatementNode = new ForStatementNode(arithExpressionNode1, arithExpressionNode2, blockNode);
        setCodePos(forStatementNode, ctx);

        return forStatementNode;
    }

    @Override
    public ASTNode visitExpr(OurParser.ExprContext ctx) {
        ExpressionNode expressionNode;

        if (ctx.expr(0) != null){
            if(ctx.expr(1) != null){
                ArithExpressionNode node1 = (ArithExpressionNode) visitExpr(ctx.expr(0));
                ArithExpressionNode node2 = (ArithExpressionNode) visitExpr(ctx.expr(1));
                expressionNode = new ArithExpressionNode(node1 , node2, getArithOperator(ctx.arit_op()));
            } else {
                ArithExpressionNode node = (ArithExpressionNode) visitExpr(ctx.expr(0));
                expressionNode = new ArithExpressionNode(node);
            }
        } else if (ctx.numLiteral() != null) {
            expressionNode = new ArithExpressionNode(getNumLiteralValue(ctx.numLiteral()));
        } else if (ctx.variableName() != null) {
            expressionNode = new ArithExpressionNode(ctx.variableName().getText());
        } else {
            throw new CompilerException("Invalid Expression", getCodePosition(ctx));
        }

        setCodePos(expressionNode, ctx);
        return expressionNode;
    }

    @Override
    public ASTNode visitBoolExpr(OurParser.BoolExprContext ctx) {
        BoolExpressionNode boolExpressionNode;

        if (ctx.boolExpr() != null) {
            if (ctx.NOT() != null) {
                //if there is 'NOT' before the expression
            }
            boolExpressionNode = (BoolExpressionNode) visitBoolExpr(ctx.boolExpr());
            return boolExpressionNode;
        } else if (ctx.BOOL_LITERAL() != null) {
            if (ctx.BOOL_LITERAL(1) != null) {

                ExpressionNode node1 = (ExpressionNode) visitExpr(ctx.expr(0));
                ExpressionNode node2 = (ExpressionNode) visitExpr(ctx.expr(1));

                return new BoolExpressionNode(node1, node2, getBoolOperator(ctx.bool_op()));
            } else if (ctx.expr() != null){
                ExpressionNode expressionNode = (ExpressionNode) visitExpr(ctx.expr(0));
                return new BoolExpressionNode(expressionNode, ctx.BOOL_LITERAL(0).getText(), getBoolOperator(ctx.bool_op()));
            } else {
                return new BoolExpressionNode(ctx.BOOL_LITERAL(0).getText());
            }
        } else {
            throw new  CompilerException("Invalid Boolean Expression", getCodePosition(ctx));
        }
    }

    @Override
    public ASTNode visitVariableDecl(OurParser.VariableDeclContext ctx) {
        VariableDeclarationNode variableDeclarationNode;

        try {
            Enums.DataType dataType = getDataType(ctx.datatype());
            AssignmentNode assignmentNode = (AssignmentNode) visitAssignment(ctx.assignment());
            variableDeclarationNode = new VariableDeclarationNode(dataType, assignmentNode);
        } catch (CompilerException e){
            throw new CompilerException("Invalid Variable Declaration Statement", getCodePosition(ctx));
        }

        return variableDeclarationNode;
    }

    @Override
    public ASTNode visitAssignment(OurParser.AssignmentContext ctx) {
        if (ctx.literal() != null) {
            return new AssignmentNode(ctx.variableName().getText(), ctx.literal().getText());
        } else if (ctx.expr() != null) {
            ExpressionNode expressionNode = (ExpressionNode) visitAssignment(ctx);
            return new AssignmentNode(ctx.variableName().getText(), expressionNode);
        }
        else {
            throw new CompilerException("Invalid Assignment Statement", getCodePosition(ctx));
        }
    }

    @Override
    public ASTNode visitReturnStatement(OurParser.ReturnStatementContext ctx) {
        return new ReturnStatementNode(ctx.variableName().getText());
    }

    @Override
    public ASTNode visitAtStatement(OurParser.AtStatementContext ctx) {
        try {
            ExpressionNode expressionNode = (ExpressionNode) visitExpr(ctx.expr());
            BlockNode blockNode = (BlockNode) visitBlock(ctx.block());
            return new AtStatementNode(ctx.variableName().getText(), expressionNode, getBoolOperator(ctx.bool_op()), blockNode);
        } catch (CompilerException e) {
            throw new CompilerException("Invalid At Statement", getCodePosition(ctx));
        }
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

    private Enums.Operator getArithOperator(OurParser.Arit_opContext ctx) {
        Enums.Operator operator;

        if (ctx.ADD() != null){
            operator = Enums.Operator.ADD;
        } else if (ctx.SUB() != null) {
            operator = Enums.Operator.SUB;
        } else if (ctx.MOD() != null) {
            operator = Enums.Operator.MOD;
        } else if (ctx.DIV() != null) {
            operator = Enums.Operator.DIV;
        } else if (ctx.MUL() != null) {
            operator = Enums.Operator.MUL;
        } else {
            throw new CompilerException("Operator is unknown", getCodePosition(ctx));
        }
        return operator;
    }

    private  Enums.BoolOperator getBoolOperator(OurParser.Bool_opContext ctx) {
        Enums.BoolOperator operator;

        if (ctx.EQUAL() != null){
            operator = Enums.BoolOperator.EQUAL;
        } else if (ctx.NOT_EQUAL() != null) {
            operator = Enums.BoolOperator.NOT_EQUAL;
        } else if (ctx.GREATER_THAN() != null) {
            operator = Enums.BoolOperator.GREATER_THAN;
        } else if (ctx.GREATER_OR_EQUAL() != null) {
            operator = Enums.BoolOperator.GREATER_OR_EQUAL;
        } else if (ctx.LESS_THAN() != null) {
            operator = Enums.BoolOperator.LESS_THAN;
        } else if (ctx.LESS_OR_EQUAL() != null) {
            operator = Enums.BoolOperator.LESS_OR_EQUAL;
        } else {
            throw new CompilerException("Operator is unknown", getCodePosition(ctx));
        }

        return  operator;
    }

    private Double getNumLiteralValue (OurParser.NumLiteralContext ctx){
        return Double.valueOf(ctx.getText());
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
