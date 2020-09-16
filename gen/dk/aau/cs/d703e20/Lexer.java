// Generated from C:/Users/the_p/Desktop/P7/src/dk/aau/cs/d703e20\Lexer.g4 by ANTLR 4.8
package dk.aau.cs.d703e20;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, BOOLEAN=2, DOUBLE=3, CLOCK=4, VOID=5, MAIN=6, RETURN=7, IF=8, ELSE_IF=9, 
		ELSE=10, TO=11, FOR=12, DIGIT=13, DIGIT_NEGATIVE=14, DOUBLE_DIGIT=15, 
		DOUBLE_DIGIT_NEGATIVE=16, BOOL_LITERAL=17, LEFT_BRACKET=18, RIGHT_BRACKET=19, 
		LEFT_PAREN=20, RIGHT_PAREN=21, DOT=22, COMMA=23, SEMICOLON=24, QUESTION=25, 
		COLON=26, ASSIGN=27, ADD=28, SUB=29, MOD=30, DIV=31, MUL=32, EQUAL=33, 
		AND=34, OR=35, NOT_EQUAL=36, NOT=37, GREATER_THAN=38, GREATER_OR_EQUAL=39, 
		LESS_THAN=40, LESS_OR_EQUAL=41, ID=42, COMMENT_STRING=43, WS=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "BOOLEAN", "DOUBLE", "CLOCK", "VOID", "MAIN", "RETURN", "IF", 
			"ELSE_IF", "ELSE", "TO", "FOR", "DIGIT", "DIGIT_NEGATIVE", "DOUBLE_DIGIT", 
			"DOUBLE_DIGIT_NEGATIVE", "BOOL_LITERAL", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"LEFT_PAREN", "RIGHT_PAREN", "DOT", "COMMA", "SEMICOLON", "QUESTION", 
			"COLON", "ASSIGN", "ADD", "SUB", "MOD", "DIV", "MUL", "EQUAL", "AND", 
			"OR", "NOT_EQUAL", "NOT", "GREATER_THAN", "GREATER_OR_EQUAL", "LESS_THAN", 
			"LESS_OR_EQUAL", "ID", "LETTER", "DIGIT_RULE", "DIGIT_NEGATIVE_RULE", 
			"COMMENT_STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'bool'", "'double'", "'clock'", "'void'", "'Main'", "'return'", 
			"'if'", "'else if'", "'else'", "'to'", "'for'", null, null, null, null, 
			null, "'{'", "'}'", "'('", "')'", "'.'", "','", "';'", "'?'", "':'", 
			"'='", "'+'", "'-'", "'%'", "'/'", "'*'", "'=='", "'&&'", "'||'", "'!='", 
			"'!'", "'>'", "'>='", "'<'", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "BOOLEAN", "DOUBLE", "CLOCK", "VOID", "MAIN", "RETURN", 
			"IF", "ELSE_IF", "ELSE", "TO", "FOR", "DIGIT", "DIGIT_NEGATIVE", "DOUBLE_DIGIT", 
			"DOUBLE_DIGIT_NEGATIVE", "BOOL_LITERAL", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"LEFT_PAREN", "RIGHT_PAREN", "DOT", "COMMA", "SEMICOLON", "QUESTION", 
			"COLON", "ASSIGN", "ADD", "SUB", "MOD", "DIV", "MUL", "EQUAL", "AND", 
			"OR", "NOT_EQUAL", "NOT", "GREATER_THAN", "GREATER_OR_EQUAL", "LESS_THAN", 
			"LESS_OR_EQUAL", "ID", "COMMENT_STRING", "WS"
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


	public Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u0124\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\6\20\u00a7\n\20\r\20\16\20\u00a8"+
		"\3\21\3\21\3\21\6\21\u00ae\n\21\r\21\16\21\u00af\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\5\22\u00bb\n\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$"+
		"\3$\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3)\3)\3*\3*\3*\3+\3+\3+\7+\u00f6\n"+
		"+\f+\16+\u00f9\13+\3,\3,\3-\3-\3-\7-\u0100\n-\f-\16-\u0103\13-\5-\u0105"+
		"\n-\3.\3.\3.\3.\3.\7.\u010c\n.\f.\16.\u010f\13.\3.\3.\3/\3/\3/\3/\7/\u0117"+
		"\n/\f/\16/\u011a\13/\3/\3/\3\60\6\60\u011f\n\60\r\60\16\60\u0120\3\60"+
		"\3\60\2\2\61\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W\2Y\2[\2]-_.\3\2\5\3\2C|\4"+
		"\2\13\f\17\17\5\2\13\f\17\17\"\"\2\u012a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2]\3\2\2\2\2_\3\2\2"+
		"\2\3a\3\2\2\2\5e\3\2\2\2\7j\3\2\2\2\tq\3\2\2\2\13w\3\2\2\2\r|\3\2\2\2"+
		"\17\u0081\3\2\2\2\21\u0088\3\2\2\2\23\u008b\3\2\2\2\25\u0093\3\2\2\2\27"+
		"\u0098\3\2\2\2\31\u009b\3\2\2\2\33\u009f\3\2\2\2\35\u00a1\3\2\2\2\37\u00a3"+
		"\3\2\2\2!\u00aa\3\2\2\2#\u00ba\3\2\2\2%\u00bc\3\2\2\2\'\u00be\3\2\2\2"+
		")\u00c0\3\2\2\2+\u00c2\3\2\2\2-\u00c4\3\2\2\2/\u00c6\3\2\2\2\61\u00c8"+
		"\3\2\2\2\63\u00ca\3\2\2\2\65\u00cc\3\2\2\2\67\u00ce\3\2\2\29\u00d0\3\2"+
		"\2\2;\u00d2\3\2\2\2=\u00d4\3\2\2\2?\u00d6\3\2\2\2A\u00d8\3\2\2\2C\u00da"+
		"\3\2\2\2E\u00dd\3\2\2\2G\u00e0\3\2\2\2I\u00e3\3\2\2\2K\u00e6\3\2\2\2M"+
		"\u00e8\3\2\2\2O\u00ea\3\2\2\2Q\u00ed\3\2\2\2S\u00ef\3\2\2\2U\u00f2\3\2"+
		"\2\2W\u00fa\3\2\2\2Y\u0104\3\2\2\2[\u0106\3\2\2\2]\u0112\3\2\2\2_\u011e"+
		"\3\2\2\2ab\7k\2\2bc\7p\2\2cd\7v\2\2d\4\3\2\2\2ef\7d\2\2fg\7q\2\2gh\7q"+
		"\2\2hi\7n\2\2i\6\3\2\2\2jk\7f\2\2kl\7q\2\2lm\7w\2\2mn\7d\2\2no\7n\2\2"+
		"op\7g\2\2p\b\3\2\2\2qr\7e\2\2rs\7n\2\2st\7q\2\2tu\7e\2\2uv\7m\2\2v\n\3"+
		"\2\2\2wx\7x\2\2xy\7q\2\2yz\7k\2\2z{\7f\2\2{\f\3\2\2\2|}\7O\2\2}~\7c\2"+
		"\2~\177\7k\2\2\177\u0080\7p\2\2\u0080\16\3\2\2\2\u0081\u0082\7t\2\2\u0082"+
		"\u0083\7g\2\2\u0083\u0084\7v\2\2\u0084\u0085\7w\2\2\u0085\u0086\7t\2\2"+
		"\u0086\u0087\7p\2\2\u0087\20\3\2\2\2\u0088\u0089\7k\2\2\u0089\u008a\7"+
		"h\2\2\u008a\22\3\2\2\2\u008b\u008c\7g\2\2\u008c\u008d\7n\2\2\u008d\u008e"+
		"\7u\2\2\u008e\u008f\7g\2\2\u008f\u0090\7\"\2\2\u0090\u0091\7k\2\2\u0091"+
		"\u0092\7h\2\2\u0092\24\3\2\2\2\u0093\u0094\7g\2\2\u0094\u0095\7n\2\2\u0095"+
		"\u0096\7u\2\2\u0096\u0097\7g\2\2\u0097\26\3\2\2\2\u0098\u0099\7v\2\2\u0099"+
		"\u009a\7q\2\2\u009a\30\3\2\2\2\u009b\u009c\7h\2\2\u009c\u009d\7q\2\2\u009d"+
		"\u009e\7t\2\2\u009e\32\3\2\2\2\u009f\u00a0\5Y-\2\u00a0\34\3\2\2\2\u00a1"+
		"\u00a2\5[.\2\u00a2\36\3\2\2\2\u00a3\u00a4\5\33\16\2\u00a4\u00a6\7\60\2"+
		"\2\u00a5\u00a7\5\33\16\2\u00a6\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9 \3\2\2\2\u00aa\u00ab\5\35\17"+
		"\2\u00ab\u00ad\7\60\2\2\u00ac\u00ae\5\33\16\2\u00ad\u00ac\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\"\3\2\2\2"+
		"\u00b1\u00b2\7v\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4\7w\2\2\u00b4\u00bb"+
		"\7g\2\2\u00b5\u00b6\7h\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8\7n\2\2\u00b8"+
		"\u00b9\7u\2\2\u00b9\u00bb\7g\2\2\u00ba\u00b1\3\2\2\2\u00ba\u00b5\3\2\2"+
		"\2\u00bb$\3\2\2\2\u00bc\u00bd\7}\2\2\u00bd&\3\2\2\2\u00be\u00bf\7\177"+
		"\2\2\u00bf(\3\2\2\2\u00c0\u00c1\7*\2\2\u00c1*\3\2\2\2\u00c2\u00c3\7+\2"+
		"\2\u00c3,\3\2\2\2\u00c4\u00c5\7\60\2\2\u00c5.\3\2\2\2\u00c6\u00c7\7.\2"+
		"\2\u00c7\60\3\2\2\2\u00c8\u00c9\7=\2\2\u00c9\62\3\2\2\2\u00ca\u00cb\7"+
		"A\2\2\u00cb\64\3\2\2\2\u00cc\u00cd\7<\2\2\u00cd\66\3\2\2\2\u00ce\u00cf"+
		"\7?\2\2\u00cf8\3\2\2\2\u00d0\u00d1\7-\2\2\u00d1:\3\2\2\2\u00d2\u00d3\7"+
		"/\2\2\u00d3<\3\2\2\2\u00d4\u00d5\7\'\2\2\u00d5>\3\2\2\2\u00d6\u00d7\7"+
		"\61\2\2\u00d7@\3\2\2\2\u00d8\u00d9\7,\2\2\u00d9B\3\2\2\2\u00da\u00db\7"+
		"?\2\2\u00db\u00dc\7?\2\2\u00dcD\3\2\2\2\u00dd\u00de\7(\2\2\u00de\u00df"+
		"\7(\2\2\u00dfF\3\2\2\2\u00e0\u00e1\7~\2\2\u00e1\u00e2\7~\2\2\u00e2H\3"+
		"\2\2\2\u00e3\u00e4\7#\2\2\u00e4\u00e5\7?\2\2\u00e5J\3\2\2\2\u00e6\u00e7"+
		"\7#\2\2\u00e7L\3\2\2\2\u00e8\u00e9\7@\2\2\u00e9N\3\2\2\2\u00ea\u00eb\7"+
		"@\2\2\u00eb\u00ec\7?\2\2\u00ecP\3\2\2\2\u00ed\u00ee\7>\2\2\u00eeR\3\2"+
		"\2\2\u00ef\u00f0\7>\2\2\u00f0\u00f1\7?\2\2\u00f1T\3\2\2\2\u00f2\u00f7"+
		"\5W,\2\u00f3\u00f6\5W,\2\u00f4\u00f6\5\33\16\2\u00f5\u00f3\3\2\2\2\u00f5"+
		"\u00f4\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2"+
		"\2\2\u00f8V\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fb\t\2\2\2\u00fbX\3\2"+
		"\2\2\u00fc\u0105\7\62\2\2\u00fd\u0101\4\63;\2\u00fe\u0100\4\62;\2\u00ff"+
		"\u00fe\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2"+
		"\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u00fc\3\2\2\2\u0104"+
		"\u00fd\3\2\2\2\u0105Z\3\2\2\2\u0106\u0107\7*\2\2\u0107\u0108\7/\2\2\u0108"+
		"\u0109\3\2\2\2\u0109\u010d\4\63;\2\u010a\u010c\4\62;\2\u010b\u010a\3\2"+
		"\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e"+
		"\u0110\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0111\7+\2\2\u0111\\\3\2\2\2"+
		"\u0112\u0113\7\61\2\2\u0113\u0114\7\61\2\2\u0114\u0118\3\2\2\2\u0115\u0117"+
		"\n\3\2\2\u0116\u0115\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118"+
		"\u0119\3\2\2\2\u0119\u011b\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011c\b/"+
		"\2\2\u011c^\3\2\2\2\u011d\u011f\t\4\2\2\u011e\u011d\3\2\2\2\u011f\u0120"+
		"\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\u0123\b\60\2\2\u0123`\3\2\2\2\r\2\u00a8\u00af\u00ba\u00f5\u00f7\u0101"+
		"\u0104\u010d\u0118\u0120\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}