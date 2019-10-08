package testcases;

import java.util.Scanner;

import org.apache.poi.util.SystemOutLogger;

public class Reversepharase {
	
	public static void print() {
		
		System.out.println("Printing Process... ");
	}
	
	public static String revPhrase(String inputString) {
		
		String[] words = inputString.split("\\s");
		
		String outputString="";
		
		for(int i=words.length-1; i>=0; i--) {
			
			outputString = outputString + words[i] + " ";
		}
		
		
		print();
		
		return outputString;
	}
	
	
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter phrase to rev ");
		String inputString = sc.nextLine();
		String outputString  = revPhrase(inputString);
		System.out.println("outputString " +outputString);
		sc.close();
		
		
		
		
	}

}
