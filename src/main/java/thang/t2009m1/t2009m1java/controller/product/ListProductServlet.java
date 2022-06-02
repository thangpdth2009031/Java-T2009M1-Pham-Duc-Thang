package thang.t2009m1.t2009m1java.controller.product;

import thang.t2009m1.t2009m1java.entity.Product;
import thang.t2009m1.t2009m1java.model.product.MySqlProductModel;
import thang.t2009m1.t2009m1java.model.product.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListProductServlet extends HttpServlet {
    private ProductModel productModel;
    public ListProductServlet() {
        this.productModel = new MySqlProductModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productModel.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/admin/view/product/list.jsp").forward(req, resp);
    }
}
