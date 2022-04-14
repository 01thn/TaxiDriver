package com.thn.driver.servlet;

import com.thn.driver.service.TokenService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/")
public class CheckTokenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sessionLogin = (String) req.getSession().getAttribute("login");
        Cookie[] cookies = req.getCookies();
        String token = null;
        boolean isVerifiedByToken = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                    isVerifiedByToken = TokenService.verifyToken(token, sessionLogin);
                }
            }
        }

        if (isVerifiedByToken) {
            resp.sendRedirect("account");
        } else {
            resp.sendRedirect("auth");
        }
    }
}
