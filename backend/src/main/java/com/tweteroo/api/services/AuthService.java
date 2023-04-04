package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.tweteroo.api.dtos.UserDto;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repositories.AuthRepository;

@Service
public class AuthService {
  
  @Autowired
  private AuthRepository authRepository;
  
  public UserModel create(UserDto data){
    this.mustNotExistByUsername(data.username());
    UserModel user = new UserModel(data);
    UserModel userDb = authRepository.save(user);
    TweetModel tweet = new TweetModel();
    System.out.println(user.getTweets());
    // System.out.println(user.getTweets().add(tweet));
    
    // System.out.println(authRepository.findAll());
    return userDb;
  }
  
  public List<UserModel> listAllUsers(){
    UserModel user = new UserModel();
    return authRepository.findAll();
  }

  private void mustNotExistByUsername(String username){
      UserModel user = authRepository.findByUsername(username);
      if(user != null){
        throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already registred!");
      }
    return;
  }
}
