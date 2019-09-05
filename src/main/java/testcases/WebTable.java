package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Portfolio;
import wrappers.CommonWrappers;

public class WebTable extends Portfolio {
	
	@BeforeMethod
	public void beforeMethod(){
		startTest("VerifyPorfolio", "Portfololio Save");
		
	}


	
	@Test(dataProvider="portfolioDetails")
	public void verifyPortfolioIsSaved(String portName, String portAbbr) throws InterruptedException, NullPointerException, IOException {
		Portfolio pf = new Portfolio();
		pf.launchBrowser();
		pf.appLogin("mk", "12345");
		pf.driverWait();
		pf.clickApplicationSetting("//*[@id='appMenu']/a/span");
		pf.clickPortfolio("portMenu");
		pf.enterPortfolioName("pname", portName);
		pf.enterPortAbbr("abbr", portAbbr);
		pf.driverWait();
		pf.clickAddUpdate("btnAddUpdate");
		pf.driverWait();
		pf.verifyWebTable("//*[@id=\'tblSite\']/tbody", portName);

}

	
	
	
	
@AfterMethod

public void endTest1() {
	
	endTest();
}

}