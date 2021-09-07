package _03_array_java.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxArr2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr2d;
        int x;
        int y;
        System.out.printf("Nhập chiều x\n");
        x = scanner.nextInt();
        System.out.printf("Nhập chiều y\n");
        y = scanner.nextInt();
        arr2d = new int[x][y];
        for (int i = 0; i < arr2d.length; i++) {
            for (int j = 0; j < arr2d.length; j++) {
                System.out.printf("Nhập 2 chiều của mảng" + i + " " + j + " \n");
                int nhap = scanner.nextInt();
                arr2d[i][j] = nhap;
            }
        }
        System.out.printf(Arrays.deepToString(arr2d)+"\n");
        int max = arr2d[0][0];
        int x1 = 0;
        int x2 = 0;
        for (int i = 0; i < arr2d.length; i++) {
            for (int j = 0; j < y; j++) {
                if (arr2d[i][j] > max) {
                    max = arr2d[i][j];
                    x1 = i;
                    x2 = j;
                }
            }

        }
        System.out.printf("Giá trị lớn nhất: arr2d[" + x1 + "][" + x2 + "] = " + max);
    }
}
