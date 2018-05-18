package com.tito.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

// Controller: responsible for handling HTTP requests
// add Controller annotation
@RestController
public class HelloWorldController {

  @Autowired
  private MessageSource messageSource;

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

  @GetMapping(path="/hello-world-internationalized")
  public String helloWorldInt(@RequestHeader(name  = "Accept-Language", required = false) Locale locale) {
    return messageSource.getMessage("good.morning.message", null, locale);
  }

}
