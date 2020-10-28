// Generated from D:/GitHub/P7/src\OurParser.g4 by ANTLR 4.8
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
	 * Enter a parse tree produced by {@link OurParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(OurParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(OurParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#setup}.
	 * @param ctx the parse tree
	 */
	void enterSetup(OurParser.SetupContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#setup}.
	 * @param ctx the parse tree
	 */
	void exitSetup(OurParser.SetupContext ctx);
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
	 * Enter a parse tree produced by {@link OurParser#functionArg}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArg(OurParser.FunctionArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#functionArg}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArg(OurParser.FunctionArgContext ctx);
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
	 * Enter a parse tree produced by {@link OurParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(OurParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(OurParser.ReturnStatementContext ctx);
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
	 * Enter a parse tree produced by {@link OurParser#atStatement}.
	 * @param ctx the parse tree
	 */
	void enterAtStatement(OurParser.AtStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#atStatement}.
	 * @param ctx the parse tree
	 */
	void exitAtStatement(OurParser.AtStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#atParams}.
	 * @param ctx the parse tree
	 */
	void enterAtParams(OurParser.AtParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#atParams}.
	 * @param ctx the parse tree
	 */
	void exitAtParams(OurParser.AtParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#boundStatement}.
	 * @param ctx the parse tree
	 */
	void enterBoundStatement(OurParser.BoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#boundStatement}.
	 * @param ctx the parse tree
	 */
	void exitBoundStatement(OurParser.BoundStatementContext ctx);
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
	 * Enter a parse tree produced by {@link OurParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(OurParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(OurParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#arithExpr}.
	 * @param ctx the parse tree
	 */
	void enterArithExpr(OurParser.ArithExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#arithExpr}.
	 * @param ctx the parse tree
	 */
	void exitArithExpr(OurParser.ArithExprContext ctx);
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
	 * Enter a parse tree produced by {@link OurParser#boolExprOperand}.
	 * @param ctx the parse tree
	 */
	void enterBoolExprOperand(OurParser.BoolExprOperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#boolExprOperand}.
	 * @param ctx the parse tree
	 */
	void exitBoolExprOperand(OurParser.BoolExprOperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#pinDecl}.
	 * @param ctx the parse tree
	 */
	void enterPinDecl(OurParser.PinDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#pinDecl}.
	 * @param ctx the parse tree
	 */
	void exitPinDecl(OurParser.PinDeclContext ctx);
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
	 * Enter a parse tree produced by {@link OurParser#assignArray}.
	 * @param ctx the parse tree
	 */
	void enterAssignArray(OurParser.AssignArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#assignArray}.
	 * @param ctx the parse tree
	 */
	void exitAssignArray(OurParser.AssignArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#arrayParam}.
	 * @param ctx the parse tree
	 */
	void enterArrayParam(OurParser.ArrayParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#arrayParam}.
	 * @param ctx the parse tree
	 */
	void exitArrayParam(OurParser.ArrayParamContext ctx);
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
	 * Enter a parse tree produced by {@link OurParser#pinType}.
	 * @param ctx the parse tree
	 */
	void enterPinType(OurParser.PinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#pinType}.
	 * @param ctx the parse tree
	 */
	void exitPinType(OurParser.PinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(OurParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(OurParser.DataTypeContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link OurParser#arithOp}.
	 * @param ctx the parse tree
	 */
	void enterArithOp(OurParser.ArithOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#arithOp}.
	 * @param ctx the parse tree
	 */
	void exitArithOp(OurParser.ArithOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void enterBoolOp(OurParser.BoolOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void exitBoolOp(OurParser.BoolOpContext ctx);
}