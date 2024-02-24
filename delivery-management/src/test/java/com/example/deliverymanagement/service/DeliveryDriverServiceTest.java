package com.example.deliverymanagement.service;

import com.example.deliverymanagement.command.UpdateDeliveryStatus;
import com.example.deliverymanagement.repository.DeliveryDriverRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

class DeliveryDriverServiceTest {

    @Mock
    private DeliveryDriverRepository deliveryDriverRepository;

    @InjectMocks
    private DeliveryDriverService deliveryDriverService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void updateDeliveryStatusTest() {
        UpdateDeliveryStatus command = new UpdateDeliveryStatus("order123", "DELIVERED");
        deliveryDriverService.updateDeliveryStatus(command);
        // Verify interactions, assert state changes, etc.
    }
}