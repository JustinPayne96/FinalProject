package com.promineotech.game.entity;

import java.util.Comparator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameReview implements Comparable<GameReview> {
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

  @Override
  public int compareTo(GameReview that) {
    // @formatter:off
    return Comparator
        .comparing(GameReview::getGameId)
        .thenComparing(GameReview::getRating)
        .compare(this, that);
    // @formatter:on
  }
}
