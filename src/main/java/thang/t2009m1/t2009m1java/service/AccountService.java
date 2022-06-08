package thang.t2009m1.t2009m1java.service;

import thang.t2009m1.t2009m1java.entity.Account;
import thang.t2009m1.t2009m1java.model.AccountModel;
import thang.t2009m1.t2009m1java.model.MySqlAccountModel;
import thang.t2009m1.t2009m1java.util.SHA512Hasher;

public class AccountService {
    private AccountModel accountModel;

    public AccountService() {
        this.accountModel = new MySqlAccountModel();
    }

    public Account register(Account account) {
        String salt = SHA512Hasher.randomString(7);
        //hash Password
        String passwordHash = SHA512Hasher.encode(account.getPassword(), salt);
        account.setPassword(passwordHash + "." + salt);//Them muoi vao password
        accountModel.save(account);
        return account;
    }

    public Account login(String username, String password){
        Account account = accountModel.findByUsername(username);
        if (account != null && SHA512Hasher.checkPassword(account.getPassword(), password)) {
            return account;
        }
        return null;
    }
}
