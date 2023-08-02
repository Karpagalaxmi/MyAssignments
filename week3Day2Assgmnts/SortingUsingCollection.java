package week3Day2Assgmnts;

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
import java.util.*;


public class SortingUsingCollection {

	// Declare a String array and add the Strings values as (HCL, Wipro,  Aspire Systems, CTS)		
		// get the length of the array		
		// sort the array			
		// Iterate it in the reverse order
		// print the array
		// Required Output: Wipro, HCL , CTS, Aspire Systems

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*String[] values1 = {"HCL", "Wipro",  "Aspire Systems", "CTS"};
		int len = values1.length;
		Arrays.sort(values1);
		for (int i = len-1; i >= 0; i--) {
			System.out.println(values1[i]);
		}*/		
		
		List<String> values = new ArrayList<String>();
		values.add("HCL");
		values.add("Wipro");
		values.add("Aspire Systems");
		values.add("CTS");
		
		Collections.sort(values);
		for (int i =  values.size()-1; i >= 0; i--) {
			System.out.println(values.get(i));
		}
		
		
	}

}
