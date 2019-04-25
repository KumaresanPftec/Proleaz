package wrappers;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class CommonWrappers {

protected RemoteWebDriver driver;
protected ExtentTest test;
protected ExtentReports report;	
public static Workbook book;
public static Sheet sheet;


public void intiateBrowser() {
	
	
	
}

public void getScreenshot() throws IOException   {
	
	 try {
		File screenshotFile = driver.getScreenshotAs(OutputType.FILE);
		String	timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		File screenShotName = new File("D:\\proleazscreenshot\\"+timeStamp+".png"); 
		FileUtils.copyFile(screenshotFile,screenShotName);
		
		String filePath = screenShotName.toString();
		String path ="<img width='800px' height='300px' src=\"file://" + filePath+ "\" alt=\"\" />";
		Reporter.log(path);
		
				
		// FileUtils.copyFile(screenshotFile, new File(fileName ));
		 //"D:\\proleazscreenshot\\UserNameEnteredSuccessfully.png"
		 
	} catch (WebDriverException e) {
		 
		e.printStackTrace();
	}
	
}



public boolean launchBrowser() {
	
	try {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.10.13.211/ProleazTesting/Login/Index");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
	} catch (Exception e) {
		
		e.printStackTrace();
		
	}
	return false;
}

public boolean appLogin(String userName,String passWord) throws InterruptedException 
{
	
	
		enterTextById("txtusr", userName);
		enterTextById("txtpswd", passWord);
		if(driver.findElementById("btnlogin").isDisplayed())
		{
			clickById("btnlogin");
			return true;
		}
		
		else
			{
			return false;
			}

}

public boolean enterTextById(String id, String text) throws InterruptedException {
	
	try {
		
		
		driver.findElementById(id).sendKeys(text);
		return true;
	} 
	
	catch (Exception e) 
	{
		
		e.printStackTrace();
		reportLog(" Error Passing Arguments");
		 
		return false;
	}
	
	
}



public boolean clickById(String id) throws InterruptedException {
	
	try {
		
		driver.findElementById(id).click();
		return true;
	    } 
	
	catch (Exception e) {
		
		e.printStackTrace();
		reportLog(" Error Passing Arguments");
		return false;
	}
	
	
}

public boolean clickByLinkText(String value) {
	
	try {
		driver.findElementByLinkText(value).click();
		return true;
	} 
	
	catch (Exception e) {
		
		e.printStackTrace();
		return false;
	}
	
	
}

public boolean closeDriver() {

	try {
		driver.close();
		return true;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	

}

public String getUrl() {

	
	String url= driver.getCurrentUrl();
	
	return url;
}

public boolean driverWait() {
	
	 try {
		
		 Thread.sleep(3000);
		 return true;
	
	 } catch (InterruptedException e) {
		
		e.printStackTrace();
		return false;
	}
	
}

public boolean clickByXPath(String xPath) {
	
	try {
		driver.findElementByXPath(xPath).click();
		
		
	
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	return false;
}

public boolean enterByXPath(String xPath , String name) {
	
	try {
		//driver.findElementByXPath(xPath).clear();
		driver.findElementByXPath(xPath).click();
		driver.findElementByXPath(xPath).sendKeys(name,Keys.ENTER);;
	
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	
	return false;
}

public boolean quitBrowser() {
	
	driver.quit();
	
	return false;
}

@DataProvider(name="usrLogin")
	
public Object[][] loginCredential(){
	
	Object arrayObject[][]= getExcelData("");
	return arrayObject;
	
}


public String [][] getExcelData(String fileName){
	
	String[][] arrayExcelData =null;
	
	try {
		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		
		int totalNoOfRows = sh.getLastRowNum();
		
		for(int i =0; i<=totalNoOfRows; i++) {
			
			Row row = sh.getRow(i);
			
				for(int j=0; j<=row.getLastCellNum(); j++) {
					
					
					
					arrayExcelData[i-1][j] = sh.getRow(i).getCell(j).getStringCellValue();
					System.out.println(arrayExcelData[i-1][j]);
					
					
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


public String getTextByXpath(String xPath) {
	
	String text =driver.findElementByXPath(xPath).getText();
	
	return text;
}



@SuppressWarnings("unlikely-arg-type")
public boolean selectListByXpath(String xpath,String value)
{
	
	try {
		
		
		
		List<WebElement> list =(driver.findElementsByXPath(xpath));  
		for(int i=0;i<list.size();i++)
		{
			//System.out.println(list.get(i).getText());
			if(list.get(i).getText().equals(value))
			{
				list.get(i).click();
				break;
				
				
			}
			
			
			
		}
		return true;
		
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
	
	
}




public boolean reportLog(String LogText) throws InterruptedException {
	
	Thread.sleep(500);
	Reporter.log(LogText);
	try 
	{
		getScreenshot();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return false;
}




public boolean searchListElementByXpath(String xpath,String value) {
	
	
	try 
	{
		List<WebElement> list =(driver.findElementsByXPath(xpath));  
		for(int i=0;i<list.size();i++)
		{
			//System.out.println(list.get(i).getText());
			if(list.get(i).getText().equals(value))
			{
				System.out.println(list.get(i).getText());
				
				break;
			}
			
		}
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
	
	
}

//lOGIC TO BE CHANGED
public boolean clickListElementByXpath(String xpath,String value,String action) {   // to click a Action button with same tags and ids
	
	
	try 
	{
		List<WebElement> list =(driver.findElementsByXPath(xpath));  
		for(int i=0;i<list.size();i++)
		{
			//System.out.println(list.get(i).getText());
			if(list.get(i).getText().equals(value))
			{
				
				
				List<WebElement> actions =list.get(i+3).findElements(By.tagName("a"));
				for(int j=0;j<actions.size();j++)
				{
					
					//System.out.println(actions.get(j).getText());
					System.out.println(actions.get(j).getAttribute("title").toString());
					if(actions.get(j).getAttribute("title").toString().equals(action))
					{
						actions.get(j).click();
						break;
					}
					
				}
			break;	
			}
			
		}
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
	
	
}


public String addScreenshot() throws IOException   {   	//To Add Screenshot for Extent report
	
	  
	File screenshotFile = driver.getScreenshotAs(OutputType.FILE);
	String	timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
	File screenShotName = new File("D:\\proleazscreenshot\\"+timeStamp+".png"); 
	FileUtils.copyFile(screenshotFile,screenShotName);
	
	String filePath = screenShotName.toString();
	//String path ="<img width='300px' height='300px' src=\"file://" + filePath+ "\" alt=\"\" />";
	//Reporter.log(path);
	return filePath;
	

}

/*public boolean switchLandingPage(String value) throws InterruptedException

{
	if(value.equals("Admin"))
	{
		driver.get("http://10.10.13.211/ProleazTesting/Dashboard/ControlPanel");
		System.out.println("Control panel launched");
		reportLog("Control panel launched");
		 return true;
	}
	else
	{
		driver.get("http://10.10.13.211/ProleazTesting/Home/Home");
		System.out.println("User panel launched");
		reportLog("User panel launched");
		return true;
	}
	 
	
}
*/





public String getTextValueByid(String id) 
{
		String text=driver.findElementById(id).getAttribute("value");
		return text;
}

public boolean verifyTextById(String id,String expected) 
{
		String text=driver.findElementById(id).getAttribute("value");
		
		
		if(text.equals(expected)) {
			
			return true;
		}
		
		else {
			
			return false;
		}
		//assertEquals(text, expected)
			
		
		
		
		
}
public boolean verifyTextByXPath(String xpath,String expected) 
{
		String text=driver.findElementByXPath(xpath).getText();
	
		
		if(text.equals(expected)) {
			
			return true;
		}
		
		else {
			
			return false;
		}
		
		
}


public void testUrl(String url) 
{
	driver.get(url);
	 
}

public  String getExcelData(String filepath,int row,int column) throws IOException {    //To get data from excel sheet 

	FileInputStream file = null;
	try {
		file = new FileInputStream(filepath);
		 
	} 
	catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	}
    
	book = new XSSFWorkbook(file);
	
	sheet = book.getSheetAt(0);
	
	
	 Cell cell =sheet.getRow(row).getCell(column);
	
	String strCellValue;
	if(cell.getCellType() == cell.getCellType())
	{ 
		int i = (int)cell.getNumericCellValue(); 
	    strCellValue = String.valueOf(i); 
		} 
	else 
	{ 
		strCellValue = cell.toString().trim(); 
	}
	
//	String value = sheet.getRow(row).getCell(column).toString().trim();
	
    return  strCellValue;


}
 
public  void verifyDataFromExcel(String filepath,int row,int column) throws IOException //For Getting data from excel sheet and comapring with page data
{

	FileInputStream file = null;
	try {
		file = new FileInputStream(filepath);
		 
	} 
	catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	}
    
	book = new XSSFWorkbook(file);
	
	sheet = book.getSheetAt(0);
	
	 

	int j=0;
	for(int i=0;i<=sheet.getRow(j).getLastCellNum();i++)
	{
	
		
		
	String elementType=getExcelData(filepath, row, column+i);
	String 	element = getExcelData(filepath, row+1, column+i);
	String 	value = getExcelData(filepath, row+2, column+i);
	if(elementType.equals("N/A"))
	{
		 j++;
		break;
	}
	
	else if(elementType.equals("id"))
	{
		verifyTextById(element, value);
		Reporter.log(value+" is verified");
		
	}
	else if(elementType.equals("xpath"))
	{
		verifyTextByXPath(element,value);
		Reporter.log(value+" is verified");
	}

	}
 

}

public  void getDataFromExcel(String filepath,int row,int column) throws IOException //For Getting data from excel sheet and sending it to page
, InterruptedException
{

	FileInputStream file = null;
	try {
		file = new FileInputStream(filepath);
		 
	} 
	catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	}
    
	book = new XSSFWorkbook(file);
	
	sheet = book.getSheetAt(0);
	
	 

	int j=0;
	for(int i=0;i<=sheet.getRow(j).getLastCellNum();i++)
	{
	
		
		
	String elementType=getExcelData(filepath, row, column+i);
	String 	element = getExcelData(filepath, row+1, column+i);
	String 	value = getExcelData(filepath, row+2, column+i);
	if(elementType.equals("N/A"))
	{
	   //System.out.println(element+"     "+value); 
		j++;
		break;
	}
	
	else if(elementType.equals("id"))
	{
		//System.out.println(element+"     "+value);
		enterTextById(element, value); 
		Reporter.log(value+" is Entered");
		
	}
	else if(elementType.equals("xpath"))
	{
		//System.out.println(element+"     "+value);
		enterByXPath(element, value);
		Reporter.log(value+" is Entered");
	}

	}
 

}

public boolean clearById(String id) {
	
	driver.findElementById(id).clear();
	
	return false;
	
	
}





}