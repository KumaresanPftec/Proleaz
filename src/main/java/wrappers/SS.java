package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SS {
	
	RemoteWebDriver driver;
	
	@Test
	public void takescreenShot() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://www.google.co.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File screenShot = driver.getScreenshotAs(OutputType.FILE);
		
		File screenShotName = new File("./ss.png");
		FileUtils.copyFile(screenShot, screenShotName);
		
	}

}
