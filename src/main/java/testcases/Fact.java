package testcases;

import java.util.Scanner;

public class Fact {
	
	public static void main(String args[]) {
		
		int fact=1, n;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter value to fact ");
		n=sc.nextInt();
		
		if(n>0) {
		
		for(int i=1; i<=n; i++) {
			
			fact=fact*i;
		}
		System.out.println("fact alue of "+n+" is= "+fact);
		}else {
			
			
			System.out.println("0 fact is 0");
		}
		
	
		sc.close();
	}

}
