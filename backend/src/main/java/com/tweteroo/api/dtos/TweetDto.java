package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record TweetDto(
  @NotBlank String username,
  @NotBlank String tweet
  ) {
}
