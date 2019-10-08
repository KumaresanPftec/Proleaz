package testcases;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 int n, sum=0, r, temp;
		 
		 System.out.println("Enter value to check ");
		 
		 Scanner scan = new Scanner(System.in);
		  n = scan.nextInt();	
		   temp=n;    
		  while(n>0){    
		   r=n%10;  //getting remainder  
		   sum=(sum*10)+r;    
		   n=n/10; 
		  }
		   
		  if(temp==sum)    
			   System.out.println("Palin ");    
		   else    
			   System.out.println("Not Palin"); 
		     

	
	
	}

}
