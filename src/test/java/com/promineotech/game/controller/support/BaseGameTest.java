package com.promineotech.game.controller.support;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import lombok.Getter;

public class BaseGameTest {
  @LocalServerPort
  private int serverPort;
  
  @Autowired
  @Getter
  private TestRestTemplate restTemplate;
  /**
   * 
   * @return
   */
  protected String getBaseUriForGames() {
    return String.format("http://localhost:%d/game", serverPort);
  }
  /**
   * 
   * @return
   */
  protected String getBaseUriForReviews() {
    return String.format("http://localhost:%d/review", serverPort);
  }
}
