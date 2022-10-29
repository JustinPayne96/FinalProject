package com.promineotech.game.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameReview {
  private Long review_id;
  private int game_id;
  private String reviewer_name;
  private String reviewer_timestamp;
  private GameRating rating;
  private String review_text;
}
