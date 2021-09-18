package _12_map.exercise.manager_product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager extends Product {
    static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Product> listSP = new ArrayList<>();

    static {
        Product sp1 = new Product(01, "Iphone XS", 15000000, "Apple");
        Product sp2 = new Product(03, "Samsung S21", 20000000, "SamSung");
        Product sp3 = new Product(02, "Samsung Galaxy Note 20", 22000000, "SamSung");
        Product sp4 = new Product(04, "Iphone 13 Pro Max", 31000000, "Apple");
        Product sp5 = new Product(05, "Nokia Lumia", 10000000, "Lumia");
        Product sp6 = new Product(06, "Huawie P50 Pro", 27000000, "Huawei");

        listSP.add(sp1);
        listSP.add(sp2);
        listSP.add(sp3);
        listSP.add(sp4);
        listSP.add(sp5);
        listSP.add(sp6);
    }

    public static void them() {
        System.out.printf("Nhập mã sản phẩm");
        int maSP = Integer.parseInt(scanner.nextLine());
        System.out.printf("Nhập tên sản phẩm");
        String tenSP = scanner.nextLine();
        System.out.printf("Nhập gía tiền của sản phầm");
        int tienSP = Integer.parseInt(scanner.nextLine());
        System.out.printf("Nhập hãng sản xuất");
        String hangSX = scanner.nextLine();
        Product product = new Product(maSP, tenSP, tienSP, hangSX);
        listSP.add(product);
    }

    public static void hienThi() {
        for (int i = 0; i < listSP.size(); i++) {
            System.out.println(listSP.get(i));
        }
    }

    public static void xoa() {
        hienThi();
        System.out.printf("Nhập sản phẩm cần xóa theo id");
        int maSP = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < listSP.size(); i++) {
            if (listSP.get(i).getMaSP() == maSP) {
                listSP.remove(i);
            }
        }
    }

    public static void sua() {
        hienThi();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id sản phầm cần chỉnh sửa");
        int idEdit = Integer.parseInt(scanner.nextLine());
        System.out.println("Tên mới");
        String tenSP = scanner.nextLine();
        System.out.println("Giá tiền mới");
        int tienSP = Integer.parseInt(scanner.nextLine());
        System.out.println("Hãng sản xuất mới");
        String hangSX = scanner.nextLine();
        for (int i = 0; i < listSP.size(); i++) {
            if (listSP.get(i).getMaSP() == idEdit) {
              //  listSP.get(i).setMaSP(maSP);
                listSP.get(i).setTienSP(tienSP);
                listSP.get(i).setTenSP(tenSP);
                listSP.get(i).setHangSX(hangSX);
            }
        }
        hienThi();
    }

    public static void timKiem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm");
        String tenSP = scanner.nextLine();
        for (int i = 0; i < listSP.size(); i++) {
            if (listSP.get(i).getTenSP().equals(tenSP)) {
                System.out.println(listSP.get(i));
            }
        }
    }

    public static void sapXepTang() {
        Collections.sort(listSP, new ComparatorUp());
        System.out.println(listSP + "\n");

    }

    public static void sapXepGiam() {
        Collections.sort(listSP, new ComparatorDown());
        System.out.println(listSP + "\n");
    }

}
