lexer grammar OurLexer;

// Data Types
INT: 'int';
BOOLEAN: 'bool';
DOUBLE: 'double';
CLOCK: 'clock';
STRING: 'string';
PIT: 'pit';

// Return/Function type
VOID: 'void';

// Keywords
LOOP: 'Loop';
SETUP: 'Setup';
RETURN: 'return';
IF: 'if';
ELSE_IF: 'else if';
ELSE: 'else';
TO: 'to';
FOR: 'for';
AT: 'at';
// Possible other: delay, wait, sleep, loop, pause

//Numbers and booleans
DIGIT: DIGIT_RULE;
DIGIT_NEGATIVE: DIGIT_NEGATIVE_RULE;

DOUBLE_DIGIT: DIGIT'.'DIGIT+;
DOUBLE_DIGIT_NEGATIVE: '(-' DIGIT '.' DIGIT+')';

BOOL_LITERAL: 'true' | 'false';

STRING_LITERAL: '"' (~["\\\r\n])* '"';

// Separators
LEFT_BRACKET: '{';
RIGHT_BRACKET: '}';
LEFT_PAREN: '(';
RIGHT_PAREN: ')';
DOT: '.';
COMMA: ',';
SEMICOLON: ';';
QUESTION: '?';
COLON: ':';

// Operators
ASSIGN: '=';
ADD: '+';
SUB: '-';
MOD: '%';
DIV: '/';
MUL: '*';
EQUAL: '==';
AND: '&&';
OR: '||';
NOT_EQUAL: '!=';
NOT: '!';
GREATER_THAN: '>';
GREATER_OR_EQUAL: '>=';
LESS_THAN: '<';
LESS_OR_EQUAL: '<=';

// Identifier - chars and non-negative digits
ID: LETTER (LETTER | DIGIT)*;

// Fragment rules
fragment LETTER: [A-z];

fragment DIGIT_RULE
    : '0'
    | '1'..'9' '0'..'9'*;
fragment DIGIT_NEGATIVE_RULE: '(-'('1'..'9') ('0'..'9')*')';

// MISC
COMMENT_STRING: '//' ~( '\r' | '\n' | '\t')* -> skip;
COMMENT_BLOCK : '/*' .*? '*/' -> skip;
WS: [ \t\r\n]+ -> skip;