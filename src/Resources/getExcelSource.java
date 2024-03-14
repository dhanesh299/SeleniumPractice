package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getExcelSource extends base {

	String excelSource=null;
	String cellValue = null;
	int findCount = 0;
	
	public void getRowValuesByTCID(String TCID) throws IOException {
		
		excelSource = getValueFromDataProperties("excelSource");
		
		FileInputStream fis = new FileInputStream(new File(excelSource));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {

			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.iterator();
			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();
				cellValue = cell.getStringCellValue();

				if (cellValue.equals(TCID))
					findCount++;

				if (findCount == 1) {
					switch (cell.getCellType()) {
					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t");
						break;
					case STRING:
						System.out.print(cell.getStringCellValue() + "\t");
						break;
					}
				}
			}
			if (findCount == 1) {
				System.out.println("\n");
				break;
			}
		}
	}
}
