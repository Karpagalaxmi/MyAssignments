package week4Day2_AssgPart2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

/*Myntra Assignment 
======================
1) Open https://www.myntra.com/
2) Mouse hover on MeN 
3) Click Jackets 
4) Find the total count of item 
5) Validate the sum of categories count matches
6) Check jackets
7) Click + More option under BRAND
8) Type Duke and click checkbox
9) Close the pop-up x
10) Confirm all the Coats are of brand Duke
    Hint : use List 
11) Sort by Better Discount
12) Find the price of first displayed item
Click on the first product
13) Take a screen shot
14) Click on WishList Now
15) Close Browser */


public class Myntra {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
				
		//1) Open https://www.myntra.com/
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2) Mouse hover on MeN		
		WebElement elt = driver.findElement(By.xpath("//a[text()='Men']"));
		Actions obj = new Actions(driver);
		obj.moveToElement(elt).perform();
		
		//3) Click Jackets		
		driver.findElement(By.xpath("//a[text()='Jackets']")).click();
		
		//4) Find the total count of item
		String text = driver.findElement(By.xpath("//h1[text()='Jackets for Men']/following-sibling::span")).getText();
		text = text.replaceAll("[!a-zA-Z]","");
		text = text.replaceAll("-", "");
		text = text.trim(); // remove whitespace 
		System.out.println("Total count of Jackets: "+text);
		
		//5) Validate the sum of categories count matches
		String jacket = driver.findElement(By.xpath("//span[@class='categories-num']")).getText();
		String rainjacket = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		jacket = jacket.replaceAll("[!a-zA-Z]","");
		jacket = jacket.replace("(", "");
		jacket = jacket.replace(")", "");
		jacket = jacket.trim(); 
		System.out.println("Jackets count: "+jacket);
		rainjacket = rainjacket.replaceAll("[!a-zA-Z]","");
		rainjacket = rainjacket.replace("(", "");
		rainjacket = rainjacket.replace(")", "");
		rainjacket = rainjacket.trim(); 
		System.out.println("Rain Jackets count: "+rainjacket);
		
		int total = Integer.parseInt(text);
		int jkt = Integer.parseInt(jacket);
		int rjkt = Integer.parseInt(rainjacket);
		
		if(total == (jkt+rjkt))
			System.out.println("Sum of Categories count Matches with Jackets Count");
		else
			System.out.println("Sum of Categories count does not Match with Jackets Count");
			
		
		//6) Check jackets
		driver.findElement(By.xpath("//div[@class='common-checkboxIndicator']")).click();
		
		Thread.sleep(3000);
		//7) Click + More option under BRAND
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		
		//8) Type Duke and click checkbox
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke");
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']")).click();
		
		//9) Close the pop-up x
		//driver.findElement(By.xpath("//span[contains(@class,'sprites-remove')]")).click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
	
		//10) Confirm all the Coats are of brand Duke 	    Hint : use List 
		List<WebElement> checkBrand = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		int size = checkBrand.size();
	   //  System.out.println("Size of List : "+checkBrand.size());
		Set<String> brandCount = new TreeSet<String>();
		for(int i =0;i < size;i++) {
		   String brandName = checkBrand.get(i).getText();
		   brandCount.add(brandName);
		}
		//System.out.println("Size of Set : "+brandCount.size());
		if(brandCount.size() > 1)
			System.out.println("All the Coats are NOT of brand Duke");
		else
			System.out.println("All the Coats are of brand Duke");
			 
		//11) Sort by Better Discount
		/*WebElement sortMenu = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		Actions act = new Actions(driver);
		act.moveToElement(sortMenu).perform();	*/
		//driver.findElement(By.xpath("//div[@class='sort-sortBy']")).click();
		driver.findElement(By.className("sort-sortBy")).click();
		driver.findElement(By.xpath("//ul[@class='sort-list']//li[4]//label")).click();
	   
		
	    //12) Find the price of first displayed item
	    String betterPrice = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
		System.out.println("Price of the First product (Better Discount) : " + betterPrice);
		// Click on the first product
		driver.findElement(By.xpath("//h4[@class='product-product']")).click();
		
		//13) Take a screen shot
		File scr = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/Myntra.png");
		FileUtils.copyFile(scr,dest);

		//Child Window Hanlding
		Set<String> winHands = driver.getWindowHandles();
		List<String> links = new ArrayList<String>(winHands);
		driver.switchTo().window(links.get(1));
		
		//14) Click on WishList Now
		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
		Thread.sleep(3000);
		
	    //15) Close Browser		
		driver.quit();
	}

}
