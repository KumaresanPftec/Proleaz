package testcases;

import java.util.Scanner;

public class ToSwitch {
	
	public void caseSwitch(int read) {
		
		switch(read) {
		case 10: System.out.println("entered number is " +read);
		break;
		
		case 20: System.out.println("entered number is " +read);
		break;
		
		default: System.out.println("value is out of case");
		}
		
		
	}

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter value to compare " );
		
		int a = sc.nextInt();
		
		ToSwitch ts  = new ToSwitch();
		ts.caseSwitch(a);
		

	}

}
