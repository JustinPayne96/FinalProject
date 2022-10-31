package com.promineotech.game.service;

import com.promineotech.game.entity.Review;
import com.promineotech.game.entity.ReviewRequest;

public interface GameReviewService {

  Review createReview(ReviewRequest reviewRequest);

  void deleteGameReview(String reviewId);

  Review updateGameReview(Review review);

}
