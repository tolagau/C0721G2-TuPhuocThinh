package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    protected static final String CHECK_FACILITI = "^SV(VL|RO|HO)-\\\\d{4}$";
    private static final String CHECK_NAME = "^[A-Z][a-z]+\\s?([a-z]+\\s)*\\w+$";

    public static boolean checkFaci(String string) throws WrongFormatException{
        boolean checks = string.matches(CHECK_FACILITI);
        if (!checks){
            throw new WrongFormatException("Lỗi nhập liệu loại phòng");
        }
        return checks;
    }

    public static boolean checkName(String string) throws WrongFormatException{
        boolean b = string.matches(CHECK_NAME);
        if (!b){
            throw new WrongFormatException("Lỗi nhập liệu tên");
        }
        return b;
    }
    public static boolean checkDienTich(double dienTich)throws WrongFormatException{
        if (dienTich > 30)
            return true;
        else throw new WrongFormatException("Lỗi nhập liệu diện tích");
    }
    public static boolean checkConNguoi(int nguoi)throws WrongFormatException{
        if (nguoi >0 && nguoi <=20 )
            return true;
        else throw new WrongFormatException("Lỗi nhập liệu về số người trong Facilyti");
    }
    public static boolean checkTang(int tang) throws WrongFormatException {
        if (tang > 0) {
            return true;
        } else {
            throw new WrongFormatException("Lỗi nhập liệu về số tầng");
        }
    }
    public static boolean checkChiPhi(double chiPhi) throws WrongFormatException {
        if (chiPhi > 0) {
            return true;
        } else {
            throw new WrongFormatException("Lỗi nhập liệu");
        }
    }
}
