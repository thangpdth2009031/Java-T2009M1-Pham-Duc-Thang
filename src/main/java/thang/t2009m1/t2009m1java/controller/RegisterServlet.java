package thang.t2009m1.t2009m1java.controller;

import thang.t2009m1.t2009m1java.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/User/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String birthday = (req.getParameter("birthday"));
        LocalDate date = LocalDate.parse(birthday);
        User user = new User();
        user.setUsername(username);
        user.setBirthday(date);
        user.setUsername(username);
        user.setFullName(fullName);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/User/account-success.jsp").forward(req, resp);
    }
}
