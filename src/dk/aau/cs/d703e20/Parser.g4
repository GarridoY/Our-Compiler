parser grammar Parser;
options { tokenVocab=Lexer; }

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
    : (VOID | datatype) functionName LEFT_PAREN functionParam? ( COMMA functionParam)* RIGHT_PAREN block;

// Function parameters
functionParam
    : datatype variableName;

// Call function given optional arguments (expr)
functionCall
    : functionName LEFT_PAREN expr? ( COMMA expr)* RIGHT_PAREN SEMICOLON;

// Statements available in main
statement
    : variableDecl
    | assignment
    | functionCall
    | ifElseStatement //conditionalStatement
    | iterativeStatement;
//    | returnStatement // something about typechecking

// CONDITIONAL
// any IF statement require blocks
ifElseStatement
    : ifStatement elseIfStatement* elseStatement?;

ifStatement: IF LEFT_PAREN conditionalExpression RIGHT_PAREN block;
elseIfStatement: ELSE_IF LEFT_PAREN conditionalExpression RIGHT_PAREN block;
elseStatement: ELSE block;

conditionalExpression: boolExpr | NOT? variableName | functionCall;

// ITERATIVE
iterativeStatement
    : forStatement;

// for (* to *) {}
forStatement
    : FOR LEFT_PAREN expr TO expr RIGHT_PAREN block;

// EXPRESSIONS

expr
    : expr op=(ADD | SUB | MOD | DIV | MUL) expr // Precedence handled by target
    | numLiteral | '('expr')'
    | variableName;

// TODO: Check ambiguity
// TODO: typecheck operator for expr (only pure bools can AND, OR)
boolExpr
    : boolSymbol
    | //boolExpr op=(EQUAL | AND | OR | NOT_EQUAL) boolExpr
    | (expr | BOOL_LITERAL) op=(EQUAL | NOT_EQUAL | GREATER_THAN | GREATER_OR_EQUAL | LESS_THAN | LESS_OR_EQUAL) (BOOL_LITERAL | expr)
    | LEFT_PAREN boolExpr RIGHT_PAREN;
//
boolSymbol
    : BOOL_LITERAL
    | variableName;

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
