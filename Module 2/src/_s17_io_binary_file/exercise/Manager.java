package _s17_io_binary_file.exercise;

import _s17_io_binary_file.practice.read_and_write_binary.Student;
import case_study.models.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Manager extends Product implements Serializable {

    static List<Product> listPro = new ArrayList<>();


    public void displayPro() {
        listPro = readDataFromFile("src\\_s17_io_binary_file\\exercise\\database.csv");
        for (Product list : listPro) {
            System.out.println(list);
        }
    }

    public void add() {
        Scanner scanner = new Scanner(System.in);
        displayPro();
        System.out.println("Thêm mới sản phẩm: ");
        System.out.println("-------------------------");
        System.out.println("Nhập mã sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập tên hảng: ");
        String hang = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        double price = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập ghi chú của sản phẩm: ");
        String note = scanner.nextLine();
        Product product = new Product(id, name, hang, price, note);
        listPro.add(product);
        writeToFile("src\\_s17_io_binary_file\\exercise\\database.csv",listPro);
        displayPro();
    }

    public void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm cần tìm kiếm");
        String nameSear = scanner.nextLine();
       // boolean flag = false;
        for (Product list : listPro) {
            if (list.getNamePro().contains(nameSear)) {
                System.out.println(list.toString());
            }
        }
//        if (flag){
//
//        }

    }

    public static void writeToFile(String path, List<Product> products) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readDataFromFile(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            listPro = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listPro;
    }
}
