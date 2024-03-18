import java.util.HashMap;

public class Test2 {

	public static void removeDuplicate(String str) {
		 str= str.replace(" ", "");
		 String output="";
		HashMap<Character, Integer> hm= new HashMap<Character, Integer>();
		for(int i=0;i<=str.length()-1;i++) {
			char c= str.charAt(i);
			
			if(hm.containsKey(c)) {
				hm.put(c, hm.get(c)+1);
			}else {
				
				hm.put(c, 1);
			}
		}
		System.out.println(hm);
	
	for(int i= 0;i<=str.length()-1;i++) {
		char c =str.charAt(i);
		if(hm.get(c)==1){
			output= output+c;
			
		}
	}System.out.println(output);
	}
	
	public static void capitalize(String str) {
    
    
    String str2= str.substring(0,1).toUpperCase()+str.substring(1);
    String words[]= str2.split(" ");
    
   for(int i=0;i<words.length;i++) {
	   
     System.out.println(words[i]);
 
    	words[i].toUpperCase();
    }
   System.out.println(words);
   
	}
  
    
    
    
//    for(int i=0;i<=str.length()-1;i++) {
//	  if(str2.charAt(i) == ' ') {
//		 str2=str2+ str.substring(i+1,i+2).toUpperCase();
//	  }
//	  else {
//		  
//	  }
//  }
//	 
//	 System.out.println(str2);
//		
//	}
//	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String str ="Shriya Singh";
String str1= "a beautifull morning";
capitalize(str1);

//removeDuplicate(str);
	}

}
