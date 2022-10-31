package com.promineotech.game.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.game.entity.Genre;

@RestController
public class DefaultGenreController implements GenreController {

  @Override
  public List<Genre> fetchGenres(String genreName) {
    return null;
  }

}
