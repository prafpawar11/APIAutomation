package StepApi;

import java.io.FileNotFoundException;

import com.fasterxml.jackson.core.JsonProcessingException;

import BaseApi.BaseApi;
import Endpoints.CustomerEndpoints;
import Model.Customers;
import Reader.JsonReader;
import UtliltyHelper.SchemaValidator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class CustomerStepApi extends BaseApi {

	@Given("attach customer request payload to http request")
	public void attach_customer_request_payload_to_http_request() throws JsonProcessingException, Exception {

		httpRequest.body(JsonReader
				.serialization(JsonReader.deserialization("customerPayload", Customers.class, "createcustomer")));

	}

	@When("select http post request to create customer")
	public void select_http_post_request_to_create_customer() {

		response = httpRequest.post(CustomerEndpoints.CUSTOMER_POST);

	}

	@Then("validate customer json schema")
	public void validate_customer_json_schema() throws FileNotFoundException {
		validateResponse.body(JsonSchemaValidator.matchesJsonSchema(SchemaValidator.matchJsonSchema("customerSchema")));
	}

	@Given("attach updated customer request payload to http request")
	public void attach_updated_customer_request_payload_to_http_request() throws JsonProcessingException, Exception {

		httpRequest.body(JsonReader
				.serialization(JsonReader.deserialization("customerPayload", Customers.class, "updatecustomer")));

	}

	@When("select http put request to update customer")
	public void select_http_put_request_to_update_customer() {

		response = httpRequest.put(CustomerEndpoints.CUSTOMER_PUT);
	}

	@When("select http get request to get customer")
	public void select_http_get_request_to_get_customer() {
		response = httpRequest.get(CustomerEndpoints.CUSTOMER_GET);
	}

	@When("select http delete request to delete customer")
	public void select_http_delete_request_to_delete_customer() {
		response = httpRequest.delete(CustomerEndpoints.CUSTOMER_DELETE);
	}

}
