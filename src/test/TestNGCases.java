package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Resources.ExcelReader;
import Resources.Reusables;
import Resources.base;
import Resources.excelMethods;
import Resources.getExcelSource;

public class TestNGCases extends base {

	// WebDriver driver=null;

	@BeforeClass(enabled=false)
	public void SetValuesTest() throws IOException {
		System.out.println("Test initializing...");
		initializeValues();
		//driver = initializeBrowser();
		System.out.println("Browser: " + browserValue);
		System.out.println("URL: " + urlValue);
		System.out.println("Excel Source:" + excelSourceValue);
		System.out.println("Test initialized.");
	}

	@Test (enabled=false)
	public void homePageTest() throws InterruptedException {
		// WebDriverManager.chromedriver().setup(); // Not needed since DriverManager is
		// set by latest selenium jars and maven by default
		driver.get(urlValue);
		driver.manage().window().maximize();
		System.out.println("Loaded URL: " + urlValue);
		// String expectedTitle="Online Bus Ticket Booking with Best Offers and Lowest
		// Price - redBus";
		// String expectedTitle="Bus Tickets Booking Online with Attractive Rates -
		// redBus";
		String expectedTitle = "Book Bus Tickets Online, Easy & Secure Booking, Top Operators - redBus";
		String actualTitle = driver.getTitle();
		// Thread.sleep(20000);
		Assert.assertTrue(expectedTitle.equals(actualTitle));
		System.out.println("Expected title : " + expectedTitle + " matches with " + "Actual title: " + actualTitle); // Assertion gets true, this will be executed
	}

	@Test (enabled=false)
	public void getFromExcel() throws IOException {
		// Provide details for search
		String excelPath = "C:\\My Folder\\Eclipse\\Workspaces\\SeleniumPractice\\SeleniumBasics\\src\\Resources\\testSheet.xlsx";
		String searchForSheet = "TestCases";
		String searchRowCellsFor = "TC ID";
		String searchColumnCellsFor = "TC001";

		ArrayList<String> testCaseDetails = new ArrayList<String>(); // declare array list for test case details

		excelMethods excel = new excelMethods(); // declare object for dataDriven class
		testCaseDetails = excel.listAllRowCellsByColumnValue(excelPath, searchForSheet, searchColumnCellsFor, searchRowCellsFor); // call get data method from "dataDriven" class

		Iterator<String> subdetails = testCaseDetails.iterator(); // iterate test case details
		while (subdetails.hasNext()) { // if there is a subdetail next
			System.out.println(subdetails.next()); // print the sub detail
		}
	}
	
	@Test(enabled=false)
	public void getFromExcelSource() throws IOException {
		getExcelSource ges=new getExcelSource();
		ges.getRowValuesByTCID("TC002");
	}
	
	@Test(enabled=true)
	public void readExcel() throws IOException {
		ExcelReader er=new ExcelReader();
		
		// Method 1
		er.getRowbyColumnHeaderAndValue("TC ID", "TC002"); 
		// Method 2
		er.getCellValueByColumnHeadersAndValue("User Name", "Abigail", "Password");
		er.getCellValueByColumnHeadersAndValue("TC ID", "TC002","Result"); 
	}

	@AfterClass(enabled=false)
	public void quitBrowserTest() throws InterruptedException {
		
		driver.quit();
		System.out.println("Test Ended");
	}
}