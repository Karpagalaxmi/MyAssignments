package week4Day2Assgnmts;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle_SalesForce {
	/*
	Window handles Assignment
	=========================
	Salesforce Customer service:
	1.Launch the browser
	2.Load the url as " https://login.salesforce.com/ "
	3.Enter the username as "hari.radhakrishnan@qeagle.com"
	4. Enter the password as " Testleaf$321 "
	5.click on the login button
	6.click on the learn more option in the Mobile publisher
	7.Switch to the next window using Windowhandles.
	8.click on the confirm button in the redirecting page
	9.Get the title
	10.Get back to the parent window
	11.close the browser
	*/
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$1234");		
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
		//Switch to the next window using Windowhandles.
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allLinks = new ArrayList<String>(windowHandles);
		driver.switchTo().window(allLinks.get(1));
				
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		String title = driver.getTitle();
		System.out.println("Title : "+ title);
		
		//Get back to the parent window
		driver.switchTo().window(allLinks.get(0));
		Thread.sleep(3000);
		
		//close the browser
		driver.quit();
		
	}

}
