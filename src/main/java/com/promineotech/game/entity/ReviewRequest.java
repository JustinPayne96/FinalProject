package com.promineotech.game.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import lombok.Data;

@Data
public class ReviewRequest {
  @NotNull
  @Max(30)
  private Long gameId;
  
  @NotNull
  @Length(max = 30)
  private String reviewerName;
  
  @NotNull
  @Pattern(regexp = "[\\w\\s]*")
  @Length(max = 16)
  private String timeStamp;
  
  @NotNull
  @Length(max = 30)
  @Pattern(regexp = "[A-Z_]")
  private GameRating rating;
  
  @NotNull
  @Length(max = 200)
  @Pattern(regexp = "[\\w\\s]")
  private String reviewText;
}
