package _s18_string_and_regex.exercise.validate_name_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClass {
    private static final String CLASS_REGEX = "^[ACP]\\d{4}[GHIKLM]$";
    public ValidateClass(){

    }
    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(CLASS_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
