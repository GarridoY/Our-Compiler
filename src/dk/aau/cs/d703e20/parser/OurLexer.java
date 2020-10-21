// Generated from C:/Users/the_p/Documents/GitHub/P7/src\OurLexer.g4 by ANTLR 4.8
package dk.aau.cs.d703e20.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OurLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "INT_ARRAY", "BOOLEAN", "BOOLEAN_ARRAY", "DOUBLE", "DOUBLE_ARRAY", 
			"CLOCK", "STRING", "PIT", "SUBSCRIPT", "IPIN", "OPIN", "ANALOGPIN", "VOID", 
			"LOOP", "SETUP", "RETURN", "IF", "ELSE_IF", "ELSE", "TO", "FOR", "WHILE", 
			"AT", "BOUND", "FINAL", "DIGIT", "DIGIT_NEGATIVE", "DOUBLE_DIGIT", "DOUBLE_DIGIT_NEGATIVE", 
			"BOOL_LITERAL", "STRING_LITERAL", "LEFT_SQBRACKET", "RIGHT_SQBRACKET", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", "DOT", 
			"COMMA", "SEMICOLON", "QUESTION", "COLON", "ASSIGN", "ADD", "SUB", "MOD", 
			"DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", "NOT", "GREATER_THAN", 
			"GREATER_OR_EQUAL", "LESS_THAN", "LESS_OR_EQUAL", "ID", "LETTER", "DIGIT_RULE", 
			"DIGIT_NEGATIVE_RULE", "COMMENT_STRING", "COMMENT_BLOCK", "WS"
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


	public OurLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "OurLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2@\u01c1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\7\3\u0090\n\3\f\3\16\3\u0093\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\6\36\u0124"+
		"\n\36\r\36\16\36\u0125\3\37\3\37\3\37\3\37\3\37\3\37\6\37\u012e\n\37\r"+
		"\37\16\37\u012f\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u013d\n \3!\3"+
		"!\7!\u0141\n!\f!\16!\u0144\13!\3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3"+
		"\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61"+
		"\3\61\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66"+
		"\3\66\3\67\3\67\38\38\39\39\39\3:\3:\3;\3;\3;\3<\3<\3<\7<\u0185\n<\f<"+
		"\16<\u0188\13<\3=\3=\3>\3>\3>\7>\u018f\n>\f>\16>\u0192\13>\5>\u0194\n"+
		">\3?\3?\3?\3?\3?\7?\u019b\n?\f?\16?\u019e\13?\3?\3?\3@\3@\3@\3@\7@\u01a6"+
		"\n@\f@\16@\u01a9\13@\3@\3@\3A\3A\3A\3A\7A\u01b1\nA\fA\16A\u01b4\13A\3"+
		"A\3A\3A\3A\3A\3B\6B\u01bc\nB\rB\16B\u01bd\3B\3B\3\u01b2\2C\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y\2"+
		"{\2}\2\177>\u0081?\u0083@\3\2\6\6\2\f\f\17\17$$^^\3\2C|\4\2\13\f\17\17"+
		"\5\2\13\f\17\17\"\"\2\u01ca\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2"+
		"\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2"+
		"\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i"+
		"\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2"+
		"\2\2\2w\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\3\u0085"+
		"\3\2\2\2\5\u0089\3\2\2\2\7\u0096\3\2\2\2\t\u009b\3\2\2\2\13\u00a4\3\2"+
		"\2\2\r\u00ab\3\2\2\2\17\u00b6\3\2\2\2\21\u00bc\3\2\2\2\23\u00c3\3\2\2"+
		"\2\25\u00c7\3\2\2\2\27\u00cc\3\2\2\2\31\u00d1\3\2\2\2\33\u00d6\3\2\2\2"+
		"\35\u00d9\3\2\2\2\37\u00de\3\2\2\2!\u00e3\3\2\2\2#\u00e9\3\2\2\2%\u00f0"+
		"\3\2\2\2\'\u00f3\3\2\2\2)\u00fb\3\2\2\2+\u0100\3\2\2\2-\u0103\3\2\2\2"+
		"/\u0107\3\2\2\2\61\u010d\3\2\2\2\63\u0110\3\2\2\2\65\u0116\3\2\2\2\67"+
		"\u011c\3\2\2\29\u011e\3\2\2\2;\u0120\3\2\2\2=\u0127\3\2\2\2?\u013c\3\2"+
		"\2\2A\u013e\3\2\2\2C\u0147\3\2\2\2E\u0149\3\2\2\2G\u014b\3\2\2\2I\u014d"+
		"\3\2\2\2K\u014f\3\2\2\2M\u0151\3\2\2\2O\u0153\3\2\2\2Q\u0155\3\2\2\2S"+
		"\u0157\3\2\2\2U\u0159\3\2\2\2W\u015b\3\2\2\2Y\u015d\3\2\2\2[\u015f\3\2"+
		"\2\2]\u0161\3\2\2\2_\u0163\3\2\2\2a\u0165\3\2\2\2c\u0167\3\2\2\2e\u0169"+
		"\3\2\2\2g\u016c\3\2\2\2i\u016f\3\2\2\2k\u0172\3\2\2\2m\u0175\3\2\2\2o"+
		"\u0177\3\2\2\2q\u0179\3\2\2\2s\u017c\3\2\2\2u\u017e\3\2\2\2w\u0181\3\2"+
		"\2\2y\u0189\3\2\2\2{\u0193\3\2\2\2}\u0195\3\2\2\2\177\u01a1\3\2\2\2\u0081"+
		"\u01ac\3\2\2\2\u0083\u01bb\3\2\2\2\u0085\u0086\7k\2\2\u0086\u0087\7p\2"+
		"\2\u0087\u0088\7v\2\2\u0088\4\3\2\2\2\u0089\u008a\7k\2\2\u008a\u008b\7"+
		"p\2\2\u008b\u008c\7v\2\2\u008c\u008d\3\2\2\2\u008d\u0091\7]\2\2\u008e"+
		"\u0090\5\67\34\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3"+
		"\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094"+
		"\u0095\7_\2\2\u0095\6\3\2\2\2\u0096\u0097\7d\2\2\u0097\u0098\7q\2\2\u0098"+
		"\u0099\7q\2\2\u0099\u009a\7n\2\2\u009a\b\3\2\2\2\u009b\u009c\7d\2\2\u009c"+
		"\u009d\7q\2\2\u009d\u009e\7q\2\2\u009e\u009f\7n\2\2\u009f\u00a0\3\2\2"+
		"\2\u00a0\u00a1\7]\2\2\u00a1\u00a2\5\67\34\2\u00a2\u00a3\7_\2\2\u00a3\n"+
		"\3\2\2\2\u00a4\u00a5\7f\2\2\u00a5\u00a6\7q\2\2\u00a6\u00a7\7w\2\2\u00a7"+
		"\u00a8\7d\2\2\u00a8\u00a9\7n\2\2\u00a9\u00aa\7g\2\2\u00aa\f\3\2\2\2\u00ab"+
		"\u00ac\7f\2\2\u00ac\u00ad\7q\2\2\u00ad\u00ae\7w\2\2\u00ae\u00af\7d\2\2"+
		"\u00af\u00b0\7n\2\2\u00b0\u00b1\7g\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3"+
		"\7]\2\2\u00b3\u00b4\5\67\34\2\u00b4\u00b5\7_\2\2\u00b5\16\3\2\2\2\u00b6"+
		"\u00b7\7e\2\2\u00b7\u00b8\7n\2\2\u00b8\u00b9\7q\2\2\u00b9\u00ba\7e\2\2"+
		"\u00ba\u00bb\7m\2\2\u00bb\20\3\2\2\2\u00bc\u00bd\7u\2\2\u00bd\u00be\7"+
		"v\2\2\u00be\u00bf\7t\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1\7p\2\2\u00c1\u00c2"+
		"\7i\2\2\u00c2\22\3\2\2\2\u00c3\u00c4\7r\2\2\u00c4\u00c5\7k\2\2\u00c5\u00c6"+
		"\7v\2\2\u00c6\24\3\2\2\2\u00c7\u00c8\5w<\2\u00c8\u00c9\7]\2\2\u00c9\u00ca"+
		"\5\67\34\2\u00ca\u00cb\7_\2\2\u00cb\26\3\2\2\2\u00cc\u00cd\7k\2\2\u00cd"+
		"\u00ce\7r\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0\7p\2\2\u00d0\30\3\2\2\2\u00d1"+
		"\u00d2\7q\2\2\u00d2\u00d3\7r\2\2\u00d3\u00d4\7k\2\2\u00d4\u00d5\7p\2\2"+
		"\u00d5\32\3\2\2\2\u00d6\u00d7\7C\2\2\u00d7\u00d8\5\67\34\2\u00d8\34\3"+
		"\2\2\2\u00d9\u00da\7x\2\2\u00da\u00db\7q\2\2\u00db\u00dc\7k\2\2\u00dc"+
		"\u00dd\7f\2\2\u00dd\36\3\2\2\2\u00de\u00df\7N\2\2\u00df\u00e0\7q\2\2\u00e0"+
		"\u00e1\7q\2\2\u00e1\u00e2\7r\2\2\u00e2 \3\2\2\2\u00e3\u00e4\7U\2\2\u00e4"+
		"\u00e5\7g\2\2\u00e5\u00e6\7v\2\2\u00e6\u00e7\7w\2\2\u00e7\u00e8\7r\2\2"+
		"\u00e8\"\3\2\2\2\u00e9\u00ea\7t\2\2\u00ea\u00eb\7g\2\2\u00eb\u00ec\7v"+
		"\2\2\u00ec\u00ed\7w\2\2\u00ed\u00ee\7t\2\2\u00ee\u00ef\7p\2\2\u00ef$\3"+
		"\2\2\2\u00f0\u00f1\7k\2\2\u00f1\u00f2\7h\2\2\u00f2&\3\2\2\2\u00f3\u00f4"+
		"\7g\2\2\u00f4\u00f5\7n\2\2\u00f5\u00f6\7u\2\2\u00f6\u00f7\7g\2\2\u00f7"+
		"\u00f8\7\"\2\2\u00f8\u00f9\7k\2\2\u00f9\u00fa\7h\2\2\u00fa(\3\2\2\2\u00fb"+
		"\u00fc\7g\2\2\u00fc\u00fd\7n\2\2\u00fd\u00fe\7u\2\2\u00fe\u00ff\7g\2\2"+
		"\u00ff*\3\2\2\2\u0100\u0101\7v\2\2\u0101\u0102\7q\2\2\u0102,\3\2\2\2\u0103"+
		"\u0104\7h\2\2\u0104\u0105\7q\2\2\u0105\u0106\7t\2\2\u0106.\3\2\2\2\u0107"+
		"\u0108\7y\2\2\u0108\u0109\7j\2\2\u0109\u010a\7k\2\2\u010a\u010b\7n\2\2"+
		"\u010b\u010c\7g\2\2\u010c\60\3\2\2\2\u010d\u010e\7c\2\2\u010e\u010f\7"+
		"v\2\2\u010f\62\3\2\2\2\u0110\u0111\7d\2\2\u0111\u0112\7q\2\2\u0112\u0113"+
		"\7w\2\2\u0113\u0114\7p\2\2\u0114\u0115\7f\2\2\u0115\64\3\2\2\2\u0116\u0117"+
		"\7h\2\2\u0117\u0118\7k\2\2\u0118\u0119\7p\2\2\u0119\u011a\7c\2\2\u011a"+
		"\u011b\7n\2\2\u011b\66\3\2\2\2\u011c\u011d\5{>\2\u011d8\3\2\2\2\u011e"+
		"\u011f\5}?\2\u011f:\3\2\2\2\u0120\u0121\5\67\34\2\u0121\u0123\7\60\2\2"+
		"\u0122\u0124\5\67\34\2\u0123\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0123"+
		"\3\2\2\2\u0125\u0126\3\2\2\2\u0126<\3\2\2\2\u0127\u0128\7*\2\2\u0128\u0129"+
		"\7/\2\2\u0129\u012a\3\2\2\2\u012a\u012b\5\67\34\2\u012b\u012d\7\60\2\2"+
		"\u012c\u012e\5\67\34\2\u012d\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u012d"+
		"\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\7+\2\2\u0132"+
		">\3\2\2\2\u0133\u0134\7v\2\2\u0134\u0135\7t\2\2\u0135\u0136\7w\2\2\u0136"+
		"\u013d\7g\2\2\u0137\u0138\7h\2\2\u0138\u0139\7c\2\2\u0139\u013a\7n\2\2"+
		"\u013a\u013b\7u\2\2\u013b\u013d\7g\2\2\u013c\u0133\3\2\2\2\u013c\u0137"+
		"\3\2\2\2\u013d@\3\2\2\2\u013e\u0142\7$\2\2\u013f\u0141\n\2\2\2\u0140\u013f"+
		"\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143"+
		"\u0145\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u0146\7$\2\2\u0146B\3\2\2\2\u0147"+
		"\u0148\7]\2\2\u0148D\3\2\2\2\u0149\u014a\7_\2\2\u014aF\3\2\2\2\u014b\u014c"+
		"\7}\2\2\u014cH\3\2\2\2\u014d\u014e\7\177\2\2\u014eJ\3\2\2\2\u014f\u0150"+
		"\7*\2\2\u0150L\3\2\2\2\u0151\u0152\7+\2\2\u0152N\3\2\2\2\u0153\u0154\7"+
		"\60\2\2\u0154P\3\2\2\2\u0155\u0156\7.\2\2\u0156R\3\2\2\2\u0157\u0158\7"+
		"=\2\2\u0158T\3\2\2\2\u0159\u015a\7A\2\2\u015aV\3\2\2\2\u015b\u015c\7<"+
		"\2\2\u015cX\3\2\2\2\u015d\u015e\7?\2\2\u015eZ\3\2\2\2\u015f\u0160\7-\2"+
		"\2\u0160\\\3\2\2\2\u0161\u0162\7/\2\2\u0162^\3\2\2\2\u0163\u0164\7\'\2"+
		"\2\u0164`\3\2\2\2\u0165\u0166\7\61\2\2\u0166b\3\2\2\2\u0167\u0168\7,\2"+
		"\2\u0168d\3\2\2\2\u0169\u016a\7?\2\2\u016a\u016b\7?\2\2\u016bf\3\2\2\2"+
		"\u016c\u016d\7(\2\2\u016d\u016e\7(\2\2\u016eh\3\2\2\2\u016f\u0170\7~\2"+
		"\2\u0170\u0171\7~\2\2\u0171j\3\2\2\2\u0172\u0173\7#\2\2\u0173\u0174\7"+
		"?\2\2\u0174l\3\2\2\2\u0175\u0176\7#\2\2\u0176n\3\2\2\2\u0177\u0178\7@"+
		"\2\2\u0178p\3\2\2\2\u0179\u017a\7@\2\2\u017a\u017b\7?\2\2\u017br\3\2\2"+
		"\2\u017c\u017d\7>\2\2\u017dt\3\2\2\2\u017e\u017f\7>\2\2\u017f\u0180\7"+
		"?\2\2\u0180v\3\2\2\2\u0181\u0186\5y=\2\u0182\u0185\5y=\2\u0183\u0185\5"+
		"\67\34\2\u0184\u0182\3\2\2\2\u0184\u0183\3\2\2\2\u0185\u0188\3\2\2\2\u0186"+
		"\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187x\3\2\2\2\u0188\u0186\3\2\2\2"+
		"\u0189\u018a\t\3\2\2\u018az\3\2\2\2\u018b\u0194\7\62\2\2\u018c\u0190\4"+
		"\63;\2\u018d\u018f\4\62;\2\u018e\u018d\3\2\2\2\u018f\u0192\3\2\2\2\u0190"+
		"\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0194\3\2\2\2\u0192\u0190\3\2"+
		"\2\2\u0193\u018b\3\2\2\2\u0193\u018c\3\2\2\2\u0194|\3\2\2\2\u0195\u0196"+
		"\7*\2\2\u0196\u0197\7/\2\2\u0197\u0198\3\2\2\2\u0198\u019c\4\63;\2\u0199"+
		"\u019b\4\62;\2\u019a\u0199\3\2\2\2\u019b\u019e\3\2\2\2\u019c\u019a\3\2"+
		"\2\2\u019c\u019d\3\2\2\2\u019d\u019f\3\2\2\2\u019e\u019c\3\2\2\2\u019f"+
		"\u01a0\7+\2\2\u01a0~\3\2\2\2\u01a1\u01a2\7\61\2\2\u01a2\u01a3\7\61\2\2"+
		"\u01a3\u01a7\3\2\2\2\u01a4\u01a6\n\4\2\2\u01a5\u01a4\3\2\2\2\u01a6\u01a9"+
		"\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01aa\3\2\2\2\u01a9"+
		"\u01a7\3\2\2\2\u01aa\u01ab\b@\2\2\u01ab\u0080\3\2\2\2\u01ac\u01ad\7\61"+
		"\2\2\u01ad\u01ae\7,\2\2\u01ae\u01b2\3\2\2\2\u01af\u01b1\13\2\2\2\u01b0"+
		"\u01af\3\2\2\2\u01b1\u01b4\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b2\u01b0\3\2"+
		"\2\2\u01b3\u01b5\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b5\u01b6\7,\2\2\u01b6"+
		"\u01b7\7\61\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b9\bA\2\2\u01b9\u0082\3\2"+
		"\2\2\u01ba\u01bc\t\5\2\2\u01bb\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd"+
		"\u01bb\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c0\bB"+
		"\2\2\u01c0\u0084\3\2\2\2\20\2\u0091\u0125\u012f\u013c\u0142\u0184\u0186"+
		"\u0190\u0193\u019c\u01a7\u01b2\u01bd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}