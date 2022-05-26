package thang.t2009m1.t2009m1java.model;

import thang.t2009m1.t2009m1java.entity.Account;

import java.util.List;

public interface AccountModel {
    boolean save(Account account);
    boolean update(int id, Account accountUpdate);
    boolean delete(int id);
    List<Account> findAll();
    Account findById(int id);
}
