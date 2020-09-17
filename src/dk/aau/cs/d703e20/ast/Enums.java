package dk.aau.cs.d703e20.ast;

public class Enums {
    public enum DataType {
        INT,
        STRING,
        CLOCK,
        BOOL,
    }

    public enum ReturnType {
        VOID,
        NUM,
        BOOL,
        VEC2,
        VEC3,
        VEC4
    }

    public enum Operator {
        ADD,
        SUB,
        MOD,
        DIV,
        MUL
    }

    public enum BoolOperator {
        EQUAL,
        OR,
        AND,
        NOT_EQUAL,
        GREATER_THAN,
        GREATER_OR_EQUAL,
        LESS_THAN,
        LESS_OR_EQUAL,
        NOT
    }
}
