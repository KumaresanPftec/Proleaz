package wrappers;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WindowHandle {
	
	
	
	
	
	public static void main(String args[]) {
		RemoteWebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.findElementByLinkText("Click Here").click();
		String parentHandle = driver.getWindowHandle();
		
		Set<String> allWindow = driver.getWindowHandles();
		
		for(String s1 : allWindow) {
			
			driver.switchTo().window(s1);
			
		}
		
		driver.findElementByName("emailid").sendKeys("gaurav.3n@gmail.com");
		driver.findElementByName("btnLogin").click();
		driver.close();
		
		driver.switchTo().window(parentHandle);
		//driver.findElementByLinkText("Click Here").click();
		
	}
	
	

}
