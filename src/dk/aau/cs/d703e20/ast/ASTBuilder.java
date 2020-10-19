package dk.aau.cs.d703e20.ast;

import dk.aau.cs.d703e20.ast.errorhandling.CompilerException;
import dk.aau.cs.d703e20.ast.expressions.*;
import dk.aau.cs.d703e20.ast.statements.*;
import dk.aau.cs.d703e20.ast.structure.BlockNode;
import dk.aau.cs.d703e20.ast.structure.FunctionDeclarationNode;
import dk.aau.cs.d703e20.ast.structure.SetupNode;
import dk.aau.cs.d703e20.ast.structure.LoopNode;
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
        SetupNode setupNode = (SetupNode) visitSetup(ctx.setup());
        LoopNode loopNode = (LoopNode) visitLoop(ctx.loop());

        List<FunctionDeclarationNode> functionDeclarationNodes = visitList(FunctionDeclarationNode.class, ctx.functionDecl(), this::visitFunctionDecl);

        ProgramNode programNode = new ProgramNode(setupNode, loopNode, functionDeclarationNodes);
        setCodePos(programNode, ctx);
        return programNode;
    }

    @Override
    public ASTNode visitSetup(OurParser.SetupContext ctx) {
        BlockNode blockNode = (BlockNode) visitBlock(ctx.block());

        SetupNode setupNode = new SetupNode(blockNode);
        setCodePos(setupNode, ctx);
        return setupNode;
    }

    @Override
    public ASTNode visitLoop(OurParser.LoopContext ctx) {
        BlockNode blockNode = (BlockNode) visitBlock(ctx.block());

        LoopNode loopNode = new LoopNode(blockNode);
        setCodePos(loopNode, ctx);
        return loopNode;
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
        FunctionDeclarationNode functionDeclarationNode = null;
        BlockNode blockNode = (BlockNode) visitBlock(ctx.block());

        if (ctx.functionParam() != null) {
            FunctionParameterNode functionParameterNode = (FunctionParameterNode) visitFunctionParam(ctx.functionParam());
            if (ctx.VOID() != null) {
                functionDeclarationNode = new FunctionDeclarationNode(ctx.functionName().getText(), blockNode, functionParameterNode);
            }
            else if (ctx.dataType() != null) {
                functionDeclarationNode = new FunctionDeclarationNode(getDataType(ctx.dataType()), ctx.functionName().getText(), blockNode, functionParameterNode);
            }
        }
        else {
            if (ctx.VOID() != null) {
                functionDeclarationNode = new FunctionDeclarationNode(ctx.functionName().getText(), blockNode);
            }
            else if (ctx.dataType() != null) {
                functionDeclarationNode = new FunctionDeclarationNode(getDataType(ctx.dataType()), ctx.functionName().getText(), blockNode);
            }
            else {
                throw new CompilerException("Invalid Function Declaration", getCodePosition(ctx));
            }
        }
        setCodePos(functionDeclarationNode, ctx);
        return functionDeclarationNode;
    }

    @Override
    public ASTNode visitFunctionParam(OurParser.FunctionParamContext ctx) {
        List<Enums.DataType> dataTypes = new ArrayList<Enums.DataType>();
        List<String> variableNames = new ArrayList<String>();

        for (OurParser.DataTypeContext datatypeContext : ctx.dataType()) {
            dataTypes.add(getDataType(datatypeContext));
        }

        for (OurParser.VariableNameContext variableNameContext : ctx.variableName()) {
            variableNames.add(variableNameContext.getText());
        }

        FunctionParameterNode functionParameterNode = new FunctionParameterNode(dataTypes, variableNames);
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
        else if (ctx.returnStatement() != null)
            return visitReturnStatement(ctx.returnStatement());
        else
            throw new CompilerException("Invalid statement", getCodePosition(ctx));
    }

    @Override
    public ASTNode visitFunctionCall(OurParser.FunctionCallContext ctx) {
        FunctionCallNode functionCallNode;
        if (ctx.functionArgs() != null && !ctx.functionArgs().isEmpty())
            functionCallNode = new FunctionCallNode(ctx.functionName().getText(), (FunctionArgsNode) visitFunctionArgs(ctx.functionArgs()));
        else
            functionCallNode = new FunctionCallNode(ctx.functionName().getText());

        setCodePos(functionCallNode, ctx);
        return functionCallNode;
    }

    @Override
    public ASTNode visitFunctionArgs(OurParser.FunctionArgsContext ctx) {
        List<ArithExpressionNode> arithExpressionNodes = visitList(ArithExpressionNode.class, ctx.arithExpr(), this::visitArithExpr);

        List<BoolExpressionNode> boolExpressionNodes = visitList(BoolExpressionNode.class, ctx.boolExpr(), this::visitBoolExpr);

        FunctionArgsNode functionArgsNode = new FunctionArgsNode(arithExpressionNodes, boolExpressionNodes);
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
        ConditionalExpressionNode conditionalExpressionNode = (ConditionalExpressionNode) visitConditionalExpression(ctx.conditionalExpression());
        BlockNode blockNode = (BlockNode) visitBlock(ctx.block());

        IfStatementNode ifStatementNode = new IfStatementNode(conditionalExpressionNode, blockNode);
        setCodePos(ifStatementNode, ctx);
        return ifStatementNode;
    }

    @Override
    public ASTNode visitElseIfStatement(OurParser.ElseIfStatementContext ctx) {
        ConditionalExpressionNode conditionalExpressionNode = (ConditionalExpressionNode) visitConditionalExpression(ctx.conditionalExpression());
        BlockNode blockNode = (BlockNode) visitBlock(ctx.block());

        ElseIfStatementNode elseIfStatementNode = new ElseIfStatementNode(conditionalExpressionNode, blockNode);
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
        ArithExpressionNode arithExpressionNode1 = (ArithExpressionNode) visitArithExpr(ctx.arithExpr(0));
        ArithExpressionNode arithExpressionNode2 = (ArithExpressionNode) visitArithExpr(ctx.arithExpr(1));
        BlockNode blockNode = (BlockNode) visitBlock(ctx.block());

        ForStatementNode forStatementNode = new ForStatementNode(arithExpressionNode1, arithExpressionNode2, blockNode);
        setCodePos(forStatementNode, ctx);

        return forStatementNode;
    }

    @Override
    public ASTNode visitArithExpr(OurParser.ArithExprContext ctx) {
        ArithExpressionNode arithExpressionNode = null;

        if (ctx.arithExpr().size() > 0) {
            if (ctx.arithExpr(0) != null) {
                if (ctx.arithExpr(1) != null) {
                    // arithExpr arithOp arithExpr
                    ArithExpressionNode node1 = (ArithExpressionNode) visitArithExpr(ctx.arithExpr(0));
                    ArithExpressionNode node2 = (ArithExpressionNode) visitArithExpr(ctx.arithExpr(1));
                    arithExpressionNode = new ArithExpressionNode(node1, node2, getArithOperator(ctx.arithOp()));
                } else {
                    // NOT? (arithExpr)
                    ArithExpressionNode node = (ArithExpressionNode) visitArithExpr(ctx.arithExpr(0));
                    if (ctx.NOT() != null) {
                        arithExpressionNode = new ArithExpressionNode(node, Enums.BoolOperator.NOT);
                    } else {
                        arithExpressionNode = new ArithExpressionNode(node);
                    }
                }
            }
        } else if (ctx.functionCall() != null) {
            // FunctionCall
            FunctionCallNode funcNode = (FunctionCallNode) visitFunctionCall(ctx.functionCall());
            arithExpressionNode = new ArithExpressionNode(funcNode);
        } else if (ctx.numLiteral() != null) {
            arithExpressionNode = new ArithExpressionNode(getNumLiteralValue(ctx.numLiteral()));
        } else if (ctx.variableName() != null) {
            arithExpressionNode = new ArithExpressionNode(ctx.variableName().getText());
        } else {
            throw new CompilerException("Invalid Expression", getCodePosition(ctx));
        }

        setCodePos(arithExpressionNode, ctx);
        return arithExpressionNode;
    }

    @Override
    public ASTNode visitBoolExpr(OurParser.BoolExprContext ctx) {
        BoolExpressionNode boolExpressionNode;

        if (ctx.BOOL_LITERAL().size() > 0) {
            if (ctx.BOOL_LITERAL().size() > 1) {
                // LITERAL op LITERAL
                return new BoolExpressionNode(ctx.BOOL_LITERAL(0).getText(), ctx.BOOL_LITERAL(1).getText(), getBoolOperator(ctx.boolOp()));
            } else {
                if (ctx.arithExpr() != null && !ctx.arithExpr().isEmpty()) { // ctx.ArithExpr can be empty but not null list, fails when accessing the empty list
                    // arith op LITERAL | LITERAL op arith
                    // TODO: figure out order
                    ArithExpressionNode arithExpressionNode = (ArithExpressionNode) visitArithExpr(ctx.arithExpr(0));
                    boolExpressionNode = new BoolExpressionNode(arithExpressionNode, ctx.BOOL_LITERAL(0).getText(), getBoolOperator(ctx.boolOp()));
                    setCodePos(boolExpressionNode, ctx);
                    return boolExpressionNode;
                } else {
                    // only BOOL
                    boolExpressionNode = new BoolExpressionNode(ctx.BOOL_LITERAL(0).getText());
                    setCodePos(boolExpressionNode, ctx);
                    return boolExpressionNode;
                }
            }
        } else {
            if (ctx.arithExpr() != null && !ctx.arithExpr().isEmpty()) { // ctx.ArithExpr can be empty
                // arith op arith
                ArithExpressionNode arithExpressionNode1 = (ArithExpressionNode) visitArithExpr(ctx.arithExpr(0));
                ArithExpressionNode arithExpressionNode2 = (ArithExpressionNode) visitArithExpr(ctx.arithExpr(1));
                boolExpressionNode = new BoolExpressionNode(arithExpressionNode1, arithExpressionNode2, getBoolOperator(ctx.boolOp()));
                setCodePos(boolExpressionNode, ctx);
                return boolExpressionNode;
            } else if (ctx.boolExpr() != null) {
                // nested boolExpr
                if (ctx.NOT() != null) {
                    if (ctx.LEFT_PAREN() != null && ctx.RIGHT_PAREN() != null) {
                        BoolExpressionNode nestedBoolExpressionNode = (BoolExpressionNode) visitBoolExpr(ctx.boolExpr());
                        boolExpressionNode = new BoolExpressionNode(Enums.BoolOperator.NOT, nestedBoolExpressionNode);
                        setCodePos(boolExpressionNode, ctx);
                        return boolExpressionNode;
                    }
                }
                boolExpressionNode = (BoolExpressionNode) visitBoolExpr(ctx.boolExpr());
                setCodePos(boolExpressionNode, ctx);
                return boolExpressionNode;
            } else {
                throw new CompilerException("Invalid Boolean Expression", getCodePosition(ctx));
            }
        }
    }

    @Override
    public ASTNode visitVariableDecl(OurParser.VariableDeclContext ctx) {
        VariableDeclarationNode variableDeclarationNode;

        try {
            Enums.DataType dataType = getDataType(ctx.dataType());
            AssignmentNode assignmentNode = (AssignmentNode) visitAssignment(ctx.assignment());
            variableDeclarationNode = new VariableDeclarationNode(dataType, assignmentNode);
        } catch (CompilerException e) {
            throw new CompilerException("Invalid Variable Declaration Statement", getCodePosition(ctx));
        }

        setCodePos(variableDeclarationNode, ctx);
        return variableDeclarationNode;
    }

    @Override
    public ASTNode visitAssignment(OurParser.AssignmentContext ctx) {
        if (ctx.literal() != null) {
            // Check the kind of literal
            if (ctx.literal().BOOL_LITERAL() != null) {
                AssignmentNode assignmentNode = new AssignmentNode(ctx.variableName().getText(), ctx.literal().getText());
                setCodePos(assignmentNode, ctx);
                return assignmentNode;
            }
            else {
                // if String_Literal then remove "" from string value
                AssignmentNode assignmentNode = new AssignmentNode(ctx.variableName().getText(), getStringLiteral(ctx.literal()));
                setCodePos(assignmentNode, ctx);
                return assignmentNode;
            }
        } else if (ctx.arithExpr() != null) {
            ArithExpressionNode arithExpressionNode = (ArithExpressionNode) visitArithExpr(ctx.arithExpr());
            AssignmentNode assignmentNode = new AssignmentNode(ctx.variableName().getText(), arithExpressionNode);
            setCodePos(assignmentNode, ctx);
            return assignmentNode;
        }
        /*
        else if (ctx.functionCall() != null) {
            FunctionCallNode functionCallNode = (FunctionCallNode) visitFunctionCall(ctx.functionCall());
            AssignmentNode assignmentNode = new AssignmentNode(ctx.variableName().getText(), functionCallNode);
            setCodePos(assignmentNode, ctx);
            return assignmentNode;
        } */
        else {
            throw new CompilerException("Invalid Assignment Statement", getCodePosition(ctx));
        }
    }

    @Override
    public ASTNode visitReturnStatement(OurParser.ReturnStatementContext ctx) {
        ReturnStatementNode returnStatementNode = new ReturnStatementNode(ctx.variableName().getText());
        setCodePos(returnStatementNode, ctx);
        return returnStatementNode;
    }

    @Override
    public ASTNode visitAtStatement(OurParser.AtStatementContext ctx) {
        try {
            ArithExpressionNode arithExpressionNode = (ArithExpressionNode) visitArithExpr(ctx.arithExpr());
            BlockNode blockNode = (BlockNode) visitBlock(ctx.block());
            AtStatementNode atStatementNode = new AtStatementNode(ctx.variableName().getText(), arithExpressionNode, getBoolOperator(ctx.boolOp()), blockNode);
            setCodePos(atStatementNode, ctx);
            return atStatementNode;
        } catch (CompilerException e) {
            throw new CompilerException("Invalid At Statement", getCodePosition(ctx));
        }
    }

    private Enums.DataType getDataType(OurParser.DataTypeContext ctx) {
        Enums.DataType dataType;

        if (ctx.INT() != null)
            dataType = Enums.DataType.INT;
        else if (ctx.BOOLEAN() != null)
            dataType = Enums.DataType.BOOL;
        else if (ctx.CLOCK() != null)
            dataType = Enums.DataType.CLOCK;
        else if (ctx.STRING() != null)
            dataType = Enums.DataType.STRING;
        else
            throw new CompilerException("DataType is unknown", getCodePosition(ctx));

        return dataType;
    }

    private Enums.ArithOperator getArithOperator(OurParser.ArithOpContext ctx) {
        Enums.ArithOperator operator;

        if (ctx.ADD() != null) {
            operator = Enums.ArithOperator.ADD;
        } else if (ctx.SUB() != null) {
            operator = Enums.ArithOperator.SUB;
        } else if (ctx.MOD() != null) {
            operator = Enums.ArithOperator.MOD;
        } else if (ctx.DIV() != null) {
            operator = Enums.ArithOperator.DIV;
        } else if (ctx.MUL() != null) {
            operator = Enums.ArithOperator.MUL;
        } else {
            throw new CompilerException("Operator is unknown", getCodePosition(ctx));
        }
        return operator;
    }

    private Enums.BoolOperator getBoolOperator(OurParser.BoolOpContext ctx) {
        Enums.BoolOperator operator;

        if (ctx.EQUAL() != null) {
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

        return operator;
    }

    private String getStringLiteral(OurParser.LiteralContext ctx) {
        if (ctx.STRING_LITERAL() != null) {
            // Remove "" from both ends of the string
            return ctx.STRING_LITERAL().getText().subSequence(1, ctx.STRING_LITERAL().getText().length()-1).toString();
        }
        else
            throw new CompilerException("Bool is not String");
    }

    private Double getNumLiteralValue(OurParser.NumLiteralContext ctx) {
        return Double.valueOf(ctx.getText());
    }

    // Creates a list of T (ASTNodes), then visits all contexts in S using func
    // All the results from visiting are added to the list which gets returned.
    // Usage example:
    // List<StatementNode> statementNodes = visitList(StatementNode.class, ctx.statement(), this::visitStatement);
    private <T, S> List<T> visitList(Class<T> tClass, List<S> ctxs, Function<S, ASTNode> func) {
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
