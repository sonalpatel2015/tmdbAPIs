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

  @Test
  public void verifyPassingLanguageAsParameterWithEnUs() {
    // To-do
  }

  @Test
  public void verifyLanguageIsOptionalParameter() {
    // To-do
  }

  @Test
  public void verifyImagePathIsReturned() {
    // To-do
  }

  @Test
  public void verifyPassingInvalidLanguageEnXy() {
    // To-do
  }

  @Test
  public void verifyPassingInvalidLanguageLessThanTwoCharacter() {
    // To-do
  }

  @Test
  public void verifyPassingValidSeasonWrongTvId() {
    // To-do
  }

  @Test
  public void verifyPassingValidTvIdWrongSeasonId() {
    // To-do
  }
  
}
