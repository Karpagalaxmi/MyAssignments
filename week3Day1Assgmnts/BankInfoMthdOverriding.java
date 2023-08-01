package week3Day1Assgmnts;

class AxisBank
{	
	void deposit() {
		System.out.println("Axis Bank - Max. Deposit Amount allowed per day in your account : 25 lakhs");
	}
}

public class BankInfoMthdOverriding extends AxisBank 
{
	
	/*Method Override Assignment:
		Class     :BankInfo
	    Methods :saving(),fixed(),deposit()
	     Class     :AxisBank
	     Methods :deposit()
	Description:
	You have to override the method deposit in AxisBank.
*/

	public void saving()
	{
		System.out.println("Savings Account");
	}
	
	public void fixed()
	{
		 System.out.println("Fixed Deposit Account");
	}
	
	public void deposit()
	{
		 System.out.println("BankInfo - Max. Deposit Amount per day in your account : 30 lakhs");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankInfoMthdOverriding bimo = new BankInfoMthdOverriding();
		bimo.saving();
		bimo.fixed();
		bimo.deposit();		
	}

}
