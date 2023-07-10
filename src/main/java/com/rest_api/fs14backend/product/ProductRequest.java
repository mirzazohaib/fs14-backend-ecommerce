package com.rest_api.fs14backend.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductRequest {
    private UUID categoryId;
    private String title;
    private BigDecimal price;
    private String description;
    private String image;
    private int quantity;
}