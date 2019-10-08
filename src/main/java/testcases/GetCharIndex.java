package testcases;

import java.util.Scanner;

public class GetCharIndex {
	
	public void getCharInd(String s, int a) {
		
		System.out.println(s.charAt(a));
	
		
		
	}

	public static void main(String[] args) {
		
		GetCharIndex gi = new GetCharIndex();
		
		System.out.println("Enter the string");
		
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		System.out.println("Enter index to get character");
		int a = sc.nextInt();
		gi.getCharInd(s, a);
		sc.close();

	}

}
