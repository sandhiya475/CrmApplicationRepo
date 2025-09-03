package generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

	/**
	 * This class is used to load and fetch value from Properties file
	 */
public class PropertyFileUtility {
	/**
	 * This method will return value from property file when we pass key to this method
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String toReadDataFromPropertyFile(String key) throws IOException {
		FileInputStream pfis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties prop = new Properties();
		prop.load(pfis);
		String value = prop.getProperty(key);
		return value;
	}

}
