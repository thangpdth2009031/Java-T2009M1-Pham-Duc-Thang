package thang.t2009m1.t2009m1java.model.product;

import thang.t2009m1.t2009m1java.constant.SqlConstant;
import thang.t2009m1.t2009m1java.entity.Product;
import thang.t2009m1.t2009m1java.model.product.ProductModel;
import thang.t2009m1.t2009m1java.myenum.ProductStatus;
import thang.t2009m1.t2009m1java.util.ConnectionHelper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        List<Product> products = new ArrayList<>();
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.SELECT_PRODUCT);
            preparedStatement.setInt(1, ProductStatus.STOCK.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String detail = resultSet.getString("detail");
                BigDecimal price = resultSet.getBigDecimal("price");
                String thumbnail = resultSet.getString("thumbnail");
                String manufactureEmail = resultSet.getString("manufacture_email");
                String manufacturePhone = resultSet.getString("manufacture_phone");
                LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();
                LocalDateTime updatedAt = resultSet.getTimestamp("updated_at").toLocalDateTime();
                LocalDateTime deletedAt = null;
                if(resultSet.getTimestamp("deleted_at") != null) {
                    deletedAt = resultSet.getTimestamp("deleted_at").toLocalDateTime();
                }
                int createdBy = resultSet.getInt("created_by");
                int updatedBy = resultSet.getInt("updated_by");
                int deletedBy = resultSet.getInt("deleted_by");
                ProductStatus status = ProductStatus.of(resultSet.getInt("status"));
                Product product = new Product();
                product.setId(id);
                product.setName(name);
                product.setDescription(description);
                product.setDetail(detail);
                product.setPrice(price);
                product.setThumbnail(thumbnail);
                product.setManufactureEmail(manufactureEmail);
                product.setManufacturePhone(manufacturePhone);
                product.setCreatedAt(createdAt);
                product.setUpdatedAt(updatedAt);
                product.setDeletedAt(deletedAt);
                product.setCreatedBy(createdBy);
                product.setUpdatedBy(updatedBy);
                product.setDeletedBy(deletedBy);
                product.setStatus(status);
                products.add(product);
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
        return products;
    }

    @Override
    public Product findById(int id) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PRODUCT_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, ProductStatus.STOCK.getValue());
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                String detail = rs.getString("detail");
                Double price = rs.getDouble("price");
                String thumbnail = rs.getString("thumbnail");
                String manufactureEmail = rs.getString("manufactureEmail");
                String manufacturePhone = rs.getString("manufacturePhone");
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp("updatedAt").toLocalDateTime();
                LocalDateTime deletedAt = null;
                if(rs.getTimestamp("deletedAt") != null) {
                    deletedAt = rs.getTimestamp("deletedAt").toLocalDateTime();
                }
                int createdBy = rs.getInt("createdBy");
                int updatedBy = rs.getInt("updatedBy");
                int deletedBy = rs.getInt("deletedBy");
                ProductStatus status = ProductStatus.values()[rs.getInt("status")];
                Product product = new Product(id, name, description, detail, price, thumbnail, manufactureEmail, manufacturePhone, createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy, status);
                return product;
            }
        }catch (SQLException e) {
//            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }
}
