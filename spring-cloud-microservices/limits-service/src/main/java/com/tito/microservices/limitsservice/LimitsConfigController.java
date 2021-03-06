package com.tito.microservices.limitsservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigController {

  //read min & max values from the configuration
  //configuration currently found in bootstrap.properties
  @Autowired
  private Configuration configuration;

  @GetMapping("/limits")
  public LimitConfig retrieveLimitsFromConfig() {

    return new LimitConfig(configuration.getMaximum(), configuration.getMinimum());
  }

  @GetMapping("/fault-tolerance-example")
  @HystrixCommand(fallbackMethod = "fallbackRetrieveConfig")
  public LimitConfig retrieveConfiguration() {
    throw new RuntimeException("not available");
  }


  public LimitConfig fallbackRetrieveConfig() {
    return new LimitConfig(999, 9);
  }
}
