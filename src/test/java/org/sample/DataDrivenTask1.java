package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTask1 {
	public static void main(String[] args) throws IOException {
		File f=new File("C:\\Users\\DELL\\eclipse-workspace\\SeleFramework\\testData\\Question 1 -3.xlsx");
		FileInputStream fin=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fin);
		Sheet s = w.getSheet("Student");
		int phyRow = s.getPhysicalNumberOfRows();
		System.out.println("Physical number of rows :"+phyRow);
		Row row = s.getRow(3);
		int phyCells = row.getPhysicalNumberOfCells();
		System.out.println("Physical number of cells :"+phyCells);
		
		
		
	}

}
