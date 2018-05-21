package com.tito.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

  // 1 - URIs
  @GetMapping("v1/person") //most basic way of versioning
  public PersonV1 personV1() {
    return new PersonV1("Bob Charlie");
  }

  @GetMapping("v2/person")
  public PersonV2 personV2() {
    return new PersonV2(new Name("bob", "charlie"));
  };

  // 2 - PARAMS
  // using params to version => /person/params?version=1
  @GetMapping(value = "/person/param", params = "version=1")
  public PersonV1 paramV1() {
    return new PersonV1("Bob Charlie");
  }

  // using params to version => /person/params?version=2
  @GetMapping(value = "/person/param", params = "version=2")
  public PersonV2 paramV2() {
    return new PersonV2(new Name("bob", "charlie"));
  };

  // 3 - HEADERS
  // using headers to version =>
  // => /person/header w/header key:value => X-API-VERSION: 1
  @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
  public PersonV1 headerV1() {
    return new PersonV1("Bob Charlie");
  }

  // using headers to version =>
  // => /person/header w/header key:value => X-API-VERSION: 2
  @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
  public PersonV2 headerV2() {
    return new PersonV2(new Name("bob", "charlie"));
  };

  // 4 - PRODUCES
  // using headers to version =>
  // => /person/header w/header key:value => X-API-VERSION: 1
  @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
  public PersonV1 producesV1() {
    return new PersonV1("Bob Charlie");
  }

  // using headers to version =>
  // => /person/header w/header key:value => X-API-VERSION: 2
  @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
  public PersonV2 producesV2() {
    return new PersonV2(new Name("bob", "charlie"));
  };
}
