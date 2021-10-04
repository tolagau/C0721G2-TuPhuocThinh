package services;

import models.*;

import java.io.File;
import java.lang.reflect.Field;
import java.util.*;

import static utils.ReadAndWrite.readFile;
import static utils.ReadAndWrite.writeFile;

public class FacilityServiceImpl extends Facility implements IService {
    public static final String VL_PATH = "src\\data\\villa.csv";
    public static final String RO_PATH = "src\\data\\room.csv";
    public static final String HO_PATH = "src\\data\\house.csv";
    File fileVl = new File(VL_PATH);
    File fileRo = new File(RO_PATH);
    File fileHo = new File(HO_PATH);
    public static Map<Facility, Integer> facilityList = new LinkedHashMap<>();
    public static Map<Facility, Integer> mapRO = readFici(RO_PATH);
    public static Map<Facility, Integer> mapHO = readFici(HO_PATH);
    public static Map<Facility, Integer> mapVL = readFici(VL_PATH);


    public static void writeFici(Map<Facility, Integer> facilityIntegerMap, String filePath, boolean append) {
        List<String> str = new ArrayList<>();
        for (Map.Entry<Facility, Integer> map : facilityIntegerMap.entrySet()) {
            if (map.getKey() instanceof Room) {
                str.add(((Room) map.getKey()).getInfoRoom() + "," + map.getValue());
            }
            if (map.getKey() instanceof House) {
                str.add(((House) map.getKey()).getInfoHo() + "," + map.getValue());
            }
            if (map.getKey() instanceof Villa) {
                str.add(((Villa) map.getKey()).getInfoVl() + "," + map.getValue());
            }
        }
        writeFile(str, filePath, true);
    }

    public static Map<Facility, Integer> readFici(String filePath) {
        List<String> str = readFile(filePath);
        Map<Facility, Integer> map = new LinkedHashMap<>();
        for (String string : str) {
            String[] temp;
            temp = string.split(",");
            switch (temp.length) {
                case 7:
                    Facility facility = new Room(temp[0], Double.parseDouble(temp[1]),
                            Double.parseDouble(temp[2]), Integer.parseInt(temp[3]), temp[4],
                            temp[5]);
                    map.put(facility, Integer.parseInt(temp[6]));

                    break;
                case 8:
                    Facility facility1 = new House(temp[0], Double.parseDouble(temp[1]),
                            Double.parseDouble(temp[2]), Integer.parseInt(temp[3]), temp[4],
                            temp[5], Integer.parseInt(temp[6]));
                    map.put(facility1, Integer.parseInt(temp[7]));
                    break;
                case 9:
                    Facility facility2 = new Villa(temp[0], Double.parseDouble(temp[1]),
                            Double.parseDouble(temp[2]), Integer.parseInt(temp[3]), temp[4], temp[5],
                            Double.parseDouble(temp[6]), Integer.parseInt(temp[7]));
                    map.put(facility2, Integer.parseInt(temp[8]));
                    break;
                default:
                    throw new IllegalStateException("Lỗi: " + string.length());
            }
        }
        return map;
    }


    public static String themTieuChuan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tiêu chuẩn của phòng");
        String tieuChuan = scanner.nextLine();
        return tieuChuan;
    }

    public static double themHoBoi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập diện tích hồ bơi");
        double hoBoi = Double.parseDouble(scanner.nextLine());
        return hoBoi;
    }

    public static int themTang() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tầng");
        int tang = Integer.parseInt(scanner.nextLine());
        return tang;
    }

    public static String themDV() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Thêm dịch vụ miễn phí");
        String dv = scanner.nextLine();
        return dv;
    }

    public void displayMaintenance() {
        facilityList.putAll(mapHO);
        facilityList.putAll(mapRO);
        facilityList.putAll(mapVL);
        for (Map.Entry<Facility, Integer> duyetMap : facilityList.entrySet()) {
            if (duyetMap.getValue() >= 5) {
                System.out.printf("Dịch vụ cần bảo trì: " + duyetMap.getKey().toString() + "\n");
            }
        }
    }

    @Override
    public void hienThi() {
        facilityList.putAll(mapHO);
        facilityList.putAll(mapRO);
        facilityList.putAll(mapVL);
        for (Map.Entry<Facility, Integer> duyetMap : facilityList.entrySet()) {
            System.out.println(duyetMap.toString());
        }
    }


    @Override
    public void them() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chọn hạng mục cần thêm: \n1:Room,\n" +
                " 2: House,\n" +
                " 3: Villa");
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập loại phòng");
        String serviceName = scanner.nextLine();
        System.out.println("Diện tích sử dụng");
        double usingArea = Double.valueOf(scanner.nextLine());
        System.out.println("Nhập chi phí thuê");
        double costRent = Double.valueOf(scanner.nextLine());
        System.out.println("Nhập số lượng người ở");
        int personNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập kiểu thuê");
        String typeOfRent = scanner.nextLine();
        switch (choice) {
            case 1:
                Facility room = new Room(serviceName, usingArea, costRent, personNumber,
                        typeOfRent, themDV());
                fileRo.delete();
                mapRO.put(room, 0);
                writeFici(mapRO, RO_PATH, true);
                break;
            case 2:
                Facility facility2 = new House(serviceName, usingArea, costRent, personNumber,
                        typeOfRent, themTieuChuan(), themTang());
                fileHo.delete();
                mapHO.put(facility2, 0);
                writeFici(mapHO, HO_PATH, true);
                break;
            case 3:
                Facility facility3 = new Villa(serviceName, usingArea, costRent, personNumber,
                        typeOfRent, themTieuChuan(), themHoBoi(), themTang());
                fileVl.delete();
                mapVL.put(facility3, 0);
                writeFici(mapVL, VL_PATH, true);
                break;
        }
    }

    @Override
    public void sua() {

    }
}
