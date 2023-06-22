package com.rest_api.fs14backend.inventory;

import com.rest_api.fs14backend.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InventoryRepository extends JpaRepository<Order, UUID> {
}