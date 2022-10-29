package com.promineotech.game.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.game.dao.GameDao;
import com.promineotech.game.entity.GameDetails;
import com.promineotech.game.entity.GameESRB;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultGameService implements GameService {

  @Autowired
  private GameDao gameDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<GameDetails> fetchGames(GameESRB ESRB) {
    log.info("The fetchGames method was called with ESRB={}", ESRB);
    
    List<GameDetails> gameDetails =  gameDao.fetchGames(ESRB);
    
    if(gameDetails.isEmpty()) {
      String msg = String.format("No games were found with ESRB=%s", ESRB);
      throw new NoSuchElementException(msg);
    }
    
    Collections.sort(gameDetails);
    return gameDetails;
  }

}
