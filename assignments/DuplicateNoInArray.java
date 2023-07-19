package week1.day2.assignments;

import java.util.Arrays;

public class DuplicateNoInArray {

	public static void main(String[] args) {
		// Find duplicate number in a given array
		
		int[] nums= {2,5,7,7,5,9,2,3};
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length; i++) {
			if ((i+1) == nums.length) break;
			if(nums[i] == nums[i+1])
				System.out.println(nums[i+1]);
		}
	}

}
