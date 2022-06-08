package thang.t2009m1.t2009m1java.controller.filter;

import thang.t2009m1.t2009m1java.entity.Account;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpServletRequest.getSession();
        boolean havePermission = false;
        if (session.getAttribute("currentAccount") != null) {
            Account account = (Account) session.getAttribute("currentAccount");
            System.out.println("Hello user: " + account.getUsername());
            if (account.getRoleId() == 2) {
                havePermission = true;
            }
        }
        if (havePermission) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } else {
            httpServletResponse.getWriter().println("Permission denied!");
        }
    }
}
