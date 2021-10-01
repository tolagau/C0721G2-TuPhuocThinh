package _s22_behavioral_design_pattern.practice.class_strategy;

import java.util.List;

public interface ISortStrategy {
    <T> void sort(List<T> items);
}
