package com.thn.driver.service;

import com.thn.driver.model.Order;
import com.thn.driver.reporitory.OrderRepository;

import java.util.List;

public class OrderService {
    public static List<Order> getOrders() {
        return OrderRepository.getOrders();
    }

    public static boolean confirmOrder(Integer id, String login) {
        return OrderRepository.confirmOrder(id, login);
    }
}
