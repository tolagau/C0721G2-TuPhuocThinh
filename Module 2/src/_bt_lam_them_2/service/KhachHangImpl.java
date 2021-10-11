package _bt_lam_them_2.service;

import _bt_lam_them_2.models.NguoiNN;
import _bt_lam_them_2.models.NguoiVN;
import _bt_lam_them_2.models.Person;
import _bt_lam_them_2.utils.Regex;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static _bt_lam_them_2.utils.ReadAndWrite.readFile;
import static _bt_lam_them_2.utils.ReadAndWrite.writeFile;

public class KhachHangImpl implements Service {
    public static final String CHECK_MA_KH = "^KH(VN|NN)-\\d{5}$";

    static Scanner scanner = new Scanner(System.in);

    protected static final String KH_PATH = "src\\_bt_lam_them_2\\data\\khachhang.csv";

    public static final String TYPE_PATH = "src\\_bt_lam_them_2\\data\\loaikhach.csv";

    File file = new File(KH_PATH);

    private static List<Person> personList = readNguoi(KH_PATH);


    public static void writeNguoi(List<Person> listPer, String filePath, boolean append) {
        List<String> str = new ArrayList<>();
        for (Person listStr : personList) {
            if (listStr instanceof NguoiVN) {
                str.add(((NguoiVN) listStr).getInfoVN());
            } else {
                str.add(((NguoiNN) listStr).getInfoNN());
            }
        }
        writeFile(str, KH_PATH, true);
    }

    public static List<Person> readNguoi(String filePath) {
        List<String> str = readFile(KH_PATH);
        List<Person> personList1 = new ArrayList<>();
        for (String listStr : str) {
            String[] temp;
            temp = listStr.split(",");
            switch (temp.length) {
                case 4: {
                    Person person = new NguoiVN(temp[0], temp[1], temp[2], Integer.parseInt(temp[3]));
                    personList1.add(person);
                    break;
                }
                case 3: {
                    Person person = new NguoiNN(temp[0], temp[1], temp[2]);
                    personList1.add(person);
                    break;
                }
            }
        }
        return personList1;
    }


    @Override
    public void hienThi() {
        // personList = readNguoi(KH_PATH);

        for (int i = 0; i < personList.size(); i++) {
            System.out.println((i + 1) + "," + personList.get(i));
        }
    }

    @Override
    public void them() {
        System.out.println("Chọn đối tượng khách hàng cần thêm:\n " +
                "1: Người Việt Nam\n" +
                "2: Người nước ngoài");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1: {
                String idKH = inputID();
                System.out.println("Nhập họ tên khách hàng:");
                String name = scanner.nextLine();
                System.out.println("Nhập định mức điện tiêu thụ:");
                int dinhMuc = Integer.parseInt(scanner.nextLine());
                Person nguoiVN = new NguoiVN(idKH, name, getType(), dinhMuc);
                personList.add(nguoiVN);
                file.delete();
                writeNguoi(personList, KH_PATH, true);
                break;
            }
            case 2: {
                System.out.println("Nhập mã khách hàng:");
                String idKH = scanner.nextLine();
                System.out.println("Nhập họ tên khách hàng:");
                String name = scanner.nextLine();
                System.out.println("Nhập quốc tịch khách hàng");
                String quocTich = scanner.nextLine();
                Person nguoiNN = new NguoiNN(idKH, name, quocTich);
                personList.add(nguoiNN);
                file.delete();
                writeNguoi(personList, KH_PATH, true);
                break;
            }
            default:
                System.out.println("Bạn nhập sai rồi");
        }
    }

    public static String getType() {
        int choice;
        String type = "";

        List<String> stringList = readFile(TYPE_PATH);
        System.out.println("Choice type of customer: " +
                " 1:LKH-001,Sinh Hoat \n" +
                " 2:LKH-002,Kinh doanh\n" +
                " 3:LKH-003,Sản xuất: ");
        choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                for (String string : stringList) {
                    String[] temp = string.split(",");
                    if (temp[0].contains("001")) {
                        type = temp[1];
                        break;
                    }
                }
                break;
            case 2:
                for (String string : stringList) {
                    String[] temp = string.split(",");
                    if (temp[0].contains("002")) {
                        type = temp[1];
                        break;
                    }
                }
                break;
            case 3:
                for (String string : stringList) {
                    String[] temp = string.split(",");
                    if (temp[0].contains("003")) {
                        type = temp[1];
                        break;
                    }
                }
                break;
        }
        return type;
    }

    private String inputID() {
        boolean check = true;
        String id = "";
        while (check) {
            System.out.println("Nhập mã khách hàng: ");
            id = Regex.regexData(scanner.nextLine(), CHECK_MA_KH,
                    "Bạn đã nhập sai định dạng mã khách hàng,bạn cần nhập lại theo định dạng KHXX-YYYYY");
            for (int i = 0; i < personList.size(); i++) {
                if (id.equals(personList.get(i).getIdPerson())) {
                    System.out.println("ID bạn nhập bị trùng");
                    check = true;
                    break;
                }
                check = false;
            }
        }
        return id;
    }

