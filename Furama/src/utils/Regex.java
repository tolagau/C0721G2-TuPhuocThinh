package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private static final String CHECK_NAME = "^[A-Z][a-z]+\\s?([a-z]+\\s)*\\w+$";
    private static final String CHECK_ID = "^SV(VL|RO|HO)-\\d{4}$";
    private static final String CHECK_DATE = "^\\d{2}/\\d{2}/\\d{4}$";

    public static boolean checkName(String string) {
        boolean b = string.matches(CHECK_NAME);
        return b;
    }
    public static boolean checkID(String string) {
        boolean a = string.matches(CHECK_ID);
        return a;
    }
    public static boolean checkDate(String string) {
        boolean c = string.matches(CHECK_DATE);
        return c;
    }
}
