// Generated from C:/Users/htmle/Documents/GitHub/P7/src\OurLexer.g4 by ANTLR 4.8
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
		CLOCK=7, STRING=8, PIT=9, IPIN=10, OPIN=11, ANALOGPIN=12, VOID=13, LOOP=14, 
		SETUP=15, RETURN=16, IF=17, ELSE_IF=18, ELSE=19, TO=20, FOR=21, WHILE=22, 
		AT=23, DIGIT=24, DIGIT_NEGATIVE=25, DOUBLE_DIGIT=26, DOUBLE_DIGIT_NEGATIVE=27, 
		BOOL_LITERAL=28, STRING_LITERAL=29, LEFT_SQBRACKET=30, RIGHT_SQBRACKET=31, 
		LEFT_BRACKET=32, RIGHT_BRACKET=33, LEFT_PAREN=34, RIGHT_PAREN=35, DOT=36, 
		COMMA=37, SEMICOLON=38, QUESTION=39, COLON=40, ASSIGN=41, ADD=42, SUB=43, 
		MOD=44, DIV=45, MUL=46, EQUAL=47, AND=48, OR=49, NOT_EQUAL=50, NOT=51, 
		GREATER_THAN=52, GREATER_OR_EQUAL=53, LESS_THAN=54, LESS_OR_EQUAL=55, 
		ID=56, COMMENT_STRING=57, COMMENT_BLOCK=58, WS=59;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "INT_ARRAY", "BOOLEAN", "BOOLEAN_ARRAY", "DOUBLE", "DOUBLE_ARRAY", 
			"CLOCK", "STRING", "PIT", "IPIN", "OPIN", "ANALOGPIN", "VOID", "LOOP", 
			"SETUP", "RETURN", "IF", "ELSE_IF", "ELSE", "TO", "FOR", "WHILE", "AT", 
			"DIGIT", "DIGIT_NEGATIVE", "DOUBLE_DIGIT", "DOUBLE_DIGIT_NEGATIVE", "BOOL_LITERAL", 
			"STRING_LITERAL", "LEFT_SQBRACKET", "RIGHT_SQBRACKET", "LEFT_BRACKET", 
			"RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", "DOT", "COMMA", "SEMICOLON", 
			"QUESTION", "COLON", "ASSIGN", "ADD", "SUB", "MOD", "DIV", "MUL", "EQUAL", 
			"AND", "OR", "NOT_EQUAL", "NOT", "GREATER_THAN", "GREATER_OR_EQUAL", 
			"LESS_THAN", "LESS_OR_EQUAL", "ID", "LETTER", "DIGIT_RULE", "DIGIT_NEGATIVE_RULE", 
			"COMMENT_STRING", "COMMENT_BLOCK", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", null, "'bool'", null, "'double'", null, "'clock'", "'string'", 
			"'pit'", "'ipin'", "'opin'", null, "'void'", "'Loop'", "'Setup'", "'return'", 
			"'if'", "'else if'", "'else'", "'to'", "'for'", "'while'", "'at'", null, 
			null, null, null, null, null, "'['", "']'", "'{'", "'}'", "'('", "')'", 
			"'.'", "','", "';'", "'?'", "':'", "'='", "'+'", "'-'", "'%'", "'/'", 
			"'*'", "'=='", "'&&'", "'||'", "'!='", "'!'", "'>'", "'>='", "'<'", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "INT_ARRAY", "BOOLEAN", "BOOLEAN_ARRAY", "DOUBLE", "DOUBLE_ARRAY", 
			"CLOCK", "STRING", "PIT", "IPIN", "OPIN", "ANALOGPIN", "VOID", "LOOP", 
			"SETUP", "RETURN", "IF", "ELSE_IF", "ELSE", "TO", "FOR", "WHILE", "AT", 
			"DIGIT", "DIGIT_NEGATIVE", "DOUBLE_DIGIT", "DOUBLE_DIGIT_NEGATIVE", "BOOL_LITERAL", 
			"STRING_LITERAL", "LEFT_SQBRACKET", "RIGHT_SQBRACKET", "LEFT_BRACKET", 
			"RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", "DOT", "COMMA", "SEMICOLON", 
			"QUESTION", "COLON", "ASSIGN", "ADD", "SUB", "MOD", "DIV", "MUL", "EQUAL", 
			"AND", "OR", "NOT_EQUAL", "NOT", "GREATER_THAN", "GREATER_OR_EQUAL", 
			"LESS_THAN", "LESS_OR_EQUAL", "ID", "COMMENT_STRING", "COMMENT_BLOCK", 
			"WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2=\u01b4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3\u008a\n\3\f\3"+
		"\16\3\u008d\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\7\5\u009d\n\5\f\5\16\5\u00a0\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00b4\n\7\f\7\16\7\u00b7\13"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\33\6\33\u0117\n\33\r\33\16\33\u0118\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\6\34\u0121\n\34\r\34\16\34\u0122\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0130\n\35\3\36\3\36\7\36\u0134"+
		"\n\36\f\36\16\36\u0137\13\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3"+
		"#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3."+
		"\3.\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63"+
		"\3\64\3\64\3\65\3\65\3\66\3\66\3\66\3\67\3\67\38\38\38\39\39\39\79\u0178"+
		"\n9\f9\169\u017b\139\3:\3:\3;\3;\3;\7;\u0182\n;\f;\16;\u0185\13;\5;\u0187"+
		"\n;\3<\3<\3<\3<\3<\7<\u018e\n<\f<\16<\u0191\13<\3<\3<\3=\3=\3=\3=\7=\u0199"+
		"\n=\f=\16=\u019c\13=\3=\3=\3>\3>\3>\3>\7>\u01a4\n>\f>\16>\u01a7\13>\3"+
		">\3>\3>\3>\3>\3?\6?\u01af\n?\r?\16?\u01b0\3?\3?\3\u01a5\2@\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s\2u\2w\2"+
		"y;{<}=\3\2\6\6\2\f\f\17\17$$^^\3\2C|\4\2\13\f\17\17\5\2\13\f\17\17\"\""+
		"\2\u01bf\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\3\177"+
		"\3\2\2\2\5\u0083\3\2\2\2\7\u0090\3\2\2\2\t\u0095\3\2\2\2\13\u00a3\3\2"+
		"\2\2\r\u00aa\3\2\2\2\17\u00ba\3\2\2\2\21\u00c0\3\2\2\2\23\u00c7\3\2\2"+
		"\2\25\u00cb\3\2\2\2\27\u00d0\3\2\2\2\31\u00d5\3\2\2\2\33\u00d8\3\2\2\2"+
		"\35\u00dd\3\2\2\2\37\u00e2\3\2\2\2!\u00e8\3\2\2\2#\u00ef\3\2\2\2%\u00f2"+
		"\3\2\2\2\'\u00fa\3\2\2\2)\u00ff\3\2\2\2+\u0102\3\2\2\2-\u0106\3\2\2\2"+
		"/\u010c\3\2\2\2\61\u010f\3\2\2\2\63\u0111\3\2\2\2\65\u0113\3\2\2\2\67"+
		"\u011a\3\2\2\29\u012f\3\2\2\2;\u0131\3\2\2\2=\u013a\3\2\2\2?\u013c\3\2"+
		"\2\2A\u013e\3\2\2\2C\u0140\3\2\2\2E\u0142\3\2\2\2G\u0144\3\2\2\2I\u0146"+
		"\3\2\2\2K\u0148\3\2\2\2M\u014a\3\2\2\2O\u014c\3\2\2\2Q\u014e\3\2\2\2S"+
		"\u0150\3\2\2\2U\u0152\3\2\2\2W\u0154\3\2\2\2Y\u0156\3\2\2\2[\u0158\3\2"+
		"\2\2]\u015a\3\2\2\2_\u015c\3\2\2\2a\u015f\3\2\2\2c\u0162\3\2\2\2e\u0165"+
		"\3\2\2\2g\u0168\3\2\2\2i\u016a\3\2\2\2k\u016c\3\2\2\2m\u016f\3\2\2\2o"+
		"\u0171\3\2\2\2q\u0174\3\2\2\2s\u017c\3\2\2\2u\u0186\3\2\2\2w\u0188\3\2"+
		"\2\2y\u0194\3\2\2\2{\u019f\3\2\2\2}\u01ae\3\2\2\2\177\u0080\7k\2\2\u0080"+
		"\u0081\7p\2\2\u0081\u0082\7v\2\2\u0082\4\3\2\2\2\u0083\u0084\7k\2\2\u0084"+
		"\u0085\7p\2\2\u0085\u0086\7v\2\2\u0086\u0087\3\2\2\2\u0087\u008b\7]\2"+
		"\2\u0088\u008a\5\61\31\2\u0089\u0088\3\2\2\2\u008a\u008d\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008e\u008f\7_\2\2\u008f\6\3\2\2\2\u0090\u0091\7d\2\2\u0091\u0092"+
		"\7q\2\2\u0092\u0093\7q\2\2\u0093\u0094\7n\2\2\u0094\b\3\2\2\2\u0095\u0096"+
		"\7d\2\2\u0096\u0097\7q\2\2\u0097\u0098\7q\2\2\u0098\u0099\7n\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\u009e\7]\2\2\u009b\u009d\5\61\31\2\u009c\u009b\3"+
		"\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a2\7_\2\2\u00a2\n\3\2\2\2"+
		"\u00a3\u00a4\7f\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7w\2\2\u00a6\u00a7"+
		"\7d\2\2\u00a7\u00a8\7n\2\2\u00a8\u00a9\7g\2\2\u00a9\f\3\2\2\2\u00aa\u00ab"+
		"\7f\2\2\u00ab\u00ac\7q\2\2\u00ac\u00ad\7w\2\2\u00ad\u00ae\7d\2\2\u00ae"+
		"\u00af\7n\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b5\7]\2"+
		"\2\u00b2\u00b4\5\61\31\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00b5\3\2"+
		"\2\2\u00b8\u00b9\7_\2\2\u00b9\16\3\2\2\2\u00ba\u00bb\7e\2\2\u00bb\u00bc"+
		"\7n\2\2\u00bc\u00bd\7q\2\2\u00bd\u00be\7e\2\2\u00be\u00bf\7m\2\2\u00bf"+
		"\20\3\2\2\2\u00c0\u00c1\7u\2\2\u00c1\u00c2\7v\2\2\u00c2\u00c3\7t\2\2\u00c3"+
		"\u00c4\7k\2\2\u00c4\u00c5\7p\2\2\u00c5\u00c6\7i\2\2\u00c6\22\3\2\2\2\u00c7"+
		"\u00c8\7r\2\2\u00c8\u00c9\7k\2\2\u00c9\u00ca\7v\2\2\u00ca\24\3\2\2\2\u00cb"+
		"\u00cc\7k\2\2\u00cc\u00cd\7r\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf\7p\2\2"+
		"\u00cf\26\3\2\2\2\u00d0\u00d1\7q\2\2\u00d1\u00d2\7r\2\2\u00d2\u00d3\7"+
		"k\2\2\u00d3\u00d4\7p\2\2\u00d4\30\3\2\2\2\u00d5\u00d6\7C\2\2\u00d6\u00d7"+
		"\5\61\31\2\u00d7\32\3\2\2\2\u00d8\u00d9\7x\2\2\u00d9\u00da\7q\2\2\u00da"+
		"\u00db\7k\2\2\u00db\u00dc\7f\2\2\u00dc\34\3\2\2\2\u00dd\u00de\7N\2\2\u00de"+
		"\u00df\7q\2\2\u00df\u00e0\7q\2\2\u00e0\u00e1\7r\2\2\u00e1\36\3\2\2\2\u00e2"+
		"\u00e3\7U\2\2\u00e3\u00e4\7g\2\2\u00e4\u00e5\7v\2\2\u00e5\u00e6\7w\2\2"+
		"\u00e6\u00e7\7r\2\2\u00e7 \3\2\2\2\u00e8\u00e9\7t\2\2\u00e9\u00ea\7g\2"+
		"\2\u00ea\u00eb\7v\2\2\u00eb\u00ec\7w\2\2\u00ec\u00ed\7t\2\2\u00ed\u00ee"+
		"\7p\2\2\u00ee\"\3\2\2\2\u00ef\u00f0\7k\2\2\u00f0\u00f1\7h\2\2\u00f1$\3"+
		"\2\2\2\u00f2\u00f3\7g\2\2\u00f3\u00f4\7n\2\2\u00f4\u00f5\7u\2\2\u00f5"+
		"\u00f6\7g\2\2\u00f6\u00f7\7\"\2\2\u00f7\u00f8\7k\2\2\u00f8\u00f9\7h\2"+
		"\2\u00f9&\3\2\2\2\u00fa\u00fb\7g\2\2\u00fb\u00fc\7n\2\2\u00fc\u00fd\7"+
		"u\2\2\u00fd\u00fe\7g\2\2\u00fe(\3\2\2\2\u00ff\u0100\7v\2\2\u0100\u0101"+
		"\7q\2\2\u0101*\3\2\2\2\u0102\u0103\7h\2\2\u0103\u0104\7q\2\2\u0104\u0105"+
		"\7t\2\2\u0105,\3\2\2\2\u0106\u0107\7y\2\2\u0107\u0108\7j\2\2\u0108\u0109"+
		"\7k\2\2\u0109\u010a\7n\2\2\u010a\u010b\7g\2\2\u010b.\3\2\2\2\u010c\u010d"+
		"\7c\2\2\u010d\u010e\7v\2\2\u010e\60\3\2\2\2\u010f\u0110\5u;\2\u0110\62"+
		"\3\2\2\2\u0111\u0112\5w<\2\u0112\64\3\2\2\2\u0113\u0114\5\61\31\2\u0114"+
		"\u0116\7\60\2\2\u0115\u0117\5\61\31\2\u0116\u0115\3\2\2\2\u0117\u0118"+
		"\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\66\3\2\2\2\u011a"+
		"\u011b\7*\2\2\u011b\u011c\7/\2\2\u011c\u011d\3\2\2\2\u011d\u011e\5\61"+
		"\31\2\u011e\u0120\7\60\2\2\u011f\u0121\5\61\31\2\u0120\u011f\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\3\2"+
		"\2\2\u0124\u0125\7+\2\2\u01258\3\2\2\2\u0126\u0127\7v\2\2\u0127\u0128"+
		"\7t\2\2\u0128\u0129\7w\2\2\u0129\u0130\7g\2\2\u012a\u012b\7h\2\2\u012b"+
		"\u012c\7c\2\2\u012c\u012d\7n\2\2\u012d\u012e\7u\2\2\u012e\u0130\7g\2\2"+
		"\u012f\u0126\3\2\2\2\u012f\u012a\3\2\2\2\u0130:\3\2\2\2\u0131\u0135\7"+
		"$\2\2\u0132\u0134\n\2\2\2\u0133\u0132\3\2\2\2\u0134\u0137\3\2\2\2\u0135"+
		"\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0138\3\2\2\2\u0137\u0135\3\2"+
		"\2\2\u0138\u0139\7$\2\2\u0139<\3\2\2\2\u013a\u013b\7]\2\2\u013b>\3\2\2"+
		"\2\u013c\u013d\7_\2\2\u013d@\3\2\2\2\u013e\u013f\7}\2\2\u013fB\3\2\2\2"+
		"\u0140\u0141\7\177\2\2\u0141D\3\2\2\2\u0142\u0143\7*\2\2\u0143F\3\2\2"+
		"\2\u0144\u0145\7+\2\2\u0145H\3\2\2\2\u0146\u0147\7\60\2\2\u0147J\3\2\2"+
		"\2\u0148\u0149\7.\2\2\u0149L\3\2\2\2\u014a\u014b\7=\2\2\u014bN\3\2\2\2"+
		"\u014c\u014d\7A\2\2\u014dP\3\2\2\2\u014e\u014f\7<\2\2\u014fR\3\2\2\2\u0150"+
		"\u0151\7?\2\2\u0151T\3\2\2\2\u0152\u0153\7-\2\2\u0153V\3\2\2\2\u0154\u0155"+
		"\7/\2\2\u0155X\3\2\2\2\u0156\u0157\7\'\2\2\u0157Z\3\2\2\2\u0158\u0159"+
		"\7\61\2\2\u0159\\\3\2\2\2\u015a\u015b\7,\2\2\u015b^\3\2\2\2\u015c\u015d"+
		"\7?\2\2\u015d\u015e\7?\2\2\u015e`\3\2\2\2\u015f\u0160\7(\2\2\u0160\u0161"+
		"\7(\2\2\u0161b\3\2\2\2\u0162\u0163\7~\2\2\u0163\u0164\7~\2\2\u0164d\3"+
		"\2\2\2\u0165\u0166\7#\2\2\u0166\u0167\7?\2\2\u0167f\3\2\2\2\u0168\u0169"+
		"\7#\2\2\u0169h\3\2\2\2\u016a\u016b\7@\2\2\u016bj\3\2\2\2\u016c\u016d\7"+
		"@\2\2\u016d\u016e\7?\2\2\u016el\3\2\2\2\u016f\u0170\7>\2\2\u0170n\3\2"+
		"\2\2\u0171\u0172\7>\2\2\u0172\u0173\7?\2\2\u0173p\3\2\2\2\u0174\u0179"+
		"\5s:\2\u0175\u0178\5s:\2\u0176\u0178\5\61\31\2\u0177\u0175\3\2\2\2\u0177"+
		"\u0176\3\2\2\2\u0178\u017b\3\2\2\2\u0179\u0177\3\2\2\2\u0179\u017a\3\2"+
		"\2\2\u017ar\3\2\2\2\u017b\u0179\3\2\2\2\u017c\u017d\t\3\2\2\u017dt\3\2"+
		"\2\2\u017e\u0187\7\62\2\2\u017f\u0183\4\63;\2\u0180\u0182\4\62;\2\u0181"+
		"\u0180\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0183\u0184\3\2"+
		"\2\2\u0184\u0187\3\2\2\2\u0185\u0183\3\2\2\2\u0186\u017e\3\2\2\2\u0186"+
		"\u017f\3\2\2\2\u0187v\3\2\2\2\u0188\u0189\7*\2\2\u0189\u018a\7/\2\2\u018a"+
		"\u018b\3\2\2\2\u018b\u018f\4\63;\2\u018c\u018e\4\62;\2\u018d\u018c\3\2"+
		"\2\2\u018e\u0191\3\2\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190"+
		"\u0192\3\2\2\2\u0191\u018f\3\2\2\2\u0192\u0193\7+\2\2\u0193x\3\2\2\2\u0194"+
		"\u0195\7\61\2\2\u0195\u0196\7\61\2\2\u0196\u019a\3\2\2\2\u0197\u0199\n"+
		"\4\2\2\u0198\u0197\3\2\2\2\u0199\u019c\3\2\2\2\u019a\u0198\3\2\2\2\u019a"+
		"\u019b\3\2\2\2\u019b\u019d\3\2\2\2\u019c\u019a\3\2\2\2\u019d\u019e\b="+
		"\2\2\u019ez\3\2\2\2\u019f\u01a0\7\61\2\2\u01a0\u01a1\7,\2\2\u01a1\u01a5"+
		"\3\2\2\2\u01a2\u01a4\13\2\2\2\u01a3\u01a2\3\2\2\2\u01a4\u01a7\3\2\2\2"+
		"\u01a5\u01a6\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6\u01a8\3\2\2\2\u01a7\u01a5"+
		"\3\2\2\2\u01a8\u01a9\7,\2\2\u01a9\u01aa\7\61\2\2\u01aa\u01ab\3\2\2\2\u01ab"+
		"\u01ac\b>\2\2\u01ac|\3\2\2\2\u01ad\u01af\t\5\2\2\u01ae\u01ad\3\2\2\2\u01af"+
		"\u01b0\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b2\3\2"+
		"\2\2\u01b2\u01b3\b?\2\2\u01b3~\3\2\2\2\22\2\u008b\u009e\u00b5\u0118\u0122"+
		"\u012f\u0135\u0177\u0179\u0183\u0186\u018f\u019a\u01a5\u01b0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}