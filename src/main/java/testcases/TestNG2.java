package testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG2 {
	
	/* @BeforeSuite
	public void beforeSuite() {
		
		System.out.println("@Before suite is running - tesng2");
	}
	
	@AfterSuite
	public void afterSuite() {
		
		System.out.println("After Suite is running - tesng2");
	}*/
	
	@BeforeTest
	public void beforeTest() {
		
		System.out.println("Before test is running - tesng2");
	}
	
	@AfterTest
	public void afterTest() {
		
		System.out.println("After test is running - tesng2");
		
	}
	
	/*@BeforeMethod
	public void beforeMethod() {
		
		System.out.println("Before Method is running - tesng2");
	}
	
	@AfterMethod
	public void afterMethod() {
		
		System.out.println("After Method is running - tesng2");
		
	}*/
	
	@Test(priority =1, groups= {"firstLevel"})
	public void test1() {
		
		System.out.println("Test Case 1 is running - tesng2");
	}
	
	@Test(priority =2, alwaysRun=false)
	public void test2() {
		
		System.out.println("Test Case 2 is running - tesng2");
	}

	
	@Test(priority =3 ,groups= {"secondLevel"})
	public void test3() {
		
		System.out.println("Test Case 3 is running - tesng2");
	}
	
	/*@BeforeClass
	public void beforeClass() {
		System.out.println("Before class is running - testng2");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After class is running - testng2");
	}*/
}


