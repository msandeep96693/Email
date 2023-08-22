package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities1 {

	public static Object[][] ExtractdatafromExcel(String SheetName) {
		
		XSSFWorkbook workbook = null;
		
		File ExcelFile = new File(System.getProperty("user.dir")+"/src/main/java/testdata/TestDataDriven1.xlsx");
		try {
		FileInputStream fis = new FileInputStream(ExcelFile);
		workbook = new XSSFWorkbook(fis);
		} catch(Throwable e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(SheetName);
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][cols];
		
		for(int i=0; i<rows; i++) {
			
			XSSFRow row = sheet.getRow(i);
			
			for(int j=0; j<cols; j++) {
				
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				
				switch(cellType) {
				
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				
				}
				
			}
		}
		return data;
	}
	
	public static String captureScreenShot(WebDriver driver , String testName) {
		
		
		File srcScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String Screenshotpath = System.getProperty("user.dir")+"/Screenshots/"+testName+".jpg";
		try {
//		FileUtils.copyFile(srcScreenShot, new File(Screenshotpath));
		org.openqa.selenium.io.FileHandler.copy(srcScreenShot, new File(Screenshotpath));
		} catch(IOException e) {
			e.printStackTrace();
		}
		return Screenshotpath;
	}
}
