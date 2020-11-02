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

    public static Enums.DataType dataTypeFromDatatype (Enums.DataType dataType) {
        return switch (dataType) {
            case INT_ARRAY -> DataType.INT;
            case DOUBLE_ARRAY -> DataType.DOUBLE;
            case BOOL_ARRAY -> DataType.BOOL;
            default -> DataType.VOID;
        };

    }

    public static String stringFromDataType (DataType dataType) {
        return switch (dataType) {
            case INT -> "int";
            case STRING -> "string";
            case CLOCK -> "clock";
            case BOOL -> "bool";
            case DOUBLE -> "double";
            case INT_ARRAY -> "int[]";
            case DOUBLE_ARRAY -> "double[]";
            case BOOL_ARRAY -> "bool[]";
            case VOID -> "void";
            default -> "UNKNOWN DATATYPE";
        };
    }

    public static String stringFromPinType (PinType pinType) {
        return switch (pinType) {
            case IPIN -> "ipin";
            case OPIN -> "opin";
            default -> "UNKNOWN BOOL OPERATOR";
        };
    }

    public static String stringFromBoolOperator (BoolOperator boolOperator) {
        return switch (boolOperator) {
            case EQUAL -> "==";
            case OR -> "||";
            case AND -> "&&";
            case NOT_EQUAL -> "!=";
            case GREATER_THAN -> ">";
            case GREATER_OR_EQUAL -> ">=";
            case LESS_THAN -> "<";
            case LESS_OR_EQUAL -> "<=";
            case NOT -> "!";
            default -> "UNKNOWN BOOL OPERATOR";
        };
    }
}
