package com.example.deliverymanagement.repository;

import com.example.deliverymanagement.domain.DeliveryDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DeliveryDriverRepository extends JpaRepository<DeliveryDriver, String> {
}