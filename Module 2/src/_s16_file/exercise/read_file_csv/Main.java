package _s16_file.exercise.read_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Country country = new Country();
        ArrayList<Country> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập địa chỉ file");
        String filePath = scanner.nextLine();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            String line = "";
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp;
                temp = line.split(",");
                country = new Country(Integer.parseInt(temp[0]), temp[1], temp[2]);
                list.add(country);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Xuất từ file csv: ");
        for (Country countries : list) {
            System.out.println(countries.toString());
        }
    }
}

