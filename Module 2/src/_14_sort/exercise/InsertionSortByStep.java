package _14_sort.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size:");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " values:");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("Your input list: \n");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
        intertionSort(list);
    }

    public static void intertionSort(int[] list) {
        int pos, x;
        for (int i = 1; i < list.length - 1; i++) {
            x = list[i];
            pos = i;
            System.out.println("Hiển thị giá trị index x: " + x);
            System.out.println("Hiển thị giá trị pos sau khi hoán đổi index: " + pos);
            while (pos > 0 && x < list[pos - 1]) {
                System.out.println("Swap " + list[pos] + " với " + list[pos-1]);
                list[pos] = list[pos - 1];
                pos--;
            }
            list[pos] = x;
            System.out.println("Gán giá trị sau khi sắp xếp phần tử đầu" + list[pos]);
        }
        System.out.println(Arrays.toString(list));
    }
}

