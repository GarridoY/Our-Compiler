// Generated from /Users/ruofanwu/Projects/P7/src/OurParser.g4 by ANTLR 4.8
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
		RULE_functionParam = 4, RULE_functionCall = 5, RULE_functionArgs = 6, 
		RULE_statement = 7, RULE_returnStatement = 8, RULE_ifElseStatement = 9, 
		RULE_ifStatement = 10, RULE_elseIfStatement = 11, RULE_elseStatement = 12, 
		RULE_conditionalExpression = 13, RULE_atStatement = 14, RULE_iterativeStatement = 15, 
		RULE_forStatement = 16, RULE_expr = 17, RULE_boolExpr = 18, RULE_variableDecl = 19, 
		RULE_assignment = 20, RULE_variableName = 21, RULE_functionName = 22, 
		RULE_datatype = 23, RULE_literal = 24, RULE_numLiteral = 25, RULE_arit_op = 26, 
		RULE_bool_op = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "block", "functionDecl", "functionParam", "functionCall", 
			"functionArgs", "statement", "returnStatement", "ifElseStatement", "ifStatement", 
			"elseIfStatement", "elseStatement", "conditionalExpression", "atStatement", 
			"iterativeStatement", "forStatement", "expr", "boolExpr", "variableDecl", 
			"assignment", "variableName", "functionName", "datatype", "literal", 
			"numLiteral", "arit_op", "bool_op"
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
			setState(56);
			main();
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOLEAN) | (1L << DOUBLE) | (1L << CLOCK) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(59);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT:
				case BOOLEAN:
				case DOUBLE:
				case CLOCK:
				case VOID:
					{
					setState(57);
					functionDecl();
					}
					break;
				case ID:
					{
					setState(58);
					variableName();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(63);
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
			setState(64);
			match(MAIN);
			setState(65);
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
			setState(67);
			match(LEFT_BRACKET);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOLEAN) | (1L << DOUBLE) | (1L << CLOCK) | (1L << RETURN) | (1L << IF) | (1L << FOR) | (1L << AT) | (1L << ID))) != 0)) {
				{
				{
				setState(68);
				statement();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
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
		public FunctionParamContext functionParam() {
			return getRuleContext(FunctionParamContext.class,0);
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
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				{
				setState(76);
				match(VOID);
				}
				break;
			case INT:
			case BOOLEAN:
			case DOUBLE:
			case CLOCK:
				{
				setState(77);
				datatype();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(80);
			functionName();
			setState(81);
			match(LEFT_PAREN);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOLEAN) | (1L << DOUBLE) | (1L << CLOCK))) != 0)) {
				{
				setState(82);
				functionParam();
				}
			}

			setState(85);
			match(RIGHT_PAREN);
			setState(86);
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
		public List<TerminalNode> COMMA() { return getTokens(OurParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OurParser.COMMA, i);
		}
		public List<FunctionParamContext> functionParam() {
			return getRuleContexts(FunctionParamContext.class);
		}
		public FunctionParamContext functionParam(int i) {
			return getRuleContext(FunctionParamContext.class,i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			datatype();
			setState(89);
			variableName();
			setState(94);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(90);
					match(COMMA);
					setState(91);
					functionParam();
					}
					} 
				}
				setState(96);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class FunctionCallContext extends ParserRuleContext {
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(OurParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(OurParser.RIGHT_PAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(OurParser.SEMICOLON, 0); }
		public FunctionArgsContext functionArgs() {
			return getRuleContext(FunctionArgsContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			functionName();
			setState(98);
			match(LEFT_PAREN);
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(99);
				functionArgs();
				}
				break;
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

	public static class FunctionArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<BoolExprContext> boolExpr() {
			return getRuleContexts(BoolExprContext.class);
		}
		public BoolExprContext boolExpr(int i) {
			return getRuleContext(BoolExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OurParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OurParser.COMMA, i);
		}
		public FunctionArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterFunctionArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitFunctionArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitFunctionArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgsContext functionArgs() throws RecognitionException {
		FunctionArgsContext _localctx = new FunctionArgsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(105);
				expr(0);
				}
				break;
			case 2:
				{
				setState(106);
				boolExpr();
				}
				break;
			}
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(109);
				match(COMMA);
				setState(112);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(110);
					expr(0);
					}
					break;
				case 2:
					{
					setState(111);
					boolExpr();
					}
					break;
				}
				}
				}
				setState(118);
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
		public AtStatementContext atStatement() {
			return getRuleContext(AtStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
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
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				variableDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(122);
				ifElseStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(123);
				iterativeStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(124);
				atStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(125);
				returnStatement();
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(OurParser.RETURN, 0); }
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(OurParser.SEMICOLON, 0); }
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(RETURN);
			setState(129);
			variableName();
			setState(130);
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
		enterRule(_localctx, 18, RULE_ifElseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			ifStatement();
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSE_IF) {
				{
				{
				setState(133);
				elseIfStatement();
				}
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(139);
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
		enterRule(_localctx, 20, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(IF);
			setState(143);
			match(LEFT_PAREN);
			setState(144);
			conditionalExpression();
			setState(145);
			match(RIGHT_PAREN);
			setState(146);
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
		enterRule(_localctx, 22, RULE_elseIfStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(ELSE_IF);
			setState(149);
			match(LEFT_PAREN);
			setState(150);
			conditionalExpression();
			setState(151);
			match(RIGHT_PAREN);
			setState(152);
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
		enterRule(_localctx, 24, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(ELSE);
			setState(155);
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
		enterRule(_localctx, 26, RULE_conditionalExpression);
		int _la;
		try {
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				boolExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(158);
					match(NOT);
					}
				}

				setState(161);
				variableName();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
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

	public static class AtStatementContext extends ParserRuleContext {
		public Token op;
		public TerminalNode AT() { return getToken(OurParser.AT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(OurParser.LEFT_PAREN, 0); }
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(OurParser.RIGHT_PAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(OurParser.EQUAL, 0); }
		public TerminalNode LESS_THAN() { return getToken(OurParser.LESS_THAN, 0); }
		public TerminalNode GREATER_THAN() { return getToken(OurParser.GREATER_THAN, 0); }
		public TerminalNode GREATER_OR_EQUAL() { return getToken(OurParser.GREATER_OR_EQUAL, 0); }
		public TerminalNode LESS_OR_EQUAL() { return getToken(OurParser.LESS_OR_EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(OurParser.NOT_EQUAL, 0); }
		public AtStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterAtStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitAtStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitAtStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtStatementContext atStatement() throws RecognitionException {
		AtStatementContext _localctx = new AtStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_atStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(AT);
			setState(166);
			match(LEFT_PAREN);
			setState(167);
			variableName();
			setState(168);
			((AtStatementContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << NOT_EQUAL) | (1L << GREATER_THAN) | (1L << GREATER_OR_EQUAL) | (1L << LESS_THAN) | (1L << LESS_OR_EQUAL))) != 0)) ) {
				((AtStatementContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(169);
			expr(0);
			setState(170);
			match(RIGHT_PAREN);
			setState(171);
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
		enterRule(_localctx, 30, RULE_iterativeStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
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
		enterRule(_localctx, 32, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(FOR);
			setState(176);
			match(LEFT_PAREN);
			setState(177);
			expr(0);
			setState(178);
			match(TO);
			setState(179);
			expr(0);
			setState(180);
			match(RIGHT_PAREN);
			setState(181);
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
		public Arit_opContext arit_op() {
			return getRuleContext(Arit_opContext.class,0);
		}
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
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
			case DIGIT_NEGATIVE:
			case DOUBLE_DIGIT:
			case DOUBLE_DIGIT_NEGATIVE:
				{
				setState(184);
				numLiteral();
				}
				break;
			case LEFT_PAREN:
				{
				setState(185);
				match(LEFT_PAREN);
				setState(186);
				expr(0);
				setState(187);
				match(RIGHT_PAREN);
				}
				break;
			case ID:
				{
				setState(189);
				variableName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(198);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(192);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(193);
					arit_op();
					setState(194);
					expr(5);
					}
					} 
				}
				setState(200);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		public List<TerminalNode> BOOL_LITERAL() { return getTokens(OurParser.BOOL_LITERAL); }
		public TerminalNode BOOL_LITERAL(int i) {
			return getToken(OurParser.BOOL_LITERAL, i);
		}
		public Bool_opContext bool_op() {
			return getRuleContext(Bool_opContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LEFT_PAREN() { return getToken(OurParser.LEFT_PAREN, 0); }
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(OurParser.RIGHT_PAREN, 0); }
		public TerminalNode NOT() { return getToken(OurParser.NOT, 0); }
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
		enterRule(_localctx, 36, RULE_boolExpr);
		int _la;
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				match(BOOL_LITERAL);
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
				setState(205);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DIGIT:
				case DIGIT_NEGATIVE:
				case DOUBLE_DIGIT:
				case DOUBLE_DIGIT_NEGATIVE:
				case LEFT_PAREN:
				case ID:
					{
					setState(203);
					expr(0);
					}
					break;
				case BOOL_LITERAL:
					{
					setState(204);
					match(BOOL_LITERAL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(207);
				bool_op();
				setState(210);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL_LITERAL:
					{
					setState(208);
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
					setState(209);
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
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(212);
					match(NOT);
					}
				}

				setState(215);
				match(LEFT_PAREN);
				setState(216);
				boolExpr();
				setState(217);
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
		enterRule(_localctx, 38, RULE_variableDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			datatype();
			setState(222);
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
		enterRule(_localctx, 40, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			variableName();
			setState(225);
			match(ASSIGN);
			setState(228);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
			case DIGIT_NEGATIVE:
			case DOUBLE_DIGIT:
			case DOUBLE_DIGIT_NEGATIVE:
			case LEFT_PAREN:
			case ID:
				{
				setState(226);
				expr(0);
				}
				break;
			case BOOL_LITERAL:
			case STRING_LITERAL:
				{
				setState(227);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(230);
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
		enterRule(_localctx, 42, RULE_variableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
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
		enterRule(_localctx, 44, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
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
		enterRule(_localctx, 46, RULE_datatype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
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
		enterRule(_localctx, 48, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
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
		enterRule(_localctx, 50, RULE_numLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
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

	public static class Arit_opContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(OurParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(OurParser.SUB, 0); }
		public TerminalNode MOD() { return getToken(OurParser.MOD, 0); }
		public TerminalNode DIV() { return getToken(OurParser.DIV, 0); }
		public TerminalNode MUL() { return getToken(OurParser.MUL, 0); }
		public Arit_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arit_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterArit_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitArit_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitArit_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arit_opContext arit_op() throws RecognitionException {
		Arit_opContext _localctx = new Arit_opContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_arit_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MOD) | (1L << DIV) | (1L << MUL))) != 0)) ) {
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

	public static class Bool_opContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(OurParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(OurParser.NOT_EQUAL, 0); }
		public TerminalNode GREATER_THAN() { return getToken(OurParser.GREATER_THAN, 0); }
		public TerminalNode GREATER_OR_EQUAL() { return getToken(OurParser.GREATER_OR_EQUAL, 0); }
		public TerminalNode LESS_THAN() { return getToken(OurParser.LESS_THAN, 0); }
		public TerminalNode LESS_OR_EQUAL() { return getToken(OurParser.LESS_OR_EQUAL, 0); }
		public Bool_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterBool_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitBool_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitBool_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_opContext bool_op() throws RecognitionException {
		Bool_opContext _localctx = new Bool_opContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_bool_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << NOT_EQUAL) | (1L << GREATER_THAN) | (1L << GREATER_OR_EQUAL) | (1L << LESS_THAN) | (1L << LESS_OR_EQUAL))) != 0)) ) {
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
		case 17:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\63\u00f9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\7\2>\n\2\f\2\16\2"+
		"A\13\2\3\3\3\3\3\3\3\4\3\4\7\4H\n\4\f\4\16\4K\13\4\3\4\3\4\3\5\3\5\5\5"+
		"Q\n\5\3\5\3\5\3\5\5\5V\n\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6_\n\6\f\6\16"+
		"\6b\13\6\3\7\3\7\3\7\5\7g\n\7\3\7\3\7\3\7\3\b\3\b\5\bn\n\b\3\b\3\b\3\b"+
		"\5\bs\n\b\7\bu\n\b\f\b\16\bx\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0081"+
		"\n\t\3\n\3\n\3\n\3\n\3\13\3\13\7\13\u0089\n\13\f\13\16\13\u008c\13\13"+
		"\3\13\5\13\u008f\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\17\3\17\5\17\u00a2\n\17\3\17\3\17\5\17\u00a6\n\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00c1\n\23"+
		"\3\23\3\23\3\23\3\23\7\23\u00c7\n\23\f\23\16\23\u00ca\13\23\3\24\3\24"+
		"\3\24\3\24\5\24\u00d0\n\24\3\24\3\24\3\24\5\24\u00d5\n\24\3\24\5\24\u00d8"+
		"\n\24\3\24\3\24\3\24\3\24\5\24\u00de\n\24\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\5\26\u00e7\n\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\35\2\3$\36\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668\2\7\5\2\'\'**,/\3\2\3\6\3\2\26\27\3"+
		"\2\22\25\3\2\"&\2\u00fb\2:\3\2\2\2\4B\3\2\2\2\6E\3\2\2\2\bP\3\2\2\2\n"+
		"Z\3\2\2\2\fc\3\2\2\2\16m\3\2\2\2\20\u0080\3\2\2\2\22\u0082\3\2\2\2\24"+
		"\u0086\3\2\2\2\26\u0090\3\2\2\2\30\u0096\3\2\2\2\32\u009c\3\2\2\2\34\u00a5"+
		"\3\2\2\2\36\u00a7\3\2\2\2 \u00af\3\2\2\2\"\u00b1\3\2\2\2$\u00c0\3\2\2"+
		"\2&\u00dd\3\2\2\2(\u00df\3\2\2\2*\u00e2\3\2\2\2,\u00ea\3\2\2\2.\u00ec"+
		"\3\2\2\2\60\u00ee\3\2\2\2\62\u00f0\3\2\2\2\64\u00f2\3\2\2\2\66\u00f4\3"+
		"\2\2\28\u00f6\3\2\2\2:?\5\4\3\2;>\5\b\5\2<>\5,\27\2=;\3\2\2\2=<\3\2\2"+
		"\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\3\3\2\2\2A?\3\2\2\2BC\7\n\2\2CD\5\6"+
		"\4\2D\5\3\2\2\2EI\7\30\2\2FH\5\20\t\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ"+
		"\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\7\31\2\2M\7\3\2\2\2NQ\7\t\2\2OQ\5\60\31"+
		"\2PN\3\2\2\2PO\3\2\2\2QR\3\2\2\2RS\5.\30\2SU\7\32\2\2TV\5\n\6\2UT\3\2"+
		"\2\2UV\3\2\2\2VW\3\2\2\2WX\7\33\2\2XY\5\6\4\2Y\t\3\2\2\2Z[\5\60\31\2["+
		"`\5,\27\2\\]\7\35\2\2]_\5\n\6\2^\\\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2"+
		"\2a\13\3\2\2\2b`\3\2\2\2cd\5.\30\2df\7\32\2\2eg\5\16\b\2fe\3\2\2\2fg\3"+
		"\2\2\2gh\3\2\2\2hi\7\33\2\2ij\7\36\2\2j\r\3\2\2\2kn\5$\23\2ln\5&\24\2"+
		"mk\3\2\2\2ml\3\2\2\2nv\3\2\2\2or\7\35\2\2ps\5$\23\2qs\5&\24\2rp\3\2\2"+
		"\2rq\3\2\2\2su\3\2\2\2to\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\17\3\2"+
		"\2\2xv\3\2\2\2y\u0081\5(\25\2z\u0081\5*\26\2{\u0081\5\f\7\2|\u0081\5\24"+
		"\13\2}\u0081\5 \21\2~\u0081\5\36\20\2\177\u0081\5\22\n\2\u0080y\3\2\2"+
		"\2\u0080z\3\2\2\2\u0080{\3\2\2\2\u0080|\3\2\2\2\u0080}\3\2\2\2\u0080~"+
		"\3\2\2\2\u0080\177\3\2\2\2\u0081\21\3\2\2\2\u0082\u0083\7\13\2\2\u0083"+
		"\u0084\5,\27\2\u0084\u0085\7\36\2\2\u0085\23\3\2\2\2\u0086\u008a\5\26"+
		"\f\2\u0087\u0089\5\30\r\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2"+
		"\2\2\u008d\u008f\5\32\16\2\u008e\u008d\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\25\3\2\2\2\u0090\u0091\7\f\2\2\u0091\u0092\7\32\2\2\u0092\u0093\5\34"+
		"\17\2\u0093\u0094\7\33\2\2\u0094\u0095\5\6\4\2\u0095\27\3\2\2\2\u0096"+
		"\u0097\7\r\2\2\u0097\u0098\7\32\2\2\u0098\u0099\5\34\17\2\u0099\u009a"+
		"\7\33\2\2\u009a\u009b\5\6\4\2\u009b\31\3\2\2\2\u009c\u009d\7\16\2\2\u009d"+
		"\u009e\5\6\4\2\u009e\33\3\2\2\2\u009f\u00a6\5&\24\2\u00a0\u00a2\7+\2\2"+
		"\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a6"+
		"\5,\27\2\u00a4\u00a6\5\f\7\2\u00a5\u009f\3\2\2\2\u00a5\u00a1\3\2\2\2\u00a5"+
		"\u00a4\3\2\2\2\u00a6\35\3\2\2\2\u00a7\u00a8\7\21\2\2\u00a8\u00a9\7\32"+
		"\2\2\u00a9\u00aa\5,\27\2\u00aa\u00ab\t\2\2\2\u00ab\u00ac\5$\23\2\u00ac"+
		"\u00ad\7\33\2\2\u00ad\u00ae\5\6\4\2\u00ae\37\3\2\2\2\u00af\u00b0\5\"\22"+
		"\2\u00b0!\3\2\2\2\u00b1\u00b2\7\20\2\2\u00b2\u00b3\7\32\2\2\u00b3\u00b4"+
		"\5$\23\2\u00b4\u00b5\7\17\2\2\u00b5\u00b6\5$\23\2\u00b6\u00b7\7\33\2\2"+
		"\u00b7\u00b8\5\6\4\2\u00b8#\3\2\2\2\u00b9\u00ba\b\23\1\2\u00ba\u00c1\5"+
		"\64\33\2\u00bb\u00bc\7\32\2\2\u00bc\u00bd\5$\23\2\u00bd\u00be\7\33\2\2"+
		"\u00be\u00c1\3\2\2\2\u00bf\u00c1\5,\27\2\u00c0\u00b9\3\2\2\2\u00c0\u00bb"+
		"\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c8\3\2\2\2\u00c2\u00c3\f\6\2\2\u00c3"+
		"\u00c4\5\66\34\2\u00c4\u00c5\5$\23\7\u00c5\u00c7\3\2\2\2\u00c6\u00c2\3"+
		"\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"%\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00de\7\26\2\2\u00cc\u00de\3\2\2\2"+
		"\u00cd\u00d0\5$\23\2\u00ce\u00d0\7\26\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00ce"+
		"\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d4\58\35\2\u00d2\u00d5\7\26\2\2"+
		"\u00d3\u00d5\5$\23\2\u00d4\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00de"+
		"\3\2\2\2\u00d6\u00d8\7+\2\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8"+
		"\u00d9\3\2\2\2\u00d9\u00da\7\32\2\2\u00da\u00db\5&\24\2\u00db\u00dc\7"+
		"\33\2\2\u00dc\u00de\3\2\2\2\u00dd\u00cb\3\2\2\2\u00dd\u00cc\3\2\2\2\u00dd"+
		"\u00cf\3\2\2\2\u00dd\u00d7\3\2\2\2\u00de\'\3\2\2\2\u00df\u00e0\5\60\31"+
		"\2\u00e0\u00e1\5*\26\2\u00e1)\3\2\2\2\u00e2\u00e3\5,\27\2\u00e3\u00e6"+
		"\7!\2\2\u00e4\u00e7\5$\23\2\u00e5\u00e7\5\62\32\2\u00e6\u00e4\3\2\2\2"+
		"\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\7\36\2\2\u00e9+\3"+
		"\2\2\2\u00ea\u00eb\7\60\2\2\u00eb-\3\2\2\2\u00ec\u00ed\7\60\2\2\u00ed"+
		"/\3\2\2\2\u00ee\u00ef\t\3\2\2\u00ef\61\3\2\2\2\u00f0\u00f1\t\4\2\2\u00f1"+
		"\63\3\2\2\2\u00f2\u00f3\t\5\2\2\u00f3\65\3\2\2\2\u00f4\u00f5\t\6\2\2\u00f5"+
		"\67\3\2\2\2\u00f6\u00f7\t\2\2\2\u00f79\3\2\2\2\30=?IPU`fmrv\u0080\u008a"+
		"\u008e\u00a1\u00a5\u00c0\u00c8\u00cf\u00d4\u00d7\u00dd\u00e6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}