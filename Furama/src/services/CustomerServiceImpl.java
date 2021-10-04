package services;

import models.Customer;

import java.io.File;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;

import static utils.ReadAndWrite.readFile;
import static utils.ReadAndWrite.writeFile;

public class CustomerServiceImpl extends Customer implements IService {
     static final String CUSTUMER_PATH = "src\\data\\customer.csv";
    Scanner scanner = new Scanner(System.in);
    public List<Customer> linkedListCus = (LinkedList<Customer>) readCus(CUSTUMER_PATH);

    public static void writeCus(List<Customer> listCus, String filePath, boolean append) {
        List<String> str = new LinkedList<>();
        for (Customer listStr : listCus) {
            str.add(listStr.getIF());
        }
        writeFile(str, CUSTUMER_PATH, true);
    }

    public static List<Customer> readCus(String filePath) {
        List<String> str = readFile(CUSTUMER_PATH);
        List<Customer> customerList = new LinkedList<>();
        for (String listStr : str) {
            String[] temp = listStr.split(",");
            Customer customer = new Customer(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3],
                    Integer.parseInt(temp[4]), Integer.parseInt(temp[5]),
                    temp[6], temp[7], temp[8]);
            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public void hienThi() {
        for (int i = 0; i < linkedListCus.size(); i++) {
            System.out.println(linkedListCus.get(i));
        }
    }

    @Override
    public void them() {
        hienThi();
        System.out.println("Thêm khách hàng mới");
        System.out.println("---------------------------");
        System.out.println("Nhập mã khách hàng");
        int ma = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập họ tên khách hàng");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày sinh khách hàng");
        String ngaySinh = scanner.nextLine();
        System.out.println("Nhập giới tính khách hàng");
        String sex = scanner.nextLine();
        System.out.println("Nhập số CMND khách hàng");
        int cmnd = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số điện thoại khách hàng");
        int sdt = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập email khách hàng");
        String email = scanner.nextLine();
        System.out.println("Nhập loại khách hàng");
        String loaiKH = scanner.nextLine();
        System.out.println("NHập địa chỉ khách hàng");
        String diaChi = scanner.nextLine();
        Customer customer = new Customer(ma, name, ngaySinh, sex, cmnd, sdt, email, loaiKH, diaChi);
        linkedListCus.add(customer);
        File file = new File(CUSTUMER_PATH);
        file.delete();
        writeCus(linkedListCus, CUSTUMER_PATH, true);
        hienThi();

    }

    @Override
    public void sua() {
        hienThi();
        System.out.println("---------------------------------");
        System.out.println("Sửa thông tin khách hàng");
        System.out.println("---------------------------------");
        System.out.println("Nhập mã khách hàng cần chỉnh sửa: ");
        int maEdit = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < linkedListCus.size(); i++) {
            if (maEdit == linkedListCus.get(i).getMa()) {
                System.out.println("Nhập họ tên khách hàng");
                String name = scanner.nextLine();
                System.out.println("Nhập ngày sinh khách hàng");
                String ngaySinh = scanner.nextLine();
                System.out.println("Nhập giới tính khách hàng");
                String sex = scanner.nextLine();
                System.out.println("Nhập số CMND khách hàng");
                int cmnd = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập số điện thoại khách hàng");
                int sdt = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập email khách hàng");
                String email = scanner.nextLine();
                System.out.println("Nhập loại khách hàng");
                String loaiKH = scanner.nextLine();
                System.out.println("NHập địa chỉ khách hàng");
                String diaChi = scanner.nextLine();
                linkedListCus.get(i).setHoTen(name);
                linkedListCus.get(i).setNgaySinh(ngaySinh);
                linkedListCus.get(i).setGioiTinh(sex);
                linkedListCus.get(i).setSoCMND(cmnd);
                linkedListCus.get(i).setSoDT(sdt);
                linkedListCus.get(i).setEmail(email);
                linkedListCus.get(i).setLoaiKH(loaiKH);
                linkedListCus.get(i).setDiaChi(diaChi);
            }
        }
        File file = new File(CUSTUMER_PATH);
        file.delete();
        writeCus(linkedListCus, CUSTUMER_PATH, true);
        hienThi();
    }
}
