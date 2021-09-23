package _s16_file.exercise.copy_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWWrite {
    public List<String> readFile(String filePath1, String filePath2) {
        List<String> str = new ArrayList<>();
        try {
            File file = new File(filePath1);
            File file1 = new File(filePath2);
            if (!file.exists())
                throw new FileNotFoundException();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            BufferedWriter brwrite = new BufferedWriter(new FileWriter(file1,true));
            String line = "";
            int count = 0;
            while ((line = bufferedReader.readLine()) != null) {
               // System.out.println(line);
                brwrite.write(line);
                for (int i = 0; i<line.length();i++){
                    count++;
                }
                System.out.println(count);
            }
            bufferedReader.close();
            brwrite.close();
        } catch (Exception e) {
            System.out.println("Chương trình đang bị lỗi gì đó");
        }
        return str;
    }
}
