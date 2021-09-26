package case_study.services;

import case_study.models.Customer;
import case_study.models.Employee;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Scanner;

public class CustomerServiceImpl extends Customer implements IService {
    Scanner scanner = new Scanner(System.in);
    private static LinkedList<Customer> listCustomer = new LinkedList<>();
    static {
        Customer  cus1 = new Customer(101,"Từ Thịnh","15/82","Nam",21242333,987654321,"a.mail@gmail","Diamond","Quảng ngãi");
        listCustomer.add(cus1);
    }

    @Override
    public void hienThi() {
        for (int i = 0; i < listCustomer.size(); i++) {
            System.out.println(listCustomer.get(i));
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
        int cmnd = scanner.nextInt();
        System.out.println("Nhập số điện thoại khách hàng");
        int sdt = scanner.nextInt();
        System.out.println("Nhập email khách hàng");
        String email = scanner.nextLine();
        System.out.println("Nhập loại khách hàng");
        String loaiKH = scanner.nextLine();
        System.out.println("NHập địa chỉ khách hàng");
        String diaChi = scanner.nextLine();
        Customer customer = new Customer(ma, name, ngaySinh, sex, cmnd, sdt, email, loaiKH, diaChi);
        listCustomer.add(customer);
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
        for (int i = 0; i < listCustomer.size(); i++) {
            if (maEdit == listCustomer.get(i).getMa()){
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
                listCustomer.get(i).setHoTen(name);
                listCustomer.get(i).setNgaySinh(ngaySinh);
                listCustomer.get(i).setGioiTinh(sex);
                listCustomer.get(i).setSoCMND(cmnd);
                listCustomer.get(i).setSoDT(sdt);
                listCustomer.get(i).setEmail(email);
                listCustomer.get(i).setLoaiKH(loaiKH);
                listCustomer.get(i).setDiaChi(diaChi);
            }
        }
        hienThi();
    }
}
