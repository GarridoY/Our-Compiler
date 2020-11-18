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

    public static Enums.DataType singleDataTypeFromArrayDatatype (Enums.DataType dataType) {
        switch (dataType) {
            case INT_ARRAY:    return DataType.INT;
            case DOUBLE_ARRAY: return DataType.DOUBLE;
            case BOOL_ARRAY:   return DataType.BOOL;
            default:           return DataType.VOID;
        }
    }

    public static String stringFromDataType (DataType dataType) {
        switch (dataType) {
            case INT:          return "int";
            case STRING:       return "string";
            case CLOCK:        return "clock";
            case BOOL:         return "bool";
            case DOUBLE:       return "double";
            case INT_ARRAY:    return "int[]";
            case DOUBLE_ARRAY: return "double[]";
            case BOOL_ARRAY:   return "bool[]";
            case VOID:         return "void";
            default:           return "UNKNOWN DATATYPE";
        }
    }

    public static String stringFromDataType (DataType dataType, int allocatedSize) {
        switch (dataType) {
            case INT:          return "int";
            case STRING:       return "string";
            case CLOCK:        return "clock";
            case BOOL:         return "bool";
            case DOUBLE:       return "double";
            case INT_ARRAY:    return allocatedSize > 0 ? "int[" + allocatedSize + "]" : "int[]";
            case DOUBLE_ARRAY: return allocatedSize > 0 ? "double[" + allocatedSize + "]" : "double[]";
            case BOOL_ARRAY:   return allocatedSize > 0 ? "bool[" + allocatedSize + "]" : "bool[]";
            case VOID:         return "void";
            default:           return "UNKNOWN DATATYPE";
        }
    }

    public static String stringFromPinType (PinType pinType) {
        switch (pinType) {
            case IPIN: return "ipin";
            case OPIN: return "opin";
            default:   return "UNKNOWN BOOL OPERATOR";
        }
    }

    public static String stringFromBoolOperator (BoolOperator boolOperator) {
        switch (boolOperator) {
            case EQUAL:            return "==";
            case OR:               return "||";
            case AND:              return "&&";
            case NOT_EQUAL:        return "!=";
            case GREATER_THAN:     return ">";
            case GREATER_OR_EQUAL: return ">=";
            case LESS_THAN:        return "<";
            case LESS_OR_EQUAL:    return "<=";
            case NOT:              return "!";
            default:               return "UNKNOWN BOOL OPERATOR";
        }
    }

    public static String stringFromArithOperator (ArithOperator arithOperator) {
        switch (arithOperator) {
            case ADD: return "+";
            case SUB: return "-";
            case MOD: return "%";
            case DIV: return "/";
            case MUL: return "*";
            default:  return "UNKNOWN ARITH OPERATOR";
        }
    }
}
