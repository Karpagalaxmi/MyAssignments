package week1.day2.assignments;

import java.util.Arrays;

public class SecondSmallestNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Find the Second smallest number in the array {23,45,67,32,89,22 }
		
		int[] arr = {23,45,67,32,89,22};
		Arrays.sort(arr);
		
		System.out.println("Second Smallest Number : "+arr[1]);
	}

}
