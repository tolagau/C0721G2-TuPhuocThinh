package _12_map.exercise.manager_product;

import java.util.Comparator;

public class ComparatorUp implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getTienSP() - o2.getTienSP();
    }
}
