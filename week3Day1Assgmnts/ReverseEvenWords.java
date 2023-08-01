package week3Day1Assgmnts;

public class ReverseEvenWords {
	
	/* Pseudo Code:			 
			 * Declare the input as Follow
		      		String test = "I am a software tester"; 
			a) split the words and have it in an array
			b) Traverse through each word (using loop)
			c) find the odd index within the loop (use mod operator)
			
			d)split the words and have it in an array
			
			e)print the even position words in reverse order using another loop (nested loop)
			f) Convert words to character array if the position is even else print the word as it is(concatenate space at the end).
			
		*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String test = "I am a software tester"; 
		String[] words = test.split(" ");		
		String result = "";
		
		System.out.println("Given String : " + "\n" +test);
		
		for (int i = 0; i < words.length; i++) 
		{
			if(i%2 !=0)
			{
				String rev="";
				char[] charr = words[i].toCharArray();
				
				for (int j = charr.length-1; j >= 0;j--) 
				{
					rev = rev + charr[j];
				}
				result = result + rev + " ";
			}
			else
				result = result + words[i] + " ";
	}
		
		System.out.println("After Reverse Even words: " +"\n"+result);
	}

}
