package com.ecomm.app;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRespository userRespository;
  public List<User> fetchUsers() {
    return userRespository.findAll();
  }

  public Optional<User> getUser(Long id) {
    return userRespository.findById(id);
  }

  public String createUser(User user) {
    userRespository.save(user);
    return "User added successfully";
  }

  public boolean updateExistedUser(Long id, User user){
    return userRespository.findById(id)
            .map(m -> {
              m.setLastName(user.getLastName());
              m.setFirstName(user.getFirstName());
              userRespository.save(m);
              return true;
            }).orElse(false);
  }
}
