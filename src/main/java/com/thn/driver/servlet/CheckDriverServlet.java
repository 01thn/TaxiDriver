package com.thn.driver.servlet;

import com.thn.driver.service.CheckDriverService;
import com.thn.driver.service.TokenService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "checkDriverServlet", value = "/check-driver")
public class CheckDriverServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        boolean result = CheckDriverService.checkDriver(login, password);

        if (result) {
            String userToken = TokenService.createToken(login);
            Cookie cookie = new Cookie("token", userToken);
            cookie.setMaxAge(60);
            resp.addCookie(cookie);
            req.getSession().setAttribute("login", login);
            resp.sendRedirect("account");
        } else {
            req.setAttribute("login", login);
            req.setAttribute("message", "Looks like you are not a driver");
            getServletContext().getRequestDispatcher("/auth").forward(req, resp);
        }
    }
}
