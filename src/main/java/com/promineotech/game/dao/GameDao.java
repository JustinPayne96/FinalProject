package com.promineotech.game.dao;

import java.util.List;
import com.promineotech.game.entity.GameDetails;
import com.promineotech.game.entity.GameESRB;

public interface GameDao {

  /**
   * 
   * @param ESRB
   * @return
   */
  List<GameDetails> fetchGames(GameESRB ESRB);

}
