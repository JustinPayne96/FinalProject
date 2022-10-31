package com.promineotech.game.controller.support;

public class CreateGameReviewSupport extends BaseGameTest{
  /**
   * 
   * @return
   */
  protected String createReviewBody() {
    // @formatter:off
        return "\n"
        + " \"gameId\":\"2\",\n"
        + " \"reviewerName\":\"Mister Chief\",\n"
        + " \"reviewerTimestamp\":\"2022-10-29\",\n"
        + " \"reviewRating\":\"4\",\n"
        + " \"reviewText\":\"Yeah!\",\n";
   // @formatter:on
  }
}
/*
"{\n"
        + "  \"customer\":\"STERN_TORO\",\n"
        + "  \"model\":\"CHEROKEE\",\n"
        + "  \"trim\":\"Altitude\",\n"
        + "  \"doors\":\"4\",\n"
        + "  \"color\":\"EXT_REDLINE\",\n"
        + "  \"engine\":\"3_6_GAS\",\n"
        + "  \"tire\":\"265_GOODYEAR\",\n"
        + "  \"options\":[\n"
        + "    \"TOP_MOPAR_POWER\",\n"
        + "    \"DOOR_BESTOP_ELEMENT_MIRROR\",\n"
        + "    \"DOOR_BODY_REAR\",\n"
        + "    \"DOOR_BODY_FRONT\"\n"
        + "  ]\n"

*/
