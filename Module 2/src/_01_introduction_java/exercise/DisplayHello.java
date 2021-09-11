package _01_introduction_java.exercise;
import java.util.Scanner;
public class DisplayHello {

    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter your name: ^_^");
                String name = scanner.nextLine();
                System.out.println("Hello " + name);

    }
}
