package Proleaz.project;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report {
	
	protected ExtentReports report;
	protected ExtentTest test;
	protected RemoteWebDriver driver;

	public String addScreenshot() throws IOException{

	File screenshot = driver.getScreenshotAs(OutputType.FILE);
	String timeStamp = new SimpleDateFormat("yyyymmdd_HHmmss").format(Calendar.getInstance().getTime());

	File screenshotName = new File("./Reports/"+timeStamp+".png");
	FileUtils.copyFile(screenshot , screenshotName);

	String filePath = screenshotName.getPath();

	return filePath;
	}

	public void startTest(String fileName, String text){

	report = new ExtentReports(System.getProperty("usr.dir")+"\\"+fileName+".html");

	report.assignProject("project");

	test=report.startTest(text); 

	}

	public void endTest(){

	report.endTest(test);
	report.flush();


	}

	public void extentLog(boolean result, String pass, String fail) throws IOException, NullPointerException{

		
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
	

}
