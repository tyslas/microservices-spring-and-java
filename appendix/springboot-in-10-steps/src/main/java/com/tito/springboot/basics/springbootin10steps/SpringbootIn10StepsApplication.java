package com.tito.springboot.basics.springbootin10steps;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootIn10StepsApplication {

	public static void main(String[] args) {
    ApplicationContext applicationContext = SpringApplication.run(SpringbootIn10StepsApplication.class, args);

    for (String name : applicationContext.getBeanDefinitionNames()) {
      System.out.println(name);
    }
	}
}
