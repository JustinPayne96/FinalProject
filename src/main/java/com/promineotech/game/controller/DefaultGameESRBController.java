package com.promineotech.game.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.game.entity.GameDetails;
import com.promineotech.game.entity.GameESRB;
import com.promineotech.game.service.GameService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultGameESRBController implements GameESRBController {

  @Autowired
  private GameService gameService;
  
  @Override
  public List<GameDetails> fetchGames(GameESRB ESRB) {
    log.debug("ESRB={}", ESRB);
    return gameService.fetchGames(ESRB);
  }

}
