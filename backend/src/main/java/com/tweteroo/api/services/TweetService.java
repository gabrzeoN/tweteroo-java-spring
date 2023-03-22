package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.repositories.TweetRepository;

@Service
public class TweetService {
  
  @Autowired
  TweetRepository tweetRepository;

  public List<TweetModel> listAll(){
    List<TweetModel> tweets = tweetRepository.findAll();
    return tweets;
  }  
}
