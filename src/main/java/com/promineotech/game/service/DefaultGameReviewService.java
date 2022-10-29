package com.promineotech.game.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.game.dao.GameReviewDao;
import com.promineotech.game.entity.GameRating;
import com.promineotech.game.entity.GameReview;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultGameReviewService implements GameReviewService {

  @Autowired
  private GameReviewDao gameReviewDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<GameReview> fetchGameReview(GameRating rating, int gameId) {
    log.info("The fetchGameReview method was called with rating={} and gameId={}",
        rating, gameId);
    
    List<GameReview> gameReview = gameReviewDao.fetchGameReview(rating, gameId);
    
    if(gameReview.isEmpty()) {
      String msg = String.format("No Game Reviews found with rating=%s and gameId=%s",
          rating, gameId);
      
      throw new NoSuchElementException(msg);
    }
    
    Collections.sort(gameReview);
    return gameReview;
  }

}
