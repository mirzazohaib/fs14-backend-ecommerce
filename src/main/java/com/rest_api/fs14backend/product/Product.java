package com.rest_api.fs14backend.product;

import com.rest_api.fs14backend.category.Category;
import com.rest_api.fs14backend.order.Order;
import com.rest_api.fs14backend.status.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "product")
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToOne(optional = false)
    @JoinColumn(name = "status_id")
    private Status status;

    public Product(String title, String description, BigDecimal price, int quantity, Category category) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }
}