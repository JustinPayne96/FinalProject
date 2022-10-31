package com.promineotech.game.controller;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import com.promineotech.game.controller.support.CreateGameReviewSupport;
import com.promineotech.game.entity.Review;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(
    scripts = {"classpath:flyway/migrations/V1.0__Game_Schema.sql",
        "classpath:flyway/migrations/V1.1__Game_Data.sql"},
    config = @SqlConfig(encoding = "utf-8"))
class CreateGameReviewTest extends CreateGameReviewSupport{

  /**
   * 
   */
  @Test
  void testCreateGameReviewReturnsSuccess201() {
    // Given: A Review as JSON
    String body = createReviewBody();
    String uri = getBaseUriForReviews();
    
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    
    HttpEntity<String> bodyEntity = new HttpEntity<>(body, headers);
    
    // When: Review is Sent
    ResponseEntity<Review> response = getRestTemplate().exchange(uri,
        HttpMethod.POST, bodyEntity, Review.class);
    
    // Then: A 201 Status is Returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    
    // And: the Returned Review is Correct
    assertThat(response.getBody()).isNotNull();
    
    @SuppressWarnings("unused")
    Review review = response.getBody();
  }


}
