package com.promineotech.game.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.game.entity.Genre;
import com.promineotech.game.service.GenreService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultGenreController implements GenreController {
  
  @Autowired
  private GenreService genreService;
  
  @Override
  public List<Genre> fetchGenres(String genreName) {
    log.debug("genreName={}", genreName);
    return genreService.fetchGenres(genreName);
  }

}
