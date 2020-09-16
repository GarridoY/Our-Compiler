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

ifStatement: IF LEFT_PAREN conditionalExpression RIGHT_PAREN Block;
elseIfStatement: ELSE_IF LEFT_PAREN conditionalExpression RIGHT_PAREN Block;
elseStatement: ELSE Block;

conditionalExpression: boolExpr | NOT? variableName | functionCall;

// ITERATIVE
iterativeStatement
    : forStatement;

forStatement
    : FOR LEFT_PAREN expr TO expr RIGHT_PAREN block;

// EXPRESSIONS
// TODO: Check ambiguity
boolExpr
    : boolOperation
    | LEFT_PAREN boolOperation RIGHT_PAREN;
//
boolOperand
    : BOOL_LITERAL
    | variableName;

boolOperation
    : boolOperand (boolOperator boolOperand)*;

// Declaration of variable, all variables must be initialized
variableDecl
    : datatype assignment;

assignment
    : variableName ASSIGN expr SEMICOLON;



// Names
variableName
    : ID;
functionName
    : ID;

// Boolean operators, NOT does not fit here (True ! False)
boolOperator
    : EQUAL
    | OR
    | AND
    | NOT_EQUAL
    | GREATER_THAN
    | GREATER_OR_EQUAL
    | LESS_THAN
    | LESS_OR_EQUAL;

datatype
    : INT
    | DOUBLE
    | BOOLEAN
    | CLOCK;



expr:	expr ('*'|'/') expr
    |	expr ('+'|'-') expr
    |	INT
    |	'(' expr ')'
    ;
NEWLINE : [\r\n]+ ;
INT     : [0-9]+ ;