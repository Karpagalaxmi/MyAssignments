package week1.day2.assignments;

public class Palindrome {
	
	 /*
	Check the given number is palindrome or not 
	Int num =34343
	Initialize a  temporary variable.
	Reverse the number (using for loop and add to the temporary variable)
	Compare the temporary number with reversed number
	If both numbers are same, print "palindrome number"
	Else print "not palindrome number" */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 34343;
		int temp = 0;
		int num1 = num;
		System.out.println("Given number : " + num1);
		for (;num>0;)
		{
		    temp = temp*10 + (num % 10);
		    num = num / 10;
		    
		}
		 System.out.println("Reversed Number :" + temp);
		 if (num1 == temp)
			 System.out.println("Given Number "+ num1 + " is Palindrome");
		 else
			 System.out.println("Given Number "+ num1 + " is not Palindrome");
		 
	}

}
