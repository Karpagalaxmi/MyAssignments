package week4Day1Assgnmts;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueCharacter {
	//PrintUniqueCharacter
		/*
		 * Problem		
		 * a) Take your name as input
		 * b) Print all unique characters only (any order)
		 * Input:  babu
		 * Output: a u 
		 */

		/*
		 * Psuedocode
		 * a) Convert String to Character array
		 * b) Create a new Set -> HashSet
		 * c) Add each character to the Set and if it is already there, remove it
		 * d) Finally, print the set
		 * 
		 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String myName = "Karpagalaxmi";
		char[] ch = myName.toCharArray();
		
		Set<Character> name = new HashSet<Character>();
		System.out.println("Given Name : "+myName);
		
		for (Character character : ch) {
			if(!(name.contains(character))) {
				name.add(character);
			}
			else {
				name.remove(character);
			}
		}
		System.out.println("Unique Character :"+name);
		}	

}
