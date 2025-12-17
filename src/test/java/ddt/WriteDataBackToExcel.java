package ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataBackToExcel {
public static void main(String[] args) throws Throwable {
	
	//step 1
	FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo-QSP\\OneDrive\\Desktop\\Excel\\Campaign.xlsx");
	
	//step 2
	Workbook wb = WorkbookFactory.create(fis);
	
	//step 3
	Sheet sh = wb.createSheet("sheet3");
	
	//step 4
	Row ro = sh.createRow(3);
	
	//step 5
	Cell sel = ro.createCell(0);
	
	//step 6
	sel.setCellValue("Entered Dataa Succesfully");
	
	//step 7
	FileOutputStream fos = new FileOutputStream("C:\\Users\\Lenovo-QSP\\OneDrive\\Desktop\\Excel\\Campaign.xlsx");
	
	//step 8
	wb.write(fos);
	
	//step 9
	wb.close();
	
	System.out.println("Successfull");
}
}
