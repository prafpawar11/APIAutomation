package BaseApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class BaseApi {
	protected static RequestSpecification httpRequest;
	
	protected static Response response;
	
	protected static ValidatableResponse validateResponse;
	
	
	public static void reqSpec() {
		httpRequest = RestAssured.given().contentType(ContentType.JSON).log().all();
	}

}
