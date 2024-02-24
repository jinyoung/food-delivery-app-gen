package com.example.deliverymanagement.controller;

import com.example.deliverymanagement.command.UpdateDeliveryLocation;
import com.example.deliverymanagement.command.UpdateDeliveryStatus;
import com.example.deliverymanagement.service.DeliveryDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery-drivers")
public class DeliveryDriverController {

    private final DeliveryDriverService deliveryDriverService;

    @Autowired
    public DeliveryDriverController(DeliveryDriverService deliveryDriverService) {
        this.deliveryDriverService = deliveryDriverService;
    }

    @PostMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable String id, @RequestBody UpdateDeliveryStatus command) {
        deliveryDriverService.updateDeliveryStatus(command);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/location")
    public ResponseEntity<?> updateLocation(@PathVariable String id, @RequestBody UpdateDeliveryLocation command) {
        deliveryDriverService.updateDeliveryLocation(command);
        return ResponseEntity.ok().build();
    }
}