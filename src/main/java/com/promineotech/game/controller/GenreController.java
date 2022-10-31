package com.promineotech.game.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.game.entity.Genre;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/genre")
@OpenAPIDefinition(info = @Info(title = "Genre Library"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface GenreController {
  // @formatter:off
  @Operation(
      summary = "Returns a List of Genres",
      description = "Returns a List of Genres given an optional Genre Name",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A List of Genres is Returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Genre.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The Request Parameters are Invalid", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Genre was Found with the Input Criteria", 
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
              name = "genreName", 
              allowEmptyValue = false, 
              required = false, 
              description = "The Genre name (i.e., 'Action')"),
      }      
      )
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Genre> fetchGenres(
      @RequestParam(required = false) 
        String genreName);
//@formatter:on
}
