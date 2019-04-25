package pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import wrappers.CommonWrappers;

public class Portfolio extends CommonWrappers {
	
	
	
	public Portfolio clickApplicationSetting(String appSettingXpath) {
		
		clickByXPath(appSettingXpath);
		Reporter.log("Application Setting is clicked");
		try {
			getScreenshot();
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}
		//"//*[@id=\'appMenu\']/a/b"
		return new Portfolio();
	}
	
	public Portfolio clearPortfolio(String id) {
		
		clearById(id);
		
		
		return new Portfolio();
	}

	public Portfolio clickPortfolio(String portId) throws InterruptedException {
		
		clickById(portId);
		Reporter.log("Portfolio is clicked");
		try {
			getScreenshot();
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}
		return new Portfolio();
	}
	
	
	public Portfolio enterPortfolioName(String portId , String portfolioName) throws InterruptedException {
		
		enterTextById(portId, portfolioName);
		Reporter.log("Portfolio Name is entered = "+portfolioName+"");
		try {
			getScreenshot();
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}
		return new Portfolio();
	}

	public Portfolio enterPortAbbr(String portAbbrId, String portAbbrName) throws InterruptedException {
		enterTextById(portAbbrId, portAbbrName);
		Reporter.log("Portfolio abbr is entered= "+portAbbrName+"");
		try {
			getScreenshot();
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}
		return new Portfolio();
	}
	
	public Portfolio clickAddUpdate(String addUpdtbtnId) throws InterruptedException {
		
		clickById(addUpdtbtnId);
		Reporter.log("Portfolio, Portfolio abbr are saved");
		try {
			getScreenshot();
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}
		return new Portfolio();
		
	}
	
	public Portfolio searchPortfolioName(String searchPath , String portfolioName) {
		
		enterByXPath(searchPath, portfolioName);
		Reporter.log("Portfolio name is searched ");
		try {
			getScreenshot();
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}
		return new Portfolio();
	}
	
	
	
	
	public Portfolio checkPortfoliloSaved(String enteredPortfolio, String xPath) {
		
		String savedPortfolio=getTextByXpath(xPath);
		
		if(savedPortfolio.equals(enteredPortfolio)) {
			Reporter.log("Portfolio name is saved ");
		}
		else {
			Reporter.log("Portfolio name is not saved ");
		}
		try {
			getScreenshot();
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}
		Assert.assertEquals(savedPortfolio, enteredPortfolio);
		
		return new Portfolio();
	}
	
	public Portfolio checkPortfolioAbrrSaved(String enteredPortAbbrName, String xPath) {
		
		String savedPortAbbrName = getTextByXpath(xPath);
		
		if(savedPortAbbrName.equals(enteredPortAbbrName)) {
			
			Reporter.log("PortfolioAbbr is saved ");
		}
		else {
			Reporter.log("PortfolioAbbr is not saved ");
		}
		try {
			getScreenshot();
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}
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
            
            { "TestPortfolio1", "TESTP1"},
           
        };
}
	
public Portfolio checkPortfolioDeleted(String expectedMessage, String Xpath) {
	
	String actaulMessage = getTextByXpath(Xpath);
	if(actaulMessage.equals(expectedMessage)) {
		
		Reporter.log("Portfolio info deleted ");
	}
	else {
		Reporter.log("Portfolio info is not deleted ");
	}
	try {
		getScreenshot();
	} 
	
	catch (IOException e) {
		
		e.printStackTrace();
	}
	Assert.assertEquals(actaulMessage, expectedMessage);
	
	
	
	
	
	
	return new Portfolio();
	
}
	

public Portfolio clickDeletePortfolio(String xPath) {
	
	
	clickByXPath(xPath);
	Reporter.log("Confirmation alert is appeared ");
	try {
		getScreenshot();
	} 
	
	catch (IOException e) {
		
		e.printStackTrace();
	}
	
	return new Portfolio();
}
	
public Portfolio confirmDletePortAlert(String xPath) {
	
	
	clickByXPath(xPath);
	Reporter.log("Alert is confirmed ");

	
	try {
		getScreenshot();
	} 
	
	catch (IOException e) {
		
		e.printStackTrace();
	}
	
	return new Portfolio();
}

public Portfolio clickEdit(String id) throws InterruptedException {
	
	clickById(id);
	Reporter.log("Edit is clicked ");
	
	try {
		getScreenshot();
	} 
	
	catch (IOException e) {
		
		e.printStackTrace();
	}
	return new Portfolio();
	
}
public Portfolio checkSavedPortfolioDisplayedInEdit(String enteredPortfolio, String id){
	
	String savedPortfolio=getTextValueByid(id);
	
	if(savedPortfolio.equals(enteredPortfolio)) {
		Reporter.log("Portfolio name is Displayed ");
	}
	else {
		Reporter.log("Portfolio name is not Displayed ");
	}
	try {
		getScreenshot();
	} 
	
	catch (IOException e) {
		
		e.printStackTrace();
	}
	Assert.assertEquals(savedPortfolio, enteredPortfolio);
	
	return new Portfolio();
}
public Portfolio checkSavedPortfolioAbbrDisplayedInEdit(String enteredPortAbbrName, String id){
	
	String savedPortAbbrName=getTextValueByid(id);
	
	if(savedPortAbbrName.equals(enteredPortAbbrName)) {
		Reporter.log("PortfolioAbbr name is Displayed ");
	}
	else {
		Reporter.log("PortfolioAbbr name is not Displayed ");
	}
	try {
		getScreenshot();
	} 
	
	catch (IOException e) {
		
		e.printStackTrace();
	}
	Assert.assertEquals(savedPortAbbrName, enteredPortAbbrName);
	
	return new Portfolio();
}
	
	
}
