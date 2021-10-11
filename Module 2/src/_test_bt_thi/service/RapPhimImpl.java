package _test_bt_thi.service;

import _bt_lam_them_2.models.NguoiNN;
import _bt_lam_them_2.models.NguoiVN;
import _bt_lam_them_2.models.Person;
import _bt_lam_them_2.utils.Regex;
import _test_bt_thi.models.RapPhim;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static _bt_lam_them_2.utils.ReadAndWrite.readFile;
import static _bt_lam_them_2.utils.ReadAndWrite.writeFile;

public class RapPhimImpl implements Service {
    private static final String CHECK_ID= "^CI-\\d{4}$";
    static Scanner scanner = new Scanner(System.in);
    private static final String PHIM_PATH = "src\\_test_bt_thi\\data\\phim.csv";

    private static List<RapPhim> phimList = readPhim(PHIM_PATH);

    public static void writePhim(List<RapPhim> listPer, String filePath, boolean append) {
        List<String> str = new ArrayList<>();
        for (RapPhim listStr : listPer) {
            str.add(listStr.getInfo());
        }
        writeFile(str, PHIM_PATH, true);
    }

    public static List<RapPhim> readPhim(String filePath) {
        List<String> str = readFile(PHIM_PATH);
        List<RapPhim> rapPhimList = new ArrayList<>();
        for (String listStr : str) {
            String[] temp;
            temp = listStr.split(",");
            RapPhim rapPhim;
            rapPhim = new RapPhim(temp[0], temp[1], temp[2], Integer.parseInt(temp[3]));
            rapPhimList.add(rapPhim);
        }
        return rapPhimList;
    }

    @Override
    public void disPlay() {
        phimList = readPhim(PHIM_PATH);
        for (RapPhim phim : phimList) {
            System.out.println(phim.toString());
        }
    }

    @Override
    public void add() {
        System.out.println("Thêm phim mới");
        System.out.println("------------------------------");
        System.out.println("Nhập mã phim cần thêm");
        String maPhim = scanner.nextLine();
        System.out.println("Nhập tên phim cần thêm");
        String namePhim = scanner.nextLine();
        System.out.println("Nhập ngày chiếu phim");
        String date = scanner.nextLine();
        System.out.println("Nhập số lượng vé xem phim");
        int soVe = Integer.parseInt(scanner.nextLine());
        RapPhim rapPhim = new RapPhim(maPhim, namePhim, date, soVe);
        phimList.add(rapPhim);
        File file = new File(PHIM_PATH);
        file.delete();
        writePhim(phimList, PHIM_PATH, true);
    }
//    private String inputID(){
//        System.out.println("Nhập mã phim cần thêm");
//        return Regex.regexData(scanner.nextLine(),CHECK_ID,"Bạn đã nhập sai định dạng mã phim,bạn cần nhập lại theo định dạng CI-YYYY");
//    }

    @Override
    public void delete() {
        phimList = readPhim(PHIM_PATH);
        System.out.println("Nhập mã phim cần xóa: ");
        String idDele = scanner.nextLine();
        System.out.println("Bạn có chắc chắn xóa bộ phim này không? Bạn nhập Y để xóa và N để hủy");
        String yn = scanner.nextLine();
        boolean flag = true;
        for (int i = 0; i < yn.length(); i++) {
            if (yn.equals("y"))
                flag = true;
            else flag = false;
        }
        if (flag) {
            for (int i = 0; i < phimList.size(); i++) {
                if (phimList.get(i).getMaSuat().equals(idDele)) {
                    phimList.remove(i);
                }
            }
        }
    }

    @Override
    public void timKiem() {

    }
}
