package week1.day2.assignments;

import java.util.Iterator;

public class PrimeNumber {
	/* Goal: To find whether a number is a Prime number or not
	 * input: 13
	 * output: 13 is a Prime Number
	 */

	// Declare an int Input and assign a value 13
	// Declare a boolean variable flag as false
	// Iterate from 2 to half of the input
	// Divide the input with each for loop variable and check the remainder
	// Set the flag as true when there is no remainder
	// break the iterator
	// Check the flag (Provide a condition)
	// Print 'Prime' when the condition matches
	// Print 'Not a Prime' when the condition doesn't match 

	public static void main(String[] args) {

		int num = 13;
		int value = 0;
		boolean flag = false;
		
		for (int i = 2; i < num/2; i++)
		{
			value = num%i;
			if(value == 0) {
				flag = true;
				break;
			}
		}
		
		if (flag != true)
			System.out.println("Given number "+num+" is Prime");
		else 
			System.out.println("Given number "+num+" is not Prime");
					
		}		
	
   }

