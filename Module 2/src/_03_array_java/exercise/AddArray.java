package _03_array_java.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class AddArray {
    public static void main(String[] args) {
        int[] arr = {10, 4, 6, 7, 8, 0,0,0,0,0};
        System.out.print("In mảng");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" " + arr[i]);
        }

        System.out.printf(" \n Nhập số cần chèn");
        Scanner scanner = new Scanner(System.in);
        int nhapSo = scanner.nextInt();
        System.out.printf("Nhập vị trí cần chèn");
        int viTri = scanner.nextInt();
        if (viTri <= -1 || viTri >= arr.length - 1) {
            System.out.printf("lỗi");
            System.exit(0);
        } else {
            for (int i = arr.length - 1; i >= viTri + 1; i--) { // dùng vòng lặp for để dịch chuyển phần tử

                arr[i] = arr[i - 1];
            }
            arr[viTri] = nhapSo;
            System.out.println("Mảng sau khi được thêm " + nhapSo + " "+ "tại vị trí " + viTri + ":");
            System.out.println(Arrays.toString(arr));

        }
    }
}
