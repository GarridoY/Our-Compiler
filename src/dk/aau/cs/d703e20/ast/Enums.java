package dk.aau.cs.d703e20.ast;

public class Enums {
    public enum DataType {
        INT,
        STRING,
        CLOCK,
        BOOL,
        DOUBLE,
        INT_ARRAY,
        DOUBLE_ARRAY,
        BOOL_ARRAY,
        VOID
    }

    public enum PinType {
        IPIN,
        OPIN
    }

    public enum ArithOperator {
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
