package com.thn.driver.servlet;

import com.thn.driver.service.CheckDriverService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "checkDriverServlet", value = "/check-driver")
public class CheckDriverServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login;
        String password;
        login = req.getParameter("login");
        password = req.getParameter("password");

        boolean result = CheckDriverService.checkDriver(login, password);

        if (result) {
            req.getSession().setAttribute("login", login);
            resp.sendRedirect("account");
        } else {
            req.setAttribute("login", login);
            req.setAttribute("message", "Looks like you are not a driver");
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
