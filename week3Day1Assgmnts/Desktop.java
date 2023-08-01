package week3Day1Assgmnts;

/*Package   :org.system
 Class        :Computer
 Methods   :computerModel()

 Class        :Desktop
 Methods   :desktopSize()

Description:
create above 2 class and call all your class methods into the Desktop using single inheritance.
 */

class Computer{
	
	public void computerModel() {
		System.out.println("Computer Model : Dell");
	}
}

public class Desktop extends Computer{
	
	public void desktopSize() {
		System.out.println("Desktop Size: 15 inches");
		
	}
		
	public static void main(String[] args) {
		Desktop dp = new Desktop();
		dp.computerModel();
		dp.desktopSize();		
	}
}
