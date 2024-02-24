package com.example.deliverymanagement.command;

import com.example.deliverymanagement.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateDeliveryLocation {
    private String deliveryDriverId;
    private Address location;
}