package Resources;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader extends base {

	public void getRowbyColumnHeaderAndValue(String columnHeader, String columnValue) {
		try {

			String excelSource = getValueFromDataProperties("excelSource");

			FileInputStream file = new FileInputStream(excelSource);

			// Create Workbook instance
			Workbook workbook = new XSSFWorkbook(file);

			// Get the first sheet
			Sheet sheet = workbook.getSheetAt(0);

			// Find the column index by iterating over the header row
			int columnIndex = -1;
			Row headerRow = sheet.getRow(0);
			for (Cell cell : headerRow) {
				if (cell.getStringCellValue().equals("TC ID")) {
					columnIndex = cell.getColumnIndex();
					break;
				}
			}

			// Check if column found
			if (columnIndex == -1) {
				System.out.println("Column not found!");
				return;
			}

			// Iterate over the rows and find the row with the specified value
			for (Row row : sheet) {
				Cell cell = row.getCell(columnIndex);
				if (cell != null && cell.getCellType() == CellType.STRING) {
					if (cell.getStringCellValue().equals(columnValue)) {
						// Retrieve the entire row
						for (Cell rCell : row) {
							System.out.print(rCell.getStringCellValue() + "\t");
						}
						System.out.println(); // Move to the next line
						break;
					}
				}
			}

			// Close the workbook
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getCellValueByColumnHeadersAndValue(String column1Header, String column1Value, String column2Header) {
            try {
            	String excelSource = getValueFromDataProperties("excelSource");

                // Create Workbook instance
                Workbook workbook = new XSSFWorkbook(excelSource);

                // Get the first sheet
                Sheet sheet = workbook.getSheetAt(0);

                // Find the column index by iterating over the header row
                int columnIndex1 = -1;
                int columnIndex2 = -1;
                Row headerRow = sheet.getRow(0);
                for (Cell cell : headerRow) {
                    if (cell.getStringCellValue().equals(column1Header)) {
                        columnIndex1 = cell.getColumnIndex();
                    } else if (cell.getStringCellValue().equals(column2Header)) {
                        columnIndex2 = cell.getColumnIndex();
                    }
                }

                // Check if columns found
                if (columnIndex1 == -1 || columnIndex2 == -1) {
                    System.out.println("One or more columns not found!");
                    return;
                }

                // Iterate over the rows and find the row with the specified value in ColumnHeader1
                for (Row row : sheet) {
                    Cell cell = row.getCell(columnIndex1);
                    if (cell != null && cell.getCellType() == CellType.STRING) {
                        if (cell.getStringCellValue().equals(column1Value)) {
                            // Retrieve the value from ColumnHeader2
                            Cell valueCell = row.getCell(columnIndex2);
                            if (valueCell != null) {
                                System.out.println(column2Header + " for " + column1Value + " is : " + valueCell.getStringCellValue());
                            } else {
                                System.out.println(column2Header + " not found for " + column1Value + "! or is NULL");
                            }
                            break;
                        }
                    }
                }

                // Close the workbook
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
	}
}
