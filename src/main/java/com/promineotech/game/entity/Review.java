package com.promineotech.game.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {
  private GameReview review;
  private Long reviewId;
  private int gameId;
  private String reviewerName;
  private String reviewerTimestamp;
  private GameRating rating;
  private String reviewText;
  
  @JsonIgnore
  public Long getReviewId() {
    return reviewId;
  

  }
  }

