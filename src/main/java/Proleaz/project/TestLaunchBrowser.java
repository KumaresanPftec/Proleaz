
package Proleaz.project;
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
//How to read excel files using Apache POI
public class TestLaunchBrowser {
	
	@DataProvider(name="usrLogin")
	
	 public Object[][] loginCredential1(){
	 	
	 	Object arrayObject[][]= getExcelData("./DataSheet/TestSheet.xlsx");
	 	return arrayObject;
	 	
	 }
	

public String [][] getExcelData(String fileName) throws NullPointerException{
	 	
	 	String[][] arrayExcelData =null;
	 	
	 	try {
	 		FileInputStream fis = new FileInputStream(fileName);
	 		XSSFWorkbook wb = new XSSFWorkbook(fis);
	 		XSSFSheet sh = wb.getSheetAt(0);
	 		
	 		int totalNoOfRows = sh.getPhysicalNumberOfRows();
	 		
	 		
	 		arrayExcelData = new String[totalNoOfRows-1][2];
	 		System.out.println(totalNoOfRows);
	 		for(int i =1; i<totalNoOfRows+1; i++) {
	 			Row row = sh.getRow(i);
	 			int totalNoOfCols =row.getLastCellNum();
	 		
	 				for(int j=0; j<2; j++) { 					
	 					
	 					String cellValue="";	 					
	 					//arrayExcelData[i-1][j]	 							
	 						cellValue	= sh.getRow(i).getCell(j).getStringCellValue();	 						
	 						arrayExcelData[i-1][j]=cellValue;	 					 					
	 				}
	 			
	 			
	 		}
	 		
	 	} catch (FileNotFoundException e) {
	 		
	 		e.printStackTrace();
	 	}
	 	catch (Exception e) {
	 		
	 		e.printStackTrace();
	 	}
	 	
	 	
	 	
	 	return arrayExcelData;
	 }                     
	 
@Test(dataProvider="usrLogin")
public void print(String userName, String password) {
	


	
}
/*@Test(dataProvider="usrLogin")
public void print2(String userName ,String password) {
	System.out.println(userName);
	System.out.println(password);

}*/
	 
	 
/*String cellValue="";	 
 FileInputStream fis = new FileInputStream("./DataSheet/TestSheet.xlsx");
 XSSFWorkbook workbook = new XSSFWorkbook(fis);
 XSSFSheet sheet = workbook.getSheetAt(0);
 Row row;
 
 //System.out.println(cell);
 //System.out.println(sheet.getRow(0).getCell(0));
  
 int rowCount = sheet.getLastRowNum();

 
 for(int r=0; r<rowCount+1; r++) {
	  
	 	row = sheet.getRow(r);
	 	//colCount	=row.getLastCellNum();
	 	for(int col=0; col<row.getLastCellNum();col++) {
	 		
	 		try {
				cellValue =row.getCell(col).getStringCellValue();
				System.out.println(cellValue);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	 	}
	 
 }*/
 
// String s1 = cell.getStringCellValue();
 //System.out.println(s1);
 
 } 

