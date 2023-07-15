package week1.day1;

public class Mobile {

	public void makeCall() {
		String mobileModel="POCO X4 Pro 5G";
		float mobileWeight=205;
		System.out.println("Mobile model: "+mobileModel);
		System.out.println("Mobile weight: "+mobileWeight+" grams");		
	}
	public void sendMsg() {
		boolean isFullCharged = true;
		int mobileCost = 16000;
		System.out.println("Fully Charged: "+isFullCharged);
		System.out.println("Mobile Cost: "+mobileCost);
	}
	
	public static void main(String[] args) {
		
		Mobile obj = new Mobile();
		obj.makeCall();
		obj.sendMsg();
		
		System.out.println("This is my mobile");

	}

}
