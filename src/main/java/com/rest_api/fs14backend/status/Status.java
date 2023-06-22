package com.rest_api.fs14backend.status;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity(name = "status")
@Table(name = "status")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Status {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    @Column(nullable = true, columnDefinition = "varchar(50)")
    private String createdAt;
    @Column(nullable = true, columnDefinition = "varchar(50)")
    private String modifiedAt;
    @Column(nullable = true, columnDefinition = "varchar(50)")
    private String deletedAt;

    public Status(String createdAt, String modifiedAt, String deletedAt) {
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.deletedAt = deletedAt;
    }
}
