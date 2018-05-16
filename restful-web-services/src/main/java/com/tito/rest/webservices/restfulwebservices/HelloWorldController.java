package com.tito.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  // create a GET 'mapping' to /hello-world-bean
  @GetMapping(path="/hello-world-bean")
  public HelloWorldBean helloWorldBean() {
    return new HelloWorldBean("hello world!");
  }

  // create a GET 'mapping' to /hello-world/path-variable/in28minutes
  @GetMapping(path="/hello-world/path-variable/{name}")
  public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
    return new HelloWorldBean(String.format("hello world! %s", name));
  }

}
