package pracTcs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadTheDataFromExcel {
	public static void main(String[] args) throws Throwable {
		// step 1
		FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo-QSP\\OneDrive\\Desktop\\Excel\\Campaign.xlsx");

		// step 2
		Workbook wb = WorkbookFactory.create(fis);

		// step 3
		Sheet sh = wb.getSheet("Campaign");

		// step 4
		Row row = sh.getRow(1);

		// step 5
		Cell cel = row.getCell(0);

		// step 6
		String dataa = cel.getStringCellValue();

		System.out.println(dataa);

		String data2 = wb.getSheet("Campaign").getRow(1).getCell(1).getStringCellValue();

		System.out.println(data2);

		// step 7
		wb.close();
	}
}
