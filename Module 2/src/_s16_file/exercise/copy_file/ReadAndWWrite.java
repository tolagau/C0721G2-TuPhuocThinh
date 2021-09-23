package _s16_file.exercise.copy_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWWrite {
    public List<String> readFile(String filePath) {
        List<String> str = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists())
                throw new FileNotFoundException();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
               // BufferedWriter.write
            }
        } catch (Exception e) {
            System.out.println("Chương trình đang bị lỗi gì đó");
        }
        return str;
    }

}
