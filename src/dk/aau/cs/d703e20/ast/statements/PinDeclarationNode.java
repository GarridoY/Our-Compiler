package dk.aau.cs.d703e20.ast.statements;

import dk.aau.cs.d703e20.ast.CodePosition;
import dk.aau.cs.d703e20.ast.Enums;

public class PinDeclarationNode extends StatementNode{
    private final Enums.PinType pinType;
    private final String variableName;
    private String pinNumber;

    private CodePosition codePosition;

    public PinDeclarationNode(Enums.PinType pinType, String variableName, String pinNumber) {
        this.pinType = pinType;
        this.variableName = variableName;
        this.pinNumber = pinNumber;
    }

    public Enums.PinType getPinType() { return pinType; }

    public String getVariableName() {
        return variableName;
    }

    public String getPinNumber() {
        return pinNumber;
    }

    public boolean isAnalog() {
        return pinNumber.charAt(0) == 'A';
    }

    @Override
    public String prettyPrint(int indentation) { return "PIN DECLARATION"; }

    @Override
    public void setCodePosition(CodePosition codePosition) { this.codePosition = codePosition; }

    @Override
    public CodePosition getCodePosition() { return codePosition; }
}
