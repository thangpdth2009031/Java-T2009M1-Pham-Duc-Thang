package thang.t2009m1.t2009m1java.controller.category;
import thang.t2009m1.t2009m1java.entity.Category;
import thang.t2009m1.t2009m1java.model.category.CategoryModel;
import thang.t2009m1.t2009m1java.model.category.MySqlCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListCategory extends HttpServlet {
    private CategoryModel categoryModel;

    public ListCategory() {
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categories", categoryModel.findAll());
        req.getRequestDispatcher("/admin/view/category/list.jsp").forward(req, resp);
    }
}
