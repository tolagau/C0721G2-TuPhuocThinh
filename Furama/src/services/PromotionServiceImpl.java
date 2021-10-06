package services;

import models.Booking;
import models.Customer;

import java.util.*;

import static services.BookingServiceImpl.BOOKING_PATH;
import static services.BookingServiceImpl.readBook;

public class PromotionServiceImpl implements Promotion {
    Scanner scanner = new Scanner(System.in);
    Set<Booking> listBooking = readBook(BOOKING_PATH);

    @Override
    public void display() {
        System.out.println("Enter year used service");
        String year = scanner.nextLine();
        for (Booking list : listBooking)
            if (list.getNgayBatDau().contains(year)) {
                System.out.println(list.getCustomer().toString());
            }
    }

    @Override
    public List<Customer> presentVoucher() {
        System.out.println("Enter current month/year");
        String currentMonthYear = scanner.nextLine();
        System.out.println("Enter number of voucher 10%");
        int numberOf10 = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter number of voucher 20%");
        int numberOf20 = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter number of voucher 50%");
        int numberOf50 = Integer.parseInt(scanner.nextLine());
        Stack<Customer> customerTempList = new Stack<>();
        for (Booking list : listBooking) {
            if (list.getNgayBatDau().contains(currentMonthYear) &&
                    (customerTempList.size() <= (numberOf10 + numberOf20 + numberOf50))) {
                customerTempList.add(list.getCustomer());
            }
        }
        List<Customer> listGetVoucher = new ArrayList<>();
        while (!customerTempList.isEmpty()) {
            listGetVoucher.add(customerTempList.pop());
        }
        for (Customer customer : listGetVoucher) {
            System.out.println(customer.toString());
        }
        return listGetVoucher;
    }
}

