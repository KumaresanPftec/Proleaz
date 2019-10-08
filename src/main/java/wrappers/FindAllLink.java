package wrappers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindAllLink extends ClickAlert{
	
	WebDriver driver;
	
	
	public void getLinks() {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.toolsqa.com");
		driver.manage().window().maximize();
		System.out.println(driver.getPageSource());
	/*	List<WebElement> links =driver.findElements(By.tagName("a"));
		
		
		for(WebElement element : links) {
			
			System.out.println(element.getText());
			
		}
		*/
		
	}
	
	//Override
	public void clickOnAlert() {
		
		System.out.println("sub classs is running");
	
	}
	public static void main(String args[]) {
		
		ClickAlert a = new FindAllLink();
		
		a.clickOnAlert();
		 
		a= new ClickAlert();
		
		a.clickOnAlert();
	
	}
	
	
}
