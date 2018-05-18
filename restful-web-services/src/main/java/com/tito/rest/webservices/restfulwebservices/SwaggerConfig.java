package com.tito.rest.webservices.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //Config file
@EnableSwagger2 //enable swagger
public class SwaggerConfig {
  @Bean //define a @Bean => Docket
  public Docket api() {
    //designate that the Docket bean be configured to use Swagger
    //all the paths
    //all the apis
    return new Docket(DocumentationType.SWAGGER_2);
  }
}
