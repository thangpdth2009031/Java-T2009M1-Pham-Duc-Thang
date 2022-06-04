package thang.t2009m1.t2009m1java.entity;

import thang.t2009m1.t2009m1java.base.BaseEntity;
import thang.t2009m1.t2009m1java.controller.myenum.ProductStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;

import static thang.t2009m1.t2009m1java.util.StringValidationHelper.checkValidEmail;
import static thang.t2009m1.t2009m1java.util.StringValidationHelper.checkValidPhone;

public class Product extends BaseEntity {
    private int id;
    private int categoryId;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public Product(int id, int categoryId, String name, String description, String detail, BigDecimal price, String thumbnail, String manufactureEmail, String manufacturePhone, ProductStatus status, HashMap<String, String> errors) {
        this.id = id;
        this.categoryId = categoryId;
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

    public static final class ProductBuilder {
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private LocalDateTime deletedAt;
        private int createdBy;
        private int updatedBy;
        private int deletedBy;
        private int id;
        private int categoryId;
        private String name = "";
        private String description = "";
        private String detail = "";
        private BigDecimal price = BigDecimal.valueOf(0);
        private String thumbnail = "";
        private String manufactureEmail = "";
        private String manufacturePhone = "";
        private ProductStatus status;
        private HashMap<String, String> errors = new HashMap<>();

        private ProductBuilder() {
        }

        public static ProductBuilder aProduct() {
            return new ProductBuilder();
        }

        public ProductBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ProductBuilder withUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public ProductBuilder withDeletedAt(LocalDateTime deletedAt) {
            this.deletedAt = deletedAt;
            return this;
        }

        public ProductBuilder withCreatedBy(int createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public ProductBuilder withUpdatedBy(int updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        public ProductBuilder withDeletedBy(int deletedBy) {
            this.deletedBy = deletedBy;
            return this;
        }

        public ProductBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public ProductBuilder withCategoryId(int categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public ProductBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder withDetail(String detail) {
            this.detail = detail;
            return this;
        }

        public ProductBuilder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductBuilder withThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public ProductBuilder withManufactureEmail(String manufactureEmail) {
            this.manufactureEmail = manufactureEmail;
            return this;
        }

        public ProductBuilder withManufacturePhone(String manufacturePhone) {
            this.manufacturePhone = manufacturePhone;
            return this;
        }

        public ProductBuilder withStatus(ProductStatus status) {
            this.status = status;
            return this;
        }

        public ProductBuilder withErrors(HashMap<String, String> errors) {
            this.errors = errors;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.setCreatedAt(createdAt);
            product.setUpdatedAt(updatedAt);
            product.setDeletedAt(deletedAt);
            product.setCreatedBy(createdBy);
            product.setUpdatedBy(updatedBy);
            product.setDeletedBy(deletedBy);
            product.setId(id);
            product.setCategoryId(categoryId);
            product.setName(name);
            product.setDescription(description);
            product.setDetail(detail);
            product.setPrice(price);
            product.setThumbnail(thumbnail);
            product.setManufactureEmail(manufactureEmail);
            product.setManufacturePhone(manufacturePhone);
            product.setStatus(status);
            product.setErrors(errors);
            return product;
        }
    }
}
