package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.TweetDto;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.repositories.TweetRepository;

@Service
public class TweetService {
  
  @Autowired
  TweetRepository tweetRepository;

  public List<TweetModel> listAllTweets(int page){
    List<TweetModel> tweets = tweetRepository.findAll();
    return tweets;
  } 

  public Page<TweetModel> listTweetsFromPage(int page){
    Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
    Pageable dynamicPageWithTwoElements = PageRequest.of(page, 2);
    Page<TweetModel> tweets = tweetRepository.findAll(dynamicPageWithTwoElements);
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
