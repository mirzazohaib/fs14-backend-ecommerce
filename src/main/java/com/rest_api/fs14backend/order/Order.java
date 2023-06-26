package com.rest_api.fs14backend.order;

import com.rest_api.fs14backend.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity(name = "order")
@Table(name = "order")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Order {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @OneToMany(mappedBy = "order")
    private List<Product> products;

    private BigDecimal total;
    private int quantity;
    private String shipmentDate;
    private String status;
    private boolean isCompleted;

    public Order(BigDecimal total, int quantity, String shipmentDate, String status, boolean isCompleted) {
        this.total = total;
        this.quantity = quantity;
        this.shipmentDate = shipmentDate;
        this.status = status;
        this.isCompleted = isCompleted;
    }

}
