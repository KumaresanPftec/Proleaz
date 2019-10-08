package pages;
import wrappers.CommonWrappers;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
public class LoginPage extends CommonWrappers {
		
	
	public boolean result;
	
	public LoginPage userName(String userName) throws InterruptedException, IOException   {
		
	
		//result = enterTextById(userNameId, userName);
		extentLog(enterTextById(objRep("Login.id"), userName), "UserName is entered successfully", "User name is not entered");
		
		
		
		
	/*	Reporter.log("UserName "+userName+ " is entered " );
	
		
		
		
		try {
			getScreenshot();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		*/
	
		
		
		return new LoginPage();
		
	}
	
	public LoginPage passWord(String passWordId, String passWord ) throws InterruptedException, NullPointerException, IOException  {
		
		result = enterTextById(passWordId, passWord);
		
		
		extentLog(result, "Password is entered successfully", "Password is not entered");
		
		/*Reporter.log("Password is entered "+passWord);
		try {
			getScreenshot();
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}
		*/
		
		
		return new LoginPage();
	}

	
	public LoginPage loginSubmit(String id) throws InterruptedException, NullPointerException, IOException {
		
		result =clickById(id);
		
		extentLog(result, "Login button is clicked", "Login Button is not clicked");
		
		//Reporter.log("LoginButton is clicked");
		
		
		
		return new LoginPage();
		
	}
	
	public LoginPage checkLogin(String passedUrl) {
		
		String currentURL;
		currentURL=getUrl();
	/*	Reporter.log("Page Redirected to "+currentURL);
		
		try {
			getScreenshot();
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}
		*/
		//extentLog(, "Login button is clicked", "Login Button is not clicked");
		
		
		
		 
		
		Assert.assertEquals(passedUrl, currentURL);
		
		 
		
		return new LoginPage();
		
	}
	
	@DataProvider(name="getData")
	public Object[][] getLogin() throws IOException{
		
		Object[][] excelData = readExcelData("./DataSheets/TestSheet.xlsx");
		
		
		return excelData;
		
		
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
	
	@DataProvider(name="validLoginDetails")
    public Object[][] getValidLogins(){
    return new Object[][] 
    	{
            { "mk", "12345" }
           
        };
}
	
}
