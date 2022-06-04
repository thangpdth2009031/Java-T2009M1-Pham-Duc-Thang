package thang.t2009m1.t2009m1java.controller.category;

import thang.t2009m1.t2009m1java.controller.myenum.CategoryStatus;
import thang.t2009m1.t2009m1java.controller.myenum.ProductStatus;
import thang.t2009m1.t2009m1java.entity.Category;
import thang.t2009m1.t2009m1java.entity.Product;
import thang.t2009m1.t2009m1java.model.category.CategoryModel;
import thang.t2009m1.t2009m1java.model.category.MySqlCategoryModel;
import thang.t2009m1.t2009m1java.model.product.MySqlProductModel;
import thang.t2009m1.t2009m1java.model.product.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class CreateCategory extends HttpServlet {
    private CategoryModel categoryModel;
    public CreateCategory() {
        this.categoryModel = new MySqlCategoryModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/view/category/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        Category category = new Category();
        category.setName(name);
        category.setStatus(CategoryStatus.ACTIVE);
        if (!category.isValid()) {
            req.setAttribute("category", category);
            req.setAttribute("errors", category.getErrors());
            req.getRequestDispatcher("/admin/view/category/create.jsp").forward(req, resp);
            return;
        }
        boolean result = categoryModel.save(category);
        if (result) {
            resp.sendRedirect("/admin/category/list");
        }
        System.out.println(result);
    }
}
