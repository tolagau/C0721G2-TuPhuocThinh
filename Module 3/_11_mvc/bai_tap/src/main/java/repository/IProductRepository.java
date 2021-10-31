package repository;

import bean.Product;

import java.util.List;

public interface IProductRepository {
    void save(Product product);

    void update(int id, Product product);

    void remove(int id);

    Product findById(int id);

    List<Product> findByName(String name);

    List<Product> findAll();
}
