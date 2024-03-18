
public class Test1 {
	public static void reverseString(String str) {
		char[] c = str.toCharArray();
		int l=0;
		int r=c.length-1;
		while(l>r) {
			
			char temp=c[l];
			c[r]=c[l];
			
			l++;
			r--;
			
		}
		
		//String str1=c.toString();
		System.out.println(c);
	}
	
	
	
	
	public static void main (String[] args) {
		String name= "Shriya";
		reverseString(name);
	}

}
