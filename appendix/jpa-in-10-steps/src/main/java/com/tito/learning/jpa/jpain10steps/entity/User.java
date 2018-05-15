package com.tito.learning.jpa.jpain10steps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// map this to a table called 'User' in the database
// turn this class into and entity to accomplish

@Entity
public class User {

  @Id
  @GeneratedValue
  private long id;
  private String name;
  private String role;

  protected User() {

  }

  public User(String name, String role) {
    this.name = name;
    this.role = role;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", role='" + role + '\'' +
        '}';
  }
}
