package testcases;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Lease;

public class VerifyFRLeaseCreation extends Lease {
	
	
	@BeforeMethod
	public void beforeMethod(){
		
		startTest("Verify Fixed Rental Lease Creation", "Create Fixed Rental Lease");
		
	}
	
	@Test
	public void createFRLease() throws NullPointerException, IOException, InterruptedException {
		Lease ls =new Lease();
		ls.launchBrowser();
		ls.appLogin("mk", "12345");
		ls.driverWait();
		ls.mouseOverOnLeaseMenu("/html/body/div[3]/div[1]/div[2]/div/div/ul/li[3]/a/i");
		ls.driverWait();
		ls.clickLease("/html/body/div[3]/div[1]/div[2]/div/div/ul/li[3]/ul/li[2]/a");
		ls.driverWait();
		ls.clickCreateBtn("LeaseSubmit");
		
		
		
	}
	
	
@AfterMethod
	
	public void endTest1() {
		
		endTest();
	}
	
}

