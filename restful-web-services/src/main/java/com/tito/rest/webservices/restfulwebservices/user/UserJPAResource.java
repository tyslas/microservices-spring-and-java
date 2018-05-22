package com.tito.rest.webservices.restfulwebservices.user;

import com.tito.rest.webservices.restfulwebservices.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

//import org.springframework.hateoas.mvc.ControllerLinkBuilder;

// although this is called 'UserResource' it functions as a 'Controller'
@RestController
public class UserJPAResource {

  @Autowired
  private UserRepository userRepository;

  // GET /user - details of all users
  //retrieveAllUsers
  @GetMapping("/jpa/users")
  public List<User> retrieveAllUsers() {
    return userRepository.findAll();
  }

  // GET /users/{id} - details of a specific user
  //retrieveUser(int id)
  @GetMapping("/jpa/users/{id}")
  public Resource<User> retrieveUser(@PathVariable int id) {
    Optional<User> user = userRepository.findById(id);

    if (! user.isPresent()) {
      throw new UserNotFoundException("id-" + id);
    }
    //HATEOAS
    //"all users", SERVER_PATH + "/users" <= hard-coded example that would hinder maintenance efforts
    //retrieveAllUsers
    Resource<User> resource = new Resource<User>(user.get());
    ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
    resource.add(linkTo.withRel("all-users"));

    return resource;
  }

  // return status code => CREATED
  // input - details of user
  // output - CREATED & return the created URI
  @PostMapping("/jpa/users")
  public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
    User savedUser = userRepository.save(user);

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
  @DeleteMapping("/jpa/users/{id}")
  public void deleteUser(@PathVariable int id) {
    userRepository.deleteById(id);
  }
}
