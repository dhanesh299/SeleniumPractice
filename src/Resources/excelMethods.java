package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelMethods {
	
	public ArrayList<String> listAllRowCellsByColumnValue(String excelPath, String searchForSheet, String searchColumnCellsFor, String searchRowCellsFor) throws IOException {

		ArrayList<String> testCaseDetails = new ArrayList<String>();

		// Pass excel sheet to File input stream
		FileInputStream fis = new FileInputStream(excelPath);
		// Pass the FIS object to workbook Class
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets(); // Get number of sheets in the workbook
		for (int i = 0; i < sheets; i++) { // iterator to find workbook in sheets

			if (workbook.getSheetName(i).equalsIgnoreCase(searchForSheet)) { // If sheet name match is found
				XSSFSheet sheet = workbook.getSheetAt(i); // fetch sheet
				Iterator<Row> rows = sheet.iterator(); // Iterate in rows
				Row firstrow = rows.next(); // fetch first row
				Iterator<Cell> columnCells = firstrow.cellIterator(); // iterate into cells
				int k = 0, column = 0; // k for iteration count, column to fetch column number
				while (columnCells.hasNext()) { // if there is a cell next
					Cell columnCellValue = columnCells.next(); // fetch the next cell
					if (columnCellValue.getStringCellValue().equalsIgnoreCase(searchRowCellsFor)) { // if the cell value equals searched value - "Summary"
						column = k; // column number = iteration
					}
					k++; // count updated only after columnn is found (since column number starts from 0)
				}
				System.out.println("Cell Value " + searchRowCellsFor + " is found in colummn : " + column); // Print column number

				while (rows.hasNext()) { // If there is a row next
					Row row = rows.next(); // fetch the next row
					if (row.getCell(column).getStringCellValue().equalsIgnoreCase(searchColumnCellsFor)) { // if the column-th column equals searched value "Purchase"
						System.out.println("The column Value is: " + searchColumnCellsFor);
						Iterator<Cell> rowCells = row.cellIterator(); // iterate the row into cells
						System.out.println("The Row values are: ");
						while (rowCells.hasNext()) {
							Cell rowCellValue = rowCells.next(); // fetch the cell
							if (rowCellValue.getCellType() == CellType.STRING) { // if the cell value is string
			 					testCaseDetails.add(rowCellValue.getStringCellValue()); // Add the string to the array list
							} else if (rowCellValue.getCellType() == CellType.NUMERIC) { // if the cell value is numeric
								String rowCellValueString = NumberToTextConverter
										.toText(rowCellValue.getNumericCellValue()); // convert Numeric values to String
								testCaseDetails.add(rowCellValueString); // Add the string to the array list
							}
						}
					}
				}
			}
		}
		return testCaseDetails;
	}  

}
