package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Reusables {
	
	public Properties prop;
	public FileInputStream fis;

	public String getStringValueFromDataProperties(String key) throws IOException {

		System.out.println("Fetching value from data.properties file");
		String propertyFileLocation=System.getProperty("user.dir")+"\\src\\Resources\\data.properties";
		prop = new Properties();
		FileInputStream fis = new FileInputStream(propertyFileLocation);
		prop.load(fis);
		String value = prop.getProperty(key);
		System.out.println("Value retrieved for " + key + " = " + value);
		return value;
	}
	
	public Boolean getBooleanValueFromDataProperties(String key) throws IOException {

		System.out.println("Fetching value from data.properties file");
		String propertyFileLocation=System.getProperty("user.dir")+"\\src\\Resources\\data.properties";
		prop = new Properties();
		FileInputStream fis = new FileInputStream(propertyFileLocation);
		prop.load(fis);
		String value = prop.getProperty(key);
		System.out.println("Value retrieved for " + key + " = " + value);
		return value;
	}
	
	public String getValueFromSystemProperty(String property) {
		return System.getProperty(property);
	}
	
	public String getValueFromJenkinsBuildParamater(String buildParameter) {
		return getValueFromSystemProperty(buildParameter);
	}
}
