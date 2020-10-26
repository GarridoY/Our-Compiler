package dk.aau.cs.d703e20.ast;

public class Format {
    public static String formatNumber(double num)
    {
        if(num == (long) num)
            return String.format("%d", (long) num);
        else
            return String.format("%s", num);
    }
}
