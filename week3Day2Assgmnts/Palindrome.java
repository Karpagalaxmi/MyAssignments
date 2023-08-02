package week3Day2Assgmnts;

public class Palindrome {

	/*	//Build a logic to find the given string is palindrome or not
     
	/*
	 * Pseudo Code	
	 * a) Declare A String value as"madam"
	 * b) Declare another String rev value as ""
	 * c) Iterate over the String in reverse order
	 * d) Add the char into rev
	 * e) Compare the original String with the reversed String, if it is same then print palinDrome 
	 * Hint: Use .equals or .equalsIgnoreCase when you compare a String 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String value = "madam";
		String rev = "";
		
		char[] arr = value.toCharArray();
		for (int i = arr.length-1;i >= 0; i--) {
			rev=rev+arr[i];
		}
		
		System.out.println("Given String : "+value);
		System.out.println("Reversed String : "+rev);
		
		if(value.equalsIgnoreCase(rev))
			System.out.println("Given String "+value + " is a Palindrome");
		else
			System.out.println("Given String "+value + " is not a Palindrome");
				
		
	}

}
