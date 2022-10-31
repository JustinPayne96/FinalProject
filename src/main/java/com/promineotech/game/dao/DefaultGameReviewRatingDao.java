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
import com.promineotech.game.entity.GameRating;
import com.promineotech.game.entity.GameReview;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultGameReviewRatingDao implements GameReviewRatingDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<GameReview> fetchGameReview(GameRating rating, int gameId) {
    log.debug("DAO: rating={}, gameId={}", rating, gameId);
    
    // @formatter: off
    String sql = ""
        + "SELECT * "
        + "FROM review "
        + "WHERE review_rating = :review_rating AND game_id = :game_id";
    // @formatter: on
    
    Map<String, Object> params = new HashMap<>();
    params.put("review_rating", rating.toString());
    params.put("game_id", gameId);
   
     
    return jdbcTemplate.query(sql, params,
        new RowMapper<>() {
          @Override
          public GameReview mapRow(ResultSet rs, int rowNum) throws SQLException {
            // @formatter:off
            return GameReview.builder()
                .gameId(rs.getInt("game_id"))
                .reviewerName(rs.getString("reviewer_name"))
                .reviewerTimestamp(rs.getString("reviewer_timestamp"))
                .rating(GameRating.valueOf(rs.getString("review_rating")))
                .reviewText(rs.getString("review_text"))
                .build();
            // @formatter:on
          }});
  }

}
