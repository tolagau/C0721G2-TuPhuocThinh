package case_study.services;

import case_study.models.Facility;
import case_study.models.House;
import case_study.models.Room;
import case_study.models.Villa;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl extends Facility implements IService {
    private static Map<Facility, Integer> facilityList = new LinkedHashMap<>();

    static {
        Facility facility1 = new Room("Room", 20.00, 10000000.00, 2, "Day", "Pool");
        Facility facility2 = new Room("Room", 20.00, 10000000.00, 2, "Day", "Pool");
        Facility facility3 = new House("House", 50.00, 10000000.00, 6, "Day", "Double", 2);
        Facility facility4 = new House("House", 50.00, 10000000.00, 6, "Day", "Double", 2);
        Facility facility5 = new Villa("Villa", 100.00, 10000000.00, 10, "Day", "Double", 50.00, 3);
        Facility facility6 = new Villa("Villa", 100.00, 10000000.00, 10, "Day", "Double", 50.00, 3);
        facilityList.put(facility1, 1);
        facilityList.put(facility2, 1);
        facilityList.put(facility3, 1);
        facilityList.put(facility4, 1);
        facilityList.put(facility5, 1);
        facilityList.put(facility6, 1);
    }
    public static String themTieuChuan(){
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
//    public static String displayMaintenance(){
//
//    }
    @Override
    public void hienThi() {
        for(Map.Entry<Facility, Integer> duyetMap: facilityList.entrySet() ){
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
                facilityList.put(facility1, 1);
                break;
            case 2:
                Facility facility2 = new House(serviceName, usingArea, costRent, personNumber,
                        typeOfRent, themTieuChuan(), themTang());
                facilityList.put(facility2, 1);
                break;
            case 3:
                Facility facility3 = new Villa(serviceName, usingArea, costRent, personNumber,
                        typeOfRent, themTieuChuan(), themHoBoi(), themTang());
                facilityList.put(facility3, 1);
        }
    }
    @Override
    public void sua() {

    }
}
