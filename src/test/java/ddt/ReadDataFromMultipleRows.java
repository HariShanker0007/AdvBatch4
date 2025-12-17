package ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromMultipleRows {
public static void main(String[] args) throws Throwable {
	
	FileInputStream fis = new FileInputStream("./\\src\\test\\resources\\resources\\MultiRow.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	
	Sheet sh = wb.getSheet("Sheet1");
	int rowCount = sh.getLastRowNum();
	for (int row = 1; row <= rowCount; row++) {
		String brand = sh.getRow(row).getCell(0).getStringCellValue();
		String mobile = sh.getRow(row).getCell(1).getStringCellValue();
		
		System.out.println(brand+"===="+mobile);
	}
}
}
