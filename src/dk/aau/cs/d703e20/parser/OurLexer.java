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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2>\u01b1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3\u008c\n"+
		"\3\f\3\16\3\u008f\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\6\34\u0114"+
		"\n\34\r\34\16\34\u0115\3\35\3\35\3\35\3\35\3\35\3\35\6\35\u011e\n\35\r"+
		"\35\16\35\u011f\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\5\36\u012d\n\36\3\37\3\37\7\37\u0131\n\37\f\37\16\37\u0134\13\37\3\37"+
		"\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)"+
		"\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\61\3\62\3\62"+
		"\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\3\67"+
		"\38\38\39\39\39\3:\3:\3:\7:\u0175\n:\f:\16:\u0178\13:\3;\3;\3<\3<\3<\7"+
		"<\u017f\n<\f<\16<\u0182\13<\5<\u0184\n<\3=\3=\3=\3=\3=\7=\u018b\n=\f="+
		"\16=\u018e\13=\3=\3=\3>\3>\3>\3>\7>\u0196\n>\f>\16>\u0199\13>\3>\3>\3"+
		"?\3?\3?\3?\7?\u01a1\n?\f?\16?\u01a4\13?\3?\3?\3?\3?\3?\3@\6@\u01ac\n@"+
		"\r@\16@\u01ad\3@\3@\3\u01a2\2A\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61"+
		"a\62c\63e\64g\65i\66k\67m8o9q:s;u\2w\2y\2{<}=\177>\3\2\6\6\2\f\f\17\17"+
		"$$^^\3\2C|\4\2\13\f\17\17\5\2\13\f\17\17\"\"\2\u01ba\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3"+
		"\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2"+
		"\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2"+
		"e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3"+
		"\2\2\2\2s\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\3\u0081\3\2\2\2"+
		"\5\u0085\3\2\2\2\7\u0092\3\2\2\2\t\u0097\3\2\2\2\13\u00a0\3\2\2\2\r\u00a7"+
		"\3\2\2\2\17\u00b2\3\2\2\2\21\u00b8\3\2\2\2\23\u00bf\3\2\2\2\25\u00c3\3"+
		"\2\2\2\27\u00c8\3\2\2\2\31\u00cd\3\2\2\2\33\u00d2\3\2\2\2\35\u00d5\3\2"+
		"\2\2\37\u00da\3\2\2\2!\u00df\3\2\2\2#\u00e5\3\2\2\2%\u00ec\3\2\2\2\'\u00ef"+
		"\3\2\2\2)\u00f7\3\2\2\2+\u00fc\3\2\2\2-\u00ff\3\2\2\2/\u0103\3\2\2\2\61"+
		"\u0109\3\2\2\2\63\u010c\3\2\2\2\65\u010e\3\2\2\2\67\u0110\3\2\2\29\u0117"+
		"\3\2\2\2;\u012c\3\2\2\2=\u012e\3\2\2\2?\u0137\3\2\2\2A\u0139\3\2\2\2C"+
		"\u013b\3\2\2\2E\u013d\3\2\2\2G\u013f\3\2\2\2I\u0141\3\2\2\2K\u0143\3\2"+
		"\2\2M\u0145\3\2\2\2O\u0147\3\2\2\2Q\u0149\3\2\2\2S\u014b\3\2\2\2U\u014d"+
		"\3\2\2\2W\u014f\3\2\2\2Y\u0151\3\2\2\2[\u0153\3\2\2\2]\u0155\3\2\2\2_"+
		"\u0157\3\2\2\2a\u0159\3\2\2\2c\u015c\3\2\2\2e\u015f\3\2\2\2g\u0162\3\2"+
		"\2\2i\u0165\3\2\2\2k\u0167\3\2\2\2m\u0169\3\2\2\2o\u016c\3\2\2\2q\u016e"+
		"\3\2\2\2s\u0171\3\2\2\2u\u0179\3\2\2\2w\u0183\3\2\2\2y\u0185\3\2\2\2{"+
		"\u0191\3\2\2\2}\u019c\3\2\2\2\177\u01ab\3\2\2\2\u0081\u0082\7k\2\2\u0082"+
		"\u0083\7p\2\2\u0083\u0084\7v\2\2\u0084\4\3\2\2\2\u0085\u0086\7k\2\2\u0086"+
		"\u0087\7p\2\2\u0087\u0088\7v\2\2\u0088\u0089\3\2\2\2\u0089\u008d\7]\2"+
		"\2\u008a\u008c\5\63\32\2\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u0090\u0091\7_\2\2\u0091\6\3\2\2\2\u0092\u0093\7d\2\2\u0093\u0094"+
		"\7q\2\2\u0094\u0095\7q\2\2\u0095\u0096\7n\2\2\u0096\b\3\2\2\2\u0097\u0098"+
		"\7d\2\2\u0098\u0099\7q\2\2\u0099\u009a\7q\2\2\u009a\u009b\7n\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009d\7]\2\2\u009d\u009e\5\63\32\2\u009e\u009f\7"+
		"_\2\2\u009f\n\3\2\2\2\u00a0\u00a1\7f\2\2\u00a1\u00a2\7q\2\2\u00a2\u00a3"+
		"\7w\2\2\u00a3\u00a4\7d\2\2\u00a4\u00a5\7n\2\2\u00a5\u00a6\7g\2\2\u00a6"+
		"\f\3\2\2\2\u00a7\u00a8\7f\2\2\u00a8\u00a9\7q\2\2\u00a9\u00aa\7w\2\2\u00aa"+
		"\u00ab\7d\2\2\u00ab\u00ac\7n\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae\3\2\2"+
		"\2\u00ae\u00af\7]\2\2\u00af\u00b0\5\63\32\2\u00b0\u00b1\7_\2\2\u00b1\16"+
		"\3\2\2\2\u00b2\u00b3\7e\2\2\u00b3\u00b4\7n\2\2\u00b4\u00b5\7q\2\2\u00b5"+
		"\u00b6\7e\2\2\u00b6\u00b7\7m\2\2\u00b7\20\3\2\2\2\u00b8\u00b9\7u\2\2\u00b9"+
		"\u00ba\7v\2\2\u00ba\u00bb\7t\2\2\u00bb\u00bc\7k\2\2\u00bc\u00bd\7p\2\2"+
		"\u00bd\u00be\7i\2\2\u00be\22\3\2\2\2\u00bf\u00c0\7r\2\2\u00c0\u00c1\7"+
		"k\2\2\u00c1\u00c2\7v\2\2\u00c2\24\3\2\2\2\u00c3\u00c4\5s:\2\u00c4\u00c5"+
		"\7]\2\2\u00c5\u00c6\5\63\32\2\u00c6\u00c7\7_\2\2\u00c7\26\3\2\2\2\u00c8"+
		"\u00c9\7k\2\2\u00c9\u00ca\7r\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc\7p\2\2"+
		"\u00cc\30\3\2\2\2\u00cd\u00ce\7q\2\2\u00ce\u00cf\7r\2\2\u00cf\u00d0\7"+
		"k\2\2\u00d0\u00d1\7p\2\2\u00d1\32\3\2\2\2\u00d2\u00d3\7C\2\2\u00d3\u00d4"+
		"\5\63\32\2\u00d4\34\3\2\2\2\u00d5\u00d6\7x\2\2\u00d6\u00d7\7q\2\2\u00d7"+
		"\u00d8\7k\2\2\u00d8\u00d9\7f\2\2\u00d9\36\3\2\2\2\u00da\u00db\7N\2\2\u00db"+
		"\u00dc\7q\2\2\u00dc\u00dd\7q\2\2\u00dd\u00de\7r\2\2\u00de \3\2\2\2\u00df"+
		"\u00e0\7U\2\2\u00e0\u00e1\7g\2\2\u00e1\u00e2\7v\2\2\u00e2\u00e3\7w\2\2"+
		"\u00e3\u00e4\7r\2\2\u00e4\"\3\2\2\2\u00e5\u00e6\7t\2\2\u00e6\u00e7\7g"+
		"\2\2\u00e7\u00e8\7v\2\2\u00e8\u00e9\7w\2\2\u00e9\u00ea\7t\2\2\u00ea\u00eb"+
		"\7p\2\2\u00eb$\3\2\2\2\u00ec\u00ed\7k\2\2\u00ed\u00ee\7h\2\2\u00ee&\3"+
		"\2\2\2\u00ef\u00f0\7g\2\2\u00f0\u00f1\7n\2\2\u00f1\u00f2\7u\2\2\u00f2"+
		"\u00f3\7g\2\2\u00f3\u00f4\7\"\2\2\u00f4\u00f5\7k\2\2\u00f5\u00f6\7h\2"+
		"\2\u00f6(\3\2\2\2\u00f7\u00f8\7g\2\2\u00f8\u00f9\7n\2\2\u00f9\u00fa\7"+
		"u\2\2\u00fa\u00fb\7g\2\2\u00fb*\3\2\2\2\u00fc\u00fd\7v\2\2\u00fd\u00fe"+
		"\7q\2\2\u00fe,\3\2\2\2\u00ff\u0100\7h\2\2\u0100\u0101\7q\2\2\u0101\u0102"+
		"\7t\2\2\u0102.\3\2\2\2\u0103\u0104\7y\2\2\u0104\u0105\7j\2\2\u0105\u0106"+
		"\7k\2\2\u0106\u0107\7n\2\2\u0107\u0108\7g\2\2\u0108\60\3\2\2\2\u0109\u010a"+
		"\7c\2\2\u010a\u010b\7v\2\2\u010b\62\3\2\2\2\u010c\u010d\5w<\2\u010d\64"+
		"\3\2\2\2\u010e\u010f\5y=\2\u010f\66\3\2\2\2\u0110\u0111\5\63\32\2\u0111"+
		"\u0113\7\60\2\2\u0112\u0114\5\63\32\2\u0113\u0112\3\2\2\2\u0114\u0115"+
		"\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u01168\3\2\2\2\u0117"+
		"\u0118\7*\2\2\u0118\u0119\7/\2\2\u0119\u011a\3\2\2\2\u011a\u011b\5\63"+
		"\32\2\u011b\u011d\7\60\2\2\u011c\u011e\5\63\32\2\u011d\u011c\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\3\2"+
		"\2\2\u0121\u0122\7+\2\2\u0122:\3\2\2\2\u0123\u0124\7v\2\2\u0124\u0125"+
		"\7t\2\2\u0125\u0126\7w\2\2\u0126\u012d\7g\2\2\u0127\u0128\7h\2\2\u0128"+
		"\u0129\7c\2\2\u0129\u012a\7n\2\2\u012a\u012b\7u\2\2\u012b\u012d\7g\2\2"+
		"\u012c\u0123\3\2\2\2\u012c\u0127\3\2\2\2\u012d<\3\2\2\2\u012e\u0132\7"+
		"$\2\2\u012f\u0131\n\2\2\2\u0130\u012f\3\2\2\2\u0131\u0134\3\2\2\2\u0132"+
		"\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135\3\2\2\2\u0134\u0132\3\2"+
		"\2\2\u0135\u0136\7$\2\2\u0136>\3\2\2\2\u0137\u0138\7]\2\2\u0138@\3\2\2"+
		"\2\u0139\u013a\7_\2\2\u013aB\3\2\2\2\u013b\u013c\7}\2\2\u013cD\3\2\2\2"+
		"\u013d\u013e\7\177\2\2\u013eF\3\2\2\2\u013f\u0140\7*\2\2\u0140H\3\2\2"+
		"\2\u0141\u0142\7+\2\2\u0142J\3\2\2\2\u0143\u0144\7\60\2\2\u0144L\3\2\2"+
		"\2\u0145\u0146\7.\2\2\u0146N\3\2\2\2\u0147\u0148\7=\2\2\u0148P\3\2\2\2"+
		"\u0149\u014a\7A\2\2\u014aR\3\2\2\2\u014b\u014c\7<\2\2\u014cT\3\2\2\2\u014d"+
		"\u014e\7?\2\2\u014eV\3\2\2\2\u014f\u0150\7-\2\2\u0150X\3\2\2\2\u0151\u0152"+
		"\7/\2\2\u0152Z\3\2\2\2\u0153\u0154\7\'\2\2\u0154\\\3\2\2\2\u0155\u0156"+
		"\7\61\2\2\u0156^\3\2\2\2\u0157\u0158\7,\2\2\u0158`\3\2\2\2\u0159\u015a"+
		"\7?\2\2\u015a\u015b\7?\2\2\u015bb\3\2\2\2\u015c\u015d\7(\2\2\u015d\u015e"+
		"\7(\2\2\u015ed\3\2\2\2\u015f\u0160\7~\2\2\u0160\u0161\7~\2\2\u0161f\3"+
		"\2\2\2\u0162\u0163\7#\2\2\u0163\u0164\7?\2\2\u0164h\3\2\2\2\u0165\u0166"+
		"\7#\2\2\u0166j\3\2\2\2\u0167\u0168\7@\2\2\u0168l\3\2\2\2\u0169\u016a\7"+
		"@\2\2\u016a\u016b\7?\2\2\u016bn\3\2\2\2\u016c\u016d\7>\2\2\u016dp\3\2"+
		"\2\2\u016e\u016f\7>\2\2\u016f\u0170\7?\2\2\u0170r\3\2\2\2\u0171\u0176"+
		"\5u;\2\u0172\u0175\5u;\2\u0173\u0175\5\63\32\2\u0174\u0172\3\2\2\2\u0174"+
		"\u0173\3\2\2\2\u0175\u0178\3\2\2\2\u0176\u0174\3\2\2\2\u0176\u0177\3\2"+
		"\2\2\u0177t\3\2\2\2\u0178\u0176\3\2\2\2\u0179\u017a\t\3\2\2\u017av\3\2"+
		"\2\2\u017b\u0184\7\62\2\2\u017c\u0180\4\63;\2\u017d\u017f\4\62;\2\u017e"+
		"\u017d\3\2\2\2\u017f\u0182\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u0181\3\2"+
		"\2\2\u0181\u0184\3\2\2\2\u0182\u0180\3\2\2\2\u0183\u017b\3\2\2\2\u0183"+
		"\u017c\3\2\2\2\u0184x\3\2\2\2\u0185\u0186\7*\2\2\u0186\u0187\7/\2\2\u0187"+
		"\u0188\3\2\2\2\u0188\u018c\4\63;\2\u0189\u018b\4\62;\2\u018a\u0189\3\2"+
		"\2\2\u018b\u018e\3\2\2\2\u018c\u018a\3\2\2\2\u018c\u018d\3\2\2\2\u018d"+
		"\u018f\3\2\2\2\u018e\u018c\3\2\2\2\u018f\u0190\7+\2\2\u0190z\3\2\2\2\u0191"+
		"\u0192\7\61\2\2\u0192\u0193\7\61\2\2\u0193\u0197\3\2\2\2\u0194\u0196\n"+
		"\4\2\2\u0195\u0194\3\2\2\2\u0196\u0199\3\2\2\2\u0197\u0195\3\2\2\2\u0197"+
		"\u0198\3\2\2\2\u0198\u019a\3\2\2\2\u0199\u0197\3\2\2\2\u019a\u019b\b>"+
		"\2\2\u019b|\3\2\2\2\u019c\u019d\7\61\2\2\u019d\u019e\7,\2\2\u019e\u01a2"+
		"\3\2\2\2\u019f\u01a1\13\2\2\2\u01a0\u019f\3\2\2\2\u01a1\u01a4\3\2\2\2"+
		"\u01a2\u01a3\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a3\u01a5\3\2\2\2\u01a4\u01a2"+
		"\3\2\2\2\u01a5\u01a6\7,\2\2\u01a6\u01a7\7\61\2\2\u01a7\u01a8\3\2\2\2\u01a8"+
		"\u01a9\b?\2\2\u01a9~\3\2\2\2\u01aa\u01ac\t\5\2\2\u01ab\u01aa\3\2\2\2\u01ac"+
		"\u01ad\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01af\3\2"+
		"\2\2\u01af\u01b0\b@\2\2\u01b0\u0080\3\2\2\2\20\2\u008d\u0115\u011f\u012c"+
		"\u0132\u0174\u0176\u0180\u0183\u018c\u0197\u01a2\u01ad\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}