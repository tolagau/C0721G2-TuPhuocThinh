package services;

import models.Booking;
import models.Contract;
import models.Customer;
import models.Employee;

import java.io.File;
import java.util.*;

import static services.BookingServiceImpl.BOOKING_PATH;
import static services.BookingServiceImpl.readBook;
import static services.CustomerServiceImpl.CUSTUMER_PATH;
import static services.CustomerServiceImpl.readCus;
import static utils.ReadAndWrite.readFile;
import static utils.ReadAndWrite.writeFile;

public class ContactServiceImpl implements IService {
    static final String CONTRACT_PATH = "src\\data\\contract.csv";
    List<Contract> contracts = readCon(CONTRACT_PATH);

    public static void writeCon(List<Contract> contracts, String filePath, boolean append) {
        List<String> str = new ArrayList<>();
        for (Contract listStr : contracts) {
            str.add(listStr.getIFCon());
        }
        writeFile(str, CONTRACT_PATH, true);
    }

    public static List<Contract> readCon(String filePath) {
        List<String> str = readFile(CONTRACT_PATH);
        List<Contract> contractList = new ArrayList<>();
        for (String listStr : str) {
            List<Customer> customer = readCus(CUSTUMER_PATH);
            String[] temp = listStr.split(",");
            Contract contract = new Contract(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Double.parseDouble(temp[2]), Double.parseDouble(temp[3]),
                    Integer.parseInt(temp[4]));
            contractList.add(contract);
        }
        return contractList;
    }

    @Override
    public void hienThi() {
        for (Contract contracts : contracts) {
            System.out.println(contracts.toString());
        }
    }

    @Override
    public void them() {
        Scanner scanner = new Scanner(System.in);
        CustomerServiceImpl displayCus = new CustomerServiceImpl();
        displayCus.hienThi();
        Queue<Booking> newListBooking = new ArrayDeque<>();
        Set<Booking> bookingList = readBook(BOOKING_PATH);
        newListBooking.addAll(bookingList);
        while (newListBooking.size() > 0) {
            if (newListBooking.peek().getFacility().equals("Room")) {
                newListBooking.poll();
            } else {
                System.out.println(newListBooking.peek());
                System.out.println("Enter id contract");
                int idContract = Integer.parseInt(scanner.nextLine());
                int idBooking = newListBooking.peek().getMaBKing();
                System.out.println("Enter deposit");
                double deposit = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter total pay");
                double totalPay = Double.parseDouble(scanner.nextLine());
                int idCustomer = newListBooking.poll().getCustomer().getMa();
                Contract contract = new Contract(idContract, idBooking, deposit, totalPay, idCustomer);
                File file = new File(CONTRACT_PATH);
                contracts.add(contract);
                file.delete();
                writeCon(contracts, CONTRACT_PATH, true);
            }
        }
    }

    @Override
    public void sua() {
        Scanner scanner = new Scanner(System.in);
        List< Contract > contractList = readCon(CONTRACT_PATH);
        boolean flag = true;
        System.out.println("Enter id name of edit contract");
        int editId = Integer.parseInt(scanner.nextLine());
        for (Contract contracts : contractList) {
            if (contracts.getmHD() == editId) {
                System.out.println("Enter new id contract");
                int idContract = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter new id booking");
                int idBooking = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter new deposit");
                double deposit = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter new total pay");
                double totalPay = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter new id customer");
                int idCustomer = Integer.parseInt(scanner.nextLine());
                contracts.setmHD(idContract);
                contracts.setMaBKing(idBooking);
                contracts.setDeposit(deposit);
                contracts.setTotalPay(totalPay);
                contracts.setIdCostumer(idCustomer);
                contracts.toString();
                break;
            } else {
                flag = false;
            }
        }
        if (!flag) {
            System.out.println("Not find contract");
        }

    }
}
//
//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//               NGƯỜI CHƠI HỆ TÂM LINH         NÓI KHÔNG VỚI BUG
//