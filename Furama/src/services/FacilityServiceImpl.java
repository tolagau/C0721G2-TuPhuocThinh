package services;

import utils.Regex;
import utils.WrongFormatException;
import models.*;

import java.io.File;
import java.lang.reflect.Field;
import java.util.*;

import static utils.ReadAndWrite.readFile;
import static utils.ReadAndWrite.writeFile;
import static utils.Regex.*;

public class FacilityServiceImpl extends Facility implements IService {
    public static final String FACILITY_PATH = "src\\data\\facility.csv";
    private static final String REGEX_ID = "^SV(VL|HO|RO)\\d{4}$";
    private static final String REGEX_NAME = "^[A-Z](\\w+\\s?)*$";
    private static final String REGEX_AREA = "^([3-9][1-9]|[1-9]\\d{2,}).?\\d*$";
    private static final String REGEX_INT = "^[1-9]|[1][0-9]+$";
    private static final String REGEX_PERSON = "^[1-9]|[1][0-9]$";
    private static final String REGEX_CHOICE = "^[1-3]$";
    File file = new File(FACILITY_PATH);
    Map<Facility, Integer> facilityList = readFici(FACILITY_PATH);
    static Scanner scanner = new Scanner(System.in);


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
                    Facility facility = new Room(temp[0], temp[1], Double.parseDouble(temp[2]),
                            Double.parseDouble(temp[3]), Integer.parseInt(temp[4]), temp[5],
                            temp[6]);
                    map.put(facility, Integer.parseInt(temp[7]));

                    break;
                case 8:
                    Facility facility1 = new House(temp[0], temp[1], Double.parseDouble(temp[2]),
                            Double.parseDouble(temp[3]), Integer.parseInt(temp[4]), temp[5],
                            temp[6], Integer.parseInt(temp[7]));
                    map.put(facility1, Integer.parseInt(temp[8]));
                    break;
                case 9:
                    Facility facility2 = new Villa(temp[0], temp[1], Double.parseDouble(temp[2]),
                            Double.parseDouble(temp[3]), Integer.parseInt(temp[4]), temp[5], temp[6],
                            Double.parseDouble(temp[7]), Integer.parseInt(temp[8]));
                    map.put(facility2, Integer.parseInt(temp[9]));
                    break;
                default:
                    throw new IllegalStateException("Lỗi: " + string.length());
            }
        }
        return map;
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
        for (Map.Entry<Facility, Integer> map : facilityList.entrySet()) {
            System.out.println(map.getKey().toString() + "," + map.getValue());
        }
    }

    @Override
    public void them() {
        System.out.println("Thêm loại phòng facility: " +
                " 1:Room,\n" +
                " 2: House,\n" +
                " 3: Villa");
        int choice = Integer.parseInt(inputChoice());
        switch (choice) {
            case 1:
                Facility facility1 = new Room(inputId(), inputServiceName(), Double.parseDouble(inputArea()),
                        Double.parseDouble(inputCostRent()), Integer.parseInt(inputPersonNumber()),
                        inputTypeRent(), inputFreeService());
                file.delete();
                facilityList.put(facility1, 0);
                writeFici(facilityList, FACILITY_PATH, true);
                break;
            case 2:
                Facility facility2 = new House(inputId(), inputServiceName(), Double.parseDouble(inputArea()),
                        Double.parseDouble(inputCostRent()), Integer.parseInt(inputPersonNumber()),
                        inputTypeRent(), inputStandard(), Integer.parseInt(inputFloor()));
                file.delete();
                facilityList.put(facility2, 0);
                writeFici(facilityList, FACILITY_PATH, true);
                break;
            case 3:
                Facility facility3 = new Villa(inputId(), inputServiceName(), Double.parseDouble(inputArea()),
                        Double.parseDouble(inputCostRent()), Integer.parseInt(inputPersonNumber()),
                        inputTypeRent(), inputStandard(), Double.parseDouble(inputPoolArea()), Integer.parseInt(inputFloor()));
                file.delete();
                facilityList.put(facility3, 0);
                writeFici(facilityList, FACILITY_PATH, true);
        }
    }
    private String inputChoice() {
        System.out.println("Enter choice: ");
        String choice = scanner.nextLine();
        return checkRegex(choice, REGEX_CHOICE, "Only input 1 or 2 or 3");
    }

    private String inputId() {
        System.out.println("Enter id: ");
        String id = scanner.nextLine();
        return checkRegex(id, REGEX_ID, "Wrong format, please input like: SVVL1001");
    }

    private String inputServiceName() {
        System.out.println("Enter Service name: ");
        String serviceName = scanner.nextLine();
        return checkRegex(serviceName, REGEX_NAME, "Wrong format, first word is capital");
    }

    private String inputArea() {
        System.out.println("Enter area ");
        String area = scanner.nextLine();
        return checkRegex(area, REGEX_AREA, "Area >30");
    }

    private String inputPersonNumber() {
        System.out.println("Enter person number ");
        String personNumber = scanner.nextLine();
        return checkRegex(personNumber, REGEX_PERSON, "Area have to better than 20");
    }

    private String inputCostRent() {
        System.out.println("Enter cost rent ");
        String costRent = scanner.nextLine();
        return checkRegex(costRent, REGEX_INT, "Cost rent  have to positive");
    }

    private String inputTypeRent() {
        System.out.println("Enter cost type of rent ");
        String typeOfRent = scanner.nextLine();
        return checkRegex(typeOfRent, REGEX_NAME, "Wrong format, first word is capital");
    }

    private String inputStandard() {
        System.out.println("Enter add Standard: ");
        String standard = scanner.nextLine();
        return checkRegex(standard, REGEX_NAME, "Wrong format, first word is capital");
    }

    private String inputPoolArea() {
        System.out.println("Enter pool area: ");
        String poolArea = scanner.nextLine();
        return checkRegex(poolArea, REGEX_AREA, "Area >30");
    }

    private String inputFloor() {
        System.out.println("Enter number of floor: ");
        String numberOfFloor = scanner.nextLine();
        return checkRegex(numberOfFloor, REGEX_PERSON, " Number of floor have to positive");
    }

    public String inputFreeService() {
        System.out.println("Enter free service: ");
        String freeService = scanner.nextLine();
        return checkRegex(freeService, REGEX_NAME, "Wrong format, first word is capital");
    }

    @Override
    public void sua() {

    }
}
