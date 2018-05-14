package org.themoviedb.tv_seasons;

import static org.themoviedb.common.RestUtilities.setEndPoint;
import static org.themoviedb.constants.EndPoints.TV_SEASON_GET_IMAGES;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.themoviedb.core.BaseClass;

public class tmdb_getImages extends BaseClass {

  @BeforeClass
  public void pathForGetDetails() {
    setEndPoint(TV_SEASON_GET_IMAGES);
  }

  /*
    This api test verifies that it returns correct data with passing option parameter: language
   */
  @Test
  public void verifyPassingLanguageAsParameterWithEnUs() {
    // To-do
  }

  /*
    Verify api without passing language parameter to confirm language is optional
   */
  @Test
  public void verifyLanguageIsOptionalParameter() {
    // To-do
  }

  /*
    Verify actual response and also verify image path is returned
   */
  @Test
  public void verifyImagePathIsReturned() {
    // To-do
  }

  /*
    Verify api by passing invalid language as parameter
   */
  @Test
  public void verifyPassingInvalidLanguageEnXy() {
    // To-do
  }

  /*
    Verify api by passing language less than 2 character [checking validation]
   */
  @Test
  public void verifyPassingInvalidLanguageLessThanTwoCharacter() {
    // To-do
  }

  /*
  Verify api by passing Wrong TV Id
 */
  @Test
  public void verifyPassingValidSeasonWrongTvId() {
    // To-do
  }

  /*
      Verify api by passing Wrong Season Id
  */
  @Test
  public void verifyPassingValidTvIdWrongSeasonId() {
    // To-do
  }
  
}
