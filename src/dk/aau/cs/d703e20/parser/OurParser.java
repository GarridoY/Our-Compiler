// Generated from C:/Users/the_p/Documents/GitHub/P7/src\OurParser.g4 by ANTLR 4.8
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
		INT=1, INT_ARRAY=2, BOOLEAN=3, BOOLEAN_ARRAY=4, DOUBLE=5, DOUBLE_ARRAY=6, 
		CLOCK=7, STRING=8, PIT=9, SUBSCRIPT=10, IPIN=11, OPIN=12, ANALOGPIN=13, 
		VOID=14, LOOP=15, SETUP=16, RETURN=17, IF=18, ELSE_IF=19, ELSE=20, TO=21, 
		FOR=22, WHILE=23, AT=24, BOUND=25, FINAL=26, DIGIT=27, DIGIT_NEGATIVE=28, 
		DOUBLE_DIGIT=29, DOUBLE_DIGIT_NEGATIVE=30, BOOL_LITERAL=31, STRING_LITERAL=32, 
		LEFT_SQBRACKET=33, RIGHT_SQBRACKET=34, LEFT_BRACKET=35, RIGHT_BRACKET=36, 
		LEFT_PAREN=37, RIGHT_PAREN=38, DOT=39, COMMA=40, SEMICOLON=41, QUESTION=42, 
		COLON=43, ASSIGN=44, ADD=45, SUB=46, MOD=47, DIV=48, MUL=49, EQUAL=50, 
		AND=51, OR=52, NOT_EQUAL=53, NOT=54, GREATER_THAN=55, GREATER_OR_EQUAL=56, 
		LESS_THAN=57, LESS_OR_EQUAL=58, ID=59, COMMENT_STRING=60, COMMENT_BLOCK=61, 
		WS=62;
	public static final int
		RULE_program = 0, RULE_loop = 1, RULE_setup = 2, RULE_block = 3, RULE_functionDecl = 4, 
		RULE_functionParam = 5, RULE_functionCall = 6, RULE_functionArgs = 7, 
		RULE_statement = 8, RULE_returnStatement = 9, RULE_ifElseStatement = 10, 
		RULE_ifStatement = 11, RULE_elseIfStatement = 12, RULE_elseStatement = 13, 
		RULE_conditionalExpression = 14, RULE_atStatement = 15, RULE_atParams = 16, 
		RULE_boundStatement = 17, RULE_iterativeStatement = 18, RULE_forStatement = 19, 
		RULE_whileStatement = 20, RULE_arithExpr = 21, RULE_boolExpr = 22, RULE_pinDecl = 23, 
		RULE_variableDecl = 24, RULE_assignArray = 25, RULE_assignment = 26, RULE_variableName = 27, 
		RULE_functionName = 28, RULE_pinType = 29, RULE_dataType = 30, RULE_literal = 31, 
		RULE_numLiteral = 32, RULE_arithOp = 33, RULE_boolOp = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "loop", "setup", "block", "functionDecl", "functionParam", 
			"functionCall", "functionArgs", "statement", "returnStatement", "ifElseStatement", 
			"ifStatement", "elseIfStatement", "elseStatement", "conditionalExpression", 
			"atStatement", "atParams", "boundStatement", "iterativeStatement", "forStatement", 
			"whileStatement", "arithExpr", "boolExpr", "pinDecl", "variableDecl", 
			"assignArray", "assignment", "variableName", "functionName", "pinType", 
			"dataType", "literal", "numLiteral", "arithOp", "boolOp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", null, "'bool'", null, "'double'", null, "'clock'", "'string'", 
			"'pit'", null, "'ipin'", "'opin'", null, "'void'", "'Loop'", "'Setup'", 
			"'return'", "'if'", "'else if'", "'else'", "'to'", "'for'", "'while'", 
			"'at'", "'bound'", "'final'", null, null, null, null, null, null, "'['", 
			"']'", "'{'", "'}'", "'('", "')'", "'.'", "','", "';'", "'?'", "':'", 
			"'='", "'+'", "'-'", "'%'", "'/'", "'*'", "'=='", "'&&'", "'||'", "'!='", 
			"'!'", "'>'", "'>='", "'<'", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "INT_ARRAY", "BOOLEAN", "BOOLEAN_ARRAY", "DOUBLE", "DOUBLE_ARRAY", 
			"CLOCK", "STRING", "PIT", "SUBSCRIPT", "IPIN", "OPIN", "ANALOGPIN", "VOID", 
			"LOOP", "SETUP", "RETURN", "IF", "ELSE_IF", "ELSE", "TO", "FOR", "WHILE", 
			"AT", "BOUND", "FINAL", "DIGIT", "DIGIT_NEGATIVE", "DOUBLE_DIGIT", "DOUBLE_DIGIT_NEGATIVE", 
			"BOOL_LITERAL", "STRING_LITERAL", "LEFT_SQBRACKET", "RIGHT_SQBRACKET", 
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
		public SetupContext setup() {
			return getRuleContext(SetupContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
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
			setState(70);
			setup();
			setState(71);
			loop();
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << INT_ARRAY) | (1L << BOOLEAN) | (1L << BOOLEAN_ARRAY) | (1L << DOUBLE) | (1L << DOUBLE_ARRAY) | (1L << CLOCK) | (1L << STRING) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(74);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT:
				case INT_ARRAY:
				case BOOLEAN:
				case BOOLEAN_ARRAY:
				case DOUBLE:
				case DOUBLE_ARRAY:
				case CLOCK:
				case STRING:
				case VOID:
					{
					setState(72);
					functionDecl();
					}
					break;
				case ID:
					{
					setState(73);
					variableName();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(78);
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

	public static class LoopContext extends ParserRuleContext {
		public TerminalNode LOOP() { return getToken(OurParser.LOOP, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(LOOP);
			setState(80);
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

	public static class SetupContext extends ParserRuleContext {
		public TerminalNode SETUP() { return getToken(OurParser.SETUP, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SetupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterSetup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitSetup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitSetup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetupContext setup() throws RecognitionException {
		SetupContext _localctx = new SetupContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_setup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(SETUP);
			setState(83);
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
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(LEFT_BRACKET);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << INT_ARRAY) | (1L << BOOLEAN) | (1L << BOOLEAN_ARRAY) | (1L << DOUBLE) | (1L << DOUBLE_ARRAY) | (1L << CLOCK) | (1L << STRING) | (1L << IPIN) | (1L << OPIN) | (1L << RETURN) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << AT) | (1L << BOUND) | (1L << ID))) != 0)) {
				{
				{
				setState(86);
				statement();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
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
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
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
		enterRule(_localctx, 8, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				{
				setState(94);
				match(VOID);
				}
				break;
			case INT:
			case INT_ARRAY:
			case BOOLEAN:
			case BOOLEAN_ARRAY:
			case DOUBLE:
			case DOUBLE_ARRAY:
			case CLOCK:
			case STRING:
				{
				setState(95);
				dataType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(98);
			functionName();
			setState(99);
			match(LEFT_PAREN);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << INT_ARRAY) | (1L << BOOLEAN) | (1L << BOOLEAN_ARRAY) | (1L << DOUBLE) | (1L << DOUBLE_ARRAY) | (1L << CLOCK) | (1L << STRING))) != 0)) {
				{
				setState(100);
				functionParam();
				}
			}

			setState(103);
			match(RIGHT_PAREN);
			setState(104);
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
		public List<DataTypeContext> dataType() {
			return getRuleContexts(DataTypeContext.class);
		}
		public DataTypeContext dataType(int i) {
			return getRuleContext(DataTypeContext.class,i);
		}
		public List<VariableNameContext> variableName() {
			return getRuleContexts(VariableNameContext.class);
		}
		public VariableNameContext variableName(int i) {
			return getRuleContext(VariableNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OurParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OurParser.COMMA, i);
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
		enterRule(_localctx, 10, RULE_functionParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			dataType();
			setState(107);
			variableName();
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(108);
				match(COMMA);
				setState(109);
				dataType();
				setState(110);
				variableName();
				}
				}
				setState(116);
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

	public static class FunctionCallContext extends ParserRuleContext {
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(OurParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(OurParser.RIGHT_PAREN, 0); }
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
		enterRule(_localctx, 12, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			functionName();
			setState(118);
			match(LEFT_PAREN);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUBSCRIPT) | (1L << DIGIT) | (1L << DIGIT_NEGATIVE) | (1L << DOUBLE_DIGIT) | (1L << DOUBLE_DIGIT_NEGATIVE) | (1L << BOOL_LITERAL) | (1L << LEFT_PAREN) | (1L << NOT) | (1L << ID))) != 0)) {
				{
				setState(119);
				functionArgs();
				}
			}

			setState(122);
			match(RIGHT_PAREN);
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
		public List<ArithExprContext> arithExpr() {
			return getRuleContexts(ArithExprContext.class);
		}
		public ArithExprContext arithExpr(int i) {
			return getRuleContext(ArithExprContext.class,i);
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
		enterRule(_localctx, 14, RULE_functionArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(124);
				arithExpr(0);
				}
				break;
			case 2:
				{
				setState(125);
				boolExpr();
				}
				break;
			}
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(128);
				match(COMMA);
				setState(131);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(129);
					arithExpr(0);
					}
					break;
				case 2:
					{
					setState(130);
					boolExpr();
					}
					break;
				}
				}
				}
				setState(137);
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
		public TerminalNode SEMICOLON() { return getToken(OurParser.SEMICOLON, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public PinDeclContext pinDecl() {
			return getRuleContext(PinDeclContext.class,0);
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
		public BoundStatementContext boundStatement() {
			return getRuleContext(BoundStatementContext.class,0);
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
		enterRule(_localctx, 16, RULE_statement);
		try {
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				variableDecl();
				setState(139);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				assignment();
				setState(142);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(144);
				pinDecl();
				setState(145);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(147);
				functionCall();
				setState(148);
				match(SEMICOLON);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(150);
				ifElseStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(151);
				iterativeStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(152);
				atStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(153);
				boundStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(154);
				returnStatement();
				setState(155);
				match(SEMICOLON);
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
		enterRule(_localctx, 18, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(RETURN);
			setState(160);
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
		enterRule(_localctx, 20, RULE_ifElseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			ifStatement();
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSE_IF) {
				{
				{
				setState(163);
				elseIfStatement();
				}
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(169);
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
		enterRule(_localctx, 22, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(IF);
			setState(173);
			match(LEFT_PAREN);
			setState(174);
			conditionalExpression();
			setState(175);
			match(RIGHT_PAREN);
			setState(176);
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
		enterRule(_localctx, 24, RULE_elseIfStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(ELSE_IF);
			setState(179);
			match(LEFT_PAREN);
			setState(180);
			conditionalExpression();
			setState(181);
			match(RIGHT_PAREN);
			setState(182);
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
		enterRule(_localctx, 26, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(ELSE);
			setState(185);
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
		public TerminalNode SUBSCRIPT() { return getToken(OurParser.SUBSCRIPT, 0); }
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
		enterRule(_localctx, 28, RULE_conditionalExpression);
		int _la;
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				boolExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(188);
					match(NOT);
					}
				}

				setState(191);
				variableName();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(193);
				match(SUBSCRIPT);
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
		public TerminalNode AT() { return getToken(OurParser.AT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(OurParser.LEFT_PAREN, 0); }
		public AtParamsContext atParams() {
			return getRuleContext(AtParamsContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(OurParser.RIGHT_PAREN, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode FINAL() { return getToken(OurParser.FINAL, 0); }
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
		enterRule(_localctx, 30, RULE_atStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(AT);
			setState(197);
			match(LEFT_PAREN);
			setState(198);
			atParams();
			setState(199);
			match(RIGHT_PAREN);
			setState(200);
			block();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FINAL) {
				{
				setState(201);
				match(FINAL);
				setState(202);
				block();
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

	public static class AtParamsContext extends ParserRuleContext {
		public List<VariableNameContext> variableName() {
			return getRuleContexts(VariableNameContext.class);
		}
		public VariableNameContext variableName(int i) {
			return getRuleContext(VariableNameContext.class,i);
		}
		public List<BoolOpContext> boolOp() {
			return getRuleContexts(BoolOpContext.class);
		}
		public BoolOpContext boolOp(int i) {
			return getRuleContext(BoolOpContext.class,i);
		}
		public List<ArithExprContext> arithExpr() {
			return getRuleContexts(ArithExprContext.class);
		}
		public ArithExprContext arithExpr(int i) {
			return getRuleContext(ArithExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OurParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OurParser.COMMA, i);
		}
		public TerminalNode BOOL_LITERAL() { return getToken(OurParser.BOOL_LITERAL, 0); }
		public AtParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterAtParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitAtParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitAtParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtParamsContext atParams() throws RecognitionException {
		AtParamsContext _localctx = new AtParamsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_atParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			variableName();
			setState(206);
			boolOp();
			setState(207);
			arithExpr(0);
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(208);
				match(COMMA);
				setState(209);
				variableName();
				setState(210);
				boolOp();
				setState(211);
				arithExpr(0);
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(212);
					match(COMMA);
					setState(213);
					match(BOOL_LITERAL);
					}
				}

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

	public static class BoundStatementContext extends ParserRuleContext {
		public TerminalNode BOUND() { return getToken(OurParser.BOUND, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(OurParser.LEFT_PAREN, 0); }
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public BoolOpContext boolOp() {
			return getRuleContext(BoolOpContext.class,0);
		}
		public ArithExprContext arithExpr() {
			return getRuleContext(ArithExprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(OurParser.RIGHT_PAREN, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(OurParser.COMMA, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(OurParser.BOOL_LITERAL, 0); }
		public TerminalNode FINAL() { return getToken(OurParser.FINAL, 0); }
		public BoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterBoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitBoundStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitBoundStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoundStatementContext boundStatement() throws RecognitionException {
		BoundStatementContext _localctx = new BoundStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_boundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(BOUND);
			setState(219);
			match(LEFT_PAREN);
			setState(220);
			variableName();
			setState(221);
			boolOp();
			setState(222);
			arithExpr(0);
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(223);
				match(COMMA);
				setState(224);
				match(BOOL_LITERAL);
				}
			}

			setState(227);
			match(RIGHT_PAREN);
			setState(228);
			block();
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FINAL) {
				{
				setState(229);
				match(FINAL);
				setState(230);
				block();
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

	public static class IterativeStatementContext extends ParserRuleContext {
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
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
		enterRule(_localctx, 36, RULE_iterativeStatement);
		try {
			setState(235);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				forStatement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				whileStatement();
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

	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(OurParser.FOR, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(OurParser.LEFT_PAREN, 0); }
		public List<ArithExprContext> arithExpr() {
			return getRuleContexts(ArithExprContext.class);
		}
		public ArithExprContext arithExpr(int i) {
			return getRuleContext(ArithExprContext.class,i);
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
		enterRule(_localctx, 38, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(FOR);
			setState(238);
			match(LEFT_PAREN);
			setState(239);
			arithExpr(0);
			setState(240);
			match(TO);
			setState(241);
			arithExpr(0);
			setState(242);
			match(RIGHT_PAREN);
			setState(243);
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

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(OurParser.WHILE, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(OurParser.LEFT_PAREN, 0); }
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(OurParser.RIGHT_PAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(WHILE);
			setState(246);
			match(LEFT_PAREN);
			setState(247);
			boolExpr();
			setState(248);
			match(RIGHT_PAREN);
			setState(249);
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

	public static class ArithExprContext extends ParserRuleContext {
		public NumLiteralContext numLiteral() {
			return getRuleContext(NumLiteralContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(OurParser.LEFT_PAREN, 0); }
		public List<ArithExprContext> arithExpr() {
			return getRuleContexts(ArithExprContext.class);
		}
		public ArithExprContext arithExpr(int i) {
			return getRuleContext(ArithExprContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(OurParser.RIGHT_PAREN, 0); }
		public TerminalNode NOT() { return getToken(OurParser.NOT, 0); }
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode SUBSCRIPT() { return getToken(OurParser.SUBSCRIPT, 0); }
		public ArithOpContext arithOp() {
			return getRuleContext(ArithOpContext.class,0);
		}
		public ArithExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterArithExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitArithExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitArithExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithExprContext arithExpr() throws RecognitionException {
		return arithExpr(0);
	}

	private ArithExprContext arithExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArithExprContext _localctx = new ArithExprContext(_ctx, _parentState);
		ArithExprContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_arithExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(252);
				numLiteral();
				}
				break;
			case 2:
				{
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(253);
					match(NOT);
					}
				}

				setState(256);
				match(LEFT_PAREN);
				setState(257);
				arithExpr(0);
				setState(258);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				{
				setState(260);
				variableName();
				}
				break;
			case 4:
				{
				setState(261);
				functionCall();
				}
				break;
			case 5:
				{
				setState(262);
				match(SUBSCRIPT);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(271);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArithExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_arithExpr);
					setState(265);
					if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
					setState(266);
					arithOp();
					setState(267);
					arithExpr(7);
					}
					} 
				}
				setState(273);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
		public BoolOpContext boolOp() {
			return getRuleContext(BoolOpContext.class,0);
		}
		public List<ArithExprContext> arithExpr() {
			return getRuleContexts(ArithExprContext.class);
		}
		public ArithExprContext arithExpr(int i) {
			return getRuleContext(ArithExprContext.class,i);
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
		enterRule(_localctx, 44, RULE_boolExpr);
		int _la;
		try {
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				match(BOOL_LITERAL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(277);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SUBSCRIPT:
				case DIGIT:
				case DIGIT_NEGATIVE:
				case DOUBLE_DIGIT:
				case DOUBLE_DIGIT_NEGATIVE:
				case LEFT_PAREN:
				case NOT:
				case ID:
					{
					setState(275);
					arithExpr(0);
					}
					break;
				case BOOL_LITERAL:
					{
					setState(276);
					match(BOOL_LITERAL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(279);
				boolOp();
				setState(282);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL_LITERAL:
					{
					setState(280);
					match(BOOL_LITERAL);
					}
					break;
				case SUBSCRIPT:
				case DIGIT:
				case DIGIT_NEGATIVE:
				case DOUBLE_DIGIT:
				case DOUBLE_DIGIT_NEGATIVE:
				case LEFT_PAREN:
				case NOT:
				case ID:
					{
					setState(281);
					arithExpr(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(284);
					match(NOT);
					}
				}

				setState(287);
				match(LEFT_PAREN);
				setState(288);
				boolExpr();
				setState(289);
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

	public static class PinDeclContext extends ParserRuleContext {
		public PinTypeContext pinType() {
			return getRuleContext(PinTypeContext.class,0);
		}
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public TerminalNode DIGIT() { return getToken(OurParser.DIGIT, 0); }
		public TerminalNode ANALOGPIN() { return getToken(OurParser.ANALOGPIN, 0); }
		public PinDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pinDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterPinDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitPinDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitPinDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PinDeclContext pinDecl() throws RecognitionException {
		PinDeclContext _localctx = new PinDeclContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_pinDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			pinType();
			setState(294);
			variableName();
			setState(295);
			_la = _input.LA(1);
			if ( !(_la==ANALOGPIN || _la==DIGIT) ) {
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

	public static class VariableDeclContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public AssignArrayContext assignArray() {
			return getRuleContext(AssignArrayContext.class,0);
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
		enterRule(_localctx, 48, RULE_variableDecl);
		try {
			setState(306);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				dataType();
				setState(298);
				variableName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(300);
				dataType();
				setState(301);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(303);
				dataType();
				setState(304);
				assignArray();
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

	public static class AssignArrayContext extends ParserRuleContext {
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(OurParser.ASSIGN, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(OurParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(OurParser.RIGHT_BRACKET, 0); }
		public List<ArithExprContext> arithExpr() {
			return getRuleContexts(ArithExprContext.class);
		}
		public ArithExprContext arithExpr(int i) {
			return getRuleContext(ArithExprContext.class,i);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OurParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OurParser.COMMA, i);
		}
		public AssignArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterAssignArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitAssignArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitAssignArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignArrayContext assignArray() throws RecognitionException {
		AssignArrayContext _localctx = new AssignArrayContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_assignArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			variableName();
			setState(309);
			match(ASSIGN);
			setState(310);
			match(LEFT_BRACKET);
			setState(313);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUBSCRIPT:
			case DIGIT:
			case DIGIT_NEGATIVE:
			case DOUBLE_DIGIT:
			case DOUBLE_DIGIT_NEGATIVE:
			case LEFT_PAREN:
			case NOT:
			case ID:
				{
				setState(311);
				arithExpr(0);
				}
				break;
			case BOOL_LITERAL:
			case STRING_LITERAL:
				{
				setState(312);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(315);
				match(COMMA);
				setState(318);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SUBSCRIPT:
				case DIGIT:
				case DIGIT_NEGATIVE:
				case DOUBLE_DIGIT:
				case DOUBLE_DIGIT_NEGATIVE:
				case LEFT_PAREN:
				case NOT:
				case ID:
					{
					setState(316);
					arithExpr(0);
					}
					break;
				case BOOL_LITERAL:
				case STRING_LITERAL:
					{
					setState(317);
					literal();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(325);
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

	public static class AssignmentContext extends ParserRuleContext {
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(OurParser.ASSIGN, 0); }
		public ArithExprContext arithExpr() {
			return getRuleContext(ArithExprContext.class,0);
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
		enterRule(_localctx, 52, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			variableName();
			setState(328);
			match(ASSIGN);
			setState(331);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUBSCRIPT:
			case DIGIT:
			case DIGIT_NEGATIVE:
			case DOUBLE_DIGIT:
			case DOUBLE_DIGIT_NEGATIVE:
			case LEFT_PAREN:
			case NOT:
			case ID:
				{
				setState(329);
				arithExpr(0);
				}
				break;
			case BOOL_LITERAL:
			case STRING_LITERAL:
				{
				setState(330);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		enterRule(_localctx, 54, RULE_variableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
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
		enterRule(_localctx, 56, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
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

	public static class PinTypeContext extends ParserRuleContext {
		public TerminalNode IPIN() { return getToken(OurParser.IPIN, 0); }
		public TerminalNode OPIN() { return getToken(OurParser.OPIN, 0); }
		public PinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterPinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitPinType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitPinType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PinTypeContext pinType() throws RecognitionException {
		PinTypeContext _localctx = new PinTypeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_pinType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			_la = _input.LA(1);
			if ( !(_la==IPIN || _la==OPIN) ) {
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

	public static class DataTypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(OurParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(OurParser.DOUBLE, 0); }
		public TerminalNode BOOLEAN() { return getToken(OurParser.BOOLEAN, 0); }
		public TerminalNode CLOCK() { return getToken(OurParser.CLOCK, 0); }
		public TerminalNode STRING() { return getToken(OurParser.STRING, 0); }
		public TerminalNode INT_ARRAY() { return getToken(OurParser.INT_ARRAY, 0); }
		public TerminalNode DOUBLE_ARRAY() { return getToken(OurParser.DOUBLE_ARRAY, 0); }
		public TerminalNode BOOLEAN_ARRAY() { return getToken(OurParser.BOOLEAN_ARRAY, 0); }
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_dataType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << INT_ARRAY) | (1L << BOOLEAN) | (1L << BOOLEAN_ARRAY) | (1L << DOUBLE) | (1L << DOUBLE_ARRAY) | (1L << CLOCK) | (1L << STRING))) != 0)) ) {
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
		enterRule(_localctx, 62, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
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
		enterRule(_localctx, 64, RULE_numLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
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

	public static class ArithOpContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(OurParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(OurParser.SUB, 0); }
		public TerminalNode MOD() { return getToken(OurParser.MOD, 0); }
		public TerminalNode DIV() { return getToken(OurParser.DIV, 0); }
		public TerminalNode MUL() { return getToken(OurParser.MUL, 0); }
		public ArithOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterArithOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitArithOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitArithOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithOpContext arithOp() throws RecognitionException {
		ArithOpContext _localctx = new ArithOpContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_arithOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
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

	public static class BoolOpContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(OurParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(OurParser.NOT_EQUAL, 0); }
		public TerminalNode GREATER_THAN() { return getToken(OurParser.GREATER_THAN, 0); }
		public TerminalNode GREATER_OR_EQUAL() { return getToken(OurParser.GREATER_OR_EQUAL, 0); }
		public TerminalNode LESS_THAN() { return getToken(OurParser.LESS_THAN, 0); }
		public TerminalNode LESS_OR_EQUAL() { return getToken(OurParser.LESS_OR_EQUAL, 0); }
		public BoolOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).enterBoolOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurParserListener ) ((OurParserListener)listener).exitBoolOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OurParserVisitor ) return ((OurParserVisitor<? extends T>)visitor).visitBoolOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolOpContext boolOp() throws RecognitionException {
		BoolOpContext _localctx = new BoolOpContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_boolOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
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
		case 21:
			return arithExpr_sempred((ArithExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean arithExpr_sempred(ArithExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3@\u0160\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\7\2M\n\2\f\2\16\2P\13\2\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\5\3\5\7\5Z\n\5\f\5\16\5]\13\5\3\5\3\5\3\6\3\6\5\6"+
		"c\n\6\3\6\3\6\3\6\5\6h\n\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7s\n"+
		"\7\f\7\16\7v\13\7\3\b\3\b\3\b\5\b{\n\b\3\b\3\b\3\t\3\t\5\t\u0081\n\t\3"+
		"\t\3\t\3\t\5\t\u0086\n\t\7\t\u0088\n\t\f\t\16\t\u008b\13\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a0"+
		"\n\n\3\13\3\13\3\13\3\f\3\f\7\f\u00a7\n\f\f\f\16\f\u00aa\13\f\3\f\5\f"+
		"\u00ad\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\20\3\20\5\20\u00c0\n\20\3\20\3\20\3\20\5\20\u00c5\n\20\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00ce\n\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u00d9\n\22\5\22\u00db\n\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\5\23\u00e4\n\23\3\23\3\23\3\23\3\23\5\23\u00ea"+
		"\n\23\3\24\3\24\5\24\u00ee\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\5\27\u0101\n\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\5\27\u010a\n\27\3\27\3\27\3\27\3\27\7\27\u0110"+
		"\n\27\f\27\16\27\u0113\13\27\3\30\3\30\3\30\5\30\u0118\n\30\3\30\3\30"+
		"\3\30\5\30\u011d\n\30\3\30\5\30\u0120\n\30\3\30\3\30\3\30\3\30\5\30\u0126"+
		"\n\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\5\32\u0135\n\32\3\33\3\33\3\33\3\33\3\33\5\33\u013c\n\33\3\33\3\33\3"+
		"\33\5\33\u0141\n\33\7\33\u0143\n\33\f\33\16\33\u0146\13\33\3\33\3\33\3"+
		"\34\3\34\3\34\3\34\5\34\u014e\n\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3"+
		" \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\2\3,%\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDF\2\t\4\2\17\17\35\35\3\2\r\16\3\2\3"+
		"\n\3\2!\"\3\2\35 \3\2/\63\5\2\64\64\67\679<\2\u016b\2H\3\2\2\2\4Q\3\2"+
		"\2\2\6T\3\2\2\2\bW\3\2\2\2\nb\3\2\2\2\fl\3\2\2\2\16w\3\2\2\2\20\u0080"+
		"\3\2\2\2\22\u009f\3\2\2\2\24\u00a1\3\2\2\2\26\u00a4\3\2\2\2\30\u00ae\3"+
		"\2\2\2\32\u00b4\3\2\2\2\34\u00ba\3\2\2\2\36\u00c4\3\2\2\2 \u00c6\3\2\2"+
		"\2\"\u00cf\3\2\2\2$\u00dc\3\2\2\2&\u00ed\3\2\2\2(\u00ef\3\2\2\2*\u00f7"+
		"\3\2\2\2,\u0109\3\2\2\2.\u0125\3\2\2\2\60\u0127\3\2\2\2\62\u0134\3\2\2"+
		"\2\64\u0136\3\2\2\2\66\u0149\3\2\2\28\u014f\3\2\2\2:\u0151\3\2\2\2<\u0153"+
		"\3\2\2\2>\u0155\3\2\2\2@\u0157\3\2\2\2B\u0159\3\2\2\2D\u015b\3\2\2\2F"+
		"\u015d\3\2\2\2HI\5\6\4\2IN\5\4\3\2JM\5\n\6\2KM\58\35\2LJ\3\2\2\2LK\3\2"+
		"\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\3\3\2\2\2PN\3\2\2\2QR\7\21\2\2RS\5"+
		"\b\5\2S\5\3\2\2\2TU\7\22\2\2UV\5\b\5\2V\7\3\2\2\2W[\7%\2\2XZ\5\22\n\2"+
		"YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\^\3\2\2\2][\3\2\2\2^_\7&\2"+
		"\2_\t\3\2\2\2`c\7\20\2\2ac\5> \2b`\3\2\2\2ba\3\2\2\2cd\3\2\2\2de\5:\36"+
		"\2eg\7\'\2\2fh\5\f\7\2gf\3\2\2\2gh\3\2\2\2hi\3\2\2\2ij\7(\2\2jk\5\b\5"+
		"\2k\13\3\2\2\2lm\5> \2mt\58\35\2no\7*\2\2op\5> \2pq\58\35\2qs\3\2\2\2"+
		"rn\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2u\r\3\2\2\2vt\3\2\2\2wx\5:\36"+
		"\2xz\7\'\2\2y{\5\20\t\2zy\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\7(\2\2}\17\3\2"+
		"\2\2~\u0081\5,\27\2\177\u0081\5.\30\2\u0080~\3\2\2\2\u0080\177\3\2\2\2"+
		"\u0081\u0089\3\2\2\2\u0082\u0085\7*\2\2\u0083\u0086\5,\27\2\u0084\u0086"+
		"\5.\30\2\u0085\u0083\3\2\2\2\u0085\u0084\3\2\2\2\u0086\u0088\3\2\2\2\u0087"+
		"\u0082\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2"+
		"\2\2\u008a\21\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d\5\62\32\2\u008d"+
		"\u008e\7+\2\2\u008e\u00a0\3\2\2\2\u008f\u0090\5\66\34\2\u0090\u0091\7"+
		"+\2\2\u0091\u00a0\3\2\2\2\u0092\u0093\5\60\31\2\u0093\u0094\7+\2\2\u0094"+
		"\u00a0\3\2\2\2\u0095\u0096\5\16\b\2\u0096\u0097\7+\2\2\u0097\u00a0\3\2"+
		"\2\2\u0098\u00a0\5\26\f\2\u0099\u00a0\5&\24\2\u009a\u00a0\5 \21\2\u009b"+
		"\u00a0\5$\23\2\u009c\u009d\5\24\13\2\u009d\u009e\7+\2\2\u009e\u00a0\3"+
		"\2\2\2\u009f\u008c\3\2\2\2\u009f\u008f\3\2\2\2\u009f\u0092\3\2\2\2\u009f"+
		"\u0095\3\2\2\2\u009f\u0098\3\2\2\2\u009f\u0099\3\2\2\2\u009f\u009a\3\2"+
		"\2\2\u009f\u009b\3\2\2\2\u009f\u009c\3\2\2\2\u00a0\23\3\2\2\2\u00a1\u00a2"+
		"\7\23\2\2\u00a2\u00a3\58\35\2\u00a3\25\3\2\2\2\u00a4\u00a8\5\30\r\2\u00a5"+
		"\u00a7\5\32\16\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3"+
		"\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab"+
		"\u00ad\5\34\17\2\u00ac\u00ab\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\27\3\2"+
		"\2\2\u00ae\u00af\7\24\2\2\u00af\u00b0\7\'\2\2\u00b0\u00b1\5\36\20\2\u00b1"+
		"\u00b2\7(\2\2\u00b2\u00b3\5\b\5\2\u00b3\31\3\2\2\2\u00b4\u00b5\7\25\2"+
		"\2\u00b5\u00b6\7\'\2\2\u00b6\u00b7\5\36\20\2\u00b7\u00b8\7(\2\2\u00b8"+
		"\u00b9\5\b\5\2\u00b9\33\3\2\2\2\u00ba\u00bb\7\26\2\2\u00bb\u00bc\5\b\5"+
		"\2\u00bc\35\3\2\2\2\u00bd\u00c5\5.\30\2\u00be\u00c0\78\2\2\u00bf\u00be"+
		"\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c5\58\35\2\u00c2"+
		"\u00c5\5\16\b\2\u00c3\u00c5\7\f\2\2\u00c4\u00bd\3\2\2\2\u00c4\u00bf\3"+
		"\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\37\3\2\2\2\u00c6"+
		"\u00c7\7\32\2\2\u00c7\u00c8\7\'\2\2\u00c8\u00c9\5\"\22\2\u00c9\u00ca\7"+
		"(\2\2\u00ca\u00cd\5\b\5\2\u00cb\u00cc\7\34\2\2\u00cc\u00ce\5\b\5\2\u00cd"+
		"\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce!\3\2\2\2\u00cf\u00d0\58\35\2"+
		"\u00d0\u00d1\5F$\2\u00d1\u00da\5,\27\2\u00d2\u00d3\7*\2\2\u00d3\u00d4"+
		"\58\35\2\u00d4\u00d5\5F$\2\u00d5\u00d8\5,\27\2\u00d6\u00d7\7*\2\2\u00d7"+
		"\u00d9\7!\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00db\3\2"+
		"\2\2\u00da\u00d2\3\2\2\2\u00da\u00db\3\2\2\2\u00db#\3\2\2\2\u00dc\u00dd"+
		"\7\33\2\2\u00dd\u00de\7\'\2\2\u00de\u00df\58\35\2\u00df\u00e0\5F$\2\u00e0"+
		"\u00e3\5,\27\2\u00e1\u00e2\7*\2\2\u00e2\u00e4\7!\2\2\u00e3\u00e1\3\2\2"+
		"\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\7(\2\2\u00e6\u00e9"+
		"\5\b\5\2\u00e7\u00e8\7\34\2\2\u00e8\u00ea\5\b\5\2\u00e9\u00e7\3\2\2\2"+
		"\u00e9\u00ea\3\2\2\2\u00ea%\3\2\2\2\u00eb\u00ee\5(\25\2\u00ec\u00ee\5"+
		"*\26\2\u00ed\u00eb\3\2\2\2\u00ed\u00ec\3\2\2\2\u00ee\'\3\2\2\2\u00ef\u00f0"+
		"\7\30\2\2\u00f0\u00f1\7\'\2\2\u00f1\u00f2\5,\27\2\u00f2\u00f3\7\27\2\2"+
		"\u00f3\u00f4\5,\27\2\u00f4\u00f5\7(\2\2\u00f5\u00f6\5\b\5\2\u00f6)\3\2"+
		"\2\2\u00f7\u00f8\7\31\2\2\u00f8\u00f9\7\'\2\2\u00f9\u00fa\5.\30\2\u00fa"+
		"\u00fb\7(\2\2\u00fb\u00fc\5\b\5\2\u00fc+\3\2\2\2\u00fd\u00fe\b\27\1\2"+
		"\u00fe\u010a\5B\"\2\u00ff\u0101\78\2\2\u0100\u00ff\3\2\2\2\u0100\u0101"+
		"\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\7\'\2\2\u0103\u0104\5,\27\2\u0104"+
		"\u0105\7(\2\2\u0105\u010a\3\2\2\2\u0106\u010a\58\35\2\u0107\u010a\5\16"+
		"\b\2\u0108\u010a\7\f\2\2\u0109\u00fd\3\2\2\2\u0109\u0100\3\2\2\2\u0109"+
		"\u0106\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u0108\3\2\2\2\u010a\u0111\3\2"+
		"\2\2\u010b\u010c\f\b\2\2\u010c\u010d\5D#\2\u010d\u010e\5,\27\t\u010e\u0110"+
		"\3\2\2\2\u010f\u010b\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112-\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0126\7!\2\2\u0115"+
		"\u0118\5,\27\2\u0116\u0118\7!\2\2\u0117\u0115\3\2\2\2\u0117\u0116\3\2"+
		"\2\2\u0118\u0119\3\2\2\2\u0119\u011c\5F$\2\u011a\u011d\7!\2\2\u011b\u011d"+
		"\5,\27\2\u011c\u011a\3\2\2\2\u011c\u011b\3\2\2\2\u011d\u0126\3\2\2\2\u011e"+
		"\u0120\78\2\2\u011f\u011e\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\3\2"+
		"\2\2\u0121\u0122\7\'\2\2\u0122\u0123\5.\30\2\u0123\u0124\7(\2\2\u0124"+
		"\u0126\3\2\2\2\u0125\u0114\3\2\2\2\u0125\u0117\3\2\2\2\u0125\u011f\3\2"+
		"\2\2\u0126/\3\2\2\2\u0127\u0128\5<\37\2\u0128\u0129\58\35\2\u0129\u012a"+
		"\t\2\2\2\u012a\61\3\2\2\2\u012b\u012c\5> \2\u012c\u012d\58\35\2\u012d"+
		"\u0135\3\2\2\2\u012e\u012f\5> \2\u012f\u0130\5\66\34\2\u0130\u0135\3\2"+
		"\2\2\u0131\u0132\5> \2\u0132\u0133\5\64\33\2\u0133\u0135\3\2\2\2\u0134"+
		"\u012b\3\2\2\2\u0134\u012e\3\2\2\2\u0134\u0131\3\2\2\2\u0135\63\3\2\2"+
		"\2\u0136\u0137\58\35\2\u0137\u0138\7.\2\2\u0138\u013b\7%\2\2\u0139\u013c"+
		"\5,\27\2\u013a\u013c\5@!\2\u013b\u0139\3\2\2\2\u013b\u013a\3\2\2\2\u013c"+
		"\u0144\3\2\2\2\u013d\u0140\7*\2\2\u013e\u0141\5,\27\2\u013f\u0141\5@!"+
		"\2\u0140\u013e\3\2\2\2\u0140\u013f\3\2\2\2\u0141\u0143\3\2\2\2\u0142\u013d"+
		"\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"\u0147\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u0148\7&\2\2\u0148\65\3\2\2\2"+
		"\u0149\u014a\58\35\2\u014a\u014d\7.\2\2\u014b\u014e\5,\27\2\u014c\u014e"+
		"\5@!\2\u014d\u014b\3\2\2\2\u014d\u014c\3\2\2\2\u014e\67\3\2\2\2\u014f"+
		"\u0150\7=\2\2\u01509\3\2\2\2\u0151\u0152\7=\2\2\u0152;\3\2\2\2\u0153\u0154"+
		"\t\3\2\2\u0154=\3\2\2\2\u0155\u0156\t\4\2\2\u0156?\3\2\2\2\u0157\u0158"+
		"\t\5\2\2\u0158A\3\2\2\2\u0159\u015a\t\6\2\2\u015aC\3\2\2\2\u015b\u015c"+
		"\t\7\2\2\u015cE\3\2\2\2\u015d\u015e\t\b\2\2\u015eG\3\2\2\2#LN[bgtz\u0080"+
		"\u0085\u0089\u009f\u00a8\u00ac\u00bf\u00c4\u00cd\u00d8\u00da\u00e3\u00e9"+
		"\u00ed\u0100\u0109\u0111\u0117\u011c\u011f\u0125\u0134\u013b\u0140\u0144"+
		"\u014d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}