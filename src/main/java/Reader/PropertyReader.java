package Reader;

import java.io.FileReader;
import java.util.Properties;

public class PropertyReader {

	public static String getProperty(String keyName) {
		String path = System.getProperty("user.dir") + "/src/main/resources/ConfigurationLayer/config.properties";

		Properties prop = new Properties();
		try {

			prop.load(new FileReader(path));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return prop.getProperty(keyName);
	}

}
