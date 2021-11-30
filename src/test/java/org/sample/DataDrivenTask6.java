package org.sample;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.utilities.HelperClass;

public class DataDrivenTask6 extends HelperClass {
	public static void main(String[] args) throws IOException {
		launchChrome();
		loadUrl("https://www.facebook.com/");
		winMax();
		printTitle();
		printCurrentUrl();
		File f=new File("C:\\Users\\DELL\\eclipse-workspace\\SeleFramework\\testData\\Facebook.xlsx");
		f.createNewFile();
		Workbook w=new XSSFWorkbook();
		Sheet sheet = w.createSheet();
		Row row = sheet.createRow(0);
		Cell c1 = row.createCell(0);
		c1.setCellValue(" Email");
		Cell c2 = row.createCell(1);
		c2.setCellValue(" password");
		Row row2 = sheet.createRow(1);
		Cell c3 = row2.createCell(0);
		c3.setCellValue("greens@gmail.com");
		Cell c4 = row2.createCell(1);
		c4.setCellValue("greens@123");
		FileOutputStream fout=new FileOutputStream(f);
		w.write(fout);
		
		WebElement txtUser = driver.findElement(By.id("email"));
		fill(txtUser,getData(1, 0));
		
		WebElement txtPass = driver.findElement(By.id("pass"));
		fill(txtPass,getData(1, 1));
		
		WebElement btnLogin = driver.findElement(By.xpath("//button[@name='login']"));
		btnClick(btnLogin);
		
		
		
		
		
		
		
		
	}

}
