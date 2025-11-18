package com.ecomm.app;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> userList = new ArrayList<>();

    public List<User> fetchUsers(){
        return userList;
    }

    public String createUser(User user){
        userList.add(user);
        return "User added successfully";
    }
}
