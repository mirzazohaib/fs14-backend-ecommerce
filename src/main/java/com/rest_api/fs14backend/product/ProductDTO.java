package com.rest_api.fs14backend.product;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@Data
public class ProductDTO {
    private UUID categoryId;
    private String title;
    private String description;
    private BigDecimal price;
    private int quantity;
}