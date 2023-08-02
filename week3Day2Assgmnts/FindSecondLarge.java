package week3Day2Assgmnts;

import java.util.Arrays;

public class FindSecondLarge {
		/*
			 Pseudo Code:
			 1) Arrange the array in ascending order
			 2) Pick the 2nd element from the last and print it
			 */
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Here is the input
		int[] data = {3,2,11,4,6,7};
		Arrays.sort(data);
		int len = data.length;
		System.out.println(data[len-2]);
	}

}
