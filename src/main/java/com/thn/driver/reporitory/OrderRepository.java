package com.thn.driver.reporitory;

import com.thn.driver.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/taxi";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";
    private static final String GET_ORDERS = "select * from orders where is_active = true";
    private static final String GET_CLIENT = "select * from users where id=?";
    private static final String GET_ORDER = "update orders set driver_id = ?, is_active = ?  where id = ?";
    private static final String GET_DRIVER = "select * from driver where login=?";
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection error");
        }
    }

    public static List<Order> getOrders() {
        ResultSet rs = prepareOrders();
        List<Order> orders = new ArrayList<>();
        try {
            while (rs.next()) {
                orders.add(new Order(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        getClientName(rs.getInt(5))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public static boolean confirmOrder(Integer id, String login) {
        boolean result = false;
        int driverId = getDriverId(login);
        System.out.println("ID in method: " + driverId);
        try {
            PreparedStatement ps = connection.prepareStatement(GET_ORDER);
            ps.setInt(1, driverId);
            ps.setBoolean(2, false);
            ps.setInt(3, id);

            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static ResultSet prepareOrders() {
        ResultSet rs = null;
        try {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(GET_ORDERS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    private static String getClientName(Integer id){
        String name = null;
        try{
            PreparedStatement ps = connection.prepareStatement(GET_CLIENT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                name = rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    private static int getDriverId(String login) {
        int id = 1;
        try {
            PreparedStatement ps = connection.prepareStatement(GET_DRIVER);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
