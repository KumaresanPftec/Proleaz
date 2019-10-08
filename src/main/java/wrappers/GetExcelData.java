package wrappers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetExcelData {
	
	
	public String[][] getData(String filePath) throws FileNotFoundException{
		
		String[][] excelData=null;
		
		try {
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
	
		int rowCount = sheet.getLastRowNum();
		int colCount =sheet.getRow(0).getLastCellNum();
		
		excelData = new String[rowCount][colCount];
		
		for(int i=1;i<=rowCount; i++) {
			
			XSSFRow row = sheet.getRow(i);
			String cellValue ="";
			
			for(int j=0; j<=colCount; j++) {
				
				cellValue = row.getCell(j).getStringCellValue();
				excelData[i][j] = cellValue;
				
				
			}
			
			
			
		}
				
	
		
		}catch(NullPointerException e) {
			
			
			System.out.println("Null Value is passed ");
		
		}catch(Exception e) {
			
			System.out.println("Common Exception" +e);
		}
		
		return excelData;
		
		
	}
	
	@DataProvider(name="loginDetails")
	public Object[][] getArrayData() throws IOException{
		
		Object[][] excelData1 = getData("./DataSheets/TestSheet.xlsx");
		
		return excelData1;
		
	}

	@Test(dataProvider="loginDetails")
	public void printExcelData(String txt1, String txt2) {
		
		
		System.out.println(txt1 +""+ txt2);
		
	}
}


