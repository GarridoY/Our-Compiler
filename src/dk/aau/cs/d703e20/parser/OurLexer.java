// Generated from D:/GitHub/P7/src\OurLexer.g4 by ANTLR 4.9
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
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, INT_ARRAY=2, BOOLEAN=3, BOOLEAN_ARRAY=4, DOUBLE=5, DOUBLE_ARRAY=6, 
		CLOCK=7, STRING=8, VOID=9, IPIN=10, OPIN=11, IPPIN=12, ANALOGPIN=13, LED_BUILTIN=14, 
		SUBSCRIPT=15, LOOP=16, SETUP=17, RETURN=18, IF=19, ELSE_IF=20, ELSE=21, 
		TO=22, FOR=23, WHILE=24, AT=25, BOUND=26, FINAL=27, CATCH=28, DIGIT=29, 
		DIGIT_NEGATIVE=30, DOUBLE_DIGIT=31, DOUBLE_DIGIT_NEGATIVE=32, BOOL_LITERAL=33, 
		STRING_LITERAL=34, LEFT_SQBRACKET=35, RIGHT_SQBRACKET=36, LEFT_BRACKET=37, 
		RIGHT_BRACKET=38, LEFT_PAREN=39, RIGHT_PAREN=40, DOT=41, COMMA=42, SEMICOLON=43, 
		QUESTION=44, COLON=45, ASSIGN=46, ADD=47, SUB=48, MOD=49, DIV=50, MUL=51, 
		EQUAL=52, AND=53, OR=54, NOT_EQUAL=55, NOT=56, GREATER_THAN=57, GREATER_OR_EQUAL=58, 
		LESS_THAN=59, LESS_OR_EQUAL=60, ID=61, COMMENT_STRING=62, COMMENT_BLOCK=63, 
		WS=64;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "INT_ARRAY", "BOOLEAN", "BOOLEAN_ARRAY", "DOUBLE", "DOUBLE_ARRAY", 
			"CLOCK", "STRING", "VOID", "IPIN", "OPIN", "IPPIN", "ANALOGPIN", "LED_BUILTIN", 
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
			"'void'", "'ipin'", "'opin'", "'ippin'", null, "'LED_BUILTIN'", null, 
			"'Loop'", "'Setup'", "'return'", "'if'", "'else if'", "'else'", "'to'", 
			"'for'", "'while'", "'at'", "'bound'", "'final'", "'catch'", null, null, 
			null, null, null, null, "'['", "']'", "'{'", "'}'", "'('", "')'", "'.'", 
			"','", "';'", "'?'", "':'", "'='", "'+'", "'-'", "'%'", "'/'", "'*'", 
			"'=='", "'&&'", "'||'", "'!='", "'!'", "'>'", "'>='", "'<'", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "INT_ARRAY", "BOOLEAN", "BOOLEAN_ARRAY", "DOUBLE", "DOUBLE_ARRAY", 
			"CLOCK", "STRING", "VOID", "IPIN", "OPIN", "IPPIN", "ANALOGPIN", "LED_BUILTIN", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2B\u01da\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\3\2\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\5\3\u0094\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\5\5\u00a4\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00b8\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3"+
		"\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\36\3\36\3\37\3\37\3 \3 \3 \6 \u013d\n \r \16 \u013e\3!\3!\3!\3!"+
		"\3!\3!\6!\u0147\n!\r!\16!\u0148\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\5\"\u0156\n\"\3#\3#\7#\u015a\n#\f#\16#\u015d\13#\3#\3#\3$\3$\3%\3"+
		"%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3"+
		"\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3"+
		"\66\3\67\3\67\3\67\38\38\38\39\39\3:\3:\3;\3;\3;\3<\3<\3=\3=\3=\3>\3>"+
		"\3>\7>\u019e\n>\f>\16>\u01a1\13>\3?\3?\3@\3@\3@\7@\u01a8\n@\f@\16@\u01ab"+
		"\13@\5@\u01ad\n@\3A\3A\3A\3A\3A\7A\u01b4\nA\fA\16A\u01b7\13A\3A\3A\3B"+
		"\3B\3B\3B\7B\u01bf\nB\fB\16B\u01c2\13B\3B\3B\3C\3C\3C\3C\7C\u01ca\nC\f"+
		"C\16C\u01cd\13C\3C\3C\3C\3C\3C\3D\6D\u01d5\nD\rD\16D\u01d6\3D\3D\3\u01cb"+
		"\2E\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u<w=y>{?}\2\177\2\u0081\2\u0083@\u0085A\u0087B\3\2\6\6\2\f\f\17"+
		"\17$$^^\3\2C|\4\2\13\f\17\17\5\2\13\f\17\17\"\"\2\u01e5\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3"+
		"\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2"+
		"\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2"+
		"q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2\u0083"+
		"\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\3\u0089\3\2\2\2\5\u008d\3\2\2"+
		"\2\7\u0097\3\2\2\2\t\u009c\3\2\2\2\13\u00a7\3\2\2\2\r\u00ae\3\2\2\2\17"+
		"\u00bb\3\2\2\2\21\u00c1\3\2\2\2\23\u00c8\3\2\2\2\25\u00cd\3\2\2\2\27\u00d2"+
		"\3\2\2\2\31\u00d7\3\2\2\2\33\u00dd\3\2\2\2\35\u00e0\3\2\2\2\37\u00ec\3"+
		"\2\2\2!\u00f1\3\2\2\2#\u00f6\3\2\2\2%\u00fc\3\2\2\2\'\u0103\3\2\2\2)\u0106"+
		"\3\2\2\2+\u010e\3\2\2\2-\u0113\3\2\2\2/\u0116\3\2\2\2\61\u011a\3\2\2\2"+
		"\63\u0120\3\2\2\2\65\u0123\3\2\2\2\67\u0129\3\2\2\29\u012f\3\2\2\2;\u0135"+
		"\3\2\2\2=\u0137\3\2\2\2?\u0139\3\2\2\2A\u0140\3\2\2\2C\u0155\3\2\2\2E"+
		"\u0157\3\2\2\2G\u0160\3\2\2\2I\u0162\3\2\2\2K\u0164\3\2\2\2M\u0166\3\2"+
		"\2\2O\u0168\3\2\2\2Q\u016a\3\2\2\2S\u016c\3\2\2\2U\u016e\3\2\2\2W\u0170"+
		"\3\2\2\2Y\u0172\3\2\2\2[\u0174\3\2\2\2]\u0176\3\2\2\2_\u0178\3\2\2\2a"+
		"\u017a\3\2\2\2c\u017c\3\2\2\2e\u017e\3\2\2\2g\u0180\3\2\2\2i\u0182\3\2"+
		"\2\2k\u0185\3\2\2\2m\u0188\3\2\2\2o\u018b\3\2\2\2q\u018e\3\2\2\2s\u0190"+
		"\3\2\2\2u\u0192\3\2\2\2w\u0195\3\2\2\2y\u0197\3\2\2\2{\u019a\3\2\2\2}"+
		"\u01a2\3\2\2\2\177\u01ac\3\2\2\2\u0081\u01ae\3\2\2\2\u0083\u01ba\3\2\2"+
		"\2\u0085\u01c5\3\2\2\2\u0087\u01d4\3\2\2\2\u0089\u008a\7k\2\2\u008a\u008b"+
		"\7p\2\2\u008b\u008c\7v\2\2\u008c\4\3\2\2\2\u008d\u008e\7k\2\2\u008e\u008f"+
		"\7p\2\2\u008f\u0090\7v\2\2\u0090\u0091\3\2\2\2\u0091\u0093\7]\2\2\u0092"+
		"\u0094\5;\36\2\u0093\u0092\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2"+
		"\2\2\u0095\u0096\7_\2\2\u0096\6\3\2\2\2\u0097\u0098\7d\2\2\u0098\u0099"+
		"\7q\2\2\u0099\u009a\7q\2\2\u009a\u009b\7n\2\2\u009b\b\3\2\2\2\u009c\u009d"+
		"\7d\2\2\u009d\u009e\7q\2\2\u009e\u009f\7q\2\2\u009f\u00a0\7n\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a3\7]\2\2\u00a2\u00a4\5;\36\2\u00a3\u00a2\3\2"+
		"\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\7_\2\2\u00a6"+
		"\n\3\2\2\2\u00a7\u00a8\7f\2\2\u00a8\u00a9\7q\2\2\u00a9\u00aa\7w\2\2\u00aa"+
		"\u00ab\7d\2\2\u00ab\u00ac\7n\2\2\u00ac\u00ad\7g\2\2\u00ad\f\3\2\2\2\u00ae"+
		"\u00af\7f\2\2\u00af\u00b0\7q\2\2\u00b0\u00b1\7w\2\2\u00b1\u00b2\7d\2\2"+
		"\u00b2\u00b3\7n\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7"+
		"\7]\2\2\u00b6\u00b8\5;\36\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\u00b9\3\2\2\2\u00b9\u00ba\7_\2\2\u00ba\16\3\2\2\2\u00bb\u00bc\7e\2\2"+
		"\u00bc\u00bd\7n\2\2\u00bd\u00be\7q\2\2\u00be\u00bf\7e\2\2\u00bf\u00c0"+
		"\7m\2\2\u00c0\20\3\2\2\2\u00c1\u00c2\7u\2\2\u00c2\u00c3\7v\2\2\u00c3\u00c4"+
		"\7t\2\2\u00c4\u00c5\7k\2\2\u00c5\u00c6\7p\2\2\u00c6\u00c7\7i\2\2\u00c7"+
		"\22\3\2\2\2\u00c8\u00c9\7x\2\2\u00c9\u00ca\7q\2\2\u00ca\u00cb\7k\2\2\u00cb"+
		"\u00cc\7f\2\2\u00cc\24\3\2\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf\7r\2\2\u00cf"+
		"\u00d0\7k\2\2\u00d0\u00d1\7p\2\2\u00d1\26\3\2\2\2\u00d2\u00d3\7q\2\2\u00d3"+
		"\u00d4\7r\2\2\u00d4\u00d5\7k\2\2\u00d5\u00d6\7p\2\2\u00d6\30\3\2\2\2\u00d7"+
		"\u00d8\7k\2\2\u00d8\u00d9\7r\2\2\u00d9\u00da\7r\2\2\u00da\u00db\7k\2\2"+
		"\u00db\u00dc\7p\2\2\u00dc\32\3\2\2\2\u00dd\u00de\7C\2\2\u00de\u00df\5"+
		";\36\2\u00df\34\3\2\2\2\u00e0\u00e1\7N\2\2\u00e1\u00e2\7G\2\2\u00e2\u00e3"+
		"\7F\2\2\u00e3\u00e4\7a\2\2\u00e4\u00e5\7D\2\2\u00e5\u00e6\7W\2\2\u00e6"+
		"\u00e7\7K\2\2\u00e7\u00e8\7N\2\2\u00e8\u00e9\7V\2\2\u00e9\u00ea\7K\2\2"+
		"\u00ea\u00eb\7P\2\2\u00eb\36\3\2\2\2\u00ec\u00ed\5{>\2\u00ed\u00ee\7]"+
		"\2\2\u00ee\u00ef\5;\36\2\u00ef\u00f0\7_\2\2\u00f0 \3\2\2\2\u00f1\u00f2"+
		"\7N\2\2\u00f2\u00f3\7q\2\2\u00f3\u00f4\7q\2\2\u00f4\u00f5\7r\2\2\u00f5"+
		"\"\3\2\2\2\u00f6\u00f7\7U\2\2\u00f7\u00f8\7g\2\2\u00f8\u00f9\7v\2\2\u00f9"+
		"\u00fa\7w\2\2\u00fa\u00fb\7r\2\2\u00fb$\3\2\2\2\u00fc\u00fd\7t\2\2\u00fd"+
		"\u00fe\7g\2\2\u00fe\u00ff\7v\2\2\u00ff\u0100\7w\2\2\u0100\u0101\7t\2\2"+
		"\u0101\u0102\7p\2\2\u0102&\3\2\2\2\u0103\u0104\7k\2\2\u0104\u0105\7h\2"+
		"\2\u0105(\3\2\2\2\u0106\u0107\7g\2\2\u0107\u0108\7n\2\2\u0108\u0109\7"+
		"u\2\2\u0109\u010a\7g\2\2\u010a\u010b\7\"\2\2\u010b\u010c\7k\2\2\u010c"+
		"\u010d\7h\2\2\u010d*\3\2\2\2\u010e\u010f\7g\2\2\u010f\u0110\7n\2\2\u0110"+
		"\u0111\7u\2\2\u0111\u0112\7g\2\2\u0112,\3\2\2\2\u0113\u0114\7v\2\2\u0114"+
		"\u0115\7q\2\2\u0115.\3\2\2\2\u0116\u0117\7h\2\2\u0117\u0118\7q\2\2\u0118"+
		"\u0119\7t\2\2\u0119\60\3\2\2\2\u011a\u011b\7y\2\2\u011b\u011c\7j\2\2\u011c"+
		"\u011d\7k\2\2\u011d\u011e\7n\2\2\u011e\u011f\7g\2\2\u011f\62\3\2\2\2\u0120"+
		"\u0121\7c\2\2\u0121\u0122\7v\2\2\u0122\64\3\2\2\2\u0123\u0124\7d\2\2\u0124"+
		"\u0125\7q\2\2\u0125\u0126\7w\2\2\u0126\u0127\7p\2\2\u0127\u0128\7f\2\2"+
		"\u0128\66\3\2\2\2\u0129\u012a\7h\2\2\u012a\u012b\7k\2\2\u012b\u012c\7"+
		"p\2\2\u012c\u012d\7c\2\2\u012d\u012e\7n\2\2\u012e8\3\2\2\2\u012f\u0130"+
		"\7e\2\2\u0130\u0131\7c\2\2\u0131\u0132\7v\2\2\u0132\u0133\7e\2\2\u0133"+
		"\u0134\7j\2\2\u0134:\3\2\2\2\u0135\u0136\5\177@\2\u0136<\3\2\2\2\u0137"+
		"\u0138\5\u0081A\2\u0138>\3\2\2\2\u0139\u013a\5;\36\2\u013a\u013c\7\60"+
		"\2\2\u013b\u013d\5;\36\2\u013c\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e"+
		"\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f@\3\2\2\2\u0140\u0141\7*\2\2\u0141"+
		"\u0142\7/\2\2\u0142\u0143\3\2\2\2\u0143\u0144\5;\36\2\u0144\u0146\7\60"+
		"\2\2\u0145\u0147\5;\36\2\u0146\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148"+
		"\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014b\7+"+
		"\2\2\u014bB\3\2\2\2\u014c\u014d\7v\2\2\u014d\u014e\7t\2\2\u014e\u014f"+
		"\7w\2\2\u014f\u0156\7g\2\2\u0150\u0151\7h\2\2\u0151\u0152\7c\2\2\u0152"+
		"\u0153\7n\2\2\u0153\u0154\7u\2\2\u0154\u0156\7g\2\2\u0155\u014c\3\2\2"+
		"\2\u0155\u0150\3\2\2\2\u0156D\3\2\2\2\u0157\u015b\7$\2\2\u0158\u015a\n"+
		"\2\2\2\u0159\u0158\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b"+
		"\u015c\3\2\2\2\u015c\u015e\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u015f\7$"+
		"\2\2\u015fF\3\2\2\2\u0160\u0161\7]\2\2\u0161H\3\2\2\2\u0162\u0163\7_\2"+
		"\2\u0163J\3\2\2\2\u0164\u0165\7}\2\2\u0165L\3\2\2\2\u0166\u0167\7\177"+
		"\2\2\u0167N\3\2\2\2\u0168\u0169\7*\2\2\u0169P\3\2\2\2\u016a\u016b\7+\2"+
		"\2\u016bR\3\2\2\2\u016c\u016d\7\60\2\2\u016dT\3\2\2\2\u016e\u016f\7.\2"+
		"\2\u016fV\3\2\2\2\u0170\u0171\7=\2\2\u0171X\3\2\2\2\u0172\u0173\7A\2\2"+
		"\u0173Z\3\2\2\2\u0174\u0175\7<\2\2\u0175\\\3\2\2\2\u0176\u0177\7?\2\2"+
		"\u0177^\3\2\2\2\u0178\u0179\7-\2\2\u0179`\3\2\2\2\u017a\u017b\7/\2\2\u017b"+
		"b\3\2\2\2\u017c\u017d\7\'\2\2\u017dd\3\2\2\2\u017e\u017f\7\61\2\2\u017f"+
		"f\3\2\2\2\u0180\u0181\7,\2\2\u0181h\3\2\2\2\u0182\u0183\7?\2\2\u0183\u0184"+
		"\7?\2\2\u0184j\3\2\2\2\u0185\u0186\7(\2\2\u0186\u0187\7(\2\2\u0187l\3"+
		"\2\2\2\u0188\u0189\7~\2\2\u0189\u018a\7~\2\2\u018an\3\2\2\2\u018b\u018c"+
		"\7#\2\2\u018c\u018d\7?\2\2\u018dp\3\2\2\2\u018e\u018f\7#\2\2\u018fr\3"+
		"\2\2\2\u0190\u0191\7@\2\2\u0191t\3\2\2\2\u0192\u0193\7@\2\2\u0193\u0194"+
		"\7?\2\2\u0194v\3\2\2\2\u0195\u0196\7>\2\2\u0196x\3\2\2\2\u0197\u0198\7"+
		">\2\2\u0198\u0199\7?\2\2\u0199z\3\2\2\2\u019a\u019f\5}?\2\u019b\u019e"+
		"\5}?\2\u019c\u019e\5;\36\2\u019d\u019b\3\2\2\2\u019d\u019c\3\2\2\2\u019e"+
		"\u01a1\3\2\2\2\u019f\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0|\3\2\2\2"+
		"\u01a1\u019f\3\2\2\2\u01a2\u01a3\t\3\2\2\u01a3~\3\2\2\2\u01a4\u01ad\7"+
		"\62\2\2\u01a5\u01a9\4\63;\2\u01a6\u01a8\4\62;\2\u01a7\u01a6\3\2\2\2\u01a8"+
		"\u01ab\3\2\2\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ad\3\2"+
		"\2\2\u01ab\u01a9\3\2\2\2\u01ac\u01a4\3\2\2\2\u01ac\u01a5\3\2\2\2\u01ad"+
		"\u0080\3\2\2\2\u01ae\u01af\7*\2\2\u01af\u01b0\7/\2\2\u01b0\u01b1\3\2\2"+
		"\2\u01b1\u01b5\4\63;\2\u01b2\u01b4\4\62;\2\u01b3\u01b2\3\2\2\2\u01b4\u01b7"+
		"\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b8\3\2\2\2\u01b7"+
		"\u01b5\3\2\2\2\u01b8\u01b9\7+\2\2\u01b9\u0082\3\2\2\2\u01ba\u01bb\7\61"+
		"\2\2\u01bb\u01bc\7\61\2\2\u01bc\u01c0\3\2\2\2\u01bd\u01bf\n\4\2\2\u01be"+
		"\u01bd\3\2\2\2\u01bf\u01c2\3\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2"+
		"\2\2\u01c1\u01c3\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c3\u01c4\bB\2\2\u01c4"+
		"\u0084\3\2\2\2\u01c5\u01c6\7\61\2\2\u01c6\u01c7\7,\2\2\u01c7\u01cb\3\2"+
		"\2\2\u01c8\u01ca\13\2\2\2\u01c9\u01c8\3\2\2\2\u01ca\u01cd\3\2\2\2\u01cb"+
		"\u01cc\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cc\u01ce\3\2\2\2\u01cd\u01cb\3\2"+
		"\2\2\u01ce\u01cf\7,\2\2\u01cf\u01d0\7\61\2\2\u01d0\u01d1\3\2\2\2\u01d1"+
		"\u01d2\bC\2\2\u01d2\u0086\3\2\2\2\u01d3\u01d5\t\5\2\2\u01d4\u01d3\3\2"+
		"\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7"+
		"\u01d8\3\2\2\2\u01d8\u01d9\bD\2\2\u01d9\u0088\3\2\2\2\22\2\u0093\u00a3"+
		"\u00b7\u013e\u0148\u0155\u015b\u019d\u019f\u01a9\u01ac\u01b5\u01c0\u01cb"+
		"\u01d6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}