package com.tweteroo.api.models;

import java.util.List;

import com.tweteroo.api.dtos.UserDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class UserModel {

  public UserModel(UserDto data) {
    this.username = data.username();
    this.avatar = data.avatar();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 20, nullable = false)
  private String username;

  @Column(length = 200, nullable = false)
  private String avatar;

  @OneToMany(mappedBy = "user")
  private List<TweetModel> tweets;
  
}
