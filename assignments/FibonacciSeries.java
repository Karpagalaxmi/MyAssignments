package week1.day2.assignments;

public class FibonacciSeries {
			//Goal: To find Fibonacci Series for a given range
			//input(range): 8 output: 0, 1, 1, 2, 3, 5, 8, 13
			// initialize 3 int variables (Tip: range = 8, firstNum = 0, secNum = 1, sum in the series)
			// Print first number
			// Iterate from 1 to the range
			// add first and second number assign to sum
			// Assign second number to the first number
			// Assign sum to the second number
			// print sum

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int range =8, firstNum = 0, secNum = 1,sum=0;
		
		System.out.println(firstNum);
		System.out.println(secNum);
		for(int i=1;i<=range-2;i++)
		{
			sum=firstNum + secNum;
			System.out.println(sum);
			firstNum = secNum;
			secNum=sum;
		}
		

	}

}
