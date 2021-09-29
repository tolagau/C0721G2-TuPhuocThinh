package case_study.services;

import case_study.models.Booking;

import java.util.Scanner;
import java.util.TreeSet;

public class BookingServiceImpl implements IService {

    private static TreeSet<Booking> listBook = new TreeSet<>(new BookingComparator());

    static {
        Booking booking = new Booking(10, "15/09/2021", "20/09/2021", 1001, "Villa", "Thuê");
        Booking booking1 = new Booking(11, "01/08/2021", "20/08/2021", 1001, "Villa", "Thuê");
        Booking booking2 = new Booking(12, "04/10/2021", "11/11/2021", 1001, "Villa", "Thuê");

    }

    @Override
    public void hienThi() {
        for (Booking booking : listBook){
            System.out.println(booking.toString());
        }
    }

    @Override
    public void them() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        customerService.hienThi();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Thêm mới Booking");
        System.out.printf("--------------------");
        System.out.println("Nhập mã booking");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập ngày bắt đầu booking");
        String bd = scanner.nextLine();
        System.out.println("Nhập ngày kết thúc booking");
        String kt = scanner.nextLine();
        System.out.println("Nhập mã khách hàng booking");
        int idCus = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời nhập dịch vụ booking");
        String dv = scanner.nextLine();
        System.out.println("Mời nhập dịch vụ booking");
        String loaiDv = scanner.nextLine();
    }

    @Override
    public void sua() {

    }
}
