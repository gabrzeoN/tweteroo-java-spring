package com.tweteroo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.models.UserModel;

public interface AuthRepository extends JpaRepository<UserModel, Long> {
  
}
