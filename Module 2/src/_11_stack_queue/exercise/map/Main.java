package _11_stack_queue.exercise.map;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhập chuỗi cần đếm");
        String str = scanner.nextLine();
        str = str.toLowerCase();
        String[] arr = str.replaceAll(","," ").split(" ");
        String key;
        int value = 1;
        for (int i = 0; i < arr.length; i++) {
            key = arr[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, value);
            }
        }
        System.out.printf(String.valueOf(map));
    }
}
