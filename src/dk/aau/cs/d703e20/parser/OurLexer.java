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
		INT=1, BOOLEAN=2, DOUBLE=3, CLOCK=4, STRING=5, PIT=6, VOID=7, LOOP=8, 
		SETUP=9, RETURN=10, IF=11, ELSE_IF=12, ELSE=13, TO=14, FOR=15, AT=16, 
		DIGIT=17, DIGIT_NEGATIVE=18, DOUBLE_DIGIT=19, DOUBLE_DIGIT_NEGATIVE=20, 
		BOOL_LITERAL=21, STRING_LITERAL=22, LEFT_BRACKET=23, RIGHT_BRACKET=24, 
		LEFT_PAREN=25, RIGHT_PAREN=26, DOT=27, COMMA=28, SEMICOLON=29, QUESTION=30, 
		COLON=31, ASSIGN=32, ADD=33, SUB=34, MOD=35, DIV=36, MUL=37, EQUAL=38, 
		AND=39, OR=40, NOT_EQUAL=41, NOT=42, GREATER_THAN=43, GREATER_OR_EQUAL=44, 
		LESS_THAN=45, LESS_OR_EQUAL=46, ID=47, COMMENT_STRING=48, COMMENT_BLOCK=49, 
		WS=50;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "BOOLEAN", "DOUBLE", "CLOCK", "STRING", "PIT", "VOID", "LOOP", 
			"SETUP", "RETURN", "IF", "ELSE_IF", "ELSE", "TO", "FOR", "AT", "DIGIT", 
			"DIGIT_NEGATIVE", "DOUBLE_DIGIT", "DOUBLE_DIGIT_NEGATIVE", "BOOL_LITERAL", 
			"STRING_LITERAL", "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", 
			"DOT", "COMMA", "SEMICOLON", "QUESTION", "COLON", "ASSIGN", "ADD", "SUB", 
			"MOD", "DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", "NOT", "GREATER_THAN", 
			"GREATER_OR_EQUAL", "LESS_THAN", "LESS_OR_EQUAL", "ID", "LETTER", "DIGIT_RULE", 
			"DIGIT_NEGATIVE_RULE", "COMMENT_STRING", "COMMENT_BLOCK", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'bool'", "'double'", "'clock'", "'string'", "'pit'", 
			"'void'", "'Loop'", "'Setup'", "'return'", "'if'", "'else if'", "'else'", 
			"'to'", "'for'", "'at'", null, null, null, null, null, null, "'{'", "'}'", 
			"'('", "')'", "'.'", "','", "';'", "'?'", "':'", "'='", "'+'", "'-'", 
			"'%'", "'/'", "'*'", "'=='", "'&&'", "'||'", "'!='", "'!'", "'>'", "'>='", 
			"'<'", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "BOOLEAN", "DOUBLE", "CLOCK", "STRING", "PIT", "VOID", "LOOP", 
			"SETUP", "RETURN", "IF", "ELSE_IF", "ELSE", "TO", "FOR", "AT", "DIGIT", 
			"DIGIT_NEGATIVE", "DOUBLE_DIGIT", "DOUBLE_DIGIT_NEGATIVE", "BOOL_LITERAL", 
			"STRING_LITERAL", "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", 
			"DOT", "COMMA", "SEMICOLON", "QUESTION", "COLON", "ASSIGN", "ADD", "SUB", 
			"MOD", "DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", "NOT", "GREATER_THAN", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u0160\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\6\24\u00c7"+
		"\n\24\r\24\16\24\u00c8\3\25\3\25\3\25\3\25\3\25\3\25\6\25\u00d1\n\25\r"+
		"\25\16\25\u00d2\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\5\26\u00e0\n\26\3\27\3\27\7\27\u00e4\n\27\f\27\16\27\u00e7\13\27\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3"+
		"\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3,\3,\3-\3-\3-\3.\3.\3/\3/\3/\3\60"+
		"\3\60\3\60\7\60\u0124\n\60\f\60\16\60\u0127\13\60\3\61\3\61\3\62\3\62"+
		"\3\62\7\62\u012e\n\62\f\62\16\62\u0131\13\62\5\62\u0133\n\62\3\63\3\63"+
		"\3\63\3\63\3\63\7\63\u013a\n\63\f\63\16\63\u013d\13\63\3\63\3\63\3\64"+
		"\3\64\3\64\3\64\7\64\u0145\n\64\f\64\16\64\u0148\13\64\3\64\3\64\3\65"+
		"\3\65\3\65\3\65\7\65\u0150\n\65\f\65\16\65\u0153\13\65\3\65\3\65\3\65"+
		"\3\65\3\65\3\66\6\66\u015b\n\66\r\66\16\66\u015c\3\66\3\66\3\u0151\2\67"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\2c\2e\2g\62i\63k\64\3\2\6"+
		"\6\2\f\f\17\17$$^^\3\2C|\4\2\13\f\17\17\5\2\13\f\17\17\"\"\2\u0168\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3"+
		"\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2g\3\2\2"+
		"\2\2i\3\2\2\2\2k\3\2\2\2\3m\3\2\2\2\5q\3\2\2\2\7v\3\2\2\2\t}\3\2\2\2\13"+
		"\u0083\3\2\2\2\r\u008a\3\2\2\2\17\u008e\3\2\2\2\21\u0093\3\2\2\2\23\u0098"+
		"\3\2\2\2\25\u009e\3\2\2\2\27\u00a5\3\2\2\2\31\u00a8\3\2\2\2\33\u00b0\3"+
		"\2\2\2\35\u00b5\3\2\2\2\37\u00b8\3\2\2\2!\u00bc\3\2\2\2#\u00bf\3\2\2\2"+
		"%\u00c1\3\2\2\2\'\u00c3\3\2\2\2)\u00ca\3\2\2\2+\u00df\3\2\2\2-\u00e1\3"+
		"\2\2\2/\u00ea\3\2\2\2\61\u00ec\3\2\2\2\63\u00ee\3\2\2\2\65\u00f0\3\2\2"+
		"\2\67\u00f2\3\2\2\29\u00f4\3\2\2\2;\u00f6\3\2\2\2=\u00f8\3\2\2\2?\u00fa"+
		"\3\2\2\2A\u00fc\3\2\2\2C\u00fe\3\2\2\2E\u0100\3\2\2\2G\u0102\3\2\2\2I"+
		"\u0104\3\2\2\2K\u0106\3\2\2\2M\u0108\3\2\2\2O\u010b\3\2\2\2Q\u010e\3\2"+
		"\2\2S\u0111\3\2\2\2U\u0114\3\2\2\2W\u0116\3\2\2\2Y\u0118\3\2\2\2[\u011b"+
		"\3\2\2\2]\u011d\3\2\2\2_\u0120\3\2\2\2a\u0128\3\2\2\2c\u0132\3\2\2\2e"+
		"\u0134\3\2\2\2g\u0140\3\2\2\2i\u014b\3\2\2\2k\u015a\3\2\2\2mn\7k\2\2n"+
		"o\7p\2\2op\7v\2\2p\4\3\2\2\2qr\7d\2\2rs\7q\2\2st\7q\2\2tu\7n\2\2u\6\3"+
		"\2\2\2vw\7f\2\2wx\7q\2\2xy\7w\2\2yz\7d\2\2z{\7n\2\2{|\7g\2\2|\b\3\2\2"+
		"\2}~\7e\2\2~\177\7n\2\2\177\u0080\7q\2\2\u0080\u0081\7e\2\2\u0081\u0082"+
		"\7m\2\2\u0082\n\3\2\2\2\u0083\u0084\7u\2\2\u0084\u0085\7v\2\2\u0085\u0086"+
		"\7t\2\2\u0086\u0087\7k\2\2\u0087\u0088\7p\2\2\u0088\u0089\7i\2\2\u0089"+
		"\f\3\2\2\2\u008a\u008b\7r\2\2\u008b\u008c\7k\2\2\u008c\u008d\7v\2\2\u008d"+
		"\16\3\2\2\2\u008e\u008f\7x\2\2\u008f\u0090\7q\2\2\u0090\u0091\7k\2\2\u0091"+
		"\u0092\7f\2\2\u0092\20\3\2\2\2\u0093\u0094\7N\2\2\u0094\u0095\7q\2\2\u0095"+
		"\u0096\7q\2\2\u0096\u0097\7r\2\2\u0097\22\3\2\2\2\u0098\u0099\7U\2\2\u0099"+
		"\u009a\7g\2\2\u009a\u009b\7v\2\2\u009b\u009c\7w\2\2\u009c\u009d\7r\2\2"+
		"\u009d\24\3\2\2\2\u009e\u009f\7t\2\2\u009f\u00a0\7g\2\2\u00a0\u00a1\7"+
		"v\2\2\u00a1\u00a2\7w\2\2\u00a2\u00a3\7t\2\2\u00a3\u00a4\7p\2\2\u00a4\26"+
		"\3\2\2\2\u00a5\u00a6\7k\2\2\u00a6\u00a7\7h\2\2\u00a7\30\3\2\2\2\u00a8"+
		"\u00a9\7g\2\2\u00a9\u00aa\7n\2\2\u00aa\u00ab\7u\2\2\u00ab\u00ac\7g\2\2"+
		"\u00ac\u00ad\7\"\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7h\2\2\u00af\32\3"+
		"\2\2\2\u00b0\u00b1\7g\2\2\u00b1\u00b2\7n\2\2\u00b2\u00b3\7u\2\2\u00b3"+
		"\u00b4\7g\2\2\u00b4\34\3\2\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7\7q\2\2\u00b7"+
		"\36\3\2\2\2\u00b8\u00b9\7h\2\2\u00b9\u00ba\7q\2\2\u00ba\u00bb\7t\2\2\u00bb"+
		" \3\2\2\2\u00bc\u00bd\7c\2\2\u00bd\u00be\7v\2\2\u00be\"\3\2\2\2\u00bf"+
		"\u00c0\5c\62\2\u00c0$\3\2\2\2\u00c1\u00c2\5e\63\2\u00c2&\3\2\2\2\u00c3"+
		"\u00c4\5#\22\2\u00c4\u00c6\7\60\2\2\u00c5\u00c7\5#\22\2\u00c6\u00c5\3"+
		"\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"(\3\2\2\2\u00ca\u00cb\7*\2\2\u00cb\u00cc\7/\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\u00ce\5#\22\2\u00ce\u00d0\7\60\2\2\u00cf\u00d1\5#\22\2\u00d0\u00cf\3"+
		"\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00d5\7+\2\2\u00d5*\3\2\2\2\u00d6\u00d7\7v\2\2\u00d7"+
		"\u00d8\7t\2\2\u00d8\u00d9\7w\2\2\u00d9\u00e0\7g\2\2\u00da\u00db\7h\2\2"+
		"\u00db\u00dc\7c\2\2\u00dc\u00dd\7n\2\2\u00dd\u00de\7u\2\2\u00de\u00e0"+
		"\7g\2\2\u00df\u00d6\3\2\2\2\u00df\u00da\3\2\2\2\u00e0,\3\2\2\2\u00e1\u00e5"+
		"\7$\2\2\u00e2\u00e4\n\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5"+
		"\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e8\3\2\2\2\u00e7\u00e5\3\2"+
		"\2\2\u00e8\u00e9\7$\2\2\u00e9.\3\2\2\2\u00ea\u00eb\7}\2\2\u00eb\60\3\2"+
		"\2\2\u00ec\u00ed\7\177\2\2\u00ed\62\3\2\2\2\u00ee\u00ef\7*\2\2\u00ef\64"+
		"\3\2\2\2\u00f0\u00f1\7+\2\2\u00f1\66\3\2\2\2\u00f2\u00f3\7\60\2\2\u00f3"+
		"8\3\2\2\2\u00f4\u00f5\7.\2\2\u00f5:\3\2\2\2\u00f6\u00f7\7=\2\2\u00f7<"+
		"\3\2\2\2\u00f8\u00f9\7A\2\2\u00f9>\3\2\2\2\u00fa\u00fb\7<\2\2\u00fb@\3"+
		"\2\2\2\u00fc\u00fd\7?\2\2\u00fdB\3\2\2\2\u00fe\u00ff\7-\2\2\u00ffD\3\2"+
		"\2\2\u0100\u0101\7/\2\2\u0101F\3\2\2\2\u0102\u0103\7\'\2\2\u0103H\3\2"+
		"\2\2\u0104\u0105\7\61\2\2\u0105J\3\2\2\2\u0106\u0107\7,\2\2\u0107L\3\2"+
		"\2\2\u0108\u0109\7?\2\2\u0109\u010a\7?\2\2\u010aN\3\2\2\2\u010b\u010c"+
		"\7(\2\2\u010c\u010d\7(\2\2\u010dP\3\2\2\2\u010e\u010f\7~\2\2\u010f\u0110"+
		"\7~\2\2\u0110R\3\2\2\2\u0111\u0112\7#\2\2\u0112\u0113\7?\2\2\u0113T\3"+
		"\2\2\2\u0114\u0115\7#\2\2\u0115V\3\2\2\2\u0116\u0117\7@\2\2\u0117X\3\2"+
		"\2\2\u0118\u0119\7@\2\2\u0119\u011a\7?\2\2\u011aZ\3\2\2\2\u011b\u011c"+
		"\7>\2\2\u011c\\\3\2\2\2\u011d\u011e\7>\2\2\u011e\u011f\7?\2\2\u011f^\3"+
		"\2\2\2\u0120\u0125\5a\61\2\u0121\u0124\5a\61\2\u0122\u0124\5#\22\2\u0123"+
		"\u0121\3\2\2\2\u0123\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2"+
		"\2\2\u0125\u0126\3\2\2\2\u0126`\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u0129"+
		"\t\3\2\2\u0129b\3\2\2\2\u012a\u0133\7\62\2\2\u012b\u012f\4\63;\2\u012c"+
		"\u012e\4\62;\2\u012d\u012c\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2"+
		"\2\2\u012f\u0130\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0132"+
		"\u012a\3\2\2\2\u0132\u012b\3\2\2\2\u0133d\3\2\2\2\u0134\u0135\7*\2\2\u0135"+
		"\u0136\7/\2\2\u0136\u0137\3\2\2\2\u0137\u013b\4\63;\2\u0138\u013a\4\62"+
		";\2\u0139\u0138\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u013f\7+"+
		"\2\2\u013ff\3\2\2\2\u0140\u0141\7\61\2\2\u0141\u0142\7\61\2\2\u0142\u0146"+
		"\3\2\2\2\u0143\u0145\n\4\2\2\u0144\u0143\3\2\2\2\u0145\u0148\3\2\2\2\u0146"+
		"\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0149\3\2\2\2\u0148\u0146\3\2"+
		"\2\2\u0149\u014a\b\64\2\2\u014ah\3\2\2\2\u014b\u014c\7\61\2\2\u014c\u014d"+
		"\7,\2\2\u014d\u0151\3\2\2\2\u014e\u0150\13\2\2\2\u014f\u014e\3\2\2\2\u0150"+
		"\u0153\3\2\2\2\u0151\u0152\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0154\3\2"+
		"\2\2\u0153\u0151\3\2\2\2\u0154\u0155\7,\2\2\u0155\u0156\7\61\2\2\u0156"+
		"\u0157\3\2\2\2\u0157\u0158\b\65\2\2\u0158j\3\2\2\2\u0159\u015b\t\5\2\2"+
		"\u015a\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d"+
		"\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u015f\b\66\2\2\u015fl\3\2\2\2\17\2"+
		"\u00c8\u00d2\u00df\u00e5\u0123\u0125\u012f\u0132\u013b\u0146\u0151\u015c"+
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