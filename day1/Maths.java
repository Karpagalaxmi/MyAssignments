package week1.day1;

public class Maths {
	
	public int add(int a,int b){
		return a+b;
	}
	
	public float multiply(float c,float d) {
		return c*d;
	}
	
	public double divide(double e,double f) {
		return e/f;
	}
	
	void sub(String heading) {
		System.out.println(heading);
	}
	
	public void operations(String operation) {
		System.out.println(operation);
	}
	
	public static void main(String[] args) {
		
		Maths obj=new Maths();
		
		obj.sub("Arithmetic Operations");
		
		obj.operations ("Addition");
		System.out.println(obj.add(120, 30));
		
		obj.operations ("Multiplication");
		float mulvalue = obj.multiply(16,5);
		System.out.println(mulvalue);
		
		obj.operations ("Division");
		double divvalue = obj.divide(15.50, 3.2);
		System.out.println(divvalue);
			
	}

}
