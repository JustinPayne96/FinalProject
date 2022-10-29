package com.promineotech.game.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.game.entity.GameDetails;
import com.promineotech.game.entity.GameESRB;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/games")
@OpenAPIDefinition(info = @Info(title = "Game Library"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface GameESRBController {
  // @formatter:off
  @Operation(
      summary = "Return a List of Games",
      description = "Return a List of Games based on ESRB Rating",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A List of Games is Returned.", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = GameDetails.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "Request Parameters are Invalid.", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Games were Found with Input Criteria.", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An Unplanned Error Occurred.", 
              content = @Content(mediaType = "application/json"))
          
      },
      parameters = {
          @Parameter(
              name = "ESRB", 
              allowEmptyValue = false, 
              required = false, 
              description = "The ESRB rating (i.e., 'EVERYONE')")
          
      }
  )

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<GameDetails> fetchGames(
      @RequestParam(required = false) 
        GameESRB ESRB);
  // @formatter:on
}
