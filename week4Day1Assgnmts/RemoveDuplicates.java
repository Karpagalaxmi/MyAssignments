package week4Day1Assgnmts;

import java.util.*;

public class RemoveDuplicates {
	
//	Declare a String as "PayPal India"
//	Convert it into a character array
//	Declare a Set as charSet for Character
//	Declare a Set as dupCharSet for duplicate Character
//	Iterate character array and add it into charSet
//	if the character is already in the charSet then, add it to the dupCharSet
//	Check the dupCharSet elements and remove those in the charSet
//	Iterate using charSet
//	Check the iterator variable isn't equals to an empty space
//	print it

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "Paypal India";
		char[] arr = input.toCharArray();
		
		Set<Character> charSet = new LinkedHashSet<Character>();
		Set<Character> dupCharSet = new LinkedHashSet<Character>();
		
		System.out.println("Given String : "+input);
		for (Character character : arr)
		{
				if(!(charSet.contains(character))) 
					charSet.add(character);
				else	
					dupCharSet.add(character);	
		}
		
		for (Character dupCharacter : dupCharSet) {
			if(charSet.contains(dupCharacter))
				charSet.remove(dupCharacter);
		}
		
		System.out.print("\nCharacter Set : ");	
		for (Character character : charSet) 
		{
			if(!(character.equals(' ')))
					System.out.print(character);
		}
			
		System.out.println("\nDuplicate set : "+dupCharSet);
	}

}
