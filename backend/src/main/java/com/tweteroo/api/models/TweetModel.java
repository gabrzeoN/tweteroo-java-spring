package com.tweteroo.api.models;

import com.tweteroo.api.dtos.TweetDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class TweetModel {
  
  public TweetModel(){
  }

  public TweetModel(TweetDto data){
    this.username = data.username();
    this.tweet = data.tweet();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 200, nullable = false)
  private String username;

  @Column(length = 200, nullable = false)
  private String tweet;

  @ManyToOne
  private UserModel user;

}
