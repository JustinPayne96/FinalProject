package com.promineotech.game.dao;

import java.util.List;
import com.promineotech.game.entity.GameRating;
import com.promineotech.game.entity.GameReview;

public interface GameReviewDao {

  /**
   * 
   * @param rating
   * @param gameId
   * @return
   */
  List<GameReview> fetchGameReview(GameRating rating, int gameId);

}
