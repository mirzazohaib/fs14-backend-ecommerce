package com.rest_api.fs14backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/users")
  public List<User> findAll() {
    return userService.findAll();
  }

  @PostMapping("/auth/signin")
  public Map<String, String> login(@RequestBody AuthRequest authRequest) {
    return userService.loginUser(authRequest);
  }

  @PostMapping("/auth/signup")
  public User signup(@RequestBody User user) {
    return userService.createOne(user);
  }

  @GetMapping("/users/{id}")
  public User findById(@PathVariable UUID id) {
    return userService.findById(id);
  }

  @DeleteMapping("/users/{id}")
  public void deleteById(@PathVariable UUID id) {
    userService.deleteOne(id);
  }
}