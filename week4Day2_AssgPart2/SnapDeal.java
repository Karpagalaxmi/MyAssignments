package week4Day2_AssgPart2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

/*
	 SnapDeal Assignment
	=========================
	1. Launch https://www.snapdeal.com/
	2. Go to Mens Fashion
	3. Go to Sports Shoes
	4. Get the count of the sports shoes
	5. Click Training shoes
	6. Sort by Low to High
	7. Check if the items displayed are sorted correctly
	8.Select the price range (900-1200)
	9.Filter with color Navy 
	10 verify the all applied filters 
	11. Mouse Hover on first resulting Training shoes
	12. click QuickView button
	13. Print the cost and the discount percentage
	14. Take the snapshot of the shoes.
	15. Close the current window
	16. Close the main window
 */
public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		//1. Launch https://www.snapdeal.com/
		ChromeDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com");
		
		Thread.sleep(3000);
		//2. Go to Mens Fashion
		WebElement moveToElt = driver.findElement(By.xpath("//span[@class='catText']"));
		Actions obj = new Actions(driver);
		obj.moveToElement(moveToElt).perform();


		//3. Go to Sports Shoes
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		
		//4. Get the count of the sports shoes
		String text = driver.findElement(By.xpath("(//div[@class='child-cat-count '])[2]")).getText();
		System.out.println("Number of Sports Shoes : "+text);
		
		//5. Click Training shoes
		driver.findElement(By.xpath("//a[contains(@href,'training-shoes')]")).click();		
		Thread.sleep(3000);
		
		//6. Sort by Low to High
		//click drop down
		driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();	
		
		// select Price Low To High
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		
		Thread.sleep(3000);
		
		//7. Check if the items displayed are sorted correctly
		String price ="";
		List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
	
		List<Integer> pr = new ArrayList<Integer>();
		List<Integer> pr1 = new ArrayList<Integer>();
		
		System.out.println("No. of items: "+priceList.size());
		
		for(int i =0;i < priceList.size(); i++) {
			price = priceList.get(i).getText();
			String replace = price.replace("Rs. ", "");
			int intpr = 0;
			if(!replace.isEmpty()) 
				intpr=Integer.parseInt(replace);
			
			pr.add(intpr);
			pr1.add(intpr);		
		}
		
		Collections.sort(pr1);
		
		int flag = 0;
		for(int j =0;j<priceList.size();j++) {
			if(!(pr.get(j) == (pr1.get(j))))
			{
			 flag = 1;
			 break;
			}
		}
		
		if(flag == 1) System.out.println("Items displayed are NOT sorted correctly");
		else  System.out.println("Items displayed are sorted correctly");
		
		
		//8. Select the price range (900-1200)
		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
		driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("600");
		driver.findElement(By.xpath("//input[@name='toVal']")).clear();
		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("999");
		driver.findElement(By.xpath("//div[contains(@class,'btn-theme-secondary')]")).click();
		
		
		//9. Filter with color Navy
		
		//driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		//Err: StaleElementReferenceException: stale element reference: stale element not found
		//Navy is not clickable; so use javascript click
		WebElement navy = driver.findElement(By.xpath("//label[@for='Color_s-Navy']"));
		driver.executeScript("arguments[0].click()", navy);
		
		//10. verify the all applied filters 
		String priceFilter = driver.findElement(By.xpath("//a[@data-key='Price|Price']")).getText();
		String colorFilter = driver.findElement(By.xpath("//a[@data-key='Color_s|Color']")).getText();
		
		if((priceFilter.equals("Rs. 600 - Rs. 999")) && (colorFilter.equals("Navy"))) 
			System.out.println("Filters are applied Correctly");
		else
			System.out.println("Filters are NOT applied Correctly");
					
		//11. Mouse Hover on first resulting Training shoes
		WebElement moveToElt1 =driver.findElement(By.xpath("//a[@class='dp-widget-link noUdLine hashAdded']"));
		Actions obj1 = new Actions(driver);
		obj1.moveToElement(moveToElt1).perform();
		
		Thread.sleep(3000);
		//12. click QuickView button
		driver.findElement(By.xpath("(//div[@supc='SDL901001171'])[2]")).click();
		
		//13. Print the cost and the discount percentage
		System.out.println("First Resulting Training Shoes");
		System.out.println("Cost : Rs. " +driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText());		
		System.out.println("Dicount Percentage: "+driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText());
		
	
		//14. Take the snapshot of the shoes.		
		File scr = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/SnapDeal.png");
		FileUtils.copyFile(scr, dest);
		
		//15. Close the current window
		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
		
		//16. Close the main window
		driver.quit();	
		
	}

}
