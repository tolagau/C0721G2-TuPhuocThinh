package _04_oop_java.exercise.quadratic_equation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhập số a: ");
        double a = scanner.nextDouble();
        System.out.printf("Nhập số b: ");
        double b = scanner.nextDouble();
        System.out.printf("Nhập số c: ");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        if (quadraticEquation.getDiscriminant()>0){
            System.out.printf("Phương trình có 2 nghiệm " + quadraticEquation.getRoot1()+ " và " + quadraticEquation.getRoot2());
        }else if (quadraticEquation.getDiscriminant() == 0){
            System.out.printf("Phương trình có 1 nghiệm: "+ quadraticEquation.getRoot1());
        }else System.out.printf("Phương trình vô nghiệm");
    }

}
