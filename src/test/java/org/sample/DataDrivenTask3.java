package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTask3 {
	public static void main(String[] args) throws IOException {
		File f=new File("C:\\Users\\DELL\\eclipse-workspace\\SeleFramework\\testData\\Question 1 -3.xlsx");
		FileInputStream fin=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fin);
		Sheet s = w.getSheet("Student");
		Row row = s.createRow(10);
		Cell c1 = row.createCell(0);
		c1.setCellValue("Mahesh");
		Cell c2 = row.createCell(1);
		c2.setCellValue("MCom");
		FileOutputStream fout=new FileOutputStream(f);
		w.write(fout);
		
		System.out.println("success");
		
		
	}

}
