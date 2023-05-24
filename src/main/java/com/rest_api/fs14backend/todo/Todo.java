package com.rest_api.fs14backend.todo;

import com.rest_api.fs14backend.category.Category;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity(name = "todo")
@Table(name = "todo")
@Data
@NoArgsConstructor
public class Todo {
  @Id
  @GeneratedValue
  @UuidGenerator
  private UUID id;
  @Column(nullable = false, columnDefinition = "varchar(50)")
  private String title;
  @Column(nullable = false)
  private boolean isCompleted;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Category category;

  public Todo(String title, boolean isCompleted, Category category) {
    this.title = title;
    this.isCompleted = isCompleted;
    this.category = category;
  }


  public UUID getCategory() {
    return category.getId();
  }

}
