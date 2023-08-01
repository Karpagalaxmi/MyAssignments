package week3Day1Assgmnts;

public class ReverseGivenString {	
		/*Reverse the String
		==================
		String  input=“Amazon development centre,Chennai"; 
		Output = Chennai,centre development Amazon
		Goal: To understand String , loop
		a)Convert the string to lower case
		b)split the sentence with white space and get the count of the words
		c)Use for loop to iterate (from end to go to the first)
		d)Print the  reversed String
		*Hint  Use system.out.print() 
		Before writing the code – follow the 3 step process:
		Understand the problem
		Solve the problem (Using Pseudocode)
		Write the code */

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			String input = "Amazon development centre, Chennai";
					
			//a)Convert the string to lower case
			System.out.println("LowerCase :"+"\n"+ input.toLowerCase());
			
			//b)split the sentence with white space and get the count of the words
			System.out.println("\nSplit with Spaces :");
			String[] sp = input.split(" ");
			int count=0;
			for (int i = 0; i < sp.length; i++) {
				System.out.print(sp[i]);
				count++;
			}
			System.out.println("\n" + "Number of words : "+ count);
			
			//c)Use for loop to iterate (from end to go to the first)
			System.out.println("\nFrom end to first: ");
			int len = input.length();
			char[] ch = input.toCharArray();
			for (int i = len-1; i >= 0; i--) {
				System.out.print(ch[i]);		
			}
					
			//d)Print the  reversed String
			System.out.println("\n\nReverse of the String: ");
			for (int i = sp.length-1; i >= 0; i--) {
				System.out.print(sp[i] + " ");

			}
		
	}

}
