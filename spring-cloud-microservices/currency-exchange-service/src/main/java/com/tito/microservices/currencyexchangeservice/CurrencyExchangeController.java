package com.tito.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController //allows us to accept JSON requests and send JSON back out
public class CurrencyExchangeController {

  @Autowired
  private Environment environment;

  @Autowired
  private ExchangeValueRepository repository;

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
//    ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65)); //return hard coded bean for exchange value

    ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);

    exchangeValue
        .setPort(Integer.parseInt(environment.getProperty("local.server.port")));
    return exchangeValue;
  }
}
