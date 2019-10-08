package pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import wrappers.CommonWrappers;

public class Lease extends CommonWrappers{
	
	/*public Lease clickOnLeaseMenu(String Xpath) throws NullPointerException, IOException {
		
		extentLog(clickByXPath(Xpath), "Lease Menu is clicked", "Lease menu is not clicked");
		
		
		return new Lease();
		
		
	}*/
	
	public Lease mouseOverOnLeaseMenu(String XPath) throws NullPointerException, IOException {
		
		
		extentLog(mouseOverByXpath(XPath), "Lease Menu is clicked", "Lease menu is not clicked");
		
		
		return new Lease();
	}

	public Lease clickLease(String leaseXPath) throws NullPointerException, IOException {
		
		extentLog(clickByXPath(leaseXPath),"Lease dashboard redirected" , "Lease dashboard is not redirected");
		
		return new Lease();
		
	}
	
	public Lease clickCreateBtn(String createId) throws NullPointerException, IOException, InterruptedException {
		
		extentLog(clickById(createId), "Create button is clicked", "Create button is not clicked");
		
		return new Lease();
		
	}
}
