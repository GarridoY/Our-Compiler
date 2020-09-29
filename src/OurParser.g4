parser grammar OurParser;
options { tokenVocab=OurLexer; }

// Program rule, has to consist of a main rule, can be followed by function declarations.
// variableName is used to catch outside of the program
program
    : main (functionDecl | variableName)*;

// main start keyword followed by a block
main
    : MAIN block;

// Encapsulation of code by brackets
block
    : LEFT_BRACKET (statement)* RIGHT_BRACKET;

// FUNCTIONS
// Function declaration, optional argument followed by more optional arguments prefixed by comma TODO: Check if ANTLR can figure out which functionArg is in use
functionDecl
    : (VOID | datatype) functionName LEFT_PAREN functionParam? RIGHT_PAREN block;

// Function parameters
functionParam
    : datatype variableName ( COMMA functionParam)*;

// Call function given optional arguments (expr)
functionCall
    : functionName LEFT_PAREN functionArgs? RIGHT_PAREN SEMICOLON;

// Function arguments for calling function(s)
functionArgs
    : (expr | boolExpr) ( COMMA (expr | boolExpr))*;

// Statements available in main
statement
    : variableDecl
    | assignment
    | functionCall
    | ifElseStatement //conditionalStatement
    | iterativeStatement
    | atStatement
    | returnStatement;

returnStatement
    : RETURN variableName SEMICOLON;

// CONDITIONAL
// any IF statement require blocks
ifElseStatement
    : ifStatement elseIfStatement* elseStatement?;

ifStatement: IF LEFT_PAREN conditionalExpression RIGHT_PAREN block;
elseIfStatement: ELSE_IF LEFT_PAREN conditionalExpression RIGHT_PAREN block;
elseStatement: ELSE block;

conditionalExpression: boolExpr | NOT? variableName | functionCall;

// at statement for clock and timing purposes
atStatement
    : AT LEFT_PAREN variableName op=(EQUAL | LESS_THAN | GREATER_THAN | GREATER_OR_EQUAL | LESS_OR_EQUAL | NOT_EQUAL) expr RIGHT_PAREN block;

// ITERATIVE
iterativeStatement
    : forStatement;

// for (* to *) {}
forStatement
    : FOR LEFT_PAREN expr TO expr RIGHT_PAREN block;

// EXPRESSIONS

expr
    : expr arit_op expr // Precedence handled by target
    | numLiteral
    | '('expr')'
    | variableName;

// TODO: Check ambiguity
// TODO: typecheck operator for expr (only pure bools can AND, OR)
boolExpr
    : BOOL_LITERAL
    | //boolExpr op=(EQUAL | AND | OR | NOT_EQUAL) boolExpr
    | (expr | BOOL_LITERAL) bool_op (BOOL_LITERAL | expr)
    | NOT? LEFT_PAREN boolExpr RIGHT_PAREN;


// Declaration of variable, all variables must be initialized
variableDecl
    : datatype assignment;

assignment
    : variableName ASSIGN (expr | literal) SEMICOLON;



// Names
variableName
    : ID;
functionName
    : ID;

datatype
    : INT
    | DOUBLE
    | BOOLEAN
    | CLOCK;

literal
    : STRING_LITERAL
    | BOOL_LITERAL;

numLiteral
    : DIGIT
    | DIGIT_NEGATIVE
    | DOUBLE_DIGIT
    | DOUBLE_DIGIT_NEGATIVE;

arit_op
    : ADD
    | SUB
    | MOD
    | DIV
    | MUL
    ;

bool_op
    : EQUAL
    | NOT_EQUAL
    | GREATER_THAN
    | GREATER_OR_EQUAL
    | LESS_THAN
    | LESS_OR_EQUAL
    ;