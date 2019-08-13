package seleniumtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium {
	
	static WebDriver driver;
	public void excel(String filePath, String fileName, String sheetName) throws Exception{
		
		File file = new File(filePath+"\\"+fileName);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		for(int i=0; i<=rowCount+1; i++){
			Row row = sheet.getRow(i);
			for(int j=0; j<row.getLastCellNum();j++){
				//row.getCell(j).getStringCellValue();
				String value = row.getCell(j).getStringCellValue();
				System.out.println(value);
			}
			//driver.findElement(By.linkText("SIGN-ON")).click();
	        //driver.findElement(By.name("userName")).sendKeys("munna");
		}
    }
	public static void main(String[] args) throws Exception{

//		System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		 driver = new ChromeDriver();	
		 String baseUrl = "http://demo.guru99.com/test/newtours/";
		 driver.get(baseUrl);
//	        String expectedTitle = "Welcome: Mercury Tours";
//	        String actualTitle = "";

	        // launch Fire fox and direct it to the Base URL
	        //driver.get(baseUrl);
	        TestSelenium objExcelFile = new TestSelenium();
	        //Prepare the path of excel file
	        String filePath = System.getProperty("user.dir")+"\\D:\\ExcelRead";
	        //Call read file method of the class to read data
	        objExcelFile.excel(filePath,"ExcelRead.xlsx","Sheet1");
	    
	}
}
