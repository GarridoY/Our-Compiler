package dk.aau.cs.d703e20.codegen.arduino.code;

import dk.aau.cs.d703e20.ast.Enums;
import dk.aau.cs.d703e20.ast.statements.AssignArrayNode;
import dk.aau.cs.d703e20.ast.statements.AssignmentNode;
import dk.aau.cs.d703e20.ast.statements.VariableDeclarationNode;

public class ArduinoVarDecl extends VariableDeclarationNode {
    public ArduinoVarDecl(Enums.DataType dataType, AssignmentNode assignmentNode) {
        super(dataType, assignmentNode);
    }

    public ArduinoVarDecl(Enums.DataType dataType, AssignArrayNode assignArrayNode) {
        super(dataType, assignArrayNode);
    }

    public ArduinoVarDecl(Enums.DataType dataType, String variableName) {
        super(dataType, variableName);
    }

    public ArduinoVarDecl(Enums.DataType dataType, int allocatedSize, AssignArrayNode assignArrayNode) {
        super(dataType, allocatedSize, assignArrayNode);
    }

    public ArduinoVarDecl(Enums.DataType dataType, int allocatedSize, String variableName) {
        super(dataType, allocatedSize, variableName);
    }

    @Override
    public String prettyPrint(int indentation) {
        StringBuilder sb = new StringBuilder();

        sb.append(stringFromDataType(dataType, allocatedSize));
        sb.append(" ");
        if (assignmentNode != null)
            sb.append(assignmentNode.prettyPrint(indentation));
        else if (assignArrayNode != null)
            sb.append(assignArrayNode.prettyPrint(indentation));
        else {
            sb.append(variableName);
            if (allocatedSize > 0)
                sb.append("[").append(allocatedSize).append("]");
            sb.append(";");
        }
        return sb.toString();
    }

    private String stringFromDataType (Enums.DataType dataType, int allocatedSize) {
        switch (dataType) {
            case INT: case INT_ARRAY:       return "int";
            case BOOL: case BOOL_ARRAY:     return "bool";
            case DOUBLE: case DOUBLE_ARRAY: return "double";
            default:                        return Enums.stringFromDataType(dataType, allocatedSize);
        }
    }
}
