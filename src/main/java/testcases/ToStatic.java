package testcases;

public class ToStatic {

	static {
		System.out.println("Static block is loading....");
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Main method is loading....");
		

	}

}
