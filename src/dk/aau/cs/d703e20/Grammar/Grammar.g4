grammar Grammar;

prog : main ;

main : ;

NAME : (UNDERSCORE+ (DIG | LIT) | UNDERSCORE UNDERSCORE+ | LIT) (UNDERSCORE | LIT | DIG)*;
LIT  : [a-zA-Z];
DIG  : [0-9];
INT  : [1-9]+ DIG*;
DEC  : (SUB)? (INT | INT DOT DIG+ |DIG DOT DIG+);
END  : ';';
LP   : '(';
RP   : ')';
EQ	 : '=';
LB   : '{';
RB   : '}';
NE   : '!';
ADD  : '+';
SUB  : '-';
EQEQ :'==';
MULT : '*';
DIV  : '/';
MOD  : '%';
DOT  : '.';
QUOTE: '"';
COMMA: ',';
LS   : '[';
RS   : ']';
GT   : '>';
LT   : '<';
GE   :'>=';
LE   :'<=';
AND  :'&&';
OR   :'||';
UNDERSCORE : '_';
RETURN : 'return';
NULL : 'null';

STRING : QUOTE ~('\r' | '\n')* QUOTE;
WS     : (' '|'\r'|'\n')+ -> skip ; // ignore whitespace tab and newlinefeed -> SKIP
COMMENT : '/*' .*? '*/' -> skip; // block comments
LINE_COMMENT : '//' ~[\r\n] * -> skip;