//    private String inputID(){
//        System.out.println("Nhập mã khách hàng: ");
//       return Regex.regexData(scanner.nextLine(),CHECK_MA_KH,
//               "Bạn đã nhập sai định dạng mã khách hàng,bạn cần nhập lại theo định dạng KHXX-YYYYY");
//    }


    @Override
    public void sua() {
        System.out.println("Chọn đối tượng khách hàng cần sửa:\n " +
                "1: Người Việt Nam\n" +
                "2: Người nước ngoài");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1: {
                hienThi();
                System.out.println("Nhập mã khách hàng cần sửa:");
                String idKH = scanner.nextLine();
                for (int i = 0; i < personList.size(); i++) {
                    if (personList.get(i).getIdPerson().equals(idKH)) {
                        System.out.println("Nhập họ tên khách hàng cần sửa:");
                        String name = scanner.nextLine();
                        System.out.println("Nhập loại khách hàng cần sửa:");
                        String loaiKH = scanner.nextLine();
                        System.out.println("Nhập định mức điện tiêu thụ cần sửa:");
                        int dinhMuc = Integer.parseInt(scanner.nextLine());
                        personList.get(i).setName(name);
                        ((NguoiVN) personList.get(i)).setLoaiKH(loaiKH);
                        ((NguoiVN) personList.get(i)).setDinhMuc(dinhMuc);
                    }
                }
                file.delete();
                writeNguoi(personList, KH_PATH, true);
                break;
            }
            case 2: {
                hienThi();
                System.out.println("Nhập mã khách hàng cần sửa:");
                String idKH = scanner.nextLine();
                for (int i = 0; i < personList.size(); i++) {
                    if (personList.get(i).getIdPerson().equals(idKH)) {
                        System.out.println("Nhập họ tên khách hàng cần sửa:");
                        String name = scanner.nextLine();
                        System.out.println("Nhập quốc tịch khách hàng cần sửa:");
                        String quocTich = scanner.nextLine();
                        personList.get(i).setName(name);
                        ((NguoiNN) personList.get(i)).setQuocTich(quocTich);
                    }
                }
                file.delete();
                writeNguoi(personList, KH_PATH, true);
                break;
            }
        }


    }


    @Override
    public void timKiem() {
        System.out.println("Nhập tên khách hàng cần tìm kiếm: ");
        String nameSreach = scanner.nextLine();
        List<Person> listPer = new ArrayList<>();
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getName().contains(nameSreach)) {
                listPer.add(personList.get(i));
            }
        }
        if (listPer.size() == 0) {
            System.out.println("Không có khách hàng này trong danh sách");
        } else {
            for (Person person : listPer) {
                System.out.println(person.toString());
            }
        }
    }

    @Override
    public void xoa() {
        hienThi();
        System.out.println("Nhập id cần xóa: ");
        String idDelete = scanner.nextLine();
        boolean check = true;
        while (check) {
            System.out.println("Mày có chắc xóa không?" +
                    " 1. delete " +
                    " 2. return menu ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    for (int i = 0; i < personList.size(); i++) {
                        if (personList.get(i).getIdPerson().equals(idDelete)) {
                            personList.remove(personList.get(i));
                            file.delete();
                            writeNguoi(personList, KH_PATH, true);
                        }
                    }
                    break;
            }
            break;
        }
        hienThi();
    }
}
