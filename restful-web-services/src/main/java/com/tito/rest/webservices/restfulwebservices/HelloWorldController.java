package com.tito.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Controller: responsible for handling HTTP requests
// add Controller annotation
@RestController
public class HelloWorldController {
  // GET
  // URI - /hello-world
  // method - "hello world!"
  // use annotation to create a "mapping" of the HTTP request -> URI
//  @RequestMapping(method=RequestMethod.GET, path="/hello-world") // must specify request method
  @GetMapping(path="/hello-world") // method doesn't need to be specified w/this annotation
  public String helloWorld() {
    return "hello world!";
  }

}
