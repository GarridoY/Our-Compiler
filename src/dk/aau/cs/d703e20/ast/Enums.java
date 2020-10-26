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

    public static String stringFromDataType (DataType dataType) {
        switch (dataType) {
            case INT:
                return "int";

            case STRING:
                return "string";

            case CLOCK:
                return "clock";

            case BOOL:
                return "bool";

            case DOUBLE:
                return "double";

            case INT_ARRAY:
                return "int[]";

            case DOUBLE_ARRAY:
                return "double[]";

            case BOOL_ARRAY:
                return "bool[]";

            case VOID:
                return "void";

            default:
                return "UNKNOWN DATATYPE";
        }
    }
}
