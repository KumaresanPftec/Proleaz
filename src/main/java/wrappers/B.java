package wrappers;

import java.io.IOException;

import org.testng.annotations.Test;

public class B extends TestClass{
	
	
	@Test
public void print() throws RuntimeException{
		
		
		System.out.println("Print b");
		
	}
	
	public static void main(String args[]) {
		

		
		TestClass t1 = new TestClass();
	
		t1.print();
	}

}
