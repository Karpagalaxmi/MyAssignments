package week1.day1;

public class Maths1 {

	public static void main(String[] args) {
		
		Maths obj1=new Maths();
		
		obj1.sub("Class 2");
		
		obj1.operations ("Addition Class2");
		System.out.println(obj1.add(10, 25));
		
		obj1.operations ("Multiplication Class2");
		float mulvalue1 = obj1.multiply(15,14);
		System.out.println(mulvalue1);
		
		obj1.operations ("Division Class2");
		double divvalue1 = obj1.divide(10, 3);
		System.out.println(divvalue1);
	}

}
