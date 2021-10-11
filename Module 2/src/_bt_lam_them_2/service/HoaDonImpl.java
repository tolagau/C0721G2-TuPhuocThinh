package _bt_lam_them_2.service;

import _bt_lam_them_2.models.HoaDon;
import _bt_lam_them_2.models.NguoiNN;
import _bt_lam_them_2.models.NguoiVN;
import _bt_lam_them_2.models.Person;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static _bt_lam_them_2.service.KhachHangImpl.KH_PATH;
import static _bt_lam_them_2.service.KhachHangImpl.readNguoi;
import static _bt_lam_them_2.utils.ReadAndWrite.readFile;
import static _bt_lam_them_2.utils.ReadAndWrite.writeFile;

public class HoaDonImpl implements Service {
    static Scanner scanner = new Scanner(System.in);
    private static final String HD_PATH = "src\\_bt_lam_them_2\\data\\hoadon.csv";
    File file = new File(HD_PATH);
    private static List<HoaDon> hoaDonList = readHD(HD_PATH);
    static List<Person> personList = readNguoi(KH_PATH);

    public static void writeHD(List<HoaDon> listHoa, String filePath, boolean append) {
        List<String> str = new ArrayList<>();
        for (HoaDon listStr : hoaDonList) {
            str.add(listStr.getInfo());
        }
        writeFile(str, HD_PATH, true);
    }

    public static List<HoaDon> readHD(String filePath) {
        List<String> str = readFile(HD_PATH);
        List<HoaDon> hoaDonsStr = new ArrayList<>();
        personList = readNguoi(KH_PATH);
        for (String listStr : str) {
            String[] temp;
            temp = listStr.split(",");
            Person person = new Person();
            for (Person person1 : personList) {
                if (person1.getIdPerson().equals(temp[1])) {
                    person = person1;
                }
            }
            HoaDon hoaDon = new HoaDon(temp[0], person, temp[2], Integer.parseInt(temp[3])
                    , Double.parseDouble(temp[4]));
            hoaDonsStr.add(hoaDon);
        }
        return hoaDonsStr;
    }

    @Override
    public void hienThi() {

        for (HoaDon str : hoaDonList) {
            System.out.println(str.toString());
        }
    }

//    if(id <10) {
//        idReceipt = "MHD-00"+(Integer.parseInt(temp[1]) +1);
//    }else if(id<100) {
//        idReceipt = "MHD-0"+(Integer.parseInt(temp[1]) +1);
//    }else {
//        idReceipt = "MHD-"+(Integer.parseInt(temp[1]) +1);
//    }
    @Override
    public void them() {
        KhachHangImpl khachHang = new KhachHangImpl();
        khachHang.hienThi();
        System.out.println("Nhập các thông tin của hóa đơn");
        System.out.println("--------------------------------");
        //-------------------tạo id tự động---------------------------
        String[] temp = hoaDonList.get(hoaDonList.size() - 1).getMaHoaDon().split("-");
        int i = Integer.parseInt(temp[1]) + 1;
        String idHD = "MHD-00" + i;
        //--------------------------------------------
        System.out.println("Nhập thứ tự khách hàng để lấy mã khách hàng");
        int index = Integer.parseInt(scanner.nextLine());
        Person person = personList.get(index - 1);
        System.out.println("Nhập ngày tạo hóa đơn");
        String ngayTao = scanner.nextLine();
        System.out.println("Số lượng tiêu thụ kWH");
        int soLuong = Integer.parseInt(scanner.nextLine());
        System.out.println("Đơn giá");
        double donGia = Double.parseDouble(scanner.nextLine());
        HoaDon hoaDon = new HoaDon(idHD, person, ngayTao, soLuong, donGia);
        File file = new File(HD_PATH);
        file.delete();
        hoaDonList.add(hoaDon);
        writeHD(hoaDonList, HD_PATH, true);
    }

    @Override
    public void sua() {

    }

    @Override
    public void timKiem() {

    }

    @Override
    public void xoa() {

    }
}
