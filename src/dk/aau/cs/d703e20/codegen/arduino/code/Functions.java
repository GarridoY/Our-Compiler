package dk.aau.cs.d703e20.codegen.arduino.code;

public class Functions {
    public static String dWrite =
            "void dWrite(int pin, int value) {\n\t" +
                "if (value == HIGH || value ==  LOW)\n\t\t" +
                    "digitalWrite(pin, value);\n\t" +
                "else\n\t\t" +
                    "digitalWrite(pin, value ? HIGH : LOW);\n" +
            "}\n";
}
