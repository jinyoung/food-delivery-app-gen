package com.example.deliverymanagement.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DeliveryDriver {
    @Id
    private String deliveryDriverId;
    private String name;
    private String phone;
    private Address location;
    private String status;
}