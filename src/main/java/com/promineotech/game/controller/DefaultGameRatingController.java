package com.promineotech.game.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.game.entity.GameRating;
import com.promineotech.game.entity.GameReview;
import com.promineotech.game.service.GameReviewService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultGameRatingController implements GameRatingController {

  @Autowired
  private GameReviewService gameReviewService;
  
  @Override
  public List<GameReview> fetchGameReviews(GameRating rating, int gameId) {
    log.debug("rating={}, gameId={}", rating, gameId);
    return gameReviewService.fetchGameReview(rating, gameId);
  }

}
