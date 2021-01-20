package dk.aau.cs.d703e20.codegen.arduino.code;

public class Functions {
    public static String dWrite =
            "void dWrite(int pin, int value) {\n\t" +
                "if (value == HIGH || value == LOW)\n\t\t" +
                    "digitalWrite(pin, value);\n\t" +
                "else\n\t\t" +
                    "digitalWrite(pin, value ? HIGH : LOW);\n" +
            "}\n";

    public static String ResetClock =
            "int ResetClock(int clock) {\n\t" +
                    "ourClocks[clock] = millis();\n" +
                    "}\n";

    public static String GetClock =
            "int GetClock(int clock) {\n\t" +
                "return millis() - ourClocks[clock];\n" +
            "}\n";

    public static String Seconds =
            "int Seconds(double seconds) {\n\t" +
                "return seconds * 1000;\n" +
            "}\n";

    public static String Minutes =
            "int Minutes(double minutes) {\n\t" +
                    "return minutes * 1000 * 60;\n" +
                    "}\n";

    public static String Hours =
            "int Hours(double hours) {\n\t" +
                    "return hours * 1000 * 60 * 60;\n" +
                    "}\n";

    public static String Days =
            "int Days(double days) {\n\t" +
                    "return days * 1000 * 60 * 60 * 24;\n" +
                    "}\n";
}
