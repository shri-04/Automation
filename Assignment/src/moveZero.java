import java.util.Arrays;

public class moveZero {
	 public static void swapArr(int arr[],int i, int j){
	        int temp= arr[i];
	        arr[i]= arr[j];
	        arr[j]=temp;
	    
	    }
	    public static int[] moveZeros(int arr[]){
	        boolean swap= true;
	        while(swap){
	            swap=false;
	            for(int i=1;i<arr.length;i++){
	                if(arr[i]==0 && arr[i-1]!=0){
	                swapArr(arr,i,i-1);
	                swap=true;
	            }
	                
	        }
	           
	            
	        }
	        
	        
	        return arr;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  int arr[]={45,77,23,0,65,7,0,99};
         int result[]=moveZeros(arr);
        System.out.println(Arrays.toString(result));

	}

}
