package com.rest_api.fs14backend.cart;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private UUID productId;
    private int quantity;

    public CartItem(UUID productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}