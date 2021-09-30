package services;

import models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.ReadAndWrite.readFile;
import static utils.ReadAndWrite.writeFile;

public class EmployeeServiceImpl extends Employee implements IEmployeeService {
    Scanner scanner = new Scanner(System.in);

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
        List<Employee> employeeList = readEmploy(EMPLOYEE_PATH);
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println(employeeList.get(i));
        }
    }

    @Override
    public void them() {
        ArrayList<Employee> listEmployee = new ArrayList<>();
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
        writeEmploy(listEmployee, EMPLOYEE_PATH, true);
        hienThi();
    }

    @Override
    public void sua() {
        List<Employee> employeeList = readEmploy(EMPLOYEE_PATH);
        hienThi();
        System.out.println("---------------------------------");
        System.out.println("Sửa thông tin nhân viên");
        System.out.println("---------------------------------");
        System.out.println("Nhập mã nhân viên cần chỉnh sửa: ");
        int maEdit = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < employeeList.size(); i++) {
            if (maEdit == employeeList.get(i).getMa()) {
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
                employeeList.get(i).setHoTen(name);
                employeeList.get(i).setNgaySinh(ngaySinh);
                employeeList.get(i).setGioiTinh(sex);
                employeeList.get(i).setSoCMND(cmnd);
                employeeList.get(i).setSoDT(sdt);
                employeeList.get(i).setEmail(email);
                employeeList.get(i).setTrinhDo(trinh);
                employeeList.get(i).setViTri(viTri);
                employeeList.get(i).setLuong(luong);
            }
        }
        writeEmploy(employeeList, EMPLOYEE_PATH, false);
        hienThi();
    }
}