package _03_array_java.exercise;

import java.util.Scanner;

public class MinArrr {
    public static void main(String[] args) {
        int[] arr;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử ");
        int size = scanner.nextInt();
        arr = new int[size];
        System.out.println();

        System.out.println("Nhập phần tử trong mảng");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Nhập giá trị mảng [" + i + "]: ");
            int x = scanner.nextInt();
            arr[i] = x;
        }
        System.out.println();

        System.out.println("Xuất mảng: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();

        int min = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }

        System.out.println();
        System.out.println("Min = arr[" + index + "] = " + min);
    }
}
