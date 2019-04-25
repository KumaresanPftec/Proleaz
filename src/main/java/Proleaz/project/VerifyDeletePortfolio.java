package Proleaz.project;
import org.testng.annotations.Test;

import pages.Portfolio;


@Test(dataProvider="portfolioDetails")
public class VerifyDeletePortfolio extends Portfolio {
	
	public void deletePortfolio(String portName,String portAbbrName) throws InterruptedException {
	Portfolio pf = new Portfolio();
	pf.launchBrowser();
	pf.appLogin("mk","12345");
	pf.driverWait();
	pf.clickApplicationSetting("//*[@id='appMenu']/a/span");
	pf.clickPortfolio("portMenu");
	pf.searchPortfolioName("//*[@id=\'tblSite_filter\']/label/input", portName);
	pf.clickDeletePortfolio("//*[@id=\"tblSite\"]/tbody/tr/td[5]/a[2]");
	pf.driverWait();
	pf.confirmDletePortAlert("/html/body/div[6]/div[7]/div/button");
	pf.searchPortfolioName("//*[@id=\'tblSite_filter\']/label/input", portName);
	pf.checkPortfolioDeleted("No matching records found", "//*[@id=\'tblSite\']/tbody/tr/td");
	
	
}

}
