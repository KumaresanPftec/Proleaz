package testcases;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Portfolio;
public class VerifyEditPortfolio extends Portfolio{
	
	@BeforeMethod
	public void beforeMethod(){
		startTest("VerifyEditPorfolio", "Portfololio Edit");
		
	}
	@Test(dataProvider="portfolioDetails")
	
	
	public void editPortfolioSave(String portName, String portAbbr) throws InterruptedException, NullPointerException, IOException {
		
		Portfolio pf = new Portfolio();
		pf.launchBrowser();
		pf.appLogin("mk","12345");
		pf.driverWait();
		pf.clickApplicationSetting("//*[@id='appMenu']/a/span");
		pf.clickPortfolio("portMenu");
		pf.searchPortfolioName("//*[@id=\'tblSite_filter\']/label/input", portName);
		pf.clickEdit("lnkedit");
		pf.checkSavedPortfolioDisplayedInEdit(portName, "pname");
		pf.checkSavedPortfolioAbbrDisplayedInEdit(portAbbr, "abbr");
		pf.clearPortfolio("pname");
		pf.enterPortfolioName("pname", portName+1);
		pf.clearPortfolio("abbr");
		pf.enterPortAbbr("abbr", portAbbr+1);
		pf.clickAddUpdate("btnAddUpdate");
		pf.driverWait();
		pf.searchPortfolioName("//*[@id=\'tblSite_filter\']/label/input", portName+1);
		pf.driverWait();
		pf.checkPortfoliloSaved(portName+1, "//*[@id=\'tblSite\']/tbody/tr/td[2]");
		pf.checkPortfolioAbrrSaved(portAbbr,"//*[@id=\'tblSite\']/tbody/tr/td[3]");
		
	
	
	}
	
@AfterMethod
	
	public void endTest1() {
		
		endTest();
	}
	

}
