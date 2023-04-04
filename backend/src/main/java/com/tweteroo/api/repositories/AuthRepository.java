package com.tweteroo.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.models.UserModel;

public interface AuthRepository extends JpaRepository<UserModel, Long> {
  UserModel findByUsername(String username);
  

}
