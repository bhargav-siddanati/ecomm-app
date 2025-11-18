package com.ecomm.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private List<User> userList = new ArrayList<>();

    @GetMapping("/users")
    public List<User> getUsers(){
        return userList;
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        userList.add(user);
        return "User added successfully";
    }
}
