package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCompleteRead {
	public static void main(String[] args) throws IOException {
		File f=new File("C:\\Users\\DELL\\eclipse-workspace\\SeleFramework\\testData\\Sample.xlsx");
		FileInputStream fin=new FileInputStream(f);
		
		Workbook w=new XSSFWorkbook(fin);
		Sheet s = w.getSheet("Greens");
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row row = s.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				
				Cell cell = row.getCell(j);
				int cellType = cell.getCellType();
				if(cellType==1)
				{
					String value = cell.getStringCellValue();
					System.out.println(value);
				}
				else if(cellType==0)
				{
					if(DateUtil.isCellDateFormatted(cell)) {
						Date d = cell.getDateCellValue();
						
						SimpleDateFormat sim= new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
						String value = sim.format(d);
						System.out.println(value);
						
					}
					else {
						double d = cell.getNumericCellValue();
						long l=(long) d;
						String value = String.valueOf(l);
						System.out.println(value);
						
					}
						
				}
			}
		}
		

}
}