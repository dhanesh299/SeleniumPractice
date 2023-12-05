package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class OwnMethods {
	
	public Properties prop;
	public FileInputStream fis;

	public String getValueFromPropertiesFile(String key) throws IOException {

		System.out.println("Getting value from properties file");
		System.out.println("Key is : " + key);
		
		String sourceHome=System.getProperty("user.dir");
		String propertyFileLocation="\\src\\Resources\\data.properties";
		System.out.println("data.properties location: " + sourceHome + propertyFileLocation);

		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\Resources\\data.properties");
		prop.load(fis);
		String value = prop.getProperty(key);
		System.out.println("Value is : " + value);
		return value;
	}
}
