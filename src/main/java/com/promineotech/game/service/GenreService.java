package com.promineotech.game.service;

import java.util.List;
import com.promineotech.game.entity.Genre;

public interface GenreService {

  
  /**
   * 
   * @param genreName
   * @return
   */
  List<Genre> fetchGenres(String genreName);

}
