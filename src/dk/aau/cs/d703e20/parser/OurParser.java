// Generated from C:/Users/htmle/Documents/GitHub/P7/src\OurParser.g4 by ANTLR 4.8
package dk.aau.cs.d703e20.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OurParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, BOOLEAN=2, DOUBLE=3, CLOCK=4, STRING=5, PIT=6, VOID=7, MAIN=8, 
		RETURN=9, IF=10, ELSE_IF=11, ELSE=12, TO=13, FOR=14, AT=15, DIGIT=16, 
		DIGIT_NEGATIVE=17, DOUBLE_DIGIT=18, DOUBLE_DIGIT_NEGATIVE=19, BOOL_LITERAL=20, 
		STRING_LITERAL=21, LEFT_BRACKET=22, RIGHT_BRACKET=23, LEFT_PAREN=24, RIGHT_PAREN=25, 
		DOT=26, COMMA=27, SEMICOLON=28, QUESTION=29, COLON=30, ASSIGN=31, ADD=32, 
		SUB=33, MOD=34, DIV=35, MUL=36, EQUAL=37, AND=38, OR=39, NOT_EQUAL=40, 
		NOT=41, GREATER_THAN=42, GREATER_OR_EQUAL=43, LESS_THAN=44, LESS_OR_EQUAL=45, 
		ID=46, COMMENT_STRING=47, COMMENT_BLOCK=48, WS=49;
	public static final int
		RULE_program = 0, RULE_main = 1, RULE_block = 2, RULE_functionDecl = 3, 
		RULE_functionParam = 4, RULE_functionCall = 5, RULE_statement = 6, RULE_ifElseStatement = 7, 
		RULE_ifStatement = 8, RULE_elseIfStatement = 9, RULE_elseStatement = 10, 
		RULE_conditionalExpression = 11, RULE_iterativeStatement = 12, RULE_forStatement = 13, 
		RULE_expr = 14, RULE_boolExpr = 15, RULE_boolSymbol = 16, RULE_variableDecl = 17, 
		RULE_assignment = 18, RULE_variableName = 19, RULE_functionName = 20, 
		RULE_datatype = 21, RULE_literal = 22, RULE_numLiteral = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "block", "functionDecl", "functionParam", "functionCall", 
			"statement", "ifElseStatement", "ifStatement", "elseIfStatement", "elseStatement", 
			"conditionalExpression", "iterativeStatement", "forStatement", "expr", 
			"boolExpr", "boolSymbol", "variableDecl", "assignment", "variableName", 
			"functionName", "datatype", "literal", "numLiteral"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'bool'", "'double'", "'clock'", "'string'", "'pit'", 
			"'void'", "'Main'", "'return'", "'if'", "'else if'", "'else'", "'to'", 
			"'for'", "'at'", null, null, null, null, null, null, "'{'", "'}'", "'('", 
			"')'", "'.'", "','", "';'", "'?'", "':'", "'='", "'+'", "'-'", "'%'", 
			"'/'", "'*'", "'=='", "'&&'", "'||'", "'!='", "'!'", "'>'", "'>='", "'<'", 
			"'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "BOOLEAN", "DOUBLE", "CLOCK", "STRING", "PIT", "VOID", "MAIN", 
			"RETURN", "IF", "ELSE_IF", "ELSE", "TO", "FOR", "AT", "DIGIT", "DIGIT_NEGATIVE", 
			"DOUBLE_DIGIT", "DOUBLE_DIGIT_NEGATIVE", "BOOL_LITERAL", "STRING_LITERAL", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", "DOT", 
			"COMMA", "SEMICOLON", "QUESTION", "COLON", "ASSIGN", "ADD", "SUB", "MOD", 
			"DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", "NOT", "GREATER_THAN", 
			"GREATER_OR_EQUAL", "LESS_THAN", "LESS_OR_EQUAL", "ID", "COMMENT_STRING", 
			"COMMENT_BLOCK", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "OurParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public OurParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<VariableNameContext> variableName() {
			return getRuleContexts(VariableNameContext.class);
		}
		public VariableNameContext variableName(int i) {
			return getRuleContext(VariableNameContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			main();
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOLEAN) | (1L << DOUBLE) | (1L << CLOCK) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(51);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT:
				case BOOLEAN:
				case DOUBLE:
				case CLOCK:
				case VOID:
					{
					setState(49);
					functionDecl();
					}
					break;
				case ID:
					{
					setState(50);
					variableName();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainContext extends ParserRuleContext {
		public TerminalNode MAIN() { return getToken(OurParser.MAIN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(MAIN);
			setState(57);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACKET() { return getToken(OurParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(OurParser.RIGHT_BRACKET, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(LEFT_BRACKET);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOLEAN) | (1L << DOUBLE) | (1L << CLOCK) | (1L << IF) | (1L << FOR) | (1L << ID))) != 0)) {
				{
				{
				setState(60);
				statement();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
			match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclContext extends ParserRuleContext {
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(OurParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(OurParser.RIGHT_PAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode VOID() { return getToken(OurParser.VOID, 0); }
		public DatatypeContext datatype() {
			return getRuleContext(DatatypeContext.class,0);
		}
		public List<FunctionParamContext> functionParam() {
			return getRuleContexts(FunctionParamContext.class);
		}
		public FunctionParamContext functionParam(int i) {
			return getRuleContext(FunctionParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OurParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OurParser.COMMA, i);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitFunctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				{
				setState(68);
				match(VOID);
				}
				break;
			case INT:
			case BOOLEAN:
			case DOUBLE:
			case CLOCK:
				{
				setState(69);
				datatype();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(72);
			functionName();
			setState(73);
			match(LEFT_PAREN);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOLEAN) | (1L << DOUBLE) | (1L << CLOCK))) != 0)) {
				{
				setState(74);
				functionParam();
				}
			}

			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(77);
				match(COMMA);
				setState(78);
				functionParam();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			match(RIGHT_PAREN);
			setState(85);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionParamContext extends ParserRuleContext {
		public DatatypeContext datatype() {
			return getRuleContext(DatatypeContext.class,0);
		}
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public FunctionParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterFunctionParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitFunctionParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitFunctionParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionParamContext functionParam() throws RecognitionException {
		FunctionParamContext _localctx = new FunctionParamContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			datatype();
			setState(88);
			variableName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(OurParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(OurParser.RIGHT_PAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(OurParser.SEMICOLON, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OurParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OurParser.COMMA, i);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			functionName();
			setState(91);
			match(LEFT_PAREN);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGIT) | (1L << DIGIT_NEGATIVE) | (1L << DOUBLE_DIGIT) | (1L << DOUBLE_DIGIT_NEGATIVE) | (1L << LEFT_PAREN) | (1L << ID))) != 0)) {
				{
				setState(92);
				expr(0);
				}
			}

			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(95);
				match(COMMA);
				setState(96);
				expr(0);
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			match(RIGHT_PAREN);
			setState(103);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public VariableDeclContext variableDecl() {
			return getRuleContext(VariableDeclContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public IfElseStatementContext ifElseStatement() {
			return getRuleContext(IfElseStatementContext.class,0);
		}
		public IterativeStatementContext iterativeStatement() {
			return getRuleContext(IterativeStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				variableDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
				functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(108);
				ifElseStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(109);
				iterativeStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfElseStatementContext extends ParserRuleContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public List<ElseIfStatementContext> elseIfStatement() {
			return getRuleContexts(ElseIfStatementContext.class);
		}
		public ElseIfStatementContext elseIfStatement(int i) {
			return getRuleContext(ElseIfStatementContext.class,i);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterIfElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitIfElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitIfElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfElseStatementContext ifElseStatement() throws RecognitionException {
		IfElseStatementContext _localctx = new IfElseStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ifElseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			ifStatement();
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSE_IF) {
				{
				{
				setState(113);
				elseIfStatement();
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(119);
				elseStatement();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(OurParser.IF, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(OurParser.LEFT_PAREN, 0); }
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(OurParser.RIGHT_PAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(IF);
			setState(123);
			match(LEFT_PAREN);
			setState(124);
			conditionalExpression();
			setState(125);
			match(RIGHT_PAREN);
			setState(126);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseIfStatementContext extends ParserRuleContext {
		public TerminalNode ELSE_IF() { return getToken(OurParser.ELSE_IF, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(OurParser.LEFT_PAREN, 0); }
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(OurParser.RIGHT_PAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseIfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterElseIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitElseIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitElseIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIfStatementContext elseIfStatement() throws RecognitionException {
		ElseIfStatementContext _localctx = new ElseIfStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_elseIfStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(ELSE_IF);
			setState(129);
			match(LEFT_PAREN);
			setState(130);
			conditionalExpression();
			setState(131);
			match(RIGHT_PAREN);
			setState(132);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseStatementContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(OurParser.ELSE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(ELSE);
			setState(135);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalExpressionContext extends ParserRuleContext {
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public TerminalNode NOT() { return getToken(OurParser.NOT, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ConditionalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterConditionalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitConditionalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitConditionalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalExpressionContext conditionalExpression() throws RecognitionException {
		ConditionalExpressionContext _localctx = new ConditionalExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_conditionalExpression);
		int _la;
		try {
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				boolExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(138);
					match(NOT);
					}
				}

				setState(141);
				variableName();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				functionCall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IterativeStatementContext extends ParserRuleContext {
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public IterativeStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterativeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterIterativeStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitIterativeStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitIterativeStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterativeStatementContext iterativeStatement() throws RecognitionException {
		IterativeStatementContext _localctx = new IterativeStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_iterativeStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			forStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(OurParser.FOR, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(OurParser.LEFT_PAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode TO() { return getToken(OurParser.TO, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(OurParser.RIGHT_PAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(FOR);
			setState(148);
			match(LEFT_PAREN);
			setState(149);
			expr(0);
			setState(150);
			match(TO);
			setState(151);
			expr(0);
			setState(152);
			match(RIGHT_PAREN);
			setState(153);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Token op;
		public NumLiteralContext numLiteral() {
			return getRuleContext(NumLiteralContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(OurParser.LEFT_PAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(OurParser.RIGHT_PAREN, 0); }
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public TerminalNode ADD() { return getToken(OurParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(OurParser.SUB, 0); }
		public TerminalNode MOD() { return getToken(OurParser.MOD, 0); }
		public TerminalNode DIV() { return getToken(OurParser.DIV, 0); }
		public TerminalNode MUL() { return getToken(OurParser.MUL, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
			case DIGIT_NEGATIVE:
			case DOUBLE_DIGIT:
			case DOUBLE_DIGIT_NEGATIVE:
				{
				setState(156);
				numLiteral();
				}
				break;
			case LEFT_PAREN:
				{
				setState(157);
				match(LEFT_PAREN);
				setState(158);
				expr(0);
				setState(159);
				match(RIGHT_PAREN);
				}
				break;
			case ID:
				{
				setState(161);
				variableName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(164);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(165);
					((ExprContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MOD) | (1L << DIV) | (1L << MUL))) != 0)) ) {
						((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(166);
					expr(5);
					}
					} 
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BoolExprContext extends ParserRuleContext {
		public Token op;
		public BoolSymbolContext boolSymbol() {
			return getRuleContext(BoolSymbolContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> BOOL_LITERAL() { return getTokens(OurParser.BOOL_LITERAL); }
		public TerminalNode BOOL_LITERAL(int i) {
			return getToken(OurParser.BOOL_LITERAL, i);
		}
		public TerminalNode EQUAL() { return getToken(OurParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(OurParser.NOT_EQUAL, 0); }
		public TerminalNode GREATER_THAN() { return getToken(OurParser.GREATER_THAN, 0); }
		public TerminalNode GREATER_OR_EQUAL() { return getToken(OurParser.GREATER_OR_EQUAL, 0); }
		public TerminalNode LESS_THAN() { return getToken(OurParser.LESS_THAN, 0); }
		public TerminalNode LESS_OR_EQUAL() { return getToken(OurParser.LESS_OR_EQUAL, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(OurParser.LEFT_PAREN, 0); }
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(OurParser.RIGHT_PAREN, 0); }
		public BoolExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolExprContext boolExpr() throws RecognitionException {
		BoolExprContext _localctx = new BoolExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_boolExpr);
		int _la;
		try {
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				boolSymbol();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(176);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DIGIT:
				case DIGIT_NEGATIVE:
				case DOUBLE_DIGIT:
				case DOUBLE_DIGIT_NEGATIVE:
				case LEFT_PAREN:
				case ID:
					{
					setState(174);
					expr(0);
					}
					break;
				case BOOL_LITERAL:
					{
					setState(175);
					match(BOOL_LITERAL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(178);
				((BoolExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << NOT_EQUAL) | (1L << GREATER_THAN) | (1L << GREATER_OR_EQUAL) | (1L << LESS_THAN) | (1L << LESS_OR_EQUAL))) != 0)) ) {
					((BoolExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(181);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL_LITERAL:
					{
					setState(179);
					match(BOOL_LITERAL);
					}
					break;
				case DIGIT:
				case DIGIT_NEGATIVE:
				case DOUBLE_DIGIT:
				case DOUBLE_DIGIT_NEGATIVE:
				case LEFT_PAREN:
				case ID:
					{
					setState(180);
					expr(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(183);
				match(LEFT_PAREN);
				setState(184);
				boolExpr();
				setState(185);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolSymbolContext extends ParserRuleContext {
		public TerminalNode BOOL_LITERAL() { return getToken(OurParser.BOOL_LITERAL, 0); }
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public BoolSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterBoolSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitBoolSymbol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitBoolSymbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolSymbolContext boolSymbol() throws RecognitionException {
		BoolSymbolContext _localctx = new BoolSymbolContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_boolSymbol);
		try {
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				match(BOOL_LITERAL);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				variableName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclContext extends ParserRuleContext {
		public DatatypeContext datatype() {
			return getRuleContext(DatatypeContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public VariableDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterVariableDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitVariableDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitVariableDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclContext variableDecl() throws RecognitionException {
		VariableDeclContext _localctx = new VariableDeclContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_variableDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			datatype();
			setState(194);
			assignment();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(OurParser.ASSIGN, 0); }
		public TerminalNode SEMICOLON() { return getToken(OurParser.SEMICOLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			variableName();
			setState(197);
			match(ASSIGN);
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
			case DIGIT_NEGATIVE:
			case DOUBLE_DIGIT:
			case DOUBLE_DIGIT_NEGATIVE:
			case LEFT_PAREN:
			case ID:
				{
				setState(198);
				expr(0);
				}
				break;
			case BOOL_LITERAL:
			case STRING_LITERAL:
				{
				setState(199);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(202);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(OurParser.ID, 0); }
		public VariableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterVariableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitVariableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitVariableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableNameContext variableName() throws RecognitionException {
		VariableNameContext _localctx = new VariableNameContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_variableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(OurParser.ID, 0); }
		public FunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterFunctionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitFunctionName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitFunctionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionNameContext functionName() throws RecognitionException {
		FunctionNameContext _localctx = new FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatatypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(OurParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(OurParser.DOUBLE, 0); }
		public TerminalNode BOOLEAN() { return getToken(OurParser.BOOLEAN, 0); }
		public TerminalNode CLOCK() { return getToken(OurParser.CLOCK, 0); }
		public DatatypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterDatatype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitDatatype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitDatatype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatatypeContext datatype() throws RecognitionException {
		DatatypeContext _localctx = new DatatypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_datatype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOLEAN) | (1L << DOUBLE) | (1L << CLOCK))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(OurParser.STRING_LITERAL, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(OurParser.BOOL_LITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			_la = _input.LA(1);
			if ( !(_la==BOOL_LITERAL || _la==STRING_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumLiteralContext extends ParserRuleContext {
		public TerminalNode DIGIT() { return getToken(OurParser.DIGIT, 0); }
		public TerminalNode DIGIT_NEGATIVE() { return getToken(OurParser.DIGIT_NEGATIVE, 0); }
		public TerminalNode DOUBLE_DIGIT() { return getToken(OurParser.DOUBLE_DIGIT, 0); }
		public TerminalNode DOUBLE_DIGIT_NEGATIVE() { return getToken(OurParser.DOUBLE_DIGIT_NEGATIVE, 0); }
		public NumLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterNumLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitNumLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitNumLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumLiteralContext numLiteral() throws RecognitionException {
		NumLiteralContext _localctx = new NumLiteralContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_numLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGIT) | (1L << DIGIT_NEGATIVE) | (1L << DOUBLE_DIGIT) | (1L << DOUBLE_DIGIT_NEGATIVE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\63\u00d9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\2\7\2\66\n\2\f\2\16\29\13\2\3\3\3\3\3\3\3\4\3\4\7\4@\n\4\f"+
		"\4\16\4C\13\4\3\4\3\4\3\5\3\5\5\5I\n\5\3\5\3\5\3\5\5\5N\n\5\3\5\3\5\7"+
		"\5R\n\5\f\5\16\5U\13\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\5\7`\n\7\3"+
		"\7\3\7\7\7d\n\7\f\7\16\7g\13\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\bq\n"+
		"\b\3\t\3\t\7\tu\n\t\f\t\16\tx\13\t\3\t\5\t{\n\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\5\r\u008e\n\r\3\r"+
		"\3\r\5\r\u0092\n\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00a5\n\20\3\20\3\20\3\20\7\20"+
		"\u00aa\n\20\f\20\16\20\u00ad\13\20\3\21\3\21\3\21\3\21\5\21\u00b3\n\21"+
		"\3\21\3\21\3\21\5\21\u00b8\n\21\3\21\3\21\3\21\3\21\5\21\u00be\n\21\3"+
		"\22\3\22\5\22\u00c2\n\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u00cb"+
		"\n\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31"+
		"\2\3\36\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\2\7\3\2"+
		"\"&\5\2\'\'**,/\3\2\3\6\3\2\26\27\3\2\22\25\2\u00db\2\62\3\2\2\2\4:\3"+
		"\2\2\2\6=\3\2\2\2\bH\3\2\2\2\nY\3\2\2\2\f\\\3\2\2\2\16p\3\2\2\2\20r\3"+
		"\2\2\2\22|\3\2\2\2\24\u0082\3\2\2\2\26\u0088\3\2\2\2\30\u0091\3\2\2\2"+
		"\32\u0093\3\2\2\2\34\u0095\3\2\2\2\36\u00a4\3\2\2\2 \u00bd\3\2\2\2\"\u00c1"+
		"\3\2\2\2$\u00c3\3\2\2\2&\u00c6\3\2\2\2(\u00ce\3\2\2\2*\u00d0\3\2\2\2,"+
		"\u00d2\3\2\2\2.\u00d4\3\2\2\2\60\u00d6\3\2\2\2\62\67\5\4\3\2\63\66\5\b"+
		"\5\2\64\66\5(\25\2\65\63\3\2\2\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2"+
		"\2\678\3\2\2\28\3\3\2\2\29\67\3\2\2\2:;\7\n\2\2;<\5\6\4\2<\5\3\2\2\2="+
		"A\7\30\2\2>@\5\16\b\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2"+
		"\2CA\3\2\2\2DE\7\31\2\2E\7\3\2\2\2FI\7\t\2\2GI\5,\27\2HF\3\2\2\2HG\3\2"+
		"\2\2IJ\3\2\2\2JK\5*\26\2KM\7\32\2\2LN\5\n\6\2ML\3\2\2\2MN\3\2\2\2NS\3"+
		"\2\2\2OP\7\35\2\2PR\5\n\6\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TV"+
		"\3\2\2\2US\3\2\2\2VW\7\33\2\2WX\5\6\4\2X\t\3\2\2\2YZ\5,\27\2Z[\5(\25\2"+
		"[\13\3\2\2\2\\]\5*\26\2]_\7\32\2\2^`\5\36\20\2_^\3\2\2\2_`\3\2\2\2`e\3"+
		"\2\2\2ab\7\35\2\2bd\5\36\20\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2"+
		"fh\3\2\2\2ge\3\2\2\2hi\7\33\2\2ij\7\36\2\2j\r\3\2\2\2kq\5$\23\2lq\5&\24"+
		"\2mq\5\f\7\2nq\5\20\t\2oq\5\32\16\2pk\3\2\2\2pl\3\2\2\2pm\3\2\2\2pn\3"+
		"\2\2\2po\3\2\2\2q\17\3\2\2\2rv\5\22\n\2su\5\24\13\2ts\3\2\2\2ux\3\2\2"+
		"\2vt\3\2\2\2vw\3\2\2\2wz\3\2\2\2xv\3\2\2\2y{\5\26\f\2zy\3\2\2\2z{\3\2"+
		"\2\2{\21\3\2\2\2|}\7\f\2\2}~\7\32\2\2~\177\5\30\r\2\177\u0080\7\33\2\2"+
		"\u0080\u0081\5\6\4\2\u0081\23\3\2\2\2\u0082\u0083\7\r\2\2\u0083\u0084"+
		"\7\32\2\2\u0084\u0085\5\30\r\2\u0085\u0086\7\33\2\2\u0086\u0087\5\6\4"+
		"\2\u0087\25\3\2\2\2\u0088\u0089\7\16\2\2\u0089\u008a\5\6\4\2\u008a\27"+
		"\3\2\2\2\u008b\u0092\5 \21\2\u008c\u008e\7+\2\2\u008d\u008c\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0092\5(\25\2\u0090\u0092\5\f"+
		"\7\2\u0091\u008b\3\2\2\2\u0091\u008d\3\2\2\2\u0091\u0090\3\2\2\2\u0092"+
		"\31\3\2\2\2\u0093\u0094\5\34\17\2\u0094\33\3\2\2\2\u0095\u0096\7\20\2"+
		"\2\u0096\u0097\7\32\2\2\u0097\u0098\5\36\20\2\u0098\u0099\7\17\2\2\u0099"+
		"\u009a\5\36\20\2\u009a\u009b\7\33\2\2\u009b\u009c\5\6\4\2\u009c\35\3\2"+
		"\2\2\u009d\u009e\b\20\1\2\u009e\u00a5\5\60\31\2\u009f\u00a0\7\32\2\2\u00a0"+
		"\u00a1\5\36\20\2\u00a1\u00a2\7\33\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a5"+
		"\5(\25\2\u00a4\u009d\3\2\2\2\u00a4\u009f\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5"+
		"\u00ab\3\2\2\2\u00a6\u00a7\f\6\2\2\u00a7\u00a8\t\2\2\2\u00a8\u00aa\5\36"+
		"\20\7\u00a9\u00a6\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab"+
		"\u00ac\3\2\2\2\u00ac\37\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00be\5\"\22"+
		"\2\u00af\u00be\3\2\2\2\u00b0\u00b3\5\36\20\2\u00b1\u00b3\7\26\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b7\t\3"+
		"\2\2\u00b5\u00b8\7\26\2\2\u00b6\u00b8\5\36\20\2\u00b7\u00b5\3\2\2\2\u00b7"+
		"\u00b6\3\2\2\2\u00b8\u00be\3\2\2\2\u00b9\u00ba\7\32\2\2\u00ba\u00bb\5"+
		" \21\2\u00bb\u00bc\7\33\2\2\u00bc\u00be\3\2\2\2\u00bd\u00ae\3\2\2\2\u00bd"+
		"\u00af\3\2\2\2\u00bd\u00b2\3\2\2\2\u00bd\u00b9\3\2\2\2\u00be!\3\2\2\2"+
		"\u00bf\u00c2\7\26\2\2\u00c0\u00c2\5(\25\2\u00c1\u00bf\3\2\2\2\u00c1\u00c0"+
		"\3\2\2\2\u00c2#\3\2\2\2\u00c3\u00c4\5,\27\2\u00c4\u00c5\5&\24\2\u00c5"+
		"%\3\2\2\2\u00c6\u00c7\5(\25\2\u00c7\u00ca\7!\2\2\u00c8\u00cb\5\36\20\2"+
		"\u00c9\u00cb\5.\30\2\u00ca\u00c8\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00cc"+
		"\3\2\2\2\u00cc\u00cd\7\36\2\2\u00cd\'\3\2\2\2\u00ce\u00cf\7\60\2\2\u00cf"+
		")\3\2\2\2\u00d0\u00d1\7\60\2\2\u00d1+\3\2\2\2\u00d2\u00d3\t\4\2\2\u00d3"+
		"-\3\2\2\2\u00d4\u00d5\t\5\2\2\u00d5/\3\2\2\2\u00d6\u00d7\t\6\2\2\u00d7"+
		"\61\3\2\2\2\26\65\67AHMS_epvz\u008d\u0091\u00a4\u00ab\u00b2\u00b7\u00bd"+
		"\u00c1\u00ca";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}