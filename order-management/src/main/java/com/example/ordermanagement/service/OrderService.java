package com.example.ordermanagement.service;

import com.example.ordermanagement.dto.OrderRequest;
import com.example.ordermanagement.dto.UpdateOrderStatusRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createOrder(OrderRequest orderRequest) {
        // Generate a new UUID for the order
        String orderId = UUID.randomUUID().toString();

        // Insert order into the database using JDBC
        String sql = "INSERT INTO orders (order_id, menu, delivery_address, payment_method) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, orderId, orderRequest.getMenu().toString(), orderRequest.getDeliveryAddress().toString(), orderRequest.getPaymentMethod());

        // Publish an OrderPlaced event (implementation omitted for brevity)

        return orderId;
    }

    public String updateOrderStatus(String orderId, UpdateOrderStatusRequest updateOrderStatusRequest) {
        // Update order status in the database using JDBC
        String sql = "UPDATE orders SET status = ? WHERE order_id = ?";
        jdbcTemplate.update(sql, updateOrderStatusRequest.getStatus(), orderId);

        // Publish an OrderStatusUpdated event (implementation omitted for brevity)

        return "Order status updated";
    }
}