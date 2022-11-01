package com.promineotech.game.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.game.entity.Genre;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
class DefaultGenreDao implements GenreDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Genre> fetchGenres(String genreName) {
    log.debug("DAO: genreName={}", genreName);
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM genre "
        + "WHERE genre_name = :genre_name";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("genre_name", genreName);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
       // @formatter:off
        return Genre.builder()
            .genreId(rs.getLong("genre_id"))
            .genreName(rs.getString("genre_name"))
            .build();
        
       // @formatter:on
      }});
  }

}
