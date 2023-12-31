package com.rest_api.fs14backend.category;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity(name = "category")
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Category {
  @Id
  @GeneratedValue
  @UuidGenerator
  private UUID id;

  @Column(unique = true, nullable = false)
  private String name;
}
