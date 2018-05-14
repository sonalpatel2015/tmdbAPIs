package org.themoviedb.tv_seasons;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.themoviedb.constants.Path;
import org.themoviedb.core.BaseClass;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.themoviedb.common.RestUtilities.createPathParam;
import static org.themoviedb.common.RestUtilities.setEndPoint;
import static org.themoviedb.constants.EndPoints.TV_SEASON_GET_DETAILS;


public class tmdb_getDetailsApiTest extends BaseClass {

  int valid_tv_id = 2316;
  int valid_season_number = 9;
  int invalid_season_number = 15;

  @BeforeClass
  public void pathForGetDetails() {
    reqSpec.basePath(Path.TV_SEASON);
    setEndPoint(TV_SEASON_GET_DETAILS);
  }

  /*
    Below test will log the full response and also verify
    1. Status code is 200
    2. Response time of the api is less than 5 seconds
    Both of above are inbuilt into framework and will be executed for every test
   */
  @Test
  public void statusCodeVerificationWithValidData() {
    given()
      .spec(createPathParam(reqSpec, "tv_id", valid_tv_id))
      .spec(createPathParam(reqSpec, "season_number", valid_season_number))
    .then()
      // Below line can be removed. I intentionally leave 1 line so in case of debugging purpose
      .log().all()
      .spec(resSpec);
  }

  /*
    Verifying wrong Season Number and correct TV_ID returns 404 page
   */
  @Test
  public void validTVIdWrongSeasonNumber() {
    given()
      .spec(createPathParam(reqSpec, "tv_id", valid_tv_id))
      .spec(createPathParam(reqSpec, "season_number", invalid_season_number))
    .then()
      .spec(expect().statusCode(404));
  }

  /*
    This is to verify that api returns number of episode in given season are correct
   */
  @Test
  public void verifyNumberOfEpisodesAreCorrect() {
    given()
      .spec(createPathParam(reqSpec, "tv_id", valid_tv_id))
      .spec(createPathParam(reqSpec, "season_number", valid_season_number))
    .then()
      .spec(resSpec)
      .body("episodes.size()", equalTo(23));
  }

  /*
    This is to verify that api actually returns correct Season details
   */
  @Test
  public void verifyItReturnsCorrectSeason() {
    given()
      .spec(createPathParam(reqSpec, "tv_id", valid_tv_id))
      .spec(createPathParam(reqSpec, "season_number", valid_season_number))
    .then()
      .spec(resSpec)
      .body("season_number", equalTo(valid_season_number),
            "name", containsString("Season 9")); // 2nd Assertion is not necessary but this is how you can do soft assertion
  }
}
