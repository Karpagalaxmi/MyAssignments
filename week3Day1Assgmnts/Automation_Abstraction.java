package week3Day1Assgmnts;
/*	Abstraction Assignment
	======================
	Interface :Language
	     Methods   :Java()
	     Interface :TestTool
	     Methods   :Selenium()
	     AbstractClass :MultipleLangauge
	     Methods   :python() and un implemented method as ruby()
	  Execution class: Automation 
	Implement all the methods of interface and abstract class in Automation class
*/

public class Automation_Abstraction extends MultipleLanguage implements Language, TestTool
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Automation_Abstraction aa = new Automation_Abstraction();
		aa.Java();
		aa.Selenium();
		aa.ruby();
		aa.python();
	}

	public void Java() {
		// TODO Auto-generated method stub
		System.out.println("Method Java in Interface - Lanuguage");
	}

	public void Selenium() {
		// TODO Auto-generated method stub
		System.out.println("Method Selenium in Inteface - TestTool");
	}
	
	@Override
	public void ruby() {
		// TODO Auto-generated method stub
		System.out.println("Unimplemented method Ruby in Abstract Class - Multiple Language");
	}

	

}
