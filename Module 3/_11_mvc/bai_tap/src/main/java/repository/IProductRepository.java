package repository;

import bean.Product;

import java.util.List;

public interface IProductRepository {
    void save(int id, Product customer);

    void update(int id, Product product);

    void remove(int id);

    Product findById(int id);

    Product findByName(int name);

    List<Product> findAll();
}
