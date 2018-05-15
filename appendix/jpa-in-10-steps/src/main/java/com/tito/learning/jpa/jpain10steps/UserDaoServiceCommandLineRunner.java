package com.tito.learning.jpa.jpain10steps;

import com.tito.learning.jpa.jpain10steps.entity.User;
import com.tito.learning.jpa.jpain10steps.service.UserDAOService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {

  private static final org.slf4j.Logger log = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);

  @Autowired
  private UserDAOService userDAOService;

  @Override
  public void run(String... args) throws Exception {
    User user = new User("Jack", "Admin");
    // new user is created: User [id=1, name=Jack, role=Admin]
    long insert = userDAOService.insert(user);
    log.info("new User is created: " + user);
  }
}
