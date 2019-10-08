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

public class TestNG {
	
	
	@BeforeSuite
	public void beforeSuite() {
		
		System.out.println("Before suite is running");
	}
	
	@AfterSuite
	public void afterSuite() {
		
		System.out.println("After Suite is running");
	}
	
	@BeforeTest
	public void beforeTest() {
		
		System.out.println("Before test is running");
	}
	
	@AfterTest
	public void afterTest() {
		
		System.out.println("After test is running");
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		
		System.out.println("Before Method is running");
	}
	
	@AfterMethod
	public void afterMethod() {
		
		System.out.println("After Method is running");
		
	}
	
	@Test(priority =1, groups="Priority 1 method", alwaysRun=true)
	public void test1() {
		
		System.out.println("Test Case 1 is running");
	}
	
	@Test(priority =2, alwaysRun=true, groups="Priority 2 method", dependsOnGroups="Priority 1 method")
	public void test2() {
		
		System.out.println("Test Case 2 is running");
	}

	
	@Test(priority =3, groups="Priority 3 method", dependsOnGroups= {"Priority 1 method" , "Priority 2 method"}, invocationCount=2, invocationTimeOut=10)
	public void test3() {
		
		System.out.println("Test Case 3 is running");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class is running ");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After class is running");
	}
}
