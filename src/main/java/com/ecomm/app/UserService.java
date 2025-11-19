package com.ecomm.app;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
  private List<User> userList = new ArrayList<>();
  private Long increID = 1L;

  public List<User> fetchUsers() {
    return userList;
  }

  public User getUser(Long id) {
    for(User user : userList){
      if (user.getId().equals(id))
        return user;
    }
    return null;
  }

  public String createUser(User user) {
    user.setId(increID++);
    userList.add(user);
    return "User added successfully";
  }
}
