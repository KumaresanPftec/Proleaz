package pages;
import wrappers.CommonWrappers;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
public class LoginPage extends CommonWrappers {
		
	
	public LoginPage userName(String userNameId, String userName) throws InterruptedException   {
		
	
		enterTextById(userNameId, userName);
		Reporter.log("UserName "+userName+ " is entered " );
		try {
			getScreenshot();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	
		
		
		return new LoginPage();
		
	}
	
	public LoginPage passWord(String passWordId, String passWord) throws InterruptedException  {
		
		enterTextById(passWordId, passWord);
		Reporter.log("Password is entered "+passWord);
		try {
			getScreenshot();
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		return new LoginPage();
	}

	
	public LoginPage loginSubmit(String id) throws InterruptedException {
		
		clickById(id);
		Reporter.log("LoginButton is clicked");
		
		
		
		return new LoginPage();
		
	}
	
	public LoginPage checkLogin(String passedUrl) {
		
		String currentURL=getUrl();
		Reporter.log("Page Redirected to "+currentURL);
		
		try {
			getScreenshot();
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		Assert.assertEquals(passedUrl, currentURL);
		
		
		
		return new LoginPage();
		
	}
	
	
	@DataProvider(name="validLoginDetails")
    public Object[][] getValidLogins(){
    return new Object[][] 
    	{
            { "mk", "12345" },
           
        };
}
	
	@DataProvider(name="invalidLoginDetails")
    public Object[][] getValidInLogins(){
    return new Object[][] 
    	{
            
            { "mk", "123456"},
            {"m1k", "12345"},
            {"m1k","123456"},
            {"",""}
            
            
            
            
            
           
        };
}
	
}
