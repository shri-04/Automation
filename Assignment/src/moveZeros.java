import java.util.HashMap;

public class moveZeros {
	
	public static int[] zerosLeft(int[]arr) {
	int array;
	int n= arr.length;

	
	for(int i=arr.length-1;i>0;i++) {
		if(arr[i]!=0) {
			n=arr[i];
			i--;
				
		}
		
		if(n>arr.length) {
			arr[n--]=0;
		}
	}
	return arr;
	}
	
	
	public static void duplicatechar(String str) {
		Character ch;
		String str1="";
		HashMap<Character, Integer> hm= new HashMap<Character, Integer>();
		for(int i=0;i<str.length();i++)
	{   ch= str.charAt(i);
	if(hm.containsKey(ch)) {
		
		hm.put(ch, hm.get(ch)+1);}
		else {
			
			hm.put(ch, 1);
			str1=str1+ch;
		
	}}
	//0,1,1,2
		System.out.println(str1);
		
		
	}
	
	
	
	public static void fibonacciseries(int n) {
		int a=0;
		int b=1;
		System.out.println(a);
		System.out.println(b);
		while(n>2) {
			int c=a+b;
			a=b;
			b=c;
			
			n--;
			System.out.println(c);
		}
		
	
	}
	
	public static void sortArray(int arr[]) {
		int temp =0;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]<arr[j]) {
					temp= arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
				
			}System.out.println(arr[i]);
		}
		
		
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="aaaaffhtcssu";
		int arr1[]= {12,7,4,43,90,7,0};
int arr[]= {0,0,0,2,4,5,6,0,0,11,32,8,4,3,0,0,67,8,9,0};
//System.out.println(zerosLeft(arr));
//System.out.println(arr.length);
//fibonacciseries(10);
		//duplicatechar(str);

sortArray(arr1);
		
		//{0,0,0,2,4,5,6,0,0,11,32,8,4,3,0,0,67,8,9,0}
		//{0,0,0,0,0,0,2,4,5,6,,11,32,8,4..}

	}

}
