package thang.t2009m1.t2009m1java.model.product;

import thang.t2009m1.t2009m1java.constant.SqlConstant;
import thang.t2009m1.t2009m1java.controller.myenum.CategoryStatus;
import thang.t2009m1.t2009m1java.entity.Category;
import thang.t2009m1.t2009m1java.entity.Product;
import thang.t2009m1.t2009m1java.controller.myenum.ProductStatus;
import thang.t2009m1.t2009m1java.util.ConnectionHelper;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductModel implements ProductModel {
    @Override
    public boolean save(Product product) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SqlConstant.PRODUCT_INSERT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setString(3, product.getDetail());
            preparedStatement.setBigDecimal(4, product.getPrice());
            preparedStatement.setString(5, product.getThumbnail());
            preparedStatement.setString(6, product.getManufactureEmail());
            preparedStatement.setString(7, product.getManufacturePhone());
            preparedStatement.setString(8, product.getCreatedAt().toString());
            preparedStatement.setString(9, product.getUpdatedAt().toString());
            preparedStatement.setInt(10, product.getCreatedBy());
            preparedStatement.setInt(11, product.getUpdatedBy());
            preparedStatement.setInt(12, product.getStatus().getValue());
            preparedStatement.setInt(13, product.getCategoryId());
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(int id, Product product) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PRODUCT_UPDATE);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setString(3, product.getDetail());
            preparedStatement.setBigDecimal(4, product.getPrice());
            preparedStatement.setString(5, product.getThumbnail());
            preparedStatement.setString(6, product.getManufactureEmail());
            preparedStatement.setString(7, product.getManufacturePhone());
            preparedStatement.setString(8, product.getCreatedAt().toString());
            preparedStatement.setString(9, product.getUpdatedAt().toString());
            if(product.getDeletedAt() != null) {
                preparedStatement.setString(10, product.getDeletedAt().toString());
            }else {
                preparedStatement.setString(10, null);
            }
            preparedStatement.setInt(11, product.getCreatedBy());
            preparedStatement.setInt(12, product.getUpdatedBy());
            preparedStatement.setInt(13, product.getDeletedBy());
            preparedStatement.setInt(14, product.getStatus().getValue());
            preparedStatement.setInt(15, id);
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e) {
//            e.printStackTrace();
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PRODUCT_DELETE);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e) {
//            e.printStackTrace();
            System.out.println(e);
        }
        return false;
    }

    @Override
    public List<Product> findAll() {
        List<Product> listObj = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SqlConstant.SELECT_PRODUCT);
            preparedStatement.setInt(1, ProductStatus.STOCK.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = convertResultSetToObject(resultSet);
                if (product != null) {
                    listObj.add(product);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listObj;
    }

    @Override
    public Product findById(int id) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PRODUCT_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, ProductStatus.STOCK.getValue());
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return convertResultSetToObject(rs);
            }
        }catch (SQLException e) {
//            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    private Product convertResultSetToObject(ResultSet resultSet) {
        try {
            int id = resultSet.getInt(SqlConstant.PRODUCT_FIELD_ID);
            int categoryId = resultSet.getInt(SqlConstant.PRODUCT_FIELD_CATEGORY_ID);
            String name = resultSet.getString(SqlConstant.PRODUCT_FIELD_NAME);
            String description = resultSet.getString(SqlConstant.PRODUCT_FIELD_DESCRIPTION);
            String detail = resultSet.getString(SqlConstant.PRODUCT_FIELD_DETAIL);
            String manufactureEmail = resultSet.getString(SqlConstant.PRODUCT_FIELD_MANUFACTURE_EMAIL);
            String manufacturePhone = resultSet.getString(SqlConstant.PRODUCT_FIELD_MANUFACTURE_PHONE);
            String thumbnail = resultSet.getString(SqlConstant.PRODUCT_FIELD_THUMBNAIL);
            BigDecimal price = resultSet.getBigDecimal(SqlConstant.PRODUCT_FIELD_PRICE);
            int status = resultSet.getInt(SqlConstant.PRODUCT_FIELD_STATUS);
            LocalDateTime createdAt = resultSet.getTimestamp(SqlConstant.FIELD_CREATED_AT).toLocalDateTime();
            LocalDateTime updatedAt = resultSet.getTimestamp(SqlConstant.FIELD_UPDATED_AT).toLocalDateTime();
            LocalDateTime deletedAt = null;
            Timestamp timestamp = resultSet.getTimestamp(SqlConstant.FIELD_DELETED_AT);
            if (timestamp != null) {
                deletedAt = timestamp.toLocalDateTime();
            }
            int createdBy = resultSet.getInt(SqlConstant.FIELD_CREATED_BY);
            int updatedBy = resultSet.getInt(SqlConstant.FIELD_UPDATED_BY);
            int deletedBy = resultSet.getInt(SqlConstant.FIELD_DELETED_BY);
            return Product.ProductBuilder.aProduct()
                    .withId(id)
                    .withCategoryId(categoryId)
                    .withName(name)
                    .withDescription(description)
                    .withDetail(detail)
                    .withPrice(price)
                    .withThumbnail(thumbnail)
                    .withManufactureEmail(manufactureEmail)
                    .withManufacturePhone(manufacturePhone)
                    .withStatus(ProductStatus.of(status))
                    .withCreatedAt(createdAt)
                    .withUpdatedAt(updatedAt)
                    .withDeletedAt(deletedAt)
                    .withCreatedBy(createdBy)
                    .withUpdatedBy(updatedBy)
                    .withDeletedBy(deletedBy)
                    .build();
        } catch (SQLException ex) {
            return null;
        }
    }
}
