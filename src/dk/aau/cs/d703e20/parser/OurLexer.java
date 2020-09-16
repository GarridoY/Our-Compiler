// Generated from /Users/Garrido/Documents/GitHub/P7/src/OurLexer.g4 by ANTLR 4.8
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
		INT=1, BOOLEAN=2, DOUBLE=3, CLOCK=4, PIT=5, VOID=6, MAIN=7, RETURN=8, 
		IF=9, ELSE_IF=10, ELSE=11, TO=12, FOR=13, DIGIT=14, DIGIT_NEGATIVE=15, 
		DOUBLE_DIGIT=16, DOUBLE_DIGIT_NEGATIVE=17, BOOL_LITERAL=18, LEFT_BRACKET=19, 
		RIGHT_BRACKET=20, LEFT_PAREN=21, RIGHT_PAREN=22, DOT=23, COMMA=24, SEMICOLON=25, 
		QUESTION=26, COLON=27, ASSIGN=28, ADD=29, SUB=30, MOD=31, DIV=32, MUL=33, 
		EQUAL=34, AND=35, OR=36, NOT_EQUAL=37, NOT=38, GREATER_THAN=39, GREATER_OR_EQUAL=40, 
		LESS_THAN=41, LESS_OR_EQUAL=42, ID=43, NEWLINE=44, COMMENT_STRING=45, 
		COMMENT_BLOCK=46, WS=47;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "BOOLEAN", "DOUBLE", "CLOCK", "PIT", "VOID", "MAIN", "RETURN", 
			"IF", "ELSE_IF", "ELSE", "TO", "FOR", "DIGIT", "DIGIT_NEGATIVE", "DOUBLE_DIGIT", 
			"DOUBLE_DIGIT_NEGATIVE", "BOOL_LITERAL", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"LEFT_PAREN", "RIGHT_PAREN", "DOT", "COMMA", "SEMICOLON", "QUESTION", 
			"COLON", "ASSIGN", "ADD", "SUB", "MOD", "DIV", "MUL", "EQUAL", "AND", 
			"OR", "NOT_EQUAL", "NOT", "GREATER_THAN", "GREATER_OR_EQUAL", "LESS_THAN", 
			"LESS_OR_EQUAL", "ID", "LETTER", "DIGIT_RULE", "DIGIT_NEGATIVE_RULE", 
			"NEWLINE", "COMMENT_STRING", "COMMENT_BLOCK", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'bool'", "'double'", "'clock'", "'pit'", "'void'", "'Main'", 
			"'return'", "'if'", "'else if'", "'else'", "'to'", "'for'", null, null, 
			null, null, null, "'{'", "'}'", "'('", "')'", "'.'", "','", "';'", "'?'", 
			"':'", "'='", "'+'", "'-'", "'%'", "'/'", "'*'", "'=='", "'&&'", "'||'", 
			"'!='", "'!'", "'>'", "'>='", "'<'", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "BOOLEAN", "DOUBLE", "CLOCK", "PIT", "VOID", "MAIN", "RETURN", 
			"IF", "ELSE_IF", "ELSE", "TO", "FOR", "DIGIT", "DIGIT_NEGATIVE", "DOUBLE_DIGIT", 
			"DOUBLE_DIGIT_NEGATIVE", "BOOL_LITERAL", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"LEFT_PAREN", "RIGHT_PAREN", "DOT", "COMMA", "SEMICOLON", "QUESTION", 
			"COLON", "ASSIGN", "ADD", "SUB", "MOD", "DIV", "MUL", "EQUAL", "AND", 
			"OR", "NOT_EQUAL", "NOT", "GREATER_THAN", "GREATER_OR_EQUAL", "LESS_THAN", 
			"LESS_OR_EQUAL", "ID", "NEWLINE", "COMMENT_STRING", "COMMENT_BLOCK", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\61\u0141\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\20\3\20\3\21\3\21\3\21\6\21\u00b1\n\21\r\21\16\21\u00b2\3\22\3\22"+
		"\3\22\6\22\u00b8\n\22\r\22\16\22\u00b9\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\5\23\u00c5\n\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'"+
		"\3\'\3(\3(\3)\3)\3)\3*\3*\3+\3+\3+\3,\3,\3,\7,\u0100\n,\f,\16,\u0103\13"+
		",\3-\3-\3.\3.\3.\7.\u010a\n.\f.\16.\u010d\13.\5.\u010f\n.\3/\3/\3/\3/"+
		"\3/\7/\u0116\n/\f/\16/\u0119\13/\3/\3/\3\60\6\60\u011e\n\60\r\60\16\60"+
		"\u011f\3\61\3\61\3\61\3\61\7\61\u0126\n\61\f\61\16\61\u0129\13\61\3\61"+
		"\3\61\3\62\3\62\3\62\3\62\7\62\u0131\n\62\f\62\16\62\u0134\13\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\63\6\63\u013c\n\63\r\63\16\63\u013d\3\63\3\63\3"+
		"\u0132\2\64\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y\2[\2]\2_.a/c\60e\61\3\2\6\3"+
		"\2C|\4\2\f\f\17\17\4\2\13\f\17\17\5\2\13\f\17\17\"\"\2\u0149\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2"+
		"\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2"+
		"W\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\3g\3\2\2\2\5k\3"+
		"\2\2\2\7p\3\2\2\2\tw\3\2\2\2\13}\3\2\2\2\r\u0081\3\2\2\2\17\u0086\3\2"+
		"\2\2\21\u008b\3\2\2\2\23\u0092\3\2\2\2\25\u0095\3\2\2\2\27\u009d\3\2\2"+
		"\2\31\u00a2\3\2\2\2\33\u00a5\3\2\2\2\35\u00a9\3\2\2\2\37\u00ab\3\2\2\2"+
		"!\u00ad\3\2\2\2#\u00b4\3\2\2\2%\u00c4\3\2\2\2\'\u00c6\3\2\2\2)\u00c8\3"+
		"\2\2\2+\u00ca\3\2\2\2-\u00cc\3\2\2\2/\u00ce\3\2\2\2\61\u00d0\3\2\2\2\63"+
		"\u00d2\3\2\2\2\65\u00d4\3\2\2\2\67\u00d6\3\2\2\29\u00d8\3\2\2\2;\u00da"+
		"\3\2\2\2=\u00dc\3\2\2\2?\u00de\3\2\2\2A\u00e0\3\2\2\2C\u00e2\3\2\2\2E"+
		"\u00e4\3\2\2\2G\u00e7\3\2\2\2I\u00ea\3\2\2\2K\u00ed\3\2\2\2M\u00f0\3\2"+
		"\2\2O\u00f2\3\2\2\2Q\u00f4\3\2\2\2S\u00f7\3\2\2\2U\u00f9\3\2\2\2W\u00fc"+
		"\3\2\2\2Y\u0104\3\2\2\2[\u010e\3\2\2\2]\u0110\3\2\2\2_\u011d\3\2\2\2a"+
		"\u0121\3\2\2\2c\u012c\3\2\2\2e\u013b\3\2\2\2gh\7k\2\2hi\7p\2\2ij\7v\2"+
		"\2j\4\3\2\2\2kl\7d\2\2lm\7q\2\2mn\7q\2\2no\7n\2\2o\6\3\2\2\2pq\7f\2\2"+
		"qr\7q\2\2rs\7w\2\2st\7d\2\2tu\7n\2\2uv\7g\2\2v\b\3\2\2\2wx\7e\2\2xy\7"+
		"n\2\2yz\7q\2\2z{\7e\2\2{|\7m\2\2|\n\3\2\2\2}~\7r\2\2~\177\7k\2\2\177\u0080"+
		"\7v\2\2\u0080\f\3\2\2\2\u0081\u0082\7x\2\2\u0082\u0083\7q\2\2\u0083\u0084"+
		"\7k\2\2\u0084\u0085\7f\2\2\u0085\16\3\2\2\2\u0086\u0087\7O\2\2\u0087\u0088"+
		"\7c\2\2\u0088\u0089\7k\2\2\u0089\u008a\7p\2\2\u008a\20\3\2\2\2\u008b\u008c"+
		"\7t\2\2\u008c\u008d\7g\2\2\u008d\u008e\7v\2\2\u008e\u008f\7w\2\2\u008f"+
		"\u0090\7t\2\2\u0090\u0091\7p\2\2\u0091\22\3\2\2\2\u0092\u0093\7k\2\2\u0093"+
		"\u0094\7h\2\2\u0094\24\3\2\2\2\u0095\u0096\7g\2\2\u0096\u0097\7n\2\2\u0097"+
		"\u0098\7u\2\2\u0098\u0099\7g\2\2\u0099\u009a\7\"\2\2\u009a\u009b\7k\2"+
		"\2\u009b\u009c\7h\2\2\u009c\26\3\2\2\2\u009d\u009e\7g\2\2\u009e\u009f"+
		"\7n\2\2\u009f\u00a0\7u\2\2\u00a0\u00a1\7g\2\2\u00a1\30\3\2\2\2\u00a2\u00a3"+
		"\7v\2\2\u00a3\u00a4\7q\2\2\u00a4\32\3\2\2\2\u00a5\u00a6\7h\2\2\u00a6\u00a7"+
		"\7q\2\2\u00a7\u00a8\7t\2\2\u00a8\34\3\2\2\2\u00a9\u00aa\5[.\2\u00aa\36"+
		"\3\2\2\2\u00ab\u00ac\5]/\2\u00ac \3\2\2\2\u00ad\u00ae\5\35\17\2\u00ae"+
		"\u00b0\7\60\2\2\u00af\u00b1\5\35\17\2\u00b0\u00af\3\2\2\2\u00b1\u00b2"+
		"\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\"\3\2\2\2\u00b4"+
		"\u00b5\5\37\20\2\u00b5\u00b7\7\60\2\2\u00b6\u00b8\5\35\17\2\u00b7\u00b6"+
		"\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"$\3\2\2\2\u00bb\u00bc\7v\2\2\u00bc\u00bd\7t\2\2\u00bd\u00be\7w\2\2\u00be"+
		"\u00c5\7g\2\2\u00bf\u00c0\7h\2\2\u00c0\u00c1\7c\2\2\u00c1\u00c2\7n\2\2"+
		"\u00c2\u00c3\7u\2\2\u00c3\u00c5\7g\2\2\u00c4\u00bb\3\2\2\2\u00c4\u00bf"+
		"\3\2\2\2\u00c5&\3\2\2\2\u00c6\u00c7\7}\2\2\u00c7(\3\2\2\2\u00c8\u00c9"+
		"\7\177\2\2\u00c9*\3\2\2\2\u00ca\u00cb\7*\2\2\u00cb,\3\2\2\2\u00cc\u00cd"+
		"\7+\2\2\u00cd.\3\2\2\2\u00ce\u00cf\7\60\2\2\u00cf\60\3\2\2\2\u00d0\u00d1"+
		"\7.\2\2\u00d1\62\3\2\2\2\u00d2\u00d3\7=\2\2\u00d3\64\3\2\2\2\u00d4\u00d5"+
		"\7A\2\2\u00d5\66\3\2\2\2\u00d6\u00d7\7<\2\2\u00d78\3\2\2\2\u00d8\u00d9"+
		"\7?\2\2\u00d9:\3\2\2\2\u00da\u00db\7-\2\2\u00db<\3\2\2\2\u00dc\u00dd\7"+
		"/\2\2\u00dd>\3\2\2\2\u00de\u00df\7\'\2\2\u00df@\3\2\2\2\u00e0\u00e1\7"+
		"\61\2\2\u00e1B\3\2\2\2\u00e2\u00e3\7,\2\2\u00e3D\3\2\2\2\u00e4\u00e5\7"+
		"?\2\2\u00e5\u00e6\7?\2\2\u00e6F\3\2\2\2\u00e7\u00e8\7(\2\2\u00e8\u00e9"+
		"\7(\2\2\u00e9H\3\2\2\2\u00ea\u00eb\7~\2\2\u00eb\u00ec\7~\2\2\u00ecJ\3"+
		"\2\2\2\u00ed\u00ee\7#\2\2\u00ee\u00ef\7?\2\2\u00efL\3\2\2\2\u00f0\u00f1"+
		"\7#\2\2\u00f1N\3\2\2\2\u00f2\u00f3\7@\2\2\u00f3P\3\2\2\2\u00f4\u00f5\7"+
		"@\2\2\u00f5\u00f6\7?\2\2\u00f6R\3\2\2\2\u00f7\u00f8\7>\2\2\u00f8T\3\2"+
		"\2\2\u00f9\u00fa\7>\2\2\u00fa\u00fb\7?\2\2\u00fbV\3\2\2\2\u00fc\u0101"+
		"\5Y-\2\u00fd\u0100\5Y-\2\u00fe\u0100\5\35\17\2\u00ff\u00fd\3\2\2\2\u00ff"+
		"\u00fe\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2"+
		"\2\2\u0102X\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0105\t\2\2\2\u0105Z\3\2"+
		"\2\2\u0106\u010f\7\62\2\2\u0107\u010b\4\63;\2\u0108\u010a\4\62;\2\u0109"+
		"\u0108\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2"+
		"\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u0106\3\2\2\2\u010e"+
		"\u0107\3\2\2\2\u010f\\\3\2\2\2\u0110\u0111\7*\2\2\u0111\u0112\7/\2\2\u0112"+
		"\u0113\3\2\2\2\u0113\u0117\4\63;\2\u0114\u0116\4\62;\2\u0115\u0114\3\2"+
		"\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118"+
		"\u011a\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011b\7+\2\2\u011b^\3\2\2\2\u011c"+
		"\u011e\t\3\2\2\u011d\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u011d\3\2"+
		"\2\2\u011f\u0120\3\2\2\2\u0120`\3\2\2\2\u0121\u0122\7\61\2\2\u0122\u0123"+
		"\7\61\2\2\u0123\u0127\3\2\2\2\u0124\u0126\n\4\2\2\u0125\u0124\3\2\2\2"+
		"\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012a"+
		"\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012b\b\61\2\2\u012bb\3\2\2\2\u012c"+
		"\u012d\7\61\2\2\u012d\u012e\7,\2\2\u012e\u0132\3\2\2\2\u012f\u0131\13"+
		"\2\2\2\u0130\u012f\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0133\3\2\2\2\u0132"+
		"\u0130\3\2\2\2\u0133\u0135\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0136\7,"+
		"\2\2\u0136\u0137\7\61\2\2\u0137\u0138\3\2\2\2\u0138\u0139\b\62\2\2\u0139"+
		"d\3\2\2\2\u013a\u013c\t\5\2\2\u013b\u013a\3\2\2\2\u013c\u013d\3\2\2\2"+
		"\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0140"+
		"\b\63\2\2\u0140f\3\2\2\2\17\2\u00b2\u00b9\u00c4\u00ff\u0101\u010b\u010e"+
		"\u0117\u011f\u0127\u0132\u013d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}