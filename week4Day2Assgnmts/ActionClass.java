package week4Day2Assgnmts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
	Assignment Based on Action Class
	================================	
	https://jqueryui.com/draggable
	https://jqueryui.com/droppable
	https://jqueryui.com/resizable
	https://jqueryui.com/selectable
 */
public class ActionClass {
	public static ChromeDriver driver;
	public static Actions opt;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//https://jqueryui.com/draggable
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/draggable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		WebElement ddby = driver.findElement(By.xpath("//div[@id='draggable']"));
		opt = new Actions(driver);
		opt.dragAndDropBy(ddby, 105, 100).perform();
		driver.switchTo().parentFrame();
		Thread.sleep(3000);
		driver.close();
		
		//https://jqueryui.com/droppable
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Thread.sleep(3000);
		driver.switchTo().frame(0);	
		WebElement src = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement tgt = driver.findElement(By.xpath("//div[@id='droppable']"));	
		Thread.sleep(3000);
		opt = new Actions(driver);
		opt.dragAndDrop(src, tgt).perform();		
		driver.switchTo().parentFrame();	
		Thread.sleep(3000);
		driver.close();
		
		
		//https://jqueryui.com/resizable
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Thread.sleep(3000);		
		driver.switchTo().frame(0);	
		WebElement resize = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		opt = new Actions(driver);
		opt.moveToElement(resize); // mouse hover to the webelement
		opt.clickAndHold(resize).moveByOffset(100, 50).perform(); // resize
		driver.switchTo().parentFrame();	
		Thread.sleep(3000);
		driver.close();
		
		
		//https://jqueryui.com/selectable
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Thread.sleep(3000);		
		driver.switchTo().frame(0);			
		WebElement index1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement index2 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement index3 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		WebElement index4 = driver.findElement(By.xpath("//li[text()='Item 6']"));
		opt = new Actions(driver);
		Thread.sleep(3000);
		opt.keyDown(Keys.CONTROL).click(index1).click(index2).click(index3).click(index4).perform();
		Thread.sleep(3000);
		driver.switchTo().parentFrame();	
		Thread.sleep(3000);
		driver.close();		
		
	}

}
