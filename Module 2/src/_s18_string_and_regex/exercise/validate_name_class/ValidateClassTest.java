package _s18_string_and_regex.exercise.validate_name_class;

public class ValidateClassTest {
    private static ValidateClass validateClass;

    public static final String[] hopLe = new String[]{"C0318G"};

    public static final String[] kHopLe = new String[]{"M0318G"};

    public static void main(String[] args) {

        validateClass = new ValidateClass();

        for (String check : hopLe) {
            boolean isValid = validateClass.validate(check);
            System.out.println("Class is: " + check + " is valid: " + isValid);
        }
        for (String check : kHopLe) {
            boolean isValid = validateClass.validate(check);
            System.out.println("Class is: " + check + " is valid: " + isValid);
        }
    }

}
