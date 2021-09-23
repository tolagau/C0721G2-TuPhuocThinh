package _s16_file.practice.find_max_value;

import java.util.List;

public class FindMaxValue {
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("src\\_s16_file\\practice\\find_max_value\\numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("src\\_s16_file\\practice\\find_max_value\\result.txt", maxValue);
    }
}
