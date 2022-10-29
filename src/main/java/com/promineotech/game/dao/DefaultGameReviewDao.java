package com.promineotech.game.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import com.promineotech.game.entity.GameRating;
import com.promineotech.game.entity.GameReview;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultGameReviewDao implements GameReviewDao {

  @Override
  public List<GameReview> fetchGameReview(GameRating rating, int gameId) {
    log.debug("DAO: rating={}, gameId={}", rating, gameId);
    return null;
  }

}
