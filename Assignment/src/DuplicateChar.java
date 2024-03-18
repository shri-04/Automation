import java.util.HashMap;

public class DuplicateChar {

	public static void duplicateChar(String str)
	{ 
		Character ch;
       String dup="";

	HashMap<Character, Integer> hm= new HashMap<Character,Integer>();
	for(int i=0;i<str.length()-1;i++){
	ch= str.charAt(i);

	if(hm.containsKey(ch)){

	hm.put(ch,hm.get(ch)+1);

	}else {
	hm.put(ch,1);
	dup= dup+ch;
	}
	
	}

	System.out.println(dup);
	
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name ="Shriya Singh";
		duplicateChar(name);

	}

}
