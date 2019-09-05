package testcases;
import wrappers.CommonWrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
public class VerifyLogin extends LoginPage{
	
	
	LoginPage lp = new LoginPage();
	
	@BeforeMethod
	public void beforeMethod(){
		startTest("VerifyValidLogin", "Test Result");
		lp.launchBrowser();
	}

	
	@Test(dataProvider="validLoginDetails")
		
	public void validLogin(String userName, String passWord) {
		
			try {
				
				
				lp.userName("txtusr", userName);
				lp.passWord("txtpswd", passWord);
				lp.loginSubmit("btnlogin");
				lp.driverWait();
				lp.checkLogin("http://10.10.13.211/ProleazTesting/Dashboard/ControlPanel");
				
			} 
			
			catch (Exception e) {
				
				e.printStackTrace();
			}
		}


	@AfterMethod
	
	public void endTest1() {
		
		endTest();
	}
	
	
	
	
	}
