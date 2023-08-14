package week4Day2Assgnmts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LeafGround_DragAndDrop {

	/*
	 * 	Drag Assignment
		=====================
		https://leafground.com/drag.xhtml
	 */
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/drag.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Thread.sleep(3000);
		WebElement ddby = driver.findElement(By.id("form:conpnl_header"));
		Actions opt = new Actions(driver);
		opt.dragAndDropBy(ddby, 105, 10).perform();
		
		Thread.sleep(3000);
		WebElement src = driver.findElement(By.id("form:drag_content"));
		WebElement tgt = driver.findElement(By.id("form:drop_header"));
		
		opt.dragAndDrop(src, tgt).perform();
		
	}

}
