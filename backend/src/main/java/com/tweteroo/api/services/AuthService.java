package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.UserDto;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repositories.AuthRepository;

@Service
public class AuthService {
  
  @Autowired
  private AuthRepository authRepository;

  public UserModel create(UserDto data){
    UserModel user = new UserModel(data);
    System.out.println(user);
    // System.out.println(authRepository.findAll());
    return authRepository.save(user);
  }

  public List<UserModel> listAllUsers(){
    return authRepository.findAll();
  }
}
