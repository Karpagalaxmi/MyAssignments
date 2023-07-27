package week2.day1.day1assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	/*Assignment 3:CreateAccount
	   1. Launch URL "http://leaftaps.com/opentaps/control/login"	   
	   2. Enter UserName and Password Using Id Locator	   
	   3. Click on Login Button using Class Locator	   
	   4. Click on CRM/SFA Link	   
	   5. Click on Accounts Button	   
	   6. Click on Create Account	    
	   7. Enter AccountName Field Using Xpath Locator value as Debit Limited Account	   
	   8. Enter DEscriptiion as "Selenium Automation Tester"	   
	   9. Enter LocalName Field Using Xpath Locator	   
	   10. Enter SiteName Field Using Xpath Locator	   
	   11. Enter value for AnnualRevenue Field using Xpath Locator but class as Attribute	   
	   12. Select Industry as ComputerSoftware	   
	   13. Select OwnerShip as S-Corporation using SelectByVisibletext	   
	   14. Select Source as Employee using SelectByValue	   
	   15. Select Marketing Campaign as eCommerce Site Internal Campaign using SelectbyIndex	   
	   16. Select State/Province as Texas using SelectByValue 	   
	   17. Click on Create Account using Xpath Locator */
	   
	   public static void main(String[] args) {
		   
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://leaftaps.com/opentaps/control/login");
			
			driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
		
			driver.findElement(By.linkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Accounts")).click();
			driver.findElement(By.linkText("Create Account")).click();
	
			/* 7. Enter AccountName Field Using Xpath Locator value as Debit Limited Account	   
			   8. Enter DEscriptiion as "Selenium Automation Tester"	   
			   9. Enter LocalName Field Using Xpath Locator	   
			   10. Enter SiteName Field Using Xpath Locator	   
			   11. Enter value for AnnualRevenue Field using Xpath Locator but class as Attribute */  
			 			
			driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys("Debit Limited Account Create AC");
	
			//driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
			//id contains number : ext-gen594
			
			driver.findElement(By.xpath("//textarea[contains(@name,'desc')]")).sendKeys("Selenium Automation Tester");
			
			driver.findElement(By.xpath("//input[@id='groupNameLocal']")).sendKeys("Karpagalaxmi");
			driver.findElement(By.xpath("//input[@id='officeSiteName']")).sendKeys("Nanganallur");
			driver.findElement(By.xpath("(//input[@class='inputBox'])[5]")).sendKeys("250000000");
			
			/*   12. Select Industry as ComputerSoftware	   
			   13. Select OwnerShip as S-Corporation using SelectByVisibletext	   
			   14. Select Source as Employee using SelectByValue	   
			   15. Select Marketing Campaign as eCommerce Site Internal Campaign using SelectbyIndex	   
			   16. Select State/Province as Texas using SelectByValue 	   
			   17. Click on Create Account using Xpath Locator */
				
			WebElement industry = driver.findElement(By.name("industryEnumId"));
			Select opi = new Select(industry);
			opi.selectByVisibleText("Computer Software");
			
			WebElement ownership = driver.findElement(By.name("ownershipEnumId"));
			Select opo = new Select(ownership);
			opo.selectByVisibleText("S-Corporation");
			
			WebElement source = driver.findElement(By.id("dataSourceId"));
			Select ops = new Select(source);
			ops.selectByValue("LEAD_EMPLOYEE");
		
			WebElement market = driver.findElement(By.id("marketingCampaignId"));
			Select opm = new Select(market);
			opm.selectByIndex(6);			;
			
			WebElement state = driver.findElement(By.id("generalStateProvinceGeoId"));
			Select opst = new Select(state);
			opst.selectByValue("TX");
			
			driver.findElement(By.xpath("(//input[@class='smallSubmit'])")).click();
	   }
}
