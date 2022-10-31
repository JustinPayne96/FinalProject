package com.promineotech.game.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.game.entity.Review;
import com.promineotech.game.entity.ReviewRequest;
import com.promineotech.game.service.GameReviewService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultGameReviewController implements GameReviewController {

  @Autowired
  private GameReviewService gameReviewService;
  
  @Override
  public Review createGameReview(ReviewRequest reviewRequest) {
    log.debug("Review={}", reviewRequest);
    return gameReviewService.createReview(reviewRequest);
  }

  @Override
  public Map<String, Object> deleteGameReview(String reviewId) {
    gameReviewService.deleteGameReview(reviewId);
    return Map.of("Message", "Review with ID=" + reviewId + " was successfully deleted.");
  }

  @Override
  public Review updateGameReview(Review review) {
    log.info("Updating review {}", review);
    return gameReviewService.updateGameReview(review);
  }

}
