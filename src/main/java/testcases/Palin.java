package testcases;

import java.util.Scanner;

public class Palin {
	
	private static int getValue(int n) {
		
		int r, temp, sum=0;
		
		temp = n;
		
		while(n>0) {
			
			r = n%10;
			sum = (sum*10)+r;
			n=n/10;
		}
		if(sum==temp) {
			
			System.out.println("Entered value is pal ");
		}
		else {
			
			System.out.println("Entered value is not pal ");
		}
		
		
		return sum;
		
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value to work out / check ");
		int n =	sc.nextInt();
		getValue(n);
		sc.close();
	
	}

}
