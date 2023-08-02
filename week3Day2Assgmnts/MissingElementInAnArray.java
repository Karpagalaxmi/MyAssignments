package week3Day2Assgmnts;

import java.util.Arrays;

public class MissingElementInAnArray {
			// Sort the array	
			// loop through the array (start i from arr[0] till the length of the array)
			// check if the iterator variable is not equal to the array values respectively
			// print the number
			// once printed break the iteration
					
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Here is the input
		int[] arr = {1,2,3,4,7,6,8};
		Arrays.sort(arr);
		int j =0;
		for (int i = 0; i < arr.length; i++) {
			j = i+1;
			if(arr[i] != j) {
				 System.out.println("Missing Element in the given Array : "+j);
				 break;
			}
		}
	
	}

}
