package com.promineotech.game.dao;

import java.util.List;
import com.promineotech.game.entity.Genre;

public interface GenreDao {

  /**
   * 
   * @param genreName
   * @return
   */
  List<Genre> fetchGenres(String genreName);

}
