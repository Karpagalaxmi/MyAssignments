package week2.day1.day1assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LeafgroundDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/*
		Assignment 4:
		DropDown in Leaf Ground:
		https://www.leafground.com/select.xhtml 
		 */
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		
		WebElement findElement = driver.findElement(By.className("ui-selectonemenu"));
		Select tool = new Select(findElement);
		tool.selectByVisibleText("Selenium");
		
		 driver.findElement(By.xpath("//label[text()='Select Country']")).click();		
		 driver.findElement(By.xpath("//li[text()='India']")).click();
		
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//label[text()='Select City']")).click();		
		 driver.findElement(By.xpath("//li[text()='Chennai']")).click();
		 
		 Thread.sleep(1000);
		// Click Choose course
		 //driver.findElement(By.xpath("//li[@class='ui-autocomplete-input-token']/input")).click();
		// Thread.sleep(1000);
		 
		 //Click dropdown in course
		 driver.findElement(By.xpath("(//span[contains(@class,'ui-icon-triangle-1-s')])[3]")).click();
		 Thread.sleep(1000);
		 
		 driver.findElement(By.xpath("//li[text()='Selenium WebDriver']")).click();
		 Thread.sleep(1000);
		 
		 driver.findElement(By.xpath("//label[text()='Select Language']")).click();		
		 driver.findElement(By.xpath("//li[text()='English']")).click();
		 Thread.sleep(1000);
		 
		 driver.findElement(By.xpath("//label[text()='Select Values']")).click();		
		 driver.findElement(By.xpath("//li[text()='Two']")).click();
		 
	}

}
