package services;

import models.*;
import utils.BookingComparator;

import java.io.File;
import java.util.*;

import static services.CustomerServiceImpl.CUSTUMER_PATH;
import static services.CustomerServiceImpl.readCus;
import static services.FacilityServiceImpl.*;
import static utils.ReadAndWrite.readFile;
import static utils.ReadAndWrite.writeFile;

public class BookingServiceImpl implements IService {

    private static TreeSet<Booking> listBook = new TreeSet<>(new BookingComparator());
     static final String BOOKING_PATH = "src\\data\\booking.csv";

    public static void writeBook(TreeSet<Booking> bookings, String filePath, boolean append) {
        List<String> str = new ArrayList<>();
        for (Booking booking : listBook) {
            str.add(booking.getIFBook());
        }
        writeFile(str, BOOKING_PATH, true);
    }

    public static TreeSet<Booking> readBook(String filePath) {
        List<String> str = readFile(filePath);
        TreeSet<Booking> treeSet = new TreeSet<>(new BookingComparator());
        for (String string : str) {
            List<Customer> customer = readCus(CUSTUMER_PATH);
            String[] temp = string.split(",");
            Customer customer1 = new Customer();
            for (Customer cus : customer) {
                if (cus.getMa() == Integer.parseInt(temp[3])) {
                    customer1 = cus;
                }
            }
            Map<Facility, Integer> facilityList = new LinkedHashMap<>();
            Map<Facility, Integer> mapRO = readFici(RO_PATH);
            Map<Facility, Integer> mapHO = readFici(HO_PATH);
            Map<Facility, Integer> mapVL = readFici(VL_PATH);
            facilityList.putAll(mapHO);
            facilityList.putAll(mapRO);
            facilityList.putAll(mapVL);
            Facility facility = null;
            for (Map.Entry<Facility, Integer> mapFaci : facilityList.entrySet()) {
                if (mapFaci.getKey().getTenDV().equals(temp[4])) {
                    facility = mapFaci.getKey();
                }
            }
            Booking booking = new Booking(Integer.parseInt(temp[0]), temp[1], temp[2],
                    customer1, facility, temp[5]);
            treeSet.add(booking);
        }

        return treeSet;
    }

    @Override
    public void hienThi() {
        listBook = readBook(BOOKING_PATH);
        for (Booking booking : listBook) {
            System.out.println(booking.toString());
        }
    }

    @Override
    public void them() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        List<Customer> listCustomer = readCus("src\\data\\customer.csv");
        customerService.hienThi();
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        Map<Facility, Integer> facilityList = new LinkedHashMap<>();
        Map<Facility, Integer> mapRO = readFici(RO_PATH);
        Map<Facility, Integer> mapHO = readFici(HO_PATH);
        Map<Facility, Integer> mapVL = readFici(VL_PATH);
        facilityList.putAll(mapHO);
        facilityList.putAll(mapRO);
        facilityList.putAll(mapVL);
        facilityService.hienThi();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Thêm mới Booking");
        System.out.println("--------------------");
        System.out.println("Nhập mã booking");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập ngày bắt đầu booking");
        String bd = scanner.nextLine();
        System.out.println("Nhập ngày kết thúc booking");
        String kt = scanner.nextLine();
        System.out.println("Nhập mã khách hàng booking");
        int idCus = Integer.parseInt(scanner.nextLine());
        Customer customer1 = new Customer();
        for (Customer cus1 : listCustomer) {
            if (cus1.getMa() == idCus) {
                customer1 = cus1;
            }
        }
        System.out.println("Mời nhập loại phòng booking");
        String dv = scanner.nextLine();
        Facility facility = null;
        for (Map.Entry<Facility, Integer> mapFaci : facilityList.entrySet()) {
            if (mapFaci.getKey().getTenDV().equals(dv)) {
                facility = mapFaci.getKey();

            }
        }
        System.out.println("Mời nhập loại dịch vụ đi kèm booking");
        String loaiDv = scanner.nextLine();
        Booking booking = new Booking(id, bd, kt, customer1, facility, loaiDv);
        listBook.add(booking);
        writeBook(listBook,BOOKING_PATH,true);
        hienThi();
    }
    public static void tangValue(Facility facility){
        Map<Facility, Integer> facilityList = new LinkedHashMap<>();
        Map<Facility, Integer> mapRO = readFici(RO_PATH);
        Map<Facility, Integer> mapHO = readFici(HO_PATH);
        Map<Facility, Integer> mapVL = readFici(VL_PATH);
        facilityList.putAll(mapHO);
        facilityList.putAll(mapRO);
        facilityList.putAll(mapVL);
        for (Facility key : facilityList.keySet()) {
            if(key instanceof Villa){
                facilityList.put(key,((Integer)(facilityList.get(key))+1));
            } else if(key instanceof House){
                facilityList.put(key,((Integer)(facilityList.get(key))+1));
            }else if(key instanceof Room){
                facilityList.put(key,((Integer)(facilityList.get(key))+1));
            }
        }
    }
    @Override
    public void sua() {
    }
}
