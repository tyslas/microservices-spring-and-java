package com.tito.rest.webservices.restfulwebservices;

import com.tito.rest.webservices.restfulwebservices.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {

  @Autowired
  private UserDaoService service;

  // GET /user - details of all users
  //retrieveAllUsers
  @GetMapping("/users")
  public List<User> retrieveAllUsers() {
    return service.findAll();
  }

  // GET /users/{id} - details of a specific user
  //retrieveUser(int id)
  @GetMapping("/users/{id}")
  public User retrieveUser(@PathVariable int id) {
    return service.findOne(id);
  }
}
