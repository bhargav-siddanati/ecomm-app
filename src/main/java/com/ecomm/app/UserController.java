package com.ecomm.app;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/users")
  public List<User> getUsers() {
    return userService.fetchUsers();
  }

  @GetMapping("/getUser/{id}")
  public User getUser(@PathVariable int id) {
    return userService.getUser(id);
  }

  @PostMapping("/addUser")
  public String addUser(@RequestBody User user) {
    return userService.createUser(user);
  }
}
