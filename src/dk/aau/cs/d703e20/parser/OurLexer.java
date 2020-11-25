// Generated from D:/GitHub/P7/src\OurLexer.g4 by ANTLR 4.8
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
		CLOCK=7, STRING=8, VOID=9, IPIN=10, OPIN=11, ANALOGPIN=12, LED_BUILTIN=13, 
		SUBSCRIPT=14, LOOP=15, SETUP=16, RETURN=17, IF=18, ELSE_IF=19, ELSE=20, 
		TO=21, FOR=22, WHILE=23, AT=24, BOUND=25, FINAL=26, CATCH=27, DIGIT=28, 
		DIGIT_NEGATIVE=29, DOUBLE_DIGIT=30, DOUBLE_DIGIT_NEGATIVE=31, BOOL_LITERAL=32, 
		STRING_LITERAL=33, LEFT_SQBRACKET=34, RIGHT_SQBRACKET=35, LEFT_BRACKET=36, 
		RIGHT_BRACKET=37, LEFT_PAREN=38, RIGHT_PAREN=39, DOT=40, COMMA=41, SEMICOLON=42, 
		QUESTION=43, COLON=44, ASSIGN=45, ADD=46, SUB=47, MOD=48, DIV=49, MUL=50, 
		EQUAL=51, AND=52, OR=53, NOT_EQUAL=54, NOT=55, GREATER_THAN=56, GREATER_OR_EQUAL=57, 
		LESS_THAN=58, LESS_OR_EQUAL=59, ID=60, COMMENT_STRING=61, COMMENT_BLOCK=62, 
		WS=63;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "INT_ARRAY", "BOOLEAN", "BOOLEAN_ARRAY", "DOUBLE", "DOUBLE_ARRAY", 
			"CLOCK", "STRING", "VOID", "IPIN", "OPIN", "ANALOGPIN", "LED_BUILTIN", 
			"SUBSCRIPT", "LOOP", "SETUP", "RETURN", "IF", "ELSE_IF", "ELSE", "TO", 
			"FOR", "WHILE", "AT", "BOUND", "FINAL", "CATCH", "DIGIT", "DIGIT_NEGATIVE", 
			"DOUBLE_DIGIT", "DOUBLE_DIGIT_NEGATIVE", "BOOL_LITERAL", "STRING_LITERAL", 
			"LEFT_SQBRACKET", "RIGHT_SQBRACKET", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"LEFT_PAREN", "RIGHT_PAREN", "DOT", "COMMA", "SEMICOLON", "QUESTION", 
			"COLON", "ASSIGN", "ADD", "SUB", "MOD", "DIV", "MUL", "EQUAL", "AND", 
			"OR", "NOT_EQUAL", "NOT", "GREATER_THAN", "GREATER_OR_EQUAL", "LESS_THAN", 
			"LESS_OR_EQUAL", "ID", "LETTER", "DIGIT_RULE", "DIGIT_NEGATIVE_RULE", 
			"COMMENT_STRING", "COMMENT_BLOCK", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", null, "'bool'", null, "'double'", null, "'clock'", "'string'", 
			"'void'", "'ipin'", "'opin'", null, "'LED_BUILTIN'", null, "'Loop'", 
			"'Setup'", "'return'", "'if'", "'else if'", "'else'", "'to'", "'for'", 
			"'while'", "'at'", "'bound'", "'final'", "'catch'", null, null, null, 
			null, null, null, "'['", "']'", "'{'", "'}'", "'('", "')'", "'.'", "','", 
			"';'", "'?'", "':'", "'='", "'+'", "'-'", "'%'", "'/'", "'*'", "'=='", 
			"'&&'", "'||'", "'!='", "'!'", "'>'", "'>='", "'<'", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "INT_ARRAY", "BOOLEAN", "BOOLEAN_ARRAY", "DOUBLE", "DOUBLE_ARRAY", 
			"CLOCK", "STRING", "VOID", "IPIN", "OPIN", "ANALOGPIN", "LED_BUILTIN", 
			"SUBSCRIPT", "LOOP", "SETUP", "RETURN", "IF", "ELSE_IF", "ELSE", "TO", 
			"FOR", "WHILE", "AT", "BOUND", "FINAL", "CATCH", "DIGIT", "DIGIT_NEGATIVE", 
			"DOUBLE_DIGIT", "DOUBLE_DIGIT_NEGATIVE", "BOOL_LITERAL", "STRING_LITERAL", 
			"LEFT_SQBRACKET", "RIGHT_SQBRACKET", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"LEFT_PAREN", "RIGHT_PAREN", "DOT", "COMMA", "SEMICOLON", "QUESTION", 
			"COLON", "ASSIGN", "ADD", "SUB", "MOD", "DIV", "MUL", "EQUAL", "AND", 
			"OR", "NOT_EQUAL", "NOT", "GREATER_THAN", "GREATER_OR_EQUAL", "LESS_THAN", 
			"LESS_OR_EQUAL", "ID", "COMMENT_STRING", "COMMENT_BLOCK", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2A\u01d2\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\3\u0092\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\5\u00a2\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\5\7\u00b6\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3"+
		"\37\6\37\u0135\n\37\r\37\16\37\u0136\3 \3 \3 \3 \3 \3 \6 \u013f\n \r "+
		"\16 \u0140\3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u014e\n!\3\"\3\"\7\"\u0152"+
		"\n\"\f\"\16\"\u0155\13\"\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3"+
		"(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3"+
		"\62\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3"+
		"\67\38\38\39\39\3:\3:\3:\3;\3;\3<\3<\3<\3=\3=\3=\7=\u0196\n=\f=\16=\u0199"+
		"\13=\3>\3>\3?\3?\3?\7?\u01a0\n?\f?\16?\u01a3\13?\5?\u01a5\n?\3@\3@\3@"+
		"\3@\3@\7@\u01ac\n@\f@\16@\u01af\13@\3@\3@\3A\3A\3A\3A\7A\u01b7\nA\fA\16"+
		"A\u01ba\13A\3A\3A\3B\3B\3B\3B\7B\u01c2\nB\fB\16B\u01c5\13B\3B\3B\3B\3"+
		"B\3B\3C\6C\u01cd\nC\rC\16C\u01ce\3C\3C\3\u01c3\2D\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O"+
		")Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{\2}\2\177"+
		"\2\u0081?\u0083@\u0085A\3\2\6\6\2\f\f\17\17$$^^\3\2C|\4\2\13\f\17\17\5"+
		"\2\13\f\17\17\"\"\2\u01dd\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]"+
		"\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2"+
		"\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2"+
		"\2w\3\2\2\2\2y\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2"+
		"\3\u0087\3\2\2\2\5\u008b\3\2\2\2\7\u0095\3\2\2\2\t\u009a\3\2\2\2\13\u00a5"+
		"\3\2\2\2\r\u00ac\3\2\2\2\17\u00b9\3\2\2\2\21\u00bf\3\2\2\2\23\u00c6\3"+
		"\2\2\2\25\u00cb\3\2\2\2\27\u00d0\3\2\2\2\31\u00d5\3\2\2\2\33\u00d8\3\2"+
		"\2\2\35\u00e4\3\2\2\2\37\u00e9\3\2\2\2!\u00ee\3\2\2\2#\u00f4\3\2\2\2%"+
		"\u00fb\3\2\2\2\'\u00fe\3\2\2\2)\u0106\3\2\2\2+\u010b\3\2\2\2-\u010e\3"+
		"\2\2\2/\u0112\3\2\2\2\61\u0118\3\2\2\2\63\u011b\3\2\2\2\65\u0121\3\2\2"+
		"\2\67\u0127\3\2\2\29\u012d\3\2\2\2;\u012f\3\2\2\2=\u0131\3\2\2\2?\u0138"+
		"\3\2\2\2A\u014d\3\2\2\2C\u014f\3\2\2\2E\u0158\3\2\2\2G\u015a\3\2\2\2I"+
		"\u015c\3\2\2\2K\u015e\3\2\2\2M\u0160\3\2\2\2O\u0162\3\2\2\2Q\u0164\3\2"+
		"\2\2S\u0166\3\2\2\2U\u0168\3\2\2\2W\u016a\3\2\2\2Y\u016c\3\2\2\2[\u016e"+
		"\3\2\2\2]\u0170\3\2\2\2_\u0172\3\2\2\2a\u0174\3\2\2\2c\u0176\3\2\2\2e"+
		"\u0178\3\2\2\2g\u017a\3\2\2\2i\u017d\3\2\2\2k\u0180\3\2\2\2m\u0183\3\2"+
		"\2\2o\u0186\3\2\2\2q\u0188\3\2\2\2s\u018a\3\2\2\2u\u018d\3\2\2\2w\u018f"+
		"\3\2\2\2y\u0192\3\2\2\2{\u019a\3\2\2\2}\u01a4\3\2\2\2\177\u01a6\3\2\2"+
		"\2\u0081\u01b2\3\2\2\2\u0083\u01bd\3\2\2\2\u0085\u01cc\3\2\2\2\u0087\u0088"+
		"\7k\2\2\u0088\u0089\7p\2\2\u0089\u008a\7v\2\2\u008a\4\3\2\2\2\u008b\u008c"+
		"\7k\2\2\u008c\u008d\7p\2\2\u008d\u008e\7v\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u0091\7]\2\2\u0090\u0092\59\35\2\u0091\u0090\3\2\2\2\u0091\u0092\3\2"+
		"\2\2\u0092\u0093\3\2\2\2\u0093\u0094\7_\2\2\u0094\6\3\2\2\2\u0095\u0096"+
		"\7d\2\2\u0096\u0097\7q\2\2\u0097\u0098\7q\2\2\u0098\u0099\7n\2\2\u0099"+
		"\b\3\2\2\2\u009a\u009b\7d\2\2\u009b\u009c\7q\2\2\u009c\u009d\7q\2\2\u009d"+
		"\u009e\7n\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\7]\2\2\u00a0\u00a2\59\35"+
		"\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4"+
		"\7_\2\2\u00a4\n\3\2\2\2\u00a5\u00a6\7f\2\2\u00a6\u00a7\7q\2\2\u00a7\u00a8"+
		"\7w\2\2\u00a8\u00a9\7d\2\2\u00a9\u00aa\7n\2\2\u00aa\u00ab\7g\2\2\u00ab"+
		"\f\3\2\2\2\u00ac\u00ad\7f\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af\7w\2\2\u00af"+
		"\u00b0\7d\2\2\u00b0\u00b1\7n\2\2\u00b1\u00b2\7g\2\2\u00b2\u00b3\3\2\2"+
		"\2\u00b3\u00b5\7]\2\2\u00b4\u00b6\59\35\2\u00b5\u00b4\3\2\2\2\u00b5\u00b6"+
		"\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\7_\2\2\u00b8\16\3\2\2\2\u00b9"+
		"\u00ba\7e\2\2\u00ba\u00bb\7n\2\2\u00bb\u00bc\7q\2\2\u00bc\u00bd\7e\2\2"+
		"\u00bd\u00be\7m\2\2\u00be\20\3\2\2\2\u00bf\u00c0\7u\2\2\u00c0\u00c1\7"+
		"v\2\2\u00c1\u00c2\7t\2\2\u00c2\u00c3\7k\2\2\u00c3\u00c4\7p\2\2\u00c4\u00c5"+
		"\7i\2\2\u00c5\22\3\2\2\2\u00c6\u00c7\7x\2\2\u00c7\u00c8\7q\2\2\u00c8\u00c9"+
		"\7k\2\2\u00c9\u00ca\7f\2\2\u00ca\24\3\2\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cd"+
		"\7r\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf\7p\2\2\u00cf\26\3\2\2\2\u00d0\u00d1"+
		"\7q\2\2\u00d1\u00d2\7r\2\2\u00d2\u00d3\7k\2\2\u00d3\u00d4\7p\2\2\u00d4"+
		"\30\3\2\2\2\u00d5\u00d6\7C\2\2\u00d6\u00d7\59\35\2\u00d7\32\3\2\2\2\u00d8"+
		"\u00d9\7N\2\2\u00d9\u00da\7G\2\2\u00da\u00db\7F\2\2\u00db\u00dc\7a\2\2"+
		"\u00dc\u00dd\7D\2\2\u00dd\u00de\7W\2\2\u00de\u00df\7K\2\2\u00df\u00e0"+
		"\7N\2\2\u00e0\u00e1\7V\2\2\u00e1\u00e2\7K\2\2\u00e2\u00e3\7P\2\2\u00e3"+
		"\34\3\2\2\2\u00e4\u00e5\5y=\2\u00e5\u00e6\7]\2\2\u00e6\u00e7\59\35\2\u00e7"+
		"\u00e8\7_\2\2\u00e8\36\3\2\2\2\u00e9\u00ea\7N\2\2\u00ea\u00eb\7q\2\2\u00eb"+
		"\u00ec\7q\2\2\u00ec\u00ed\7r\2\2\u00ed \3\2\2\2\u00ee\u00ef\7U\2\2\u00ef"+
		"\u00f0\7g\2\2\u00f0\u00f1\7v\2\2\u00f1\u00f2\7w\2\2\u00f2\u00f3\7r\2\2"+
		"\u00f3\"\3\2\2\2\u00f4\u00f5\7t\2\2\u00f5\u00f6\7g\2\2\u00f6\u00f7\7v"+
		"\2\2\u00f7\u00f8\7w\2\2\u00f8\u00f9\7t\2\2\u00f9\u00fa\7p\2\2\u00fa$\3"+
		"\2\2\2\u00fb\u00fc\7k\2\2\u00fc\u00fd\7h\2\2\u00fd&\3\2\2\2\u00fe\u00ff"+
		"\7g\2\2\u00ff\u0100\7n\2\2\u0100\u0101\7u\2\2\u0101\u0102\7g\2\2\u0102"+
		"\u0103\7\"\2\2\u0103\u0104\7k\2\2\u0104\u0105\7h\2\2\u0105(\3\2\2\2\u0106"+
		"\u0107\7g\2\2\u0107\u0108\7n\2\2\u0108\u0109\7u\2\2\u0109\u010a\7g\2\2"+
		"\u010a*\3\2\2\2\u010b\u010c\7v\2\2\u010c\u010d\7q\2\2\u010d,\3\2\2\2\u010e"+
		"\u010f\7h\2\2\u010f\u0110\7q\2\2\u0110\u0111\7t\2\2\u0111.\3\2\2\2\u0112"+
		"\u0113\7y\2\2\u0113\u0114\7j\2\2\u0114\u0115\7k\2\2\u0115\u0116\7n\2\2"+
		"\u0116\u0117\7g\2\2\u0117\60\3\2\2\2\u0118\u0119\7c\2\2\u0119\u011a\7"+
		"v\2\2\u011a\62\3\2\2\2\u011b\u011c\7d\2\2\u011c\u011d\7q\2\2\u011d\u011e"+
		"\7w\2\2\u011e\u011f\7p\2\2\u011f\u0120\7f\2\2\u0120\64\3\2\2\2\u0121\u0122"+
		"\7h\2\2\u0122\u0123\7k\2\2\u0123\u0124\7p\2\2\u0124\u0125\7c\2\2\u0125"+
		"\u0126\7n\2\2\u0126\66\3\2\2\2\u0127\u0128\7e\2\2\u0128\u0129\7c\2\2\u0129"+
		"\u012a\7v\2\2\u012a\u012b\7e\2\2\u012b\u012c\7j\2\2\u012c8\3\2\2\2\u012d"+
		"\u012e\5}?\2\u012e:\3\2\2\2\u012f\u0130\5\177@\2\u0130<\3\2\2\2\u0131"+
		"\u0132\59\35\2\u0132\u0134\7\60\2\2\u0133\u0135\59\35\2\u0134\u0133\3"+
		"\2\2\2\u0135\u0136\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137"+
		">\3\2\2\2\u0138\u0139\7*\2\2\u0139\u013a\7/\2\2\u013a\u013b\3\2\2\2\u013b"+
		"\u013c\59\35\2\u013c\u013e\7\60\2\2\u013d\u013f\59\35\2\u013e\u013d\3"+
		"\2\2\2\u013f\u0140\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141"+
		"\u0142\3\2\2\2\u0142\u0143\7+\2\2\u0143@\3\2\2\2\u0144\u0145\7v\2\2\u0145"+
		"\u0146\7t\2\2\u0146\u0147\7w\2\2\u0147\u014e\7g\2\2\u0148\u0149\7h\2\2"+
		"\u0149\u014a\7c\2\2\u014a\u014b\7n\2\2\u014b\u014c\7u\2\2\u014c\u014e"+
		"\7g\2\2\u014d\u0144\3\2\2\2\u014d\u0148\3\2\2\2\u014eB\3\2\2\2\u014f\u0153"+
		"\7$\2\2\u0150\u0152\n\2\2\2\u0151\u0150\3\2\2\2\u0152\u0155\3\2\2\2\u0153"+
		"\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0156\3\2\2\2\u0155\u0153\3\2"+
		"\2\2\u0156\u0157\7$\2\2\u0157D\3\2\2\2\u0158\u0159\7]\2\2\u0159F\3\2\2"+
		"\2\u015a\u015b\7_\2\2\u015bH\3\2\2\2\u015c\u015d\7}\2\2\u015dJ\3\2\2\2"+
		"\u015e\u015f\7\177\2\2\u015fL\3\2\2\2\u0160\u0161\7*\2\2\u0161N\3\2\2"+
		"\2\u0162\u0163\7+\2\2\u0163P\3\2\2\2\u0164\u0165\7\60\2\2\u0165R\3\2\2"+
		"\2\u0166\u0167\7.\2\2\u0167T\3\2\2\2\u0168\u0169\7=\2\2\u0169V\3\2\2\2"+
		"\u016a\u016b\7A\2\2\u016bX\3\2\2\2\u016c\u016d\7<\2\2\u016dZ\3\2\2\2\u016e"+
		"\u016f\7?\2\2\u016f\\\3\2\2\2\u0170\u0171\7-\2\2\u0171^\3\2\2\2\u0172"+
		"\u0173\7/\2\2\u0173`\3\2\2\2\u0174\u0175\7\'\2\2\u0175b\3\2\2\2\u0176"+
		"\u0177\7\61\2\2\u0177d\3\2\2\2\u0178\u0179\7,\2\2\u0179f\3\2\2\2\u017a"+
		"\u017b\7?\2\2\u017b\u017c\7?\2\2\u017ch\3\2\2\2\u017d\u017e\7(\2\2\u017e"+
		"\u017f\7(\2\2\u017fj\3\2\2\2\u0180\u0181\7~\2\2\u0181\u0182\7~\2\2\u0182"+
		"l\3\2\2\2\u0183\u0184\7#\2\2\u0184\u0185\7?\2\2\u0185n\3\2\2\2\u0186\u0187"+
		"\7#\2\2\u0187p\3\2\2\2\u0188\u0189\7@\2\2\u0189r\3\2\2\2\u018a\u018b\7"+
		"@\2\2\u018b\u018c\7?\2\2\u018ct\3\2\2\2\u018d\u018e\7>\2\2\u018ev\3\2"+
		"\2\2\u018f\u0190\7>\2\2\u0190\u0191\7?\2\2\u0191x\3\2\2\2\u0192\u0197"+
		"\5{>\2\u0193\u0196\5{>\2\u0194\u0196\59\35\2\u0195\u0193\3\2\2\2\u0195"+
		"\u0194\3\2\2\2\u0196\u0199\3\2\2\2\u0197\u0195\3\2\2\2\u0197\u0198\3\2"+
		"\2\2\u0198z\3\2\2\2\u0199\u0197\3\2\2\2\u019a\u019b\t\3\2\2\u019b|\3\2"+
		"\2\2\u019c\u01a5\7\62\2\2\u019d\u01a1\4\63;\2\u019e\u01a0\4\62;\2\u019f"+
		"\u019e\3\2\2\2\u01a0\u01a3\3\2\2\2\u01a1\u019f\3\2\2\2\u01a1\u01a2\3\2"+
		"\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a4\u019c\3\2\2\2\u01a4"+
		"\u019d\3\2\2\2\u01a5~\3\2\2\2\u01a6\u01a7\7*\2\2\u01a7\u01a8\7/\2\2\u01a8"+
		"\u01a9\3\2\2\2\u01a9\u01ad\4\63;\2\u01aa\u01ac\4\62;\2\u01ab\u01aa\3\2"+
		"\2\2\u01ac\u01af\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae"+
		"\u01b0\3\2\2\2\u01af\u01ad\3\2\2\2\u01b0\u01b1\7+\2\2\u01b1\u0080\3\2"+
		"\2\2\u01b2\u01b3\7\61\2\2\u01b3\u01b4\7\61\2\2\u01b4\u01b8\3\2\2\2\u01b5"+
		"\u01b7\n\4\2\2\u01b6\u01b5\3\2\2\2\u01b7\u01ba\3\2\2\2\u01b8\u01b6\3\2"+
		"\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01bb\3\2\2\2\u01ba\u01b8\3\2\2\2\u01bb"+
		"\u01bc\bA\2\2\u01bc\u0082\3\2\2\2\u01bd\u01be\7\61\2\2\u01be\u01bf\7,"+
		"\2\2\u01bf\u01c3\3\2\2\2\u01c0\u01c2\13\2\2\2\u01c1\u01c0\3\2\2\2\u01c2"+
		"\u01c5\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c4\u01c6\3\2"+
		"\2\2\u01c5\u01c3\3\2\2\2\u01c6\u01c7\7,\2\2\u01c7\u01c8\7\61\2\2\u01c8"+
		"\u01c9\3\2\2\2\u01c9\u01ca\bB\2\2\u01ca\u0084\3\2\2\2\u01cb\u01cd\t\5"+
		"\2\2\u01cc\u01cb\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce"+
		"\u01cf\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d1\bC\2\2\u01d1\u0086\3\2"+
		"\2\2\22\2\u0091\u00a1\u00b5\u0136\u0140\u014d\u0153\u0195\u0197\u01a1"+
		"\u01a4\u01ad\u01b8\u01c3\u01ce\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}