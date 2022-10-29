package com.promineotech.game.controller.support;

import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import com.promineotech.game.entity.GameDetails;
import com.promineotech.game.entity.GameESRB;

public class FetchGameTestSupport extends BaseGameTest {
  protected List<GameDetails> buildExpected() {
    List<GameDetails> list = new LinkedList<>();
    
    // @formatter:off  
    list.add(GameDetails.builder()
        .gameName("Gotham_Knights")
        .completionTime(new BigDecimal("020.00"))
        .gameOverview("Gotham Knights is a brand-new open world, third-person action RPG featuring the Batman Family as players step into the roles of Batgirl, Nightwing, Red Hood, and Robin, a new guard of trained DC Super Heroes who must rise up as the protectors of Gotham City in the wake of Batman's death. An expansive, criminal underworld has swept through the streets of Gotham, and it is now up to these new heroes to protect the city, bring hope to its citizens, discipline to its cops and fear to its criminals. Players must save Gotham from descent into chaos and reinvent themselves into their own version of the Dark Knight. - GameStop & Walmart")
        .ESRB(GameESRB.TEEN)
        .difficulty("NORMAL")
        .averageRating(06.4)
        .releaseDate("2022-10-21")
        .basePrice(new BigDecimal("069.99"))
        .build());
    
    list.add(GameDetails.builder()
        .gameName("Marvels_Spider-Man:Miles_Morales")
        .completionTime(new BigDecimal("012.00"))
        .gameOverview("Take on the mean streets of Manhattan as a new Spider-Man. Marvel's Spider-Man: Miles Morales introduces you to the rise of a new hero. In the latest adventure in the Spider-verse, teenager Miles Morales is adjusting to his new home while following in the footsteps of his mentor, Peter Parker. But when a fierce power struggle threatens to destroy his new home, the aspiring hero realizes that with great power, there must also come great responsibility. To save all of Marvel's New York, Miles must take up the mantle of Spider-Man and own it. - GameStop")
        .ESRB(GameESRB.TEEN)
        .difficulty("NORMAL")
        .averageRating(09.2)
        .releaseDate("2021-11-12")
        .basePrice(new BigDecimal("024.99"))
        .build());
    // @formatter:on
    
      Collections.sort(list);
    return list;
  }
  
  
  /**
   * 
   * @param error
   * @param status
   */
  protected void assertErrorMessageValid(Map<String, Object> error,
      HttpStatus status) {
    // @formatter:off
    assertThat(error)
      .containsKey("message")
      .containsEntry("status code", status.value())
      .containsEntry("uri", "/games")
      .containsKey("timestamp")
      .containsEntry("reason", status.getReasonPhrase());
    // @formatter:on
  }
}
