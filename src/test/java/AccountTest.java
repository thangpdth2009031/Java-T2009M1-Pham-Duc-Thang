import org.junit.jupiter.api.Test;
import thang.t2009m1.t2009m1java.entity.Account;
import thang.t2009m1.t2009m1java.util.ConnectionHelper;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountTest {


    @Test
    public void save() {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into accounts (username, password, fullName, email, phone, status, birthday) values (?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, "cuongtoi2");
            preparedStatement.setString(2, "cuongtoi2");
            preparedStatement.setString(3, "Cường tỏi cà mau1");
            preparedStatement.setString(4, "cuongtoi@gmail.com1");
            preparedStatement.setString(5, "09886756751");
            preparedStatement.setInt(6, 1);
            preparedStatement.setDate(7, java.sql.Date.valueOf(java.time.LocalDate.now()));
            preparedStatement.execute();
            System.out.println("success");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void update() {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update accounts set username = ?, password = ?, fullName = ?, email = ?, phone = ?, status = ?, birthday = ? where id = ?");
            preparedStatement.setString(1, "cuongtoiUpdate");
            preparedStatement.setString(2, "cuongtoiUpdate");
            preparedStatement.setString(3, "Cường tỏi cà mau update");
            preparedStatement.setString(4, "cuongtoiupdate@gmail.com");
            preparedStatement.setString(5, "098767767889");
            preparedStatement.setInt(6, 2);
            preparedStatement.setDate(7, java.sql.Date.valueOf(java.time.LocalDate.now()));
            preparedStatement.setInt(8, 1);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void delete() {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update accounts set status = ? where id = ?");
            preparedStatement.setInt(1, -1);
            preparedStatement.setInt(2, 2);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void findAll() {
        Connection connection = ConnectionHelper.getConnection();
        List<Account> accounts = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from accounts");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                String phone = resultSet.getString("phone");
                String birthday = resultSet.getString("birthday");
//                LocalDate birthdayLocal = LocalDate.parse(birthday);
                int status = resultSet.getInt("status");
                Account account = new Account(id, username, email, password, fullName, phone, status,birthday);
                accounts.add(account);
                System.out.println(account.toString());
            }
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void findById() {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from accounts where id = ?");
            preparedStatement.setInt(1,2);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                String phone = resultSet.getString("phone");
                String birthday = resultSet.getString("birthday");
                LocalDate birthdayLocal = LocalDate.parse(birthday);
                int status = resultSet.getInt("status");
                Account account = new Account(id, username, email, password, fullName, phone, status,birthday);
                System.out.println(account.toString());
                return;
            }
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
