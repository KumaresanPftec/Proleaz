package wrappers;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.http.util.Asserts;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class CommonWrappers {

	protected RemoteWebDriver driver;
	protected WebDriverWait wait;
	public static Workbook book;
	public static Sheet sheet;
	protected static ExtentTest test;
	protected ExtentReports report;
	public final String getPath =  (System.getProperty("user.dir")+"\\resources\\"+"GetCompanyDetails.xlsx");
	public final String verifyPath =  (System.getProperty("user.dir")+"\\resources\\"+"VerifyCompanyDetails.xlsx");
	
	
	
	public String objRep(String locatorKey) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\ObjectRepository.properties");
		prop.load(fis);
		String key =prop.getProperty(locatorKey);
		return key;
	}


	public void getScreenshot() throws IOException   {
		
		 try {
			File screenshotFile = driver.getScreenshotAs(OutputType.FILE);
			String	timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
			File screenShotName = new File("./Reports/"+timeStamp+".png"); 
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

		
		String url = driver.getCurrentUrl();
		
		
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
			 return true;
			
		
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
		
	}

	public boolean enterByXPath(String xPath , String name) {
		
		try {
			//driver.findElementByXPath(xPath).clear();
			driver.findElementByXPath(xPath).click();
			driver.findElementByXPath(xPath).sendKeys(name,Keys.ENTER);
			return true;
		
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
		
		
	}

	public boolean quitBrowser() {
		
		driver.quit();
		
		return false;
	}

	@DataProvider(name="Data")
		
	public String loginCredential() throws IOException{
		
		String arrayObject= getExcelData("", 1,1 );
		return arrayObject;
		
	}


	public String getTextByXpath(String xPath) {
		
		String text =driver.findElementByXPath(xPath).getText();
		
		return text;
	}



	@SuppressWarnings("unlikely-arg-type")
	public boolean selectListByXpath(String xpath,String value)  //TO select a Dropdown option  by passing xpath and select value
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




	public boolean reportLog(String LogText) throws InterruptedException {  //To Add log and screenshot for TestNG report
		
		Thread.sleep(500);
		Reporter.log(LogText);
		try 
		{
			getScreenshot();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		
	}




	public boolean searchListElementByXpath(String xpath,String value) {   // To search a whether the table contains the stored data 
		
		
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
		{	boolean result=false;
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
							result=true;
							break;
						}
						
					}
					
					break;	
				}
				
			}
			return result;
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
		File screenShotName = new File("./Reports/"+timeStamp+".png"); 
		FileUtils.copyFile(screenshotFile,screenShotName);
		
		String filePath = screenShotName.getPath();
		//String path ="<img width='300px' height='300px' src=\"file://" + filePath+ "\" alt=\"\" />";
		//Reporter.log(path);
		return filePath;
		

	}

	public boolean switchLandingPage(String value) throws InterruptedException // to Change landing page on login

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
		if(cell.getCellType() == cell.getCellTypeEnum())
		{ 
			int i = (int)cell.getNumericCellValue(); 
		    strCellValue = String.valueOf(i); 
			} 
		else 
		{ 
			strCellValue = cell.toString().trim(); 
		}
		
