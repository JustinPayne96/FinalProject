package com.promineotech.game.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.game.entity.GameDetails;
import com.promineotech.game.entity.GameESRB;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultGameDao implements GameDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<GameDetails> fetchGames(GameESRB ESRB) {
    log.debug("DAO: ESRB={}", ESRB);
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM game "
        + "WHERE esrb_rating = :esrb_rating";
    // @formatter:on
    
   Map<String, Object> params = new HashMap<>();
   params.put("esrb_rating", ESRB.toString());
    
    return jdbcTemplate.query(sql, params,
        new RowMapper<>() {
          @Override
          public GameDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
            // @formatter:off
            return GameDetails.builder()
                .gameId(rs.getLong("game_id"))
                .gameName(rs.getString("game_name"))
                .completionTime(new BigDecimal(rs.getString("estimated_completion_time")))
                .gameOverview(rs.getString("game_overview"))
                .ESRB(GameESRB.valueOf(rs.getString("esrb_rating")))
                .difficulty(rs.getString("difficulty"))
                .averageRating(rs.getDouble("average_rating"))
                .releaseDate(rs.getString("release_date"))
                .basePrice(new BigDecimal(rs.getString("price")))
                .build();
            // @formatter:on
          }});
  }

}
