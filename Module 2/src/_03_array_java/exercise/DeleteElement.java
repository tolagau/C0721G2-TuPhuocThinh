package _03_array_java.exercise;

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        boolean flag = true;
        int arrNum[] = {10, 4, 6, 7, 8, 6, 0,0,0,0};
        int delNum;
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Phần tử cần xóa trong mảng");
        delNum = scanner.nextInt();
        for (int i = 0; i < arrNum.length; i++) {
            if (delNum == arrNum[i]) {
                flag = true;
                for (int j = i; j < arrNum.length - 1; j++) {
                    if (j < arrNum.length - 1) {
                        arrNum[j] = arrNum[j + 1];
                    } else arrNum[j] = 0;
                }
            } else
                flag = false;
        }
        if (flag) {
            System.out.print("Mảng cần in ");
            for (int num : arrNum) {
                System.out.print(num + " ");
            }
        } else System.out.printf("Phần tử bạn nhập không có trong mảng");

    }
}
