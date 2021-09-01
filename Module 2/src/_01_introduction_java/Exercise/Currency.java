package _01_introduction_java.Exercise;
import java.util.Scanner;
public class Currency {
    public static void main(String[] args) {
        double usd;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập số tiền:");
        usd = scanner.nextDouble();
        double exchange = usd*23000;
        System.out.println("Giá trị VND:" + exchange);
    }
}
