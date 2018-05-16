package com.tito.rest.webservices.restfulwebservices;

import com.tito.rest.webservices.restfulwebservices.user.User;
import com.tito.rest.webservices.restfulwebservices.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

// although this is called 'UserResource' it functions as a 'Controller'
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
    User user = service.findOne(id);
    if (user == null) {
      throw new UserNotFoundException("id-" + id);
    }
    return user;
  }

  // return status code => CREATED
  // input - details of user
  // output - CREATED & return the created URI
  @PostMapping("/users")
  public ResponseEntity<Object> createUser(@RequestBody User user) {
    User savedUser = service.save(user);

//    String uriLocation = "/users/" + savedUser.getId(); //my attempt
    URI uriLocation = ServletUriComponentsBuilder
        .fromCurrentRequest() //captures the root URI "/users"
        .path("/{id}") //captures the id of the resource created
        .buildAndExpand(savedUser.getId()) //puts the full path together
        .toUri(); //creates a URI data type

//    return "/users/" + savedUser.getId(); //my attempt
    return ResponseEntity.created(uriLocation).build(); //returns a 201 status code => 'Created'
  }
}
