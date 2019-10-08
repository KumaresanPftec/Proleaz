package testcases;

public class ToFinal {
	
	static final int i;
	
	static {
		i=500;
	}
	 
	 ToFinal(){
		 System.out.println(i);
		
	 }
	
	
	public static void main(String args[]) {
		
		ToFinal tf = new ToFinal();
	
		
	}
	

}
