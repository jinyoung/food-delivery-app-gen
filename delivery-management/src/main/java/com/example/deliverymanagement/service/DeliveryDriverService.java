package com.example.deliverymanagement.service;

import com.example.deliverymanagement.command.UpdateDeliveryLocation;
import com.example.deliverymanagement.command.UpdateDeliveryStatus;
import com.example.deliverymanagement.domain.DeliveryDriver;
import com.example.deliverymanagement.event.DeliveryStatusUpdated;
import com.example.deliverymanagement.repository.DeliveryDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeliveryDriverService {

    private final DeliveryDriverRepository deliveryDriverRepository;

    @Autowired
    public DeliveryDriverService(DeliveryDriverRepository deliveryDriverRepository) {
        this.deliveryDriverRepository = deliveryDriverRepository;
    }

    @Transactional
    public void updateDeliveryStatus(UpdateDeliveryStatus command) {
        // Business logic to update delivery status
        // Emit event after updating status
    }

    @Transactional
    public void updateDeliveryLocation(UpdateDeliveryLocation command) {
        // Business logic to update delivery location
    }
}