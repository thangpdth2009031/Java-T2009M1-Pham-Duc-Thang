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
    private int roleId;//1.user - 2. admin
    private AccountStatus status;
    private LocalDate birthday;
    private String confirmPassword;

    private HashMap<String, String> errors = new HashMap<>();

    public Account(int id, String username, String passwordHash, String fullName, AccountStatus of) {
    }

    public Account(String username, String email, String password, String fullName, String phone, int status, String birthday) {
    }

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
//        if (phone == null || phone.length() == 0) {
//            errors.put("phone", "Please enter phone");
//        }
//        if (phone != null && phone.length() > 0 && !checkValidPhone(phone)) {
//            errors.put("phoneValid", "Phone number is not in the correct format");
//        }
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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

    public Account(int id, String username, String password, String fullName, String email, String phone, int roleId, AccountStatus status, LocalDate birthday, String confirmPassword, HashMap<String, String> errors) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.roleId = roleId;
        this.status = status;
        this.birthday = birthday;
        this.confirmPassword = confirmPassword;
        this.errors = errors;
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

    public static final class AccountBuilder {
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private LocalDateTime deletedAt;
        private int createdBy;
        private int updatedBy;
        private int deletedBy;
        private int id;
        private String username = "";
        private String password;
        private String fullName = "";
        private String email = "";
        private String phone = "";
        private int roleId;//1.user - 2. admin
        private AccountStatus status;
        private LocalDate birthday;
        private String confirmPassword;
        private HashMap<String, String> errors = new HashMap<>();

        private AccountBuilder() {
        }

        public static AccountBuilder anAccount() {
            return new AccountBuilder();
        }

        public AccountBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AccountBuilder withUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public AccountBuilder withDeletedAt(LocalDateTime deletedAt) {
            this.deletedAt = deletedAt;
            return this;
        }

        public AccountBuilder withCreatedBy(int createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public AccountBuilder withUpdatedBy(int updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        public AccountBuilder withDeletedBy(int deletedBy) {
            this.deletedBy = deletedBy;
            return this;
        }

        public AccountBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public AccountBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public AccountBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public AccountBuilder withFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public AccountBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public AccountBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public AccountBuilder withRoleId(int roleId) {
            this.roleId = roleId;
            return this;
        }

        public AccountBuilder withStatus(AccountStatus status) {
            this.status = status;
            return this;
        }

        public AccountBuilder withBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public AccountBuilder withConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
            return this;
        }

        public AccountBuilder withErrors(HashMap<String, String> errors) {
            this.errors = errors;
            return this;
        }

        public Account build() {
            Account account = new Account();
            account.setCreatedAt(createdAt);
            account.setUpdatedAt(updatedAt);
            account.setDeletedAt(deletedAt);
            account.setCreatedBy(createdBy);
            account.setUpdatedBy(updatedBy);
            account.setDeletedBy(deletedBy);
            account.setId(id);
            account.setUsername(username);
            account.setPassword(password);
            account.setFullName(fullName);
            account.setEmail(email);
            account.setPhone(phone);
            account.setRoleId(roleId);
            account.setStatus(status);
            account.setBirthday(birthday);
            account.setConfirmPassword(confirmPassword);
            account.setErrors(errors);
            return account;
        }
    }
}
