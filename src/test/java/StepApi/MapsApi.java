package StepApi;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hamcrest.Matchers;

import com.fasterxml.jackson.core.JsonProcessingException;

import BaseApi.BaseApi;
import Endpoints.CustomerEndpoints;
import Endpoints.MapsEndpoints;
import Model.Customers;
import Model.Maps;
import Reader.JsonReader;
import Reader.PropertyReader;
import UtliltyHelper.SchemaValidator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class MapsApi extends BaseApi {

	static String mapId;

	@Given("configure base uri")
	public void configure_base_uri() {
		RestAssured.baseURI = PropertyReader.getProperty("BASE_URI");
	}

	@Given("get the request specification object")
	public void get_the_request_specification_object() {
		BaseApi.reqSpec();
	}

	@Given("attach request payload to http request")
	public void attach_request_payload_to_http_request() throws Exception {
		Maps maps = JsonReader.deserialization("mapsPayload", Maps.class, "createmap");

		String mapsRequestPayload = JsonReader.serialization(maps);

		httpRequest.body(mapsRequestPayload);
	}

	@When("select http post request")
	public void select_http_post_request() {
		response = httpRequest.post(MapsEndpoints.MAP_POST);
	}

	@Then("capture id from response payload")
	public void capture_id_from_response_payload() {
		mapId = response.jsonPath().getString("id");

	}

	@Then("validate status code {int}")
	public void validate_status_code(Integer code) {
		validateResponse = response.then().assertThat().statusCode(Matchers.equalTo(code));

	}

	@Then("validate status line {string}")
	public void validate_status_line(String line) {
		validateResponse.statusLine(Matchers.containsString(line));
	}

	@Then("validate response time below {int} ms")
	public void validate_response_time_below_ms(Integer time) {
		validateResponse.time(Matchers.lessThan((long) time));
	}

	@Then("validate {string} and {string} response header")
	public void validate_and_response_header(String key, String value) {
		validateResponse.header(key, Matchers.containsString(value));
	}

	@Then("validate {string} and current month and year response header")
	public void validate_and_current_month_and_year_response_header(String key) {

		String date = new SimpleDateFormat("MMM yyyy").format(new Date());

		validateResponse.header(key, Matchers.containsString(date));

	}

	@Then("validate json schema")
	public void validate_json_schema() throws FileNotFoundException {

		validateResponse.body(JsonSchemaValidator.matchesJsonSchema(SchemaValidator.matchJsonSchema("mapsSchema")));
	}

	@Then("generate logs")
	public void generate_logs() {
		validateResponse.log().all();
	}

	@Given("add path parameter")
	public void add_path_parameter() {

		httpRequest.pathParam("id", mapId);

	}

	@When("select http get request")
	public void select_http_get_request() {
		response = httpRequest.get(MapsEndpoints.MAP_GET);
	}

	@Given("attach request payload to http put request")
	public void attach_request_payload_to_http_put_request() throws Exception {

		Maps maps = JsonReader.deserialization("mapsPayload", Maps.class, "updatemap");

		String mapspayload = JsonReader.serialization(maps);

		httpRequest.body(mapspayload);

	}

	@When("select http delete request")
	public void select_http_delete_request() {

		response = httpRequest.delete(MapsEndpoints.MAP_DELETE);

	}

	@When("select http put request")
	public void select_http_put_request() {

		response = httpRequest.put(MapsEndpoints.MAP_PUT);

	}

}
