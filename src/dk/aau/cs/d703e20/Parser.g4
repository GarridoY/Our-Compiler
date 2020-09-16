parser grammar Parser;
options { tokenVocab=Lexer; }
prog:	(expr NEWLINE)* ;
expr:	expr ('*'|'/') expr
    |	expr ('+'|'-') expr
    |	INT
    |	'(' expr ')'
    ;

//INT     : [0-9]+ ; # not allowed due to Lexer.g4