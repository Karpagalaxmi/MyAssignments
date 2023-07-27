package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook {
	/*Assignment:1

	FaceBook:
	================================
	// Step 1: Download and set the path 
	// Step 2: Launch the chromebrowser
	// Step 3: Load the URL https://en-gb.facebook.com/
	// Step 4: Maximise the window
	// Step 5: Add implicit wait
	// Step 6: Click on Create New Account button
	// Step 7: Enter the first name
	// Step 8: Enter the last name
	// Step 9: Enter the mobile number
	// Step 10: Enterthe password
	// Step 11: Handle all the three drop downs
	// Step 12: Select the radio button "Female" 
	            ( A normal click will do for this step)  */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		driver.findElement(By.name("firstname")).sendKeys("SampleFirstName");
		driver.findElement(By.name("lastname")).sendKeys("SampleSurname");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9876543210");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("PASWRD");
		
			
		WebElement day = driver.findElement(By.id("day"));
		Select opd = new Select(day);
		opd.selectByVisibleText("7");
				
		WebElement mth = driver.findElement(By.id("month"));
		Select opm = new Select(mth);
		opm.selectByVisibleText("May");
		
		WebElement yr = driver.findElement(By.id("year"));
		Select opy = new Select(yr);
		opy.selectByVisibleText("1992");
		
		driver.findElement(By.xpath("//input[@value='1']")).click();
		
		}

}
