package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.services.TweetService;

@RestController
@RequestMapping(value = "/tweets")
public class TweetController {
  
  @Autowired
  TweetService tweetService;

  @GetMapping()
  public List<TweetModel> listAllTweets(){
    return tweetService.listAll();
  }

}
