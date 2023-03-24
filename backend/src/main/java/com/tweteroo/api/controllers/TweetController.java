package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweetDto;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class TweetController {
  
  @Autowired
  TweetService tweetService;

  @GetMapping("/tweets")
  public List<TweetModel> listAllTweets(){
    List<TweetModel> tweets = tweetService.listAll();
    return tweets;
  }

  @GetMapping("/tweets/{username}")
  public List<TweetModel> listAllTweets(@PathVariable String username){
    List<TweetModel> tweets = tweetService.listTweetsFromUser(username);
    return tweets;
  }

  @PostMapping("/tweets")
  public void postTweet(@RequestBody @Valid TweetDto data){
    tweetService.postTweet(data);
    return;
  }
}
