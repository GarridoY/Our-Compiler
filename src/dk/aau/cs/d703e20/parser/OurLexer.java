// Generated from C:/Users/the_p/Desktop/P7/src\OurLexer.g4 by ANTLR 4.8
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
		CLOCK=7, STRING=8, SUBSCRIPT=9, IPIN=10, OPIN=11, ANALOGPIN=12, VOID=13, 
		LOOP=14, SETUP=15, RETURN=16, IF=17, ELSE_IF=18, ELSE=19, TO=20, FOR=21, 
		WHILE=22, AT=23, BOUND=24, FINAL=25, DIGIT=26, DIGIT_NEGATIVE=27, DOUBLE_DIGIT=28, 
		DOUBLE_DIGIT_NEGATIVE=29, BOOL_LITERAL=30, STRING_LITERAL=31, LEFT_SQBRACKET=32, 
		RIGHT_SQBRACKET=33, LEFT_BRACKET=34, RIGHT_BRACKET=35, LEFT_PAREN=36, 
		RIGHT_PAREN=37, DOT=38, COMMA=39, SEMICOLON=40, QUESTION=41, COLON=42, 
		ASSIGN=43, ADD=44, SUB=45, MOD=46, DIV=47, MUL=48, EQUAL=49, AND=50, OR=51, 
		NOT_EQUAL=52, NOT=53, GREATER_THAN=54, GREATER_OR_EQUAL=55, LESS_THAN=56, 
		LESS_OR_EQUAL=57, ID=58, COMMENT_STRING=59, COMMENT_BLOCK=60, WS=61;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "INT_ARRAY", "BOOLEAN", "BOOLEAN_ARRAY", "DOUBLE", "DOUBLE_ARRAY", 
			"CLOCK", "STRING", "SUBSCRIPT", "IPIN", "OPIN", "ANALOGPIN", "VOID", 
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
			null, "'ipin'", "'opin'", null, "'void'", "'Loop'", "'Setup'", "'return'", 
			"'if'", "'else if'", "'else'", "'to'", "'for'", "'while'", "'at'", "'bound'", 
			"'final'", null, null, null, null, null, null, "'['", "']'", "'{'", "'}'", 
			"'('", "')'", "'.'", "','", "';'", "'?'", "':'", "'='", "'+'", "'-'", 
			"'%'", "'/'", "'*'", "'=='", "'&&'", "'||'", "'!='", "'!'", "'>'", "'>='", 
			"'<'", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "INT_ARRAY", "BOOLEAN", "BOOLEAN_ARRAY", "DOUBLE", "DOUBLE_ARRAY", 
			"CLOCK", "STRING", "SUBSCRIPT", "IPIN", "OPIN", "ANALOGPIN", "VOID", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2?\u01bc\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u008e"+
		"\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u009e"+
		"\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7\u00b2\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3"+
		"\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\6\35\u011f\n\35\r\35\16\35\u0120"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\6\36\u0129\n\36\r\36\16\36\u012a\3\36\3"+
		"\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0138\n\37\3 \3"+
		" \7 \u013c\n \f \16 \u013f\13 \3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3"+
		"&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60"+
		"\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65"+
		"\3\66\3\66\3\67\3\67\38\38\38\39\39\3:\3:\3:\3;\3;\3;\7;\u0180\n;\f;\16"+
		";\u0183\13;\3<\3<\3=\3=\3=\7=\u018a\n=\f=\16=\u018d\13=\5=\u018f\n=\3"+
		">\3>\3>\3>\3>\7>\u0196\n>\f>\16>\u0199\13>\3>\3>\3?\3?\3?\3?\7?\u01a1"+
		"\n?\f?\16?\u01a4\13?\3?\3?\3@\3@\3@\3@\7@\u01ac\n@\f@\16@\u01af\13@\3"+
		"@\3@\3@\3@\3@\3A\6A\u01b7\nA\rA\16A\u01b8\3A\3A\3\u01ad\2B\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w\2y\2"+
		"{\2}=\177>\u0081?\3\2\6\6\2\f\f\17\17$$^^\3\2C|\4\2\13\f\17\17\5\2\13"+
		"\f\17\17\"\"\2\u01c7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q"+
		"\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2"+
		"\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2"+
		"\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2}"+
		"\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\3\u0083\3\2\2\2\5\u0087\3\2\2\2"+
		"\7\u0091\3\2\2\2\t\u0096\3\2\2\2\13\u00a1\3\2\2\2\r\u00a8\3\2\2\2\17\u00b5"+
		"\3\2\2\2\21\u00bb\3\2\2\2\23\u00c2\3\2\2\2\25\u00c7\3\2\2\2\27\u00cc\3"+
		"\2\2\2\31\u00d1\3\2\2\2\33\u00d4\3\2\2\2\35\u00d9\3\2\2\2\37\u00de\3\2"+
		"\2\2!\u00e4\3\2\2\2#\u00eb\3\2\2\2%\u00ee\3\2\2\2\'\u00f6\3\2\2\2)\u00fb"+
		"\3\2\2\2+\u00fe\3\2\2\2-\u0102\3\2\2\2/\u0108\3\2\2\2\61\u010b\3\2\2\2"+
		"\63\u0111\3\2\2\2\65\u0117\3\2\2\2\67\u0119\3\2\2\29\u011b\3\2\2\2;\u0122"+
		"\3\2\2\2=\u0137\3\2\2\2?\u0139\3\2\2\2A\u0142\3\2\2\2C\u0144\3\2\2\2E"+
		"\u0146\3\2\2\2G\u0148\3\2\2\2I\u014a\3\2\2\2K\u014c\3\2\2\2M\u014e\3\2"+
		"\2\2O\u0150\3\2\2\2Q\u0152\3\2\2\2S\u0154\3\2\2\2U\u0156\3\2\2\2W\u0158"+
		"\3\2\2\2Y\u015a\3\2\2\2[\u015c\3\2\2\2]\u015e\3\2\2\2_\u0160\3\2\2\2a"+
		"\u0162\3\2\2\2c\u0164\3\2\2\2e\u0167\3\2\2\2g\u016a\3\2\2\2i\u016d\3\2"+
		"\2\2k\u0170\3\2\2\2m\u0172\3\2\2\2o\u0174\3\2\2\2q\u0177\3\2\2\2s\u0179"+
		"\3\2\2\2u\u017c\3\2\2\2w\u0184\3\2\2\2y\u018e\3\2\2\2{\u0190\3\2\2\2}"+
		"\u019c\3\2\2\2\177\u01a7\3\2\2\2\u0081\u01b6\3\2\2\2\u0083\u0084\7k\2"+
		"\2\u0084\u0085\7p\2\2\u0085\u0086\7v\2\2\u0086\4\3\2\2\2\u0087\u0088\7"+
		"k\2\2\u0088\u0089\7p\2\2\u0089\u008a\7v\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\u008d\7]\2\2\u008c\u008e\5\65\33\2\u008d\u008c\3\2\2\2\u008d\u008e\3"+
		"\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\7_\2\2\u0090\6\3\2\2\2\u0091\u0092"+
		"\7d\2\2\u0092\u0093\7q\2\2\u0093\u0094\7q\2\2\u0094\u0095\7n\2\2\u0095"+
		"\b\3\2\2\2\u0096\u0097\7d\2\2\u0097\u0098\7q\2\2\u0098\u0099\7q\2\2\u0099"+
		"\u009a\7n\2\2\u009a\u009b\3\2\2\2\u009b\u009d\7]\2\2\u009c\u009e\5\65"+
		"\33\2\u009d\u009c\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a0\7_\2\2\u00a0\n\3\2\2\2\u00a1\u00a2\7f\2\2\u00a2\u00a3\7q\2\2\u00a3"+
		"\u00a4\7w\2\2\u00a4\u00a5\7d\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7\7g\2\2"+
		"\u00a7\f\3\2\2\2\u00a8\u00a9\7f\2\2\u00a9\u00aa\7q\2\2\u00aa\u00ab\7w"+
		"\2\2\u00ab\u00ac\7d\2\2\u00ac\u00ad\7n\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af"+
		"\3\2\2\2\u00af\u00b1\7]\2\2\u00b0\u00b2\5\65\33\2\u00b1\u00b0\3\2\2\2"+
		"\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7_\2\2\u00b4\16\3"+
		"\2\2\2\u00b5\u00b6\7e\2\2\u00b6\u00b7\7n\2\2\u00b7\u00b8\7q\2\2\u00b8"+
		"\u00b9\7e\2\2\u00b9\u00ba\7m\2\2\u00ba\20\3\2\2\2\u00bb\u00bc\7u\2\2\u00bc"+
		"\u00bd\7v\2\2\u00bd\u00be\7t\2\2\u00be\u00bf\7k\2\2\u00bf\u00c0\7p\2\2"+
		"\u00c0\u00c1\7i\2\2\u00c1\22\3\2\2\2\u00c2\u00c3\5u;\2\u00c3\u00c4\7]"+
		"\2\2\u00c4\u00c5\5\65\33\2\u00c5\u00c6\7_\2\2\u00c6\24\3\2\2\2\u00c7\u00c8"+
		"\7k\2\2\u00c8\u00c9\7r\2\2\u00c9\u00ca\7k\2\2\u00ca\u00cb\7p\2\2\u00cb"+
		"\26\3\2\2\2\u00cc\u00cd\7q\2\2\u00cd\u00ce\7r\2\2\u00ce\u00cf\7k\2\2\u00cf"+
		"\u00d0\7p\2\2\u00d0\30\3\2\2\2\u00d1\u00d2\7C\2\2\u00d2\u00d3\5\65\33"+
		"\2\u00d3\32\3\2\2\2\u00d4\u00d5\7x\2\2\u00d5\u00d6\7q\2\2\u00d6\u00d7"+
		"\7k\2\2\u00d7\u00d8\7f\2\2\u00d8\34\3\2\2\2\u00d9\u00da\7N\2\2\u00da\u00db"+
		"\7q\2\2\u00db\u00dc\7q\2\2\u00dc\u00dd\7r\2\2\u00dd\36\3\2\2\2\u00de\u00df"+
		"\7U\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7v\2\2\u00e1\u00e2\7w\2\2\u00e2"+
		"\u00e3\7r\2\2\u00e3 \3\2\2\2\u00e4\u00e5\7t\2\2\u00e5\u00e6\7g\2\2\u00e6"+
		"\u00e7\7v\2\2\u00e7\u00e8\7w\2\2\u00e8\u00e9\7t\2\2\u00e9\u00ea\7p\2\2"+
		"\u00ea\"\3\2\2\2\u00eb\u00ec\7k\2\2\u00ec\u00ed\7h\2\2\u00ed$\3\2\2\2"+
		"\u00ee\u00ef\7g\2\2\u00ef\u00f0\7n\2\2\u00f0\u00f1\7u\2\2\u00f1\u00f2"+
		"\7g\2\2\u00f2\u00f3\7\"\2\2\u00f3\u00f4\7k\2\2\u00f4\u00f5\7h\2\2\u00f5"+
		"&\3\2\2\2\u00f6\u00f7\7g\2\2\u00f7\u00f8\7n\2\2\u00f8\u00f9\7u\2\2\u00f9"+
		"\u00fa\7g\2\2\u00fa(\3\2\2\2\u00fb\u00fc\7v\2\2\u00fc\u00fd\7q\2\2\u00fd"+
		"*\3\2\2\2\u00fe\u00ff\7h\2\2\u00ff\u0100\7q\2\2\u0100\u0101\7t\2\2\u0101"+
		",\3\2\2\2\u0102\u0103\7y\2\2\u0103\u0104\7j\2\2\u0104\u0105\7k\2\2\u0105"+
		"\u0106\7n\2\2\u0106\u0107\7g\2\2\u0107.\3\2\2\2\u0108\u0109\7c\2\2\u0109"+
		"\u010a\7v\2\2\u010a\60\3\2\2\2\u010b\u010c\7d\2\2\u010c\u010d\7q\2\2\u010d"+
		"\u010e\7w\2\2\u010e\u010f\7p\2\2\u010f\u0110\7f\2\2\u0110\62\3\2\2\2\u0111"+
		"\u0112\7h\2\2\u0112\u0113\7k\2\2\u0113\u0114\7p\2\2\u0114\u0115\7c\2\2"+
		"\u0115\u0116\7n\2\2\u0116\64\3\2\2\2\u0117\u0118\5y=\2\u0118\66\3\2\2"+
		"\2\u0119\u011a\5{>\2\u011a8\3\2\2\2\u011b\u011c\5\65\33\2\u011c\u011e"+
		"\7\60\2\2\u011d\u011f\5\65\33\2\u011e\u011d\3\2\2\2\u011f\u0120\3\2\2"+
		"\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121:\3\2\2\2\u0122\u0123"+
		"\7*\2\2\u0123\u0124\7/\2\2\u0124\u0125\3\2\2\2\u0125\u0126\5\65\33\2\u0126"+
		"\u0128\7\60\2\2\u0127\u0129\5\65\33\2\u0128\u0127\3\2\2\2\u0129\u012a"+
		"\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012c\3\2\2\2\u012c"+
		"\u012d\7+\2\2\u012d<\3\2\2\2\u012e\u012f\7v\2\2\u012f\u0130\7t\2\2\u0130"+
		"\u0131\7w\2\2\u0131\u0138\7g\2\2\u0132\u0133\7h\2\2\u0133\u0134\7c\2\2"+
		"\u0134\u0135\7n\2\2\u0135\u0136\7u\2\2\u0136\u0138\7g\2\2\u0137\u012e"+
		"\3\2\2\2\u0137\u0132\3\2\2\2\u0138>\3\2\2\2\u0139\u013d\7$\2\2\u013a\u013c"+
		"\n\2\2\2\u013b\u013a\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e\u0140\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0141\7$"+
		"\2\2\u0141@\3\2\2\2\u0142\u0143\7]\2\2\u0143B\3\2\2\2\u0144\u0145\7_\2"+
		"\2\u0145D\3\2\2\2\u0146\u0147\7}\2\2\u0147F\3\2\2\2\u0148\u0149\7\177"+
		"\2\2\u0149H\3\2\2\2\u014a\u014b\7*\2\2\u014bJ\3\2\2\2\u014c\u014d\7+\2"+
		"\2\u014dL\3\2\2\2\u014e\u014f\7\60\2\2\u014fN\3\2\2\2\u0150\u0151\7.\2"+
		"\2\u0151P\3\2\2\2\u0152\u0153\7=\2\2\u0153R\3\2\2\2\u0154\u0155\7A\2\2"+
		"\u0155T\3\2\2\2\u0156\u0157\7<\2\2\u0157V\3\2\2\2\u0158\u0159\7?\2\2\u0159"+
		"X\3\2\2\2\u015a\u015b\7-\2\2\u015bZ\3\2\2\2\u015c\u015d\7/\2\2\u015d\\"+
		"\3\2\2\2\u015e\u015f\7\'\2\2\u015f^\3\2\2\2\u0160\u0161\7\61\2\2\u0161"+
		"`\3\2\2\2\u0162\u0163\7,\2\2\u0163b\3\2\2\2\u0164\u0165\7?\2\2\u0165\u0166"+
		"\7?\2\2\u0166d\3\2\2\2\u0167\u0168\7(\2\2\u0168\u0169\7(\2\2\u0169f\3"+
		"\2\2\2\u016a\u016b\7~\2\2\u016b\u016c\7~\2\2\u016ch\3\2\2\2\u016d\u016e"+
		"\7#\2\2\u016e\u016f\7?\2\2\u016fj\3\2\2\2\u0170\u0171\7#\2\2\u0171l\3"+
		"\2\2\2\u0172\u0173\7@\2\2\u0173n\3\2\2\2\u0174\u0175\7@\2\2\u0175\u0176"+
		"\7?\2\2\u0176p\3\2\2\2\u0177\u0178\7>\2\2\u0178r\3\2\2\2\u0179\u017a\7"+
		">\2\2\u017a\u017b\7?\2\2\u017bt\3\2\2\2\u017c\u0181\5w<\2\u017d\u0180"+
		"\5w<\2\u017e\u0180\5\65\33\2\u017f\u017d\3\2\2\2\u017f\u017e\3\2\2\2\u0180"+
		"\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182v\3\2\2\2"+
		"\u0183\u0181\3\2\2\2\u0184\u0185\t\3\2\2\u0185x\3\2\2\2\u0186\u018f\7"+
		"\62\2\2\u0187\u018b\4\63;\2\u0188\u018a\4\62;\2\u0189\u0188\3\2\2\2\u018a"+
		"\u018d\3\2\2\2\u018b\u0189\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018f\3\2"+
		"\2\2\u018d\u018b\3\2\2\2\u018e\u0186\3\2\2\2\u018e\u0187\3\2\2\2\u018f"+
		"z\3\2\2\2\u0190\u0191\7*\2\2\u0191\u0192\7/\2\2\u0192\u0193\3\2\2\2\u0193"+
		"\u0197\4\63;\2\u0194\u0196\4\62;\2\u0195\u0194\3\2\2\2\u0196\u0199\3\2"+
		"\2\2\u0197\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u019a\3\2\2\2\u0199"+
		"\u0197\3\2\2\2\u019a\u019b\7+\2\2\u019b|\3\2\2\2\u019c\u019d\7\61\2\2"+
		"\u019d\u019e\7\61\2\2\u019e\u01a2\3\2\2\2\u019f\u01a1\n\4\2\2\u01a0\u019f"+
		"\3\2\2\2\u01a1\u01a4\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3"+
		"\u01a5\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a5\u01a6\b?\2\2\u01a6~\3\2\2\2\u01a7"+
		"\u01a8\7\61\2\2\u01a8\u01a9\7,\2\2\u01a9\u01ad\3\2\2\2\u01aa\u01ac\13"+
		"\2\2\2\u01ab\u01aa\3\2\2\2\u01ac\u01af\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ad"+
		"\u01ab\3\2\2\2\u01ae\u01b0\3\2\2\2\u01af\u01ad\3\2\2\2\u01b0\u01b1\7,"+
		"\2\2\u01b1\u01b2\7\61\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b4\b@\2\2\u01b4"+
		"\u0080\3\2\2\2\u01b5\u01b7\t\5\2\2\u01b6\u01b5\3\2\2\2\u01b7\u01b8\3\2"+
		"\2\2\u01b8\u01b6\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba"+
		"\u01bb\bA\2\2\u01bb\u0082\3\2\2\2\22\2\u008d\u009d\u00b1\u0120\u012a\u0137"+
		"\u013d\u017f\u0181\u018b\u018e\u0197\u01a2\u01ad\u01b8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}