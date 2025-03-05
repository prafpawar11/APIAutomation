package UtliltyHelper;

import java.io.FileNotFoundException;
import java.io.FileReader;

import BaseApi.BaseApi;
import io.restassured.module.jsv.JsonSchemaValidator;

public class SchemaValidator extends BaseApi {

	public static FileReader matchJsonSchema(String SchemaFileName) throws FileNotFoundException {
		String path = System.getProperty("user.dir") + "/src/test/resources/JsonSchema/" + SchemaFileName + ".json";

		FileReader reader = new FileReader(path);

		return reader;
	}

}
