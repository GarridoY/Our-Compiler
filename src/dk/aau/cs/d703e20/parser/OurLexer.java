// Generated from /Users/ruofanwu/Projects/P7/src/OurLexer.g4 by ANTLR 4.8
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
		CLOCK=7, STRING=8, VOID=9, IPIN=10, OPIN=11, ANALOGPIN=12, SUBSCRIPT=13, 
		LOOP=14, SETUP=15, RETURN=16, IF=17, ELSE_IF=18, ELSE=19, TO=20, FOR=21, 
		WHILE=22, AT=23, BOUND=24, FINAL=25, CATCH=26, DIGIT=27, DIGIT_NEGATIVE=28, 
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
			"CLOCK", "STRING", "VOID", "IPIN", "OPIN", "ANALOGPIN", "SUBSCRIPT", 
			"LOOP", "SETUP", "RETURN", "IF", "ELSE_IF", "ELSE", "TO", "FOR", "WHILE", 
			"AT", "BOUND", "FINAL", "CATCH", "DIGIT", "DIGIT_NEGATIVE", "DOUBLE_DIGIT", 
			"DOUBLE_DIGIT_NEGATIVE", "BOOL_LITERAL", "STRING_LITERAL", "LEFT_SQBRACKET", 
			"RIGHT_SQBRACKET", "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", 
			"DOT", "COMMA", "SEMICOLON", "QUESTION", "COLON", "ASSIGN", "ADD", "SUB", 
			"MOD", "DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", "NOT", "GREATER_THAN", 
			"GREATER_OR_EQUAL", "LESS_THAN", "LESS_OR_EQUAL", "ID", "LETTER", "DIGIT_RULE", 
			"DIGIT_NEGATIVE_RULE", "COMMENT_STRING", "COMMENT_BLOCK", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", null, "'bool'", null, "'double'", null, "'clock'", "'string'", 
			"'void'", "'ipin'", "'opin'", null, null, "'Loop'", "'Setup'", "'return'", 
			"'if'", "'else if'", "'else'", "'to'", "'for'", "'while'", "'at'", "'bound'", 
			"'final'", "'catch'", null, null, null, null, null, null, "'['", "']'", 
			"'{'", "'}'", "'('", "')'", "'.'", "','", "';'", "'?'", "':'", "'='", 
			"'+'", "'-'", "'%'", "'/'", "'*'", "'=='", "'&&'", "'||'", "'!='", "'!'", 
			"'>'", "'>='", "'<'", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "INT_ARRAY", "BOOLEAN", "BOOLEAN_ARRAY", "DOUBLE", "DOUBLE_ARRAY", 
			"CLOCK", "STRING", "VOID", "IPIN", "OPIN", "ANALOGPIN", "SUBSCRIPT", 
			"LOOP", "SETUP", "RETURN", "IF", "ELSE_IF", "ELSE", "TO", "FOR", "WHILE", 
			"AT", "BOUND", "FINAL", "CATCH", "DIGIT", "DIGIT_NEGATIVE", "DOUBLE_DIGIT", 
			"DOUBLE_DIGIT_NEGATIVE", "BOOL_LITERAL", "STRING_LITERAL", "LEFT_SQBRACKET", 
			"RIGHT_SQBRACKET", "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2@\u01c4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\5\3\u0090\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\5\5\u00a0\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\5\7\u00b4\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3"+
		"\36\3\36\6\36\u0127\n\36\r\36\16\36\u0128\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\6\37\u0131\n\37\r\37\16\37\u0132\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \5 \u0140\n \3!\3!\7!\u0144\n!\f!\16!\u0147\13!\3!\3!\3\"\3\"\3#\3#\3"+
		"$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/"+
		"\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3"+
		"\65\3\65\3\66\3\66\3\66\3\67\3\67\38\38\39\39\39\3:\3:\3;\3;\3;\3<\3<"+
		"\3<\7<\u0188\n<\f<\16<\u018b\13<\3=\3=\3>\3>\3>\7>\u0192\n>\f>\16>\u0195"+
		"\13>\5>\u0197\n>\3?\3?\3?\3?\3?\7?\u019e\n?\f?\16?\u01a1\13?\3?\3?\3@"+
		"\3@\3@\3@\7@\u01a9\n@\f@\16@\u01ac\13@\3@\3@\3A\3A\3A\3A\7A\u01b4\nA\f"+
		"A\16A\u01b7\13A\3A\3A\3A\3A\3A\3B\6B\u01bf\nB\rB\16B\u01c0\3B\3B\3\u01b5"+
		"\2C\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u<w=y\2{\2}\2\177>\u0081?\u0083@\3\2\6\6\2\f\f\17\17$$^^\3\2C"+
		"|\4\2\13\f\17\17\5\2\13\f\17\17\"\"\2\u01cf\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2"+
		"\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2"+
		"s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083"+
		"\3\2\2\2\3\u0085\3\2\2\2\5\u0089\3\2\2\2\7\u0093\3\2\2\2\t\u0098\3\2\2"+
		"\2\13\u00a3\3\2\2\2\r\u00aa\3\2\2\2\17\u00b7\3\2\2\2\21\u00bd\3\2\2\2"+
		"\23\u00c4\3\2\2\2\25\u00c9\3\2\2\2\27\u00ce\3\2\2\2\31\u00d3\3\2\2\2\33"+
		"\u00d6\3\2\2\2\35\u00db\3\2\2\2\37\u00e0\3\2\2\2!\u00e6\3\2\2\2#\u00ed"+
		"\3\2\2\2%\u00f0\3\2\2\2\'\u00f8\3\2\2\2)\u00fd\3\2\2\2+\u0100\3\2\2\2"+
		"-\u0104\3\2\2\2/\u010a\3\2\2\2\61\u010d\3\2\2\2\63\u0113\3\2\2\2\65\u0119"+
		"\3\2\2\2\67\u011f\3\2\2\29\u0121\3\2\2\2;\u0123\3\2\2\2=\u012a\3\2\2\2"+
		"?\u013f\3\2\2\2A\u0141\3\2\2\2C\u014a\3\2\2\2E\u014c\3\2\2\2G\u014e\3"+
		"\2\2\2I\u0150\3\2\2\2K\u0152\3\2\2\2M\u0154\3\2\2\2O\u0156\3\2\2\2Q\u0158"+
		"\3\2\2\2S\u015a\3\2\2\2U\u015c\3\2\2\2W\u015e\3\2\2\2Y\u0160\3\2\2\2["+
		"\u0162\3\2\2\2]\u0164\3\2\2\2_\u0166\3\2\2\2a\u0168\3\2\2\2c\u016a\3\2"+
		"\2\2e\u016c\3\2\2\2g\u016f\3\2\2\2i\u0172\3\2\2\2k\u0175\3\2\2\2m\u0178"+
		"\3\2\2\2o\u017a\3\2\2\2q\u017c\3\2\2\2s\u017f\3\2\2\2u\u0181\3\2\2\2w"+
		"\u0184\3\2\2\2y\u018c\3\2\2\2{\u0196\3\2\2\2}\u0198\3\2\2\2\177\u01a4"+
		"\3\2\2\2\u0081\u01af\3\2\2\2\u0083\u01be\3\2\2\2\u0085\u0086\7k\2\2\u0086"+
		"\u0087\7p\2\2\u0087\u0088\7v\2\2\u0088\4\3\2\2\2\u0089\u008a\7k\2\2\u008a"+
		"\u008b\7p\2\2\u008b\u008c\7v\2\2\u008c\u008d\3\2\2\2\u008d\u008f\7]\2"+
		"\2\u008e\u0090\5\67\34\2\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u0092\7_\2\2\u0092\6\3\2\2\2\u0093\u0094\7d\2\2\u0094"+
		"\u0095\7q\2\2\u0095\u0096\7q\2\2\u0096\u0097\7n\2\2\u0097\b\3\2\2\2\u0098"+
		"\u0099\7d\2\2\u0099\u009a\7q\2\2\u009a\u009b\7q\2\2\u009b\u009c\7n\2\2"+
		"\u009c\u009d\3\2\2\2\u009d\u009f\7]\2\2\u009e\u00a0\5\67\34\2\u009f\u009e"+
		"\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\7_\2\2\u00a2"+
		"\n\3\2\2\2\u00a3\u00a4\7f\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7w\2\2\u00a6"+
		"\u00a7\7d\2\2\u00a7\u00a8\7n\2\2\u00a8\u00a9\7g\2\2\u00a9\f\3\2\2\2\u00aa"+
		"\u00ab\7f\2\2\u00ab\u00ac\7q\2\2\u00ac\u00ad\7w\2\2\u00ad\u00ae\7d\2\2"+
		"\u00ae\u00af\7n\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3"+
		"\7]\2\2\u00b2\u00b4\5\67\34\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2"+
		"\u00b4\u00b5\3\2\2\2\u00b5\u00b6\7_\2\2\u00b6\16\3\2\2\2\u00b7\u00b8\7"+
		"e\2\2\u00b8\u00b9\7n\2\2\u00b9\u00ba\7q\2\2\u00ba\u00bb\7e\2\2\u00bb\u00bc"+
		"\7m\2\2\u00bc\20\3\2\2\2\u00bd\u00be\7u\2\2\u00be\u00bf\7v\2\2\u00bf\u00c0"+
		"\7t\2\2\u00c0\u00c1\7k\2\2\u00c1\u00c2\7p\2\2\u00c2\u00c3\7i\2\2\u00c3"+
		"\22\3\2\2\2\u00c4\u00c5\7x\2\2\u00c5\u00c6\7q\2\2\u00c6\u00c7\7k\2\2\u00c7"+
		"\u00c8\7f\2\2\u00c8\24\3\2\2\2\u00c9\u00ca\7k\2\2\u00ca\u00cb\7r\2\2\u00cb"+
		"\u00cc\7k\2\2\u00cc\u00cd\7p\2\2\u00cd\26\3\2\2\2\u00ce\u00cf\7q\2\2\u00cf"+
		"\u00d0\7r\2\2\u00d0\u00d1\7k\2\2\u00d1\u00d2\7p\2\2\u00d2\30\3\2\2\2\u00d3"+
		"\u00d4\7C\2\2\u00d4\u00d5\5\67\34\2\u00d5\32\3\2\2\2\u00d6\u00d7\5w<\2"+
		"\u00d7\u00d8\7]\2\2\u00d8\u00d9\5\67\34\2\u00d9\u00da\7_\2\2\u00da\34"+
		"\3\2\2\2\u00db\u00dc\7N\2\2\u00dc\u00dd\7q\2\2\u00dd\u00de\7q\2\2\u00de"+
		"\u00df\7r\2\2\u00df\36\3\2\2\2\u00e0\u00e1\7U\2\2\u00e1\u00e2\7g\2\2\u00e2"+
		"\u00e3\7v\2\2\u00e3\u00e4\7w\2\2\u00e4\u00e5\7r\2\2\u00e5 \3\2\2\2\u00e6"+
		"\u00e7\7t\2\2\u00e7\u00e8\7g\2\2\u00e8\u00e9\7v\2\2\u00e9\u00ea\7w\2\2"+
		"\u00ea\u00eb\7t\2\2\u00eb\u00ec\7p\2\2\u00ec\"\3\2\2\2\u00ed\u00ee\7k"+
		"\2\2\u00ee\u00ef\7h\2\2\u00ef$\3\2\2\2\u00f0\u00f1\7g\2\2\u00f1\u00f2"+
		"\7n\2\2\u00f2\u00f3\7u\2\2\u00f3\u00f4\7g\2\2\u00f4\u00f5\7\"\2\2\u00f5"+
		"\u00f6\7k\2\2\u00f6\u00f7\7h\2\2\u00f7&\3\2\2\2\u00f8\u00f9\7g\2\2\u00f9"+
		"\u00fa\7n\2\2\u00fa\u00fb\7u\2\2\u00fb\u00fc\7g\2\2\u00fc(\3\2\2\2\u00fd"+
		"\u00fe\7v\2\2\u00fe\u00ff\7q\2\2\u00ff*\3\2\2\2\u0100\u0101\7h\2\2\u0101"+
		"\u0102\7q\2\2\u0102\u0103\7t\2\2\u0103,\3\2\2\2\u0104\u0105\7y\2\2\u0105"+
		"\u0106\7j\2\2\u0106\u0107\7k\2\2\u0107\u0108\7n\2\2\u0108\u0109\7g\2\2"+
		"\u0109.\3\2\2\2\u010a\u010b\7c\2\2\u010b\u010c\7v\2\2\u010c\60\3\2\2\2"+
		"\u010d\u010e\7d\2\2\u010e\u010f\7q\2\2\u010f\u0110\7w\2\2\u0110\u0111"+
		"\7p\2\2\u0111\u0112\7f\2\2\u0112\62\3\2\2\2\u0113\u0114\7h\2\2\u0114\u0115"+
		"\7k\2\2\u0115\u0116\7p\2\2\u0116\u0117\7c\2\2\u0117\u0118\7n\2\2\u0118"+
		"\64\3\2\2\2\u0119\u011a\7e\2\2\u011a\u011b\7c\2\2\u011b\u011c\7v\2\2\u011c"+
		"\u011d\7e\2\2\u011d\u011e\7j\2\2\u011e\66\3\2\2\2\u011f\u0120\5{>\2\u0120"+
		"8\3\2\2\2\u0121\u0122\5}?\2\u0122:\3\2\2\2\u0123\u0124\5\67\34\2\u0124"+
		"\u0126\7\60\2\2\u0125\u0127\5\67\34\2\u0126\u0125\3\2\2\2\u0127\u0128"+
		"\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129<\3\2\2\2\u012a"+
		"\u012b\7*\2\2\u012b\u012c\7/\2\2\u012c\u012d\3\2\2\2\u012d\u012e\5\67"+
		"\34\2\u012e\u0130\7\60\2\2\u012f\u0131\5\67\34\2\u0130\u012f\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\3\2"+
		"\2\2\u0134\u0135\7+\2\2\u0135>\3\2\2\2\u0136\u0137\7v\2\2\u0137\u0138"+
		"\7t\2\2\u0138\u0139\7w\2\2\u0139\u0140\7g\2\2\u013a\u013b\7h\2\2\u013b"+
		"\u013c\7c\2\2\u013c\u013d\7n\2\2\u013d\u013e\7u\2\2\u013e\u0140\7g\2\2"+
		"\u013f\u0136\3\2\2\2\u013f\u013a\3\2\2\2\u0140@\3\2\2\2\u0141\u0145\7"+
		"$\2\2\u0142\u0144\n\2\2\2\u0143\u0142\3\2\2\2\u0144\u0147\3\2\2\2\u0145"+
		"\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0148\3\2\2\2\u0147\u0145\3\2"+
		"\2\2\u0148\u0149\7$\2\2\u0149B\3\2\2\2\u014a\u014b\7]\2\2\u014bD\3\2\2"+
		"\2\u014c\u014d\7_\2\2\u014dF\3\2\2\2\u014e\u014f\7}\2\2\u014fH\3\2\2\2"+
		"\u0150\u0151\7\177\2\2\u0151J\3\2\2\2\u0152\u0153\7*\2\2\u0153L\3\2\2"+
		"\2\u0154\u0155\7+\2\2\u0155N\3\2\2\2\u0156\u0157\7\60\2\2\u0157P\3\2\2"+
		"\2\u0158\u0159\7.\2\2\u0159R\3\2\2\2\u015a\u015b\7=\2\2\u015bT\3\2\2\2"+
		"\u015c\u015d\7A\2\2\u015dV\3\2\2\2\u015e\u015f\7<\2\2\u015fX\3\2\2\2\u0160"+
		"\u0161\7?\2\2\u0161Z\3\2\2\2\u0162\u0163\7-\2\2\u0163\\\3\2\2\2\u0164"+
		"\u0165\7/\2\2\u0165^\3\2\2\2\u0166\u0167\7\'\2\2\u0167`\3\2\2\2\u0168"+
		"\u0169\7\61\2\2\u0169b\3\2\2\2\u016a\u016b\7,\2\2\u016bd\3\2\2\2\u016c"+
		"\u016d\7?\2\2\u016d\u016e\7?\2\2\u016ef\3\2\2\2\u016f\u0170\7(\2\2\u0170"+
		"\u0171\7(\2\2\u0171h\3\2\2\2\u0172\u0173\7~\2\2\u0173\u0174\7~\2\2\u0174"+
		"j\3\2\2\2\u0175\u0176\7#\2\2\u0176\u0177\7?\2\2\u0177l\3\2\2\2\u0178\u0179"+
		"\7#\2\2\u0179n\3\2\2\2\u017a\u017b\7@\2\2\u017bp\3\2\2\2\u017c\u017d\7"+
		"@\2\2\u017d\u017e\7?\2\2\u017er\3\2\2\2\u017f\u0180\7>\2\2\u0180t\3\2"+
		"\2\2\u0181\u0182\7>\2\2\u0182\u0183\7?\2\2\u0183v\3\2\2\2\u0184\u0189"+
		"\5y=\2\u0185\u0188\5y=\2\u0186\u0188\5\67\34\2\u0187\u0185\3\2\2\2\u0187"+
		"\u0186\3\2\2\2\u0188\u018b\3\2\2\2\u0189\u0187\3\2\2\2\u0189\u018a\3\2"+
		"\2\2\u018ax\3\2\2\2\u018b\u0189\3\2\2\2\u018c\u018d\t\3\2\2\u018dz\3\2"+
		"\2\2\u018e\u0197\7\62\2\2\u018f\u0193\4\63;\2\u0190\u0192\4\62;\2\u0191"+
		"\u0190\3\2\2\2\u0192\u0195\3\2\2\2\u0193\u0191\3\2\2\2\u0193\u0194\3\2"+
		"\2\2\u0194\u0197\3\2\2\2\u0195\u0193\3\2\2\2\u0196\u018e\3\2\2\2\u0196"+
		"\u018f\3\2\2\2\u0197|\3\2\2\2\u0198\u0199\7*\2\2\u0199\u019a\7/\2\2\u019a"+
		"\u019b\3\2\2\2\u019b\u019f\4\63;\2\u019c\u019e\4\62;\2\u019d\u019c\3\2"+
		"\2\2\u019e\u01a1\3\2\2\2\u019f\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0"+
		"\u01a2\3\2\2\2\u01a1\u019f\3\2\2\2\u01a2\u01a3\7+\2\2\u01a3~\3\2\2\2\u01a4"+
		"\u01a5\7\61\2\2\u01a5\u01a6\7\61\2\2\u01a6\u01aa\3\2\2\2\u01a7\u01a9\n"+
		"\4\2\2\u01a8\u01a7\3\2\2\2\u01a9\u01ac\3\2\2\2\u01aa\u01a8\3\2\2\2\u01aa"+
		"\u01ab\3\2\2\2\u01ab\u01ad\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ad\u01ae\b@"+
		"\2\2\u01ae\u0080\3\2\2\2\u01af\u01b0\7\61\2\2\u01b0\u01b1\7,\2\2\u01b1"+
		"\u01b5\3\2\2\2\u01b2\u01b4\13\2\2\2\u01b3\u01b2\3\2\2\2\u01b4\u01b7\3"+
		"\2\2\2\u01b5\u01b6\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b6\u01b8\3\2\2\2\u01b7"+
		"\u01b5\3\2\2\2\u01b8\u01b9\7,\2\2\u01b9\u01ba\7\61\2\2\u01ba\u01bb\3\2"+
		"\2\2\u01bb\u01bc\bA\2\2\u01bc\u0082\3\2\2\2\u01bd\u01bf\t\5\2\2\u01be"+
		"\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2"+
		"\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c3\bB\2\2\u01c3\u0084\3\2\2\2\22\2\u008f"+
		"\u009f\u00b3\u0128\u0132\u013f\u0145\u0187\u0189\u0193\u0196\u019f\u01aa"+
		"\u01b5\u01c0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}