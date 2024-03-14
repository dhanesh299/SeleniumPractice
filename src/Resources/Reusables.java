package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Reusables {

	public Properties prop;
	public FileInputStream fis;

	public String path_currentProject = System.getProperty("user.dir");
	public String path_dataProperties = path_currentProject + "\\src\\Resources\\data.properties";

	public String getValueFromDataProperties(String property_key) throws IOException {

		//System.out.println("Fetching value from data.properties file");

		prop = new Properties();
		FileInputStream fis = new FileInputStream(path_dataProperties);
		prop.load(fis);
		String property_value = prop.getProperty(property_key);
		//System.out.println("Value retrieved for " + property_key + " = " + property_value);
		return property_value;
	}

	public String getValueFromSystemProperty(String property_key) {
		String property_value = System.getProperty(property_key);
		System.out.println("Value retrieved for " + property_key + " = " + property_value);
		return property_value;
	}

}
