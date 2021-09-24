package _s17_io_binary_file.exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();
        System.out.println("List of choice: \n " +
                "1. Display product\n" +
                "2. Add  product \n" +
                "3. Search  product \n" +
                "4. Exit");
        boolean flag = true;
        int choose;

        while (flag) {
            System.out.println("Nhập lựa chọn");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    manager.displayPro();
                    break;
                case 2:
                    manager.add();
                    break;
                case 3:
                    manager.search();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}
