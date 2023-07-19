package week1.day2.assignments;

public class NegativeToPositiveConversion {

	/*Assignment:3
	Convert a negative number to positive number
	
	1. Initialize an integer with a negative number like, int number = -40;
	2. Check if the number is a negative number
	 Hint : any number that is lesser than zero is a negative number
	 3. If so, convert the number to a positive number
	4. Print as below "The number -40 is converted to 40" */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nvalue = -27;
		
	if (nvalue < 0) {
			int pvalue = nvalue *-1;
			System.out.println("The number "+nvalue +" is converted to "+pvalue);	
		}
				
		
	}

}
