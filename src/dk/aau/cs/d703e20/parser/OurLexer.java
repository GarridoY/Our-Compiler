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
		FOR=22, WHILE=23, AT=24, DIGIT=25, DIGIT_NEGATIVE=26, DOUBLE_DIGIT=27, 
		DOUBLE_DIGIT_NEGATIVE=28, BOOL_LITERAL=29, STRING_LITERAL=30, LEFT_SQBRACKET=31, 
		RIGHT_SQBRACKET=32, LEFT_BRACKET=33, RIGHT_BRACKET=34, LEFT_PAREN=35, 
		RIGHT_PAREN=36, DOT=37, COMMA=38, SEMICOLON=39, QUESTION=40, COLON=41, 
		ASSIGN=42, ADD=43, SUB=44, MOD=45, DIV=46, MUL=47, EQUAL=48, AND=49, OR=50, 
		NOT_EQUAL=51, NOT=52, GREATER_THAN=53, GREATER_OR_EQUAL=54, LESS_THAN=55, 
		LESS_OR_EQUAL=56, ID=57, COMMENT_STRING=58, COMMENT_BLOCK=59, WS=60;
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
			"AT", "DIGIT", "DIGIT_NEGATIVE", "DOUBLE_DIGIT", "DOUBLE_DIGIT_NEGATIVE", 
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
			"'at'", null, null, null, null, null, null, "'['", "']'", "'{'", "'}'", 
			"'('", "')'", "'.'", "','", "';'", "'?'", "':'", "'='", "'+'", "'-'", 
			"'%'", "'/'", "'*'", "'=='", "'&&'", "'||'", "'!='", "'!'", "'>'", "'>='", 
			"'<'", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "INT_ARRAY", "BOOLEAN", "BOOLEAN_ARRAY", "DOUBLE", "DOUBLE_ARRAY", 
			"CLOCK", "STRING", "PIT", "SUBSCRIPT", "IPIN", "OPIN", "ANALOGPIN", "VOID", 
			"LOOP", "SETUP", "RETURN", "IF", "ELSE_IF", "ELSE", "TO", "FOR", "WHILE", 
			"AT", "DIGIT", "DIGIT_NEGATIVE", "DOUBLE_DIGIT", "DOUBLE_DIGIT_NEGATIVE", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2>\u01b2\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u008c\n"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u009c\n"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\5\7\u00b0\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\6\34"+
		"\u0115\n\34\r\34\16\34\u0116\3\35\3\35\3\35\3\35\3\35\3\35\6\35\u011f"+
		"\n\35\r\35\16\35\u0120\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\5\36\u012e\n\36\3\37\3\37\7\37\u0132\n\37\f\37\16\37\u0135\13"+
		"\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3"+
		"(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\61\3"+
		"\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3"+
		"\67\3\67\38\38\39\39\39\3:\3:\3:\7:\u0176\n:\f:\16:\u0179\13:\3;\3;\3"+
		"<\3<\3<\7<\u0180\n<\f<\16<\u0183\13<\5<\u0185\n<\3=\3=\3=\3=\3=\7=\u018c"+
		"\n=\f=\16=\u018f\13=\3=\3=\3>\3>\3>\3>\7>\u0197\n>\f>\16>\u019a\13>\3"+
		">\3>\3?\3?\3?\3?\7?\u01a2\n?\f?\16?\u01a5\13?\3?\3?\3?\3?\3?\3@\6@\u01ad"+
		"\n@\r@\16@\u01ae\3@\3@\3\u01a3\2A\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60"+
		"_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u\2w\2y\2{<}=\177>\3\2\6\6\2\f\f\17"+
		"\17$$^^\3\2C|\4\2\13\f\17\17\5\2\13\f\17\17\"\"\2\u01bd\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3"+
		"\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2"+
		"\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2"+
		"q\3\2\2\2\2s\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\3\u0081\3\2\2"+
		"\2\5\u0085\3\2\2\2\7\u008f\3\2\2\2\t\u0094\3\2\2\2\13\u009f\3\2\2\2\r"+
		"\u00a6\3\2\2\2\17\u00b3\3\2\2\2\21\u00b9\3\2\2\2\23\u00c0\3\2\2\2\25\u00c4"+
		"\3\2\2\2\27\u00c9\3\2\2\2\31\u00ce\3\2\2\2\33\u00d3\3\2\2\2\35\u00d6\3"+
		"\2\2\2\37\u00db\3\2\2\2!\u00e0\3\2\2\2#\u00e6\3\2\2\2%\u00ed\3\2\2\2\'"+
		"\u00f0\3\2\2\2)\u00f8\3\2\2\2+\u00fd\3\2\2\2-\u0100\3\2\2\2/\u0104\3\2"+
		"\2\2\61\u010a\3\2\2\2\63\u010d\3\2\2\2\65\u010f\3\2\2\2\67\u0111\3\2\2"+
		"\29\u0118\3\2\2\2;\u012d\3\2\2\2=\u012f\3\2\2\2?\u0138\3\2\2\2A\u013a"+
		"\3\2\2\2C\u013c\3\2\2\2E\u013e\3\2\2\2G\u0140\3\2\2\2I\u0142\3\2\2\2K"+
		"\u0144\3\2\2\2M\u0146\3\2\2\2O\u0148\3\2\2\2Q\u014a\3\2\2\2S\u014c\3\2"+
		"\2\2U\u014e\3\2\2\2W\u0150\3\2\2\2Y\u0152\3\2\2\2[\u0154\3\2\2\2]\u0156"+
		"\3\2\2\2_\u0158\3\2\2\2a\u015a\3\2\2\2c\u015d\3\2\2\2e\u0160\3\2\2\2g"+
		"\u0163\3\2\2\2i\u0166\3\2\2\2k\u0168\3\2\2\2m\u016a\3\2\2\2o\u016d\3\2"+
		"\2\2q\u016f\3\2\2\2s\u0172\3\2\2\2u\u017a\3\2\2\2w\u0184\3\2\2\2y\u0186"+
		"\3\2\2\2{\u0192\3\2\2\2}\u019d\3\2\2\2\177\u01ac\3\2\2\2\u0081\u0082\7"+
		"k\2\2\u0082\u0083\7p\2\2\u0083\u0084\7v\2\2\u0084\4\3\2\2\2\u0085\u0086"+
		"\7k\2\2\u0086\u0087\7p\2\2\u0087\u0088\7v\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u008b\7]\2\2\u008a\u008c\5\63\32\2\u008b\u008a\3\2\2\2\u008b\u008c\3"+
		"\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\7_\2\2\u008e\6\3\2\2\2\u008f\u0090"+
		"\7d\2\2\u0090\u0091\7q\2\2\u0091\u0092\7q\2\2\u0092\u0093\7n\2\2\u0093"+
		"\b\3\2\2\2\u0094\u0095\7d\2\2\u0095\u0096\7q\2\2\u0096\u0097\7q\2\2\u0097"+
		"\u0098\7n\2\2\u0098\u0099\3\2\2\2\u0099\u009b\7]\2\2\u009a\u009c\5\63"+
		"\32\2\u009b\u009a\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u009e\7_\2\2\u009e\n\3\2\2\2\u009f\u00a0\7f\2\2\u00a0\u00a1\7q\2\2\u00a1"+
		"\u00a2\7w\2\2\u00a2\u00a3\7d\2\2\u00a3\u00a4\7n\2\2\u00a4\u00a5\7g\2\2"+
		"\u00a5\f\3\2\2\2\u00a6\u00a7\7f\2\2\u00a7\u00a8\7q\2\2\u00a8\u00a9\7w"+
		"\2\2\u00a9\u00aa\7d\2\2\u00aa\u00ab\7n\2\2\u00ab\u00ac\7g\2\2\u00ac\u00ad"+
		"\3\2\2\2\u00ad\u00af\7]\2\2\u00ae\u00b0\5\63\32\2\u00af\u00ae\3\2\2\2"+
		"\u00af\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\7_\2\2\u00b2\16\3"+
		"\2\2\2\u00b3\u00b4\7e\2\2\u00b4\u00b5\7n\2\2\u00b5\u00b6\7q\2\2\u00b6"+
		"\u00b7\7e\2\2\u00b7\u00b8\7m\2\2\u00b8\20\3\2\2\2\u00b9\u00ba\7u\2\2\u00ba"+
		"\u00bb\7v\2\2\u00bb\u00bc\7t\2\2\u00bc\u00bd\7k\2\2\u00bd\u00be\7p\2\2"+
		"\u00be\u00bf\7i\2\2\u00bf\22\3\2\2\2\u00c0\u00c1\7r\2\2\u00c1\u00c2\7"+
		"k\2\2\u00c2\u00c3\7v\2\2\u00c3\24\3\2\2\2\u00c4\u00c5\5s:\2\u00c5\u00c6"+
		"\7]\2\2\u00c6\u00c7\5\63\32\2\u00c7\u00c8\7_\2\2\u00c8\26\3\2\2\2\u00c9"+
		"\u00ca\7k\2\2\u00ca\u00cb\7r\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7p\2\2"+
		"\u00cd\30\3\2\2\2\u00ce\u00cf\7q\2\2\u00cf\u00d0\7r\2\2\u00d0\u00d1\7"+
		"k\2\2\u00d1\u00d2\7p\2\2\u00d2\32\3\2\2\2\u00d3\u00d4\7C\2\2\u00d4\u00d5"+
		"\5\63\32\2\u00d5\34\3\2\2\2\u00d6\u00d7\7x\2\2\u00d7\u00d8\7q\2\2\u00d8"+
		"\u00d9\7k\2\2\u00d9\u00da\7f\2\2\u00da\36\3\2\2\2\u00db\u00dc\7N\2\2\u00dc"+
		"\u00dd\7q\2\2\u00dd\u00de\7q\2\2\u00de\u00df\7r\2\2\u00df \3\2\2\2\u00e0"+
		"\u00e1\7U\2\2\u00e1\u00e2\7g\2\2\u00e2\u00e3\7v\2\2\u00e3\u00e4\7w\2\2"+
		"\u00e4\u00e5\7r\2\2\u00e5\"\3\2\2\2\u00e6\u00e7\7t\2\2\u00e7\u00e8\7g"+
		"\2\2\u00e8\u00e9\7v\2\2\u00e9\u00ea\7w\2\2\u00ea\u00eb\7t\2\2\u00eb\u00ec"+
		"\7p\2\2\u00ec$\3\2\2\2\u00ed\u00ee\7k\2\2\u00ee\u00ef\7h\2\2\u00ef&\3"+
		"\2\2\2\u00f0\u00f1\7g\2\2\u00f1\u00f2\7n\2\2\u00f2\u00f3\7u\2\2\u00f3"+
		"\u00f4\7g\2\2\u00f4\u00f5\7\"\2\2\u00f5\u00f6\7k\2\2\u00f6\u00f7\7h\2"+
		"\2\u00f7(\3\2\2\2\u00f8\u00f9\7g\2\2\u00f9\u00fa\7n\2\2\u00fa\u00fb\7"+
		"u\2\2\u00fb\u00fc\7g\2\2\u00fc*\3\2\2\2\u00fd\u00fe\7v\2\2\u00fe\u00ff"+
		"\7q\2\2\u00ff,\3\2\2\2\u0100\u0101\7h\2\2\u0101\u0102\7q\2\2\u0102\u0103"+
		"\7t\2\2\u0103.\3\2\2\2\u0104\u0105\7y\2\2\u0105\u0106\7j\2\2\u0106\u0107"+
		"\7k\2\2\u0107\u0108\7n\2\2\u0108\u0109\7g\2\2\u0109\60\3\2\2\2\u010a\u010b"+
		"\7c\2\2\u010b\u010c\7v\2\2\u010c\62\3\2\2\2\u010d\u010e\5w<\2\u010e\64"+
		"\3\2\2\2\u010f\u0110\5y=\2\u0110\66\3\2\2\2\u0111\u0112\5\63\32\2\u0112"+
		"\u0114\7\60\2\2\u0113\u0115\5\63\32\2\u0114\u0113\3\2\2\2\u0115\u0116"+
		"\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u01178\3\2\2\2\u0118"+
		"\u0119\7*\2\2\u0119\u011a\7/\2\2\u011a\u011b\3\2\2\2\u011b\u011c\5\63"+
		"\32\2\u011c\u011e\7\60\2\2\u011d\u011f\5\63\32\2\u011e\u011d\3\2\2\2\u011f"+
		"\u0120\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\3\2"+
		"\2\2\u0122\u0123\7+\2\2\u0123:\3\2\2\2\u0124\u0125\7v\2\2\u0125\u0126"+
		"\7t\2\2\u0126\u0127\7w\2\2\u0127\u012e\7g\2\2\u0128\u0129\7h\2\2\u0129"+
		"\u012a\7c\2\2\u012a\u012b\7n\2\2\u012b\u012c\7u\2\2\u012c\u012e\7g\2\2"+
		"\u012d\u0124\3\2\2\2\u012d\u0128\3\2\2\2\u012e<\3\2\2\2\u012f\u0133\7"+
		"$\2\2\u0130\u0132\n\2\2\2\u0131\u0130\3\2\2\2\u0132\u0135\3\2\2\2\u0133"+
		"\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0136\3\2\2\2\u0135\u0133\3\2"+
		"\2\2\u0136\u0137\7$\2\2\u0137>\3\2\2\2\u0138\u0139\7]\2\2\u0139@\3\2\2"+
		"\2\u013a\u013b\7_\2\2\u013bB\3\2\2\2\u013c\u013d\7}\2\2\u013dD\3\2\2\2"+
		"\u013e\u013f\7\177\2\2\u013fF\3\2\2\2\u0140\u0141\7*\2\2\u0141H\3\2\2"+
		"\2\u0142\u0143\7+\2\2\u0143J\3\2\2\2\u0144\u0145\7\60\2\2\u0145L\3\2\2"+
		"\2\u0146\u0147\7.\2\2\u0147N\3\2\2\2\u0148\u0149\7=\2\2\u0149P\3\2\2\2"+
		"\u014a\u014b\7A\2\2\u014bR\3\2\2\2\u014c\u014d\7<\2\2\u014dT\3\2\2\2\u014e"+
		"\u014f\7?\2\2\u014fV\3\2\2\2\u0150\u0151\7-\2\2\u0151X\3\2\2\2\u0152\u0153"+
		"\7/\2\2\u0153Z\3\2\2\2\u0154\u0155\7\'\2\2\u0155\\\3\2\2\2\u0156\u0157"+
		"\7\61\2\2\u0157^\3\2\2\2\u0158\u0159\7,\2\2\u0159`\3\2\2\2\u015a\u015b"+
		"\7?\2\2\u015b\u015c\7?\2\2\u015cb\3\2\2\2\u015d\u015e\7(\2\2\u015e\u015f"+
		"\7(\2\2\u015fd\3\2\2\2\u0160\u0161\7~\2\2\u0161\u0162\7~\2\2\u0162f\3"+
		"\2\2\2\u0163\u0164\7#\2\2\u0164\u0165\7?\2\2\u0165h\3\2\2\2\u0166\u0167"+
		"\7#\2\2\u0167j\3\2\2\2\u0168\u0169\7@\2\2\u0169l\3\2\2\2\u016a\u016b\7"+
		"@\2\2\u016b\u016c\7?\2\2\u016cn\3\2\2\2\u016d\u016e\7>\2\2\u016ep\3\2"+
		"\2\2\u016f\u0170\7>\2\2\u0170\u0171\7?\2\2\u0171r\3\2\2\2\u0172\u0177"+
		"\5u;\2\u0173\u0176\5u;\2\u0174\u0176\5\63\32\2\u0175\u0173\3\2\2\2\u0175"+
		"\u0174\3\2\2\2\u0176\u0179\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2"+
		"\2\2\u0178t\3\2\2\2\u0179\u0177\3\2\2\2\u017a\u017b\t\3\2\2\u017bv\3\2"+
		"\2\2\u017c\u0185\7\62\2\2\u017d\u0181\4\63;\2\u017e\u0180\4\62;\2\u017f"+
		"\u017e\3\2\2\2\u0180\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2"+
		"\2\2\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0184\u017c\3\2\2\2\u0184"+
		"\u017d\3\2\2\2\u0185x\3\2\2\2\u0186\u0187\7*\2\2\u0187\u0188\7/\2\2\u0188"+
		"\u0189\3\2\2\2\u0189\u018d\4\63;\2\u018a\u018c\4\62;\2\u018b\u018a\3\2"+
		"\2\2\u018c\u018f\3\2\2\2\u018d\u018b\3\2\2\2\u018d\u018e\3\2\2\2\u018e"+
		"\u0190\3\2\2\2\u018f\u018d\3\2\2\2\u0190\u0191\7+\2\2\u0191z\3\2\2\2\u0192"+
		"\u0193\7\61\2\2\u0193\u0194\7\61\2\2\u0194\u0198\3\2\2\2\u0195\u0197\n"+
		"\4\2\2\u0196\u0195\3\2\2\2\u0197\u019a\3\2\2\2\u0198\u0196\3\2\2\2\u0198"+
		"\u0199\3\2\2\2\u0199\u019b\3\2\2\2\u019a\u0198\3\2\2\2\u019b\u019c\b>"+
		"\2\2\u019c|\3\2\2\2\u019d\u019e\7\61\2\2\u019e\u019f\7,\2\2\u019f\u01a3"+
		"\3\2\2\2\u01a0\u01a2\13\2\2\2\u01a1\u01a0\3\2\2\2\u01a2\u01a5\3\2\2\2"+
		"\u01a3\u01a4\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a4\u01a6\3\2\2\2\u01a5\u01a3"+
		"\3\2\2\2\u01a6\u01a7\7,\2\2\u01a7\u01a8\7\61\2\2\u01a8\u01a9\3\2\2\2\u01a9"+
		"\u01aa\b?\2\2\u01aa~\3\2\2\2\u01ab\u01ad\t\5\2\2\u01ac\u01ab\3\2\2\2\u01ad"+
		"\u01ae\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b0\3\2"+
		"\2\2\u01b0\u01b1\b@\2\2\u01b1\u0080\3\2\2\2\22\2\u008b\u009b\u00af\u0116"+
		"\u0120\u012d\u0133\u0175\u0177\u0181\u0184\u018d\u0198\u01a3\u01ae\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}