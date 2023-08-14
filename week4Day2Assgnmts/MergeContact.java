package week4Day2Assgnmts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContact {
	/*Pseudo Code
	 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
	 * 2. Enter UserName and Password Using Id Locator
	 * 3. Click on Login Button using Class Locator
	 * 4. Click on CRM/SFA Link
	 * 5. Click on contacts Button
	 * 6. Click on Merge Contacts using Xpath Locator
	 * 7. Click on Widget of From Contact
	 * 8. Click on First Resulting Contact
	 * 9. Click on Widget of To Contact
	 * 10. Click on Second Resulting Contact
	 * 11. Click on Merge button using Xpath Locator
	 * 12. Accept the Alert
	 * 13. Verify the title of the page
	 */

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
	
		driver.findElement(By.linkText("CRM/SFA")).click();				
		//Click Contacts
		driver.findElement(By.linkText("Contacts")).click();
	
		//Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		//Click on Widget of From Contact
		driver.findElement(By.xpath("//a[contains(@href,'LookupContacts')]")).click();
		
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allLinks = new ArrayList<String>(windowHandles);
		driver.switchTo().window(allLinks.get(1));
				
		//Find 1st resulting contact		
		 driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Karpagalaxmi");
		 driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		
		 Thread.sleep(3000);  // avoids StaleElementException
		//Get the text of the captured first resulting contact
		String text = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		System.out.println("First From Contact ID: "+text);
				
		//click the first resulting contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)")).click();
		
		//Set values in From text box	
		//driver.findElement(By.id("widget_ComboBox_partyIdFrom")).sendKeys(text);

		//	Come back to parent window
		driver.switchTo().window(allLinks.get(0));	
		
		//Click on Widget of To Contact		
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> towindowHandles = driver.getWindowHandles();
		List<String> toallLinks = new ArrayList<String>(towindowHandles);
		driver.switchTo().window(toallLinks.get(1));
		
		//Find 1st resulting contact		
		 driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Karpagam");
		 driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		 
		 Thread.sleep(3000);  // avoids StaleElementException
		//Find 2nd resulting contact
		String path1 = "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]";
		WebElement findElement1 = driver.findElement(By.xpath(path1));
						
		//Get the text of the captured 2nd resulting contact
		String txt = findElement1.getText();
		System.out.println("Second To Contact ID: "+txt);
						
		//click the second resulting contact
		driver.findElement(By.xpath(path1)).click();
		
		//	Come back to parent window
		driver.switchTo().window(allLinks.get(0));	
								
		//Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
				
		//Accept the Alert		
		Alert alert = driver.switchTo().alert();		
		//String msg = alert.getText();
		//System.out.println(msg);
		Thread.sleep(3000);
		alert.accept();
		
		//Verify the title of the page
		String title = driver.getTitle();
		System.out.println("Title : "+title);
		if (title.equals("View Contact | opentaps CRM"))
			System.out.println("Title Verified and Contacts Merged");
		else
			System.out.println("Title is NOT Verified");	
		
		driver.quit();
		
	}

}
