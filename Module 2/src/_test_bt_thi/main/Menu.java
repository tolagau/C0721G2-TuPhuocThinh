package _test_bt_thi.main;


import _test_bt_thi.service.RapPhimImpl;

import java.util.Scanner;

public class Menu {

    public static void hamPhu(String str) {
        System.out.println(str);
    }

    public static void displayMenu() {
        RapPhimImpl rapPhim = new RapPhimImpl();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int choose;
        while (flag) {
            hamPhu("Vui lòng chọn chức năng ");
            hamPhu("1.  Hiển thị ");
            hamPhu("2. Thêm mới ");
            hamPhu("3.  Xóa ");
            hamPhu("4.  Thoát  ");
            hamPhu("Mời chọn chức năng: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1: {
                    rapPhim.disPlay();
                    break;
                }
                case 2: {
                    rapPhim.add();
                    break;

                }
                case 3: {
                    rapPhim.delete();

                    break;
                }
                case 4: {
                    System.exit(0);

                }
            }
        }
    }

    public static void main(String[] args) {
        displayMenu();
    }
}
