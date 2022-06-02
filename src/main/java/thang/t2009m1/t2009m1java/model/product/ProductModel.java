package thang.t2009m1.t2009m1java.model.product;

import thang.t2009m1.t2009m1java.entity.Product;

import java.util.List;

public interface ProductModel {
    boolean save(Product product);
    boolean update(int id, Product productUpdate);
    boolean delete(int id);
    List<Product> findAll();
    Product findById(int id);
}
