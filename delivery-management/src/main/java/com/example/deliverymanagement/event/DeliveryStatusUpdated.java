package com.example.deliverymanagement.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DeliveryStatusUpdated {
    private String orderId;
    private String status;
}