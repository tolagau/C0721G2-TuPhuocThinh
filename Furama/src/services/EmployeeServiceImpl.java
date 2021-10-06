package services;

import models.Employee;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.ReadAndWrite.readFile;
import static utils.ReadAndWrite.writeFile;

public class EmployeeServiceImpl extends Employee implements IEmployeeService {
    Scanner scanner = new Scanner(System.in);
    private List<Employee> listEmployee = readEmploy(EMPLOYEE_PATH);
    private static final String EMPLOYEE_PATH = "src\\data\\employee.csv";

    public static void writeEmploy(List<Employee> listEmp, String filePath, boolean append) {
        List<String> str = new ArrayList<>();
        for (Employee listStr : listEmp) {
            str.add(listStr.getEmploy());
        }
        writeFile(str, EMPLOYEE_PATH, true);
    }

    public static List<Employee> readEmploy(String filePath) {
        List<String> str = readFile(EMPLOYEE_PATH);
        List<Employee> employeeList = new ArrayList<>();
        for (String listStr : str) {
            String[] temp = listStr.split(",");
            Employee employee = new Employee(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3],
                    Integer.parseInt(temp[4]), Integer.parseInt(temp[5]),
                    temp[6], temp[7], temp[8], Double.parseDouble(temp[9]));
            employeeList.add(employee);
        }
        return employeeList;
    }

    @Override
    public void hienThi() {
        listEmployee = readEmploy(EMPLOYEE_PATH);
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
        int cmnd = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số điện thoại");
        int sdt = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập email nhân viên");
        String email = scanner.nextLine();
        System.out.println("Nhập trình độ nhân viên");
        String trinh = scanner.nextLine();
        System.out.println("NHập vị trí nhân viên");
        String viTri = scanner.nextLine();
        System.out.println("Nhập lương nhân viên");
        int luong = Integer.parseInt(scanner.nextLine());
        Employee employee = new Employee(ma, name, ngaySinh, sex, cmnd, sdt, email, trinh, viTri, luong);
        listEmployee.add(employee);
        File file = new File(EMPLOYEE_PATH);
        file.delete();
        writeEmploy(listEmployee, EMPLOYEE_PATH, true);
        hienThi();
    }

    @Override
    public void sua() {
        hienThi();
        System.out.println("---------------------------------");
        System.out.println("Sửa thông tin nhân viên");
        System.out.println("---------------------------------");
        System.out.println("Nhập mã nhân viên cần chỉnh sửa: ");
        int maEdit = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < listEmployee.size(); i++) {
            if (maEdit == listEmployee.get(i).getMa()) {
                System.out.println("Nhập họ tên");
                String name = scanner.nextLine();
                System.out.println("Nhập ngày sinh");
                String ngaySinh = scanner.nextLine();
                System.out.println("Nhập giới tính");
                String sex = scanner.nextLine();
                System.out.println("Nhập số CMND");
                int cmnd = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập số điện thoại");
                int sdt = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập email nhân viên");
                String email = scanner.nextLine();
                System.out.println("Nhập trình độ nhân viên");
                String trinh = scanner.nextLine();
                System.out.println("NHập vị trí nhân viên");
                String viTri = scanner.nextLine();
                System.out.println("Nhập lương nhân viên");
                int luong = Integer.parseInt(scanner.nextLine());
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
            File file = new File(EMPLOYEE_PATH);
        file.delete();
        writeEmploy(listEmployee, EMPLOYEE_PATH, false);
        hienThi();
    }
}