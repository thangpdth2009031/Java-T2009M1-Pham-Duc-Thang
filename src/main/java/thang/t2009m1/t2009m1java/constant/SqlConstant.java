package thang.t2009m1.t2009m1java.constant;

public class SqlConstant {
    public static final String ACCOUNT_INSERT = "INSERT INTO accounts (username, password, fullName, email, phone, birthday, createdAt, updatedAt, createdBy, updatedBy, status) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String PRODUCT_INSERT = "INSERT INTO products (name, description, detail, price, thumbnail, manufacture_email, manufacture_phone, created_at, updated_at, created_by, updated_by, status) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_PRODUCT = "SELECT * FROM products WHERE status = ?;";
}
