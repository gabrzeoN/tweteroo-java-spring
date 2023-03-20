package com.tweteroo.api.dtos;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;

public record UserDto(
  @NotBlank
  String username,
  
  @NotBlank
  @URL(protocol = "http") // Won't work
  String avatarUrl
  ) {}
