package _02_loop_java.exercise;

public class Display20IsPrime {
    public static void main(String[] args) {
        int cout = 0;
        int n = 2;
        String temp = "";
        while (cout < 20) {
            boolean flag = true;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                temp += n + ",";
                cout++;
            }
            n++;
        }
        System.out.printf("CÁc số nguyên tố là: " + temp);
    }
}
