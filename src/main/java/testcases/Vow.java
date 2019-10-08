package testcases;

import java.util.Scanner;

public class Vow {
	
	
	public void findV() {
		
		String s;
		int count=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String to traverse");
	
		s = sc.nextLine();
		
		for(int i=0; i<s.length()-1; i++) {
			
			
			char c = s.charAt(i);
			
			if(c=='a'||c=='e') {
				
				count++;
				
			}
		}

		System.out.println(count);
	
	}
	
	public static void main(String args[]) {
		
		Vow v = new Vow();
		
		v.findV();
	}
	
}

