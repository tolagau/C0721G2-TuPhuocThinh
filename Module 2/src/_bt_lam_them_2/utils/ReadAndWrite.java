package _bt_lam_them_2.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static List<String> readFile(String filePath) {
        List<String> stringList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = "";
            String[] arr = null;
            while ((line = br.readLine()) != null) {
                arr = line.split(",");
                stringList.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

    public static void writeFile(List<String> listStr, String filePath, boolean append) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String line : listStr) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
