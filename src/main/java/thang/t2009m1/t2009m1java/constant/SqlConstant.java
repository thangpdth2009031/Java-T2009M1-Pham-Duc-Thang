package thang.t2009m1.t2009m1java.constant;

public class SqlConstant {
    public static final String ACCOUNT_INSERT = "INSERT INTO accounts (username, password, fullName, email, phone, birthday, createdAt, updatedAt, createdBy, updatedBy, status) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String PRODUCT_INSERT = "INSERT INTO products (name, description, detail, price, thumbnail, manufacture_email, manufacture_phone, created_at, updated_at, created_by, updated_by, status) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_PRODUCT = "SELECT * FROM products WHERE status = ?;";
    public static final String PRODUCT_UPDATE = "UPDATE products SET name = ?, description = ?, detail = ?, price = ?, thumbnail = ?, manufactureEmail = ?, manufacturePhone = ?," +
            "createdAt = ?, updatedAt = ?, deletedAt = ?, createdBy = ?, updatedBy = ?, deletedBy = ?, status = ? WHERE id = ?;";
    public static final String PRODUCT_DELETE = "DELETE FROM products WHERE id = ?;";
    public static final String PRODUCT_FIND_BY_ID = "SELECT * FROM products WHERE id = ? AND status = ?;";

    public static final String CATEGORY_INSERT = "insert into categories (name, createdAt, updatedAt, createdBy, updatedBy, status) values (?,?,?,?,?,?)";
    public static final String CATEGORY_UPDATE = "update categories set name = ?, udpatedAt = ?, updatedBy = ?, status = ? where id = ?";
    public static final String CATEGORY_DELETE = "update categories set status = ? where id = ?";
    public static final String CATEGORY_SELECT_ALL = "select * from categories where status = ?";
    public static final String CATEGORY_SELECT_BY_ID = "select * from categories where status = ? and id = ?";


    public static final String CATEGORY_FIELD_ID = "id";
    public static final String CATEGORY_FIELD_NAME = "name";
    public static final String CATEGORY_FIELD_STATUS = "status";

    public static final String FIELD_CREATED_AT = "createdAt";
    public static final String FIELD_UPDATED_AT = "updatedAt";
    public static final String FIELD_DELETED_AT = "deletedAt";
    public static final String FIELD_CREATED_BY = "createdBy";
    public static final String FIELD_UPDATED_BY = "updatedBy";
    public static final String FIELD_DELETED_BY = "deletedBy";
}
