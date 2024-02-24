package com.example.deliverymanagement.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateDeliveryStatus {
    private String orderId;
    private String status;
}