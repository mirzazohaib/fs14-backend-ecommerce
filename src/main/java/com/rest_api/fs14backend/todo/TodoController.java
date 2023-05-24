package com.rest_api.fs14backend.todo;

import com.rest_api.fs14backend.category.Category;
import com.rest_api.fs14backend.category.CategoryService;
import com.rest_api.fs14backend.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
//@RequestMapping("api/v1/todos")
public class TodoController {

  @Autowired
  private TodoService todoService;
  @Autowired
  private CategoryService categoryService;
  @Autowired
  private TodoMapper todoMapper;

  @GetMapping("/hello")
  public String hello(@RequestParam(name = "name", defaultValue = "World") String name) {
    return String.format("Hello, %s", name);
  }

  @PostMapping("/")
  public Todo createOne(@RequestBody TodoDTO todoDTO) {
    UUID categoryId = todoDTO.getCategoryId();
    Category category = categoryService.findById(categoryId);

    Todo todo = todoMapper.toTodo(todoDTO, category);

    return todoService.createOne(todo);
  }

  @GetMapping("/")
  public List<Todo> findAll() {
    return todoService.findAll();
  }

  @GetMapping("/{id}")
  public Todo findById(@PathVariable UUID id) {
    Todo todo = todoService.findById(id);

    if (todo == null) {
      throw new NotFoundException("Todo not found");
    }
    return todo;
  }

  @DeleteMapping("/{id}")
  public void deleteOne(@PathVariable UUID id) {
    todoService.deleteById(id);
  }
}
