package _thi_module_2.controllers;

import _thi_module_2.service.MannagerImpl;

import java.util.Scanner;

public class Menu {
    static MannagerImpl mannager = new MannagerImpl();

    public static void hamPhu(String str) {
        System.out.println(str);
    }

    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String choose, choose1;
        while (flag) {
            hamPhu("Vui lòng chọn chức năng ");
            hamPhu("1.  Hiển thị ");
            hamPhu("2. Thêm mới ");
            hamPhu("3.  Xóa ");
            hamPhu("4.  Thoát  ");
            hamPhu("Mời chọn chức năng: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1": {
                    mannager.hienThi();
                    break;
                }
                case "2": {
                    mannager.them();
                    break;
                }
                case "3": {
                    mannager.xoa();
                    break;
                }
                case "4": {
                    System.exit(0);
                }
            }
        }
    }
    public static void main(String[] args) {
        displayMenu();
    }
}
