package week2.day1.day1assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

/*        Assignment 1:Create Lead
 1. Launch URL "http://leaftaps.com/opentaps/control/login"
 2. Enter UserName and Password Using Id Locator
 3. Click on Login Button using Class Locator
 4. Click on CRM/SFA Link
 5. Click on Leads Button
 6. Click on Create Lead 
 7. Enter CompanyName Field Using id Locator
 8. Enter FirstName Field Using id Locator
 9. Enter LastName Field Using id Locator
 10. Enter FirstName(Local) Field Using id Locator
 11. Enter Department Field Using any Locator of Your Choice
 12. Enter Description Field Using any Locator of your choice 
 13. Enter your email in the E-mail address Field using the locator of your choice
 14. Select State/Province as NewYork Using Visible Text
 15. Click on Create Button */
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
	
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");		
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Karpagalaxmi");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Raj");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Karpagam");
				
		driver.findElement(By.name("departmentName")).sendKeys("Testing");
		driver.findElement(By.name("description")).sendKeys("Create a New Lead");
		
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("karpagalaxmi@gmail.com");
		
		//driver.findElement(By.name("primaryEmail")).sendKeys("karpagalaxmi@gmail.com");
		
		String name = "createLeadForm_generalStateProvinceGeoId";;
		WebElement drop = driver.findElement(By.id(name));
		Select op = new Select(drop);
		op.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
			
		
	}

}
