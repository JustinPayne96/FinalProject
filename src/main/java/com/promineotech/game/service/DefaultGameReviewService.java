package com.promineotech.game.service;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.game.dao.GameReviewDao;
import com.promineotech.game.entity.Review;
import com.promineotech.game.entity.ReviewRequest;
import com.promineotech.game.entity.ReviewerName;

@Service
public class DefaultGameReviewService implements GameReviewService {

  @Autowired
  private GameReviewDao gameReviewDao;
  
  @Transactional
  @Override
  public Review createReview(ReviewRequest reviewRequest) {
   ReviewerName reviewerName = gameReviewDao.fetchReviewer(reviewRequest.getReviewerName());
    
    return null;
  }

  @Transactional(readOnly = false)
  @Override
  public void deleteGameReview(String reviewId) {
    if(!gameReviewDao.deleteGameReview(reviewId)) {
      throw new NoSuchElementException(
          "Review with ID=" + reviewId + " does not exist.");
    }
  }

  @Override
  public Review updateGameReview(Review review) {
    if(!gameReviewDao.updateGameReview(review)) {
      throw new NoSuchElementException(
          "Review with ID=" + review.getReviewId() + " does not exist.");
    
  }
    return review;
  }
}
