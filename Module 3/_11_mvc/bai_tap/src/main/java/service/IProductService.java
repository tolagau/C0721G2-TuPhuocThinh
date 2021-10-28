package service;

import bean.Product;

import java.util.List;

public interface IProductService {
    void save(int id, Product customer);

    void update(int id, Product product);

    void remove(int id);

    Product findById(int id);

    Product findByName(int name);

    List<Product> findAll();
}
