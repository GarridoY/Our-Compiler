parser grammar OurParser;
options { tokenVocab=OurLexer; }

// Program rule, has to consist of a main rule, can be followed by function declarations.
// variableName is used to catch outside of the program
program
    : setup loop (functionDecl | variableName)*;

// main start keyword followed by a block
loop
    : LOOP block;

setup
    : SETUP block;

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
    : functionName LEFT_PAREN functionArgs? RIGHT_PAREN;

// Function arguments for calling function(s)
functionArgs
    : (arithExpr | boolExpr) ( COMMA (arithExpr | boolExpr))*;

// Statements available in main
statement
    : variableDecl SEMICOLON
    | assignment SEMICOLON
    | functionCall SEMICOLON
    | ifElseStatement //conditionalStatement
    | iterativeStatement
    | atStatement
    | returnStatement SEMICOLON;

returnStatement
    : RETURN variableName;

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
    : AT LEFT_PAREN variableName boolOp arithExpr RIGHT_PAREN block;

// ITERATIVE
iterativeStatement
    : forStatement;

// for (* to *) {}
forStatement
    : FOR LEFT_PAREN arithExpr TO arithExpr RIGHT_PAREN block;

// EXPRESSIONS

arithExpr
    : arithExpr arithOp arithExpr // Precedence handled by target
    | numLiteral | NOT?'('arithExpr')'
    | variableName
    | functionCall;

// TODO: Check ambiguity
// TODO: typecheck operator for expr (only pure bools can AND, OR)
boolExpr
    : BOOL_LITERAL
    | (arithExpr | BOOL_LITERAL) boolOp (BOOL_LITERAL | arithExpr)
    | NOT? LEFT_PAREN boolExpr RIGHT_PAREN;


// Declaration of variable, all variables must be initialized
variableDecl
    : datatype assignment;

assignment
    : variableName ASSIGN (arithExpr | literal); // Todo: Fix amiguity functioncall arith

// Names
variableName
    : ID;
functionName
    : ID;

datatype
    : INT
    | DOUBLE
    | BOOLEAN
    | CLOCK
    | STRING;

literal
    : STRING_LITERAL
    | BOOL_LITERAL;

numLiteral
    : DIGIT
    | DIGIT_NEGATIVE
    | DOUBLE_DIGIT
    | DOUBLE_DIGIT_NEGATIVE;

arithOp
    : ADD
    | SUB
    | MOD
    | DIV
    | MUL;

boolOp
    : EQUAL
    | NOT_EQUAL
    | GREATER_THAN
    | GREATER_OR_EQUAL
    | LESS_THAN
    | LESS_OR_EQUAL;