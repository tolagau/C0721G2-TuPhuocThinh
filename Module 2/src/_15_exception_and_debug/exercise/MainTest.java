package _15_exception_and_debug.exercise;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập cạnh a của tam giác");
        int a = scanner.nextInt();
        System.out.println("Nhập cạnh b của tam giác");
        int b = scanner.nextInt();
        System.out.println("Nhập cạnh c của tam giác");
        int c = scanner.nextInt();
        try {
            tamGiac(a, b, c);
            System.out.println("Các cạnh của hình tam giá ABC là: " + a + " " + b + " " + c);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void tamGiac(int a, int b, int c) throws IllegalTriangleException {
        if (a + b < c || a + c < b || b + c < a) {
            throw new IllegalTriangleException("Bạn nhập sai rồi");
        }
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Bạn nhập sai rồi");
        }
    }
}
