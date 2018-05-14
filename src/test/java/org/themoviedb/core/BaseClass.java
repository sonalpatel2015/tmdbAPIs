package org.themoviedb.core;

import static org.themoviedb.common.RestUtilities.getRequestSpecification;
import static org.themoviedb.common.RestUtilities.getResponseSpecification;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.themoviedb.constants.Path;

public class BaseClass {

  public RequestSpecification reqSpec;
  public ResponseSpecification resSpec;

  @BeforeClass
  public void setup() {
    reqSpec = getRequestSpecification();
    reqSpec.basePath(Path.TV_SEASON);
    resSpec = getResponseSpecification();
  }


}
