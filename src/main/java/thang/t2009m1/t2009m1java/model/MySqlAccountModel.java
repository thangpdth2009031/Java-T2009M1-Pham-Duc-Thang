package thang.t2009m1.t2009m1java.model;

import thang.t2009m1.t2009m1java.constant.SqlConstant;
import thang.t2009m1.t2009m1java.entity.Account;
import thang.t2009m1.t2009m1java.util.ConnectionHelper;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MySqlAccountModel implements AccountModel{


    @Override
    public boolean save(Account obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SqlConstant.ACCOUNT_INSERT);
            preparedStatement.setString(1, obj.getUsername());
            preparedStatement.setString(2, obj.getPassword());
            preparedStatement.setString(3, obj.getFullName());
            preparedStatement.setString(4, obj.getEmail());
            preparedStatement.setString(5, obj.getPhone());
            preparedStatement.setString(6, obj.getBirthday().toString());
            preparedStatement.setString(7, obj.getCreatedAt().toString());
            preparedStatement.setString(8, obj.getUpdatedAt().toString());
            preparedStatement.setInt(9, obj.getCreatedBy());
            preparedStatement.setInt(10, obj.getUpdatedBy());
            preparedStatement.setInt(11, obj.getStatus().getValue());
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(int id, Account accountUpdate) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update accounts set username = ?, email = ?, password = ?, fullName = ?, phone = ?, birthday = ?, status = ? where id = ?");
            preparedStatement.setString(1, accountUpdate.getUsername());
            preparedStatement.setString(2, accountUpdate.getEmail());
            preparedStatement.setString(3, accountUpdate.getPassword());
            preparedStatement.setString(4, accountUpdate.getFullName());
            preparedStatement.setString(5, accountUpdate.getPhone());
            String birthday = String.valueOf(accountUpdate.getBirthday());
            LocalDate birthdayLocal = LocalDate.parse(birthday);
            preparedStatement.setDate(6, Date.valueOf(birthdayLocal));
            preparedStatement.setInt(7, accountUpdate.getStatus().getValue());
            preparedStatement.setInt(8, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update accounts set status = ? where id = ?");
            preparedStatement.setInt(1, -1);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from accounts where status = ?");
            preparedStatement.setInt(1,1);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                String phone = resultSet.getString("phone");
                int status = resultSet.getInt("status");
                String birthday = resultSet.getString("birthday");
//                LocalDate birthdayLocal = LocalDate.parse(birthday);
                Account account = new Account(id, username, email, password, fullName, phone, status, birthday);
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public Account findById(int id) {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from accounts where status = ? and id = ?");
            preparedStatement.setInt(1,1);
            preparedStatement.setInt(2,id);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                String phone = resultSet.getString("phone");
                String birthday = resultSet.getString("birthday");
              //  LocalDate birthdayLocal = LocalDate.parse(birthday);
                int status = resultSet.getInt("status");
                return new Account(id, username, email, password, fullName, phone, status, birthday);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
