package thang.t2009m1.t2009m1java.entity;

public class Account {
    private int id;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phone;
    private int status;
    private String birthday;


    public Account(int id, String username, String password, String fullName, String email, String phone, int status, String birthday) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.birthday = birthday;
    }

    public Account() {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String setUsername(String username) {
        this.username = username;
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String setPassword(String password) {
        this.password = password;
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String setFullName(String fullName) {
        this.fullName = fullName;
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String setEmail(String email) {
        this.email = email;
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String setPhone(String phone) {
        this.phone = phone;
        return phone;
    }

    public int getStatus() {
        return status;
    }

    public int setStatus(int status) {
        this.status = status;
        return status;
    }

    public String getBirthday() {
        return birthday;
    }

    public String setBirthday(String birthday) {
        this.birthday = birthday;
        return birthday;
    }
}
