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
		INT=1, BOOLEAN=2, DOUBLE=3, CLOCK=4, STRING=5, PIT=6, VOID=7, MAIN=8, 
		RETURN=9, IF=10, ELSE_IF=11, ELSE=12, TO=13, FOR=14, AT=15, DIGIT=16, 
		DIGIT_NEGATIVE=17, DOUBLE_DIGIT=18, DOUBLE_DIGIT_NEGATIVE=19, BOOL_LITERAL=20, 
		STRING_LITERAL=21, LEFT_BRACKET=22, RIGHT_BRACKET=23, LEFT_PAREN=24, RIGHT_PAREN=25, 
		DOT=26, COMMA=27, SEMICOLON=28, QUESTION=29, COLON=30, ASSIGN=31, ADD=32, 
		SUB=33, MOD=34, DIV=35, MUL=36, EQUAL=37, AND=38, OR=39, NOT_EQUAL=40, 
		NOT=41, GREATER_THAN=42, GREATER_OR_EQUAL=43, LESS_THAN=44, LESS_OR_EQUAL=45, 
		ID=46, COMMENT_STRING=47, COMMENT_BLOCK=48, WS=49;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "BOOLEAN", "DOUBLE", "CLOCK", "STRING", "PIT", "VOID", "MAIN", 
			"RETURN", "IF", "ELSE_IF", "ELSE", "TO", "FOR", "AT", "DIGIT", "DIGIT_NEGATIVE", 
			"DOUBLE_DIGIT", "DOUBLE_DIGIT_NEGATIVE", "BOOL_LITERAL", "STRING_LITERAL", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\63\u0153\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\23\6\23\u00bf\n\23\r\23\16\23\u00c0\3\24\3\24\3\24\6"+
		"\24\u00c6\n\24\r\24\16\24\u00c7\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\5\25\u00d3\n\25\3\26\3\26\7\26\u00d7\n\26\f\26\16\26\u00da\13\26"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3"+
		"&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3-\3.\3"+
		".\3.\3/\3/\3/\7/\u0117\n/\f/\16/\u011a\13/\3\60\3\60\3\61\3\61\3\61\7"+
		"\61\u0121\n\61\f\61\16\61\u0124\13\61\5\61\u0126\n\61\3\62\3\62\3\62\3"+
		"\62\3\62\7\62\u012d\n\62\f\62\16\62\u0130\13\62\3\62\3\62\3\63\3\63\3"+
		"\63\3\63\7\63\u0138\n\63\f\63\16\63\u013b\13\63\3\63\3\63\3\64\3\64\3"+
		"\64\3\64\7\64\u0143\n\64\f\64\16\64\u0146\13\64\3\64\3\64\3\64\3\64\3"+
		"\64\3\65\6\65\u014e\n\65\r\65\16\65\u014f\3\65\3\65\3\u0144\2\66\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\2a\2c\2e\61g\62i\63\3\2\6\6\2\f\f"+
		"\17\17$$^^\3\2C|\4\2\13\f\17\17\5\2\13\f\17\17\"\"\2\u015b\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W"+
		"\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2"+
		"\2\2\3k\3\2\2\2\5o\3\2\2\2\7t\3\2\2\2\t{\3\2\2\2\13\u0081\3\2\2\2\r\u0088"+
		"\3\2\2\2\17\u008c\3\2\2\2\21\u0091\3\2\2\2\23\u0096\3\2\2\2\25\u009d\3"+
		"\2\2\2\27\u00a0\3\2\2\2\31\u00a8\3\2\2\2\33\u00ad\3\2\2\2\35\u00b0\3\2"+
		"\2\2\37\u00b4\3\2\2\2!\u00b7\3\2\2\2#\u00b9\3\2\2\2%\u00bb\3\2\2\2\'\u00c2"+
		"\3\2\2\2)\u00d2\3\2\2\2+\u00d4\3\2\2\2-\u00dd\3\2\2\2/\u00df\3\2\2\2\61"+
		"\u00e1\3\2\2\2\63\u00e3\3\2\2\2\65\u00e5\3\2\2\2\67\u00e7\3\2\2\29\u00e9"+
		"\3\2\2\2;\u00eb\3\2\2\2=\u00ed\3\2\2\2?\u00ef\3\2\2\2A\u00f1\3\2\2\2C"+
		"\u00f3\3\2\2\2E\u00f5\3\2\2\2G\u00f7\3\2\2\2I\u00f9\3\2\2\2K\u00fb\3\2"+
		"\2\2M\u00fe\3\2\2\2O\u0101\3\2\2\2Q\u0104\3\2\2\2S\u0107\3\2\2\2U\u0109"+
		"\3\2\2\2W\u010b\3\2\2\2Y\u010e\3\2\2\2[\u0110\3\2\2\2]\u0113\3\2\2\2_"+
		"\u011b\3\2\2\2a\u0125\3\2\2\2c\u0127\3\2\2\2e\u0133\3\2\2\2g\u013e\3\2"+
		"\2\2i\u014d\3\2\2\2kl\7k\2\2lm\7p\2\2mn\7v\2\2n\4\3\2\2\2op\7d\2\2pq\7"+
		"q\2\2qr\7q\2\2rs\7n\2\2s\6\3\2\2\2tu\7f\2\2uv\7q\2\2vw\7w\2\2wx\7d\2\2"+
		"xy\7n\2\2yz\7g\2\2z\b\3\2\2\2{|\7e\2\2|}\7n\2\2}~\7q\2\2~\177\7e\2\2\177"+
		"\u0080\7m\2\2\u0080\n\3\2\2\2\u0081\u0082\7u\2\2\u0082\u0083\7v\2\2\u0083"+
		"\u0084\7t\2\2\u0084\u0085\7k\2\2\u0085\u0086\7p\2\2\u0086\u0087\7i\2\2"+
		"\u0087\f\3\2\2\2\u0088\u0089\7r\2\2\u0089\u008a\7k\2\2\u008a\u008b\7v"+
		"\2\2\u008b\16\3\2\2\2\u008c\u008d\7x\2\2\u008d\u008e\7q\2\2\u008e\u008f"+
		"\7k\2\2\u008f\u0090\7f\2\2\u0090\20\3\2\2\2\u0091\u0092\7O\2\2\u0092\u0093"+
		"\7c\2\2\u0093\u0094\7k\2\2\u0094\u0095\7p\2\2\u0095\22\3\2\2\2\u0096\u0097"+
		"\7t\2\2\u0097\u0098\7g\2\2\u0098\u0099\7v\2\2\u0099\u009a\7w\2\2\u009a"+
		"\u009b\7t\2\2\u009b\u009c\7p\2\2\u009c\24\3\2\2\2\u009d\u009e\7k\2\2\u009e"+
		"\u009f\7h\2\2\u009f\26\3\2\2\2\u00a0\u00a1\7g\2\2\u00a1\u00a2\7n\2\2\u00a2"+
		"\u00a3\7u\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a5\7\"\2\2\u00a5\u00a6\7k\2"+
		"\2\u00a6\u00a7\7h\2\2\u00a7\30\3\2\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa"+
		"\7n\2\2\u00aa\u00ab\7u\2\2\u00ab\u00ac\7g\2\2\u00ac\32\3\2\2\2\u00ad\u00ae"+
		"\7v\2\2\u00ae\u00af\7q\2\2\u00af\34\3\2\2\2\u00b0\u00b1\7h\2\2\u00b1\u00b2"+
		"\7q\2\2\u00b2\u00b3\7t\2\2\u00b3\36\3\2\2\2\u00b4\u00b5\7c\2\2\u00b5\u00b6"+
		"\7v\2\2\u00b6 \3\2\2\2\u00b7\u00b8\5a\61\2\u00b8\"\3\2\2\2\u00b9\u00ba"+
		"\5c\62\2\u00ba$\3\2\2\2\u00bb\u00bc\5!\21\2\u00bc\u00be\7\60\2\2\u00bd"+
		"\u00bf\5!\21\2\u00be\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00be\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1&\3\2\2\2\u00c2\u00c3\5#\22\2\u00c3\u00c5"+
		"\7\60\2\2\u00c4\u00c6\5!\21\2\u00c5\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2"+
		"\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8(\3\2\2\2\u00c9\u00ca\7"+
		"v\2\2\u00ca\u00cb\7t\2\2\u00cb\u00cc\7w\2\2\u00cc\u00d3\7g\2\2\u00cd\u00ce"+
		"\7h\2\2\u00ce\u00cf\7c\2\2\u00cf\u00d0\7n\2\2\u00d0\u00d1\7u\2\2\u00d1"+
		"\u00d3\7g\2\2\u00d2\u00c9\3\2\2\2\u00d2\u00cd\3\2\2\2\u00d3*\3\2\2\2\u00d4"+
		"\u00d8\7$\2\2\u00d5\u00d7\n\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\u00da\3\2"+
		"\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00db\3\2\2\2\u00da"+
		"\u00d8\3\2\2\2\u00db\u00dc\7$\2\2\u00dc,\3\2\2\2\u00dd\u00de\7}\2\2\u00de"+
		".\3\2\2\2\u00df\u00e0\7\177\2\2\u00e0\60\3\2\2\2\u00e1\u00e2\7*\2\2\u00e2"+
		"\62\3\2\2\2\u00e3\u00e4\7+\2\2\u00e4\64\3\2\2\2\u00e5\u00e6\7\60\2\2\u00e6"+
		"\66\3\2\2\2\u00e7\u00e8\7.\2\2\u00e88\3\2\2\2\u00e9\u00ea\7=\2\2\u00ea"+
		":\3\2\2\2\u00eb\u00ec\7A\2\2\u00ec<\3\2\2\2\u00ed\u00ee\7<\2\2\u00ee>"+
		"\3\2\2\2\u00ef\u00f0\7?\2\2\u00f0@\3\2\2\2\u00f1\u00f2\7-\2\2\u00f2B\3"+
		"\2\2\2\u00f3\u00f4\7/\2\2\u00f4D\3\2\2\2\u00f5\u00f6\7\'\2\2\u00f6F\3"+
		"\2\2\2\u00f7\u00f8\7\61\2\2\u00f8H\3\2\2\2\u00f9\u00fa\7,\2\2\u00faJ\3"+
		"\2\2\2\u00fb\u00fc\7?\2\2\u00fc\u00fd\7?\2\2\u00fdL\3\2\2\2\u00fe\u00ff"+
		"\7(\2\2\u00ff\u0100\7(\2\2\u0100N\3\2\2\2\u0101\u0102\7~\2\2\u0102\u0103"+
		"\7~\2\2\u0103P\3\2\2\2\u0104\u0105\7#\2\2\u0105\u0106\7?\2\2\u0106R\3"+
		"\2\2\2\u0107\u0108\7#\2\2\u0108T\3\2\2\2\u0109\u010a\7@\2\2\u010aV\3\2"+
		"\2\2\u010b\u010c\7@\2\2\u010c\u010d\7?\2\2\u010dX\3\2\2\2\u010e\u010f"+
		"\7>\2\2\u010fZ\3\2\2\2\u0110\u0111\7>\2\2\u0111\u0112\7?\2\2\u0112\\\3"+
		"\2\2\2\u0113\u0118\5_\60\2\u0114\u0117\5_\60\2\u0115\u0117\5!\21\2\u0116"+
		"\u0114\3\2\2\2\u0116\u0115\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2"+
		"\2\2\u0118\u0119\3\2\2\2\u0119^\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011c"+
		"\t\3\2\2\u011c`\3\2\2\2\u011d\u0126\7\62\2\2\u011e\u0122\4\63;\2\u011f"+
		"\u0121\4\62;\2\u0120\u011f\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2"+
		"\2\2\u0122\u0123\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0125"+
		"\u011d\3\2\2\2\u0125\u011e\3\2\2\2\u0126b\3\2\2\2\u0127\u0128\7*\2\2\u0128"+
		"\u0129\7/\2\2\u0129\u012a\3\2\2\2\u012a\u012e\4\63;\2\u012b\u012d\4\62"+
		";\2\u012c\u012b\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e"+
		"\u012f\3\2\2\2\u012f\u0131\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0132\7+"+
		"\2\2\u0132d\3\2\2\2\u0133\u0134\7\61\2\2\u0134\u0135\7\61\2\2\u0135\u0139"+
		"\3\2\2\2\u0136\u0138\n\4\2\2\u0137\u0136\3\2\2\2\u0138\u013b\3\2\2\2\u0139"+
		"\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013c\3\2\2\2\u013b\u0139\3\2"+
		"\2\2\u013c\u013d\b\63\2\2\u013df\3\2\2\2\u013e\u013f\7\61\2\2\u013f\u0140"+
		"\7,\2\2\u0140\u0144\3\2\2\2\u0141\u0143\13\2\2\2\u0142\u0141\3\2\2\2\u0143"+
		"\u0146\3\2\2\2\u0144\u0145\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u0147\3\2"+
		"\2\2\u0146\u0144\3\2\2\2\u0147\u0148\7,\2\2\u0148\u0149\7\61\2\2\u0149"+
		"\u014a\3\2\2\2\u014a\u014b\b\64\2\2\u014bh\3\2\2\2\u014c\u014e\t\5\2\2"+
		"\u014d\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150"+
		"\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0152\b\65\2\2\u0152j\3\2\2\2\17\2"+
		"\u00c0\u00c7\u00d2\u00d8\u0116\u0118\u0122\u0125\u012e\u0139\u0144\u014f"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}