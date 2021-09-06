package _03_array_java.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MergeArr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhập mảng 1\n");
        int[] arr1 = new int[5];
        for (int i = 0; i < arr1.length; i++) {
            System.out.printf("nhập phần tử thứ " + i + " trong mảng \n");
            arr1[i] = scanner.nextInt();
        }
        System.out.printf(Arrays.toString(arr1) + "\n");
        int[] arr2 = new int[7];
        for (int i = 0; i < arr2.length; i++) {
            System.out.printf("nhập phần tử thứ " + i + " trong mảng \n");
            arr2[i] = scanner.nextInt();
        }
        System.out.printf(Arrays.toString(arr2) + "\n");
        int[] arr3 = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr3[arr1.length + i] = arr2[i];
        }
        System.out.printf(Arrays.toString(arr3));
    }
}
