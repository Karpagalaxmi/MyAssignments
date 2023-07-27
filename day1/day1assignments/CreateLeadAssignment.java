package week2.day1.day1assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLeadAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/*Assignment 1:Create Lead
		  1. Launch URL "http://leaftaps.com/opentaps/control/login"
	      2. Enter UserName and Password Using Id Locator
		   3. Click on Login Button using Class Locator
		   4. Click on CRM/SFA Link
		   5. Click on Leads Button
		   6. Click on create Lead Button
		   7. Enter CompanyName using id Locator
		   8. Enter FirstName using id Locator
		   9. Enter LastName using id Locator
		   10. Select value as Employee in Source Using SelectbyVisible text
		   11. Select value as Pay Per Click Advertising in MarketingCampaignId Using SelectbyValue
		   13. Select value as Corporation in OwnerShip field Using SelectbyIndex
		   14. Select value as India in Country Field Using SelectbyVisibletext
		   15. Click on create Lead Button Using name Locator
		   16. Get the Title of the resulting Page */

	
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
		
		WebElement source = driver.findElement(By.name("dataSourceId"));
		Select ops = new Select(source);
		ops.selectByVisibleText("Employee");
		
		WebElement market = driver.findElement(By.name("marketingCampaignId"));
		Select opm = new Select(market);
		opm.selectByValue("9001");
				
		WebElement ownership = driver.findElement(By.name("ownershipEnumId"));
		Select opo = new Select(ownership);
		opo.selectByIndex(5);
		
		WebElement country = driver.findElement(By.name("generalCountryGeoId"));
		Select opc = new Select(country);
		opc.selectByVisibleText("India");
		Thread.sleep(5000);
		
		driver.findElement(By.name("submitButton")).click();
		
		String title = driver.getTitle();
		System.out.println("Title : " + title);
	}

}
