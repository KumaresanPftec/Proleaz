package testcases;

import java.util.Scanner;

public class PalinString {
	
	public static void main(String args[]) {
		
		String original, reverse="";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value to check ");
		original = sc.nextLine();
		
		for(int i=original.length()-1; i>=0; i--) {
			
			reverse = reverse+original.charAt(i);
		}
		
		if(reverse.equals(original))
			System.out.println("Given string is palin ");
		
		else
			System.out.println("Given String is not palin ");
		
		sc.close();
	}

}
