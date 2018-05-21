package com.tito.rest.webservices.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration //Config file
@EnableSwagger2 //enable swagger
public class SwaggerConfig {

  public static final Contact DEFAULT_CONTACT = new Contact("Fred Flintstone", "fred.feet", "fred@flintstone.com");
  private static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
      "Awesome API Title", "Awesome API Description", "1.1",
      "wwww.termsofservice.url", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
  private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json", "application/xml"));

  @Bean //define a @Bean => Docket
  public Docket api() {
    //designate that the Docket bean be configured to use Swagger
    //all the paths
    //all the apis
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(DEFAULT_API_INFO)
        .produces(DEFAULT_PRODUCES_AND_CONSUMES)
        .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
  }
}
