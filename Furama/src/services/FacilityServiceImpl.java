package services;

import models.*;

import java.io.File;
import java.lang.reflect.Field;
import java.util.*;

import static utils.ReadAndWrite.readFile;
import static utils.ReadAndWrite.writeFile;

public class FacilityServiceImpl extends Facility implements IService {

    private static Map<Facility, Integer> facilityList = new LinkedHashMap<>();
    private static final String FICILATI_PATH = "src\\data\\facility.csv";
    //    static {
    //        Facility facility1 = new Room("Room", 20.00, 10000000.00, 2, "Day", "Pool");
//        Facility facility2 = new Room("Room", 20.00, 10000000.00, 2, "Day", "Pool");
//
//        Facility facility4 = new House("House1", 50.00, 10000000.00, 6, "Day", "Double", 2);
//        Facility facility5 = new Villa("Villa", 100.00, 10000000.00, 10, "Day", "Double", 50.00, 3);
//
//        facilityList.put(facility1, 1);
//        facilityList.put(facility2, 1);
//
//        facilityList.put(facility4, 5);
//        facilityList.put(facility5, 6);
//
//    }
    public static void writeFici(Map<Facility, Integer> facilityIntegerMap, String filePath, boolean append) {
        List<String> str = new ArrayList<>();
        for (Map.Entry<Facility, Integer> map : facilityList.entrySet()) {
            if (map.getKey() instanceof Room) {
                str.add(((Room) map.getKey()).getInfoRoom() + "," + map.getValue());
            } else if (map.getKey() instanceof House) {
                str.add(((House) map.getKey()).getInfoHo() + "," + map.getValue());
            } else {
                str.add(((Villa) map.getKey()).getInfoVl() + "," + map.getValue());
            }
        }
        writeFile(str, FICILATI_PATH, true);
    }

    public static Map<Facility, Integer> readFici(String filePath) {
        List<String> str = readFile(FICILATI_PATH);
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
        for (Map.Entry<Facility, Integer> duyetMap : facilityList.entrySet()) {
            if (duyetMap.getValue() >= 5) {
                System.out.printf("Dịch vụ cần bảo trì: " + duyetMap.getKey().toString() + "\n");
            }
        }
    }

    @Override
    public void hienThi() {
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
        System.out.println("Nhập loại tiền thuê");
        String typeOfRent = scanner.nextLine();
        switch (choice) {
            case 1:
                Facility facility1 = new Room(serviceName, usingArea, costRent, personNumber,
                        typeOfRent, themDV());
                facilityList.put(facility1, 0);
                break;
            case 2:
                Facility facility2 = new House(serviceName, usingArea, costRent, personNumber,
                        typeOfRent, themTieuChuan(), themTang());
                facilityList.put(facility2, 0);
                break;
            case 3:
                Facility facility3 = new Villa(serviceName, usingArea, costRent, personNumber,
                        typeOfRent, themTieuChuan(), themHoBoi(), themTang());
                facilityList.put(facility3, 0);
        }
        File file = new File(FICILATI_PATH);
        file.delete();
        writeFici(facilityList, FICILATI_PATH, true);
    }

    @Override
    public void sua() {

    }
}
