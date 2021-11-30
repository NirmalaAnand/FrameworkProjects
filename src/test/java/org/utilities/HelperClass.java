package org.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperClass {
	public static WebDriver driver;
	//WebDriver Interface methods
	//1- Chrome Launch
	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	//2 - Load Url
	public static void loadUrl(String url) {
		driver.get(url);
	}
	
	//3- Window maximize
	public static void winMax() {
		driver.manage().window().maximize();
	}
	
	// 4- Window Minimize
	public static void winMin() {
		driver.manage().window().minimize();
	}
	
	// 5 - getTitle
	public static void printTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	//6.getCurrentUrl
	public static void printCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}
	
	//7.close
	public static void closeWindow() {
		driver.close();
	}
	
	//8.quit
	public static void closeAllWindow() {
		driver.quit();
	}
	
	//WebElement Interface Methods
	
	//9.sendKeys()
	public static void fill(WebElement ele,String value) {
		ele.sendKeys(value);
	}
	
	//10.click()
	
	public static void btnClick(WebElement ele) {
		ele.click();
		
	}
	//11.getText
	
	public static void printText(WebElement ele) {
		ele.getText();
	}
	
	//12.getAttribute
	
	public static void printValue(WebElement ele) {
		ele.getAttribute("value");
	}
	
	//Actions class
	
	//13.moveToElement
	
	public static void mouseOver(WebElement ele) {
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
	}
	//14.Drag and drop
	
	public static void dragPlace() {
		

	}
	//ExcelRead
	

	
public static String getData(int rowNumber,int cellNumber) throws IOException {
	File f=new File("C:\\Users\\DELL\\eclipse-workspace\\SeleFramework\\testData\\FB.xlsx");
	FileInputStream fin=new FileInputStream(f);
	Workbook w=new XSSFWorkbook(fin);
	Sheet s = w.getSheet("Data");
	Row row = s.getRow(rowNumber);
	Cell cell = row.getCell(cellNumber);
	int cellType = cell.getCellType();
	
    String value = "";
	if(cellType==1)
	{
		 value = cell.getStringCellValue();
	}
	else if(cellType==0) {
		if(DateUtil.isCellDateFormatted(cell)){
			Date d = cell.getDateCellValue();
			SimpleDateFormat sim=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			 value = sim.format(d);
		}else {
			double d = cell.getNumericCellValue();
			long l=(long) d;
			  value = String.valueOf(l);
			
		}
		
	}
	return value;
	
}

public static void writeData(int rowNumber,int cellNumber,String value) throws IOException {
	 File f=new File("C:\\Users\\DELL\\eclipse-workspace\\SeleFramework\\testData\\hotel.xlsx");
	 FileInputStream fin=new FileInputStream(f);
	 Workbook w=new XSSFWorkbook(fin);
	 Sheet s = w.getSheet("Hotel");
		
	 Row row = s.createRow(rowNumber);
	 Cell cell = row.createCell(cellNumber);
	 cell.setCellValue(value);
     FileOutputStream fout=new FileOutputStream(f);
     w.write(fout);
     
    		

}
}

