package thang.t2009m1.t2009m1java.controller.auth;

import thang.t2009m1.t2009m1java.entity.Account;
import thang.t2009m1.t2009m1java.model.AccountModel;
import thang.t2009m1.t2009m1java.model.MySqlAccountModel;
import thang.t2009m1.t2009m1java.controller.myenum.AccountStatus;
import thang.t2009m1.t2009m1java.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class RegisterServlet extends HttpServlet {
    private AccountService accountService;

    public RegisterServlet() {
        this.accountService = new AccountService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/client/user/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        //String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
       // String phone = req.getParameter("phone");
        //String birthday = (req.getParameter("birthday"));
        Account account = Account.AccountBuilder.anAccount()
                .withUsername(username)
                .withEmail(email)
                .withPassword(password)
                .withConfirmPassword(confirmPassword)
                .withStatus(AccountStatus.ACTIVE)
                .withBirthday(LocalDate.now())
                .withCreatedAt(LocalDateTime.now())
                .withUpdatedAt(LocalDateTime.now())
                .withRoleId(1)
                .build();
        if (!account.isValid()) {
            req.setAttribute("account", account);
            req.setAttribute("errors", account.getErrors());
            req.getRequestDispatcher("/client/user/login.jsp").forward(req, resp);
            return;
        }
        account = accountService.register(account);
        if (account != null) {
            req.setAttribute("account", account);
            req.getRequestDispatcher("/User/account-success.jsp").forward(req, resp);
        }else {
            resp.getWriter().println("Register fails!");
        }
    }
}
