package _thi_module_2.service;

import _thi_module_2.models.CoThoiHan;
import _thi_module_2.models.DaiHan;
import _thi_module_2.models.KhachHang;
import _thi_module_2.models.VoThoiHan;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import static _thi_module_2.utils.DocGhiThanhPhan.*;
import static _thi_module_2.utils.ReadAndWrite.readFile;
import static _thi_module_2.utils.ReadAndWrite.writeFile;

public class MannagerImpl implements Service {

    public static final String NGANHAN = "src\\_thi_module_2\\data\\shortTerm.csv";
    public static final String DAIHAN_PATH = "src\\_thi_module_2\\data\\longTerm.csv";
    public static final String CUSTOMER = "src\\_thi_module_2\\data\\customer.csv";
    File filengan = new File(NGANHAN);
    File filedai = new File(DAIHAN_PATH);
    List<KhachHang> khachHangList = docFileKhachHang(CUSTOMER);
    List<CoThoiHan> coThoiHanList = docCoThoiHan(NGANHAN);
    List<VoThoiHan> voThoiHanList = docVoHan(NGANHAN);
    List<DaiHan> daiHanList = docDaiHan(DAIHAN_PATH);
    static Scanner sc = new Scanner(System.in);

    @Override
    public void hienThi() {
        String chon;
        System.out.println("Chọn loại sổ tiết kiệm muốn hiển thị: " +
                "1: Dài hạn \n " +
                "2: Vô thời hạn \n " +
                "3: Có thời hạn");
        chon = sc.nextLine();
        switch (chon) {
            case "1":
                hienThiDaiHan();
                break;
            case "2":
                hienThiVoThoiHan();
                break;
            case "3":
                hienThiCoThoiHan();
                break;
        }

    }

    public void hienThiDaiHan() {
        for (DaiHan daiHan : daiHanList) {
            System.out.println(daiHan.toString());
        }
    }

    public void hienThiVoThoiHan() {
        for (VoThoiHan voThoiHan : voThoiHanList) {
            System.out.println(voThoiHan.toString());
        }
    }

    public void hienThiCoThoiHan() {
        for (CoThoiHan coThoiHan : coThoiHanList) {
            System.out.println(coThoiHan.toString());
        }
    }

    @Override
    public void them() {
        String choice;
        System.out.println("Chọn loai sổ tiết kiệm: \n" +
                " 1: Dài Hạn: \n" +
                " 1: Ngắn Hạn: \n");
        choice = sc.nextLine();
        switch (choice) {
            case "1":
                DaiHan soDaiHan = new DaiHan(nhapIDSTK(), nhapIDKH(), nhapDateMo(),
                        nhapDate(), Double.parseDouble(nhapTienGui()),
                        Double.parseDouble(nhapLai()), nhapKyHan(), nhapUuDai());
                daiHanList.add(soDaiHan);
                filedai.delete();
                ghiDaiHan(daiHanList, DAIHAN_PATH, true);
                break;
            case "2":
                String choice1;
                System.out.println("Chọn loai sổ tiết kiệm: \n" +
                        " 1: Ngắn hạn: \n" +
                        " 2: Vô thời hạn: \n");
                choice1 = sc.nextLine();
                switch (choice1) {
                    case "1":
                        VoThoiHan soNgaHan = new VoThoiHan(nhapIDSTK(), nhapIDKH(), nhapDateMo(), nhapDate(),
                                Double.parseDouble(nhapTienGui()), Double.parseDouble(nhapLai()));
                        voThoiHanList.add(soNgaHan);
                        filengan.delete();
                        ghiVoHan(voThoiHanList, NGANHAN, true);
                        break;
                    case "2":
                        CoThoiHan coThoiHan = new CoThoiHan(nhapIDSTK(), nhapIDKH(), nhapDateMo(), nhapDate()
                                , Double.parseDouble(nhapTienGui()), Double.parseDouble(nhapLai()), nhapKyHan());
                        coThoiHanList.add(coThoiHan);
                        filengan.delete();
                        ghiCoThoiHan(coThoiHanList, NGANHAN, true);
                }
        }

    }

    private String nhapIDSTK() {
        System.out.println("Nhập mã sổ: ");
        String ma = sc.nextLine();
        return ma;
    }

