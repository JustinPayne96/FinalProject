package com.promineotech.game.service;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.game.dao.GenreDao;
import com.promineotech.game.entity.Genre;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultGenreService implements GenreService {
  
  @Autowired
  private GenreDao genreDao;

  @Override
  public List<Genre> fetchGenres(String genreName) {
    log.info("The fetchGenres method was called with genreName={}", genreName);
   
    List<Genre> genres = genreDao.fetchGenres(genreName);
    
     Collections.sort(genres);
     return genres;
  }

}
