package Utils;


import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {
	
 
	public static Object[][] ExtractDataFromExcel(String SheetName) {
		
		XSSFWorkbook workbook = null;
		File ExcelFile = new File(System.getProperty("user.dir")+"/src/main/java/testdata/TestDataDriven1.xlsx");
		try {
		FileInputStream fis = new FileInputStream(ExcelFile);
		workbook = new XSSFWorkbook(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet(SheetName);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][cols];
		
		for(int i=0; i<rows; i++) {
			
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j =0; j<cols; j++) {
				
				XSSFCell cell = row.getCell(j);
				CellType celltype = cell.getCellType();
				
				switch (celltype) {
				
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;	
				case NUMERIC:
					data[i][j]= Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j]=cell.getBooleanCellValue();
					

				
				}
			}
		}
		return data;
	}
}
