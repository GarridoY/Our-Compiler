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
		INT=1, BOOLEAN=2, DOUBLE=3, CLOCK=4, STRING=5, VOID=6, MAIN=7, RETURN=8, 
		IF=9, ELSE_IF=10, ELSE=11, TO=12, FOR=13, AT=14, DIGIT=15, DIGIT_NEGATIVE=16, 
		DOUBLE_DIGIT=17, DOUBLE_DIGIT_NEGATIVE=18, BOOL_LITERAL=19, STRING_LITERAL=20, 
		LEFT_BRACKET=21, RIGHT_BRACKET=22, LEFT_PAREN=23, RIGHT_PAREN=24, DOT=25, 
		COMMA=26, SEMICOLON=27, QUESTION=28, COLON=29, ASSIGN=30, ADD=31, SUB=32, 
		MOD=33, DIV=34, MUL=35, EQUAL=36, AND=37, OR=38, NOT_EQUAL=39, NOT=40, 
		GREATER_THAN=41, GREATER_OR_EQUAL=42, LESS_THAN=43, LESS_OR_EQUAL=44, 
		ID=45, NEWLINE=46, COMMENT_STRING=47, COMMENT_BLOCK=48, WS=49;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "BOOLEAN", "DOUBLE", "CLOCK", "STRING", "VOID", "MAIN", "RETURN", 
			"IF", "ELSE_IF", "ELSE", "TO", "FOR", "AT", "DIGIT", "DIGIT_NEGATIVE", 
			"DOUBLE_DIGIT", "DOUBLE_DIGIT_NEGATIVE", "BOOL_LITERAL", "STRING_LITERAL", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", "DOT", 
			"COMMA", "SEMICOLON", "QUESTION", "COLON", "ASSIGN", "ADD", "SUB", "MOD", 
			"DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", "NOT", "GREATER_THAN", 
			"GREATER_OR_EQUAL", "LESS_THAN", "LESS_OR_EQUAL", "ID", "LETTER", "DIGIT_RULE", 
			"DIGIT_NEGATIVE_RULE", "NEWLINE", "COMMENT_STRING", "COMMENT_BLOCK", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'bool'", "'double'", "'clock'", "'string'", "'void'", 
			"'Main'", "'return'", "'if'", "'else if'", "'else'", "'to'", "'for'", 
			"'at'", null, null, null, null, null, null, "'{'", "'}'", "'('", "')'", 
			"'.'", "','", "';'", "'?'", "':'", "'='", "'+'", "'-'", "'%'", "'/'", 
			"'*'", "'=='", "'&&'", "'||'", "'!='", "'!'", "'>'", "'>='", "'<'", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "BOOLEAN", "DOUBLE", "CLOCK", "STRING", "VOID", "MAIN", 
			"RETURN", "IF", "ELSE_IF", "ELSE", "TO", "FOR", "AT", "DIGIT", "DIGIT_NEGATIVE", 
			"DOUBLE_DIGIT", "DOUBLE_DIGIT_NEGATIVE", "BOOL_LITERAL", "STRING_LITERAL", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", "DOT", 
			"COMMA", "SEMICOLON", "QUESTION", "COLON", "ASSIGN", "ADD", "SUB", "MOD", 
			"DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", "NOT", "GREATER_THAN", 
			"GREATER_OR_EQUAL", "LESS_THAN", "LESS_OR_EQUAL", "ID", "NEWLINE", "COMMENT_STRING", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\63\u0154\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\22\6\22\u00bb\n\22\r\22\16\22\u00bc\3\23\3\23\3\23\6\23\u00c2\n\23"+
		"\r\23\16\23\u00c3\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00cf"+
		"\n\24\3\25\3\25\7\25\u00d3\n\25\f\25\16\25\u00d6\13\25\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3&"+
		"\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3*\3*\3+\3+\3+\3,\3,\3-\3-\3-\3.\3."+
		"\3.\7.\u0113\n.\f.\16.\u0116\13.\3/\3/\3\60\3\60\3\60\7\60\u011d\n\60"+
		"\f\60\16\60\u0120\13\60\5\60\u0122\n\60\3\61\3\61\3\61\3\61\3\61\7\61"+
		"\u0129\n\61\f\61\16\61\u012c\13\61\3\61\3\61\3\62\6\62\u0131\n\62\r\62"+
		"\16\62\u0132\3\63\3\63\3\63\3\63\7\63\u0139\n\63\f\63\16\63\u013c\13\63"+
		"\3\63\3\63\3\64\3\64\3\64\3\64\7\64\u0144\n\64\f\64\16\64\u0147\13\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\65\6\65\u014f\n\65\r\65\16\65\u0150\3\65\3"+
		"\65\3\u0145\2\66\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\2_\2a\2c\60e\61g"+
		"\62i\63\3\2\7\6\2\f\f\17\17$$^^\3\2C|\4\2\f\f\17\17\4\2\13\f\17\17\5\2"+
		"\13\f\17\17\"\"\2\u015d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2c\3"+
		"\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\3k\3\2\2\2\5o\3\2\2\2\7t\3\2\2"+
		"\2\t{\3\2\2\2\13\u0081\3\2\2\2\r\u0088\3\2\2\2\17\u008d\3\2\2\2\21\u0092"+
		"\3\2\2\2\23\u0099\3\2\2\2\25\u009c\3\2\2\2\27\u00a4\3\2\2\2\31\u00a9\3"+
		"\2\2\2\33\u00ac\3\2\2\2\35\u00b0\3\2\2\2\37\u00b3\3\2\2\2!\u00b5\3\2\2"+
		"\2#\u00b7\3\2\2\2%\u00be\3\2\2\2\'\u00ce\3\2\2\2)\u00d0\3\2\2\2+\u00d9"+
		"\3\2\2\2-\u00db\3\2\2\2/\u00dd\3\2\2\2\61\u00df\3\2\2\2\63\u00e1\3\2\2"+
		"\2\65\u00e3\3\2\2\2\67\u00e5\3\2\2\29\u00e7\3\2\2\2;\u00e9\3\2\2\2=\u00eb"+
		"\3\2\2\2?\u00ed\3\2\2\2A\u00ef\3\2\2\2C\u00f1\3\2\2\2E\u00f3\3\2\2\2G"+
		"\u00f5\3\2\2\2I\u00f7\3\2\2\2K\u00fa\3\2\2\2M\u00fd\3\2\2\2O\u0100\3\2"+
		"\2\2Q\u0103\3\2\2\2S\u0105\3\2\2\2U\u0107\3\2\2\2W\u010a\3\2\2\2Y\u010c"+
		"\3\2\2\2[\u010f\3\2\2\2]\u0117\3\2\2\2_\u0121\3\2\2\2a\u0123\3\2\2\2c"+
		"\u0130\3\2\2\2e\u0134\3\2\2\2g\u013f\3\2\2\2i\u014e\3\2\2\2kl\7k\2\2l"+
		"m\7p\2\2mn\7v\2\2n\4\3\2\2\2op\7d\2\2pq\7q\2\2qr\7q\2\2rs\7n\2\2s\6\3"+
		"\2\2\2tu\7f\2\2uv\7q\2\2vw\7w\2\2wx\7d\2\2xy\7n\2\2yz\7g\2\2z\b\3\2\2"+
		"\2{|\7e\2\2|}\7n\2\2}~\7q\2\2~\177\7e\2\2\177\u0080\7m\2\2\u0080\n\3\2"+
		"\2\2\u0081\u0082\7u\2\2\u0082\u0083\7v\2\2\u0083\u0084\7t\2\2\u0084\u0085"+
		"\7k\2\2\u0085\u0086\7p\2\2\u0086\u0087\7i\2\2\u0087\f\3\2\2\2\u0088\u0089"+
		"\7x\2\2\u0089\u008a\7q\2\2\u008a\u008b\7k\2\2\u008b\u008c\7f\2\2\u008c"+
		"\16\3\2\2\2\u008d\u008e\7O\2\2\u008e\u008f\7c\2\2\u008f\u0090\7k\2\2\u0090"+
		"\u0091\7p\2\2\u0091\20\3\2\2\2\u0092\u0093\7t\2\2\u0093\u0094\7g\2\2\u0094"+
		"\u0095\7v\2\2\u0095\u0096\7w\2\2\u0096\u0097\7t\2\2\u0097\u0098\7p\2\2"+
		"\u0098\22\3\2\2\2\u0099\u009a\7k\2\2\u009a\u009b\7h\2\2\u009b\24\3\2\2"+
		"\2\u009c\u009d\7g\2\2\u009d\u009e\7n\2\2\u009e\u009f\7u\2\2\u009f\u00a0"+
		"\7g\2\2\u00a0\u00a1\7\"\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7h\2\2\u00a3"+
		"\26\3\2\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7\7u\2\2\u00a7"+
		"\u00a8\7g\2\2\u00a8\30\3\2\2\2\u00a9\u00aa\7v\2\2\u00aa\u00ab\7q\2\2\u00ab"+
		"\32\3\2\2\2\u00ac\u00ad\7h\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af\7t\2\2\u00af"+
		"\34\3\2\2\2\u00b0\u00b1\7c\2\2\u00b1\u00b2\7v\2\2\u00b2\36\3\2\2\2\u00b3"+
		"\u00b4\5_\60\2\u00b4 \3\2\2\2\u00b5\u00b6\5a\61\2\u00b6\"\3\2\2\2\u00b7"+
		"\u00b8\5\37\20\2\u00b8\u00ba\7\60\2\2\u00b9\u00bb\5\37\20\2\u00ba\u00b9"+
		"\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		"$\3\2\2\2\u00be\u00bf\5!\21\2\u00bf\u00c1\7\60\2\2\u00c0\u00c2\5\37\20"+
		"\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4"+
		"\3\2\2\2\u00c4&\3\2\2\2\u00c5\u00c6\7v\2\2\u00c6\u00c7\7t\2\2\u00c7\u00c8"+
		"\7w\2\2\u00c8\u00cf\7g\2\2\u00c9\u00ca\7h\2\2\u00ca\u00cb\7c\2\2\u00cb"+
		"\u00cc\7n\2\2\u00cc\u00cd\7u\2\2\u00cd\u00cf\7g\2\2\u00ce\u00c5\3\2\2"+
		"\2\u00ce\u00c9\3\2\2\2\u00cf(\3\2\2\2\u00d0\u00d4\7$\2\2\u00d1\u00d3\n"+
		"\2\2\2\u00d2\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d8\7$"+
		"\2\2\u00d8*\3\2\2\2\u00d9\u00da\7}\2\2\u00da,\3\2\2\2\u00db\u00dc\7\177"+
		"\2\2\u00dc.\3\2\2\2\u00dd\u00de\7*\2\2\u00de\60\3\2\2\2\u00df\u00e0\7"+
		"+\2\2\u00e0\62\3\2\2\2\u00e1\u00e2\7\60\2\2\u00e2\64\3\2\2\2\u00e3\u00e4"+
		"\7.\2\2\u00e4\66\3\2\2\2\u00e5\u00e6\7=\2\2\u00e68\3\2\2\2\u00e7\u00e8"+
		"\7A\2\2\u00e8:\3\2\2\2\u00e9\u00ea\7<\2\2\u00ea<\3\2\2\2\u00eb\u00ec\7"+
		"?\2\2\u00ec>\3\2\2\2\u00ed\u00ee\7-\2\2\u00ee@\3\2\2\2\u00ef\u00f0\7/"+
		"\2\2\u00f0B\3\2\2\2\u00f1\u00f2\7\'\2\2\u00f2D\3\2\2\2\u00f3\u00f4\7\61"+
		"\2\2\u00f4F\3\2\2\2\u00f5\u00f6\7,\2\2\u00f6H\3\2\2\2\u00f7\u00f8\7?\2"+
		"\2\u00f8\u00f9\7?\2\2\u00f9J\3\2\2\2\u00fa\u00fb\7(\2\2\u00fb\u00fc\7"+
		"(\2\2\u00fcL\3\2\2\2\u00fd\u00fe\7~\2\2\u00fe\u00ff\7~\2\2\u00ffN\3\2"+
		"\2\2\u0100\u0101\7#\2\2\u0101\u0102\7?\2\2\u0102P\3\2\2\2\u0103\u0104"+
		"\7#\2\2\u0104R\3\2\2\2\u0105\u0106\7@\2\2\u0106T\3\2\2\2\u0107\u0108\7"+
		"@\2\2\u0108\u0109\7?\2\2\u0109V\3\2\2\2\u010a\u010b\7>\2\2\u010bX\3\2"+
		"\2\2\u010c\u010d\7>\2\2\u010d\u010e\7?\2\2\u010eZ\3\2\2\2\u010f\u0114"+
		"\5]/\2\u0110\u0113\5]/\2\u0111\u0113\5\37\20\2\u0112\u0110\3\2\2\2\u0112"+
		"\u0111\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2"+
		"\2\2\u0115\\\3\2\2\2\u0116\u0114\3\2\2\2\u0117\u0118\t\3\2\2\u0118^\3"+
		"\2\2\2\u0119\u0122\7\62\2\2\u011a\u011e\4\63;\2\u011b\u011d\4\62;\2\u011c"+
		"\u011b\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2"+
		"\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0119\3\2\2\2\u0121"+
		"\u011a\3\2\2\2\u0122`\3\2\2\2\u0123\u0124\7*\2\2\u0124\u0125\7/\2\2\u0125"+
		"\u0126\3\2\2\2\u0126\u012a\4\63;\2\u0127\u0129\4\62;\2\u0128\u0127\3\2"+
		"\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b"+
		"\u012d\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012e\7+\2\2\u012eb\3\2\2\2\u012f"+
		"\u0131\t\4\2\2\u0130\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0130\3\2"+
		"\2\2\u0132\u0133\3\2\2\2\u0133d\3\2\2\2\u0134\u0135\7\61\2\2\u0135\u0136"+
		"\7\61\2\2\u0136\u013a\3\2\2\2\u0137\u0139\n\5\2\2\u0138\u0137\3\2\2\2"+
		"\u0139\u013c\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d"+
		"\3\2\2\2\u013c\u013a\3\2\2\2\u013d\u013e\b\63\2\2\u013ef\3\2\2\2\u013f"+
		"\u0140\7\61\2\2\u0140\u0141\7,\2\2\u0141\u0145\3\2\2\2\u0142\u0144\13"+
		"\2\2\2\u0143\u0142\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0146\3\2\2\2\u0145"+
		"\u0143\3\2\2\2\u0146\u0148\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u0149\7,"+
		"\2\2\u0149\u014a\7\61\2\2\u014a\u014b\3\2\2\2\u014b\u014c\b\64\2\2\u014c"+
		"h\3\2\2\2\u014d\u014f\t\6\2\2\u014e\u014d\3\2\2\2\u014f\u0150\3\2\2\2"+
		"\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0153"+
		"\b\65\2\2\u0153j\3\2\2\2\20\2\u00bc\u00c3\u00ce\u00d4\u0112\u0114\u011e"+
		"\u0121\u012a\u0132\u013a\u0145\u0150\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}