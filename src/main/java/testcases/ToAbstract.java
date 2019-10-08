package testcases;

public abstract class ToAbstract {
	
	abstract void method();
	
	protected void print() {
		
		System.out.println("Private method can not be printed ");
	}

}
