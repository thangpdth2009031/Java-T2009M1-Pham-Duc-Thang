package thang.t2009m1.t2009m1java.controller.product;

import thang.t2009m1.t2009m1java.entity.Category;
import thang.t2009m1.t2009m1java.entity.Product;
import thang.t2009m1.t2009m1java.model.category.CategoryModel;
import thang.t2009m1.t2009m1java.model.category.MySqlCategoryModel;
import thang.t2009m1.t2009m1java.model.product.MySqlProductModel;
import thang.t2009m1.t2009m1java.model.product.ProductModel;
import thang.t2009m1.t2009m1java.controller.myenum.ProductStatus;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class CreateProductServlet extends HttpServlet {
    private ProductModel productModel;
    private CategoryModel categoryModel;
    public CreateProductServlet() {
        this.productModel = new MySqlProductModel();
        this.categoryModel = new MySqlCategoryModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoryList = this.categoryModel.findAll();
        req.setAttribute("categories", categoryList);
        req.getRequestDispatcher("/admin/view/product/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productModel = new MySqlProductModel();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String detail = req.getParameter("detail");
        BigDecimal price = BigDecimal.valueOf(Long.parseLong(req.getParameter("price")));
        String thumbnail = req.getParameter("thumbnail");
        String manufactureEmail = req.getParameter("manufactureEmail");
        String manufacturePhone = (req.getParameter("manufacturePhone"));
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setDetail(detail);
        product.setPrice(price);
        product.setThumbnail(thumbnail);
        product.setManufactureEmail(manufactureEmail);
        product.setManufacturePhone(manufacturePhone);
        product.setStatus(ProductStatus.STOCK);
        if (!product.isValid()) {
            req.setAttribute("product", product);
            req.setAttribute("errors", product.getErrors());
            req.getRequestDispatcher("/product/create-product.jsp").forward(req, resp);
            return;
        }
        boolean result = productModel.save(product);
        if (result) {
            resp.sendRedirect("/list-product");
        }
        System.out.println(result);
    }
}
