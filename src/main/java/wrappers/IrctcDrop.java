package wrappers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class IrctcDrop {
	
	
	@Test
	public static void main(String args[]) {
		
		RemoteWebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		driver.get("http://demo.guru99.com/v1/");
		driver.manage().window().maximize();
	
		driver.findElementByXPath("//*[@type='text' or @name='uid']").sendKeys("value");
		
		
	
		
		
	}

}
