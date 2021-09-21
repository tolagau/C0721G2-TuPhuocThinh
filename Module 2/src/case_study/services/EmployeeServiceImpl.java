package case_study.services;

import case_study.models.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EmployeeServiceImpl extends Employee implements IEmployeeService{

    public EmployeeServiceImpl(String hoTen, String ngaySinh, String gioiTinh, int soCMND, int soDT, String email) {
        super(hoTen, ngaySinh, gioiTinh, soCMND, soDT, email);
    }

    public EmployeeServiceImpl() {
    }

    public EmployeeServiceImpl(String hoTen, String ngaySinh, String gioiTinh, int soCMND, int soDT, String email, int maNV, String trinhDo, String viTri, double luong) {
        super(hoTen, ngaySinh, gioiTinh, soCMND, soDT, email, maNV, trinhDo, viTri, luong);
    }

    public EmployeeServiceImpl(int maNV, String trinhDo, String viTri, double luong) {
        super(maNV, trinhDo, viTri, luong);
    }

    Scanner scanner = new Scanner(System.in);
    private static ArrayList<Employee> listEmployee = new ArrayList<>();
    static {
        Employee emp1 = new Employee("Nguyễn Văn A","15/07/1998","Nam",212423058,
                1234,"a.mail@gmail.com",1001,"Đại học","Quản lý",5000000);
        Employee emp2 = new Employee("Hồ Thị B","15/07/1998","Nữ",212423058,1234,"b.mail@gmail.com");
        Employee emp3 = new Employee("Võ Thanh D","15/07/1998","Nam",212423058,1234,"d.mail@gmail.com");
        Employee emp4 = new Employee("Hồ Thu P","15/07/1998","Nam",212423058,1234,"p.mail@gmail.com");
        Employee emp5 = new Employee("Phan Văn T","15/07/1998","Nam",212423058,1234,"t.mail@gmail.com");
        Employee emp6 = new Employee("Lê Thị S","15/07/1998","Nữ",212423058,1234,"s.mail@gmail.com");
        Employee emp7 = new Employee("Đinh Văn K","15/07/1998","Nam",212423058,1234,"k.mail@gmail.com");
        listEmployee.add(emp1);
        listEmployee.add(emp2);
        listEmployee.add(emp3);
        listEmployee.add(emp4);
        listEmployee.add(emp5);
        listEmployee.add(emp6);
        listEmployee.add(emp7);
    }


    @Override
    public void hienThi() {
        for (int i = 0; i < listEmployee.size();i++){
            System.out.println(listEmployee.get(i));
        }
    }

    @Override
    public void them() {
        hienThi();
        System.out.println("Thêm nhân viên mới");
        System.out.println("---------------------------");
        System.out.println("Nhập họ tên");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày sinh");
        String ngaySinh = scanner.nextLine();
        System.out.println("Nhập giới tính");
        String sex = scanner.nextLine();
        System.out.println("Nhập số CMND");
        int cmnd = scanner.nextInt();
        System.out.println("Nhập số điện thoại");
        int sdt = scanner.nextInt();
        System.out.println("Nhập email");
        String email = scanner.nextLine();
        Employee employee = new Employee(name,ngaySinh,sex,cmnd,sdt,email);
        listEmployee.add(employee);
    }

    @Override
    public void sua() {
        hienThi();


    }
}
