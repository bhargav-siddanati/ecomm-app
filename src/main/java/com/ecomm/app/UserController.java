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
    return userService.getUser(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping("/addUser")
  public ResponseEntity<String> addUser(@RequestBody User user) {
    /*
    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedUser.getId())
        .toUri();

    return ResponseEntity.created(location).body(savedUser);

     */
    return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
  }

  @PutMapping("/updateUser/{id}")
  public ResponseEntity<String> modifyUser(@PathVariable Long id, @RequestBody User user){
    boolean isUserUpdated = userService.updateExistedUser(id, user);
    if(isUserUpdated)
      return ResponseEntity.ok("User data updated successfully");
    return new ResponseEntity<>("User data not existed", HttpStatus.NOT_FOUND);
  }
}
