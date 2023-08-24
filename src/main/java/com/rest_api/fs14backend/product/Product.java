package com.rest_api.fs14backend.product;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity(name = "product")
@Table(name = "products")
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer countInStock;

    @Column(nullable = false)
    private Integer rating;

    @Column(nullable = false)
    private Integer numReviews;

    public Product(String name, String slug, String image, String brand, String category, String description, BigDecimal price, Integer countInStock, Integer rating, Integer numReviews) {
        this.name = name;
        this.slug = slug;
        this.image =image;
        this.brand = brand;
        this.category = category;
        this.description = description;
        this.price = price;
        this.countInStock = countInStock;
        this.rating = rating;
        this.numReviews = numReviews;
    }
}