package com.rest_api.fs14backend.cart;

import com.rest_api.fs14backend.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "cart")
@Data
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    @ManyToOne(optional = false)
    private User user;
    //private Product product;
    @Column(nullable = true, columnDefinition = "varchar(50)")
    private int quantity;
    @Column(nullable = true, columnDefinition = "varchar(50)")
    private float total;
    @Column(nullable = true, columnDefinition = "varchar(50)")
    private Timestamp createAt;
    @Column(nullable = true, columnDefinition = "varchar(50)")
    private Timestamp modifiedAt;

    public Cart(int quantity, float total, Timestamp createAt, Timestamp modifiedAt) {
        this.quantity = quantity;
        this.total = total;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}