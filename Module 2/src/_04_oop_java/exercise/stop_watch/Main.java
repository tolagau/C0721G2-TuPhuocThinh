package _04_oop_java.exercise.stop_watch;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        watch.start();
        int[] arr = new int[100000];
        System.out.println("Creat array");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.floor(((Math.random() * 100000) + 1));
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            watch.stop();
            System.out.printf(Arrays.toString(arr) + "\n");

            System.out.println("Elapsed " + watch.getElapsedTime());
        }
    }
}
