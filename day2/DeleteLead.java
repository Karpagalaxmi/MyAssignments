package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*http://leaftaps.com/opentaps/control/main
		 
		Delete Lead:
		1	Launch the browser
		2	Enter the username
		3	Enter the password
		4	Click Login
		5	Click crm/sfa link
		6	Click Leads link
		7	Click Find leads
		8	Click on Phone
		9	Enter phone number
		10	Click find leads button
		11	Capture lead ID of First Resulting lead
		12	Click First Resulting lead
		13	Click Delete
		14	Click Find leads
		15	Enter captured lead ID
		16	Click find leads button
		17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		18	Close the browser (Do not log out)
*/
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
	
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
	
		//	Enter phone number
		driver.findElement(By.linkText("Phone")).click();		
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9876543210");
		Thread.sleep(1000);		
		
		//click find leads button
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		Thread.sleep(3000);
		
		//Find 1st resulting lead
		String path = "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]";
		WebElement findElement = driver.findElement(By.xpath(path));
		
		//Get the name of the captured first resulting lead
		String text = findElement.getText();
		System.out.println("Captured Lead ID: "+text);
		
		//click the first resulting lead
		driver.findElement(By.xpath(path)).click();
		
		//click Delete button
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		
		//Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Enter captured lead ID
		driver.findElement(By.xpath("//input [@name='id']")).sendKeys(text);
		
		//click find leads button
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		
		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		Thread.sleep(5000);
		String msg = driver.findElement(By.xpath("//div[@class = 'x-paging-info']")).getText();
		if (msg.equals("No records to display"))
			System.out.println("No records to display" + "\nLead ID : "+text +" is deleted sucessfully");
		else
			System.out.println("Lead ID : "+text +" is not deleted");
		
		//	Close the browser (Do not log out)
		// driver.close();
		
		
		
	}

}
