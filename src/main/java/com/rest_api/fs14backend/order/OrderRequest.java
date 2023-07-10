package com.rest_api.fs14backend.order;

import com.rest_api.fs14backend.cart.CartItem;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class OrderRequest {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private UUID userId;
    //instead of list of productIds, we need to send list of productId and quantity as one: define cartItem {id, productId, quantity}
    private List<CartItem> cartItemList;

    public OrderRequest(UUID userId, List<CartItem> cartItemList) {
        this.userId = userId;
        this.cartItemList = cartItemList;
    }
}