package thang.t2009m1.t2009m1java.entity;

import thang.t2009m1.t2009m1java.base.BaseEntity;
import thang.t2009m1.t2009m1java.myenum.ProductStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;

import static thang.t2009m1.t2009m1java.util.StringValidationHelper.checkValidEmail;
import static thang.t2009m1.t2009m1java.util.StringValidationHelper.checkValidPhone;

public class Product extends BaseEntity {
    private int id;
    private String name = "";
    private String description = "";
    private String detail = "";
    private BigDecimal price = BigDecimal.valueOf(0);
    private String thumbnail = "";
    private String manufactureEmail = "";
    private String manufacturePhone = "";
    private ProductStatus status;
    private HashMap<String, String> errors = new HashMap<>();

    public Product() {
    }

    public Product(int id, String name, String description, String detail, String price, String thumbnail, String manufactureEmail, String manufacturePhone, int status) {
    }

    public Product(int id, String name, String description, String detail, Double price, String thumbnail, String manufactureEmail, String manufacturePhone, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, int createdBy, int updatedBy, int deletedBy, ProductStatus status) {
    }

    public boolean isValid() {
        checkValid();
        return errors.size() == 0;
    }

    private void checkValid() {
        if (name == null || name.length() == 0) {
            errors.put("name", "Please enter name");
        }
        if (description == null || description.length() == 0) {
            errors.put("description", "Please enter description");
        }
        if (thumbnail == null || thumbnail.length() == 0) {
            errors.put("thumbnail", "Please enter thumbnail.");
        }
        if (manufacturePhone == null || manufacturePhone.length() == 0) {
            errors.put("phone", "Please enter manufacture phone");
        }
        if (manufacturePhone != null && manufacturePhone.length() > 0 && !checkValidPhone(manufacturePhone)) {
            errors.put("phoneValid", "Manufacture phone number is not in the correct format");
        }
        if (manufactureEmail == null || manufactureEmail.length() == 0) {
            errors.put("email", "Please enter manufacture email");
        }
        if (manufactureEmail != null && manufactureEmail.length() > 0 && !checkValidEmail(manufactureEmail)) {
            errors.put("emailValid", "Manufacture email is not in the correct format");
        }
    }
    public Product(int id, String name, String description, String detail, BigDecimal price, String thumbnail, String manufactureEmail, String manufacturePhone, ProductStatus status, HashMap<String, String> errors) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.detail = detail;
        this.price = price;
        this.thumbnail = thumbnail;
        this.manufactureEmail = manufactureEmail;
        this.manufacturePhone = manufacturePhone;
        this.status = status;
        this.errors = errors;
    }

    public Product(LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, int createdBy, int updatedBy, int deletedBy, int id, String name, String description, String detail, BigDecimal price, String thumbnail, String manufactureEmail, String manufacturePhone, ProductStatus status, HashMap<String, String> errors) {
        super(createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy);
        this.id = id;
        this.name = name;
        this.description = description;
        this.detail = detail;
        this.price = price;
        this.thumbnail = thumbnail;
        this.manufactureEmail = manufactureEmail;
        this.manufacturePhone = manufacturePhone;
        this.status = status;
        this.errors = errors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getManufactureEmail() {
        return manufactureEmail;
    }

    public void setManufactureEmail(String manufactureEmail) {
        this.manufactureEmail = manufactureEmail;
    }

    public String getManufacturePhone() {
        return manufacturePhone;
    }

    public void setManufacturePhone(String manufacturePhone) {
        this.manufacturePhone = manufacturePhone;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }
}
