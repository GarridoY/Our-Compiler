parser grammar OurParser;
options { tokenVocab=OurLexer; }

// Program rule, has to consist of Setup and Loop, can be followed by function declarations.
// variableName is used to catch outside of the program
program
    : setup loop (functionDecl | variableName)*;

// REQUIRED FUNCTIONS
// Setup runs once at the start
setup
    : SETUP block;

// Loop repeats indefinitely after Setup
loop
    : LOOP block;

// Encapsulation of code by brackets
block
    : LEFT_BRACKET (statement)* RIGHT_BRACKET;

// FUNCTIONS
// Function declaration, optional parameter followed by more optional parameters prefixed by commas
functionDecl
    : dataType functionName LEFT_PAREN (functionParam (COMMA functionParam)*)? RIGHT_PAREN block;

// Function parameters
functionParam
    : dataType variableName;

// Call function given optional arguments (expressions)
functionCall
    : functionName LEFT_PAREN (functionArg (COMMA functionArg)*)? RIGHT_PAREN;

// Function arguments for calling function(s)
functionArg
    : arithExpr
    | boolExpr;

// Statements available in a block
statement
    : variableDecl SEMICOLON
    | assignment SEMICOLON
    | pinDecl SEMICOLON
    | functionCall SEMICOLON
    | ifElseStatement
    | iterativeStatement
    | atStatement
    | boundStatement
    | returnStatement SEMICOLON;

returnStatement
    : RETURN variableName;

// CONDITIONAL STATEMENTS
// An if statement followed by optional else ifs and one optional else
ifElseStatement
    : ifStatement elseIfStatement* elseStatement?;

ifStatement: IF LEFT_PAREN conditionalExpression RIGHT_PAREN block;
elseIfStatement: ELSE_IF LEFT_PAREN conditionalExpression RIGHT_PAREN block;
elseStatement: ELSE block;

// Conditional expressions to be used in if and if else statements
conditionalExpression
    : boolExpr
    | NOT? variableName
    | functionCall
    | SUBSCRIPT;

// At statement for clock and timing purposes
atStatement
    : AT LEFT_PAREN atParams RIGHT_PAREN block;

// Parameters to use in an at statement
atParams
    : boolExpr;

// bound (y, z) z optional
boundStatement
    : BOUND LEFT_PAREN atParams (COMMA BOOL_LITERAL)? RIGHT_PAREN block (CATCH block)? (FINAL block)?;

// ITERATIVE STATEMENTS
iterativeStatement
    : forStatement
    | whileStatement;

// for (* to *) {}
forStatement
    : FOR LEFT_PAREN arithExpr TO arithExpr RIGHT_PAREN block;

// while (boolExpr) {}
whileStatement
    : WHILE LEFT_PAREN boolExpr RIGHT_PAREN block;

// EXPRESSIONS

arithExpr
    : arithExpr arithOp arithExpr // Precedence handled by target
    | NOT?'('arithExpr')'
    | numLiteral
    | variableName
    | functionCall
    | SUBSCRIPT;

boolExpr
    : BOOL_LITERAL
    | boolExprOperand (boolOp boolExprOperand)+
    | NOT? LEFT_PAREN boolExpr RIGHT_PAREN;

boolExprOperand
    : LEFT_PAREN boolExpr RIGHT_PAREN
    | BOOL_LITERAL
    | arithExpr;

// DECLARATIONS AND ASSIGNMENTS
pinDecl
    : pinType variableName (DIGIT | ANALOGPIN | LED_BUILTIN);

// Declaration of variable
variableDecl
    : dataType variableName
    | dataType assignment
    | dataType assignArray;

assignArray
    : variableName ASSIGN LEFT_BRACKET arrayParam (COMMA arrayParam)* RIGHT_BRACKET;

arrayParam
    : arithExpr
    | literal;

assignment
    : variableName ASSIGN (arithExpr | literal);

// Names
variableName
    : ID;
functionName
    : ID;

pinType
    : IPIN
    | OPIN
    | IPPIN;

dataType
    : INT
    | DOUBLE
    | BOOLEAN
    | CLOCK
    | STRING
    | VOID
    | INT_ARRAY
    | DOUBLE_ARRAY
    | BOOLEAN_ARRAY;

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
    | LESS_OR_EQUAL
    | AND
    | OR;