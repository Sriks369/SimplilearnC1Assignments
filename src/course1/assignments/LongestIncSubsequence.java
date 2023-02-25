package course1.assignments;

import java.io.IOException;
import java.util.Arrays;

public class LongestIncSubsequence {
public static int[] longestIncreasingSubSequence(int[] a) {
		
		int[] resultArray;
		int[] tempArray = new int[a.length];
		tempArray[0] = a[0];
		 
		int k=1;
		for(int i=1;i<a.length;i++) {
			
			if(a[i]>tempArray[k-1]) {
				
				tempArray[k]=a[i];
				k++;
			}else {
				continue;
			}
			}
		resultArray = new int[k];
	        for(int i=0;i<a.length;i++) {
	        	if(!(tempArray[i]==0)) {
	        		resultArray[i]=tempArray[i];
	        	}
	        }		  
		return resultArray;
	}
	
	public static void main(String[] args) throws IOException {
		 
		int[] x = {10,22,9,33,21,50,41,60,80};
		
		System.out.println(Arrays.toString(longestIncreasingSubSequence(x)));      
      }		

}
