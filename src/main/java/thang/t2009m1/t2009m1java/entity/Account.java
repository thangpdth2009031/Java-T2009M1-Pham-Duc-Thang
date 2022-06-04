package thang.t2009m1.t2009m1java.entity;

import thang.t2009m1.t2009m1java.base.BaseEntity;
import thang.t2009m1.t2009m1java.controller.myenum.AccountStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

import static thang.t2009m1.t2009m1java.util.StringValidationHelper.checkValidEmail;
import static thang.t2009m1.t2009m1java.util.StringValidationHelper.checkValidPhone;

public class Account extends BaseEntity {
    private int id;
    private String username = "";
    private String password;
    private String fullName = "";
    private String email = "";
    private String phone = "";
    private AccountStatus status;
    private LocalDate birthday;
    private String confirmPassword;

    private HashMap<String, String> errors = new HashMap<>();
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }

    public boolean isValid() {
        checkValid();
        return errors.size() == 0;
    }

    private void checkValid() {
        if (username == null || username.length() == 0) {
            errors.put("username", "Please enter username");
        }
        if (password == null || password.length() == 0) {
            errors.put("password", "Please enter password");
        }
        if (password != null && password.length() > 0 && !password.equals(confirmPassword)) {
            errors.put("confirmPassword", "Confirm password is not match.");
        }
        if (confirmPassword == null || confirmPassword.length() == 0) {
            errors.put("confirmPwdNull", "Please enter confirm password.");
        }
        if (phone == null || phone.length() == 0) {
            errors.put("phone", "Please enter phone");
        }
        if (phone != null && phone.length() > 0 && !checkValidPhone(phone)) {
            errors.put("phoneValid", "Phone number is not in the correct format");
        }
        if (email == null || email.length() == 0) {
            errors.put("email", "Please enter email");
        }
        if (email != null && email.length() > 0 && !checkValidEmail(email)) {
            errors.put("emailValid", "Email is not in the correct format");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Account() {
    }

    public Account(int id, String username, String email, String password, String fullName, String phone, int status, String birthday) {
    }

    public Account(int id, String username, String password, String fullName, String email, String phone, AccountStatus status, LocalDate birthday) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.birthday = birthday;
    }

    public Account(LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, int createdBy, int updatedBy, int deletedBy, int id, String username, String password, String fullName, String email, String phone, AccountStatus status, LocalDate birthday) {
        super(createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy);
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", birthday=" + birthday +
                '}';
    }
}
