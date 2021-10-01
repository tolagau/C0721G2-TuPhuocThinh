package _s22_behavioral_design_pattern.practice.class_strategy;

import java.util.List;

public class MergeSort implements ISortStrategy {

    @Override
    public <T> void sort(List<T> items) {
        System.out.println("Merge sort");
    }
}