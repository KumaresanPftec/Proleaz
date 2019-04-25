package Proleaz.project;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import pages.Portfolio;

public class VerifyPortfolio extends Portfolio {
	
	

	
	@Test(dataProvider="portfolioDetails")
	public void verifyPortfolioIsSaved(String portName, String portAbbr) throws InterruptedException {
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
		pf.searchPortfolioName("//*[@id=\'tblSite_filter\']/label/input", portName);
		pf.checkPortfoliloSaved(portName, "//*[@id=\'tblSite\']/tbody/tr/td[2]");
		pf.checkPortfolioAbrrSaved(portAbbr,"//*[@id=\'tblSite\']/tbody/tr/td[3]");
		pf.closeDriver();
		
		
	}
	
}


//*[@id="appMenu"]/a/span