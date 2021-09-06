package _03_array_java.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class SumTheNumberColumn {
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
                System.out.printf("Nhập chiều thứ " + i + " của mảng" + i + " " + j + " \n");
                int nhap = scanner.nextInt();
                arr2d[i][j] = nhap;
            }
        }
        System.out.printf(Arrays.deepToString(arr2d) + "\n");
        int col;
        do {
            System.out.printf("Chọn cột: \n");
            col = scanner.nextInt();
            if (col > x - 1 || col < 0) {
                System.out.printf("Bạn chọn cột không có trong mảng");
            }
        } while (col > x - 1 || col < 0);
        int sum = 0;
        for (int i = 0; i < arr2d.length; i++) {
            sum += arr2d[i][col];
        }
        System.out.printf("Tổng của cột:  " + col + " là bằng: "+ sum);
    }

}
