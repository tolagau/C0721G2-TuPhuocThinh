package case_study.services;

import case_study.models.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EmployeeServiceImpl extends Employee implements IEmployeeService {
    Scanner scanner = new Scanner(System.in);
    private static ArrayList<Employee> listEmployee = new ArrayList<>();
    static {
        Employee emp1 = new Employee(1001, "Nguyễn Văn A", "15/02/1998", "Nam",
                21232578, 91440079, "a.mail@gmail.com", "Cao đẳng", "Nhân viên", 5000000);
        Employee emp2 = new Employee(1002, "Lê Thị B", "01/03/1995", "Nữ",
                21235678, 78440079, "b.mail@gmail.com", "THạc sĩ", "Quản Lý", 10000000);
        Employee emp3 = new Employee(1003, "Đinh văn C", "15/02/1998", "Nam",
                21232578, 91440079, "c.mail@gmail.com", "Trung cấp", "Phục vụ", 3000000);
        Employee emp4 = new Employee(1004, "Võ Văn D", "15/02/1998", "Nam",
                21232578, 91440079, "d.mail@gmail.com", "Cao đẳng", "Nhân viên", 5000000);
        listEmployee.add(emp1);
        listEmployee.add(emp2);
        listEmployee.add(emp3);
        listEmployee.add(emp4);
    }

    @Override
    public void hienThi() {
        for (int i = 0; i < listEmployee.size(); i++) {
            System.out.println(listEmployee.get(i));
        }
    }

    @Override
    public void them() {
        hienThi();
        System.out.println("Thêm nhân viên mới");
        System.out.println("---------------------------");
        System.out.println("Nhập mã nhân viên");
        int ma = Integer.parseInt(scanner.nextLine());
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
        System.out.println("Nhập email nhân viên");
        String email = scanner.nextLine();
        System.out.println("Nhập trình độ nhân viên");
        String trinh = scanner.nextLine();
        System.out.println("NHập vị trí nhân viên");
        String viTri = scanner.nextLine();
        System.out.println("Nhập lương nhân viên");
        int luong = scanner.nextInt();
        Employee employee = new Employee(ma, name, ngaySinh, sex, cmnd, sdt, email, trinh, viTri, luong);
        listEmployee.add(employee);
        hienThi();
    }

    @Override
    public void sua() {
        hienThi();
        boolean check = false;
        System.out.println("---------------------------------");
        System.out.println("Sửa thông tin nhân viên");
        System.out.println("---------------------------------");
        System.out.println("Nhập mã nhân viên cần chỉnh sửa: ");
        int maEdit = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < listEmployee.size(); i++) {
            if (maEdit == listEmployee.get(i).getMa()) {
                check = true;
                break;
            }
        }
        if (check) {
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
            System.out.println("Nhập email nhân viên");
            String email = scanner.nextLine();
            System.out.println("Nhập trình độ nhân viên");
            String trinh = scanner.nextLine();
            System.out.println("NHập vị trí nhân viên");
            String viTri = scanner.nextLine();
            System.out.println("Nhập lương nhân viên");
            int luong = scanner.nextInt();
           for (int i = 1; i < listEmployee.size(); i++) {
                listEmployee.get(i).setHoTen(name);
                listEmployee.get(i).setNgaySinh(ngaySinh);
                listEmployee.get(i).setGioiTinh(sex);
                listEmployee.get(i).setSoCMND(cmnd);
                listEmployee.get(i).setSoDT(sdt);
                listEmployee.get(i).setEmail(email);
                listEmployee.get(i).setTrinhDo(trinh);
                listEmployee.get(i).setViTri(viTri);
                listEmployee.get(i).setLuong(luong);
            }
        }

//        for (int i = 0; i < listEmployee.size(); i++) {
//            if (maEdit == listEmployee.get(i).getMa()) {
//                listEmployee.get(i).setHoTen(name);
//                listEmployee.get(i).setNgaySinh(ngaySinh);
//                listEmployee.get(i).setGioiTinh(sex);
//                listEmployee.get(i).setSoCMND(cmnd);
//                listEmployee.get(i).setSoDT(sdt);
//                listEmployee.get(i).setEmail(email);
//                listEmployee.get(i).setTrinhDo(trinh);
//                listEmployee.get(i).setViTri(viTri);
//                listEmployee.get(i).setLuong(luong);
//            }
//        }
        hienThi();
    }
}
