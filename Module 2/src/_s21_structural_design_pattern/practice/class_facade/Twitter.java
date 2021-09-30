package _s21_structural_design_pattern.practice.class_facade;

public class Twitter  implements ISocialShare{
    private String message;
    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void share() {
        System.out.println("Sharing to Twitter: " + this.message);
    }
}
