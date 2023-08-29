package week4Day2_AssgPart2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonScreenShot {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		/*Amazon Assignment
		=====================
		1.Load the URL https://www.amazon.in/
		2.search as oneplus 9 pro 
		3.Get the price of the first product
		4. Print the number of customer ratings for the first displayed product
		5. Click the first text link of the first image
		6. Take a screen shot of the product displayed
		7. Click 'Add to Cart' button
		8. Get the cart subtotal and verify if it is correct.
		9.close the browser*/
		
		//1.Load the URL https://www.amazon.in/
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2.search as oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");		
		driver.findElement(By.xpath("//div[text()='oneplus 9 pro']")).click();
		
		//3.Get the price of the first product
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[2]")).getText();
		System.out.println("Price of the first product : "+price);
		
		Thread.sleep(2000);
		//4. Print the number of customer ratings for the first displayed product
		String rating = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[2]")).getText();
		System.out.println("Number of Customer Ratings of the first product : "+rating);

		//5. Click the first text link of the first image
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]")).click();
		
		//6. Take a screen shot of the product displayed	
		File scr = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/amazon_oneplus9pro.png");
		FileUtils.copyFile(scr,dest);
		
		//7. Click 'Add to Cart' button
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allLinks = new ArrayList<String>(windowHandles);
		driver.switchTo().window(allLinks.get(1));
			
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
					
		Thread.sleep(3000);		
		
		//8. Get the cart subtotal and verify if it is correct.		
		String cartTotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-total-string']/following::span/span")).getText();
			
		String cartSubTotal = cartTotal.substring(1, 7);
		System.out.println("Cart SubTotal : "+cartSubTotal);
		if(price.equals(cartSubTotal))
			System.out.println("Cart Subtotal Verified");
		else
			System.out.println("Cart Subtotal NOT Verified");
		
		Thread.sleep(3000);		
		
		//9.close the browser
		driver.quit();
				
	}

}
