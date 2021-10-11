package _thi_module_2.utils;

import _thi_module_2.models.CoThoiHan;
import _thi_module_2.models.DaiHan;
import _thi_module_2.models.KhachHang;
import _thi_module_2.models.VoThoiHan;

import java.util.ArrayList;
import java.util.List;

import static _thi_module_2.utils.ReadAndWrite.readFile;
import static _thi_module_2.utils.ReadAndWrite.writeFile;

public class DocGhiThanhPhan {

    public static List<CoThoiHan> docCoThoiHan(String path) {
        List<String> stringList = readFile(path);
        List<CoThoiHan> soNganHanList = new ArrayList<>();
        List<KhachHang> khachHangList = docFileKhachHang("src\\_thi_module_2\\data\\customer.csv");
        for (String string : stringList) {
            String[] temp = string.split(",");
            KhachHang khachHang1 = new KhachHang();
            for (KhachHang khachHang : khachHangList) {
                if (khachHang.getIdKH().equals(temp[1])) {
                    khachHang1 = khachHang;
                }
            }
            CoThoiHan receipt = new CoThoiHan(temp[0], khachHang1, temp[2], temp[3],
                    Double.parseDouble(temp[4]), Double.parseDouble(temp[5]), temp[6]);
            soNganHanList.add(receipt);
        }
        return soNganHanList;
    }

    public static List<VoThoiHan> docVoHan(String path) {
        List<String> stringList = readFile(path);
        List<VoThoiHan> soVoHanList = new ArrayList<>();
        List<KhachHang> khachHangList = docFileKhachHang("src\\_thi_module_2\\data\\customer.csv");
        for (String string : stringList) {
            String[] temp = string.split(",");
            KhachHang khachHang1 = new KhachHang();
            for (KhachHang khachHang : khachHangList) {
                if (khachHang.getIdKH().equals(temp[1])) {
                    khachHang1 = khachHang;
                }
            }
            VoThoiHan soVoHan = new VoThoiHan(temp[0], khachHang1, temp[2], temp[3],
                    Double.parseDouble(temp[4]), Double.parseDouble(temp[5]));
            soVoHanList.add(soVoHan);
        }
        return soVoHanList;
    }

    public static List<DaiHan> docDaiHan(String path) {
        List<String> stringList = readFile(path);
        List<DaiHan> soDaiHanList = new ArrayList<>();
        List<KhachHang> khachHangList = docFileKhachHang("src\\_thi_module_2\\data\\customer.csv");
        for (String string : stringList) {
            String[] temp = string.split(",");
            KhachHang khachHang1 = new KhachHang();
            for (KhachHang khachHang : khachHangList) {
                if (khachHang.getIdKH().equals(temp[1])) {
                    khachHang1 = khachHang;
                }
            }
            DaiHan soDaiHan = new DaiHan(temp[0], khachHang1, temp[2], temp[3],
                    Double.parseDouble(temp[4]), Double.parseDouble(temp[5]), temp[6], temp[7]);
            soDaiHanList.add(soDaiHan);
        }
        return soDaiHanList;
    }

    public static List<KhachHang> docFileKhachHang(String path) {
        List<String> stringList = readFile(path);
        List<KhachHang> khachHangList = new ArrayList<>();
        for (String string : stringList) {
            String[] temp = string.split(",");
            KhachHang khachHang = new KhachHang(temp[0], temp[1], temp[2], temp[3],
                    temp[4], temp[5]);
            khachHangList.add(khachHang);
        }
        return khachHangList;
    }

    public static void ghiCoThoiHan(List<CoThoiHan> soNganHanList, String path, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (CoThoiHan soNganHan : soNganHanList) {
            stringList.add(soNganHan.getInfoCoThoiHan());
        }
        writeFile(stringList, path, append);
    }

    public static void ghiVoHan(List<VoThoiHan> soVoHanList, String path, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (VoThoiHan soVoHan : soVoHanList) {
            stringList.add(soVoHan.getInfoVoThoiHan());
        }
        writeFile(stringList, path, append);
    }

    public static void ghiDaiHan(List<DaiHan> daiHanList, String path, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (DaiHan soDaiHan : daiHanList) {
            stringList.add(soDaiHan.getInfoDai());
        }
        writeFile(stringList, path, append);
    }

}

