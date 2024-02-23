package com.example.ordermanagement.dto;

import java.util.List;

public class OrderRequest {
    private List<MenuSelection> menu;
    private Address deliveryAddress;
    private String paymentMethod;

    // Getters and setters omitted for brevity
}