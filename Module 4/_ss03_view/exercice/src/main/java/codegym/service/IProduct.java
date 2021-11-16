package codegym.service;

import codegym.model.Product;

import java.util.List;

public interface IProduct {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product customer);

    void remove(int id);
}
