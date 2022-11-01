package com.promineotech.game.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.game.entity.GameReview;
import com.promineotech.game.entity.Review;
import com.promineotech.game.entity.ReviewerName;

@Component
public class DefaultGameReviewDao implements GameReviewDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public ReviewerName fetchReviewer(@NotNull String reviewerName) {
    String sql = ""
        + "SELECT * "
        + "FROM review "
        + "WHERE reviewerName = :reviewerName";
    
    Map<String, Object> params = new HashMap<>();
    params.put("reviewerName", reviewerName);
    
    return jdbcTemplate.query(sql, params, new ReviewerNameResultSetExtractor());
  }
  
  class ReviewerNameResultSetExtractor implements ResultSetExtractor<ReviewerName>{
    @Override
    public ReviewerName extractData(ResultSet rs)
        throws SQLException, DataAccessException {
     rs.next();
     
     // @formatter:off
     return ReviewerName.builder()
         .reviewerName(rs.getString("reviewerName"))
         .build();
     // @formatter:on
    
    }
    
  }

  @Override
  public boolean deleteGameReview(String reviewId) {
    String sql = """
            DELETE
            FROM review
            WHERE review_id = :review_id
            """;
    Map<String, Object> params = Map.of("review_id", reviewId.toString());
    
    return jdbcTemplate.update(sql, params) == 1;
  }

  @Override
  public boolean updateGameReview(Review review) {
    String sql = """
            UPDATE review SET
              game_id = :game_id,
              reviewer_name = :reviewer_name,
              review_rating = :review_rating,
              reviewer_timestamp = :reviewer_timestamp,
              review_text = :review_text,
            WHERE review_id = :review_id
            """;
    
    // @formatter:off
    Map<String, Object> params =
        Map.of(    
            "game_id", review.getGameId(),
            "reviewer_name", review.getReviewerName(), 
            "review_rating", review.getRating().toString(),
            "reviewer_timestamp", review.getReviewerTimestamp(),
            "review_text", review.getReviewText(),
            "review_id", review.getReviewId()
            );
    // @formatter:on
    
    return jdbcTemplate.update(sql, params) == 1;
  } 
  }

