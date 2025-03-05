package Reader;

import java.io.FileReader;

import org.apache.poi.ss.formula.functions.T;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {

	public static <T> T deserialization(String JsonPayloadFileName, Class<T> ModeClasslName, String nodeName)
			throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/resources/JsonPayload/" + JsonPayloadFileName
				+ ".json";

		FileReader file = new FileReader(path);

		ObjectMapper mapper = new ObjectMapper();

		JsonNode jsonNode = mapper.readTree(file);

		return mapper.treeToValue(jsonNode.get(nodeName), ModeClasslName);

	}

	public static String serialization(Object ModeClasslName) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();

		return mapper.writeValueAsString(ModeClasslName);

	}
}
