package testcases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PrintDec {
	
	
	public void printDec() {
		
		double d1 = 8999.664;
		
		int i = (int) d1;
		
		System.out.println(d1-i);
		
		String s1 ="6666.335";
		
		int i2 =s1.indexOf('.');
		
		int i3 =s1.length();
		
		System.out.println(s1.substring(i2, i3));
		
		
	}

	public void arrayLarge() {
		int n, max;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of elements in the array:");
        n = s.nextInt();
        System.out.println(n);
        int a[] = new int[n];
        System.out.println("Enter elements of array:");
        for(int i = 0; i < n; i++)
        {
            a[i] = s.nextInt();
        }
        max = a[0];
        for(int i = 0; i < n; i++)
        {
            if(max < a[i])
            {
                max = a[i];
            }
        }
        System.out.println("Maximum value:"+max);
		
	}
	
	public void arrayLarge2() {
		
		int n, max;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of element in the array");
		n=s.nextInt();
		
		int a[] = new int[n];
		System.out.println("Enter element of array");
		
		for(int i=0; i<n; i++) {
			
			a[i] =s.nextInt();
		}
		 
		max=a[0];
		
		for(int i=0; i<n; i++) {
			
			if(max<a[i]) {
				
				max = a[i];
		
			}
			
		}
		
		System.out.println("Lrgst val " +max);
	}
	
	public void ascOrd() {
		{
	        int n, temp;
	        Scanner s = new Scanner(System.in);
	        System.out.print("Enter no. of elements you want in array:");
	        n = s.nextInt();
	        int a[] = new int[n];
	        System.out.println("Enter all the elements:");
	        for (int i = 0; i < n; i++) 
	        {
	            a[i] = s.nextInt();
	        }
	        for (int i = 0; i < n; i++) 
	        {
	            for (int j = i + 1; j < n; j++) 
	            {
	                if (a[i] > a[j]) 
	                {
	                    temp = a[i];
	                    a[i] = a[j];
	                    a[j] = temp;
	                }
	            }
	        }
	        System.out.print("Asc Order:");
	        for (int i = 0; i < n - 1; i++) 
	        {
	            System.out.print(a[i] + ",");
	        }
	        System.out.print(a[n - 1]);
	    }
	}
	
	
	
	public void arrayString() {
		
		String[] s = {"t", "e", "s", "t"};
		
		for(int i=s.length-1; i>=0; i--) {
			
			System.out.println(s[i]);
			
		}
		 
		
	}
	
	public void arrayInt() {
		
		int[] n = {1,2,3,4,5};
		
		for(int i=n.length-1; i>=0; i--) {
			
			System.out.println(n[i]);
		}
	}
	
	public void arrayList() {
		
		ArrayList<String> lis = new ArrayList<String>();
		
		lis.add("kumar");
		lis.add("Raj");
		lis.add("kita");
		lis.add("kumar");
		
		System.out.println("Size of the array list is " +lis.size());
		
		Iterator itr = lis.iterator();
		
		while(itr.hasNext()) {
			
			System.out.println(itr.next());
		}
	}
	
	
	
	public static void main(String args[]) {
		

	PrintDec p1 = new PrintDec();
	/*p1.printDec();
	p1.arrayLarge();
	p1.arrayLarge2();
	p1.arrayString();
	p1.arrayInt();
	*/
	p1.arrayList();
	
	}

}
