package testcases;

public class ExtendAbs extends ToAbstract {
	
	void method() {
		
		System.out.println("Abs method implement and printed");
	}



	public static void main(String[] args) {
		
		ExtendAbs ea = new ExtendAbs();
		ea.print();
		ea.method();
		
		

	}


	

}
