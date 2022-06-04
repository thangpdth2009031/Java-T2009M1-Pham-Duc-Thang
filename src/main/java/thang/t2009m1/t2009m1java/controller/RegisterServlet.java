package thang.t2009m1.t2009m1java.controller;

import thang.t2009m1.t2009m1java.entity.Account;
import thang.t2009m1.t2009m1java.model.AccountModel;
import thang.t2009m1.t2009m1java.model.MySqlAccountModel;
import thang.t2009m1.t2009m1java.controller.myenum.AccountStatus;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class RegisterServlet extends HttpServlet {
    AccountModel accountModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/User/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        accountModel = new MySqlAccountModel();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String birthday = (req.getParameter("birthday"));
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setConfirmPassword(confirmPassword);
        account.setFullName(fullName);
        account.setEmail(email);
        account.setPhone(phone);
        account.setBirthday(LocalDate.parse(birthday));
        account.setStatus(AccountStatus.ACTIVE);
        if (!account.isValid()) {
            req.setAttribute("account", account);
            req.setAttribute("errors", account.getErrors());
            req.getRequestDispatcher("/User/register.jsp").forward(req, resp);
            return;
        }
        boolean result = accountModel.save(account);
        if (result) {
            req.getRequestDispatcher("/User/account-success.jsp").forward(req, resp);
        }
        System.out.println(result);
    }
}
