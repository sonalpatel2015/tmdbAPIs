package org.themoviedb.tv_seasons;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;
import static org.themoviedb.common.RestUtilities.createPathParam;
import static org.themoviedb.common.RestUtilities.getResponse;
import static org.themoviedb.common.RestUtilities.setEndPoint;
import static org.themoviedb.constants.EndPoints.TV_SEASON_GET_DETAILS;
import static org.themoviedb.constants.EndPoints.TV_SEASON_GET_EXTERNAL_IDS;

import io.restassured.response.Response;
import org.hamcrest.core.IsNull;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.themoviedb.core.BaseClass;


public class tmdb_getExternalIdsApiTest extends BaseClass {

  int valid_tv_id = 2316;
  int valid_season_number = 9;

  @BeforeClass
  public void pathForGetDetails() {
    setEndPoint(TV_SEASON_GET_EXTERNAL_IDS);
  }



  /*
    This will verify that all external IDs are returned in the response
  */
  @Test
  public void verifyResponseReturnsExternalIds() {
    /**
     *  My Framework also supports different way to get response and use hamcrest assertion
     */

    createPathParam(reqSpec, "tv_id", valid_tv_id);
    createPathParam(reqSpec, "season_number", valid_season_number);
    Response res = getResponse(reqSpec, "get");
    assertThat(res.path("id"), not(IsNull.nullValue()));
    assertThat(res.path("freebase_mid"), not(IsNull.nullValue()));
    assertThat(res.path("tvdb_id"), not(IsNull.nullValue()));
    assertThat(res.path("freebase_id"), is(IsNull.nullValue()));
    assertThat(res.path("tvrage_id"), is(IsNull.nullValue()));
  }

}
