package com.tito.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigController {

  //read min & max values from the configuration
  //configuration currently found in application.properties
  @Autowired
  private Configuration configuration;

  @GetMapping("/limits")
  public LimitConfig retrieveLimitsFromConfig() {

    return new LimitConfig(configuration.getMaximum(), configuration.getMinimum());
  }
}
