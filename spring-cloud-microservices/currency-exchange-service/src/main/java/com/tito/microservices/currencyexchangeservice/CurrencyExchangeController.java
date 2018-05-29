package com.tito.microservices.currencyexchangeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController //allows us to accept JSON requests and send JSON back out
public class CurrencyExchangeController {

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
    return new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65)); //return hard coded bean for exchange value
  }
}
