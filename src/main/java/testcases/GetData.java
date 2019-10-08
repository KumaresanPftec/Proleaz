package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetData {
	
	public static void main(String args[]) throws IOException {
		
		
		
		FileInputStream fis = new FileInputStream("./DataSheets/TestSheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		
		for(int i=0; i<=rowCount; i++) {
			
			XSSFRow row = sheet.getRow(i);
			
			String cellValue = "";
			for(int j=0; j<colCount; j++) {
				
				cellValue = row.getCell(j).getStringCellValue();
				System.out.println(cellValue);
			}
		}
		
		
	}

}
