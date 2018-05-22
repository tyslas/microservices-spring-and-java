package com.tito.rest.webservices.restfulwebservices.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@ApiModel(description = "all details about the user")
@Entity
public class User {

  @Id
  @GeneratedValue
  private Integer id;

  @Size(min=2, message = "name should have at least 2 characters")
  @ApiModelProperty(notes = "name should have at least 2 characters")
  private String name;

  @Past
  @ApiModelProperty(notes = "birth should be previous to the current time of selection")
  private Date birthDate;

  @OneToMany(mappedBy = "user")
  private List<Post> posts;

  protected User() {
  }

  public User(Integer id, String name, Date birthDate) {
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public List<Post> getPosts() {
    return posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", birthDate=" + birthDate +
        '}';
  }
}
