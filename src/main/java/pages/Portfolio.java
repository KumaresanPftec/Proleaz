package pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import wrappers.CommonWrappers;

public class Portfolio extends CommonWrappers {
	
	
	
	public Portfolio clickApplicationSetting(String appSettingXpath) throws NullPointerException, IOException {
		
		
		
		
		extentLog(clickByXPath(appSettingXpath), "App Setting is clicked", "App Setting is not clicked");
		
		
		/*Reporter.log("Application Setting is clicked");
		try {
			getScreenshot();
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}*/
		//"//*[@id=\'appMenu\']/a/b"
		return new Portfolio();
	}
	
	public Portfolio clearPortfolio(String id) {
		
		clearById(id);
		
		
		return new Portfolio();
	}

	public Portfolio clickPortfolio(String portId) throws InterruptedException, NullPointerException, IOException {
		
	
		
		extentLog(	clickById(portId), "Portfolio is clicked", "Portfolio is not clicked");
		
		/*Reporter.log("Portfolio is clicked");
		try {
			getScreenshot();
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}*/
		return new Portfolio();
	}
	
	
	public Portfolio enterPortfolioName(String portId , String portfolioName) throws InterruptedException, NullPointerException, IOException {
		
		
		
		extentLog(	enterTextById(portId, portfolioName), "Portfolio name  is clicked", "Portfolio name is not clicked");
	
	
	/*	Reporter.log("Portfolio Name is entered = "+portfolioName+"");
		try {
			getScreenshot();
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}*/
		return new Portfolio();
	}

	public Portfolio enterPortAbbr(String portAbbrId, String portAbbrName) throws InterruptedException, NullPointerException, IOException {
		
		
		extentLog(	enterTextById(portAbbrId, portAbbrName), "PortfolioAbbr nameis clicked", "PortfolioAbbr name is not clicked");
		
	/*	Reporter.log("Portfolio abbr is entered= "+portAbbrName+"");
		try {
			getScreenshot();
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}*/
		return new Portfolio();
	}
	
	public Portfolio clickAddUpdate(String addUpdtbtnId) throws InterruptedException, NullPointerException, IOException {
		
		
		
		extentLog(	clickById(addUpdtbtnId), "Add/Update is clicked", "Add/Update is not clicked");
		
	/*	Reporter.log("Portfolio, Portfolio abbr are saved");
		try {
			getScreenshot();
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}*/
		return new Portfolio();
		
	}
	
	public Portfolio searchPortfolioName(String searchPath , String portfolioName) throws NullPointerException, IOException {
		
		
		
		extentLog(	enterByXPath(searchPath, portfolioName), "Portfolio is searched", "Portfolio is not searched");
	
		/*	Reporter.log("Portfolio name is searched ");
		try {
			getScreenshot();
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}*/
		return new Portfolio();
	}
	
	
	
	
	public Portfolio checkPortfoliloSaved(String enteredPortfolio, String xPath) throws NullPointerException, IOException {
		
		String savedPortfolio=getTextByXpath(xPath);
		
		if(savedPortfolio.equals(enteredPortfolio)) {
			extentLog(	true, "Portfolio is saved", "Portfolio is not saved");
		}
		else {
			extentLog(	false, "Portfolio is saved", "Portfolio is not saved");
		}
		/*try {
			getScreenshot();
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}*/
		Assert.assertEquals(savedPortfolio, enteredPortfolio);
		
		return new Portfolio();
	}
	
	public Portfolio checkPortfolioAbrrSaved(String enteredPortAbbrName, String xPath) throws NullPointerException, IOException {
		
		String savedPortAbbrName = getTextByXpath(xPath);
		
		if(savedPortAbbrName.equals(enteredPortAbbrName)) {
			
			extentLog(	true, "PortfolioAbbr is saved", "PortfolioAbbr is not saved");
		}
		else {
			extentLog(	false, "PortfolioAbbr is saved", "PortfolioAbbr is not saved");
		}
	/*	try {
			getScreenshot();
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}*/
		Assert.assertEquals(savedPortAbbrName, enteredPortAbbrName);
		
		
		return new Portfolio();
	}
	
	
	@DataProvider(name="portfolioDetails")
    public Object[][] getValidInLogins(){
    return new Object[][] 
    	{
            
            { "TestPortfolio", "TESTP"},
           
        };
}
	
