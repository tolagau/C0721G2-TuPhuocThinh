package _12_map.exercise.manager_product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ProductManager productManager = new ProductManager();
        boolean flag = true;
        while (flag){
            System.out.println("Lựa chọn\n" +
                    "1. Hiển thị \n" +
                    "2. Thêm \n" +
                    "3. Xóa \n" +
                    "4. Sửa \n" +
                    "5. Tìm kiếm \n" +
                    "6. Sắp xếp tăng \n" +
                    "7 Sắp xếp giảm \n" +
                    "8. Thoát \n");
            System.out.println("Enter your selection");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1: ProductManager.hienThi();
                break;
                case 2: ProductManager.add();
                break;
               case 3: ProductManager.delete();
               break;
                case 4: productManager.edit();
                break;
                case 5: productManager.search();
                break;
                case 6: productManager.sapXepTang();
                break;
                case 7: productManager.sapXepGiam();
                break;
                case 8: flag = false;
                break;
            }
        }

    }
}
