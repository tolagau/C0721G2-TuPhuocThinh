package _s21_structural_design_pattern.practice.class_adapter;

public class Client {
    private FileCalculator fileCalculator;

    public Client(FileCalculator fileCalculator) {
        this.fileCalculator = fileCalculator;
    }

    public void printFileSize(String path){
        long size = fileCalculator.calculateSize(path);
        System.out.println("Size: " + size);
    }
}
