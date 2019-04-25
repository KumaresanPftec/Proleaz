package Proleaz.project;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;

public class VerifyInvalidLogin extends LoginPage {
	
	LoginPage lp = new LoginPage();
	@BeforeMethod
	public void beforeMethod(){
		
		lp.launchBrowser();
	}
	@Test(dataProvider="invalidLoginDetails")
	
	public void invalidLogin(String userName ,String passWord) {
		try {
			
			lp.userName("txtusr", userName);
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
	lp.quitBrowser();
	
}
}
