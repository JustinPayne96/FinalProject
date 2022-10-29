package com.promineotech.game.controller.support;

import java.util.LinkedList;
import java.util.List;
import com.promineotech.game.entity.GameRating;
import com.promineotech.game.entity.GameReview;

public class FetchGameReviewTestSupport extends BaseGameTest {

  protected List<GameReview> buildExpected() {
    List<GameReview> list = new LinkedList<>();
    
    // @formatter:off
    list.add(GameReview.builder()
        .game_id(3)
        .reviewer_name("Mister Chief")
        .reviewer_timestamp("2022-08-26")
        .rating(GameRating.FIVE_STARS)
        .review_text("A fresh breath of air from a long standing franchise")
        .build());
    
    
    list.add(GameReview.builder()
        .game_id(3)
        .reviewer_name("Jannie0130")
        .reviewer_timestamp("2022-08-23")
        .rating(GameRating.FIVE_STARS)
        .review_text("It's super fun to play even if you're not a super Pokemon fan or if you don't know much about Pokemon")
        .build());
    // @formatter:on
    return list;
  }

}
//INSERT INTO review (game_id, reviewer_name, reviewer_timestamp, review_rating, review_text) VALUES (3, 'Jannie0130', '2022-08-23', 'FIVE_STARS', 'It''s super fun to play even if you''re not a super Pokemon fan or if you don''t know much about Pokemon');
