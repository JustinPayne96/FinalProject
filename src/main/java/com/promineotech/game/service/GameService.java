package com.promineotech.game.service;

import java.util.List;
import com.promineotech.game.entity.GameDetails;
import com.promineotech.game.entity.GameESRB;

public interface GameService {

  /*
   * 
   * @param ESRB
   * @return
   */
  List<GameDetails> fetchGames(GameESRB ESRB);

}
