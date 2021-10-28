package service.impl;

import bean.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {

    private IProductRepository iProductRepository = new ProductRepository();




    @Override
    public void save(int id, Product product) {
        this.iProductRepository.save(id,product);
    }

    @Override
    public void update(int id, Product product) {
        this.iProductRepository.update(id,product);
    }

    @Override
    public void remove(int id) {
        this.iProductRepository.remove(id);
    }

    @Override
    public Product findById(int id) {
        return this.iProductRepository.findById(id);
    }

    @Override
    public Product findByName(int name) {
        return this.iProductRepository.findByName(name);
    }

    @Override
    public List<Product> findAll() {
        return this.iProductRepository.findAll();
    }
}
