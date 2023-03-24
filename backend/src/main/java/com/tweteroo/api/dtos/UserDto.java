package com.tweteroo.api.dtos;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;

public record UserDto(

  @NotBlank
  String username,
  
  @URL(protocol = "https")
  @NotBlank
  String avatar
  ) {

  }
  
