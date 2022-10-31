package com.promineotech.game.controller.support;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import com.promineotech.game.entity.GameRating;
import com.promineotech.game.entity.GameReview;

public class FetchGameReviewTestSupport extends BaseGameTest {

  protected List<GameReview> buildExpected() {
    List<GameReview> list = new LinkedList<>();
    
    // @formatter:off
    list.add(GameReview.builder()
        .gameId(3)
        .reviewerName("Mister Chief")
        .reviewerTimestamp("2022-08-26")
        .rating(GameRating.FIVE_STARS)
        .reviewText("A fresh breath of air from a long standing franchise")
        .build());
    
    
    list.add(GameReview.builder()
        .gameId(3)
        .reviewerName("Jannie0130")
        .reviewerTimestamp("2022-08-23")
        .rating(GameRating.FIVE_STARS)
        .reviewText("It's super fun to play even if you're not a super Pokemon fan or if you don't know much about Pokemon")
        .build());
    // @formatter:on
    Collections.sort(list);
    return list;
  }
  
  /**
   * 
   * @param error
   * @param status
   */
  protected void assertErrorMessageValid(Map<String, Object> error, HttpStatus status) {
    // @formatter:off
    assertThat(error)
    .containsKey("message")
    .containsEntry("status code", status.value())
    .containsEntry("uri", "/game/review")
    .containsKey("timestamp")
    .containsEntry("reason", status.getReasonPhrase());
    // @formatter:on
}
}
