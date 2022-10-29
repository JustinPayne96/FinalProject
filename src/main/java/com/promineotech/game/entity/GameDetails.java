package com.promineotech.game.entity;

import java.math.BigDecimal;
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
public class GameDetails implements Comparable<GameDetails> {
  private Long gameId;
  private String gameName;
  private BigDecimal completionTime;
  private String gameOverview;
  private GameESRB ESRB;
  private String difficulty;
  private double averageRating;
  private String releaseDate;
  private BigDecimal basePrice;
  
  @JsonIgnore
  public Long getGameId() {
    return gameId;
  }

  @Override
  public int compareTo(GameDetails that) {   
    // @formatter:off
    return Comparator
        .comparing(GameDetails::getReleaseDate)
        .thenComparing(GameDetails::getGameName)
        .thenComparing(GameDetails::getGameOverview)
        .compare(this, that);
    // @formatter:on
  }

}
