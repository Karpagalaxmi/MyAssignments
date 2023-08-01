package week3Day1Assgmnts;


/*
Pseudo Code
* Declare String Input as Follow 
* String test = "changeme";
* a) Convert the String to character array
* b) Traverse through each character (using loop)
* c)find the odd index within the loop (use mod operator)
* d)within the loop, change the character to uppercase, if the index is odd else don't change

*/
public class ChangeOddIndexToUpperCase {

		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "changeme";
		System.out.println("ChangeOddIndexToUpperCase" +"\n\nGiven String : "+test);
		char[] ch = test.toCharArray();
		
		System.out.print("Modified String: ");	
		for (int i = 0; i < ch.length; i++) {
			if(i%2!=0) {				
				if (Character.isLowerCase(ch[i]))
					ch[i] = Character.toUpperCase(ch[i]);
			}
			System.out.print(ch[i]);
		}
		
	}
		
}
