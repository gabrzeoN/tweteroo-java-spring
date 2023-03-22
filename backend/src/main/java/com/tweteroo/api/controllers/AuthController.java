package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.UserDto;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.services.AuthService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
  
  @Autowired
  private AuthService authService;

  @PostMapping("/sign-up")
  public UserModel createUser(@RequestBody @Valid UserDto req){
    return authService.create(req);
  }

  @GetMapping(value="users")
  public List<UserModel> getAllUsers() {
      return authService.listAllUsers();
  }
  

}
