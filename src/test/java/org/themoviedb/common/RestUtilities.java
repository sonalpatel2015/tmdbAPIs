package org.themoviedb.common;

import static org.hamcrest.Matchers.lessThan;
import static io.restassured.RestAssured.given;
import static org.themoviedb.constants.Auth.CONSUMER_API_KEY;

import io.restassured.authentication.AuthenticationScheme;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.themoviedb.constants.Path;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestUtilities {
	
	public static String ENDPOINT;
	public static RequestSpecBuilder REQUEST_BUILDER;
	public static RequestSpecification REQUEST_SPEC;
	public static ResponseSpecBuilder RESPONSE_BUILDER;
	public static ResponseSpecification RESPONSE_SPEC;
	
	public static void setEndPoint(String epoint) {
		ENDPOINT = epoint;
	}

	public static RequestSpecification getRequestSpecification() {
		REQUEST_BUILDER = new RequestSpecBuilder();
		REQUEST_BUILDER.setBaseUri(Path.BASE_URI);
		REQUEST_BUILDER.addQueryParam("api_key", CONSUMER_API_KEY);
		REQUEST_SPEC = REQUEST_BUILDER.build();
		return REQUEST_SPEC;
	}

	public static ResponseSpecification getResponseSpecification() {
		RESPONSE_BUILDER = new ResponseSpecBuilder();
		RESPONSE_BUILDER.expectStatusCode(200);
		RESPONSE_BUILDER.expectContentType("application/json");
		RESPONSE_BUILDER.expectResponseTime(lessThan(5L), TimeUnit.SECONDS);
		RESPONSE_SPEC = RESPONSE_BUILDER.build();
		return RESPONSE_SPEC;
	}

	/**
	 * Most of TMDB apis are path parameters, so below method is more useful
	 */
	public static RequestSpecification createPathParam(RequestSpecification rspec,
			String param, int value) {
		return rspec.pathParam(param, value);
	}

	/**
	 * I understand that TMDB may/may not be using query parameters but
	 * Below Method is just an example in case if we want to use Query Parameters
	 */
	public static RequestSpecification createQueryParam(RequestSpecification rspec,
			String param, String value) {
		return rspec.queryParam(param, value);
	}

	/**
	 * I understand that TMDB may/may not be using query parameters but
	 * Below Method is also similar to above method except this can except multiple parameters
	 * This is also example of Method Overloading in Java
	 */
	public static RequestSpecification createQueryParam(RequestSpecification rspec,
			Map<String, String> queryMap) {
		return rspec.queryParams(queryMap);
	}

	public static Response getResponse() {
		return given().get(ENDPOINT);
	}
	
	public static Response getResponse(RequestSpecification reqSpec, String type) {
		REQUEST_SPEC.spec(reqSpec);
		Response response = null;
		if (type.equalsIgnoreCase("get")) {
			response = given().spec(REQUEST_SPEC).get(ENDPOINT);
		} else if (type.equalsIgnoreCase("post")) {
			response = given().spec(REQUEST_SPEC).post(ENDPOINT);
		} else if (type.equalsIgnoreCase("put")) {
			response = given().spec(REQUEST_SPEC).put(ENDPOINT);
		} else if (type.equalsIgnoreCase("delete")) {
			response = given().spec(REQUEST_SPEC).delete(ENDPOINT);
		} else {
			System.out.println("Type is not supported");
		}
		response.then().log().all();
		response.then().spec(RESPONSE_SPEC);
		return response;
	}

	public static JsonPath getJsonPath(Response res) {
		String path = res.asString();
		return new JsonPath(path);
	}

	public static void resetBasePath() {
		RestAssured.basePath = null;
	}

}