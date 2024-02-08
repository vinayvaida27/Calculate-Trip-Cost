package Hackathon_TripCost;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* Author name
* Gerald Hadley Brownie
* Prabhu Shanmugam
* Rajesh R 
* Sai Sushmita
* Vinay Vaida
*/

public class getExcel {
	XSSFSheet sh = null;

	getExcel() throws IOException {
		File source = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\hackathon.xlsx");
		FileInputStream is = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(is);
		this.sh = wb.getSheetAt(0);
	}

//getting data from excel sheet
	public String locName() {
		return sh.getRow(1).getCell(0).getStringCellValue();
	}

	public String checkIn() {
		return sh.getRow(1).getCell(1).getStringCellValue();
	}

	public String checkOut() {
		return sh.getRow(1).getCell(2).getStringCellValue();
	}
}