parser grammar OurParser;
options { tokenVocab=OurLexer; }

prog: MAIN LEFT_BRACKET (stmt)+ RIGHT_BRACKET (func_decl)*;

stmt: vari_decl
    | func_call SEMICOLON
    | assign SEMICOLON
    | if
    | for_loop
    | RETURN ID SEMICOLON;

func_decl: (type | VOID) ID LEFT_PAREN parameter? RIGHT_PAREN LEFT_BRACKET (stmt)+ RIGHT_BRACKET;

vari_decl: type assign SEMICOLON;

func_call: ID LEFT_PAREN ( arguments (COMMA arguments)*)? RIGHT_PAREN;

assign: ID ASSIGN (expr | literal);

parameter: type ID (COMMA type ID)*;

expr: expr_arit
    | expr_bool
    | func_call;

expr_arit: lowPrecedence;

expr_bool: bool_ops;

arithOperand: (integer | double)
            | ID
            | func_call;

//Precedence, goes through low to high, ends at atom
lowPrecedence: highPrecedence (lowOperator highPrecedence)*;

highPrecedence: atomPrecedence (highOperator atomPrecedence)*;

atomPrecedence: SUB? arithOperand
              | LEFT_PAREN lowPrecedence RIGHT_PAREN;

// Recursive boolean operations
bool_ops: NOT? bool_op bool_op_ex*
        | NOT? expr_arit bool_op_ex+;

// Boolean operations
bool_op: BOOL_LITERAL
       | LEFT_PAREN bool_ops RIGHT_PAREN;

bool_op_ex: boolOperator NOT? (bool_op | expr_arit);

highOperator
    : MUL
    | DIV
    | MOD;

lowOperator
    : ADD
    | SUB;

boolOperator
    : EQUAL
    | OR
    | AND
    | NOT_EQUAL
    | GREATER_THAN
    | GREATER_OR_EQUAL
    | LESS_THAN
    | LESS_OR_EQUAL;

type: INT
    | BOOLEAN
    | DOUBLE
    | CLOCK
    | PIT
    | STRING;

arguments: expr
         | ID
         | integer
         | double;

if: IF LEFT_PAREN (expr) RIGHT_PAREN LEFT_BRACKET (stmt)+ RIGHT_BRACKET (else | else_if)?;

else: ELSE LEFT_BRACKET (stmt)+ RIGHT_BRACKET;

else_if: ELSE if;

for_loop: FOR LEFT_PAREN arguments TO arguments RIGHT_PAREN LEFT_BRACKET (stmt)+ RIGHT_BRACKET;

integer: DIGIT
       | DIGIT_NEGATIVE;

double: integer
      | DOUBLE_DIGIT
      | DOUBLE_DIGIT_NEGATIVE;

literal : STRING_LITERAL | BOOL_LITERAL;