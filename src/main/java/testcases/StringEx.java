package testcases;

public class StringEx {

	public static void main(String[] args) {
		
		int i=10;
		int j=50;
		String s2="method of method";
		
		String s1=String.valueOf(i);
		
		System.out.println(j+i);
		System.out.println(s2+s1);
		
		System.out.println(s2.trim()+s1);
		System.out.println(s2.toUpperCase().trim().toLowerCase());
		System.out.println(s2.indexOf('u'));
		System.out.println(s2.indexOf("method",7));
		System.out.println(s2.indexOf('e', 4));
		System.out.println(s2.indexOf("of"));
		
		String s3="pathfinder";
		
		String s4 = new String("pathfinder");
		
		String s5 =s4.intern();
		
		if(s3==s5)
			System.out.println("memory location are equal");
		else if(s3.equals(s5)) {
			System.out.println("content are equal");
		}
		else {
			System.out.println("Memory location/Content are not equal");
		}
		
		String[] s6 = s2.split("\\s");
		
		for(String w : s6) {
			
			System.out.println(w);
		}
		
		System.out.println(s2.replace('o', 'i'));
		
		System.out.println(s2.replace("of", "if"));
		
		String s8 = String.join("_", "The", "Name", "is", "Kumaresan");
		
		System.out.println(s8);
		
		String s9="memory";
		System.out.println(s9.lastIndexOf('m'));
		System.out.println(s9.substring(1));
		System.out.println(s9.substring(1, 4));

	}
	

}
