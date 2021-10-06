package _bt_lam_them_2.controllers;

import _bt_lam_them_2.service.HoaDonImpl;
import _bt_lam_them_2.service.KhachHangImpl;

import java.util.Scanner;

public class Menu {
    static KhachHangImpl khachHang = new KhachHangImpl();
    static HoaDonImpl hoaDon = new HoaDonImpl();

    public static void hamPhu(String str) {
        System.out.println(str);
    }

    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int choose, choose1;
        while (flag) {
            hamPhu("Vui lòng chọn chức năng ");
            hamPhu("1.  Thêm mới khách hàng ");
            hamPhu("2.  Hiển thị thông tin khách hàng ");
            hamPhu("3.  Tìm kiếm thông tin khách hàng ");
            hamPhu("4.  Hóa đơn  ");
            hamPhu("5.  Exit                ");
            hamPhu("Mời chọn chức năng: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1: {
                    boolean flag1 = true;
                    while (flag1) {
                        hamPhu("Thêm mới khách hàng           ");
                        hamPhu("*----------------------------*");
                        hamPhu("1. Thêm khách hàng    ");
                        hamPhu("2. Return main menu           ");
                        hamPhu("Mời nhập lựa chọn             ");
                        choose1 = Integer.parseInt(scanner.nextLine());
                        switch (choose1) {
                            case 1:
                                khachHang.them();
                                break;
                            case 2:
                                flag1 = false;
                        }
                    }
                    break;
                }
                case 2: {
                    boolean flag1 = true;
                    while (flag1) {
                        hamPhu("Hiển thị thông tin khách hàng               ");
                        hamPhu("*--------------------------------*");
                        hamPhu("1. Hiển thị thông tin          ");
                        hamPhu("2. Return main menu               ");
                        hamPhu("Mời nhập lựa chọn                 ");
                        choose1 = Integer.parseInt(scanner.nextLine());
                        switch (choose1) {
                            case 1:
                                khachHang.hienThi();
                                break;
                            case 2:
                                flag1 = false;
                        }
                    }
                    break;
                }
                case 3: {
                    boolean flag1 = true;
                    while (flag1) {
                        hamPhu("Tìm kiếm thông tin khách hàng                   ");
                        hamPhu("*------------------------------------*");
                        hamPhu("1. Tim kiếm theo tên khách hàng              ");
                        hamPhu("2. Return main menu                   ");
                        hamPhu("Mời nhập lựa chọn                     ");
                        choose1 = Integer.parseInt(scanner.nextLine());
                        switch (choose1) {
                            case 1:
                                khachHang.timKiem();
                                break;
                            case 2:
                                flag1 = false;
                        }
                    }
                    break;
                }
                case 4: {
                    boolean flag1 = true;
                    while (flag1) {
                        hamPhu("Menu hóa đơn               ");
                        hamPhu("*--------------------------------*");
                        hamPhu("1. Hiển thị hóa đơn                ");
                        hamPhu("2. Thêm mới hóa đơn           ");
                        hamPhu("3. Sửa hóa đơn                      ");
                        hamPhu("4. Tìm kiếm hóa đơn          ");
                        hamPhu("5. Xóa hóa đơn                 ");
                        hamPhu("6. Return main menu               ");
                        hamPhu("Mời nhập lựa chọn                 ");
                        choose1 = Integer.parseInt(scanner.nextLine());
                        switch (choose1) {
                            case 1:
                                hoaDon.hienThi();
                                break;
                            case 2:
                                hoaDon.them();
                                break;
                            case 3:
                                hoaDon.sua();
                                break;
                            case 4:
                                hoaDon.timKiem();
                                break;
                            case 5:
                                hoaDon.xoa();
                                break;
                            case 6:
                                flag1 = false;
                        }
                    }
                    break;
                }
                case 5:
                    System.exit(0);

            }
        }
    }

    public static void main(String[] args) {
        displayMenu();
    }
}
