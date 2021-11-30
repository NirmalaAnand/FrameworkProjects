package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public static void main(String[] args) throws IOException {
		File f=new File("C:\\Users\\DELL\\eclipse-workspace\\SeleFramework\\testData\\Sample.xlsx");
		FileInputStream fin =new FileInputStream (f);
		
		Workbook w=new XSSFWorkbook(fin);
		Sheet s = w.getSheet("Greens");
		Row r = s.getRow(2);
		Cell c = r.getCell(0);
		System.out.println(c);
		
		
		
		
		
	}

}
