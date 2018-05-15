package com.tito.learning.jpa.jpain10steps;

import com.tito.learning.jpa.jpain10steps.entity.User;
import com.tito.learning.jpa.jpain10steps.service.UserDAOService;
import com.tito.learning.jpa.jpain10steps.service.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

  private static final org.slf4j.Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(String... args) throws Exception {
    User user = new User("Jill", "Admin");
    // new user is created: User [id=1, name=Jack, role=Admin]
    userRepository.save(user);
    log.info("new User is created: " + user);
  }
}
