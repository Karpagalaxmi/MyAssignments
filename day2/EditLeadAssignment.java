package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLeadAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/*http://leaftaps.com/opentaps/control/main
		
		* 1	Launch the browser
		* 2	Enter the username
		* 3	Enter the password
		* 4	Click Login
		* 5	Click crm/sfa link
		* 6	Click Leads link
		* 7	Click Find leads
		* 8	Enter first name
		* 9	Click Find leads button
		* 10 Click on first resulting lead
		* 11 Verify title of the page
		* 12 Click Edit
		* 13 Change the company name
		* 14 Click Update
		* 15 Confirm the changed name appears
		* 16 Close the browser (Do not log out)
*/
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
	
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		
		//Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
				
		//enter first name
		WebElement findElement = driver.findElement(By.xpath("(//input[@name='firstName'])[3]"));
		findElement.sendKeys("Karpagalaxmi");
		//click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(1000);
		//click the first resulting lead
		driver.findElement(By.xpath("//a[text()='11741']")).click();
	
		/*
		 //Find 1st resulting lead
		String path = "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]";
		WebElement findElement1 = driver.findElement(By.xpath(path));
		
		//Get the name of the captured first resulting lead
		String text = findElement1.getText();
		System.out.println("Captured Lead ID: "+text);
		*/
				
		String title = driver.getTitle();
		System.out.println("Title : " + title);
		
		if(title.equals("View Lead | opentaps CRM"))
			System.out.println("Title Verified");
		else
			System.out.println("Title not Verified");
		
		
		driver.findElement(By.linkText("Edit")).click();		
		
		WebElement findElement2 = driver.findElement(By.id("updateLeadForm_companyName"));
		Thread.sleep(5000);
		findElement2.clear();
		
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Testleaf Automation");
		driver.findElement(By.name("submitButton")).click();
		
		
		WebElement findElement3 = driver.findElement(By.id("viewLead_companyName_sp"));
	 String company = findElement3.getText();
	 System.out.println(company);
		if(company.contains("Testleaf Automation"))
			System.out.println("Company Name Changed");
		else
			System.out.println("Company Name not changed");
		 
		Thread.sleep(5000);		
		//	Close the browser (Do not log out)
		//driver.close();
		



	}

}
