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
    private UUID id;
    private String name;
    private String slug;
    private String image;
    private String brand;
    private String category;
    private String description;
    private BigDecimal price;
    private Integer countInStock;
    private Integer rating;
    private Integer numReviews;
}