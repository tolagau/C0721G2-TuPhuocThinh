package case_study.controllers;

import java.util.Scanner;

public class FuramaController {
    public static void hamPhu(String str) {
        System.out.println(str);
    }

    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int choose, choose1;
        while (flag) {
            hamPhu("Vui lòng chọn chức năng ");
            hamPhu("1.  Employee Management ");
            hamPhu("2.  Customer Management ");
            hamPhu("3.  Facility Management ");
            hamPhu("4.  Booking Management  ");
            hamPhu("5.  Promotion Management");
            hamPhu("6.  Exit                ");
            hamPhu("Mời chọn chức năng: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1: {
                    do {
                        hamPhu("Employee Mangement            ");
                        hamPhu("*----------------------------*");
                        hamPhu("1. Display list employees     ");
                        hamPhu("2. Add new employee           ");
                        hamPhu("3. Edit employee              ");
                        hamPhu("4. Return main menu           ");
                        hamPhu("Mời nhập lựa chọn             ");
                        choose1 = Integer.parseInt(scanner.nextLine());
                    } while (choose1 < 1 || choose1 > 4);
                }
                case 2: {
                    do {
                        hamPhu("Customer Management               ");
                        hamPhu("*--------------------------------*");
                        hamPhu("1. Display list customer          ");
                        hamPhu("2. Add new customer               ");
                        hamPhu("3. Edit customer                  ");
                        hamPhu("4. Return main menu               ");
                        hamPhu("Mời nhập lựa chọn                 ");
                        choose1 = Integer.parseInt(scanner.nextLine());

                    } while (choose1 < 1 || choose1 > 4);
                }
                case 3: {
                    do {
                        hamPhu("Facility Management                   ");
                        hamPhu("*------------------------------------*");
                        hamPhu("1. Display list facility              ");
                        hamPhu("2. Add new facility                   ");
                        hamPhu("3. Display list facility maintenance  ");
                        hamPhu("4. Return main menu                   ");
                        hamPhu("Mời nhập lựa chọn                     ");
                        choose1 = Integer.parseInt(scanner.nextLine());
                    } while (choose1 < 1 || choose1 > 4);
                }
                case 4: {
                    do {
                        hamPhu("Booking Managerment               ");
                        hamPhu("*--------------------------------*");
                        hamPhu("1. Add new booking                ");
                        hamPhu("2. Display list booking           ");
                        hamPhu("3. Create new constracts          ");
                        hamPhu("4. Display list contracts         ");
                        hamPhu("5. Edit contracts                 ");
                        hamPhu("6. Return main menu               ");
                        hamPhu("Mời nhập lựa chọn                 ");
                        choose1 = Integer.parseInt(scanner.nextLine());
                    } while (choose1 < 1 || choose1 > 6);
                }
                case 5: {
                    do {
                        hamPhu("Promotion Management                        ");
                        hamPhu("*------------------------------------------*");
                        hamPhu("1. Display list customer use service        ");
                        hamPhu("2. Display list customers get voucher       ");
                        hamPhu("3. Return main menu                         ");
                        hamPhu("Mời nhập lựa chọn                           ");
                        choose1 = Integer.parseInt(scanner.nextLine());
                    } while (choose1 < 1 || choose1 > 4);
                }
                case 6: System.exit(0);

            }
        }
    }

    public static void main(String[] args) {
        displayMenu();
    }
}
