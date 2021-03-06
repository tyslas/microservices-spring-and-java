package com.tito.rest.webservices.restfulwebservices;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.tito.rest.webservices.restfulwebservices.user.User;
import com.tito.rest.webservices.restfulwebservices.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
//import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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
  public Resource<User> retrieveUser(@PathVariable int id) {
    User user = service.findOne(id);
    if (user == null) {
      throw new UserNotFoundException("id-" + id);
    }
    //HATEOAS
    //"all users", SERVER_PATH + "/users" <= hard-coded example that would hinder maintenance efforts
    //retrieveAllUsers
    Resource<User> resource = new Resource<User>(user);
    ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
    resource.add(linkTo.withRel("all-users"));

    return resource;
  }

  // return status code => CREATED
  // input - details of user
  // output - CREATED & return the created URI
  @PostMapping("/users")
  public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
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

  // this deleteUser method has a return type of void the void return type
  // translates to a 200 status if everything works fine & throws an exception if not
  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable int id) {
    User user = service.deleteById(id);
    if (user == null) {
      throw new UserNotFoundException("id-" + id);
    }
  }
}
