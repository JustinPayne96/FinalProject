package com.promineotech.game.controller;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import com.promineotech.game.controller.support.FetchGameTestSupport;
import com.promineotech.game.entity.GameDetails;
import com.promineotech.game.entity.GameESRB;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {"classpath:flyway/migrations/V1.0__Game_Schema.sql",
    "classpath:flyway/migrations/V1.1__Game_Data.sql"},
    config = @SqlConfig(encoding = "utf-8"))
class FetchGameTest extends FetchGameTestSupport {

  @Test
  void testThatGameIsReturnedWhenAValidESRBRatingIsSupplied() {
   
    //Given: A Valid Game ESRB Rating and URI
    GameESRB ESRB = GameESRB.TEEN;
    String uri = 
        String.format("%s?ESRB=%s", getBaseUri(), ESRB);
    
    // GameDetails.class
    //When: A Connection is Made to the URI
    ResponseEntity<List<GameDetails>> response =
    getRestTemplate().exchange(uri, HttpMethod.GET, null, 
        new ParameterizedTypeReference<>() {});
    
    //Then: A Successful (OK - 200) Status Code is Returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    // And: The Actual List Returned is the Same as the Expected List
    @SuppressWarnings("unused")
    List<GameDetails> actual = response.getBody();
    List<GameDetails> expected = buildExpected();
    
    assertThat(response.getBody()).isEqualTo(expected);
  }

  @Disabled
  @Test
  void testThatAnErrorMessageIsReturnedWhenAnUnknownESRBRatingIsSupplied() {
   
    //Given: A Valid Game ESRB Rating and URI
    GameESRB ESRB = GameESRB.ADULTS_ONLY_18PLUS;
    String uri = 
        String.format("%s?ESRB=%s", getBaseUri(), ESRB);
    
    // GameDetails.class
    //When: A Connection is Made to the URI
    ResponseEntity<Map<String, Object>> response =
    getRestTemplate().exchange(uri, HttpMethod.GET, null, 
        new ParameterizedTypeReference<>() {});
    
    //Then: A Not Found (404) Status Code is Returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    
    // And: An Error Message is Returned
    Map<String, Object> error = response.getBody();
    
    assertErrorMessageValid(error, HttpStatus.NOT_FOUND);
  }


}
