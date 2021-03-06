package testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;

public class VerifyInvalidLogin extends LoginPage {
	
	LoginPage lp = new LoginPage();
	@BeforeMethod
	public void beforeMethod(){
		startTest("VerifyValidLogin", "Test Result");
		lp.launchBrowser();
	}
	@Test(dataProvider="getData")
	
	public void invalidLogin(String userName ,String passWord) {
		try {
			System.out.println(userName+""+passWord);
			//lp.userName("txtusr", userName);
			lp.passWord("txtpswd", passWord);
			lp.loginSubmit("btnlogin");
			lp.checkLogin("http://10.10.13.211/ProleazTesting/Login/Index");
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}

@AfterMethod
public void closeAllBrowser(){
	endTest();
	lp.quitBrowser();
	
}
}
