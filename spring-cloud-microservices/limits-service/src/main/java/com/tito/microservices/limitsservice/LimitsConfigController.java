package com.tito.microservices.limitsservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigController {

  @GetMapping("/limits")
  public LimitConfig retrieveLimitsFromConfig() {

    return new LimitConfig(1000, 1);
  }
}
