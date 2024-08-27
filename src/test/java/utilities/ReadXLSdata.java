package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSdata {

	@DataProvider(name ="maruthiTest")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException
	{
	  String excelSheetName = m.getName();
		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		// Corrected the file path
		fis = new FileInputStream(f); // create the stream of a particular file
		// create the workbook from the input stream
		Sheet sheetName = wb.getSheet(excelSheetName);

		int totalRows = sheetName.getLastRowNum();
		System.out.println("Total rows: " + totalRows);

		Row rowCells = sheetName.getRow(0); // Get the first row to determine the number of columns
		int totalCol = rowCells.getLastCellNum(); // Get the number of columns from the first row
		System.out.println("Total columns: " + totalCol);

		DataFormatter format = new DataFormatter();
		String[][] testData = new String[totalRows +1][totalCol]; // Adjusted array size to include all rows

		for (int i = 0; i <= totalRows; i++) {
			for (int j = 0; j < totalCol; j++) {
				testData[i][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i][j]);
			}
		}
		return testData;
	}
}
