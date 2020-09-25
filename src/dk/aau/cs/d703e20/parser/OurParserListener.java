// Generated from C:/Users/htmle/Documents/GitHub/P7/src\OurParser.g4 by ANTLR 4.8
package dk.aau.cs.d703e20.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OurParser}.
 */
public interface OurParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link OurParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(OurParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(OurParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(OurParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(OurParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(OurParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(OurParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(OurParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(OurParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#functionParam}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParam(OurParser.FunctionParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#functionParam}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParam(OurParser.FunctionParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(OurParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(OurParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#functionArgs}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArgs(OurParser.FunctionArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#functionArgs}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArgs(OurParser.FunctionArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(OurParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(OurParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStatement(OurParser.IfElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStatement(OurParser.IfElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(OurParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(OurParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStatement(OurParser.ElseIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStatement(OurParser.ElseIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(OurParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(OurParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(OurParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(OurParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#iterativeStatement}.
	 * @param ctx the parse tree
	 */
	void enterIterativeStatement(OurParser.IterativeStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#iterativeStatement}.
	 * @param ctx the parse tree
	 */
	void exitIterativeStatement(OurParser.IterativeStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(OurParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(OurParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(OurParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(OurParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(OurParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(OurParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void enterVariableDecl(OurParser.VariableDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void exitVariableDecl(OurParser.VariableDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(OurParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(OurParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#variableName}.
	 * @param ctx the parse tree
	 */
	void enterVariableName(OurParser.VariableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#variableName}.
	 * @param ctx the parse tree
	 */
	void exitVariableName(OurParser.VariableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(OurParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(OurParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#datatype}.
	 * @param ctx the parse tree
	 */
	void enterDatatype(OurParser.DatatypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#datatype}.
	 * @param ctx the parse tree
	 */
	void exitDatatype(OurParser.DatatypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(OurParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(OurParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#numLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumLiteral(OurParser.NumLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#numLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumLiteral(OurParser.NumLiteralContext ctx);
}