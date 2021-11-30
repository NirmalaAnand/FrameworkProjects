package org.sample;

import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.utilities.HelperClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTask4 extends HelperClass {
	public static void main(String[] args) throws IOException, InterruptedException {
		launchChrome();
		loadUrl("http://www.adactin.com/HotelApp/");
		winMax();
		printTitle();
		printCurrentUrl();
		WebElement txtUser = driver.findElement(By.id("username"));
		fill(txtUser, "Nirmalaanand");
		WebElement txtPass = driver.findElement(By.id("password"));
		fill(txtPass,"2PQ0A9");
		WebElement login = driver.findElement(By.id("login"));
		btnClick(login);
		 File f=new File("C:\\Users\\DELL\\eclipse-workspace\\SeleFramework\\testData\\hotel.xlsx");
	     f.createNewFile();
	     Workbook w=new XSSFWorkbook();
		 Sheet sheet = w.createSheet("Hotel");
		
		writeData(0, 0, "Location");
    	writeData(0, 1, "Hotels");
	    writeData(0, 2, "Room Type");
		writeData(0, 3, "Number of Rooms");
		writeData(0, 4, "Check In Date");
		writeData(0, 5, "Check Out Date");
		writeData(0, 6, "Adults per Room");
		writeData(0, 7, "Children per Room");
		
		writeData(1, 0, "Paris");
		writeData(1, 1, "Hotel Creek");
		writeData(1, 2, "Double");
		writeData(1, 3, "1-One");
		writeData(1, 4, "14/11/2021");
		writeData(1, 5, "16/11/2021");
		writeData(1, 6, "2-Two");
		writeData(1, 7, "1-One");
		System.out.println("Success");
	
		
		
		
	}

}
