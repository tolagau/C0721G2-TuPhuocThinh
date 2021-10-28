package repository.impl;

import bean.Product;
import repository.IProductRepository;

import java.util.*;

public class ProductRepository implements IProductRepository {
    static Map<Integer,Product> productMap = new TreeMap<>();
    static {
        productMap.put(1,new Product(1,"Iphone 13", 30000000, "512Mg", "Apple"));
        productMap.put(2,new Product(2,"Iphone 12", 25000000, "512Mg", "Apple"));
        productMap.put(4,new Product(4,"Iphone 11", 20000000, "256Mg", "Apple"));
        productMap.put(3,new Product(3,"Iphone X", 15000000, "128Mg", "Apple"));
        productMap.put(6,new Product(6,"Iphone 8", 10000000, "128Mg", "Apple"));

    }

    @Override
    public void save(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public Product findByName(int name) {
        return productMap.get(name);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }
}
