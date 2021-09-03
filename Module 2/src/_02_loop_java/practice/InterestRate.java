package _02_loop_java.practice;

import java.util.Scanner;

public class InterestRate {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double interestRate = 1.0;
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhập tiền cho vay:");
        money = scanner.nextDouble();
        System.out.printf("Nhập số tháng muốn cho vay:");
        month = scanner.nextInt();
        System.out.printf("Nhập lãi suất:");
        interestRate = scanner.nextDouble();
        double  totalInteresRate =0;
        for (int i = 0; i < month;i++){
            totalInteresRate += money * (interestRate/100)/12 * month;
        }
        System.out.printf("Tổng tiền lãi nhập được khi gởi là " + (long)totalInteresRate);
    }

}
