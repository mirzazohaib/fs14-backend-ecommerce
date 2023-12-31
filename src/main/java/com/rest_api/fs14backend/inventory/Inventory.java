package com.rest_api.fs14backend.inventory;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity(name =  "inventory")
@Table(name = "inventories")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Inventory {
    @Id
    @GeneratedValue
    @UuidGenerator

    private UUID id;
    @Column(nullable = false)
    private int quantity;

    public Inventory(int quantity) {
        this.quantity = quantity;
    }
}
