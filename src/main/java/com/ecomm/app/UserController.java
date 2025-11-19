package com.ecomm.app;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/users")
  public ResponseEntity<List<User>> getUsers() {
    return ResponseEntity.ok(userService.fetchUsers());
  }

  @GetMapping("/getUser/{id}")
  public ResponseEntity<User> getUser(@PathVariable Long id) {
    return ResponseEntity.ok(userService.getUser(id));
  }

  @PostMapping("/addUser")
  public ResponseEntity<String> addUser(@RequestBody User user) {
    return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
  }
}
