package com.rest_api.fs14backend.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity(name = "user")
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue
  @UuidGenerator
  private UUID id;

  @Column
  private String name;

  @Column(unique = true)
  private String username;

  @Enumerated(EnumType.STRING)
  private Role role;
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  public User(String name, String username, String password, Role role) {
    this.name = name;
    this.username = username;
    this.password = password;
    this.role = role;
  }

  enum Role {
    USER,
    ADMIN
  }
}
