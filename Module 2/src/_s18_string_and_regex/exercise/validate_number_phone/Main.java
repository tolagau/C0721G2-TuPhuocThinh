package _s18_string_and_regex.exercise.validate_number_phone;

import _s18_string_and_regex.exercise.validate_name_class.ValidateClass;

public class Main {
    public static ValidatePhone validatePhone;
    public static final String[] hopLe = new String[]{"(84)-(0978489648)"};

    public static final String[] kHopLe = new String[]{"(a8)-(22222222)"};

    public static void main(String[] args) {

        validatePhone = new ValidatePhone();

        for (String check : hopLe) {
            boolean isValid = validatePhone.validate(check);
            System.out.println("Class is: " + check + " is valid: " + isValid);
        }
        for (String check : kHopLe) {
            boolean isValid = validatePhone.validate(check);
            System.out.println("Class is: " + check + " is valid: " + isValid);
        }
    }
}
