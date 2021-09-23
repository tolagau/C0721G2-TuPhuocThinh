package _s16_file.exercise.copy_file;

import _s16_file.practice.find_max_value.ReadAndWriteFile;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadAndWWrite readAndWriteFile = new ReadAndWWrite();
        readAndWriteFile.readFile("src\\_s16_file\\exercise\\copy_file\\read.txt","src\\_s16_file\\exercise\\copy_file\\write.txt");

    }
}
