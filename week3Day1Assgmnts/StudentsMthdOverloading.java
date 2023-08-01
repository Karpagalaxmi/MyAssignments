package week3Day1Assgmnts;

public class StudentsMthdOverloading
{
	/*Method overload Assignment
	  Class: Students
      Methods: getStudentInfo()

	Description: 
	Create multiple getStudentInfo() method by passing id argument alone, by id & name, by email & phoneNumber

*/
	public void getStudentInfo(int id) {
		System.out.println("\nInside Method : getStudentInfo(id)");
		System.out.println("ID : "+ id);
	}
	
	public void getStudentInfo(int id,String name) {
		System.out.println("\nInside Method : getStudentInfo(id & name)");
		System.out.println("ID : "+ id);
		System.out.println("name: "+ name);
	}
	public void getStudentInfo(String email,String phoneNumber) {
		System.out.println("\nInside Method : getStudentInfo(email & phonenumber)");
		System.out.println("Email : "+ email);
		System.out.println("Phone Number: "+ phoneNumber);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StudentsMthdOverloading smol = new StudentsMthdOverloading();
		smol.getStudentInfo(123);
		smol.getStudentInfo(154, "Karpagalaxmi");
		smol.getStudentInfo("karpagalaxmi@gmail.com", "9876543210");

	}

}
