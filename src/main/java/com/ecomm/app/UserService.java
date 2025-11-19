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

  public User getUser(int id) {
    //return id <= userList.size() ? userList.get(id-1) : null;
    User response = null;
    for(User user : userList){
      if (user.getId().equals(id)) {
        response = user;
        break;
        }
    }
    return response;
  }

  public String createUser(User user) {
    user.setId(increID++);
    userList.add(user);
    return "User added successfully";
  }
}
