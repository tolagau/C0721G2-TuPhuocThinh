package _s18_string_and_regex.exercise.validate_number_phone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhone {
    private static final String CLASS_REGEX = "^[(]\\d{2}[)][-][(][0]\\d{9}[)]$";

    public ValidatePhone() {

    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(CLASS_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
