package com.promineotech.game.controller;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.game.entity.Review;
import com.promineotech.game.entity.ReviewRequest;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/review")
@OpenAPIDefinition(info = @Info(title = "Game Review Entry Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface GameReviewController {
  


  // @formatter:off
  @Operation(
      summary = "Create A Review for Game",
      description = "Returns the Create Review for Game",
      responses = {
          @ApiResponse(
              responseCode = "201", 
              description = "A Created Game Review is Returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Review.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The Request Parameters are Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "A Review was Not Found with the Input Criteria", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An Unplanned Error Occurred.", 
              content = @Content(
                  mediaType = "application/json"))
          
      },
      parameters = {
          @Parameter(
              name = "reviewRequest", 
              required = true, 
              description = "The Order as JSON")      
      }
      )

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Review createGameReview(@Valid @RequestBody ReviewRequest reviewRequest);
  // @formatter:on
  
  @DeleteMapping("/edit/delete")
  Map<String, Object> deleteGameReview(@RequestParam String reviewId);
  
  @PutMapping("/edit/update")
  Review updateGameReview(@RequestBody Review review);
}
