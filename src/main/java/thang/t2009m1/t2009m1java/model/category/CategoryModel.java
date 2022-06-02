package thang.t2009m1.t2009m1java.model.category;

import thang.t2009m1.t2009m1java.entity.Category;

import java.util.List;

public interface CategoryModel {
    boolean save(Category obj);
    boolean update(int id, Category updateObj);
    boolean delete(int id);
    List<Category> findAll();
    Category findById(int id);
}
