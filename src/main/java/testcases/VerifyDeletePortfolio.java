package testcases;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Portfolio;





public class VerifyDeletePortfolio extends Portfolio {
	
	@BeforeMethod
	public void beforeMethod(){
		startTest("VerifyDeletePorfolio", "Portfolio Delete");
		
	}
	@Test(dataProvider="portfolioDetails")
	public void deletePortfolio(String portName,String portAbbrName) throws InterruptedException, NullPointerException, IOException {
	Portfolio pf = new Portfolio();
	pf.launchBrowser();
	pf.appLogin("mk","12345");
	pf.driverWait();
	pf.clickApplicationSetting("//*[@id='appMenu']/a/span");
	pf.clickPortfolio("portMenu");
	pf.driverWait();
	pf.searchPortfolioName("//*[@id=\'tblSite_filter\']/label/input", portName);
	pf.clickDeletePortfolio("//*[@id=\"tblSite\"]/tbody/tr/td[5]/a[2]");
	pf.driverWait();
	pf.confirmDletePortAlert("/html/body/div[6]/div[7]/div/button");
	pf.driverWait();
	pf.searchPortfolioName("//*[@id=\'tblSite_filter\']/label/input", portName);
	pf.driverWait();
	pf.checkPortfolioDeleted("No matching records found", "//*[@id=\'tblSite\']/tbody/tr/td");
	
	

	}
@AfterMethod
	
	public void endTest1() {
		
		endTest();
	}
	

}
