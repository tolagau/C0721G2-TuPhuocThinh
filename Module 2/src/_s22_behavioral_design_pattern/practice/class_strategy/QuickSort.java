package _s22_behavioral_design_pattern.practice.class_strategy;

import java.util.List;

public class QuickSort implements ISortStrategy {

    @Override
    public <T> void sort(List<T> items) {
        System.out.println("Quick sort");
    }
}