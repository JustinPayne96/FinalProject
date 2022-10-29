package com.promineotech.game.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.game.entity.GameRating;
import com.promineotech.game.entity.GameReview;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/game")
@OpenAPIDefinition(info = @Info(title = "Game Review Library"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface GameRatingController {
  
  // @formatter:off
  @Operation(
      summary = "Returns a List of Reviews",
      description = "Returns a List of Review given an optional Rating and Game ID",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A List of Reviews is Returned", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = GameReview.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The Request Parameters are Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Reviews were Found with the Input Criteria", 
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
              name = "rating", 
              allowEmptyValue = false, 
              required = false, 
              description = "The Game Rating (i.e, 'ONE_STAR')"),
          @Parameter(
              name = "gameId", 
              allowEmptyValue = false, 
              required = false, 
              description = "The Game ID (i.e, 1)")          
      }
      )

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<GameReview> fetchGameReviews(
      @RequestParam(required = false) 
        GameRating rating,
      @RequestParam(required = false) 
        int gameId);
  // @formatter:on
}
