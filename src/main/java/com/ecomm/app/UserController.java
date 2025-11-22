package com.ecomm.app;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

  private final UserService userService;
  //@RequestMapping(value="/users", method = RequestMethod.GET)
  @GetMapping
  public ResponseEntity<List<User>> getUsers() {
    return ResponseEntity.ok(userService.fetchUsers());
  }

  @GetMapping("{id}")
  public ResponseEntity<User> getUser(@PathVariable Long id) {
    return userService.getUser(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping("/add")
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

  @PutMapping("/update/{id}")
  public ResponseEntity<String> modifyUser(@PathVariable Long id, @RequestBody User user){
    boolean isUserUpdated = userService.updateExistedUser(id, user);
    if(isUserUpdated)
      return ResponseEntity.ok("User data updated successfully");
    return new ResponseEntity<>("User data not existed", HttpStatus.NOT_FOUND);
  }
}
