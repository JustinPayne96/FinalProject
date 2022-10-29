package com.promineotech.game.service;

import java.util.List;
import com.promineotech.game.entity.GameRating;
import com.promineotech.game.entity.GameReview;

public interface GameReviewService {

  /**
   * 
   * @param rating
   * @param gameId
   * @return
   */
  List<GameReview> fetchGameReview(GameRating rating, int gameId);

}