    private KhachHang nhapIDKH() {
        System.out.println("Khách hàng");
        for (int i = 0; i < khachHangList.size(); i++) {
            System.out.println((i + 1) + "," + khachHangList.get(i).toString());
        }
        System.out.println("Nhập thứ tự khách hàng muốn thêm");
        int index = Integer.parseInt(sc.nextLine());
        KhachHang khachHang = new KhachHang();
        khachHang = khachHangList.get(index - 1);
        return khachHang;
    }

    private String nhapDateMo() {
        System.out.println("Nhập ngay mở sổ: ");
        String ngay = sc.nextLine();
        return ngay;
    }

    private String nhapDate() {
        System.out.println("Nhập thời gian ");
        String thoiGian = sc.nextLine();
        return thoiGian;
    }

    private String nhapKyHan() {
        System.out.println("Nhap kỳ hạn: ");
        String kyHan = sc.nextLine();
        return kyHan;
    }

    private String nhapTienGui() {
        System.out.println("Enter tiền gửi: ");
        String tienGui = sc.nextLine();
        return tienGui;
    }

    private String nhapLai() {
        System.out.println("Nhâp lãi: ");
        String lai = sc.nextLine();
        return lai;
    }

    private String nhapUuDai() {
        System.out.println("Nhâp ưu đãi: ");
        String uuDai = sc.nextLine();
        return uuDai;
    }


    @Override
    public void xoa() {
        System.out.println("Nhập mã số tiết kiệm muốn xóa theo danh sách: " +
                "1: Sổ tiết kiệm dài hạn" +
                "2: Sổ tiết kiệm ngắn hạn");
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                hienThiDaiHan();
                System.out.println("Nhập mã số tiết kiệm cần xóa");
                String id = sc.nextLine();
                for (int i = 0; i < daiHanList.size(); i++) {
                    if (id.equals(daiHanList.get(i).getIdSTK())) {
                        String choiceDelete;
                        System.out.println("Bạn có chắc muốn xóa không \n" +
                                " 1. Đồng ý\n" +
                                " 2. No");
                        choiceDelete = sc.nextLine();
                        if (choiceDelete.equals("1")) {
                            daiHanList.remove(daiHanList.get(i));
                            System.out.println("Xóa thành công");
                            break;
                        } else {
                            break;
                        }
                    }
                }
                filedai.delete();
                ghiDaiHan(daiHanList, DAIHAN_PATH, true);
                break;
            case "2":
                System.out.println("Chọn loại sổ tiết kiệm: " +
                        "1: Có thời hạn" +
                        "2: Vô thời hạn");
                String chon = sc.nextLine();
                switch (chon) {
                    case "1": {
                        hienThiCoThoiHan();
                        System.out.println("Nhập mã số tiết kiệm cần xóa");
                        String idDele = sc.nextLine();
                        for (int i = 0; i < coThoiHanList.size(); i++) {
                            if (idDele.equals(coThoiHanList.get(i).getIdSTK())) {
                                String choiceDelete;
                                System.out.println("Bạn có chắc muốn xóa không \n" +
                                        " 1. Đồng ý\n" +
                                        " 2. No");
                                choiceDelete = sc.nextLine();
                                if (choiceDelete.equals("1")) {
                                    coThoiHanList.remove(coThoiHanList.get(i));
                                    System.out.println("Xóa thành công");
                                    break;
                                } else {
                                    break;
                                }
                            }
                        }
                        filengan.delete();
                        ghiCoThoiHan(coThoiHanList, NGANHAN, true);
                        break;
                    }
                    case "2": {
                        hienThiVoThoiHan();
                        System.out.println("Nhập mã số tiết kiệm cần xóa");
                        String idDele = sc.nextLine();
                        for (int i = 0; i < voThoiHanList.size(); i++) {
                            if (idDele.equals(voThoiHanList.get(i).getIdSTK())) {
                                String choiceDelete;
                                System.out.println("Bạn có chắc muốn xóa không \n" +
                                        " 1. Đồng ý\n" +
                                        " 2. No");
                                choiceDelete = sc.nextLine();
                                if (choiceDelete.equals("1")) {
                                    voThoiHanList.remove(voThoiHanList.get(i));
                                    System.out.println("Xóa thành công");
                                    break;
                                } else {
                                    break;
                                }
                            }
                        }
                        filedai.delete();
                        ghiVoHan(voThoiHanList, NGANHAN, true);
                        break;
                    }

                }
        }
    }
}