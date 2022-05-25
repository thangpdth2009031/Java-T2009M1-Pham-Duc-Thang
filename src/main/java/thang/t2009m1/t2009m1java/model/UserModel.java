package thang.t2009m1.t2009m1java.model;

import thang.t2009m1.t2009m1java.entity.User;

import java.util.List;

public interface UserModel {
    boolean save(User user);
    boolean update(int id, User userUpdate);
    boolean delete(int id);
    List<User> findAll();
    User findById(int id);
}