	@DataProvider(name="portfolioEditDetails")
    public Object[][] getPortfolioEditDetails(){
    return new Object[][] 
    	{
            
            { "TestPortfolio", "TESTP"},
           
        };
}
	
public Portfolio checkPortfolioDeleted(String expectedMessage, String Xpath) throws NullPointerException, IOException {
	
	String actaulMessage = getTextByXpath(Xpath);
	if(actaulMessage.equals(expectedMessage)) {
		
		extentLog(	true, "Portfolio is deleted", "PortfolioAbbr is not deleted");
	}
	else {
		extentLog(	false, "Portfolio is  deleted", "Portfolio is not deleted");
	}
	/*try {
		getScreenshot();
	} 
	
	catch (IOException e) {
		
		e.printStackTrace();
	}*/
	Assert.assertEquals(actaulMessage, expectedMessage);
	
	
	
	
	
	
	return new Portfolio();
	
}
	

public Portfolio clickDeletePortfolio(String xPath) throws NullPointerException, IOException {
	
	
	
	extentLog(	clickByXPath(xPath), "confirmation alert is appeared", "confirmation alert is not appeared");
	try {
		getScreenshot();
	} 
	
	catch (IOException e) {
		
		e.printStackTrace();
	}
	
	return new Portfolio();
}
	
public Portfolio confirmDletePortAlert(String xPath) throws NullPointerException, IOException {
	
	
	
	extentLog(	clickByXPath(xPath), "Alert is confirmed", "Alert is not confirmed");

	
/*	try {
		getScreenshot();
	} 
	
	catch (IOException e) {
		
		e.printStackTrace();
	}
	*/
	return new Portfolio();
}

public Portfolio clickEdit(String id) throws InterruptedException, NullPointerException, IOException {
	
	
	extentLog(	clickById(id), "Alert is confirmed", "Alert is not confirmed");
	
/*	try {
		getScreenshot();
	} 
	
	catch (IOException e) {
		
		e.printStackTrace();
	}*/
	return new Portfolio();
	
}
public Portfolio checkSavedPortfolioDisplayedInEdit(String enteredPortfolio, String id) throws NullPointerException, IOException{
	
	String savedPortfolio=getTextValueByid(id);
	
	if(savedPortfolio.equals(enteredPortfolio)) {
		extentLog(	true, "Portfolio name is dispalyed", "Portfolio name is not displayed");
	}
	else {
		extentLog(	false, "Portfolio name is dispalyed", "Portfolio name is not displayed");
	}
/*	try {
		getScreenshot();
	} 
	
	catch (IOException e) {
		
		e.printStackTrace();
	}*/
	Assert.assertEquals(savedPortfolio, enteredPortfolio);
	
	return new Portfolio();
}
public Portfolio checkSavedPortfolioAbbrDisplayedInEdit(String enteredPortAbbrName, String id) throws NullPointerException, IOException{
	
	String savedPortAbbrName=getTextValueByid(id);
	
	if(savedPortAbbrName.equals(enteredPortAbbrName)) {
		extentLog(	true, "PortfolioAbbr name is dispalyed", "PortfolioAbbr name is not displayed");
	}
	else {
		extentLog(	false, "PortfolioAbbr name is dispalyed", "PortfolioAbbr name is not displayed");
	}
/*	try {
		getScreenshot();
	} 
	
	catch (IOException e) {
		
		e.printStackTrace();
	}*/
	Assert.assertEquals(savedPortAbbrName, enteredPortAbbrName);
	
	return new Portfolio();
}
	
	
}
