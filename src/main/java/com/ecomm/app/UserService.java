package com.ecomm.app;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  private List<User> userList = new ArrayList<>();
  private Long increID = 1L;

  public List<User> fetchUsers() {
    return userList;
  }

  public Optional<User> getUser(Long id) {
    return userList.stream().filter(user -> user.getId().equals(id))
            .findAny();
  }

  public String createUser(User user) {
    user.setId(increID++);
    userList.add(user);
    return "User added successfully";
  }
}