//		String value = sheet.getRow(row).getCell(column).toString().trim();
		
	    return  strCellValue;


	}
	 
	public  boolean verifyDataFromExcel(String filepath,int row,int column) throws IOException //For Getting data from excel sheet and comapring with page data
	{

		FileInputStream file = null;
		try {
			file = new FileInputStream(filepath);
			 
		
	    
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
		return true;
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return false;
		}
	 

	}

	public  boolean getDataFromExcel(String filepath,int row,int column) throws IOException //For Getting data from excel sheet and sending it to page
	, InterruptedException
	{

		FileInputStream file = null;
		try {
			file = new FileInputStream(filepath);
		
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
		return true;
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	
	public void startTest(String filename,String text)   // To start extent report
	{
	     
		 
		report = new ExtentReports(System.getProperty("user.dir")+"\\"+filename+".html");
	    report.assignProject("project");
	    
		test = report.startTest(text);
		
	}

	public  void endTest() //To end extent report log
	{
	report.endTest(test);
	report.flush();
	}

	
	public void extentLog(boolean result,String pass,String fail) throws IOException, NullPointerException //To log result to extent report
	{
		String screenshot = test.addScreenCapture(addScreenshot());
	try {	
			if(result==true)
			{
				test.log(LogStatus.PASS, pass);
			}
			else
			{
				test.log(LogStatus.FAIL, fail,screenshot);
			}
		}
	catch(Exception e)
		{
			test.log(LogStatus.ERROR, e.toString(),screenshot);
			
		}


	}



	public boolean alert(String value) throws IOException //To select Alert option
	{
		
	try {	
			if(value.equals("YES"))
			{
				
				 driver.switchTo().activeElement().findElement(By.xpath("//button[@class='confirm']")).click();
				 return true;
			}
			else if(value.equals("NO"))
			{
				
				driver.switchTo().activeElement().findElement(By.xpath("//button[@class='cancel']")).click();
				return true;
			}
			else
			{
				return false;
			}
			
		}
	catch(Exception e)
		{
			e.printStackTrace();
			return false;	
			
		}


	}



public boolean clearById(String id) {
	
	try {
		driver.findElementById(id).clear();
		
		return true;
	} 
	
	catch (Exception e) {
		
		e.printStackTrace();
		return false;
	}
	
	
	
	
}
 public boolean verifyWebTable(String xpath, String value) {
	
	 String text="";
	 try {
	 WebElement tBody = driver.findElementByXPath(xpath);
	 
	 List<WebElement> tRow = tBody.findElements(By.tagName("tr"));
	  
	 int totalRow = tRow.size();
	 
	 for(int row=0; row<totalRow; row++) {
		 
		 List<WebElement> tCol = tRow.get(row).findElements(By.tagName("td"));
		 
		 int totalCol = tCol.size();
		 
		 for(int col=0; col<totalCol;col++) {
			 
			 text = tCol.get(col).getText();
			 
			 
			 if(text.equalsIgnoreCase(value)) {
				 System.out.println(text);
				 }
			
				
		 }
		 
			 
		 
		 
		 
	 }
		 
		
	 return true;		 
			 
		 
	 }
	 catch(Exception e) {
		 return false;
	 }
		 
	 }
	 
 public boolean mouseOverByXpath(String XPath) {
	 
	 try {
		 Actions actions = new Actions(driver);
		 WebElement element = driver.findElementByXPath(XPath);
		 actions.moveToElement(element).perform();
		 return true;
		 
	 }
	 
	 catch(Exception e) {
		 
		 return false;
	 }
	 
 }

public boolean clickByLink(String linkName) {
	
	try {
		driver.findElementByLinkText(linkName).click();
		return true;
		
	}
	
	catch(Exception e) {
		
		return false;
	}
}

public boolean selectById(String id, int index) {
	
	try {
		
		Select select = new Select(driver.findElementById(id));
		
		select.selectByIndex(index);
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	return true;
	
	
	}


public String[][] readExcelData(String filePath) throws IOException {
	
	String[][] arrayData=null;

	FileInputStream fis = new FileInputStream(filePath);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	
	XSSFSheet sheet = workbook.getSheetAt(0);
	
	int rowCount = sheet.getLastRowNum();
	int colCount = sheet.getRow(0).getLastCellNum();
	
	arrayData = new String[rowCount][colCount];
	System.out.println(rowCount);
	System.out.println(colCount);
	for(int i=1; i<=rowCount; i++) {
		
		//XSSFRow row =sheet.getRow(i) ;
		
		String cellValue = "";
		try {
		for(int j=0; j<=colCount; j++) {
			
			
			cellValue = sheet.getRow(i).getCell(j).getStringCellValue();
			arrayData[i][j]=cellValue;
			
			}
		
		}
		
		catch(NullPointerException e) {
			System.out.println("null value is passed ");
		}
		catch(Exception e){
			
			System.out.println("could not read ");
		}
		
	 
	 
 }

	return arrayData;
}
}

