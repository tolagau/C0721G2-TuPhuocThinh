package codegym.service;

import codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProduct{
    private static Map<Integer, Product> productMap;
    static {
        productMap = new HashMap<>();
        productMap.put(1,new Product(1,"Tủ lạnh",10,"Dàn lạnh độc lập","Toshiba"));
        productMap.put(2,new Product(2,"Máy lạnh",5,"Công nghệ Inveter","Electrolux"));
        productMap.put(3,new Product(3,"Sony A7",2,"Công nghệ lấy nét mới","Sony"));
        productMap.put(4,new Product(4,"Ai phôn bờ rồ mát",20,"Đắt tiền lắm","Chúa tể môi trường"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);

    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product customer) {
        productMap.put(id, customer);

    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
