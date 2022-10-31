package com.promineotech.game.dao;

import javax.validation.constraints.NotNull;
import com.promineotech.game.entity.Review;
import com.promineotech.game.entity.ReviewerName;

public interface GameReviewDao {

  ReviewerName fetchReviewer(@NotNull String reviewerName);

  boolean deleteGameReview(String reviewId);

  boolean updateGameReview(Review review);


 

 
}
