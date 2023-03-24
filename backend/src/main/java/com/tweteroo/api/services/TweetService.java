package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.TweetDto;
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

  public List<TweetModel> listTweetsFromUser(String username){
    List<TweetModel> tweets = tweetRepository.findByUsername(username);
    return tweets;
  } 

  public void postTweet(TweetDto newTweet){
    tweetRepository.save(new TweetModel(newTweet));
    return;
  }
}
