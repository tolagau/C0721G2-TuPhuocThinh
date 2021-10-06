package utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    static Scanner scanner = new Scanner(System.in);
    public static String checkRegex(String string, String regex, String err) {
        boolean check = true;
        do {
            if (string.matches(regex)) {
                check = false;
            } else {
                System.out.println(err);
                string = scanner.nextLine();
            }
        } while (check);
        return string;
    }
}
