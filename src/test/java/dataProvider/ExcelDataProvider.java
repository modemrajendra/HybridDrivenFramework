package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;

	public ExcelDataProvider() {

		File fi = new File("./AppTestData/ApplicationData.xlsx");

		try {
			FileInputStream fis = new FileInputStream(fi);
			wb = new XSSFWorkbook(fis);
		}

		catch (Exception e) {

			System.out.println("The Error Message is:" + e.getMessage());
		}

	}

	public String getData(int sheetindex, int row, int col) {
		String data = wb.getSheetAt(sheetindex).getRow(row).getCell(col).getStringCellValue();
		return data;
	}

	public String getData(String sheetname, int row, int col) {
		String data = wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
		return data;
	}
}
