package com.promineotech.game.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import com.promineotech.game.controller.support.FetchGameReviewTestSupport;
import com.promineotech.game.entity.GameRating;
import com.promineotech.game.entity.GameReview;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(
    scripts = {"classpath:flyway/migrations/V1.0__Game_Schema.sql",
        "classpath:flyway/migrations/V1.1__Game_Data.sql"},
    config = @SqlConfig(encoding = "utf-8"))
class FetchGameReviewTest extends FetchGameReviewTestSupport {


  @Test
  void testThatReviewsAreReturnedWhenAValidRatingAndGameAreSupplied() {
    
    // Given: A Valid Game, Rating, and URI
    GameRating rating = GameRating.FIVE_STARS;
    int gameId = 3;
    String uri = 
        String.format("%s?rating=%s&gameId=%s", "/game/review", rating, gameId);
    
    // GameReview.class
    // When: A Connection is Made to the URI
    ResponseEntity<List<GameReview>> response =
        getRestTemplate().exchange(uri, HttpMethod.GET, null,
            new ParameterizedTypeReference<>() {});
    
    // Then: A Success (OK - 200) Status Code is Returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    // And: The Actual List Returned is the Same as the Expected List
    List<GameReview> actual = response.getBody();
    List<GameReview> expected = buildExpected();
    
    assertThat(actual).isEqualTo(expected);
  }
  
  @Test
  void testThatAnErrorMessageIsReturnedWhenAnUnknownGameIsSupplied() {
    
    // Given: A Valid Game, Rating, and URI
    GameRating rating = GameRating.FIVE_STARS;
    int gameId = 20;
    String uri = 
        String.format("%s?rating=%s&gameId=%s", "/game/review", rating, gameId);
    
    // GameReview.class
    // When: A Connection is Made to the URI
    ResponseEntity<Map<String, Object>> response =
        getRestTemplate().exchange(uri, HttpMethod.GET, null,
            new ParameterizedTypeReference<>() {});
    
    // Then: A Not Found (404) Status Code is Returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    
    // And: An Error Message is Returned
    Map<String, Object> error = response.getBody();
    
    assertErrorMessageValid(error, HttpStatus.NOT_FOUND);
  }

  
  @ParameterizedTest
  @MethodSource("com.promineotech.game.controller.FetchGameReviewTest#parametersForInvalidInput")
  void testThatAnErrorMessageIsReturnedWhenAnInvalidGameIsSupplied(
      String rating, String gameId, String reason) {
    
    // Given: A Valid Game, Rating, and URI
    String uri = 
        String.format("%s?rating=%s&gameId=%s", "/game/review", rating, gameId);
    
    // GameReview.class
    // When: A Connection is Made to the URI
    ResponseEntity<Map<String, Object>> response =
        getRestTemplate().exchange(uri, HttpMethod.GET, null,
            new ParameterizedTypeReference<>() {});
    
    // Then: A Not Found (400) Status Code is Returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    
    // And: An Error Message is Returned
    Map<String, Object> error = response.getBody();
    assertErrorMessageValid(error, HttpStatus.BAD_REQUEST);
  }
  
  static Stream<Arguments> parametersForInvalidInput(){
    
    // @formatter:off
    return Stream.of(
            arguments("FIVE_STARS", "A@#%$d" , "Game Identifier contains non-numeric characters")
    // @formatter:on
        );
  }
  }

