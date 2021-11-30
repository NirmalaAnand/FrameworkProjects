package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.utilities.HelperClass;

public class DataDrivenTask7 extends HelperClass {
    public static void main(String[] args) throws IOException, InterruptedException {
		launchChrome();
		loadUrl("https://www.facebook.com/");
		winMax();
		printTitle();
		printCurrentUrl();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		File f=new File("C:\\Users\\DELL\\eclipse-workspace\\SeleFramework\\testData\\FB.xlsx");
		f.createNewFile();
		Workbook w=new XSSFWorkbook();
		Sheet sheet = w.createSheet("Data");
		Row row1 = sheet.createRow(0);
		Cell c1 = row1.createCell(0);
		c1.setCellValue("Email");
		Cell c2=row1.createCell(1);
		c2.setCellValue("Password");
		Row row2 = sheet.createRow(1);
		Cell c3 = row2.createCell(0);
		c3.setCellValue("greens");
		Cell c4 = row2.createCell(1);
		c4.setCellValue("greens@123");
		
		System.out.println("success");
		
		WebElement txtUser = driver.findElement(By.id("email"));
		fill(txtUser, getData(1, 0));
		
		WebElement txtPass = driver.findElement(By.id("pass"));
		fill(txtPass,getData(1, 1));
		
		WebElement btnLogin = driver.findElement(By.xpath("//button[@name='login']"));
		btnClick(btnLogin);
		Thread.sleep(7000);
		
		WebElement errorMsg = driver.findElement(By.xpath("(//a[text()='Forgotten password?'])[1]"));
		String text  = errorMsg.getText();
		Thread.sleep(7000);
	    File file=new File("C:\\Users\\DELL\\eclipse-workspace\\SeleFramework\\testData\\FB.xlsx");
	    FileInputStream fin=new FileInputStream(file);
	    Workbook wb=new XSSFWorkbook(fin);
	    Sheet sheet2 = wb.getSheet("Data");
	    Row row = sheet2.createRow(3);
	    row.createCell(0).setCellValue(text);
	    FileOutputStream fos=new FileOutputStream(file);
	    wb.write(fos);
	    System.out.println(text);
	    Thread.sleep(7000);
		
		
    }
}
