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
		INT=1, BOOLEAN=2, DOUBLE=3, CLOCK=4, STRING=5, PIT=6, IPIN=7, OPIN=8, 
		ANALOGPIN=9, VOID=10, LOOP=11, SETUP=12, RETURN=13, IF=14, ELSE_IF=15, 
		ELSE=16, TO=17, FOR=18, AT=19, DIGIT=20, DIGIT_NEGATIVE=21, DOUBLE_DIGIT=22, 
		DOUBLE_DIGIT_NEGATIVE=23, BOOL_LITERAL=24, STRING_LITERAL=25, LEFT_BRACKET=26, 
		RIGHT_BRACKET=27, LEFT_PAREN=28, RIGHT_PAREN=29, DOT=30, COMMA=31, SEMICOLON=32, 
		QUESTION=33, COLON=34, ASSIGN=35, ADD=36, SUB=37, MOD=38, DIV=39, MUL=40, 
		EQUAL=41, AND=42, OR=43, NOT_EQUAL=44, NOT=45, GREATER_THAN=46, GREATER_OR_EQUAL=47, 
		LESS_THAN=48, LESS_OR_EQUAL=49, ID=50, COMMENT_STRING=51, COMMENT_BLOCK=52, 
		WS=53;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "BOOLEAN", "DOUBLE", "CLOCK", "STRING", "PIT", "IPIN", "OPIN", 
			"ANALOGPIN", "VOID", "LOOP", "SETUP", "RETURN", "IF", "ELSE_IF", "ELSE", 
			"TO", "FOR", "AT", "DIGIT", "DIGIT_NEGATIVE", "DOUBLE_DIGIT", "DOUBLE_DIGIT_NEGATIVE", 
			"BOOL_LITERAL", "STRING_LITERAL", "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", 
			"RIGHT_PAREN", "DOT", "COMMA", "SEMICOLON", "QUESTION", "COLON", "ASSIGN", 
			"ADD", "SUB", "MOD", "DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", 
			"NOT", "GREATER_THAN", "GREATER_OR_EQUAL", "LESS_THAN", "LESS_OR_EQUAL", 
			"ID", "LETTER", "DIGIT_RULE", "DIGIT_NEGATIVE_RULE", "COMMENT_STRING", 
			"COMMENT_BLOCK", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'bool'", "'double'", "'clock'", "'string'", "'pit'", 
			"'ipin'", "'opin'", null, "'void'", "'Loop'", "'Setup'", "'return'", 
			"'if'", "'else if'", "'else'", "'to'", "'for'", "'at'", null, null, null, 
			null, null, null, "'{'", "'}'", "'('", "')'", "'.'", "','", "';'", "'?'", 
			"':'", "'='", "'+'", "'-'", "'%'", "'/'", "'*'", "'=='", "'&&'", "'||'", 
			"'!='", "'!'", "'>'", "'>='", "'<'", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "BOOLEAN", "DOUBLE", "CLOCK", "STRING", "PIT", "IPIN", "OPIN", 
			"ANALOGPIN", "VOID", "LOOP", "SETUP", "RETURN", "IF", "ELSE_IF", "ELSE", 
			"TO", "FOR", "AT", "DIGIT", "DIGIT_NEGATIVE", "DOUBLE_DIGIT", "DOUBLE_DIGIT_NEGATIVE", 
			"BOOL_LITERAL", "STRING_LITERAL", "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", 
			"RIGHT_PAREN", "DOT", "COMMA", "SEMICOLON", "QUESTION", "COLON", "ASSIGN", 
			"ADD", "SUB", "MOD", "DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", 
			"NOT", "GREATER_THAN", "GREATER_OR_EQUAL", "LESS_THAN", "LESS_OR_EQUAL", 
			"ID", "COMMENT_STRING", "COMMENT_BLOCK", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\67\u0173\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3"+
		"\27\3\27\3\27\6\27\u00da\n\27\r\27\16\27\u00db\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\6\30\u00e4\n\30\r\30\16\30\u00e5\3\30\3\30\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\5\31\u00f3\n\31\3\32\3\32\7\32\u00f7\n\32\f\32"+
		"\16\32\u00fa\13\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3"+
		"\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)"+
		"\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3-\3.\3.\3/\3/\3\60\3\60\3\60\3\61"+
		"\3\61\3\62\3\62\3\62\3\63\3\63\3\63\7\63\u0137\n\63\f\63\16\63\u013a\13"+
		"\63\3\64\3\64\3\65\3\65\3\65\7\65\u0141\n\65\f\65\16\65\u0144\13\65\5"+
		"\65\u0146\n\65\3\66\3\66\3\66\3\66\3\66\7\66\u014d\n\66\f\66\16\66\u0150"+
		"\13\66\3\66\3\66\3\67\3\67\3\67\3\67\7\67\u0158\n\67\f\67\16\67\u015b"+
		"\13\67\3\67\3\67\38\38\38\38\78\u0163\n8\f8\168\u0166\138\38\38\38\38"+
		"\38\39\69\u016e\n9\r9\169\u016f\39\39\3\u0164\2:\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O"+
		")Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\2i\2k\2m\65o\66q\67\3\2\6\6\2\f\f\17"+
		"\17$$^^\3\2C|\4\2\13\f\17\17\5\2\13\f\17\17\"\"\2\u017b\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3"+
		"\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2"+
		"\2\2e\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\3s\3\2\2\2\5w\3\2\2\2\7"+
		"|\3\2\2\2\t\u0083\3\2\2\2\13\u0089\3\2\2\2\r\u0090\3\2\2\2\17\u0094\3"+
		"\2\2\2\21\u0099\3\2\2\2\23\u009e\3\2\2\2\25\u00a1\3\2\2\2\27\u00a6\3\2"+
		"\2\2\31\u00ab\3\2\2\2\33\u00b1\3\2\2\2\35\u00b8\3\2\2\2\37\u00bb\3\2\2"+
		"\2!\u00c3\3\2\2\2#\u00c8\3\2\2\2%\u00cb\3\2\2\2\'\u00cf\3\2\2\2)\u00d2"+
		"\3\2\2\2+\u00d4\3\2\2\2-\u00d6\3\2\2\2/\u00dd\3\2\2\2\61\u00f2\3\2\2\2"+
		"\63\u00f4\3\2\2\2\65\u00fd\3\2\2\2\67\u00ff\3\2\2\29\u0101\3\2\2\2;\u0103"+
		"\3\2\2\2=\u0105\3\2\2\2?\u0107\3\2\2\2A\u0109\3\2\2\2C\u010b\3\2\2\2E"+
		"\u010d\3\2\2\2G\u010f\3\2\2\2I\u0111\3\2\2\2K\u0113\3\2\2\2M\u0115\3\2"+
		"\2\2O\u0117\3\2\2\2Q\u0119\3\2\2\2S\u011b\3\2\2\2U\u011e\3\2\2\2W\u0121"+
		"\3\2\2\2Y\u0124\3\2\2\2[\u0127\3\2\2\2]\u0129\3\2\2\2_\u012b\3\2\2\2a"+
		"\u012e\3\2\2\2c\u0130\3\2\2\2e\u0133\3\2\2\2g\u013b\3\2\2\2i\u0145\3\2"+
		"\2\2k\u0147\3\2\2\2m\u0153\3\2\2\2o\u015e\3\2\2\2q\u016d\3\2\2\2st\7k"+
		"\2\2tu\7p\2\2uv\7v\2\2v\4\3\2\2\2wx\7d\2\2xy\7q\2\2yz\7q\2\2z{\7n\2\2"+
		"{\6\3\2\2\2|}\7f\2\2}~\7q\2\2~\177\7w\2\2\177\u0080\7d\2\2\u0080\u0081"+
		"\7n\2\2\u0081\u0082\7g\2\2\u0082\b\3\2\2\2\u0083\u0084\7e\2\2\u0084\u0085"+
		"\7n\2\2\u0085\u0086\7q\2\2\u0086\u0087\7e\2\2\u0087\u0088\7m\2\2\u0088"+
		"\n\3\2\2\2\u0089\u008a\7u\2\2\u008a\u008b\7v\2\2\u008b\u008c\7t\2\2\u008c"+
		"\u008d\7k\2\2\u008d\u008e\7p\2\2\u008e\u008f\7i\2\2\u008f\f\3\2\2\2\u0090"+
		"\u0091\7r\2\2\u0091\u0092\7k\2\2\u0092\u0093\7v\2\2\u0093\16\3\2\2\2\u0094"+
		"\u0095\7k\2\2\u0095\u0096\7r\2\2\u0096\u0097\7k\2\2\u0097\u0098\7p\2\2"+
		"\u0098\20\3\2\2\2\u0099\u009a\7q\2\2\u009a\u009b\7r\2\2\u009b\u009c\7"+
		"k\2\2\u009c\u009d\7p\2\2\u009d\22\3\2\2\2\u009e\u009f\7C\2\2\u009f\u00a0"+
		"\5)\25\2\u00a0\24\3\2\2\2\u00a1\u00a2\7x\2\2\u00a2\u00a3\7q\2\2\u00a3"+
		"\u00a4\7k\2\2\u00a4\u00a5\7f\2\2\u00a5\26\3\2\2\2\u00a6\u00a7\7N\2\2\u00a7"+
		"\u00a8\7q\2\2\u00a8\u00a9\7q\2\2\u00a9\u00aa\7r\2\2\u00aa\30\3\2\2\2\u00ab"+
		"\u00ac\7U\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae\7v\2\2\u00ae\u00af\7w\2\2"+
		"\u00af\u00b0\7r\2\2\u00b0\32\3\2\2\2\u00b1\u00b2\7t\2\2\u00b2\u00b3\7"+
		"g\2\2\u00b3\u00b4\7v\2\2\u00b4\u00b5\7w\2\2\u00b5\u00b6\7t\2\2\u00b6\u00b7"+
		"\7p\2\2\u00b7\34\3\2\2\2\u00b8\u00b9\7k\2\2\u00b9\u00ba\7h\2\2\u00ba\36"+
		"\3\2\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd\7n\2\2\u00bd\u00be\7u\2\2\u00be"+
		"\u00bf\7g\2\2\u00bf\u00c0\7\"\2\2\u00c0\u00c1\7k\2\2\u00c1\u00c2\7h\2"+
		"\2\u00c2 \3\2\2\2\u00c3\u00c4\7g\2\2\u00c4\u00c5\7n\2\2\u00c5\u00c6\7"+
		"u\2\2\u00c6\u00c7\7g\2\2\u00c7\"\3\2\2\2\u00c8\u00c9\7v\2\2\u00c9\u00ca"+
		"\7q\2\2\u00ca$\3\2\2\2\u00cb\u00cc\7h\2\2\u00cc\u00cd\7q\2\2\u00cd\u00ce"+
		"\7t\2\2\u00ce&\3\2\2\2\u00cf\u00d0\7c\2\2\u00d0\u00d1\7v\2\2\u00d1(\3"+
		"\2\2\2\u00d2\u00d3\5i\65\2\u00d3*\3\2\2\2\u00d4\u00d5\5k\66\2\u00d5,\3"+
		"\2\2\2\u00d6\u00d7\5)\25\2\u00d7\u00d9\7\60\2\2\u00d8\u00da\5)\25\2\u00d9"+
		"\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2"+
		"\2\2\u00dc.\3\2\2\2\u00dd\u00de\7*\2\2\u00de\u00df\7/\2\2\u00df\u00e0"+
		"\3\2\2\2\u00e0\u00e1\5)\25\2\u00e1\u00e3\7\60\2\2\u00e2\u00e4\5)\25\2"+
		"\u00e3\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6"+
		"\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\7+\2\2\u00e8\60\3\2\2\2\u00e9"+
		"\u00ea\7v\2\2\u00ea\u00eb\7t\2\2\u00eb\u00ec\7w\2\2\u00ec\u00f3\7g\2\2"+
		"\u00ed\u00ee\7h\2\2\u00ee\u00ef\7c\2\2\u00ef\u00f0\7n\2\2\u00f0\u00f1"+
		"\7u\2\2\u00f1\u00f3\7g\2\2\u00f2\u00e9\3\2\2\2\u00f2\u00ed\3\2\2\2\u00f3"+
		"\62\3\2\2\2\u00f4\u00f8\7$\2\2\u00f5\u00f7\n\2\2\2\u00f6\u00f5\3\2\2\2"+
		"\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fb"+
		"\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fc\7$\2\2\u00fc\64\3\2\2\2\u00fd"+
		"\u00fe\7}\2\2\u00fe\66\3\2\2\2\u00ff\u0100\7\177\2\2\u01008\3\2\2\2\u0101"+
		"\u0102\7*\2\2\u0102:\3\2\2\2\u0103\u0104\7+\2\2\u0104<\3\2\2\2\u0105\u0106"+
		"\7\60\2\2\u0106>\3\2\2\2\u0107\u0108\7.\2\2\u0108@\3\2\2\2\u0109\u010a"+
		"\7=\2\2\u010aB\3\2\2\2\u010b\u010c\7A\2\2\u010cD\3\2\2\2\u010d\u010e\7"+
		"<\2\2\u010eF\3\2\2\2\u010f\u0110\7?\2\2\u0110H\3\2\2\2\u0111\u0112\7-"+
		"\2\2\u0112J\3\2\2\2\u0113\u0114\7/\2\2\u0114L\3\2\2\2\u0115\u0116\7\'"+
		"\2\2\u0116N\3\2\2\2\u0117\u0118\7\61\2\2\u0118P\3\2\2\2\u0119\u011a\7"+
		",\2\2\u011aR\3\2\2\2\u011b\u011c\7?\2\2\u011c\u011d\7?\2\2\u011dT\3\2"+
		"\2\2\u011e\u011f\7(\2\2\u011f\u0120\7(\2\2\u0120V\3\2\2\2\u0121\u0122"+
		"\7~\2\2\u0122\u0123\7~\2\2\u0123X\3\2\2\2\u0124\u0125\7#\2\2\u0125\u0126"+
		"\7?\2\2\u0126Z\3\2\2\2\u0127\u0128\7#\2\2\u0128\\\3\2\2\2\u0129\u012a"+
		"\7@\2\2\u012a^\3\2\2\2\u012b\u012c\7@\2\2\u012c\u012d\7?\2\2\u012d`\3"+
		"\2\2\2\u012e\u012f\7>\2\2\u012fb\3\2\2\2\u0130\u0131\7>\2\2\u0131\u0132"+
		"\7?\2\2\u0132d\3\2\2\2\u0133\u0138\5g\64\2\u0134\u0137\5g\64\2\u0135\u0137"+
		"\5)\25\2\u0136\u0134\3\2\2\2\u0136\u0135\3\2\2\2\u0137\u013a\3\2\2\2\u0138"+
		"\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139f\3\2\2\2\u013a\u0138\3\2\2\2"+
		"\u013b\u013c\t\3\2\2\u013ch\3\2\2\2\u013d\u0146\7\62\2\2\u013e\u0142\4"+
		"\63;\2\u013f\u0141\4\62;\2\u0140\u013f\3\2\2\2\u0141\u0144\3\2\2\2\u0142"+
		"\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2"+
		"\2\2\u0145\u013d\3\2\2\2\u0145\u013e\3\2\2\2\u0146j\3\2\2\2\u0147\u0148"+
		"\7*\2\2\u0148\u0149\7/\2\2\u0149\u014a\3\2\2\2\u014a\u014e\4\63;\2\u014b"+
		"\u014d\4\62;\2\u014c\u014b\3\2\2\2\u014d\u0150\3\2\2\2\u014e\u014c\3\2"+
		"\2\2\u014e\u014f\3\2\2\2\u014f\u0151\3\2\2\2\u0150\u014e\3\2\2\2\u0151"+
		"\u0152\7+\2\2\u0152l\3\2\2\2\u0153\u0154\7\61\2\2\u0154\u0155\7\61\2\2"+
		"\u0155\u0159\3\2\2\2\u0156\u0158\n\4\2\2\u0157\u0156\3\2\2\2\u0158\u015b"+
		"\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015c\3\2\2\2\u015b"+
		"\u0159\3\2\2\2\u015c\u015d\b\67\2\2\u015dn\3\2\2\2\u015e\u015f\7\61\2"+
		"\2\u015f\u0160\7,\2\2\u0160\u0164\3\2\2\2\u0161\u0163\13\2\2\2\u0162\u0161"+
		"\3\2\2\2\u0163\u0166\3\2\2\2\u0164\u0165\3\2\2\2\u0164\u0162\3\2\2\2\u0165"+
		"\u0167\3\2\2\2\u0166\u0164\3\2\2\2\u0167\u0168\7,\2\2\u0168\u0169\7\61"+
		"\2\2\u0169\u016a\3\2\2\2\u016a\u016b\b8\2\2\u016bp\3\2\2\2\u016c\u016e"+
		"\t\5\2\2\u016d\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u016d\3\2\2\2\u016f"+
		"\u0170\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0172\b9\2\2\u0172r\3\2\2\2\17"+
		"\2\u00db\u00e5\u00f2\u00f8\u0136\u0138\u0142\u0145\u014e\u0159\u0164\u016f"+
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