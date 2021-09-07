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
        Arrays.sort(arr);
        System.out.printf(Arrays.toString(arr)+"\n");
        watch.stop();
        System.out.println("Elapsed "+watch.getElapsedTime());
    }
}
