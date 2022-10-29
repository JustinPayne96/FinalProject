package com.promineotech.game.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.game.dao.GameReviewDao;
import com.promineotech.game.entity.GameRating;
import com.promineotech.game.entity.GameReview;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultGameReviewService implements GameReviewService {

  @Autowired
  private GameReviewDao gameReviewDao;
  
  @Override
  public List<GameReview> fetchGameReview(GameRating rating, int gameId) {
    log.info("The fetchGameReview method was called with rating={} and gameId={}",
        rating, gameId);
    
    return gameReviewDao.fetchGameReview(rating, gameId);
  }

}
