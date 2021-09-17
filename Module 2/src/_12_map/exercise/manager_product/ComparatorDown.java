package _12_map.exercise.manager_product;

import java.util.Comparator;

public class ComparatorDown implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getTienSP() - o1.getTienSP();
    }
}
