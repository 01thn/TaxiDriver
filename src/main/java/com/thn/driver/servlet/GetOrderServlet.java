package com.thn.driver.servlet;

import com.thn.driver.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/get-order")
public class GetOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer orderId = Integer.valueOf(req.getParameter("id"));
        String login = (String) req.getSession().getAttribute("login");
        boolean result = OrderService.confirmOrder(orderId, login);

        if (result) {
            req.setAttribute("message", "You've confirmed an order");
            getServletContext().getRequestDispatcher("/account").forward(req, resp);
        } else {
            req.setAttribute("message", "You have not confirmed an order. Try again");
            getServletContext().getRequestDispatcher("/account").forward(req, resp);
        }
    }
}
